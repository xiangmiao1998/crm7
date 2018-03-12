$(function () {
    $('#salPlan').datagrid({
        pagination: true,
        pageList: [2, 4, 6],
        pageSize: 6,
        idField: 'chcId',
        singleSelect: true,
        toolbar: [{
            iconCls: 'icon-save',
            text: '开发成功',
            handler: function () {
                var rows = $("#salPlan").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择行');
                    return;
                }
                var chcId = rows.chcId;
                $.ajax({
                    url: 'sale/kfcg?chcId=' + chcId,
                    data: '',
                    success: function (data) {
                        if (1 == data) {
                            $.messager.alert('警告', '开发成功，保存一条新纪录！');
                            $("#salPlan").datagrid("reload");
                        } else {
                            $.messager.alert('警告', '保存失败！');
                        }
                    }
                });
            }
        }, '-', {
            iconCls: 'icon-cancel',
            text: '终止开发',
            handler: function () {
                var rows = $("#salPlan").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择行');
                    return;
                }
                var chcId = rows.chcId;
                $.ajax({
                    url: "sale/edit?chcId=" + chcId + "&&chcStatus='开发失败'",
                    data: '',
                    success: function () {

                    }
                });
            }
        }, '-', {
            iconCls: 'icon-add',
            text: '制定计划',
            handler: function () {
                var rows = $("#salPlan").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择行');
                    return;
                }
                var chcId = rows.chcId;
                $.ajax({
                    url: 'sale/loadSale?chcId=' + chcId,
                    data: '',
                    success: function (data) {
                        if (data != null) {
                            //绑定值
                            $('#saleChance').form('load', data)
                        }
                        else {
                            $('#wu-salPlan').dialog('close');
                        }

                    }
                });
                $('#table1').datagrid({
                    pagination: true,
                    pageList: [2, 4, 6],
                    pageSize: 6,
                    idField: 'plaId',
                    singleSelect: true,
                    toolbar: [{
                        iconCls: 'icon-remove',
                        text: '删除计划',
                        handler: function () {
                            var rows = $("#table1").datagrid("getSelected");
                            if (!rows) {
                                $.messager.alert('警告', '请选择要删除的计划！');
                                return;
                            }
                            $.messager.confirm('确认', '您确定删除该条计划吗？', function (r) {
                                if (r) {
                                    var plaId = rows.plaId;
                                    var planUrl = "salPlan/del?plaId=" + plaId;
                                    $.ajax({
                                        dataType: 'json',
                                        url: planUrl,
                                        success: function (data) {
                                            if (1 == data) {
                                                $.messager.alert('提示', '删除成功');
                                                var ind = $("#table1").datagrid("getRowIndex", plaId);
                                                $("#table1").datagrid("deleteRow", ind);
                                            } else {
                                                $.messager.alert('警告', '删除失败');
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    }],
                    url: 'salPlan/list?plaChcId=' + chcId,
                    columns: [[{
                        field: 'plaDate',
                        title: '日期',
                        width: "150"
                    }, {
                        field: 'plaTodo',
                        title: '计划内容',
                        width: "300"
                    }, {
                        field: 'plaId',
                        hidden: true
                    }]]
                });
                $('#wu-salPlan').dialog({
                    closed: false,
                    modal: true,
                });
                $("#plan-save-btn").click(function () {
                    var plaDate = $("#plaDate").datebox("getValue");
                    var plaTodo = $("#plaTodo").val();
                    $.ajax({
                        url: 'salPlan/add?plaChcId=' + chcId + '&Date=' + plaDate + '&plaTodo=' + plaTodo,
                        data: '',
                        success: function (data) {
                            if (1 == data) {
                                $.messager.alert('信息提示', '保存成功！', 'info');
                                $("#table1").datagrid("reload");
                                $(" #plaTodo").val("");
                            } else {
                                $.messager.alert('警告', '保存失败！');
                            }
                        }
                    });
                });
            }
        }, '-', {
            iconCls: 'icon-edit',
            text: '执行计划',
            handler: function () {
                var rows = $("#salPlan").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择要处理的记录！');
                    return;
                }
                var chcId = rows.chcId;
                $('#wu-doPlan').dialog({
                    closed: false,
                    modal: true
                });
                $.ajax({
                    url: 'sale/loadSale?chcId=' + chcId,
                    data: '',
                    success: function (data) {
                        if (data != null) {
                            //绑定值
                            $('#f-doChanceLoad').form('load', data)
                        }
                        else {
                            $('#wu-doPlan').dialog('close');
                        }

                    }
                });
                $('#doPlanList').datagrid({
                    pagination: true,
                    pageList: [2, 4, 6],
                    pageSize: 6,
                    idField: 'plaId',
                    singleSelect: true,
                    toolbar: [{
                        iconCls: 'icon-save',
                        text: '执行计划',
                        handler: function () {
                            var rows = $("#doPlanList").datagrid("getSelected");
                            if (!rows) {
                                $.messager.alert('警告', '请选择要执行的计划！');
                                return;
                            }
                            var plaResult = prompt("请输入处理结果", "");
                            var plaId = rows.plaId;
                            var planUrl = "salPlan/edit?plaId=" + plaId + "&&plaResult=" + plaResult;
                            $.ajax({
                                dataType: 'json',
                                url: planUrl,
                                success: function (data) {
                                    if (1 == data) {
                                        $("#doPlanList").datagrid("reload");
                                    } else {
                                        $.messager.alert('警告', '结果上传失败！');
                                    }
                                }
                            });
                        }
                    }],
                    url: 'salPlan/list?plaChcId=' + chcId,
                    columns: [[{
                        field: 'plaDate',
                        title: '日期',
                        width: "150"
                    }, {
                        field: 'plaTodo',
                        title: '计划内容',
                        width: "300"
                    }, {
                        field: 'plaResult',
                        title: '执行结果',
                        width: '300'
                    }, {
                        field: 'plaId',
                        hidden: true
                    }]]
                });
            }
        }],
        url: "sale/listSale?chcStatus='未指派'&&panduan=plan",
        columns: [[{
            field: 'chcId',
            title: '编号',
            width: '100'
        }, {
            field: 'chcCustName',
            title: '客户名称',
            width: '180'
        }, {
            field: 'chcTitle',
            title: '概要',
            width: '180'
        }, {
            field: 'chcLinkman',
            title: '联系人',
            width: '150'
        }, {
            field: 'chcTel',
            title: '联系电话',
            width: '180'
        }, {
            field: 'chcCreateDate',
            title: '创建时间',
            width: '150'
        }, {
            field: 'chcStatus',
            title: '状态',
            width: '100'
        }, {
            field: 'chcDueId',
            hidden: true
        }]]

    });
    $("#listPlan").click(function () {
        var formData = {
            chcCustName: $("#chcCustName").val(),
            chcTitle: $("#chcTitle").val(),
            chcLinkman: $("#chcLinkman").val()
        };
        $("#salPlan").datagrid({queryParams: formData});
        return false
    });

});



