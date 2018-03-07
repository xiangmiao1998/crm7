<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">数据字典管理 > 编辑数据字典条目</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="back();">返回</button>
            <button class="common_button" onclick="save('dict.html');">保存</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>编号</th>
                <td>9</td>
                <th>类别</th>
                <td><input value="服务类型" /><span class="red_star">*</span><br />（需要使用Ajax实现自动补全功能）</td>
            </tr>
            <tr>
                <th>条目</th>
                <td><input value="咨询" /><span class="red_star">*</span></td>
                <th>值</th>
                <td><input value="咨询" /><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>是否可编辑</th>
                <td><input type="checkbox" checked /></td>
                <th>&nbsp;</th>
                <td>&nbsp;</td>
            </tr>
        </table>
    </div>
</div>
