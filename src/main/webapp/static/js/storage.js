$(function(){
    //checkbox全选与全部取消
    if($('#checkedAll').length>0)  {
        $('#checkedAll').click(function(){
            if(this.checked){
                $(":checkbox").each(function(){this.checked=true});
            }else{
                $(":checkbox").each(function(){this.checked=false});
            }
        });
    }

    //批量删除用户提示
    if($('#deleteAllUser').length>0){
        $('#deleteAllUser').click(function(){
            $('#Tips .modal-body').html("<p>确定要批量删除用户吗？</p>");
            $('#Tips').modal('hide');
        });
    }

    //批量审核用户提示
    if($('#auditAllUser').length>0){
        $('#auditAllUser').click(function(){
            $('#Tips .modal-body').html("<p>确定要批量审核用户吗？</p>");
            $('#Tips').modal('hide');
        });
    }

    //单个删除用户
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

    //批量删除分类
    if($('#deleteAllNode').length>0){
        $('#deleteAllNode').click(function(){
            $('#Tips .modal-body').html("<p>确定要批量删除分类吗？</p>");
            $('#Tips').modal('hide');
        });
    }

    //批量审核分类
    if($('#auditAllNode').length>0){
        $('#auditAllNode').click(function(){
            $('#Tips .modal-body').html("<p>确定要批量审核分类吗？</p>");
            $('#Tips').modal('hide');
        });
    }

    //单个删除分类
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