$(function () {
    $('#deal').datagrid({
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
            text: '处理',
            handler: function () {
                var rows = $("#deal").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', "请选择行！");
                    return;
                }
                var svrId = rows.svrId;//获取选中行的ID

                $('#chuli').form('load',rows);
                $('#wu-deal').dialog({
                    closed: false,
                    modal:true,
                    title: "修改信息",
                    buttons: [{
                        text: '确定',
                        iconCls: 'icon-ok',
                        handler: function () {
                            var svrDeal=$("#svrDeal").val();
                            $('#chuli').form('submit', {
                                url: 'service/editDeal?svrId='+svrId+"&svrDeal="+svrDeal,
                                success: function (data) {
                                    alert(data);
                                    if (1 == data) {
                                        $.messager.alert("信息提示", "处理成功！", "info");
                                        $('#wu-deal').dialog("close");
                                    } else {
                                        $.messager.alert("信息提示", "处理失败！", "info");
                                    }
                                }
                            });
                        }
                    }, {
                        text: '取消',
                        iconCls: 'icon-cancel',
                        handler: function () {
                            $('#wu-deal').dialog('close');
                        }
                    }]
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
        $("#deal").datagrid({
            queryParams: formDate
        });
        return false
    });
});





