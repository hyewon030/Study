package web.dto;

import java.util.Date;

public class Board {

   private int boardNo;
   private String title;
   private int location;
   private int hit;
   private String content;
   private int deleteStatus;
   private String userId;
   private int boardCate;
   private Date postDate;

 
   public Board() {
	// TODO Auto-generated constructor stub
}


public Board(int boardNo, String title, int location, int hit, String content, int deleteStatus, String userId,
		int boardCate, Date postDate) {
	super();
	this.boardNo = boardNo;
	this.title = title;
	this.location = location;
	this.hit = hit;
	this.content = content;
	this.deleteStatus = deleteStatus;
	this.userId = userId;
	this.boardCate = boardCate;
	this.postDate = postDate;
}


@Override
public String toString() {
	return "Board [boardNo=" + boardNo + ", title=" + title + ", location=" + location + ", hit=" + hit + ", content="
			+ content + ", deleteStatus=" + deleteStatus + ", userId=" + userId + ", boardCate=" + boardCate
			+ ", postDate=" + postDate + "]";
}


public int getBoardNo() {
	return boardNo;
}


public void setBoardNo(int boardNo) {
	this.boardNo = boardNo;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public int getLocation() {
	return location;
}


public void setLocation(int location) {
	this.location = location;
}


public int getHit() {
	return hit;
}


public void setHit(int hit) {
	this.hit = hit;
}


public String getContent() {
	return content;
}


public void setContent(String content) {
	this.content = content;
}


public int getDeleteStatus() {
	return deleteStatus;
}


public void setDeleteStatus(int deleteStatus) {
	this.deleteStatus = deleteStatus;
}


public String getUserId() {
	return userId;
}


public void setUserId(String userId) {
	this.userId = userId;
}


public int getBoardCate() {
	return boardCate;
}


public void setBoardCate(int boardCate) {
	this.boardCate = boardCate;
}


public Date getPostDate() {
	return postDate;
}


public void setPostDate(Date postDate) {
	this.postDate = postDate;
}

   
   
   
   
   
   
   
}