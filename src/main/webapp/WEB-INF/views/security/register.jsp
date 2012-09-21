<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
	<title>用户注册</title>
    <link rel="stylesheet" href="${ctx}/static/js/validation/validate.css"/>
</head>
<body>
<div class="page page-ex">
    <div class="page-header">
        <h2>用户注册 <small></small></h2>
    </div>
    <div class="row">
        <div class="span4 offset2">
            <form:form modelAttribute="user" action="${ctx}/reg" method="POST" cssClass="form-horizontal" id="auth-form">
                <input type='hidden' name='csrfmiddlewaretoken' value='c1b1696edcea586856677cc78ad76833' />
                <div class="control-group">
                    <label class="control-label" for="username">用户名</label>
                    <div class="controls">
                        <input type="text" id="username" name="username" maxlength="30" value="${username}" class="required input-large" placeholder="Username">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="email">邮箱</label>
                    <div class="controls">
                        <input type="text" id="email" name="username" maxlength="75" value="${email}" class="required email input-large" placeholder="Email">
                        <div id="email_suggestion" class="email_suggestion"></div>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="password">密码</label>
                    <div class="controls">
                        <input type="password" id="password" name="plainPassword" maxlength="75" class="required input-large" placeholder="Password">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="repassword">密码</label>
                    <div class="controls">
                        <input type="password" id="repassword" name="plainPassword2" maxlength="75" class="required input-large" placeholder="Confirm Password">
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <button type="submit" id="register" class="btn btn-success">注册</button>
                    </div>
                </div>
            </form:form>
            <p class="note">已经拥有账号? <a href="${ctx}/login">登录</a></p>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/min?t=js&f=/js/validation/jquery.validate.js,/js/validation/messages_bs_cn.js"></script>
<script type="text/javascript">
    $(function(){
        // 导航栏高亮
        $("#reg-page").addClass("active");

        //$("#auth-form label.error").css({'align':'right','display':'block','color':'#f00'});

        // 验证登录表单
        $("#auth-form").validate({
            rules:{
                username:{
                    required:true
                },
                email:{
                    required:true,
                    email:true
                },
                plainPassword:{
                    required:true,
                    minlength:3
                },
                plainPassword2:{
                    required:true,
                    minlength:3,
                    equalTo:"#password"
                }
            },
            messages:{
                username:{
                    required:"用户名不能为空"
                },
                email:{
                    required:"邮箱不能为空",
                    email:"请输入正确的邮箱"
                },
                plainPassword:{
                    required:"密码不能为空",
                    minlength:"密码不能低于3位"
                },
                plainPassword2:{
                    required:"确认密码不能为空",
                    minlength:"确认密码不能低于3位",
                    equalTo:"两次密码不相同"
                }
            }
        });

        $("#email").blur(function() {
            var email = $(this).val();
            $.ajax({
                url:"${ctx}/api/user/isUsedEmail?email=" + email,
                timeout: 3000
            }).done(function(data) {
                    var info = $('#email_suggestion');
                    if(true == data) {
                        $("#register").attr("disabled", true);
                        info.css({'display':'block','color':'#f00'});
                        info.text("该邮箱已被注册，请更换");

                    } else {
                        $("#register").attr("disabled", false);
                        info.css({'display':'block','color':'#0f0'});
                        info.text("邮箱可以使用");
                    }
            });
        });
    });
</script>
</body>
</html>