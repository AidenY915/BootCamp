<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	String path = application.getRealPath("fileFolder");
	int size = 1024*1024*10;
	String file = "";
	String oriFile = "";
	try{
		MultipartRequest multi = new MultipartRequest(request,path,size,"utf-8", new DefaultFileRenamePolicy());
		
		String name = request.getParameter("name");
		System.out.println("이름" + name);
		
		Enumeration<String> fileNames = multi.getFileNames();
		
	//	while(fileNames.hasMoreElements()){
	//		String str = fileNames.nextElement();
	//		file = multi.getFilesystemName(str);
	//		oriFile = multi.getOriginalFileName(str);
	//		
	//		System.out.println("경로: " + path);
	//		System.out.println("파일 이름: " + file);
	//		System.out.println("원본 이름: " + oriFile);
	//	}
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>

</body>
</html>