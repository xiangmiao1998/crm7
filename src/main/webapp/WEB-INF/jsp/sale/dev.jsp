<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/xmjs/SalPlan.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户开发计划</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" id="listPlan">查询</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>客户名称</th>
                <td><input id="chcCustName"/></td>
                <th>概要</th>
                <td><input id="chcTitle"/></td>
                <th>联系人</th>
                <td>
                    <input name="chcLinkman" size="20" />
                </td>
            </tr>
        </table>
        <br />
        <table id="salPlan" class="data_list_table">

        </table>
        <%--制定计划--%>
        <div id="wu-salPlan" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:900px; padding:10px;height: 650px">
            <form id="saleChance" method="post">
            <table class="query_form_table">
            <tr>
                <th>编号</th>
                <td><input name="chcId" readonly/></td>
                <th>机会来源</th>
                <td><input name="chcSource" readonly/></td>
            </tr>
            <tr>
                <th>客户名称</th>
                <td><input name="chcCustName" readonly/></td>
                <th>成功机率（%）</th>
                <td><input name="chcRate" readonly/></td>
            </tr>
            <tr>
                <th>概要</th>
                <td colspan="3"><textarea name="chcTitle" readonly rows="3"/></td>
            </tr>
            <tr>
                <th>联系人</th>
                <td><input name="chcLinkman" readonly/></td>
                <th>联系人电话</th>
                <td><input name="chcTel" readonly/></td>
            </tr>
            <tr>
                <th>机会描述</th>
                <td colspan="3"><textarea name="chcDesc" rows="3" readonly/></td>
            </tr>
            <tr>
                <th>创建人</th>
                <td><input name="chcCreateBy" readonly/></td>
                <th>创建时间</th>
                <td><input name="chcCreateDate" readonly/></td>
            </tr>
            <tr>
                <th>指派给</th>
                <td><input name="chcDueTo" readonly/></td>
                <th>指派时间</th>
                <td><input name="chcDueDate" readonly/></td>
            </tr>
        </table>
        </form>
        <br />
        <table class="data_list_table" id="table1">
            <tr>
                <th width="150px">日期</th>
                <th height="31">计划项</th>
            </tr>
        </table>
            <div class="button_bar">
                <button class="common_button" id="plan-save-btn">保存</button>
            </div>
            <table class="query_form_table" id="table2">
                <tr>
                    <th>日期</th>
                    <td><input type="text" id="plaDate" class="easyui-datebox"/><span class="red_star">*</span></td>
                    <th>计划项</th>
                    <td>
                        <input size="50" id="plaTodo" /><span class="red_star">*</span>
                    </td>
                </tr>
            </table>
        </div>


        <%--处理计划--%>
        <div id="wu-doPlan" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:900px; padding:10px;height: 650px">
            <form id="f-doChanceLoad" method="post">
                <table class="query_form_table">
                    <tr>
                        <th>编号</th>
                        <td><input name="chcId" readonly/></td>
                        <th>机会来源</th>
                        <td><input name="chcSource" readonly/></td>
                    </tr>
                    <tr>
                        <th>客户名称</th>
                        <td><input name="chcCustName" readonly/></td>
                        <th>成功机率（%）</th>
                        <td><input name="chcRate" readonly/></td>
                    </tr>
                    <tr>
                        <th>概要</th>
                        <td colspan="3"><textarea name="chcTitle" readonly rows="3"/></td>
                    </tr>
                    <tr>
                        <th>联系人</th>
                        <td><input name="chcLinkman" readonly/></td>
                        <th>联系人电话</th>
                        <td><input name="chcTel" readonly/></td>
                    </tr>
                    <tr>
                        <th>机会描述</th>
                        <td colspan="3"><textarea name="chcDesc" rows="3" readonly/></td>
                    </tr>
                    <tr>
                        <th>创建人</th>
                        <td><input name="chcCreateBy" readonly/></td>
                        <th>创建时间</th>
                        <td><input name="chcCreateDate" readonly/></td>
                    </tr>
                    <tr>
                        <th>指派给</th>
                        <td><input name="chcDueTo" readonly/></td>
                        <th>指派时间</th>
                        <td><input name="chcDueDate" readonly/></td>
                    </tr>
                </table>
            </form>
            <br />
            <table class="data_list_table" id="doPlanList">

            </table>
        </div>
    </div>
</div>
