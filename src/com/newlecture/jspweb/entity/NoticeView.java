package com.newlecture.jspweb.entity;

import java.sql.Date;

public class NoticeView extends Notice {

	private String writerName;
	private String commentCnt;
	

	public NoticeView(String id, String title, String writerId, String content, Date regDate, int hit, String writerName, String commentCnt) {
		super(id,title,content,writerId,regDate,hit);
		this.writerName = writerName;
		this.commentCnt = commentCnt;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(String commentCnt) {
		this.commentCnt = commentCnt;
	}

}
