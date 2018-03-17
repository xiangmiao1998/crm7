<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body onload="aa()">
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户服务分析</div>
        <div class="button_bar">
            <button class="common_button">帮助</button>
            <button class="common_button" onclick="aa()">查询</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>年份</th>
                <td>
                    <select id="yd">
                        <option>全部</option>
                        <option>2005</option>
                        <option>2006</option>
                        <option>2007</option>
                        <option>2008</option>
                        <option>2009</option>
                        <option>2010</option>
                        <option>2011</option>
                        <option>2012</option>
                        <option>2013</option>
                        <option>2014</option>
                        <option>2015</option>
                        <option>2016</option>
                        <option>2017</option>
                        <option>2018</option>
                    </select>
                </td>
                <th>&nbsp;</th>
                <td>
                    &nbsp;
                </td>
            </tr>
        </table>
        <br />
        <div id="chart2" style="width: 500px;"></div>
    </div>
</div>
</body>
</html>