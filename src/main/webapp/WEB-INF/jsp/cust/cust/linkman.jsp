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
    <script type="text/javascript" src="js/lqjs/linkman.js"></script>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户信息管理 > 客户信息 > 联系人 </div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="to('linkman_add.html');">新建</button>
            <button class="common_button" onclick="back();">返回</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>客户编号</th>
                <td>${sessionScope.cust.custNo}</td>
                <th>客户名称</th>
                <td>${sessionScope.cust.custName}</td>
            </tr>
        </table>
        <br />
        <table id="linkman" class="easyui-datagrid">
        </table>
    </div>


    <div id="linkman_add" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
        <form id="add_linkman" method="post">
        <table class="query_form_table">
            <tr>
                <th>姓名</th>
                <td><input name="lkmName"/><span class="red_star">*</span></td>
                <th>性别</th>
                <td>
                    <input type="radio" name="lkmSex" checked value="男"/>男
                    <input type="radio" name="lkmSex" value="女"/>女
                </td>
            </tr>
            <tr>
                <th>职位</th>
                <td><input name="lkmPostion"/><span class="red_star">*</span></td>
                <th>办公电话</th>
                <td><input name="lkmTel"/><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>手机</th>
                <td><input name="lkmMobile" size="20" /></td>
                <th>备注</th>
                <td><input name="lkmMemo" size="20" /></td>
            </tr>
        </table>
        </form>
    </div>



    <div id="linkman_edit" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
        <form id="edit_linkman" method="post">
            <table class="query_form_table" id="table1">
                <tr>
                    <th>姓名</th>
                    <td><input name="lkmName"/><span class="red_star">*</span><input type="hidden" name="lkmId"></td>
                    <th>性别</th>
                    <td>
                        <input type="radio" name="lkmSex" checked value="男"/>男
                        <input type="radio" name="lkmSex" value="女"/>女
                    </td>
                </tr>
                <tr>
                    <th>职位</th>
                    <td><input name="lkmPostion"/><span class="red_star">*</span></td>
                    <th>办公电话</th>
                    <td><input name="lkmTel"/><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>手机</th>
                    <td><input name="lkmMobile" size="20" /></td>
                    <th>备注</th>
                    <td><input name="lkmMemo" size="20" /></td>
                </tr>
            </table>
        </form>
    </div>












</div>
</body>
</html>