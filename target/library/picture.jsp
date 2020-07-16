<%--
  Created by IntelliJ IDEA.
  User: 10101
  Date: 2020/7/11
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h3>SpringMVC文件上传</h3>

<form action="Manager/updateBookAndAuthor" method="post" enctype="multipart/form-data">
    选择上传图书文件：<input type="file" name="bookFile"/><br/>
    id  <input type="text" name="bookId"><br/>
    书名 <input type="text" name="bookName"><br/>
    书数量 <input type="text" name="bookNumber"><br/>
    出版社 <input type="text" name="publisher"><br/>
    出版时间 <input type="date" name="publishtime"><br/>
<%--    选择上传作者文件：<input type="file" name="authorFile"/><br/>--%>
<%--    作者名 <input type="text" name="authorName"><br/>--%>
<%--    作者信息 <input type="text" name="authorInfo"><br/>--%>
    <input type="submit" value="上传"/>

</form>
</body>
</html>
