<%@page import="vo.NoticeBean, java.sql.Connection, dao.NoticeDAO, db.JdbcUtil, java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NoticeDAO noticeDAO = NoticeDAO.getInstance();
	Connection conn = JdbcUtil.getConnection();
	noticeDAO.setConnection(conn);
	NoticeBean article = noticeDAO.selectArticle(Integer.parseInt(request.getParameter("selectArticle")));
	out.println("[");
	out.println(article.getNotice_name());
	out.println(",");
	out.println(article.getNotice_subject());
	out.println(",");
	out.println(article.getNotice_content());
	out.println("]");
%>