<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">销售机会管理&nbsp; &gt; 编辑销售机会</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="back();">返回</button>
            <button class="common_button" onclick="save('list.html');">保存</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>编号</th>
                <td><input readonly value="1" /></td>
                <th>机会来源</th>
                <td>
                    <input name="T4" size="20" /></td>
            </tr>
            <tr>
                <th>客户名称</th>
                <td><input value="睿智电脑" /><span class="red_star">*</span></td>
                <th>成功机率（%）</th>
                <td><input value="70" /><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>概要</th>
                <td colspan="3"><input value="采购笔记本电脑意向" name="T0" size="52" /><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>联系人</th>
                <td><input name="T21" value="刘先生" size="20" /></td>
                <th>联系人电话</th>
                <td><input name="T5" value="13729239239" size="20" /></td>
            </tr>
            <tr>
                <th>机会描述</th>
                <td colspan="3"><textarea rows="6" cols="50" name="S1">...</textarea><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>创建人</th>
                <td><input name="T19" value="刘颖" readonly size="20" /><span class="red_star">*</span></td>
                <th>创建时间</th>
                <td><input id="t1" name="T15" value="2007-12-6 16:09:8" readonly size="20" /><span class="red_star">*</span></td>
            </tr>
        </table>
        <br />
        <table disabled class="query_form_table" id="table1">
            <tr>
                <th>指派给</th>
                <td>
                    <select name="D1">
                        <option>请选择...</option>
                        <option>小明</option>
                        <option>旺财</option>
                        <option>球球</option>
                        <option>孙小美</option>
                        <option>周洁轮</option>
                    </select> <span class="red_star">*</span></td>
                <th>指派时间</th>
                <td>
                    <input id="t2" name="T20" readonly size="20" /><span class="red_star">*</span></td>
            </tr>
        </table>
        <script>
            setCurTime('t1');
            setCurTime('t2');
        </script>
    </div>
</div>
