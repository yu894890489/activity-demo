$(document).ready(function() {
	initTable(); 
	initdykRateTable();
	formValidator();
	dateload();
	//modal绑定事件
	$('#addModal').on('hidden.bs.modal', function(){
		$("#addForm")[0].reset();
		$("#addForm").data('bootstrapValidator').destroy();
		$("#addForm").data('bootstrapValidator', null);
		formValidator();
		document.getElementById("field").disabled=false;
		document.getElementById("btn_save").style.display="";
	});
	//去掉modal上的验证缓存
	$('#addModal').on('hide.bs.modal', function () {
		$("#addForm").data('bootstrapValidator').resetForm();
	});
	ajaxRelaCorps("txt_productId","productId");
	//financingType();,"productId_js"
	numFormat();
} );

window.operateEvents = {
		'click .detail': function (e, value, row, index) {
			detailFun(row,0);
			},
		'click .mod': function (e, value, row, index) {
				modFun(row,2);
		    },
	    'click .remove': function (e, value, row, index) {
	    	bootbox.confirm("确定删除此条记录?", function(result) {  
	            if (result) {  
	            	var options = {
	    					url : '../../im/delete',
	    					data : '{"recUid":"'+row.recUid+'"}',
	    					callBackFun : function(data) {
	    						if(data.result==0){
	    							searchFun();
	    						}else{
	    							bootbox.alert(data.resultNote);
	    							return false;
	    						}
	    					},
	    					errorCallback:function(data){
	    						bootbox.alert("error");
	    					}
	    			};
	    			CloudUtils.ajax(options);
	            } 
	    	 });
	    }
	};

function initTable() { 
	$('#imList').bootstrapTable('destroy');  
	$("#imList").bootstrapTable({  
         method: "post", 
         url: "../../im/list", 
         striped: false,  //表格显示条纹  
         pagination: true, //启动分页  
         pageSize: 5,  //每页显示的记录数  
         pageNumber:1, //当前第几页  
         pageList: [5, 10, 15, 20, 25],  //记录数可选列表  
         search: false,  //是否启用查询  
         showColumns: false,  //显示下拉框勾选要显示的列  
         showRefresh: false,  //显示刷新按钮  
         sidePagination: "server", //表示服务端请求  
         //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
         //设置为limit可以获取limit, offset, search, sort, order  
         queryParamsType : "undefined",   
         queryParams: function queryParams(params) {   //设置查询参数  
           var data = CloudUtils.convertStringJson('searchForm');
           var jsonData = eval("(" + data + ")");
           if(jsonData.txt_productId ==""){
        	   jsonData.txt_productId = null;
           }
           var param = {    
               pageNumber: params.pageNumber,    
               pageSize: params.pageSize,
               productId: jsonData.txt_productId
           };    
           return JSON.stringify(param);                   
         },  
         responseHandler:function responseHandler(res) {
        	 if (res.result==0) {
	        	 return {
	        		 "rows": res.dataList,
	        		 "total": res.records
	        	 };
        	 } else {
        		 bootbox.alert(res.resultNote);
        		 return {
			        	 "rows": [],
			        	 "total": 0
			        	 };
        	 }
         },
         columns: [{
 	        field: 'recUid',
 	        title: 'Item ID',
 	        align: 'center',
            valign: 'middle',
            visible: false
 	    },{
 	        field: 'productId',
 	        title: '产品Id',
 	        align: 'center',
            valign: 'middle'
 	    }, {
 	        field: 'productName',
 	        title: '产品名称',
 	        align: 'center',
            valign: 'middle'
 	    },{
 	        field: 'bett',
 	        title: '扣息方式',
 	        align: 'center',
            valign: 'middle',
            formatter:function(value,row,index){
              	if(value==0){
              		return "按季结息";
              	}else if(value==1){
              		return "按月结息";
              	}else if(value==2){
              		return "到期利随本清";
              	}else if(value==3){
              		return "预收利息，到期结息";
              	}
              } 
 	    }, {
 	        field: 'deduct',
 	        title: '扣费方式',
 	        align: 'center',
            valign: 'middle',
            formatter:function(value,row,index){
              	if(value==0){
              		return "转让应收账款时支付费用";
              	}else if(value==1){
              		return "获得融资款项时支付费用";
              	}
              } 
 	    }, {
 	        field: 'interestRate',
 	        title: '分期超人利率',
 	        align: 'center',
             valign: 'middle',
             formatter:function(value,row,index){
   	 	    	return $.number(value,4);
   		        }
 	    }, {
 	        field: 'costRate',
 	        title: '分期超人费率',
 	        align: 'center',
             valign: 'middle',
             formatter:function(value,row,index){
   	 	    	return $.number(value,4);
   		        }
 	    },{
 	        field: 'receptionDate',
 	        title: '收息日',
 	        align: 'center',
            valign: 'middle'
 	    }, {
 	        field: 'interestRateStandard',
 	        title: '利率标准',
 	        align: 'center',
            valign: 'middle',
            visible: false
 	    }, {
 	        field: 'operation',
 	        title: '操作',
 	        align: 'center',
 	        formatter:function(value,row,index){
	        	var d = '<a class = "fa fa-list-ul detail" style="color:#a9d86e;padding:0px 5px;" title="详情" href="javascript:void(0)"></a>';
 	        	var m = '<a class = "fa fa-edit mod" style="color:#d864fd;padding:0px 5px;" title="编辑" href="javascript:void(0)"></a>';
	 	         var r = '<a class = "fa fa-trash-o remove" style="color:#fa8564;padding:0px 5px;" title="删除" href="javascript:void(0)"></a>';
	 	        return d+' '+m+' '+r;
 	        },
 	        events: 'operateEvents'
 	    }]
       });  
}

