package kr.co.smhrd.steam.dao;

import java.util.ArrayList;

import kr.co.smhrd.steam.model.GameVO;
import kr.co.smhrd.steam.model.UserVO;

public interface GameDAOI {
	
	
	public void insert_user(UserVO new_user);

	public int cash_check(String new_user_id);

	public void cash_plus(String new_user_id, int pay);

	public void delete_user(String new_user_id);

	public GameVO select_by_name(String name);

	public ArrayList<GameVO> select_by_genre(String genre);

	public ArrayList<GameVO> select_by_score(String score);

	public void insert_purchsed(String user_id, int game_num);
	
	public int search_game_price(int num);

	public String search_game_name(int num);
	
	public void print(ArrayList arr) ;

	public ArrayList<GameVO> purchased_game(String user_id);
	
	public UserVO search_user(String id) ;
	public void update_game_genre(int gnum, String genre);
	   // (0-1) 게임목록 호출 : Game DB에서 개발자 ID와 일치하는 게임의 이름만 호출하기 (5/all)
	   // (0-2) 게임 호출 : Game DB에서 입력한 Name과 일치하는 모든 게임 내용 호출하기
	   public GameVO import_gamename(String game_name);
	   // (0-3) 정보 확인 : Customer DB에서 개발자ID와 일치하는 회원정보의 내용(ID,PWD) 호출하기
	   public UserVO import_devprofile(String user_id);
	   // (0-4) 게임이름을 받고 가격확인하기
	   public int check_price(String name);
	   // (0-5) 게임이름을 받고 장르확인하기
	   public String check_genre(String name);
	   // (0-6) 게임이름을 받고 설명확인하기
	   public String check_game_info(String name);
	   
	   // (1-1) 게임등록 : 게임이름, 가격, 장르, 설명을 입력받아 Game DB에 아이디와 함께 올리기
	   public void put_game(GameVO gv);
	   // (1-2) 게임수정 P : (0-2)를 통해서 호출받은 게임에 대해서 현재 가격을 보여주고 변경할 값 입력 받기
	   public void update_game_price(int num, int price);
	   // (1-3) 게임수정 G : (0-2)를 통해서 호출받은 게임에 대해서 현재 장르를 보여주고 변경할 값 입력 받기

	   // (1-4) 게임수정 D : (0-2)를 통해서 호출받은 게임에 대해서 현재 설명을 보여주고 변경할 값 입력 받기
	   public void update_game_info(int num , String info);
	   // (1-5) 게임삭제 : (0-2)를 통해서 호출받은 게임에 대해서 현재 이름을 보여주고, 정말 삭제할 것인지 여부를 물은 뒤
	   //               확인에 동의한다면 Game DB에서 (0-3)에 대한 게임 삭제하기
	   public void delete_game(int s);
	   public int income(int num );
	   public int total_income(String user_id);
	   // # 수익(income) - Money에서 관리자 수수료를 뺀 금액
	   // (2-1) 총수익 확인 : Shop DB에서 개발자 ID와 일치하는 모든 게임의 수익 호출하기
	   public int import_totalincome(String user_id);
	   // (2-2) 개별수익 확인 : Shop DB에서 개발자 ID와 일치하는 distinct된 게임의 이름과 게임 별 수익 호출하기
	   public ArrayList<GameVO> import_eachincome(String user_id);
	   // (2-3) 수익인출 : Customer DB에서 개발자 ID에서 Money를 값을 입력받은 만큼 마이너스값 저장하기
	   public int import_withdraw(String user_id);
	   // (2-4) 잔액확인 : 총수익 + 개발자ID money 계산값 보여주기
	   public int import_moneycheck(String user_id);
	   public ArrayList<GameVO> Search_game_by_uname(String s);
	   // (3-1) 비밀번호 변경 : (0-4)를 통해 회원정보를 확인시키고 , 변경여부를 묻고 수락 시 PWD 변경 값 입력받고 저장하기
	   public String update_devpwd();
	   // (3-2) 회원 탈퇴 : (0-4)를 통해 회원정보를 확인시키고 , 삭제여부를 묻고 수락 시 DB에서 개발자 ID와 일치하는 정보 삭제하기
	   public String delete_devprofile();
	   public void super_select_user() ;
	   public ArrayList<GameVO> super_select_game();
	   public void super_delete_user(String id);
}
