<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/zhou/listService.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户服务管理 > 服务分配</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" id="load">查询</button>
        </div>
        <table class="query_form_table" height="53">
            <tr>
                <th height="28">客户</th>
                <td><input id="svrCustName"/></td>
                <th height="28">概要</th>
                <td><input id="svrTitle"/></td>
                <th height="28">服务类型</th>
                <td>
                    <select id="svrType">
                        <option>全部</option>
                        <option>咨询</option>
                        <option>建议</option>
                        <option>投诉</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th height="22">创建日期</th>
                <td colspan="3">
                    <input id="svrCreateDate1" size="10" class="easyui-datebox"/> - <input id="svrCreateDate2" size="10" class="easyui-datebox"/></td>

                <th height="22">状态</th>
                <td colspan="2">
                    <select id="svrStatus">
                        <option selected>全部</option>
                        <option>新创建</option>
                    </select>
                </td>
            </tr>
        </table>
        <br/>
        <table id="dog">

        </table>

        <div id="wu-fenpei" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width: 650px;padding: 3px;padding:3px;height: 300px">
        <form id="fp" method="post"><input style="align:content" class="easyui-combobox" id="cc" name="svrDueId" value="--请选择--" panelHeight="auto"/></form>
        </div>
    </div>
</div>

