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
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("  Steem縑 寞僥ж褐 匙擊 �紊腎桭炴�.");
		System.out.println("         Ver.0.1.6          ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式戎");

	}

	public static String select_login_join() {

		while (true) {
			System.out.println("[1] 煎斜檣 [2] �蛾灠㊣� [3] 謙猿");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
			String s = scan.next();
			switch (s) {
			case "1":
			case "2":
				break;
			case "3":
				System.out.println("謙猿腎歷蝗棲棻.");
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
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 橾奩 �蛾灠㊣� [2] 偃嫦濠 �蛾灠㊣�");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("�蛾� 顫殮擊 摹鷗ж撮蹂 >> ");
			s = scan.next();
			switch (s) {
			case "1":
			case "2":
				break;
			default:
				System.out.println("棻衛殮溘ж撮蹂.");
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
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1]RPG [2]FPS [3]SPORTS [4]ARCADE [5]菴煎陛晦" );
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("摹��ж朝 濰腦蒂 摹鷗ж撮蹂 >> ");
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
			System.out.println("醞犒脹 ID殮棲棻. 棻衛 殮溘ж撮蹂.");
			System.out.print("ID : ");
			new_id = scan.next();
		}
		new_user.setUser_id(new_id);

		System.out.print("PASSWORD : ");
		new_user.setPwd(scan.next());
		System.out.print("PASSWORD confirm : ");
		while (!new_user.getPwd().equals(scan.next())) {
			System.out.println("綠塵廓�ㄟ� 橾纂ж雖 彊蝗棲棻.");
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
			System.out.println("醞犒脹 ID殮棲棻. 棻衛 殮溘ж撮蹂.");
			System.out.print("ID : ");
			new_id = scan.next();
		}
		new_user.setUser_id(new_id);

		System.out.print("PASSWORD : ");
		new_user.setPwd(scan.next());
		System.out.print("PASSWORD confirm : ");
		while (!new_user.getPwd().equals(scan.next())) {
			System.out.println("綠塵廓�ㄟ� 橾纂ж雖 彊蝗棲棻.");
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
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("[1] RPG [2] FPS [3] AOS [4]Shooting [5] etc ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.print("摹��ж朝 啪歜濰腦 >> ");
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
				System.out.println("棻衛 殮溘ж撮蹂 ");
				System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
				System.out.print("[1] RPG [2] FPS [3] AOS [4]Shooting [5] etc ");
				System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
				System.out.println("摹��ж朝 啪歜濰腦 >> ");
				favorite = scan.next();
				continue;
			}
			return result;
		}

	}

	public static String user_init() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 葆檜む檜雖 [2] 鼻薄 [3] 謙猿");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
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

	}// 嶸盪 蟾晦�飛�

	public static String user_mypage() {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 爾嶸 旎擋 [2] 爾嶸 啪歜跡煙 [3] �蛾讔內蛹秣� [4] 菴煎陛晦 ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
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

	public static String user_mypage_wallet() { // 雖骨

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 醱瞪 [2] 籀擠戲煎 ");
			System.out.println("戌式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
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

	public static String wallet_charge() { // 醱瞪

		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 醱瞪旎擋 [2] 菴煎陛晦 ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("詭景蒂 摹鷗ж撮蹂 >> ");
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

	public static String user_mypage_drop() { // 驍黴

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("驍黴ж衛啊蝗棲梱?");
			System.out.println("忙式式式式式式式式式式式式式忖");
			System.out.println("[1] 蕨 [2] 嬴棲螃 ");
			System.out.println("戌式式式式式式式式式式式式式戎");
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
		// 啪歜葬蝶お 轎溘

		System.out.println("啪歜 廓�ㄧ� 摹鷗ж撮蹂 >> ");
		scan.next();

		// 摹鷗и啪歜 Ы溯檜?
	}

	public static String user_market_search() { // 鼻薄 [2]
		while (true) {
			// 啪歜 葬蝶お 蹺陛 п憮 殮溘
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 檜葷  [2] 濰腦  [3] 給嬴陛晦 ");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
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
		System.out.print("醱瞪й 旎擋擊 殮溘ж撮蹂 >> ");
		return scan.nextInt();
	}

	public static int money_minus() {
		System.out.print("檣轎й 旎擋擊 殮溘ж撮蹂 >> ");
		return -scan.nextInt();
	}

	public static String user_market() { // 鼻薄 詭檣
		while (true) {
			// 啪歜 葬蝶お 蹺陛 п憮 殮溘
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 蹺繭 啪歜  [2] 啪歜 匐儀  [3] 菴煎 陛晦");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
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

	public static String user_market_purchase() { // 鼻薄[1][1]
		while (true) {
			// 蹺繭 啪歜 葬蝶お 蹺陛 п憮 殮溘
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 啪歜 掘衙 [2] 菴煎 陛晦");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
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
		switch (SteamView.user_market_purchase()) {// db縑憮 蹺繭啪歜 薑爾 碳楝螞�� 殮溘 嫡嬴憮 ж釭摹鷗
		case "1":
			// db縑 掘衙薑爾 蹺陛
			System.out.println("掘衙陛 諫猿腎歷蝗棲棻.");
			break;
		case "2":
			System.out.println("掘衙陛 鏃模 腎歷蝗棲棻.");
			b = false;
			break;

		}
		return b;

	}

	public static String dev_init() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 啪歜 [2] Money [3] 葆檜む檜雖 [4] 謙猿");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
			String input = scan.next();
			switch (input) {
			case "1":

			case "2":

			case "3": // dev_mypage() 煎 < --

			case "4":
				break;
			default:
				continue;
			}
			return input;
		}

	}

//[1] 頂 啪歜 ⑷�� [2] 啪歜 っ衙 蛔煙 [3] 啪歜 熱薑 蛔煙 [4] 啪歜 薯剪
	public static String mygame() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 啪歜 蛔煙 [2] 啪歜 熱薑 [3] 啪歜 餉薯 [4] 菴煎陛晦");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
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
		// っ衙й 啪歜縑 渠и 薑爾蒂 殮溘嫡嬴 sell_game縑 蛔煙
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println(" っ衙й 啪歜縑 渠и 薑爾蒂 殮溘п輿撮蹂.");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("啪歜 檜葷 :");
		dev_sellgame.setName(scan.next());
		System.out.println("啪歜 陛問 :");
		dev_sellgame.setPrice(scan.nextInt());
		System.out.println("啪歜 濰腦 :");
		dev_sellgame.setGenre(scan.next());
		System.out.println("啪歜 撲貲 :");
		dev_sellgame.setGame_info(scan.next());
		System.out.println("* " + dev_sellgame.getName() + " * 啪歜檜 蛔煙腎歷蝗棲棻.");
		return dev_sellgame;
	}

	public static String updategame() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("機等檜お й 啪歜 檜葷擊 殮溘ж撮蹂.");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式戎");
		return scan.next();

	}

	public static String updategame_by() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("熱薑й 薑爾蒂 �挫恉媮祤撚� - [1] 啪歜 陛問 [2] 啪歜 濰腦 [3] 啪歜 撲貲 [4] 給嬴陛晦");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >>");
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
		System.out.print("啪歜 廓�� : ");
		int updatewhat1 = scan.nextInt();
		return updatewhat1;
	}

	public static int update_price() {
		System.out.print("夥羚 陛問 : ");
		int updatewhat1 = scan.nextInt();
		return updatewhat1;
	}

	public static String update_genre() {
		System.out.print("夥羚 濰腦 : ");
		String updatewhat2 = scan.next();
		return updatewhat2;
	}

	public static String update_info() {
		System.out.print("夥羚 撲貲 : ");
		String updatewhat3 = scan.next();
		return updatewhat3;
	}

	public static String deletegame() {
		while (true) {
			System.out.println("餉薯й 啪歜縑 渠и 檜葷擊 殮溘п輿撮蹂. ");
//   for (GameVO game : games){
//   System.out.println(game);
			String deletegame = scan.next();
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("(deletegame)擊 薑蜓 餉薯ж衛啊蝗棲梱?" + "\n" + "[1] 啻 [2] 嬴棲螃");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("詭景蒂 摹鷗ж撮蹂 >>");
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
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 熱櫛褻�� [2] 濤擋 [3] 檣轎 [4] 菴煎陛晦");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.println("詭景蒂 摹鷗ж撮蹂 >>");
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
			System.out.println("綠塵廓�ㄧ� 滲唳ж衛啊蝗棲梱? ");
			System.out.println("忙式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 熱塊 [2] 嬴棲螃");
			System.out.println("戌式式式式式式式式式式式式式式式戎");
			System.out.println("廓�ㄧ� 摹鷗ж撮蹂 >>");
			String input = scan.next();
			switch (input) {
			case "1": // update晦棟戲煎 ぬ蝶錶萄 機等檜お

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
		System.out.print("Ы溯檜ж褒 啪歜擊 廓�ㄧ� 摹鷗ж撮蹂 >> ");
		int game_num = scan.nextInt();

		return game_num;
	}

	public static int select_game() {
		boolean gamein = false;
		GameDAO check = new GameDAO();
		int game_num =0;
		while (!gamein) {
			System.out.print("掘衙ж褒 啪歜擊 廓�ㄧ� 摹鷗ж撮蹂 >> ");
			game_num = scan.nextInt();		
			for (GameVO e : check.super_select_game()) {
				if (e.getNum() == game_num) {
					gamein = true;
					break; 
				}
			}
			if(gamein == false) {
			System.out.println("蛔煙腎雖 彊擎 啪歜廓�� 殮棲棻.");
			}
		}

		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("[1] 掘衙�挨�  [2] 掘衙鏃模 >> ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("詭景蒂 摹鷗ж撮蹂 >> ");
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
			System.out.println("忙式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 啪歜掘衙 [2] 菴煎陛晦");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >>");
			String input = scan.next();
			switch (input) {
			case "1": // update晦棟戲煎 ぬ蝶錶萄 機等檜お
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
			System.out.println("薑蜓煎 �蛾� 驍黴 ж衛啊蝗棲梱? ");
			System.out.println("忙式式式式式式式式式式式式式忖");
			System.out.println("[1]蕨 [2] 嬴棲螃");
			System.out.println("戌式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
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
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] 綠塵廓�ㄩ秣� [2] �蛾躠酷� [3] 給嬴陛晦");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
			String input = scan.next();
			switch (input) {
			case "1": // devpw_update() 檜翕 /

			case "2": // dev_delete() 戲煎 檜翕 /

			case "3": // Щ煎斜極 謙猿
				break;
			default:
				continue;
			}
			return input;
		}

	}

	public static String super_menu() {
		while (true) {
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("[1] �蛾艭餑� [2] 啪歜餉薯 [3] 謙猿");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("詭景蒂 摹鷗ж撮蹂 >> ");
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