$(function() {
    var urll='dict/listDict';
	$('#ta').datagrid({
		pagination : true,
		pageList : [2, 4, 6],
		pageSize : 6,
		idField : 'dictId',
		singleSelect : true,
		toolbar : [{
					iconCls : 'icon-Add',
					text : '新增',
					handler : function() {
                        $('#wu-dictAdd').dialog({
                            closed: false,
                            modal:true,
                            title: "添加信息",
                            buttons: [{
                                text: '确定',
                                iconCls: 'icon-ok',
                                handler: function() {
                                    $('#wu-add').form('submit', {
                                        url:'dict/add',
                                        success:function(data){
                                            if(1==data){
                                                $.messager.alert('信息提示','提交成功！','info');
                                                $('#wu-dictAdd').dialog('close');
                                                $("#ta").datagrid("reload");
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
                                    $('#wu-dictAdd').dialog('close');
                                }
                            }]
                        });
					}
				}, '-', {
					iconCls : 'icon-Remove',
					text : '删除',
					handler : function() {
						// alert('删除按钮')
						var rows = $("#ta").datagrid("getSelected");
						if (!rows) {
							$.messager.alert('警告', '请选择要删除的记录');
							return;
						}
						$.messager.confirm('确认', '您确定删除该行记录吗？', function(r) {
							if (r) {
								var dictId = rows.dictId;
								var url = "dict/deldict?dictId="+ dictId;
								$.ajax({
									dataType : 'json',
									url : url,
									success : function(data) {
										if (1 == data) {
											$.messager.alert('提示', '删除成功');
											var ind = $("#ta").datagrid("getRowIndex", dictId);
											$("#ta").datagrid("deleteRow", ind);
										} else {
											$.messager.alert('警告', '删除失败');
										}
									}
								});
							}
						});
					}
				}, '-', {
					iconCls : 'icon-edit',
					text : '修改',
					handler : function() {
                        $('#wu-edit').form('clear');
                        var item = $('#ta').datagrid('getSelected');
                        if(!item){
                            $.messager.alert('警告', '请选择要修改的记录');
                        	return;
						}
                        var dictId = item.dictId;
                        $.ajax({
                            url:'dict/loaddict?dictId='+ dictId,
                            data:'',
                            success:function(data){
                                if(null!=data){
                                    //绑定值
                                    $('#wu-edit').form('load', data)
                                }
                                else{
                                    $('#wu-dictedit').dialog('close');
                                }
                            }
                        });
                        $('#wu-dictedit').dialog({
                            closed: false,
                            modal:true,
                            title: "修改信息",
                            buttons: [{
                                text: '确定',
                                iconCls: 'icon-ok',
                                handler: function() {
                                    $('#wu-edit').form('submit', {
                                        url:'dict/editdict',
                                        success:function(data){
                                            if(data){
                                                $.messager.alert('信息提示','提交成功！','info');
                                                $('#wu-dictedit').dialog('close');
                                                $("#ta").datagrid("reload");
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
                                    $('#wu-dictedit').dialog('close');
                                }
                            }]
                        });
					}
				}],

		url : urll,
		columns : [[{
            		field : 'dictId',
					title : '编号',
            		width : "150"
				},{
					field : 'dictType',
					title : '类别',
					width : "150"
				}, {
					field : 'dictItem',
					title : '条目',
					width : "150"
				}, {
					field : 'dictValue',
					title : '值',
					width : "150"
				}, {
					field : 'dictIsEditable',
					title : '是否可编辑',
					width : "150"
				}]]

	});
	$("#listBtn").click(function() {
				var formData = {
				    dictType : $("#dictType").val(),
                    dictItem : $("#dictItem").val(),
                    dictValue : $("#dictValue").val()
				};
				$("#ta").datagrid({queryParams : formData});
				return false
			});

});