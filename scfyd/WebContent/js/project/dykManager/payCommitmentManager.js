$(document).ready(function() {
	dateload();
	//initDate();
	initTable();
	initCarInfoListTable();
	
	$('#addModal').on('hidden.bs.modal', function() {
		$("#addForm")[0].reset();
		$("#addForm").bootstrapValidator('resetForm', true);
	});
} );

window.operateEvents = {
		'click .detail': function (e, value, row, index) {
			detailFun(row,0);
	    }
};

function addFun() {
	$("#btn_blank").removeClass('col-sm-7').addClass('col-sm-4');
	$("#addModalLabel").text("添加");
    $('#addModal').modal({backdrop: 'static', keyboard: false});//防止点击空白/ESC 关闭
    $('#isEdit').val(1); //新增1；修改2
}

function searchFun(){
	 initTable("");
}

function detailFun(row) {
 	$('#detailModal').modal();
 	CloudUtils.setForm(row,'detailForm');
 	$('#detailForm input').attr('readonly',true);
    $("#btn_decide").removeClass('col-sm-4').addClass('col-sm-7');
}


function dateload(){
	 $('#startDate,#endDate').datetimepicker({
      language: 'zh-CN',
      autoclose: 1,
      todayBtn: true,// 显示今天时间
      pickerPosition: "bottom-left",
      minuteStep: 5,
      format: 'yyyy-m-dd',
      minView: 'month',　　// 日期时间选择器所能够提供的最精确的时间选择视图。
      initialDate : new Date() //参考financeInfoManager.js
     });
	 $('#startDate').datetimepicker('setEndDate', new Date());
}

/*function initDate(){
	var today=new Date();
	var submitTime=today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate()+'';
//	$("#startDate").val(submitTime);
	$("#endDate").attr("placeholder","选择融资到期日");
	
}*/

function initTable() { 
	$('#payCommitmentInfoList').bootstrapTable('destroy'); 
	$("#payCommitmentInfoList").bootstrapTable({  
		method: "post", 
        url: "../../commitment/list", 
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
              corpName:jsonData.corpName,
              corpId:jsonData.corpId,
              isPage : 1
              
          }; 
          debugger;
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
 	        field: 'corpName',
 	        title: '经销商名称',
 	        align: 'center',
            valign: 'middle',
 	    }, {
 	        field: 'corpId',
 	        title: '经销商代码',
 	        align: 'center',
            valign: 'middle',
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
 	        valign: 'middle'
 	    },{
 	        field: 'payM',
 	        title: '付款金额',
 	        align: 'center',
 	        valign: 'middle'
 	    },{
 	        field: 'productName',
 	        title: '融资状态',
 	        align: 'center',
 	        valign: 'middle'
 	    },{
 	        field: 'operation',
 	        title: '操作',
 	        align: 'center',
            valign: 'middle',
 	        formatter:function(value,row,index){
 	        	var d = '<a class = "fa fa-list-ul detail" style="color:#a9d86e;padding:0px 5px;" title="详情" href="javascript:void(0)"></a>';
 	            return d;
 	        },
 	        events: 'operateEvents'
 	    }
 	    ]
       });  
}

function initCarInfoListTable() { 
	$('#carInfoListTable').bootstrapTable('destroy'); 
	$("#carInfoListTable").bootstrapTable({  
		method: "post", 
        url: "", 
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
 	        title: '文件格式',
 	        align: 'center',
            valign: 'middle'
 	    },{
 	        field: 'attachment',
 	        title: '文件大小',
 	        align: 'center',
            valign: 'middle'
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