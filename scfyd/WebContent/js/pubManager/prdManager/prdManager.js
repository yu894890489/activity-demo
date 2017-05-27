$(document).ready(function() {
	//modal绑定事件
	$('#addModal').on('hidden.bs.modal', function() {
		$("#addForm")[0].reset();
		$("#addForm").bootstrapValidator('resetForm', true);
	});
	
	initTable(); 
	formValidator();
} );


/**
 * 备用!!
 */
/*function ajaxFileUpload(){
	if ($("#file").val().length > 0) {
		if(check()){
		$.ajaxFileUpload({  
	        url : '../../file/binUpload?pathId=1',  
	        secureuri : false,  
	        fileElementId : 'file',  
	        dataType : 'json',  
	        success : function(data, status) {  
	            if (data.result == 0) { 
	            	var path=data.fileUrl;
	            	var filename;
	            	if(path.indexOf("/")>0)//如果包含有"/"号 从最后一个"/"号+1的位置开始截取字符串
	            	{
	            	    filename=path.substring(path.lastIndexOf("/")+1,path.length);
	            	}
	            	else
	            	{
	            	    filename=path;
	            	}
	                $("#logoUrl").val( data.fileUrl); 
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
    }
    else {
    	bootbox.alert("请选择图片");
    }
	
}*/

/*
 * 图片大小限制和图片类型限制
 * by-jihang
 */
/**
 * 备用!!
 */
/*function check(){
	var aa=document.getElementById("file").value.toLowerCase().split('.');//以“.”分隔上传文件字符串
	if(aa[aa.length-1]=='gif'||aa[aa.length-1]=='jpg'||aa[aa.length-1]=='bmp'
		||aa[aa.length-1]=='png'||aa[aa.length-1]=='jpeg')//判断图片格式
	{
		var imagSize =  document.getElementById("file").files[0].size;
//		alert("图片大小："+imagSize+"B")
		if(imagSize<40*1024){
			return true;
		}else{
			bootbox.alert("图片大小在40KB以内，现在图片大小为："+imagSize/1024+"KB");
			return false;
		}
	}
	else
	{
		bootbox.alert('请选择格式为*.jpg、*.gif、*.bmp、*.png、*.jpeg 的图片');//jpg和jpeg格式是一样的只是系统Windows认jpg，Mac OS认jpeg，
		return false;
	}
}
*/

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
	    					url : '../../product/delete',
	    					data : '{"productId":"'+row.productId+'"}',
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




function searchFun() {
	initTable();  
}


function addFun() {
	$("#btn_blank").removeClass('col-sm-7').addClass('col-sm-4');
	$("#addModalLabel").text("添加");
    $('#addModal').modal({backdrop: 'static', keyboard: false});//防止点击空白/ESC 关闭
    $('#isEdit').val(1); //新增1；修改2
}

function detailFun(row) {
	$('#detailModal').modal({backdrop: 'static', keyboard: false});//防止点击空白/ESC 关闭
	CloudUtils.setForm(row,'detailForm');
    $("#detailForm input").attr("disabled",true);
    $("#detailForm textarea").attr("readonly",true);
}

function modFun(row,isEdit) {
	$("#btn_blank").removeClass('col-sm-7').addClass('col-sm-4');
	if(isEdit==2){
		$("#addModalLabel").text("修改");
	}
	$('#addModal').modal({backdrop: 'static', keyboard: false});//防止点击空白/ESC 关闭

	$('#isEdit').val(isEdit); //新增1;修改2;详情0
    $('#addModal').modal();
    CloudUtils.setForm(row,'addForm');
}

function saveProduct() {
	var da = $('#addForm').data('bootstrapValidator');
	da.validate();
	
	if(!da.isValid()){  
		 	return false;
    }else{
    	var modal = $('#addModal');
    	var data = CloudUtils.convertStringJson('addForm');
    	var data = eval("(" + data + ")");
    	data = JSON.stringify(data);
    	var isEdit =  $('#isEdit').val(); 
    	if(isEdit == 1){//新增1；修改2
    		var options = {
					url : '../../product/add',
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
    	}else if(isEdit == 2){
    		var options = {
					url : '../../product/mod',
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
    	window.parent.scrollTo(0,0);
    }
}

function initTable() { 
	$('#productListTable').bootstrapTable('destroy');  
	$("#productListTable").bootstrapTable({  
         method: "post", 
         url: "../../product/list", 
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
           var data = CloudUtils.convertStringJson('searchForm');
           var jsonData = eval("(" + data + ")");
           var param = {    
               pageNumber: params.pageNumber,    
               pageSize: params.pageSize,
               isPage : 1,
               productName: jsonData.productName,
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
 	        field: 'productId',
 	        title: '产品ID',
 	        align: 'center',
            valign: 'middle',
            visible: false
 	    }, {
 	        field: 'productName',
 	        title: '产品名称',
 	        align: 'center',
            valign: 'middle'
 	    }, {
 	        field: 'productDesc',
 	        title: '产品描述',
 	        align: 'center',
            valign: 'middle',
 	    },{
 	        field: 'attachment',
 	        title: '附件',
 	        align: 'center',
            valign: 'middle',
 	    },  {
 	        field: 'operation',
 	        title: '操作',
 	       align: 'center',
           valign: 'middle',
 	        formatter:function(value,row,index){
 	        	var d = '<a class = "fa fa-list-ul detail" style="color:#a9d86e;padding:0px 5px;" title="详情"  href="javascript:void(0)"></a>';
 	            var s = '<a class = "fa fa-edit modify" style="color:#d864fd;padding:0px 5px;" title="编辑" href="javascript:void(0)"></a>';
 	            var r = '<a class = "fa fa-trash-o remove" style="color:#fa8564;padding:0px 5px;" title="删除" href="javascript:void(0)"></a>';
 	            return d+' '+s+' '+r;
 	        },
 	        events: 'operateEvents'
 	    }]
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
	    	  productName: {
	              validators: {
	                  notEmpty: {
	                      message: '产品名称不能为空'
	                  }
	              }
	          },
	          productDesc: {
	        	  alidators: {
		                  stringLength: {
		                      max: 100,
		                      message: '长度为0-100'
		                  }
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

