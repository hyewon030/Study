package web.dto;

public class GroupTb {

	private int boardNo;
	private int recruitStatus;
	
	public GroupTb() {}

	public GroupTb(int boardNo, int recruitStatus) {
		super();
		this.boardNo = boardNo;
		this.recruitStatus = recruitStatus;
	}

	@Override
	public String toString() {
		return "GroupTb [boardNo=" + boardNo + ", recruitStatus=" + recruitStatus + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getRecruitStatus() {
		return recruitStatus;
	}

	public void setRecruitStatus(int recruitStatus) {
		this.recruitStatus = recruitStatus;
	}
	
	
	
	
	
}
