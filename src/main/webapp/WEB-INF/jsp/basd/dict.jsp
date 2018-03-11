<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/xmjs/listDict.js"></script>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">数据字典管理</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="openAdd()">新建</button>
            <button class="common_button" id="listBtn">查询</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>类别</th>
                <td><input id="dictType" /></td>
                <th>条目</th>
                <td><input id="dictItem" /></td>
                <th>值</th>
                <td><input id="dictValue" /></td>
            </tr>
        </table>
        <br />
        <table id="ta" class="easyui-datagrid">

        </table>
        <div id="wu-dictAdd" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
            <form id="wu-add" method="post">
                    <table class="query_form_table">
                        <tr>
                            <th>编号</th>
                            <td><input readonly /></td>
                            <th>类别</th>
                            <td><input type="text" name="dictType"/><span class="red_star">*</span><br />（需要使用Ajax实现自动补全功能）</td>
                        </tr>
                        <tr>
                            <th>条目</th>
                            <td><input type="text" name="dictItem" /><span class="red_star">*</span></td>
                            <th>值</th>
                            <td><input type="text" name="dictValue" /><span class="red_star">*</span></td>
                        </tr>
                        <tr>
                            <th>是否可编辑</th>
                            <td><input name="dictIsEditable" type="checkbox" checked="true" /></td>
                            <th>&nbsp;</th>
                            <td>&nbsp;</td>
                        </tr>
                    </table>
            </form>
        </div>


        <div id="wu-dictedit" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
            <form id="wu-edit" method="post">
                <table class="query_form_table">
                    <tr>
                        <th>编号</th>
                        <td><input name="dictId" aria-readonly="true" /></td>
                        <th>类别</th>
                        <td><input type="text" name="dictType"/><span class="red_star">*</span><br />（需要使用Ajax实现自动补全功能）</td>
                    </tr>
                    <tr>
                        <th>条目</th>
                        <td><input type="text" name="dictItem" /><span class="red_star">*</span></td>
                        <th>值</th>
                        <td><input type="text" name="dictValue" /><span class="red_star">*</span></td>
                    </tr>
                    <tr>
                        <th>是否可编辑</th>
                        <td><input name="dictIsEditable" type="checkbox" checked="true" /></td>
                        <th>&nbsp;</th>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

