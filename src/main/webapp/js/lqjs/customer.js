$(function() {
    $('#customer').datagrid({
        pagination : true,
        pageList : [5,10,15, 20],
        pageSize : 10,
        idField: 'custNo',
        singleSelect : true,
        toolbar: [{
            iconCls : 'icon-edit',
            text : '修改',
            handler : function() {
                $('#custf').form('clear');
                var item = $('#customer').datagrid('getSelected');
                if(!item){
                    $.messager.alert('警告', '请选择要修改/查看的客户');
                    return;
                }
                var custNo = item.custNo;
                var custStatus=item.custStatus;
                if(custStatus!=1){
                    $.messager.alert('警告', '该客户暂时不能修改!');
                    return;
                }
                    $.ajax({
                        url:'customerLQ/loadBycustNo?custNo='+ custNo,
                        data:'',
                        success:function(data){
                            if(null!=data){
                                //绑定值
                                $('#custf').form('load', data)
                            }
                            else{
                                $('#custd').dialog('close');
                            }
                        }
                    });
                $('#custd').dialog({
                    closed: false,
                    modal:true,
                    title: "修改联系人",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function() {
                            $('#custf').form('submit', {
                                url:'customerLQ/edit',
                                success:function(data){
                                    if(data){
                                        $.messager.alert('信息提示','修改成功！','info');
                                        $('#custd').dialog('close');
                                        $("#customer").datagrid("reload");
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
                            $('#custd').dialog('close');
                        }
                    }]
                });
            }
        }, '-', {
            iconCls : 'icon-users',
            text : '联系人',
            handler : function() {
                var rows = $("#customer").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择客户！');
                    return;
                }
                var custNo = rows.custNo;
                parent.addTab('联系人', 'linkmanLQ/look?custNo='+custNo,'icon-users',true);
            }
        }, '-', {
            iconCls : 'icon-book',
            text : '交往记录',
            handler : function() {
                var rows = $("#customer").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择客户！');
                    return;
                }
                var custNo = rows.custNo;
                parent.addTab('交往记录', 'activityLQ/look?custNo='+custNo,'icon-book',true);
            }
        }, '-', {
            iconCls : 'icon-cart',
            text : '历史订单',
            handler : function() {
                var rows = $("#customer").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择客户！');
                    return;
                }
                var custNo = rows.custNo;
                parent.addTab('历史订单', 'ordersLQ/look?custNo='+custNo);
            }
        }, '-', {
            iconCls : 'icon-Remove',
            text : '删除',
            handler : function() {
                // alert('删除按钮')
                var rows = $("#customer").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择要删除的记录！');
                    return;
                }
                $.messager.confirm('确认', '您确定删除该行记录吗？', function(r) {
                    if (r) {
                        var custNo = rows.custNo;
                        var url = "customerLQ/del?custNo="+custNo;
                        $.ajax({
                            dataType : 'json',
                            url : url,
                            success : function(data) {
                                if (data) {
                                    $.messager.alert('信息提示','客户删除成功！','info');
                                    $("#customer").datagrid("reload");
                                } else {
                                    $.messager.alert('警告', '客户删除失败');
                                }
                            }
                        });
                    }
                });
            }
        }],

        url: '/crm7/customerLQ/list',
        columns: [[
            {
                checkbox: true
            }, {
                field: 'custNo',
                title: '客户编号',
                width: 180
            }, {
                field: 'custName',
                title: '名称',
                width: 180
            }, {
                field: 'custRegion',
                title: '地区',
                width: 100
            }, {
                field: 'custManagerName',
                title: '客户经理',
                width: 100
            }, {
                field: 'custLevelLabel',
                title: '客户等级',
                width: 100
            }, {
                field: 'status',
                title: '状态是否正常',
                width: 100
            }]]
    });
    $("#customercx").click(function() {
        var formData = {
            custNo : $("#cuNo").val(),
            custName : $("#cuName").val(),
            custRegion : $("#cuRegion").val(),
            custManagerName : $("#cuManagerName").val(),
            custLevelLabel : $("#cuLevelLabel").val()
        };
        $("#customer").datagrid({queryParams : formData});
        return false
    });
});