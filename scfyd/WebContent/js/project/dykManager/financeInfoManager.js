$(document).ready(function() {
	dateload();
	//initDate();
	initTable();
	formValidator();
	numFormat();
	$('#addModal').on('hidden.bs.modal', function() {
		$("#addForm").bootstrapValidator('resetForm', true);
		$("#addForm")[0].reset();
	});
} );

window.operateEvents = {
		'click .detail': function (e, value, row, index) {
			detailFun(row);
	    },
		'click .modify': function (e, value, row, index) {
			modFun(row,2);
		},
		'click .remove': function (e, value, row, index) {
			bootbox.confirm("确定删除此条记录?", function(result) {  
				if (result) {
					var options = {
            			url : '../../finance/delete',
    					data : '{"financeId":"'+row.financeId+'"}',
    					callBackFun : function(data) {
    						if(data.result==0){
    							initTable();
    							bootbox.alert(data.resultNote);
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

function searchFun(){
	 initTable();
}

function detailFun(row) {
 	$('#detailModal').modal();
 	CloudUtils.setForm(row,'detailForm');
 	$('#detailForm input').attr('readonly',true);
 	$('#detailForm select').attr('disabled',true);
    $("#btn_blank").removeClass('col-sm-4').addClass('col-sm-7');
}


function dateload(){
	 $('#financeStartDate,#financeEndDate,#applyDate').datetimepicker({
      language: 'zh-CN',
      autoclose: 1,
      todayBtn: true,// 显示今天时间
      pickerPosition: "bottom-left",
      minuteStep: 5,
      format: 'yyyy-mm-dd',
      minView: 'month',　　// 日期时间选择器所能够提供的最精确的时间选择视图。
      initialDate : new Date() //参考financeInfoManager.js
     });
	 $('#financeStartDate').datetimepicker('setEndDate', new Date());
}

function addFun() {
	$("#btn_blank").removeClass('col-sm-7').addClass('col-sm-4');
	$("#addForm input").attr("readonly",false);
	$("#addModal #applyDate,#financeStartDate,#financeEndDate").attr("readonly",true);
	$("#addForm select").attr("disabled",false);
	$("#addModalLabel").text("添加");
    $('#addModal').modal({backdrop: 'static', keyboard: false});//防止点击空白/ESC 关闭
    $('#isEdit').val(1); //新增1；修改2
}

/*function initDate(){
	var today=new Date();
	var submitTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate()+'';
//	$("#startDate").val(submitTime);
	$("#endDate").attr("placeholder","选择融资到期日");
	
}*/

function modFun(row,isEdit) {
	$("#addModal input").attr("readonly",true);
	$("#financeAmount").attr("readonly",false);
	$("#addForm select").attr("disabled",true);
	$("#btn_blank").removeClass('col-sm-7').addClass('col-sm-4');
	if(isEdit==2){
		$("#addModalLabel").text("修改");
	}
	$('#addModal').modal({backdrop: 'static', keyboard: false});//防止点击空白/ESC 关闭

	$('#isEdit').val(isEdit); //新增1;修改2;详情0
    $('#addModal').modal();
    CloudUtils.setForm(row,'addForm');
}

function saveFinanceInfo() {
    	var modal = $('#addModal');
    	var data = CloudUtils.convertStringJson('addForm');
    	var data = eval("(" + data + ")");
    	data = JSON.stringify(data);
    	var isEdit =  $('#isEdit').val(); 
    	if(isEdit==1){
    		var url = '../../finance/add';//新增1；修改2
    	}else if(isEdit==2){
    		var url = '../../finance/mod';
    	}
    	var options = {
				url : url,
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
    	modal.modal("hide");
    	window.parent.scrollTo(0,0);
}

function initTable() { 
	$('#financeInfoList').bootstrapTable('destroy'); 
	$("#financeInfoList").bootstrapTable({  
		 method: "post", 
         url: "../../finance/list", 
         striped: true,  //表格显示条纹  
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
           var agencyName = '';
           var financeId = '';
           var agencyNum = '';
           var financeStartDate = '';
           var financeEndtDate = '';
           var data = CloudUtils.convertStringJson('searchForm');
           var jsonData = eval("(" + data + ")");
           if(!data){
	        	agencyName=jsonData.agencyName;
	          	financeId=jsonData.financeId;
	          	agencyNum=jsonData.agencyNum;
	          	financeStartDate=sonData.financeStartDate;
	          	financeEndtDate=sonData.financeEndtDate;
      	 	}else{
      	 		agencyName=$("#agencyName").val();
      	 		agencyNum=$("#agencyNum").val();
      	 		financeStartDate=$("#financeStartDate").val();
      	 		financeEndtDate=$("#financeEndtDate").val();
      	 		financeId=$("#financeId").val();
      	 	}
           var param = {    
               pageNumber: params.pageNumber,    
               pageSize: params.pageSize,
               isPage : 1,
               agencyName:agencyName,
	           financeId:financeId,
	           agencyNum:agencyNum,
	           financeStartDate:financeStartDate,
	           financeEndtDate:financeEndtDate
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
 	        field: 'agencyName',
 	        title: '经销商名称',
 	        align: 'center',
            valign: 'middle'
 	    }, {
 	        field: 'agencyNum',
 	        title: '经销商代码',
 	        align: 'center',
            valign: 'middle',
 	    }, {
 	        field: 'financeId',
 	        title: '融资编号',
 	        align: 'center',
            valign: 'middle',
            visible:false
 	    }, {
 	        field: 'financeStartDate',
 	        title: '融资起始日',
 	       align: 'center',
           valign: 'middle'
 	    },{
 	        field: 'financeEndDate',
 	        title: '融资到期日',
 	        align: 'center',
 	        valign: 'middle'
 	    },{
 	        field: 'financeAmount',
 	        title: '融资金额',
 	        align: 'center',
 	        valign: 'middle',
 	        formatter:function(value,row,index){
 	        	return $.number(value, 2);
 	        }
 	    },{
 	        field: 'expense',
 	        title: '付款金额',
 	        align: 'center',
 	        valign: 'middle',
 	        formatter:function(value,row,index){
 	        	return $.number(value, 2);
            }
 	    },{
 	        field: 'financeStatus',
 	        title: '融资状态',
 	        align: 'center',
 	        valign: 'middle',
 	       formatter:function(value,row,index) {
				if (value == "0") {
					return "未审核";
				} else if (value == "1") {
					return "待放款";
				}else if (value == "2") {
					return "已放款";
				}else if (value == "3") {
					return "已部分还款";
				}else if (value == "4") {
					return "已全额还款";
				}else if (value == "5") {
					return "逾期";
				}
	    	}
 	    },{
 	        field: 'operation',
 	        title: '操作',
 	        align: 'center',
            valign: 'middle',
 	        formatter:function(value,row,index){
 	        	var m = '<a class = "fa fa-edit modify" style="color:#d864fd;padding:0px 5px;" title="修改" href="javascript:void(0)"></a>';
 	        	var r = '<a class = "fa fa-trash-o remove" style="color:#fa8564;padding:0px 5px;" title="删除" href="javascript:void(0)"></a>';
 	        	var d = '<a class = "fa fa-list-ul detail" style="color:#a9d86e;padding:0px 5px;" title="详情" href="javascript:void(0)"></a>';
 	            return d + ' ' +m+' '+r;
 	        },
 	        events: 'operateEvents'
 	    }
 	    ]
       });  
}

//form验证规则
function formValidator(){
	$('#addForm').bootstrapValidator({
	      message: 'This value is not valid',
	      excluded: ':disabled',
	      feedbackIcons: {
	          valid: 'glyphicon glyphicon-ok',
	          invalid: 'glyphicon glyphicon-remove',
	          validating: 'glyphicon glyphicon-refresh'
	      },
	      fields: {
	    	  agencyName: {
	              validators: {
	                  notEmpty: {
	                      message: '经销商名称不能为空'
	                  }
	              }
	          },
	          agencyNum: {
	        	  validators: {
	        		  notEmpty: {
	                      message: '经销商名称不能为空'
	                  },
	        		  numeric: {message: '只能输入数字'},
	                  stringLength: {
	                      max: 100,
	                      message: '长度为0-100'
	                  }
		          }
	          },
	          cashRate:{
	        	  validators: {
	        		  notEmpty: {message: '费率不能为空'},
	        		  numeric: {message: '只能输入数字'},
	        		  callback: {  
	                        message: '保证金收取比例在0.00~100.00之间',  
	      						callback: function(value, validator) { 
	      						return parseFloat(value)>= 0&&parseFloat(value)<=100;
	                        }  
	                    } 
	                  
		          }
	          },
	          financeRate:{
	        	  validators: {
	        		  notEmpty: {message: '融资比例不能为空'},
	        		  numeric: {message: '只能输入数字'},
	        		  callback: {  
	                        message: '保证金收取比例在0.00~100.00之间',  
	      						callback: function(value, validator) { 
	      						return parseFloat(value)>= 0&&parseFloat(value)<=100;
	                        }  
	                    } 
	                  
		          }
	          },
	          availableCredit:{
	        	  validators: {
	        		  notEmpty: {message: '可用授信额度不能为空'},
	        		  numeric: {message: '只能输入数字'}
	        	  }
	          },
	          maxCredit:{
	        	  validators: {
	        		  notEmpty: {message: '最高授信额度不能为空'},
	        		  numeric: {message: '只能输入数字'}
	        	  } 
	          },
	          expense:{
	        	  validators: {
	        		  notEmpty: {message: '费用不能为空'},
	        		  numeric: {message: '只能输入数字'}
	        	  } 
	          },
	          financeAmount:{
	        	  validators: {
	        		  notEmpty: {message: '费用不能为空'},
	        		  numeric: {message: '只能输入数字'}
	        	  } 
	          }
	      }
		})
		.on('success.form.bv', function (e) {
        // Prevent form submission
        e.preventDefault();
        // Get the form instance
        var $form = $(e.target);
        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator')
		});
}

function numFormat(){
	$("#maxCredit").number(true, 2);	//最高信用额度
	$("#availableCredit").number(true, 2);	//可用信用额度
	$("#financeRate").number(true, 2);	//融资比例
	$("#cashRate").number(true, 4);	//费率
	$("#financeAmount").number(true, 2);	//融资金额
	$("#expense").number(true, 2);	//费用
}
