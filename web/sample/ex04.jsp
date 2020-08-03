<%--
  Created by IntelliJ IDEA.
  User: 82102
  Date: 2020-08-03
  Time: 오후 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html ; charset=UTF-8"/>
    <title>Insert title here</title>
</head>
<body>
<h2>SAMPLEDTO  ${sampleDTO} - bean 객체는 화면에 리턴이된다.</h2>
<h2>PAGE ${page} - 기본자료형(int,char 등) 은 리턴이 되지 않는다.</h2>
<h2>PAGE ${page2} - @ModelAttribute 를 사용하면 기본자료형도 리턴이 된다.}</h2>
</body>
</html>
