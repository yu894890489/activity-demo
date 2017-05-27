

$(document).ready(function() {
//	ajaxtree();
	//modal绑定事件
	showSysType();
	$('#addModal').on('hidden.bs.modal', function(){
		
		$("#addForm")[0].reset();
	});
	$('#addModal').on('hide.bs.modal', function () {
		$("#addForm").data('bootstrapValidator').resetForm();
	})

	
    $("#roleId").select2({
        tags: true,
        width:"100%",

//        maximumSelectionLength: 3  //最多能够选择的个数
    });
	changeType($("#sysType"));
	initTable();
	formValidator();
	
} );

window.operateEvents = {
		'click .modify': function (e, value, row, index) {
				modFun(row);
		    },
	    'click .remove': function (e, value, row, index) {
	    	bootbox.confirm("确定删除此条记录?", function(result) {  
	            if (result) {  
	            	var options = {
	    					url : '../../user/delete',
	    					data : '{"userId":"'+row.userId+'"}',
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
	    },
		'click .reset': function (e, value, row, index) {
	    	bootbox.confirm("确定重置密码?", function(result) {  
	            if (result) {  
	            	var options = {
	    					url : '../../user/resetPassword',
	    					data : '{"userId":"'+row.userId+'"}',
	    					callBackFun : function(data) {
	    						if(data.result==0){
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




function searchFun() {
	initTable();  
}

function searchCorpFun() {
	initCorpTable('');  
}
function initCorpTable(data){
	 
	$('#corpListTable').bootstrapTable('destroy');  
	$("#corpListTable").bootstrapTable({  
         method: "post", 
         url: "../../corp/list", 
         striped: false,  //表格显示条纹  
         pagination: true, //启动分页  
         pageSize: 5,  //每页显示的记录数  
         pageNumber:1, //当前第几页  
         pageList: [5, 10, 15, 20, 25],  //记录数可选列表  
         search: false,  //是否启用查询  
         showColumns: false,  //显示下拉框勾选要显示的列  
         showRefresh: false,  //显示刷新按钮  
         sidePagination: "server", //表示服务端请求  
         singleSelect : true, // 单选checkbox 
         //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
         //设置为limit可以获取limit, offset, search, sort, order  
         queryParamsType : "undefined",   
         queryParams: function queryParams(params) {   //设置查询参数  
        	 var corpId='';
        	 var sysType='';
        	 var isLogo='';
        	 var isPage='1';
        	 var relaCorpId='';
        	 var corpName='';
        	 var dataTemp = CloudUtils.convertStringJson('corpSearchForm');
        	 var jsonData = eval("(" + dataTemp + ")");
        	 data =  eval("(" + data + ")");
        	 if(!data){
        		 corpId=jsonData.corpId;
        		 corpName=jsonData.corpName;
        	 }else if(data.sysType=="2"){
        		 corpId=data.corpId;
        		 sysType =data.sysType;
        		 isLogo = data.isLogo;
        		 isPage = data.isPage;
        	 }else{
        		 relaCorpId=data.relaCorpId;
        		 sysType =data.sysType;
        		 isLogo = data.isLogo;
        		 isPage = data.isPage;
        	 }
        	 var param = {    
        			 corpId: corpId,    
        			 sysType: sysType,
        			 isLogo: isLogo,
        			 isPage: isPage,
        			 relaCorpId:relaCorpId,
        			 corpName: corpName
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
             checkbox: true 
         },{
 	        field: 'corpId',
 	        title: 'Item ID',
 	        align: 'center',
             valign: 'middle',
             visible: false
 	    }, {
 	        field: 'corpId',
 	        title: '企业ID',
 	        align: 'center',
             valign: 'middle'
 	    }, {
 	        field: 'corpName',
 	        title: '企业名称',
 	        align: 'center',
             valign: 'middle'
 	    }]
       });  

}


function initTable() { 
	$('#userListTable').bootstrapTable('destroy');  
	$("#userListTable").bootstrapTable({  
         method: "post", 
         url: "../../user/list", 
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
           corpId = jsonData.txt_company;
           if(corpId==""&&store.get('roleType')==1){
        	   corpId = '';
	       }else if(corpId==""&&store.get('roleType')==2){
	    	   if(jsonData.txt_sysType ==5){
	    		   corpId = jsonData.txt_company;
	    	   }else{
	    		   corpId = store.get('corpId');
	    	   }
	       }
           var param = {    
               pageNumber: params.pageNumber,    
               pageSize: params.pageSize,
               username: jsonData.txt_realname,
               corpId: corpId,
               roleId: jsonData.txt_roleName == ""?null:jsonData.txt_roleName,
               mobilephone: jsonData.txt_mobilephone,
               roleType: jsonData.txt_sysType
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
 	        field: 'userId',
 	        title: 'Item ID',
 	        align: 'center',
             valign: 'middle',
             visible: false
 	    }, {
 	        field: 'username',
 	        title: '用户名称',
 	        align: 'center',
             valign: 'middle'
 	    }, {
 	        field: 'realname',
 	        title: '真实姓名',
 	        align: 'center',
             valign: 'middle'
 	    },{
 	        field: 'corpName',
 	        title: '所属企业',
 	        align: 'center',
             valign: 'middle'
 	    }, {
 	        field: 'corpId',
 	        title: '所属机构id',
 	        align: 'center',
             valign: 'middle',
             visible: false
 	    }, {
 	        field: 'deptName',
 	        title: '所属部门',
 	        align: 'center',
             valign: 'middle'
 	    }, {
 	        field: 'deptId',
 	        title: '所属部门id',
 	        align: 'center',
             valign: 'middle',
             visible: false
 	    }, {
 	        field: 'mobilephone',
 	        title: '手机号码',
 	        align: 'center',
             valign: 'middle'
 	    }, {
 	        field: 'fixedphone',
 	        title: '固定电话',
 	        align: 'center',
             valign: 'middle'
 	    }, {
 	        field: 'email',
 	        title: '邮箱',
 	        align: 'center',
             valign: 'middle'
 	    }, {
 	        field: 'roleName',
 	        title: '用户角色',
 	        align: 'center',
             valign: 'middle'
 	    }, {
 	        field: 'roleId',
 	        title: '用户角色id',
 	        align: 'center',
             valign: 'middle',
             visible: false
 	    }, {
 	        field: 'note',
 	        title: '用户描述（备注）',
 	        align: 'center',
             valign: 'middle'
 	    },{
 	        field: 'operation',
 	        title: '操作',
 	       align: 'center',
           valign: 'middle',
 	        formatter:function(value,row,index){
 	            var m = '<a class = "fa fa-edit modify" style="color:#d864fd;padding:0px 5px;" title="编辑" href="javascript:void(0)"></a>';
 	            var d = '<a class = "fa fa-trash-o remove" style="color:#fa8564;padding:0px 5px;" title="删除" href="javascript:void(0)"></a>';
 	            //if(store.get('roleType')==1){
 	            	var r = '<a class = "fa fa-rotate-left reset" style="color:#fad164;padding:0px 5px;" title="重置密码" href="javascript:void(0)"></a>';
 	            	return m+' '+d+' '+r;
 	          //  }
 	           // return m+' '+d;
 	        },
 	        events: 'operateEvents'
 	    }]
       });  
}
 
function ajaxtree(corpId){
	 //查出所有的树，不重session取deptId
	 var deptId = null;
	 if(!corpId ){
		 return;
	 }
	 var options = {
				url : "../../dept/tree",
				data : JSON.stringify({ 
		        	 "corpId": corpId,
		        	 "deptId": deptId
		         }),
		         callBackFun : function(data) {
						if(data.result==0){
							var jsonStringData= JSON.stringify(data.dataList);
				        	 jsonStringData=jsonStringData.replace(/deptName/g,'text');
				        	 jsonStringData=jsonStringData.replace(new RegExp("subDeptList","gm"),"nodes");
				         	 var jsonData=eval('('+ jsonStringData +')');
				         	$('#parentId').treeview({
				         		 data:jsonData,
				         		 showCheckbox:false,
				         		 levels:0
				         		 });

				        	$('#parentId').on('nodeSelected', function(event, data) {
				        		var parentId = $('#parentId').treeview('getSelected', 0);
				        		if(parentId.length!=0){
				        	 		$('#deptId').val(parentId[0].deptId);
//				        	 		$("#addForm").data('bootstrapValidator').updateStatus('deptId', 'NOT_VALIDATED',null).validateField('deptId');  
				        	 	}
				            });
				        	$('#parentId').on('nodeUnselected', function(event, data) {
				        		$('#deptId').val("");
//				         		$("#addForm").data('bootstrapValidator').updateStatus('deptId', 'NOT_VALIDATED',null).validateField('deptId'); 
				            });
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

function addFun() {
	$("#addModalLabel").text("添加");
    $('#addModal').modal({backdrop: 'static', keyboard: false});//防止点击空白/ESC 关闭
    $('#isEdit').val(1); //新增1；修改2
    $("#divPassword").show();
    changeType($("#sysType"));
    $("#corpId").attr("disabled", false);
    $("#sysType").attr("disabled", false);
    $("#corpId option:first").attr("selected", true);
	ajaxDepts($("#corpId").val());
	$("#deptId option:first").attr("selected", true);
	$("#roleId option:first").attr("selected", true);
	ajaxtree($("#corpId").val());
}
var oldName;
var oldPhone;
function modFun(row) {
	$("#sysType option[value="+row.roleType+"]").attr("selected", "selected");
	$("#sysType option[value="+row.roleType+"]").attr("selected", "selected");
	oldName = null;
	oldPhone = null;
	oldName = row.username;
	oldPhone = row.mobilephone;
	$("#addModalLabel").text("修改");
    $('#addModal').modal();
    $('#isEdit').val(2); //新增1；修改2
    $("#divPassword").hide();
    ajaxtree(row.corpId);
    
    var arr=row.roleId.split(',');
    $('#roleId').val(arr).trigger('change');
    
    var allOption= $('#parentId').treeview('getUnchecked', 0);
    $.each(allOption, function (index, units) {  
			if(units.deptId == row.deptId){
				 $("#parentId").treeview('selectNode', [ units.nodeId, { silent: true } ]);
				 //单选，保留性能
				 return false;
			}
		
	});
    CloudUtils.setForm(row,'addForm');
    $("#corpId").attr("disabled", true);
    $("#sysType").attr("disabled", true);

}

function saveUser() {
	//生成初始密码为 手机号码的后6位
	var mobileNum = $("#mobilephone").val();
	var password = mobileNum.substr(mobileNum.length-6);
	$("#password").val(password);
	debugger;
	var parentId = $('#parentId').treeview('getSelected', 0);
	if(parentId.length!=0){
 		$('#deptId').val(parentId[0].deptId);
 	}else{
 		$('#deptId').val("");
 	}

 	var modal = $('#addModal');
 	var data = CloudUtils.convertStringJson('addForm');
 	data = eval("(" + data + ")");
 	if(data.corpId=='corp00001'&& $("deptId").val()){
 		bootbox.alert("所属部门不可为空");
 		return;
 	}
	data = JSON.stringify(data);
	var isEdit =  $('#isEdit').val(); 
	if(isEdit == 1){//新增1；修改2
		var options = {
				url : '../../user/add',
				data : data,
				callBackFun : function(data) {
					if(data.result==0){
						searchFun();
						bootbox.alert(data.resultNote);
					}else{
						bootbox.alert(data.resultNote);
						return false;
					}
				},
				errorCallback:function(data){
					bootbox.alert(data.resultNote);
					return false;
				}
		};
		CloudUtils.ajax(options);
	}else{
		var jsonData = eval("(" + data + ")");
		if(oldName == jsonData.username){
			jsonData.username = null;
			
		}
		if(oldPhone == jsonData.mobilephone){
			jsonData.mobilephone = null;
		}
		var options = {
				url : '../../user/mod',
				data : JSON.stringify(jsonData),
				callBackFun : function(data) {
					if(data.result==0){
						searchFun();
						bootbox.alert(data.resultNote);
					}else{
						bootbox.alert(data.resultNote);
						return false;
					}
				},
				errorCallback:function(data){
					bootbox.alert(data.resultNote);
					return false;
				}
		};
		CloudUtils.ajax(options);
	}
	modal.modal("hide");
	window.parent.scrollTo(0,0);

}

function serchCorp(){
	ajaxCorps($("#sysType").val());
}


function  ajaxCorps(sysType){
	var data;
	if(store.get('roleType')==1){
		data = '{"isPage": 0}';
	}else{
		var relaCorpId = store.get('corpId');
		if(sysType == "2"){
			data ='{"corpId":"'+relaCorpId+'","sysType":"'+sysType+'","isLogo":"Y","isPage": 0}'
		}else{
			data ='{"relaCorpId":"'+relaCorpId+'","sysType":"'+sysType+'","isLogo":"Y","isPage": 0}'
		}
		
	}
	initCorpTable(data);
}

function changeCorp(cropId){	
	ajaxDepts(cropId);
	ajaxtree(cropId);
}

var type = "";
function changeType(obj){
	ajaxCorpRoles($(obj).val(),"");
	type = $(obj).val()
	$("#corpId").val('');
	$("#deptInfo").hide();
	$("#parentId").html("");
}

function changeTxtType(obj){
	var opt = obj.options[obj.selectedIndex];
	type = opt.value;
	ajaxTxtCorpRoles($("#corpId").val());
}

function changeTxtCompany(obj){
	var opt = obj.options[obj.selectedIndex];
	ajaxTxtCorpRoles(opt.value);
}

function  ajaxDepts(corpId){
	if(!corpId){
		return;
	}
	var options = {
			url : '../../dept/tree',
			data : '{"corpId":"'+corpId+'"}',
			callBackFun : function(data) {
				if(data.result==0){
					$("#deptId").html('');
					$.each(data.dataList, function (index, units) {  
						$("#deptId").append("<option value="+units.deptId+">" + units.deptName + "</option>");  
					});  
				}else{
					bootbox.alert(data.resultNote);
				}
			},
			errorCallback:function(data){
				bootbox.alert("error");  
			}
	};
	CloudUtils.ajax(options);
}

function  ajaxCorpRoles(type,corpId){
	var options = {
			url : '../../role/list',
			data : '{"roleType":"'+type+'", "corpId":"'+corpId+'"}',
			callBackFun : function(data) {
				if(data.result==0){
					$("#roleId").empty();
					$.each(data.dataList, function (index, units) {  
						$("#roleId").append("<option value='"+units.roleId+"'>&nbsp;" + units.roleName + "</option>");
						
					});
				}else{
					bootbox.alert(data.resultNote);
				}
			},
			errorCallback:function(data){
				bootbox.alert("error");  
			}
	};
	CloudUtils.ajax(options);
}

function  ajaxTxtCorpRoles(corpId){
	if(!corpId){
		return;
	}
	var options = {
			url : '../../role/list',
			data : '{"roleType":"'+type+'", "corpId":"'+corpId+'"}',
			callBackFun : function(data) {
				if(data.result==0){
					$("#txt_roleName").html('');
					$("#txt_roleName").append("<option value=''>全部</option>"); 
					$.each(data.dataList, function (index, units) {  
						$("#txt_roleName").append("<option value="+units.roleId+">" + units.roleName + "</option>");  
					});
				}else{
					bootbox.alert(data.resultNote);
				}
			},
			errorCallback:function(data){
				bootbox.alert("error");  
			}
	};
	CloudUtils.ajax(options);
}

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
	    	  realname: {
	              validators: {
	                  notEmpty: {
	                      message: '真实姓名不能为空'
	                  },
	                  stringLength: {
	                      min: 1,
	                      max: 10,
	                      message: '用户名长度为1-10'
	                  }
	              }
	          },
	          email: {
	              validators: {
	            	  stringLength: {
			              max: 32,
			              message: '邮箱长度不能超过32'
			          },
	            	  regexp: {
	                      regexp: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
	                      message: '邮箱格式不正确'
	                  }
	              }
	          },
//	          password: {
//	              validators: {
//	                  notEmpty: {
//	                      message: '密码不能为空'
//	                  },
//	                  different: {
//	                      field: 'username',
//	                      message: '密码不能和用户名相同'
//	                  }
//	              }
//	          },

	          mobilephone: {
	              validators: {
	                  notEmpty: {
	                      message: '手机号不能为空'
	                  },
			          stringLength: {
			              min: 11,
			              max: 11,
			              message: '手机号长度为11'
			          },
			          regexp: {
	                      regexp: /^[0-9]*$/,
	                      message: '手机号只能是数字'
	                  }
	              }
	          },
	          roleId: {
	              validators: {
	                  notEmpty: {
	                      message: '角色不能为空'
	                  }
	              }
	          },
	          fixedPhone: {
	              validators: {
	            	  stringLength: {
			              max: 20,
			              message: '固定电话长度不能超过20'
			          },
	              }
	          },
	          note: {
	              validators: {
	            	  stringLength: {
			              max: 128,
			              message: '用户描述长度不能超过128'
			          },
	              }
	          },
//	          deptId: {
//	        	  validators: {
//	                  notEmpty: {
//	                      message: '所属部门不能为空'
//	                  }
//	              }
//	          },
	          username: {
	              message: '用户名格式不正确',
	              validators: {
	                  notEmpty: {
	                      message: '用户名不能为空'
	                  },
	                  stringLength: {
	                      min: 3,
	                      max: 20,
	                      message: '用户名长度为3-20'
	                  },
	                  regexp: {
	                      regexp: /^[a-zA-Z0-9_\.]+$/,
	                      message: '只能使用字母、数字、.和_'
	                  },
	                  different: {
	                      field: 'password',
	                      message: '用户名不能和密码相同'
	                  }
	              }
	          }
	      }
		})
		.on('success.form.bv', function (e) {
			e.preventDefault();
		});	
}

function showSysType(){
	//判断是否为保理商管理员
	var roleId = store.get('roleId');
	if(roleId=='ROLE000002'){
		$("#sysType").parent().parent().css('display','block');
		$("#txt_sysType").parent().css('display','block');
		$("#txt_realname").parent().removeClass("col-sm-2").addClass("col-sm-3");
		$("#txt_company").parent().removeClass("col-sm-2").addClass("col-sm-1");
		$("#txt_roleName").parent().removeClass("col-sm-2").addClass("col-sm-1");
	}
}

function controlParentId(corpId){
	if(corpId=="corp00001"){
		$("#deptInfo").show();	
	}else{
		$("#deptInfo").hide();	
	}
	
}

function checkCorpId(){
	var obj = $('#corpListTable').bootstrapTable('getSelections')[0];
	controlParentId(obj.corpId)
	changeCorp(obj.corpId);
	$("#corpId").val(obj.corpId);
	$('#corpInfo').modal('hide');
}
