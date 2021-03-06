$(document).ready(function() {
	initCntFileListTable();
	initCertifyFileListTable();
} );



function initCntFileListTable() {
	$('#cntFileListTable').bootstrapTable('destroy');  
	$("#cntFileListTable").bootstrapTable({  
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
 	        field: 'productName',
 	        title: '附件名称',
 	        align: 'center',
            valign: 'middle',
 	    }, {
 	        field: 'productName',
 	        title: '附件类型',
 	        align: 'center',
            valign: 'middle',
        	formatter:function(value,row,index){
        		var a = '<select><option value="0">签约视频</option>';
        		var b = '<option value="1">签约文件</option>';
        		var c = '<option value="2">其他</option></select>';
        		return a + ' '+b +' ' +c;
        	}
 	    },{
 	        field: 'attachment',
 	        title: '文件格式',
 	        align: 'center',
            valign: 'middle',
 	    },{
 	        field: 'attachment',
 	        title: '文件大小',
 	        align: 'center',
            valign: 'middle',
 	    },{
 	        field: 'operation',
 	        title: '操作',
 	        align: 'center',
 	        valign: 'middle',
 	        formatter:function(value,row,index){
 	        	var m = '<a class = "fa fa-edit mod" style="color:#d864fd;padding:0px 5px;" title="编辑" href="javascript:void(0)"></a>';
	 	        var r = '<a class = "fa fa-trash-o remove" style="color:#fa8564;padding:0px 5px;" title="删除" href="javascript:void(0)"></a>';
	 	        var d = '<a class = "fa fa-download dowload" style="color:#d864fd;padding:0px 5px;" title="下载" href="javascript:void(0)"></a>';
	            return m +' '+r + ' ' +d;
	        }, 
	        events: 'operateEvents'
 	    }]
       });  
}
function initCertifyFileListTable() {
	$('#certifyFileListTable').bootstrapTable('destroy');  
	$("#certifyFileListTable").bootstrapTable({  
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
  	        field: 'productName',
  	        title: '附件名称',
  	        align: 'center',
             valign: 'middle',
  	    }, {
  	        field: 'productName',
  	        title: '附件类型',
  	        align: 'center',
             valign: 'middle',
         	formatter:function(value,row,index){
         		var a = '<select><option value="0">三方协议</option>';
         		var b = '<option value="1">最高额保证合同</option>';
         		var c = '<option value="2">保单</option></select>';
         		return a + ' '+b +' ' +c;
         	}
  	    },{
  	        field: 'attachment',
  	        title: '文件格式',
  	        align: 'center',
             valign: 'middle',
  	    },{
  	        field: 'attachment',
  	        title: '文件大小',
  	        align: 'center',
             valign: 'middle',
  	    },{
  	        field: 'operation',
  	        title: '操作',
  	        align: 'center',
  	        valign: 'middle',
  	        formatter:function(value,row,index){
  	        	var m = '<a class = "fa fa-edit mod" style="color:#d864fd;padding:0px 5px;" title="编辑" href="javascript:void(0)"></a>';
 	 	        var r = '<a class = "fa fa-trash-o remove" style="color:#fa8564;padding:0px 5px;" title="删除" href="javascript:void(0)"></a>';
 	 	        var d = '<a class = "fa fa-download dowload" style="color:#d864fd;padding:0px 5px;" title="下载" href="javascript:void(0)"></a>';
 	            return m +' '+r + ' ' +d;
 	        }, 
 	        events: 'operateEvents'
  	    }]
       });  
}

function fileSelect() {
	document.getElementById("file").value = null;
    document.getElementById("file").click(); 
}

function uploadAttachment(){
	fileSelect();
}

