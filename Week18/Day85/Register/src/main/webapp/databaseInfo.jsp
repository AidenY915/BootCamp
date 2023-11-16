<%! private static final long serialVersionUID = 1L;
	private static final String DB = "memberdb";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/" + DB + "?serverTimezone=Asia/Seoul";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "0000";
	private static final String DB_TABLE = "member"; %>
<%
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
%>