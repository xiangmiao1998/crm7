<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/xmjs/listStor.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">产品查询</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" id="list-stro">查询</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>产品</th>
                <td><input id="pName"/></td>
                <th>仓库</th>
                <td><input id="stkWarehouse"/></td>
                <th>&nbsp;</th>
                <td>&nbsp;</td>
            </tr>
        </table>
        <br />
        <table id="stro-ta" class="data_list_table">

        </table>
    </div>
</div>
