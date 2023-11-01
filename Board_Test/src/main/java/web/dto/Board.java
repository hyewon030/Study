package web.dto;

import java.util.Date;

public class Board {
	
	public int boardNo;
	public String title;
	public String writerId;
	public String writerNick;
	public int hit;
	public Date writeDate;
	public String content;
	
	//생성자
	public Board() {}

	public Board(int boardNo, String title, String writerId, String writerNick, int hit, Date writeDate,
			String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.writerId = writerId;
		this.writerNick = writerNick;
		this.hit = hit;
		this.writeDate = writeDate;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", writerId=" + writerId + ", writerNick="
				+ writerNick + ", hit=" + hit + ", writeDate=" + writeDate + ", content=" + content + "]";
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

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getWriterNick() {
		return writerNick;
	}

	public void setWriterNick(String writerNick) {
		this.writerNick = writerNick;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
