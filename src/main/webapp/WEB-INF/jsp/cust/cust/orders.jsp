<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>jb-aptech毕业设计项目</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <link rel="stylesheet" type="text/css" href="easyui/1.3.4/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="css/wu.css" />
    <link rel="stylesheet" type="text/css" href="css/icon.css" />
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="easyui/1.3.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/common.js"></script>
    <%--<script type="text/javascript" src="js/lqjs/orders.js"></script>--%>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户信息管理 > 客户信息 > 历史订单 </div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="back();">返回</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>客户编号</th>
                <td>${sessionScope.cust3.custNo}</td>
                <th>客户名称</th>
                <td>${sessionScope.cust3.custName}</td>
            </tr>
        </table>
        <br />
        <table id="orders" class="easyui-datagrid">
            <script type="text/javascript">
                $('#orders').datagrid({
                    pagination : true,
                    pageList : [2, 4, 6],
                    pageSize : 6,
                    idField : 'odrId',
                    singleSelect : true,
                    toolbar : [{
                        iconCls : 'icon-edit',
                        text : '查看详情',
                        handler : function() {
                            var rows = $("#orders").datagrid("getSelected");
                            if (!rows) {
                                $.messager.alert('警告', '请选择订单！');
                                return;
                            }
                            var odrId = rows.odrId;
                            parent.addTab('订单详细', 'orderslineLQ/look?odrId='+odrId,'icon-edit',true);
                        }
                    }],
                    url : '/crm7/ordersLQ/list',
                    columns : [[{
                        field : 'odrId',
                        title : '订单编号',
                        width : "150"
                    },{
                        field : 'odrDate',
                        title : '日期',
                        width : "150"
                    }, {
                        field : 'odrAddr',
                        title : '送货地址',
                        width : "150"
                    }, {
                        field : 'status',
                        title : '状态',
                        width : "150"
                    }
                    ]]

                });
            </script>
        </table>
    </div>
</div>
</body>
</html>