function searchFun() {
	initTable();
}

function addFun() {
	$("#btn_blank").removeClass('col-sm-7').addClass('col-sm-4');
	$("#productId").attr("disabled",false);
	$("#addModalLabel").text("添加");
    $('#addModal').modal({backdrop: 'static', keyboard: false});//防止点击空白/ESC 关闭
    $('#isEdit').val(1); //新增1；修改2
}

function detailFun(row,isEdit) {
	modFun(row,isEdit);
    document.getElementById("field").disabled=true;
    document.getElementById("btn_save").style.display="none";
    $("#btn_blank").removeClass('col-sm-4').addClass('col-sm-7');
}

function modFun(row,isEdit) {
	$("#btn_blank").removeClass('col-sm-7').addClass('col-sm-4');
	if(isEdit==0){
		$("#addModalLabel").text("详情");
	}
	if(isEdit==2){
		$("#addModalLabel").text("修改");
	}
	$("#productId").attr("disabled",true);
    $('#addModal').modal();
    $('#isEdit').val(isEdit); //新增1；修改2
    CloudUtils.setForm(row,'addForm');
}

function saveUser() {
 	var modal = $('#addModal');
	var data = CloudUtils.convertStringJson('addForm');
	var data = eval("(" + data + ")");

    data = JSON.stringify(data);
	var isEdit =  $('#isEdit').val(); 
	if(isEdit == 1){//新增1；修改2
		var options = 	{
				url : '../../im/add',
				data : data,
				callBackFun : function(data) {
					bootbox.alert(data.resultNote);
					if(data.result==0){
						searchFun();
					}else{
						return false;
					}
				},
				errorCallback:function(data){
					bootbox.alert("error");
				}
		};
		CloudUtils.ajax(options);
	}else{
		var options = {
				url : '../../im/mod',
				data : data,
				callBackFun : function(data) {
					bootbox.alert(data.resultNote);
					if(data.result==0){
						searchFun();
					}else{
						return false;
					}
				},
				errorCallback:function(data){
					bootbox.alert("error");
				}
		};
		CloudUtils.ajax(options);
	}
	modal.modal("hide");
}



//初始化利率信息表
function initdykRateTable(productId){
	 $('#dykRateList').bootstrapTable('destroy'); 
		$("#dykRateList").bootstrapTable({  
	         method: "post", 
	         url: "../../dykRate/list", 
	         striped: false,  //表格显示条纹  
	         pagination: true, //启动分页  
	         pageSize: 5,  //每页显示的记录数  
	         pageNumber:1, //当前第几页  
	         pageList: [5, 10, 15, 20, 25],  //记录数可选列表  
	         search: false,  //是否启用查询  
	         showColumns: false,  //显示下拉框勾选要显示的列  
	         showRefresh: false,  //显示刷新按钮  
	         sidePagination: "server", //表示服务端请求  
	         //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
	         //设置为limit可以获取limit, offset, search, sort, order  
	         queryParamsType : "undefined",   
	         queryParams: function queryParams(params) {   //设置查询参数  
	            // var data = CloudUtils.convertStringJson('searchForm');
	            // var jsonData = eval("(" + data + ")");
	             var param = {    
		                 pageNumber: params.pageNumber,    
		                 pageSize: params.pageSize,
		                 productId:params.productId
		             }; 
				 
	             return JSON.stringify(param);                   
	           }, 
	         responseHandler:function responseHandler(res) {
	        	 if (res.result==0) {
		        	 return {
		        		 "rows": res.dataList,
		        		 "total": res.records
		        	 };

	        	 } else {
	        		 bootbox.alert(res.resultNote);
	        		 return {
				        	 "rows": [],
				        	 "total": 0
				        	 };
	        	 }
	         },
	         columns: [ {
	 	        field: 'productId',
	 	        title: '股东名称',
	 	        align: 'center',
	            valign: 'middle',
	            visible: false
	 	    }, {
	 	        field: 'productName',
	 	        title: '产品名称',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'rateStandard',
	 	        title: '利率标准',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'dykRate',
	 	        title: '利率',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'operation',
	 	        title: '操作',
	 	        align: 'center',
	            valign: 'middle',
	 	       formatter:function(value,row,index){
	 	        	var r = '<a class = "fa fa-trash-o remove" style="color:#fa8564;padding:0px 5px;" title="删除" data-type="shareInfo" href="javascript:void(0)"></a>';
	 	        	var m = '<a class = "fa fa-edit modify" style="color:#d864fd;padding:0px 5px;" title="编辑" data-type="shareInfo" href="javascript:void(0)"></a>';
	 	            return m +' '+ r;
	 	        },
	 	        events: 'operateEvents'
	 	    }
	 	    ]
	       });  
}



