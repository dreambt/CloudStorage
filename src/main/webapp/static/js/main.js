// 时间格式化
function ChangeDateFormat(cellval) {
    if(null==cellval) return 0;
    var datetime = cellval.toString().split(",");
    var month = datetime[1] < 10 ? "0" + (datetime[1]) : datetime[1];
    var currentDate = datetime[2] < 10 ? "0" + datetime[2] : datetime[2];
    return datetime[0] + "年" + month + "月" + currentDate + "日";
}
function ChangeDateTimeFormat(cellval) {
    if(null==cellval) return 0;
    var datetime = cellval.toString().split(",");
    var month = datetime[1] < 10 ? "0" + (datetime[1]) : datetime[1];
    var currentDate = datetime[2] < 10 ? "0" + datetime[2] : datetime[2];
    var hour = datetime[3] < 10 ? "0" + datetime[3] : datetime[3];
    var min = datetime[4] < 10 ? "0" + datetime[4] : datetime[4];
    var sec = datetime[5] < 10 ? "0" + datetime[5] : datetime[5];
    return datetime[0] + "年" + month + "月" + currentDate + "日 " + hour + ":" + min + ":" + sec;
}
function PostByAjax(url, data) {
    $.ajax({
        url:url,
        type: "POST",
        data: data,
        timeout:3000
    }).done(function(msg) {
            if(0==msg.status){
                type = "error";
                message = msg.message+" 请检查提交参数后再次尝试！";
            } else {
                type = "info";
                message="操作成功！";
            }
            $.msgGrowl ({
                type: type,
                position:"top-right",
                'text': message,
                lifetime: 5000
            });
        });
}
$(function(){
    // checkbox 全选与全部取消
    if($('#checkedAll').length>0)  {
        $('#checkedAll').click(function(){
            if(this.checked){
                $(":checkbox").each(function(){this.checked=true});
            }else{
                $(":checkbox").each(function(){this.checked=false});
            }
        });
    }

    // 批量删除用户提示
    if($('#deleteAllUser').length>0){
        $('#deleteAllUser').click(function(){
            $('#Tips .modal-body').html("<p>确定要批量删除用户吗？</p>");
            $('#Tips').modal('hide');
        });
    }

    // 批量审核用户提示
    if($('#auditAllUser').length>0){
        $('#auditAllUser').click(function(){
            $('#Tips .modal-body').html("<p>确定要批量审核用户吗？</p>");
            $('#Tips').modal('hide');
        });
    }

    // 单个删除用户
    if($('.deleteSingleUser').length>0){
        $('.deleteSingleUser').click(function(){
            if($(this).children().attr("class")=="icon-repeat"){
                var tmp="<p>确定要找回【"+$('td.userName').text()+"】用户吗？</p>";
            }else{
                var tmp="<p>确定要删除【"+$('td.userName').text()+"】用户吗？</p>";
            }
            $('#Tips .modal-body').html(tmp);
            $('#Tips').modal('hide');
        });
    }

    // 批量删除分类
    if($('#deleteAllNode').length>0){
        $('#deleteAllNode').click(function(){
            $('#Tips .modal-body').html("<p>确定要批量删除分类吗？</p>");
            $('#Tips').modal('hide');
        });
    }

    // 批量审核分类
    if($('#auditAllNode').length>0){
        $('#auditAllNode').click(function(){
            $('#Tips .modal-body').html("<p>确定要批量审核分类吗？</p>");
            $('#Tips').modal('hide');
        });
    }

    // 单个删除分类
    if($('.deleteSingleNode').length>0){
        $('.deleteSingleNode').click(function(){
            if($(this).children().attr("class")=="icon-repeat"){
                var tmp="<p>确定要找回【"+$('td.nodeName').text()+"】分类吗？</p>";
            }else{
                var tmp="<p>确定要删除【"+$('td.nodeName').text()+"】分类吗？</p>";
            }
            $('#Tips .modal-body').html(tmp);
            $('#Tips').modal('hide');
        });
    }
});