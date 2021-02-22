package kr.co.smhrd.steam.model;

public class GameVO {

	private int num;
	private String name;
	private int price;
	private String genre;
	private String dev_name;
	private String game_info;
	
   public GameVO() {}

public GameVO(int num, String name, int price, String genre, String dev_name, String game_info) {
	this.num = num;
	this.name = name;
	this.price = price;
	this.genre = genre;
	this.dev_name = dev_name;
	this.game_info = game_info;
}

public int getNum() {
	return num;
}

public void setNum(int num) {
	this.num = num;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public String getDev_name() {
	return dev_name;
}

public void setDev_name(String dev_name) {
	this.dev_name = dev_name;
}

public String getGame_info() {
	return game_info;
}

public void setGame_info(String game_info) {
	this.game_info = game_info;
}

@Override
public String toString() {
	return "정보 : [게임번호 :" + num + ", 게임이름 :" + name + ", 가격 :" + price + ", 장르 :" + genre + ", 개발자 이름 :" + dev_name
			+ ", 게임정보 :" + game_info + "]";
};
   
   

}