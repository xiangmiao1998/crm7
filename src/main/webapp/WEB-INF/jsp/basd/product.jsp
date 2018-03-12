<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/xmjs/listProd.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">产品查询</div>
        <div class="button_bar">
            <button class="common_button" id="list-prod">查询</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>名称</th>
                <td><input id="prodName"/></td>
                <th>型号</th>
                <td><input id="prodType"/></td>
                <th>批次</th>
                <td><input id="prodBatch"/></td>
            </tr>
        </table>
        <br />
        <table id="prod-ta" class="data_list_table">

        </table>
    </div>
</div>
