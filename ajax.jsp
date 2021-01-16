<%@page import="vo.NoticeBean, java.sql.Connection, dao.NoticeDAO, db.JdbcUtil, java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NoticeDAO noticeDAO = NoticeDAO.getInstance();
	Connection conn = JdbcUtil.getConnection();
	noticeDAO.setConnection(conn);
	int selectArticle = Integer.parseInt(request.getParameter("selectArticle"));
	NoticeBean article = noticeDAO.selectArticle(selectArticle);
	int updateReadCount = noticeDAO.addCountArticle(selectArticle);
	JdbcUtil.close(conn); 
	out.println("[");
	out.println("\""+article.getNotice_name().trim()+"\"");
	out.println(",");
	out.println("\""+article.getNotice_subject().trim()+"\"");
	out.println(",");
	out.println("\""+article.getNotice_content().trim()+"\"");
	out.println("]");
%>