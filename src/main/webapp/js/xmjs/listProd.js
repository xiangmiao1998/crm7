$(function () {
    $('#prod-ta').datagrid({
        pagination: true,
        pageList: [2, 4, 6],
        pageSize: 6,
        idField: 'prodId',
        singleSelect: true,
        url: 'prod/list',
        columns: [[{
            field: 'prodId',
            title: '编号',
            width: "100"
        }, {
            field: 'prodName',
            title: '名称',
            width: "170"
        }, {
            field: 'prodType',
            title: '类型',
            width: "100"
        }, {
            field: 'prodBatch',
            title: '等级/批次',
            width: "170"
        }, {
            field: 'prodUnit',
            title: '单位',
            width: "100"
        }, {
            field: 'prodPrice',
            title: '单价(元)',
            width: "170"
        }, {
            field: 'prodMemo',
            title: '备注',
            width: "150"
        }]]
    });
    $("#list-prod").click(function () {
        var formData = {
            prodName: $("#prodName").val(),
            prodType: $("#prodType").val(),
            prodBatch: $("#prodBatch").val()
        };
        $("#prod-ta").datagrid({
            queryParams: formData
        });
        return false
    });

});