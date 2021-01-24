<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.LoginDAO, db.JdbcUtil, java.sql.*" %>
<%
	LoginDAO loginDAO = null;
	Connection conn = null;
	try {
		loginDAO = LoginDAO.getInstance();
		conn = JdbcUtil.getConnection();
		loginDAO.setConnection(conn);
		boolean isId = loginDAO.checkId(request.getParameter("joinId"));
		out.println("[" + isId + "]");
	} catch (Exception e) {
		// TODO: handle exception
	} finally {
		JdbcUtil.close(conn);	
	}
	
	
%>
