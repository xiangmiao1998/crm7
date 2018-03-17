$(function() {
    $('#orders').datagrid({
        pagination : true,
        pageList : [2, 4, 6],
        pageSize : 6,
        idField : 'odrId',
        singleSelect : true,
        toolbar : [{
            iconCls : 'icon-edit',
            text : '查看详情',
            handler : function() {
                var rows = $("#orders").datagrid("getSelected");
                if (!rows) {
                    $.messager.alert('警告', '请选择订单！');
                    return;
                }
                var odrId = rows.odrId;
                parent.addTab('联系人', 'linkmanLQ/look?custNo='+custNo,'icon-edit',true);
            }
        }],
        url : '/crm7/ordersLQ/list',
        columns : [[{
            field : 'odrId',
            title : '订单编号',
            width : "150"
        },{
            field : 'odrDate',
            title : '日期',
            width : "150"
        }, {
            field : 'odrAddr',
            title : '送货地址',
            width : "150"
        }, {
            field : 'odrStatus',
            title : '状态',
            width : "150"
        }
        ]]

    });
});