//动态下拉框
function  ajaxRelaCorps(Id1,Id2){
	var relaCorpId = store.get('productId');
	var options = {
			url : '../../product/list',
			data : '{"relaCorpId":"'+relaCorpId+'","isPage": 0}',
			callBackFun : function(data) {
				var control1 = $('#' + Id1);
				var control2 = $('#' + Id2);
				control1.append("<option value=''>全部</option>");
	            $.each(data.dataList, function (index, units) {  
	            	control1.append("<option value="+units.productId+">" + units.productName + "</option>");
	            	control2.append("<option value="+units.productId+">" + units.productName + "</option>");
	            });  
	            $('#txt_productId').selectOrDie({
					placeholder : '产品名称'
				});
			},
			errorCallback:function(data){
				 alert("error");  
			}
	};
	CloudUtils.ajax(options);
}

function financingType(){
	 $('#txt_financingType').selectOrDie({
			placeholder : '融资类型'
		});
}

function dateload(){
	 $('#receptionDate').datetimepicker({
       language: 'zh-CN',
       autoclose: 1,
       todayBtn: true,// 显示今天时间
       pickerPosition: "bottom-left",
       minuteStep: 5,
       format: 'yyyy-mm-dd',
       minView: 'month',　　// 日期时间选择器所能够提供的最精确的时间选择视图。
       initialDate : new Date()
      });
	// $(receptionDate).datetimepicker('setEndDate', new Date());
}
/*
function CompareDate(d1,d2)
{
//将所有的短横线替换为斜杠
return ((new Date(d1.replace(/-/g,"\/"))) > (new Date(d2.replace(/-/g,"\/"))));
}
*/

//form验证规则
function formValidator(){
	$('#addForm').bootstrapValidator({
	      message: 'This value is not valid',
	      feedbackIcons: {
	          valid: 'glyphicon glyphicon-ok',
	          invalid: 'glyphicon glyphicon-remove',
	          validating: 'glyphicon glyphicon-refresh'
	      },
	      fields: {
	    	  financingNote : {
		        	 validators: {
							stringLength: {
			                      min: 1,
			                      max: 2000,
			                      message: '长度为1-2000'
			                  }
						}	        	 
		      },
		      financingInstitutions : {
		        	 validators: {
							stringLength: {
			                      min: 1,
			                      max: 32,
			                      message: '长度为1-32'
			                  }
						}	        	 
		      },
		      interestRateStandard : {
		        	 validators: {
							stringLength: {
			                      min: 1,
			                      max: 200,
			                      message: '字数限制长度为1-200'
			                  }
						}	        	 
		      },
	         interestRate : {
	                validators: {
	      				numeric: {message: '只能输入数字'},
	      				callback: {  
	      					message: '分期超人利率在0~100.0000之间',  
	      						callback: function(value, validator) { 
	      						return parseFloat(value)> 0&&parseFloat(value)<100.0000;
	      						}  
	      				} 
	                }
	         },
	         costRate : {
	        	 validators: {
	      				numeric: {message: '只能输入数字'},
	      				callback: {  
	      					message: '分期超人费率在0~100.0000之间',  
	      						callback: function(value, validator) { 
	      						return parseFloat(value)> 0&&parseFloat(value)<100.0000;
	      						}  
	      				} 
	                }
	         },dykInterestRate : {
	        	 validators: {
	      				numeric: {message: '只能输入数字'},
	      				callback: {  
	      					message: 'dyk利率在0~100.0000之间',  
	      						callback: function(value, validator) { 
	      						return parseFloat(value)> 0&&parseFloat(value)<100.0000;
	      						}  
	      				} 
	                }
	         }
	      }
		})
		.on('success.form.bv', function (e) {
			e.preventDefault();
		});	
}

function numFormat(){
	$("#interestRate").number(true, 4);
	$("#costRate").number(true, 4);
	$("#dykInterestRate").number(true, 4);
}