let corpId = CloudUtils.getIframeParams($(window.parent.document).find('iframe').attr('src')).taskId;
$(function () {
	"use strict";
    InitTable();
 });

function InitTable(){
	$('#daiban').bootstrapTable('destroy');  
	$("#daiban").bootstrapTable({  
	     method: "post", 
	     url: "../../activiti/getAgencyTaskList", 
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
	       var param = {    
	           pageNumber: params.pageNumber,    
	           pageSize: params.pageSize
	       };    
	       return JSON.stringify(param);                   
	     },  
	     responseHandler:function responseHandler(res) {
	    	 debugger
	    	 if (res.result==0) {
	        	 return {
	        		 "rows": res.dataList,
	        		 "total": res.records
	        	 };

	    	 } else {
	    		 alert(res.resultNote);
	    		 return {
			        	 "rows": [],
			        	 "total": 0
			        	 };
	    	 }
	     },
	     columns: [{
		        field: 'taskName',
		        title: '角色类型',
		        align: 'center',
	            valign: 'middle'
		    }, {
		        field: 'procdefName',
		        title: '流程名称',
		        align: 'center',
	            valign: 'middle'
		    },{
		        field: 'procInstId',
		        title: '进程Id',
		        align: 'center',
	            valign: 'middle'
		    }, {
		        field: 'taskId',
		        title: 'taskId',
		        align: 'center',
	            valign: 'middle'
		    },{
		        field: 'taskDefKey',
		        title: '节点id',
		        align: 'center',
	            valign: 'middle'
		    },{
		        field: 'createTime',
		        title: '创建时间',
		        align: 'center',
	            valign: 'middle'
		    },{
	 	        field: 'operation',
	 	        title: '编辑',
	 	        align: 'center',
	 	        formatter:function(value,row,index){
	 	        	var m = '<a class = "fa fa-edit mod" style="color:#d864fd;padding:0px 5px;" title="编辑" href="javascript:void(0)"></a>';
	 	        	var s = '<a class = "glyphicon glyphicon-eye-open show" style="color:green;padding:0px 5px;" title="导图" href="javascript:void(0)"></a>';
		 	        return m +" "+s;
	 	        },
	 	        events: 'operateEvents'
	 	    }]
	   });  
		window.operateEvents = {
		'click .mod': function (e, value, row, index) {
				if(row.taskName=="悦达项目经理"){
					//再申请
					$('#mainFrame',top.document).attr('src','pubManager/custManager/custReapply.html?taskId='+row.taskId+'&procInstId='+row.procInstId);
				}else{
					//进入审核
					$('#mainFrame',top.document).attr('src','pubManager/custManager/custAgencyTask.html?taskId='+row.taskId+'&procInstId='+row.procInstId);
				}
		    },
		// 流程图形
		'click .show': function (e, value, row, index) {
			var processDefinitionId = typeof(row.processDefinitionId)=="undefined"?"":row.processDefinitionId.replace(/\:/g, '%3A');
			var processInstanceId = typeof(row.processInstanceId)=="undefined"?"":row.procInstId.replace(/\:/g, '%3A');
			var taskId = typeof(row.taskId)=="undefined"?"":row.taskId;
			
			$("#pic").attr("src", "../../activiti/graph?processDefinitionId="+processDefinitionId+
					"&processInstanceId="+processInstanceId+"&taskId="+taskId);
			$("#picModal").modal({backdrop: 'static', keyboard: false});
		},
		};
}