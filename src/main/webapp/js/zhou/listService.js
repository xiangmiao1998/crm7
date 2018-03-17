$(function () {
    $('#dog').datagrid({
        pagination: true,
        pageList: [2, 4, 6],
        pageSize: 6,
        idField: 'svrId',
        singleSelect: true,
        url: 'service/listDispatch',
        columns: [[
            {field: 'svrId', title: '编号', width: 100},
            {field: 'svrCustName', title: '客户', width: 200},
            {field: 'svrTitle', title: '概要', width: 250},
            {field: 'svrType', title: '服务类型', width: 100},
            {field: 'svrCreateBy', title: '创建人', width: 100},
            {field: 'svrCreateDate', title: '创建日期', width: 200}
        ]],
        toolbar: [{
            iconCls: "icon-save",
            text: '分配',
            handler: function () {
                var rows = $("#dog").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', "请选择行！");
                    return;
                }


                //显示被分配人名字
                $('#cc').combobox({
                    url: 'user/list',
                    method: "post",
                    valueField: "usrId",
                    textField: "usrName",
                });

                $('#wu-fenpei').dialog({
                    closed: false,
                    modal: true,
                    title: "分配任务",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function () {
                            var svrId = rows.svrId;//获取选中行的ID
                            $('#fp').form('submit', {
                                url: 'service/edit?svrId='+svrId,
                                success: function (data) {
                                    if (1 == data) {
                                        $.messager.alert("信息提示", "分配成功！", "info");
                                        $("#fp").dialog(close);
                                        $("#fp").datagrid("reload");
                                    } else {
                                        $.messager.alert("信息提示", "分配失败！", "info");
                                    }
                                }
                            });
                        }
                    }, {
                        text: '取消',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#wu-dialog').dialog('close');
                        }
                    }]
                });
            }

        }, {
            iconCls: "icon-remove",
            text: '删除',
            handler: function () {
                var rows = $("#dog").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', "请选择行！");
                    return;
                }
                var svrId = rows.svrId;//获取选中行的ID
                var url='service/del?svrId='+svrId
                $.ajax({
                   dataType:'json',
                    url:url,
                    success:function (data) {
                        // if(0==data.code){
                        //     $.messager.alert("提示",data.messager);
                        //     var ind=$('dog').datagrid("getRowIndex",row.chcId);
                        //         $('dog').datagrid('deleteRow',ind);
                        // }else{
                        //     $.messager.alert('提示','删除失败');
                        // }
                        $.messager.alert("信息提示", "删除成功！", "info");
                        $("#dog").dialog(close);
                        $("#dog").datagrid("reload");
                    }
                });
            }
        }]
    });
    $('#load').click(function () {
        var formDate = {
            svrCustName: $("#svrCustName").val(),
            svrTitle: $("#svrTitle").val(),
            svrType: $("#svrType").val(),
            svrCreateDate1: $("#svrCreateDate1").datebox("getValue"),
            svrCreateDate2: $("#svrCreateDate2").datebox("getValue"),
            svrStatus: $("#svrStatus").val()
        };
        $("#dog").datagrid({
            queryParams: formDate
        });
        return false
    });
});





