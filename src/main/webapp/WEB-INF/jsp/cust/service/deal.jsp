<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/zhou/listDeal.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户服务管理 &gt; 服务处理</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" id="load">查询</button>
        </div>
        <table class="query_form_table">
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
                <th height="32">创建日期</th>
                <td colspan="3">
                    <input  size="10" id="svrCreateDate1" class="easyui-datebox"/> - <input id="svrCreateDate2" size="10" class="easyui-datebox"/></td>
                <th height="32">状态</th>
                <td>
                    <select name="svrStatus">
                        <option>已分配</option>
                    </select>
                </td>
            </tr>
        </table>
        <br />
        <table id="deal">

        </table>

        <!--弹出框-->
        <div id="wu-deal" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width: 650px;padding: 3px;padding:3px;height: 300px">
            <form id="chuli" method="post">
            <table class="query_form_table">
                <tr>
                    <th>编号</th>
                    <td><input type="text" name="svrId"/></td>
                    <th>服务类型</th>
                    <td>
                    <input type="text" name="svrType"/></td>
                </tr>
                <tr>
                    <th>概要</th>
                    <td colspan="3"> <input type="text" name="svrTitle"/></td>
                </tr>
                <tr>
                    <th>客户</th>
                    <td><input type="text" name="svrCustName"/></td>
                    <th>状态</th>
                    <td><input type="text" name="svrStatus"/></td>
                </tr>
                <tr>
                    <th>服务请求</th>
                    <td colspan="3"><input type="text" name="svrRequest"/><br>
                        　</td>
                </tr>
                <tr>
                    <th>创建人</th>
                    <td><input type="text" aria-readonly="true" name="svrCreateBy"/></td>
                </tr>
            </table>
            <br />
            <table class="query_form_table" id="table3">
                <tr>
                    <th>分配给</th>
                    <td>
                    <input type="text" name="svrDueTo"/></td>

            </table>
            <br />
            <table class="query_form_table" id="table1">
                <tr>
                    <th>服务处理</th>
                    <td colspan="3"><textarea rows="6" cols="50" id="svrDeal"></textarea><span class="red_star">*</span></td>
                </tr>
                <tr>
                    <th>处理人</th>
                    <td><input  size="20"  name="svrDealBy" value=""/><span class="red_star">*</span></td>

                </tr>
            </table>
            <br />

            </form>

        </div>

    </div>
</div>