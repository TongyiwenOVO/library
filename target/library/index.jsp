<%--
  Created by IntelliJ IDEA.
  User: 10101
  Date: 2020/7/9
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <script type="text/javascript">
        function  changeVcode() {
            //加random防止页面不刷新
            document.getElementById("code").src="Vcode?m="+Math.random();
        }
    </script>

</head>
<body>
<h3>登陆</h3>
<jsp:forward page="login.jsp"></jsp:forward>
<%--<form action="login" method="post">--%>
<%--    账号：<input type="text" name="account">--%>
<%--    <br>--%>
<%--    密码：<input type="text" name="password">--%>
<%--    <br>--%>
<%--    <input type="submit" value="登陆">--%>
<%--    <input type="reset" value="重置">--%>
<%--    <input type="checkbox" name="role" value="0"> 用户--%>
<%--    <input type="checkbox" name="role" value="1"> 管理员--%>
<%--    <br>--%>
<%--    输入验证码：<input type="text" name="inputCode">--%>
<%--    <img src="Vcode" id="code" onclick="changeVcode()">--%>
<%--    <br>--%>
<%--    <span>${sessionScope.get("accountinfo")}</span>--%>

<%--    <br>--%>
<%--    <a href="logout">退出</a>--%>
<%--    <span>${LoginException}</span>--%>
<%--</form>--%>
<%--<br>--%>
<%--<a href="Manager/test">test</a>--%>
<%--<h3>注册</h3>--%>
<%--<form action="register" method="get">--%>
<%--    账号：<input type="text" name="account">--%>
<%--    <br>--%>
<%--    密码：<input type="text" name="password">--%>
<%--    <br>--%>
<%--    <input type="submit" value="注册">--%>
<%--    <input type="reset" value="重置">--%>
<%--    <br>--%>
<%--&lt;%&ndash;    <span>${requestScope.get("msgreg")}</span>&ndash;%&gt;--%>
</form>
</body>
</html>
