<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" onclick="back();">返回</button>
            <button class="common_button" onclick="save('list.html');">保存</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>编号</th>
                <td>1</td>
                <th>机会来源</th>
                <td>
                    　</td>
            </tr>
            <tr>
                <th>客户名称</th>
                <td>睿智电脑</td>
                <th>成功机率（%）</th>
                <td>&nbsp;70</td>
            </tr>
            <tr>
                <th>概要</th>
                <td colspan="3">采购笔记本电脑意向</td>
            </tr>
            <tr>
                <th>联系人</th>
                <td>刘先生</td>
                <th>联系人电话</th>
                <td>13729239239</td>
            </tr>
            <tr>
                <th>机会描述</th>
                <td colspan="3">...</td>
            </tr>
            <tr>
                <th>创建人</th>
                <td>刘颖</td>
                <th>创建时间</th>
                <td>2007年12月06日 16时09分08秒</td>
            </tr>
        </table>
        <br />
        <table class="query_form_table" id="table1">
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
            setCurTime('t2');
        </script>
    </div>
</div>
