package kr.co.smhrd.steam.model;

public class UserVO {

	private String user_id;
	private String pwd;
	private int type;
	private String genre;
	private int money;

	public UserVO() {}
	public UserVO(String user_id, String pwd, int type, String genre,int money) {
		this.user_id = user_id;
		this.pwd = pwd;
		this.type = type;
		this.money = money;
		this.genre = genre;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "유저 :[닉네임 :" + user_id + ", 비밀번호 :" + pwd + ", 타입 :" + type + ", 돈 :" + money + ", 장르 :"
				+ genre + "]";
	}




}
