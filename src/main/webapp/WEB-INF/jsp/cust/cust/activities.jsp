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
    <script type="text/javascript" src="js/lqjs/activity.js"></script>
</head>

<body>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="to('activities_add.html');">新建</button>
            <button class="common_button" onclick="back();">返回</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>客户编号</th>
                <td>${sessionScope.cust2.custNo}</td>
                <th>客户名称</th>
                <td>${sessionScope.cust2.custName}</td>
            </tr>
        </table>
        <br />
        <table id="activity" class="easyui-datagrid">
        </table>
    </div>


    <div id="activity_add_div" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
        <form id="activity_add_form" method="post">
            <table class="query_form_table">
                <tr>
                    <th>时间</th>
                    <td><input name="Date" class="easyui-datebox"/><span class="red_star">*</span></td>
                    <th>地点</th>
                    <td><input name="atvPlace" size="20" />
                        <span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>概要</th>
                    <td><input name="atvTitle"/><span class="red_star">*</span></td>
                    <th>备注</th>
                    <td><input name="atvRemark"/></td>
                </tr>
                <tr>
                    <th>详细信息</th>
                    <td colspan="3">
                        <textarea cols="50" rows="6" name="atvDesc"> </textarea>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div id="activity_edit_div" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
        <form id="activity_edit_from" method="post">
            <table class="query_form_table">
                <tr>
                    <th>时间</th>
                    <td><input name="atvId" type="hidden">
                        <input name="date" class="easyui-datebox" disabled="true"/><span class="red_star">*</span></td>
                    <th>地点</th>
                    <td><input name="atvPlace" size="20" />
                        <span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>概要</th>
                    <td><input name="atvTitle"/><span class="red_star">*</span></td>
                    <th>备注</th>
                    <td><input name="atvRemark"/></td>
                </tr>
                <tr>
                    <th>详细信息</th>
                    <td colspan="3">
                        <textarea cols="50" rows="6" name="atvDesc"> </textarea>
                    </td>
                </tr>
            </table>
        </form>
    </div>



</div>
</body>
</html>
