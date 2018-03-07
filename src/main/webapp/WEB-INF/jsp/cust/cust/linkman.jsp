<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <td>KH071202001</td>
                <th>客户名称</th>
                <td>聪海信息科技有限公司</td>
            </tr>
        </table>
        <br />
        <table class="data_list_table">
            <tr>
                <th>姓名</th>
                <th>性别</th>
                <th>职位</th>
                <th>办公电话</th>
                <th>手机</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <tr>
                <td class="list_data_text">沈聪林</td>
                <td class="list_data_ltext">男</td>
                <td class="list_data_text">总经理</td>
                <td class="list_data_text">010-68348438-668</td>
                <td class="list_data_text">13622883228</td>
                <td class="list_data_op">
                    　</td>
                <td class="list_data_op">
                    <img onclick="to('linkman_edit.html');" title="编辑" src="images/bt_edit.gif" class="op_button" />
                    <img onclick="del('“联系人：沈聪林”');" title="删除" src="images/bt_del.gif" class="op_button" />

                </td>
            </tr>
            <tr>
                <td class="list_data_text">杨影</td>
                <td class="list_data_ltext">女</td>
                <td class="list_data_text">总经理助理</td>
                <td class="list_data_text">010-68348438-326</td>
                <td class="list_data_text">13728838283</td>
                <td class="list_data_op">
                    　</td>
                <td class="list_data_op">
                    <img onclick="to('linkman_edit.html');" title="编辑" src="images/bt_edit.gif" class="op_button" />
                    <img onclick="del('“联系人：杨影”');" title="删除" src="images/bt_del.gif" class="op_button" />
                </td>
            </tr>
            <tr>
                <td class="list_data_text">詹兆辉</td>
                <td class="list_data_ltext">男</td>
                <td class="list_data_text">供销部经理</td>
                <td class="list_data_text">010-68348438-520</td>
                <td class="list_data_text">13622883235</td>
                <td class="list_data_op">
                    　</td>
                <td class="list_data_op">
                    <img onclick="to('linkman_edit.html');" title="编辑" src="images/bt_edit.gif" class="op_button" />
                    <img onclick="del('“联系人：詹兆辉”');" title="删除" src="images/bt_del.gif" class="op_button" />&nbsp;
                </td>
            </tr>
        </table>
    </div>
</div>
