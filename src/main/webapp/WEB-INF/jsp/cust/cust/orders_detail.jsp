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
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户信息管理 &gt; 客户信息 &gt; 历史订单 &gt; 订单明细 </div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="back();">返回</button>
        </div>
        <table class="query_form_table" height="59">
            <tr>
                <th>订单编号</th>
                <td>${sessionScope.o.odrId}</td>
                <th>日期</th>
                <td>${sessionScope.o.time}</td>
            </tr>
            <tr>
                <th height="28">送货地址</th>
                <td>${sessionScope.o.odrCustomer}</td>
                <th height="28">总金额（元）</th>
                <td>${sessionScope.o.money}</td>
            </tr>
            <tr>
                <th height="28">状态</th>
                <td>${sessionScope.o.status}</td>
                <th height="28">&nbsp;</th>
                <td>&nbsp;</td>
            </tr>
        </table>
        <br />


        <table id="ordersline" class="easyui-datagrid">
            <script type="text/javascript">
                $('#ordersline').datagrid({
                    pagination : true,
                    pageList : [2, 4, 6],
                    pageSize : 6,
                    idField : 'oddId',
                    singleSelect : true,
                    url : '/crm7/orderslineLQ/list',
                    columns : [[{
                        field : 'prodName',
                        title : '商品',
                        width : "250"
                    },{
                        field : 'oddCount',
                        title : '数量',
                        width : "150"
                    }, {
                        field : 'oddUnit',
                        title : '单位',
                        width : "150"
                    }, {
                        field : 'oddPrice',
                        title : '单价（元）',
                        width : "150"
                    }, {
                        field : 'money',
                        title : '金额（元）',
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