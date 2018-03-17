<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="easyui-layout" data-options="fit:true">
    <div class="easyui-panel pd5" data-options="fit:true,border:true">
        <div class="page_title">客户流失管理</div>
        <div class="button_bar">
            <button class="common_button" onclick="help('');">帮助</button>
            <button class="common_button" id="listBtn">查询</button>
        </div>
        <table class="query_form_table">
            <tr>
                <th>客户</th>
                <td><input id="lstCustName"/></td>
                <th>客户经理</th>
                <td><input id="lstCustManagerName"/></td>
                <th>状态</th>
                <td><select name="custRegion" id="lstStatus">
                    <option value="">全部</option>
                    <option value="1">预警</option>
                    <option value="2">暂缓流失</option>
                    <option value="3">确认流失</option>
                </select>

                </td>
            </tr>
        </table>
        <br />
        <table id="lost" class="easyui-datagrid">
            <script type="text/javascript">
                $('#lost').datagrid({
                    pagination : true,
                    pageList : [2, 4, 6],
                    pageSize : 6,
                    idField : 'lstId',
                    singleSelect : true,
                    toolbar : [{
                        iconCls : 'icon-edit',
                        text : '确认流失',
                        handler : function() {
                            $('#lostf').form('clear');
                            var item = $('#lost').datagrid('getSelected');
                            if(!item){
                                $.messager.alert('警告', '请选择要流失的客户');
                                return;
                            }
                            var lstId = item.lstId;
                            var lstStatus=item.lstStatus;
                            if(lstStatus>=1&&lstStatus<2) {
                                $.messager.alert('警告', '该用户还未经过暂缓流失!');
                                return;
                            }
                            if(lstStatus>=3&&lstStatus<4){
                                $.messager.alert('警告', '该用户已确认流失!');
                                return;
                            }
                            $.ajax({
                                url:'lostLQ/loadBylstId?lstId='+ lstId,
                                data:'',
                                success:function(data){
                                    if(null!=data){
                                        //绑定值
                                        $('#lostf').form('load', data)
                                    }
                                    else{
                                        $('#lostd').dialog('close');
                                    }
                                }
                            });
                            $('#lostd').dialog({
                                closed: false,
                                modal:true,
                                title: "流失客户",
                                buttons: [{
                                    text: '确定',
                                    iconCls: 'icon-ok',
                                    handler: function() {
                                        $('#lostf').form('submit', {
                                            url:'lostLQ/edit1',
                                            success:function(data){
                                                if(data){
                                                    $.messager.alert('信息提示','流失成功！','info');
                                                    $('#lostd').dialog('close');
                                                    $("#lost").datagrid("reload");
                                                }
                                                else
                                                {
                                                    $.messager.alert('信息提示','流失失败！','info');
                                                }
                                            }
                                        });
                                    }
                                }, {
                                    text: '取消',
                                    iconCls: 'icon-cancel',
                                    handler: function () {
                                        $('#lostd').dialog('close');
                                    }
                                }]
                            });
                        }
                    },'-',{
                        iconCls : 'icon-edit',
                        text : '暂缓流失',
                        handler : function() {
                            $('#lostff').form('clear');
                            var item = $('#lost').datagrid('getSelected');
                            if(!item){
                                $.messager.alert('警告', '请选择要暂缓流失的客户');
                                return;
                            }
                            var lstId = item.lstId;
                            var lstStatus=item.lstStatus;

                            if(lstStatus>=3&&lstStatus<4){
                                $.messager.alert('警告', '该用户已确认流失!');
                                return;
                            }

                            $.ajax({
                                url:'lostLQ/loadBylstId?lstId='+ lstId,
                                data:'',
                                success:function(data){
                                    if(null!=data){
                                        //绑定值
                                        $('#lostff').form('load', data)
                                    }
                                    else{
                                        $('#lostdd').dialog('close');
                                    }
                                }
                            });
                            $('#lostdd').dialog({
                                closed: false,
                                modal:true,
                                title: "暂缓流失客户",
                                buttons: [{
                                    text: '确定',
                                    iconCls: 'icon-ok',
                                    handler: function() {
                                        $('#lostff').form('submit', {
                                            url:'lostLQ/edit2',
                                            success:function(data){
                                                if(data){
                                                    $.messager.alert('信息提示','暂缓流失成功！','info');
                                                    $('#lostdd').dialog('close');
                                                    $("#lost").datagrid("reload");
                                                }
                                                else
                                                {
                                                    $.messager.alert('信息提示','暂缓流失失败！','info');
                                                }
                                            }
                                        });
                                    }
                                }, {
                                    text: '取消',
                                    iconCls: 'icon-cancel',
                                    handler: function () {
                                        $('#lostdd').dialog('close');
                                    }
                                }]
                            });
                        }
                    }],
                    url : '/crm7/lostLQ/list',
                    columns : [[{
                        field : 'lstId',
                        title : '编号',
                        width : "150"
                    },{
                        field : 'lstCustName',
                        title : '客户',
                        width : "150"
                    }, {
                        field : 'lstCustManagerName',
                        title : '客户经理',
                        width : "150"
                    }, {
                        field : 'lstLastOrderDate',
                        title : '上次下单时间',
                        width : "150"
                    }, {
                        field : 'lstLostDate',
                        title : '确认流失时间',
                        width : "150"
                    }, {
                        field : 'status',
                        title : '状态',
                        width : "150"
                    }
                    ]]
                });

                $("#listBtn").click(function() {
                    var formData = {
                        lstCustName : $("#lstCustName").val(),
                        lstCustManagerName : $("#lstCustManagerName").val(),
                        lstStatus : $("#lstStatus").val()
                    };
                    $("#lost").datagrid({
                        queryParams : formData
                    });
                    return false
                });
            </script>
        </table>
    </div>



    <div id="lostd" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
        <form id="lostf" method="post">
            <table class="query_form_table">
                <tr>
                    <th>编号</th>
                    <td><input name="lstId"/></td>
                    <th>客户</th>
                    <td><input name="lstCustNo" type="hidden"><input name="lstCustName"/></td>
                </tr>
                <tr>
                    <th>客户经理</th>
                    <td><input name="lstCustManagerId" type="hidden"><input name="lstCustManagerName"/></td>
                    <th>上次下单时间</th>
                    <td><input name="time1" disabled="true"/></td>
                </tr>
                <tr>
                    <th>暂缓措施</th>
                    <td colspan="3">
                        <textarea rows="4" cols="30" name="lstDelay" disabled="true"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>流失原因</th>
                    <td colspan="3">
                        <textarea rows="6" cols="50" name="lstReason"></textarea><span class="red_star">*</span></td>
                </tr>
            </table>
        </form>
    </div>

    <div id="lostdd" class="easyui-dialog" data-options="closed:true,iconCls:'icon-save'" style="width:800px; padding:10px;height: 500px">
        <form id="lostff" method="post">
            <table class="query_form_table">
                <tr>
                    <th>编号</th>
                    <td><input name="lstId"/></td>
                    <th>客户</th>
                    <td><input name="lstCustNo" type="hidden"><input name="lstCustName"/></td>
                </tr>
                <tr>
                    <th>客户经理</th>
                    <td><input name="lstCustManagerId" type="hidden"><input name="lstCustManagerName"/></td>
                    <th>上次下单时间</th>
                    <td><input name="time1" disabled="true"/></td>
                </tr>
                <tr>
                    <th>暂缓措施</th>
                    <td colspan="3">
                        <textarea rows="4" cols="30" name="lstDelay"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>追加暂缓措施</th>
                    <td colspan="3">
                        <textarea rows="6" cols="50" name="zhuijia"></textarea><span class="red_star">*</span></td>
                </tr>
            </table>
        </form>
    </div>









</div>
