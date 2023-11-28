<%@page import="java.util.TreeMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<% request.setAttribute("map", new TreeMap<String,String>()); %>
<c:set target="${map}" property="key1" value="value1"/>
<c:set target="${map}" property="key2" value="value2"/>
${map.keyValues} - key 배열
${map.key1}
</body>
</html>