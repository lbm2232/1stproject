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
	   // (0-1) ���Ӹ�� ȣ�� : Game DB���� ������ ID�� ��ġ�ϴ� ������ �̸��� ȣ���ϱ� (5/all)
	   // (0-2) ���� ȣ�� : Game DB���� �Է��� Name�� ��ġ�ϴ� ��� ���� ���� ȣ���ϱ�
	   public GameVO import_gamename(String game_name);
	   // (0-3) ���� Ȯ�� : Customer DB���� ������ID�� ��ġ�ϴ� ȸ�������� ����(ID,PWD) ȣ���ϱ�
	   public UserVO import_devprofile(String user_id);
	   // (0-4) �����̸��� �ް� ����Ȯ���ϱ�
	   public int check_price(String name);
	   // (0-5) �����̸��� �ް� �帣Ȯ���ϱ�
	   public String check_genre(String name);
	   // (0-6) �����̸��� �ް� ����Ȯ���ϱ�
	   public String check_game_info(String name);
	   
	   // (1-1) ���ӵ�� : �����̸�, ����, �帣, ������ �Է¹޾� Game DB�� ���̵�� �Բ� �ø���
	   public void put_game(GameVO gv);
	   // (1-2) ���Ӽ��� P : (0-2)�� ���ؼ� ȣ����� ���ӿ� ���ؼ� ���� ������ �����ְ� ������ �� �Է� �ޱ�
	   public void update_game_price(int num, int price);
	   // (1-3) ���Ӽ��� G : (0-2)�� ���ؼ� ȣ����� ���ӿ� ���ؼ� ���� �帣�� �����ְ� ������ �� �Է� �ޱ�

	   // (1-4) ���Ӽ��� D : (0-2)�� ���ؼ� ȣ����� ���ӿ� ���ؼ� ���� ������ �����ְ� ������ �� �Է� �ޱ�
	   public void update_game_info(int num , String info);
	   // (1-5) ���ӻ��� : (0-2)�� ���ؼ� ȣ����� ���ӿ� ���ؼ� ���� �̸��� �����ְ�, ���� ������ ������ ���θ� ���� ��
	   //               Ȯ�ο� �����Ѵٸ� Game DB���� (0-3)�� ���� ���� �����ϱ�
	   public void delete_game(int s);
	   public int income(int num );
	   public int total_income(String user_id);
	   // # ����(income) - Money���� ������ �����Ḧ �� �ݾ�
	   // (2-1) �Ѽ��� Ȯ�� : Shop DB���� ������ ID�� ��ġ�ϴ� ��� ������ ���� ȣ���ϱ�
	   public int import_totalincome(String user_id);
	   // (2-2) �������� Ȯ�� : Shop DB���� ������ ID�� ��ġ�ϴ� distinct�� ������ �̸��� ���� �� ���� ȣ���ϱ�
	   public ArrayList<GameVO> import_eachincome(String user_id);
	   // (2-3) �������� : Customer DB���� ������ ID���� Money�� ���� �Է¹��� ��ŭ ���̳ʽ��� �����ϱ�
	   public int import_withdraw(String user_id);
	   // (2-4) �ܾ�Ȯ�� : �Ѽ��� + ������ID money ��갪 �����ֱ�
	   public int import_moneycheck(String user_id);
	   public ArrayList<GameVO> Search_game_by_uname(String s);
	   // (3-1) ��й�ȣ ���� : (0-4)�� ���� ȸ�������� Ȯ�ν�Ű�� , ���濩�θ� ���� ���� �� PWD ���� �� �Է¹ް� �����ϱ�
	   public String update_devpwd();
	   // (3-2) ȸ�� Ż�� : (0-4)�� ���� ȸ�������� Ȯ�ν�Ű�� , �������θ� ���� ���� �� DB���� ������ ID�� ��ġ�ϴ� ���� �����ϱ�
	   public String delete_devprofile();
	   public void super_select_user() ;
	   public ArrayList<GameVO> super_select_game();
	   public void super_delete_user(String id);
}
