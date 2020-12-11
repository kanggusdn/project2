package vo;

import java.sql.Date;

public class NoticeBean {
	private int notice_num;
	private String notice_name;
	private String notice_pass;
	private String notice_subject;
	private String notice_content;
	private String notice_file;
	private int notice_re_ref;
	private int notice_re_lev;
	private int notice_re_seq;
	private int notice_readcount;
	private Date notice_date;

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getNotice_name() {
		return notice_name;
	}

	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}

	public String getNotice_pass() {
		return notice_pass;
	}

	public void setNotice_pass(String notice_pass) {
		this.notice_pass = notice_pass;
	}

	public String getNotice_subject() {
		return notice_subject;
	}

	public void setNotice_subject(String notice_subject) {
		this.notice_subject = notice_subject;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public String getNotice_file() {
		return notice_file;
	}

	public void setNotice_file(String notice_file) {
		this.notice_file = notice_file;
	}

	public int getNotice_re_ref() {
		return notice_re_ref;
	}

	public void setNotice_re_ref(int notice_re_ref) {
		this.notice_re_ref = notice_re_ref;
	}

	public int getNotice_re_lev() {
		return notice_re_lev;
	}

	public void setNotice_re_lev(int notice_re_lev) {
		this.notice_re_lev = notice_re_lev;
	}

	public int getNotice_re_seq() {
		return notice_re_seq;
	}

	public void setNotice_re_seq(int notice_re_seq) {
		this.notice_re_seq = notice_re_seq;
	}

	public int getNotice_readcount() {
		return notice_readcount;
	}

	public void setNotice_readcount(int notice_readcount) {
		this.notice_readcount = notice_readcount;
	}

	public Date getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}

}
