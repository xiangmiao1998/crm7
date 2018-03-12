$(function () {
    $('#sale').datagrid({
        pagination: true,
        pageList: [2, 4, 6],
        pageSize: 6,
        idField: 'chcId',
        singleSelect: true,
        toolbar: [{
            iconCls: 'icon-Add',
            text: '新增',
            handler: function () {
                // $('#saleAdd').form('clear');
                $('#wu-saleAdd').dialog({
                    closed: false,
                    modal: true,
                    title: "添加信息",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function () {
                            $('#saleAdd').form('submit', {
                                url: 'sale/addSale',
                                success: function (data) {
                                    if (1 == data) {
                                        $.messager.alert('信息提示', '提交成功！', 'info');
                                        $('#wu-saleAdd').dialog('close');
                                        $("#sale").datagrid("reload");
                                    }
                                    else {
                                        $.messager.alert('信息提示', '提交失败！', 'info');
                                    }
                                }
                            });
                        }
                    }, {
                        text: '取消',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#wu-saleAdd').dialog('close');
                        }
                    }]
                });
            }
        }, '-', {
            iconCls: 'icon-Remove',
            text: '删除',
            handler: function () {
                // alert('删除按钮')
                var rows = $("#sale").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择要删除的记录');
                    return;
                }
                var chcDueId = rows.chcDueId;
                if (chcDueId) {
                    $.messager.alert('警告', '该记录已被指派,不可删除！');
                    return;
                }
                $.ajax({
                    url: 'holle/getUser',
                    data: '',
                    success: function (data) {
                        if (data.usrId != rows.chcCreateId) {
                            $.messager.alert('警告', '只允许创建人删除！');
                            return;
                        } else {
                            $.messager.confirm('确认', '您确定删除该行记录吗？', function (r) {
                                if (r) {
                                    var chcId = rows.chcId;
                                    var url = "sale/delSale?chcId=" + chcId;
                                    $.ajax({
                                        dataType: 'json',
                                        url: url,
                                        success: function (data) {
                                            if (1 == data) {
                                                $.messager.alert('提示', '删除成功！');
                                                var ind = $("#sale").datagrid("getRowIndex", chcId);
                                                $("#sale").datagrid("deleteRow", ind);
                                            } else {
                                                $.messager.alert('警告', '删除失败');
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    }
                });

            }
        }, '-', {
            iconCls: 'icon-edit',
            text: '修改',
            handler: function () {
                var rows = $("#sale").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择要修改的记录');
                    return;
                }
                var chcId = rows.chcId;
                var chcDueId = rows.chcDueId;
                if (chcDueId) {
                    $.messager.alert('警告', '该记录已被指派,不可修改！');
                    return;
                }
                $.ajax({
                    url: 'sale/loadSale?chcId=' + chcId,
                    data: '',
                    success: function (data) {
                        if (null != data) {
                            //绑定值
                            $('#saleEdit').form('load', data)
                        }
                        else {
                            $('#wu-saleEdit').dialog('close');
                        }
                    }
                });
                $('#wu-saleEdit').dialog({
                    closed: false,
                    modal: true,
                    title: "修改信息",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function () {
                            $('#saleEdit').form('submit', {
                                url: 'sale/editSale',
                                success: function (data) {
                                    if (data) {
                                        $.messager.alert('信息提示', '提交成功！', 'info');
                                        $('#wu-saleEdit').dialog('close');
                                        $("#sale").datagrid("reload");
                                    }
                                    else {
                                        $.messager.alert('信息提示', '提交失败！', 'info');
                                    }
                                }
                            });
                        }
                    }, {
                        text: '取消',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#wu-dictedit').dialog('close');
                        }
                    }]
                });
            }
        }, '-', {
            iconCls: 'icon-edit',
            text: '指派',
            handler: function () {
                var rows = $("#sale").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择要指派的记录');
                    return;
                }
                var chcId = rows.chcId;
                var chcDueId = rows.chcDueId;
                if (chcDueId) {
                    $.messager.alert('警告', '该记录已被指派！');
                    return;
                }
                $.ajax({
                    url: 'holle/getUser',
                    data: '',
                    success: function (data) {
                        if (data.usrRoleId != 2) {
                            $.messager.alert('警告', '此为销售主管权限！');
                            return;
                        } else {
                            $('#cc').combobox({
                                url: 'user/list',
                                method: "post",
                                valueField: "usrId",
                                textField: 'usrName'
                            });
                            $('#wu-zhipai').dialog({
                                closed: false,
                                modal: true,
                                buttons: [{
                                    text: '确定',
                                    iconCls: 'icon-ok',
                                    handler: function () {
                                        var url = "sale/doZhiPai?chcId=" + chcId;
                                        $('#f-zhipai').form('submit', {
                                            url: url,
                                            success: function (data) {
                                                if (1 == data) {
                                                    $.messager.alert('信息提示', '分配成功！', 'info');
                                                    $('#wu-zhipai').dialog('close');
                                                    $("#sale").datagrid("reload");
                                                }
                                                else {
                                                    $.messager.alert('信息提示', '分配失败！', 'info');
                                                }
                                            }
                                        });
                                    }
                                }, {
                                    text: '取消',
                                    iconCls: 'icon-cancel',
                                    handler: function () {
                                        $('#wu-zhipai').dialog('close');
                                    }
                                }]
                            });
                        }
                    }
                });
            }
        }],
        url: 'sale/listSale',
        columns: [[{
            field: 'chcId',
            title: '编号',
            width: "200"
        }, {
            field: 'chcCustName',
            title: '客户名称',
            width: "200"
        }, {
            field: 'chcTitle',
            title: '概要',
            width: "200"
        }, {
            field: 'chcLinkman',
            title: '联系人',
            width: "200"
        }, {
            field: 'chcTel',
            title: '联系电话',
            width: "200",
        }, {
            field: 'chcCreateId',
            hidden: true
        }, {
            field: 'chcDueId',
            hidden: true
        }]]

    });
    $("#listSale").click(function () {
        var formData = {
            chcCustName: $("#chcCustName").val(),
            chcTitle: $("#chcTitle").val(),
            chcLinkman: $("#chcLinkman").val()
        };
        $("#sale").datagrid({queryParams: formData});
        return false
    });

});



