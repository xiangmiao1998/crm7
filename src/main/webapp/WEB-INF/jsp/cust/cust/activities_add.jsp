<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="back();">返回</button>
            <button class="common_button" onclick="add('activities.html');">保存</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>时间</th>
                <td><input /><span class="red_star">*</span></td>
                <th>地点</th>
                <td>
                    <input name="T1" size="20" /><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>概要</th>
                <td><input /><span class="red_star">*</span></td>
                <th>备注</th>
                <td><input /></td>
            </tr>
            <tr>
                <th>详细信息</th>
                <td colspan="3">
                    <textarea cols="50" rows="6"> </textarea>
                </td>
            </tr>
        </table>

    </div>
</div>

