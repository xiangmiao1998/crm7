<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户信息管理 > 客户信息 > 联系人 > 新建联系人</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="back();">返回</button>
            <button class="common_button" onclick="add('linkman.html');">保存</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>姓名</th>
                <td><input /><span class="red_star">*</span></td>
                <th>性别</th>
                <td>
                    <input type="radio" name="gander" checked />男
                    <input type="radio" name="gander" />女
                </td>
            </tr>
            <tr>
                <th>职位</th>
                <td><input /><span class="red_star">*</span></td>
                <th>办公电话</th>
                <td><input /><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>手机</th>
                <td><input name="T1" size="20" /></td>
                <th>备注</th>
                <td><input name="T2" size="20" /></td>
            </tr>
        </table>
    </div>
</div>
