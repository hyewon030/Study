package interceptor.dto;

public class User {

	private int userno;
	private String userid;
	private String userpw;
	private String usernick;
	
	public User() {}

	public User(int userno, String userid, String userpw, String usernick) {
		super();
		this.userno = userno;
		this.userid = userid;
		this.userpw = userpw;
		this.usernick = usernick;
	}

	@Override
	public String toString() {
		return "User [userno=" + userno + ", userid=" + userid + ", userpw=" + userpw + ", usernick=" + usernick + "]";
	}

	public int getUserno() {
		return userno;
	}

	public void setUserno(int userno) {
		this.userno = userno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsernick() {
		return usernick;
	}

	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
	
}
