package kr.co.smhrd.steam.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.smhrd.steam.dao.GameDAO;
import kr.co.smhrd.steam.dao.GameDAOI;
import kr.co.smhrd.steam.model.GameVO;
import kr.co.smhrd.steam.model.UserVO;

public class SteamView {

	static Scanner scan = new Scanner(System.in);

	private SteamView() {

	}

	public static void start() {
		System.out.println("��������������������������������������������������������");
		System.out.println("  Steem�� �湮�Ͻ� ���� ȯ���մϴ�.");
		System.out.println("         Ver.0.1.6          ");
		System.out.println("��������������������������������������������������������");

	}

	public static String select_login_join() {

		while (true) {
			System.out.println("[1] �α��� [2] ȸ������ [3] ����");
			System.out.print("�޴��� �����ϼ��� >> ");
			String s = scan.next();
			switch (s) {
			case "1":
			case "2":
				break;
			case "3":
				System.out.println("����Ǿ����ϴ�.");
				break;
			default:
				continue;
			}
			return s;

		}
	}

	public static UserVO login() {
		UserVO u = new UserVO();
		System.out.print("ID : ");
		u.setUser_id(scan.next());
		System.out.print("PASSWORD : ");
		u.setPwd(scan.next());
		return u;
	}

	public static String select_join_type() {
		String s = "";
		while (true) {
			System.out.println("��������������������������������������������������������");
			System.out.println("[1] �Ϲ� ȸ������ [2] ������ ȸ������");
			System.out.println("��������������������������������������������������������");
			System.out.print("ȸ�� Ÿ���� �����ϼ��� >> ");
			s = scan.next();
			switch (s) {
			case "1":
			case "2":
				break;
			default:
				System.out.println("�ٽ��Է��ϼ���.");
				continue;
			}
			return s;
		}

	}

	public static int login_permit(UserVO input_user, UserVO current_user) {
		int logintype = 0;
		if (input_user.getUser_id().equals(current_user.getUser_id())) {
			if (input_user.getPwd().equals(current_user.getPwd())) {
				logintype = current_user.getType();
			}

		}
		return logintype;
	}

	public static String select_genre() {
		String s = "";
		while (true) {
			System.out.println("����������������������������������������������������������������������������������������");
			System.out.println("[1]RPG [2]FPS [3]SPORTS [4]ARCADE [5]�ڷΰ���" );
			System.out.println("����������������������������������������������������������������������������������������");
			System.out.print("��ȣ�ϴ� �帣�� �����ϼ��� >> ");
			s = scan.next();

			switch (s) {
			case "1":
				s = "RPG";
				break;
			case "2":
				s = "FPS";
				break;
			case "3":
				s = "SPORTS";
				break;
			case "4":
				s = "ARCADE";
				break;
			case "5":
				s = null; 
				break;
			default:
				continue;
			}
			return s;
		}
	}

	public static UserVO join2(String s) {
		UserVO new_user = new UserVO();
		String new_pwd = "";
		GameDAOI chech = new GameDAO();
		System.out.print("ID : ");
		String new_id = scan.next();
		while (!(chech.search_user(new_id).getUser_id() == null)) {
			System.out.println("�ߺ��� ID�Դϴ�. �ٽ� �Է��ϼ���.");
			System.out.print("ID : ");
			new_id = scan.next();
		}
		new_user.setUser_id(new_id);

		System.out.print("PASSWORD : ");
		new_user.setPwd(scan.next());
		System.out.print("PASSWORD confirm : ");
		while (!new_user.getPwd().equals(scan.next())) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			System.out.print("PASSWORD : ");
			new_user.setPwd(scan.next());
			System.out.print("PASSWORD confirm : ");
		}

