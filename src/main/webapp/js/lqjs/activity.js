$(function() {
    $('#activity').datagrid({
        pagination : true,
        pageList : [2, 4, 6],
        pageSize : 6,
        idField : 'atvId',
        singleSelect : true,
        toolbar : [{
            iconCls : 'icon-Add',
            text : '新增',
            handler : function() {
                $('#activity_add_div').dialog({
                    closed: false,
                    modal:true,
                    title: "添加交往记录",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function() {
                            $('#activity_add_form').form('submit', {
                                url:'activityLQ/add',
                                success:function(data){
                                    if(1==data){
                                        $.messager.alert('信息提示','提交成功！','info');
                                        $('#activity_add_div').dialog('close');
                                        $("#activity").datagrid("reload");
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
                            $('#activity_add_div').dialog('close');
                        }
                    }]
                });
            }
        }, '-', {
            iconCls : 'icon-edit',
            text : '修改',
            handler : function() {
                $('#activity_edit_from').form('clear');
                var item = $('#activity').datagrid('getSelected');
                if(!item){
                    $.messager.alert('警告', '请选择要修改的交往记录');
                    return;
                }
                var atvId = item.atvId;
                $.ajax({
                    url:'activityLQ/loadBylatvId?atvId='+ atvId,
                    data:'',
                    success:function(data){
                        if(null!=data){
                            //绑定值
                            $('#activity_edit_from').form('load', data)
                        }
                        else{
                            $('#activity_edit_div').dialog('close');
                        }
                    }
                });
                $('#activity_edit_div').dialog({
                    closed: false,
                    modal:true,
                    title: "修改联系人",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function() {
                            $('#activity_edit_from').form('submit', {
                                url:'activityLQ/edit',
                                success:function(data){
                                    if(data){
                                        $.messager.alert('信息提示','修改成功！','info');
                                        $('#activity_edit_div').dialog('close');
                                        $("#activity").datagrid("reload");
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
                            $('#activity_edit_div').dialog('close');
                        }
                    }]
                });
            }
        }, '-', {
            iconCls : 'icon-Remove',
            text : '删除',
            handler : function() {
                // alert('删除按钮')
                var rows = $("#activity").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择要删除的联系人');
                    return;
                }
                $.messager.confirm('确认', '您确定删除该联系人吗？', function(r) {
                    if (r) {
                        var atvId = rows.atvId;
                        var url = "activityLQ/del?atvId="+ atvId;
                        $.ajax({
                            dataType : 'json',
                            url : url,
                            success : function(data) {
                                if (data) {
                                    $.messager.alert('信息提示','删除成功！','info');
                                    $("#activity").datagrid("reload");
                                } else {
                                    $.messager.alert('警告', '删除失败');
                                }
                            }
                        });
                    }
                });
            }
        }],

        url : '/crm7/activityLQ/list',
        columns : [[{
            field : 'atvDate',
            title : '时间',
            width : "150"
        },{
            field : 'atvPlace',
            title : '地点',
            width : "150"
        }, {
            field : 'atvTitle',
            title : '概要',
            width : "150"
        }, {
            field : 'atvDesc',
            title : '详细信息',
            width : "150"
        }, {
            field : 'atvRemark',
            title : '备注',
            width : "150"
        }
        ]]

    });


});