<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">

    <script type="text/javascript">
        function add(){
            $('#sb').form('submit', {
                url:'service/add',
                success:function(data){
                    if(data){
                        $.messager.alert('信息提示','提交成功！','info');
                    }
                    else
                    {
                        $.messager.alert('信息提示','提交失败！','info');
                    }
                }
            });
        }

    </script>
    <form id="sb" method="post">
    <table class="query_form_table">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户服务管理 > 服务创建</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" type="button" onclick="add()">保存</button>
        </div>
            <tr>
                <th>编号</th>
                <td><input disabled name="svrId" value="自动生成"/></td>
                <th>服务类型</th>
                <td>
                    <select name="svrType">
                        <option>请选择...</option>
                        <option>咨询</option>
                        <option>投诉</option>
                        <option>建议</option>
                    </select><span class="red_star">*</span>
                </td>
            </tr>
            <tr>
                <th>概要</th>
                <td colspan="3"><input size="53" name="svrTitle"/><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>客户</th>
                <td><input name="svrCustName" size="20" /><span class="red_star">*</span></td>
                <th>状态</th>
                <td>新创建</td>
            </tr>
            <tr>
                <th>服务请求</th>
                <td colspan="3"><textarea rows="6" cols="50" name="svrRequest"></textarea><span class="red_star">*</span></td>
            </tr>
            <tr>
                <th>创建人</th>
                <td><input value="admin" readonly size="20" /><span class="red_star">*</span></td>
                <th>创建时间</th>
                <td><input id="t1" readonly size="20" /><span class="red_star">*</span></td>
            </tr>
        </table>
        </form>
        <br />

        <script>
            setCurTime('t1');
            setCurTime('t2');
            setCurTime('t3');
        </script>
    </div>
</div>