		switch (s) {
		case "1":
			new_user.setType(1);
			break;
		case "2":
			new_user.setType(2);
			break;
		}
		return new_user;
	}

	public static UserVO join(String s) {
		UserVO new_user = new UserVO();
		String new_pwd = "";
		System.out.print("ID : ");
		GameDAOI chech = new GameDAO();
		String new_id = scan.next();
		while (!(chech.search_user(new_id).getUser_id() == null)) {
			System.out.println("�ߺ��� ID�Դϴ�. �ٽ� �Է��ϼ���.");
			System.out.print("ID : ");
			new_id = scan.next();
		}
		new_user.setUser_id(new_id);

		System.out.print("PASSWORD : ");
		new_user.setPwd(scan.next());
		System.out.print("PASSWORD confirm : ");
		while (!new_user.getPwd().equals(scan.next())) {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			System.out.print("PASSWORD : ");
			new_user.setPwd(scan.next());
			System.out.print("PASSWORD confirm : ");
		}
		new_user.setGenre(select_genre());
		switch (s) {
		case "1":
			new_user.setType(1);
			break;
		case "2":
			new_user.setType(2);
			break;
		}
		return new_user;
	}

	public static String choosefavor() {

		String result = "";
		System.out.println("����������������������������������������������������������������������������������");
		System.out.println("[1] RPG [2] FPS [3] AOS [4]Shooting [5] etc ");
		System.out.println("����������������������������������������������������������������������������������");
		System.out.print("��ȣ�ϴ� �����帣 >> ");
		String favorite = scan.next();
		while (true) {
			switch (favorite) {
			case "1":
				result = "RPG";
				break;
			case "2":
				result = "FPS";
				break;
			case "3":
				result = "AOS";
				break;
			case "4":
				result = "Shooting";
				break;
			case "5":
				result = "etc";
				break;
			default:
				System.out.println("�ٽ� �Է��ϼ��� ");
				System.out.println("����������������������������������������������������������������������������������");
				System.out.print("[1] RPG [2] FPS [3] AOS [4]Shooting [5] etc ");
				System.out.println("����������������������������������������������������������������������������������");
				System.out.println("��ȣ�ϴ� �����帣 >> ");
				favorite = scan.next();
				continue;
			}
			return result;
		}

	}

	public static String user_init() {
		while (true) {
			System.out.println("��������������������������������������������������������");
			System.out.println("[1] ���������� [2] ���� [3] ����");
			System.out.println("��������������������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String s = scan.next();
			switch (s) {
			case "1":
			case "2":
			case "3":
				break;
			default:
				continue;
			}
			return s;
		}

	}// ���� �ʱ�ȭ��

	public static String user_mypage() {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.println("[1] ���� �ݾ� [2] ���� ���Ӹ�� [3] ȸ���������� [4] �ڷΰ��� ");
			System.out.println("��������������������������������������������������������������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String a = s.next();
			switch (a) {
			case "1":
			case "2":
			case "3":
			case "4":
				break;
			default:
				continue;
			}
			return a;
		}

	}

	public static String user_mypage_wallet() { // ����

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("������������������������������������");
			System.out.println("[1] ���� [2] ó������ ");
			System.out.println("������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String a = s.next();
			switch (a) {
			case "1":
			case "2":
				break;
			default:
				continue;
			}
			return a;
		}

	}

	public static String wallet_charge() { // ����

		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("������������������������������������������");
			System.out.println("[1] �����ݾ� [2] �ڷΰ��� ");
			System.out.println("������������������������������������������");
			System.out.println("�޴��� �����ϼ��� >> ");
			String a = s.next();
			switch (a) {
			case "1":
			case "2":
				break;
			default:
				continue;
			}
			return a;
		}

	}

	public static String user_mypage_drop() { // Ż��

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("Ż���Ͻðڽ��ϱ�?");
			System.out.println("������������������������������");
			System.out.println("[1] �� [2] �ƴϿ� ");
			System.out.println("������������������������������");
			String a = s.next();
			switch (a) {
			case "1":
			case "2":
				break;
			default:
				continue;
			}
			return a;
		}

	}

	public static void user_mypage_gamelist() {
		// ���Ӹ���Ʈ ���

		System.out.println("���� ��ȣ�� �����ϼ��� >> ");
		scan.next();

		// �����Ѱ��� �÷���?
	}

	public static String user_market_search() { // ���� [2]
		while (true) {
			// ���� ����Ʈ �߰� �ؼ� �Է�
			System.out.println("������������������������������������������������������");
			System.out.println("[1] �̸�  [2] �帣  [3] ���ư��� ");
			System.out.println("������������������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String s = scan.next();
			switch (s) {
			case "1":
			case "2":
			case "3":
				break;
			default:
				continue;
			}
			return s;
		}
	}

	public static int money_plus() {
		System.out.print("������ �ݾ��� �Է��ϼ��� >> ");
		return scan.nextInt();
	}

	public static int money_minus() {
		System.out.print("������ �ݾ��� �Է��ϼ��� >> ");
		return -scan.nextInt();
	}

	public static String user_market() { // ���� ����
		while (true) {
			// ���� ����Ʈ �߰� �ؼ� �Է�
			System.out.println("��������������������������������������������������������������������");
			System.out.println("[1] ��õ ����  [2] ���� �˻�  [3] �ڷ� ����");
			System.out.println("��������������������������������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String s = scan.next();
			switch (s) {
			case "1":
			case "2":
			case "3":
				break;
			default:
				continue;
			}
			return s;
		}
	}

	public static String user_market_purchase() { // ����[1][1]
		while (true) {
			// ��õ ���� ����Ʈ �߰� �ؼ� �Է�
			System.out.println("����������������������������������������������");
			System.out.println("[1] ���� ���� [2] �ڷ� ����");
			System.out.println("����������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String s = scan.next();
			switch (s) {
			case "1":
			case "2":
				break;
			default:
				continue;
			}
			return s;

		}
	}

	public static boolean purchase() {
		boolean b = true;
		switch (SteamView.user_market_purchase()) {// db���� ��õ���� ���� �ҷ����� �Է� �޾Ƽ� �ϳ�����
		case "1":
			// db�� �������� �߰�
			System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
			break;
		case "2":
			System.out.println("���Ű� ��� �Ǿ����ϴ�.");
			b = false;
			break;

		}
		return b;

	}

	public static String dev_init() {
		while (true) {
			System.out.println("����������������������������������������������������������������������������");
			System.out.println("[1] ���� [2] Money [3] ���������� [4] ����");
			System.out.println("����������������������������������������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String input = scan.next();
			switch (input) {
			case "1":

			case "2":

			case "3": // dev_mypage() �� < --

			case "4":
				break;
			default:
				continue;
			}
			return input;
		}

	}

//[1] �� ���� ��Ȳ [2] ���� �Ǹ� ��� [3] ���� ���� ��� [4] ���� ����
	public static String mygame() {
		while (true) {
			System.out.println("����������������������������������������������������������������������������������������");
			System.out.println("[1] ���� ��� [2] ���� ���� [3] ���� ���� [4] �ڷΰ���");
			System.out.println("����������������������������������������������������������������������������������������");
			String check = scan.next();
			switch (check) {
			case "1":
			case "2":
			case "3":
			case "4":
				break;
			default:
				continue;
			}
			return check;
		}
	}

	public static GameVO putgame() {
		GameVO dev_sellgame = new GameVO();
		// �Ǹ��� ���ӿ� ���� ������ �Է¹޾� sell_game�� ���
		System.out.println("������������������������������������������������������������");
		System.out.println(" �Ǹ��� ���ӿ� ���� ������ �Է����ּ���.");
		System.out.println("������������������������������������������������������������");
		System.out.println("���� �̸� :");
		dev_sellgame.setName(scan.next());
		System.out.println("���� ���� :");
		dev_sellgame.setPrice(scan.nextInt());
		System.out.println("���� �帣 :");
		dev_sellgame.setGenre(scan.next());
		System.out.println("���� ���� :");
		dev_sellgame.setGame_info(scan.next());
		System.out.println("* " + dev_sellgame.getName() + " * ������ ��ϵǾ����ϴ�.");
		return dev_sellgame;
	}

	public static String updategame() {
		System.out.println("����������������������������������������������������");
		System.out.println("������Ʈ �� ���� �̸��� �Է��ϼ���.");
		System.out.println("����������������������������������������������������");
		return scan.next();

	}

	public static String updategame_by() {
		while (true) {
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("������ ������ Ȯ�����ּ��� - [1] ���� ���� [2] ���� �帣 [3] ���� ���� [4] ���ư���");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >>");
			String check;
			check = scan.next();
			switch (check) {
			case "1":
			case "2":
			case "3":
			case "4":
				break;
			default:
				continue;
			}
			return check;
		}
	}

	public static int numselct() {
		System.out.print("���� ��ȣ : ");
		int updatewhat1 = scan.nextInt();
		return updatewhat1;
	}

	public static int update_price() {
		System.out.print("�ٲ� ���� : ");
		int updatewhat1 = scan.nextInt();
		return updatewhat1;
	}

	public static String update_genre() {
		System.out.print("�ٲ� �帣 : ");
		String updatewhat2 = scan.next();
		return updatewhat2;
	}

	public static String update_info() {
		System.out.print("�ٲ� ���� : ");
		String updatewhat3 = scan.next();
		return updatewhat3;
	}

	public static String deletegame() {
		while (true) {
			System.out.println("������ ���ӿ� ���� �̸��� �Է����ּ���. ");
//   for (GameVO game : games){
//   System.out.println(game);
			String deletegame = scan.next();
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("(deletegame)�� ���� �����Ͻðڽ��ϱ�?" + "\n" + "[1] �� [2] �ƴϿ�");
			System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.println("�޴��� �����ϼ��� >>");
			String check = scan.next();
			switch (check) {
			case "1":
			case "2":
				break;
			default:
				continue;
			}
			return check;
		}
	}

	public static String dev_money() {
		Scanner scan = new Scanner(System.in);
		String s;
		while (true) {
			System.out.println("������������������������������������������������������������������������");
			System.out.println("[1] ������ȸ [2] �ܾ� [3] ���� [4] �ڷΰ���");
			System.out.println("������������������������������������������������������������������������");
			System.out.println("�޴��� �����ϼ��� >>");
			s = scan.next();
			switch (s) {
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
				break;
			default:
				continue;
			}
			return s;
		}

	}

	public static String devpw_update() {
		while (true) {
			System.out.println("��й�ȣ�� �����Ͻðڽ��ϱ�? ");
			System.out.println("����������������������������������");
			System.out.println("[1] ���� [2] �ƴϿ�");
			System.out.println("����������������������������������");
			System.out.println("��ȣ�� �����ϼ��� >>");
			String input = scan.next();
			switch (input) {
			case "1": // update������� �н����� ������Ʈ

			case "2":
				break;
			default:
				continue;
			}
			return input;
		}
	}

	public static boolean update_permit(ArrayList<GameVO> vd1, int gnum) {
		boolean permit = false;
		for (int index = 0; index < vd1.size(); index++) {
			if (vd1.get(index).getNum() == gnum) {
				permit = true;
				break;
			}

		}
		return permit;

	}

	public static int select_game2() {
		System.out.print("�÷����Ͻ� ������ ��ȣ�� �����ϼ��� >> ");
		int game_num = scan.nextInt();

		return game_num;
	}

	public static int select_game() {
		boolean gamein = false;
		GameDAO check = new GameDAO();
		int game_num =0;
		while (!gamein) {
			System.out.print("�����Ͻ� ������ ��ȣ�� �����ϼ��� >> ");
			game_num = scan.nextInt();		
			for (GameVO e : check.super_select_game()) {
				if (e.getNum() == game_num) {
					gamein = true;
					break; 
				}
			}
			if(gamein == false) {
			System.out.println("��ϵ��� ���� ���ӹ�ȣ �Դϴ�.");
			}
		}

		System.out.println("��������������������������������������������������");
		System.out.println("[1] ����Ȯ��  [2] ������� >> ");
		System.out.println("��������������������������������������������������");
		System.out.println("�޴��� �����ϼ��� >> ");
		while (true) {
			String s = scan.next();
			switch (s) {
			case "1":
				break;
			case "2":
				game_num = 0;
				break;

			}
			return game_num;
		}
	}

	public static String game_purch() {
		while (true) {
			System.out.println("������������������������������������������");
			System.out.println("[1] ���ӱ��� [2] �ڷΰ���");
			System.out.println("������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >>");
			String input = scan.next();
			switch (input) {
			case "1": // update������� �н����� ������Ʈ
			case "2":
				break;
			default:
				continue;
			}
			return input;
		}
	}
	
	public static String dev_delete() {
		while (true) {
			System.out.println("������ ȸ�� Ż�� �Ͻðڽ��ϱ�? ");
			System.out.println("������������������������������");
			System.out.println("[1]�� [2] �ƴϿ�");
			System.out.println("������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String input = scan.next();
			switch (input) {
			case "1":
			case "2":
				break;
			default:
				continue;
			}
			return input;
		}
	}

	public static String dev_mypage() {
		while (true) {
			System.out.println("����������������������������������������������������������������������");
			System.out.println("[1] ��й�ȣ���� [2] ȸ��Ż�� [3] ���ư���");
			System.out.println("����������������������������������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String input = scan.next();
			switch (input) {
			case "1": // devpw_update() �̵� /

			case "2": // dev_delete() ���� �̵� /

			case "3": // ���α׷� ����
				break;
			default:
				continue;
			}
			return input;
		}

	}

	public static String super_menu() {
		while (true) {
			System.out.println("������������������������������������������������������������");
			System.out.println("[1] ȸ������ [2] ���ӻ��� [3] ����");
			System.out.println("������������������������������������������������������������");
			System.out.print("�޴��� �����ϼ��� >> ");
			String input = scan.next();
			switch (input) {
			case "1":
			case "2":
			case "3":
				break;
			default:
				continue;
			}
			return input;
		}
	}

}