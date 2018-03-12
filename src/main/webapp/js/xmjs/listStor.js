$(function () {
    $('#stro-ta').datagrid({
        pagination: true,
        pageList: [2, 4, 6],
        pageSize: 6,
        idField: 'stkId',
        singleSelect: true,
        url: 'stor/list',
        columns: [[{
            field: 'stkId',
            title: '编号',
            width: "100"
        }, {
            field: 'pName',
            title: '名称',
            width: "260"
        }, {
            field: 'stkWarehouse',
            title: '仓库',
            width: "180"
        }, {
            field: 'stkWare',
            title: '货位',
            width: "130"
        }, {
            field: 'stkCount',
            title: '件数',
            width: "100"
        }, {
            field: 'stkMemo',
            title: '备注',
            width: "150"
        }]]
    });
    $("#list-stro").click(function () {
        var formData = {
            pName: $("#pName").val(),
            stkWarehouse: $("#stkWarehouse").val()
        };
        $("#stro-ta").datagrid({
            queryParams: formData
        });
        return false
    });

});