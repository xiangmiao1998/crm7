$(function() {
    $('#linkman').datagrid({
        pagination : true,
        pageList : [2, 4, 6],
        pageSize : 6,
        idField : 'lkmId',
        singleSelect : true,
        toolbar : [{
            iconCls : 'icon-Add',
            text : '新增',
            handler : function() {
                $('#linkman_add').dialog({
                    closed: false,
                    modal:true,
                    title: "添加联系人",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function() {
                            $('#add_linkman').form('submit', {
                                url:'linkmanLQ/add',
                                success:function(data){
                                    if(1==data){
                                        $.messager.alert('信息提示','提交成功！','info');
                                        $('#linkman_add').dialog('close');
                                        $("#linkman").datagrid("reload");
                                    }
                                    else
                                    {
                                        $.messager.alert('信息提示','提交失败！','info');
                                    }
                                }
                            });
                        }
                    }, {
                        text: '取消',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#linkman_add').dialog('close');
                        }
                    }]
                });
            }
        }, '-', {
            iconCls : 'icon-edit',
            text : '修改',
            handler : function() {
                $('#edit_linkman').form('clear');
                var item = $('#linkman').datagrid('getSelected');
                if(!item){
                    $.messager.alert('警告', '请选择要修改的联系人');
                    return;
                }
                var lkmId = item.lkmId;
                $.ajax({
                    url:'linkmanLQ/loadBylkmId?lkmId='+ lkmId,
                    data:'',
                    success:function(data){
                        if(null!=data){
                            //绑定值
                            $('#edit_linkman').form('load', data)
                        }
                        else{
                            $('#linkman_edit').dialog('close');
                        }
                    }
                });
                $('#linkman_edit').dialog({
                    closed: false,
                    modal:true,
                    title: "修改联系人",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function() {
                            $('#edit_linkman').form('submit', {
                                url:'linkmanLQ/edit',
                                success:function(data){
                                    if(data){
                                        $.messager.alert('信息提示','修改成功！','info');
                                        $('#linkman_edit').dialog('close');
                                        $("#linkman").datagrid("reload");
                                    }
                                    else
                                    {
                                        $.messager.alert('信息提示','修改失败！','info');
                                    }
                                }
                            });
                        }
                    }, {
                        text: '取消',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#linkman_edit').dialog('close');
                        }
                    }]
                });
            }
        }, '-', {
            iconCls : 'icon-Remove',
            text : '删除',
            handler : function() {
                // alert('删除按钮')
                var rows = $("#linkman").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择要删除的记录');
                    return;
                }
                $.messager.confirm('确认', '您确定删除该行记录吗？', function(r) {
                    if (r) {
                        var lkmId = rows.lkmId;
                        var url = "linkmanLQ/del?lkmId="+ lkmId;
                        $.ajax({
                            dataType : 'json',
                            url : url,
                            success : function(data) {
                                if (data) {
                                    $.messager.alert('信息提示','删除成功！','info');
                                    $("#linkman").datagrid("reload");
                                } else {
                                    $.messager.alert('警告', '删除失败');
                                }
                            }
                        });
                    }
                });
            }
        }],

        url : '/crm7/linkmanLQ/list',
        columns : [[{
            field : 'lkmName',
            title : '姓名',
            width : "150"
        },{
            field : 'lkmSex',
            title : '性别',
            width : "150"
        }, {
            field : 'lkmPostion',
            title : '职位',
            width : "150"
        }, {
            field : 'lkmTel',
            title : '办公电话',
            width : "150"
        }, {
            field : 'lkmMobile',
            title : '手机',
            width : "150"
        }, {
            field : 'lkmMemo',
            title : '备注',
            width : "150"
        }
        ]]

    });


});