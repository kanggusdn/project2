<%@page import="vo.NoticeBean, java.sql.Connection, dao.NoticeDAO, db.JdbcUtil, java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	NoticeDAO noticeDAO = null;
	Connection conn = null;
	try{
		noticeDAO = NoticeDAO.getInstance();
		conn = JdbcUtil.getConnection();
		noticeDAO.setConnection(conn);
		int selectArticle = Integer.parseInt(request.getParameter("selectArticle"));
		NoticeBean article = noticeDAO.selectArticle(selectArticle);
		int updateReadCount = noticeDAO.addCountArticle(selectArticle);
		out.println("[");
		out.println("\""+article.getNotice_name().trim()+"\"");
		out.println(",");
		out.println("\""+article.getNotice_subject().trim()+"\"");
		out.println(",");
		out.println("\""+article.getNotice_content().trim()+"\"");
		out.println("]");
	} catch (Exception e){
		// TODO: handle exception
	} finally{
		JdbcUtil.close(conn);
	}
	
	
	
%>