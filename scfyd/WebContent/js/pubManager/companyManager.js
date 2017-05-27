 $(function() {
	 initTable();
	 initShareHolderInfoTable();
	 attachInfoTable();
 });
 
 var shareIndex =0;
 window.operateEvents = {
		
			'click .detail': function (e, value, row, index) {
				 detailFun(row);
				 initShareHolderInfoTable(row.corpId);
				 attachInfoTable(row.corpId);
		    },
		    'click .modify': function (e, value, row, index) {
		    	if($(e.target).data('type')==="shareInfo"){
		    		//修改
		    		modShareFun(row,2);
		    		shareIndex = index;
		    	}else if($(e.target).data('type')==="custInfo"){
		    		initShareHolderInfoTable(row.corpId);
		    		attachInfoTable(row.corpId);
		    		modFun(row, 2);
		    	}
		    },
		    'click .remove':function (e, value, row, index) {
		    	debugger
		    	//$('#shareHolderInfoTable').bootstrapTable('removeByUniqueId', index);
		    	if($(e.target).data('type')==="shareInfo"){
		    		var values = [];
			    	values.push(row.shareName);
			    	$('#shareHolderInfoTable').bootstrapTable('remove', {field: 'shareName', values: values});
		    	}else if ($(e.target).data('type')==="attach"){
		    		var values = [];
			    	values.push(row.fileUrl);
			    	$('#attachInfoTable').bootstrapTable('remove', {field: 'fileUrl', values: values});
		    	}
		    	
			}
 };
 
 function searchFun(){
	 initTable("");
 }
 
 function detailFun(row) {
	 	$('#detailModal').modal();
	 	$("#addModalLabel").text("详情");
	 	$("#detailForm").val("");
	 	CloudUtils.setForm(row,'detailForm');
	 	$('#detailForm input').attr('readonly',true);
	    document.getElementById("btn_save").style.display="none";
	    $("#btn_blank").removeClass('col-sm-4').addClass('col-sm-7');
	}
 
 function modFun(row,isEdit){
	$("#addModalLabel").text("修改");
	$('#detailModal').modal();
	$("#detailForm input").val("");
	CloudUtils.setForm(row,'detailForm');
	$('#isEdit').val(isEdit); //新增1;修改2
 }
 
 function modShareFun(row,isEdit){
    $("#addshareInfoModalLabel").text("修改");
	$('#shareInfoModal').modal();
	CloudUtils.setForm(row,'shareInfoForm');
	//
	$('#isEdit2').val(isEdit); //新增1;修改2
 }
 
 function initTable() { 
		$('#custInfoList').bootstrapTable('destroy'); 
		$("#custInfoList").bootstrapTable({  
	         method: "post", 
	         url: "../custInfo/list", 
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
	             var param = {    
	                 pageNumber: params.pageNumber,    
	                 pageSize: params.pageSize,
	                 corpName:jsonData.txt_corpName,
	                 legalPerson:jsonData.txt_legalPerson,
	                 sysType:jsonData.txt_sysType,
	                 corpType:jsonData.txt_corpType
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
	 	        field: 'corpId',
	 	        title: 'Item ID',
	 	        align: 'center',
	             valign: 'middle',
	             visible: false
	 	    }, {
	 	        field: 'corpName',
	 	        title: '公司名称',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'orgnNum',
	 	        title: '组织机构代码证号',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'corpType',
	 	        title: '企业类型',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'legalPerson',
	 	        title: '法定人代表',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'regCap',
	 	        title: '注册资本',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'officeAddress',
	 	        title: '公司地址',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'contactInfo',
	 	        title: '联系方式',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'fixedPhone',
	 	        title: '固定电话',
	 	        align: 'center',
	             valign: 'middle'
	 	    },{
	 	        field: 'operation',
	 	        title: '操作',
	 	        align: 'center',
	            valign: 'middle',
	 	        formatter:function(value,row,index){
	 	        	var d = '<a class = "fa fa-list-ul detail" style="color:#a9d86e;padding:0px 5px;" data-type="custInfo" title="详情" href="javascript:void(0)"></a>';
	 	        	var m = '<a class = "fa fa-edit modify" style="color:#d864fd;padding:0px 5px;" data-type="custInfo" title="编辑" href="javascript:void(0)"></a>';
	 	            return d +' '+ m;
	 	        },
	 	        events: 'operateEvents'
	 	    }
	 	    ]
	       });  
	}

 function addFun(type){
	 if(type === 0){
		 $("#detailModal").modal();
		 $('#isEdit').val(1); //新增1;修改2 
	 }else if(type === 1){
		 $("#shareInfoModal").modal();
		 $('#isEdit2').val(1); //新增1;修改2 
	 }
 }
 
 function saveFun(type){
	 if(type === 0){
//			保存到数据库
		 var data = CloudUtils.convertStringJson('detailForm');
	     var jsonData = eval("(" + data + ")");
	     var isEdit = $('#isEdit').val();
	     var allTableData = $('#shareHolderInfoTable').bootstrapTable('getData');
	     var attachData = $('#attachInfoTable').bootstrapTable('getData');
	     jsonData.shareInfoList = allTableData;
	     jsonData.attachInfoList = attachData;
	     if (isEdit == 1) {
		 var options = {
					url : '../custInfo/add',
					data : JSON.stringify(jsonData),
					callBackFun : function(data) {
						bootbox.alert(data.resultNote);
						if (data.result == 0) {
							searchFun();
						} else {
							return false;
						}
					},
					errorCallback : function(data) {
						bootbox.alert(data.resultNote);
						return false;
					}
				};
		 CloudUtils.ajax(options);
	     } else if(isEdit == 2){
	    	 var options = {
	 				url : '../custInfo/mod',
	 				data : JSON.stringify(jsonData),
	 				callBackFun : function(data) {
	 					bootbox.alert(data.resultNote);
	 					if (data.result == 0) {
	 						searchFun();
	 					} else {
	 						return false;
	 					}
	 				},
	 				errorCallback : function(data) {
	 					bootbox.alert(data.resultNote);
	 					return false;
	 				}
	 			};
	    	 CloudUtils.ajax(options);
	     }
		 $("#detailModal").modal("hide");
	 }else if(type ===1 ){
		 var isEdit2 = $('#isEdit2').val();
		  if (isEdit2 == 1) {// 新增1；修改2
			  var data = CloudUtils.convertStringJson('shareInfoForm');
//				 先只在页面显示，不录入数据库
			 $("#shareHolderInfoTable").bootstrapTable('append', JSON.parse(data));
		     } else if(isEdit2 == 2){
		    	 var data = CloudUtils.convertStringJson('shareInfoForm');
		    	$('#shareHolderInfoTable').bootstrapTable('updateRow', {index: shareIndex, row: JSON.parse(data)});
		     }
			$("#shareInfoModal").modal("hide");
	 }

 }
 
