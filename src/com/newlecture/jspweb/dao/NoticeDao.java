package com.newlecture.jspweb.dao;

import java.util.List;

import com.newlecture.jspweb.entity.Notice;
import com.newlecture.jspweb.entity.NoticeView;

public interface NoticeDao {
	
	 List<NoticeView> getList();
	/* 
	 List<Notice> getList(String query);
	 List<Notice> getList(int page);
	 List<Notice> getList(int page, String field, String query);
	 */
	
Notice get(String id);
Notice getPrev(String id);
Notice getNext(String id);

int Insert(Notice notice);
int Update(Notice notice);
int Delete(Notice notice);

}	