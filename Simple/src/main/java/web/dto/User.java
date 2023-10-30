package web.dto;

import org.apache.ibatis.type.Alias;

@Alias("User2")
public class User {

	private String username;
	private int userage;
	
	public User() {}

	public User(String username, int userage) {
		super();
		this.username = username;
		this.userage = userage;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", userage=" + userage + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserage() {
		return userage;
	}

	public void setUserage(int userage) {
		this.userage = userage;
	}
	
}
