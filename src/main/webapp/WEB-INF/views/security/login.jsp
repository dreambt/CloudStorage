<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>登录</title>
</head>
<body>
<div class="page page-ex">
    <div class="page-header">
        <h2>用户登录 <small></small></h2>
    </div>
    <div class="row">
    <div class="span4 offset2">
        <div id="login" class="accounts-form">
            <%
                String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
                if(error != null){
                    if(error.contains("DisabledAccountException")){
            %>
            <div id="message" class="alert alert_red">
                用户已被屏蔽,请登录其他用户.
            </div>
            <%
            }else{
            %>
            <div id="message" class="alert alert_red">
                登录失败，请重试.
            </div>
            <%
                    }
                }
            %>
            <form:form id="loginForm" action="${ctx}/login" method="post" cssClass="form-horizontal">
                <input type='hidden' name='csrfmiddlewaretoken' value='c1b1696edcea586856677cc78ad76833' />
                <div class="control-group">
                    <label class="control-label" for="inputEmail">邮箱</label>
                    <div class="controls">
                        <input type="text" id="inputEmail" name="username" maxlength="75" value="${username}" class="required email input-large" placeholder="Email">
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputPassword">密码</label>
                    <div class="controls">
                        <input type="password" id="inputPassword" name="password" maxlength="75" class="required input-large" placeholder="Password">
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <label class="checkbox">
                            <input type="checkbox" id="rememberMe" name="rememberMe"> 记住密码
                        </label>
                        <button type="submit" class="btn btn-success">登录</button>
                        <button type="submit" class="btn">找回密码</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
    </div>
</div>
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
    function growl_type (e) {
        $.msgGrowl ({
            type: $(this).attr ('rel')
            , 'text': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.'
            , lifetime: 5000
        });
    }
    $(function() {
        // 导航栏高亮
        $("#login-page").addClass("active");

        $("#loginForm").validate();
        $(".alert").delay(1500).fadeOut("slow");

        // 登录
        /*$("#submit").click(function(){
            $.ajax({
                url: "${ctx}/login",
                data: { username: $("#inputEmail").val(), password: $("#inputPassword").val() }
            }).done(function( msg ) {
                alert( "Data Saved: " + msg );
                    $.msgGrowl ({
                        type: $(this).attr ('rel')
                        , 'text': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.'
                        , lifetime: 5000
                    });
            });
        });*/
    });
</script>
</body>
</html>