// 初始化股东信息表
 function initShareHolderInfoTable(corpId){
	 $('#shareHolderInfoTable').bootstrapTable('destroy'); 
		$("#shareHolderInfoTable").bootstrapTable({  
	         method: "post", 
	         url: "../shareHolder/list", 
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
		                 pageSize: params.pageSize
		             }; 
				 if(corpId){
					 param.corpId = corpId            	 
	             } 
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
	 	        field: 'shareName',
	 	        title: '股东名称',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'shareProportion',
	 	        title: '持股比例',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'registeredCapital',
	 	        title: '注册资本份额',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'registeredCapitalProportion',
	 	        title: '注册资本占比',
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
 
// 添加附件信息
function attachInfoTable(corpId){
	 $('#attachInfoTable').bootstrapTable('destroy'); 
		$("#attachInfoTable").bootstrapTable({  
	         method: "post", 
	         url: "../uploadFile/list", 
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
//	             var data = CloudUtils.convertStringJson('searchForm');
//	             var jsonData = eval("(" + data + ")");
	             var param = {    
	                 pageNumber: params.pageNumber,    
	                 pageSize: params.pageSize
	             }; 
	             if(corpId){
					 param.corpId = corpId            	 
	             } 
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
	 	        field: 'fileUrl',
	 	        title: '附件地址',
	 	        align: 'center',
	            valign: 'middle',
	            visible: false
		 	}, {
	 	        field: 'fileName',
	 	        title: '附件名称',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'attachType',
	 	        title: '附件格式',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'attachSize',
	 	        title: '附件大小',
	 	        align: 'center',
	             valign: 'middle'
	 	    }, {
	 	        field: 'operation',
	 	        title: '操作',
	 	        align: 'center',
	            valign: 'middle',
	 	        formatter:function(value,row,index){
	 	        	var r = '<a class = "fa fa-trash-o remove" style="color:#fa8564;padding:0px 5px;" title="删除" data-type="attach" href="javascript:void(0)"></a>';
	 	        	//var m = '<a class = "fa fa-edit modify" style="color:#d864fd;padding:0px 5px;" title="编辑" data-type="shareInfo" href="javascript:void(0)"></a>';
	 	            return r;
	 	        },
	 	        events: 'operateEvents'
	 	    }
	 	    ]
	       });  
}

//文件上传部分
var uploadAttachment = function() {
	//document.getElementById("file").value = null;
	document.getElementById("file").click();
	$('#detailModal').modal({backdrop: 'static', keyboard: false});
}

function ajaxFileUpload(){
	if ($("#file").val().length > 0) {
		$.ajaxFileUpload({  
	        url : '../file/binUpload?pathId=3',  
	        secureuri : false,  
	        fileElementId : 'file',  
	        dataType : 'json',  
	        success : function(data, status) {  
	        	debugger
	            if (data.result == 0) { 
//	            	1.先添加进页面中
	            	var relData = {};
	            	relData.fileName = data.fileName;
	            	relData.attachSize = data.fileSize;
	            	relData.fileUrl = data.fileUrl;
	            	relData.attachType = data.fileType;
	            	$("#attachInfoTable").bootstrapTable('append', relData);
	                bootbox.alert("上传成功！");
	                
	            }else{
	            	bootbox.alert("上传失败！"); 
	            } 
	        },  
	        error : function(data, status, e) {  
	        	bootbox.alert(e);  
	        }  
	    });  
    }
    else {
    	bootbox.alert("请选择文件");
    }
	
}