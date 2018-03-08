function reload(){
    window.location.reload();
}
function help(msg){
    alert('欢迎使用'+msg);
}
function to(url){
    //$("#wu-tabs").empty().append(window.Location.url=url);
    //$("#wu-tabs").window(url);
	var title= '数据字典管理add';
    var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
    $("#wu-tabs").tabs('add',{//不存在，则添加一个
        title:title,
        content:content,
        closable:true
    });
}
function back(){
    history.go(-1);
}
function save(url){
    alert('保存成功！');
    to(url);
}
function add(url){
    alert('新建成功！');
    to(url);
}
function del(msg){
    if (window.confirm("确认删除"+msg+"？")){
        reload();
    }
}
function setCurTime(oid){
    var now=new Date();
    var year=now.getYear();
    var month=now.getMonth();
    var day=now.getDate();
    var hours=now.getHours();
    var minutes=now.getMinutes();
    var seconds=now.getSeconds();
    var timeString = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    var oCtl = document.getElementById(oid);
    oCtl.value = timeString;
}