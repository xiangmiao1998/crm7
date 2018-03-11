<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/xmjs/listSale.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">销售机会管理</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="to('add.html');">新建</button>
            <button id="listSale" class="common_button">查询</button>
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
        <table id="sale" class="data_list_table">

        </table>
        <div id="wu-saleAdd" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
            <form id="saleAdd" method="post">
            <table class="query_form_table">
                <tr>
                    <th>编号</th>
                    <td><input readonly /></td>
                    <th>机会来源</th>
                    <td>
                        <input type="text" name="chcSource" size="20" /></td>
                </tr>
                <tr>
                    <th>客户名称</th>
                    <td><input type="text" name="chcCustName"/><span class="red_star">*</span></td>
                    <th>成功机率</th>
                    <td><input type="text" name="chcRate"/><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>概要</th>
                    <td colspan="3"><input type="text" name="chcTitle" size="52" /><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>联系人</th>
                    <td><input type="text" name="chcLinkman" size="20" /></td>
                    <th>联系人电话</th>
                    <td><input type="text" name="chcTel" size="20" /></td>
                </tr>
                <tr>
                    <th>机会描述</th>
                    <td colspan="3"><textarea rows="6" cols="50" name="chcDesc"></textarea><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>创建人</th>
                    <td><input value="刘颖" readonly size="20" /><span class="red_star">*</span></td>
                    <th>创建时间</th>
                    <%
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date currentTime1 = new Date();
                        String time1 = simpleDateFormat1.format(currentTime1).toString();
                    %>
                    <td><input id="t1" value="<%=time1 %>" readonly size="20" /><span class="red_star">*</span></td>
                </tr>
            </table>
            </form>
        </div>

        <div id="wu-zhipai" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:550px; padding:10px;height: 200px">
            <form id="f-zhipai" method="post">
                <table class="query_form_table">
                    <tr>
                        <th>指派给</th>
                        <td>
                            <input class="easyui-combobox" id="cc" name="chcDueId" value="--请选择--" panelHeight="auto">
                            <span class="red_star">*</span></td>
                        <th>指派时间</th>
                        <td>
                            <%
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Date currentTime = new Date();
                                String time = simpleDateFormat.format(currentTime).toString();
                            %>
                            <input value="<%=time %>" readonly size="20" /><span class="red_star">*</span></td>
                    </tr>
                </table>
            </form>
        </div>

        <div id="wu-saleEdit" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
            <form id="saleEdit" method="post">
                <table class="query_form_table">
                    <tr>
                        <th>编号</th>
                        <td><input name="chcId" aria-readonly="true" /></td>
                        <th>机会来源</th>
                        <td>
                            <input type="text" name="chcSource" size="20" /></td>
                    </tr>
                    <tr>
                        <th>客户名称</th>
                        <td><input type="text" name="chcCustName"/><span class="red_star">*</span></td>
                        <th>成功机率</th>
                        <td><input type="text" name="chcRate"/><span class="red_star">*</span></td>
                    </tr>
                    <tr>
                        <th>概要</th>
                        <td colspan="3"><input type="text" name="chcTitle" size="52" /><span class="red_star">*</span></td>
                    </tr>
                    <tr>
                        <th>联系人</th>
                        <td><input type="text" name="chcLinkman" size="20" /></td>
                        <th>联系人电话</th>
                        <td><input type="text" name="chcTel" size="20" /></td>
                    </tr>
                    <tr>
                        <th>机会描述</th>
                        <td colspan="3"><textarea rows="6" cols="50" name="chcDesc"></textarea><span class="red_star">*</span></td>
                    </tr>
                    <tr>
                        <th>创建人</th>
                        <td><input value="刘颖" aria-readonly="true" size="20" /><span class="red_star">*</span></td>
                        <th>创建时间</th>
                        <td><input value="2018-03-10 16:44:30" aria-readonly="true" size="20" /><span class="red_star">*</span></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
