<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <td>KH071202001</td>
                <th>客户名称</th>
                <td>聪海信息科技有限公司</td>
            </tr>
        </table>
        <br />
        <table class="data_list_table">
            <tr>
                <th width="232">时间</th>
                <th>地点</th>
                <th>概要</th>
                <th>详细信息</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <tr>
                <td class="list_data_text" width="230">2007年10月09日</td>
                <td class="list_data_text">友谊宾馆</td>
                <td class="list_data_ltext">签订意向协议</td>
                <td class="list_data_ltext">...</td>
                <td class="list_data_op">
                    　</td>
                <td class="list_data_op">
                    <img onclick="to('activities_edit.html');" title="编辑" src="images/bt_edit.gif" class="op_button" />
                    <img onclick="del('“交往记录：签订意向协议”');" title="删除" src="images/bt_del.gif" class="op_button" />

                </td>
            </tr>
            <tr>
                <td class="list_data_text" width="230">2007年08月01日</td>
                <td class="list_data_text">公司</td>
                <td class="list_data_ltext">2008年行业展望座谈会</td>
                <td class="list_data_ltext">...</td>
                <td class="list_data_op">
                    主办单位:计算机报社</td>
                <td class="list_data_op">
                    <img onclick="to('activities_edit.html');" title="编辑" src="images/bt_edit.gif" class="op_button" />
                    <img onclick="del('“交往记录：签订意向协议”');" title="删除" src="images/bt_del.gif" class="op_button" />
                </td>
            </tr>
            <tr>
                <td class="list_data_text" width="230">2007年07月25日</td>
                <td class="list_data_text">公司</td>
                <td class="list_data_ltext">邀请到公司参观</td>
                <td class="list_data_ltext">...</td>
                <td class="list_data_op">
                    　</td>
                <td class="list_data_op">
                    <img onclick="to('activities_edit.html');" title="编辑" src="images/bt_edit.gif" class="op_button" />
                    <img onclick="del('“交往记录：签订意向协议”');" title="删除" src="images/bt_del.gif" class="op_button" />&nbsp;
                </td>
            </tr>
        </table>
    </div>
</div>
