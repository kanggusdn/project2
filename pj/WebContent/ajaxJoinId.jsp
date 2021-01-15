<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dao.LoginDAO, db.JdbcUtil, java.sql.*" %>
<%
	LoginDAO loginDAO = LoginDAO.getInstance();
	Connection conn = JdbcUtil.getConnection();
	loginDAO.setConnection(conn);
	boolean isId = loginDAO.checkId(request.getParameter("joinId"));
	out.println("[" + isId + "]");
	JdbcUtil.close(conn);
%>
