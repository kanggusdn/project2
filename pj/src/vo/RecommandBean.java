package vo;

import java.sql.Date;

public class RecommandBean {
	private int recommand_num;
	private String recommand_name;
	private String recommand_pass;
	private String recommand_subject;
	private String recommand_content;
	private String recommand_file;
	private int recommand_re_ref;
	private int recommand_re_lev;
	private int recommand_re_seq;
	private int recommand_readcount;
	private Date recommand_date;

	public int getRecommand_num() {
		return recommand_num;
	}

	public void setRecommand_num(int recommand_num) {
		this.recommand_num = recommand_num;
	}

	public String getRecommand_name() {
		return recommand_name;
	}

	public void setRecommand_name(String recommand_name) {
		this.recommand_name = recommand_name;
	}

	public String getRecommand_file() {
		return recommand_file;
	}

	public void setRecommand_file(String recommand_file) {
		this.recommand_file = recommand_file;
	}

	public String getRecommand_pass() {
		return recommand_pass;
	}

	public void setRecommand_pass(String recommand_pass) {
		this.recommand_pass = recommand_pass;
	}

	public String getRecommand_subject() {
		return recommand_subject;
	}

	public void setRecommand_subject(String recommand_subject) {
		this.recommand_subject = recommand_subject;
	}

	public String getRecommand_content() {
		return recommand_content;
	}

	public void setRecommand_content(String recommand_content) {
		this.recommand_content = recommand_content;
	}

	public int getRecommand_re_ref() {
		return recommand_re_ref;
	}

	public void setRecommand_re_ref(int recommand_re_ref) {
		this.recommand_re_ref = recommand_re_ref;
	}

	public int getRecommand_re_lev() {
		return recommand_re_lev;
	}

	public void setRecommand_re_lev(int recommand_re_lev) {
		this.recommand_re_lev = recommand_re_lev;
	}

	public int getRecommand_re_seq() {
		return recommand_re_seq;
	}

	public void setRecommand_re_seq(int recommand_re_seq) {
		this.recommand_re_seq = recommand_re_seq;
	}

	public int getRecommand_readcount() {
		return recommand_readcount;
	}

	public void setRecommand_readcount(int recommand_readcount) {
		this.recommand_readcount = recommand_readcount;
	}

	public Date getRecommand_date() {
		return recommand_date;
	}

	public void setRecommand_date(Date recommand_date) {
		this.recommand_date = recommand_date;
	}

}
