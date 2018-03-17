<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
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
