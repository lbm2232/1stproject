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
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("  Steem¿¡ ¹æ¹®ÇÏ½Å °ÍÀ» È¯¿µÇÕ´Ï´Ù.");
		System.out.println("         Ver.0.1.6          ");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");

	}

	public static String select_login_join() {

		while (true) {
			System.out.println("[1] ·Î±×ÀÎ [2] È¸¿ø°¡ÀÔ [3] Á¾·á");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
			String s = scan.next();
			switch (s) {
			case "1":
			case "2":
				break;
			case "3":
				System.out.println("Á¾·áµÇ¾ú½À´Ï´Ù.");
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
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ÀÏ¹Ý È¸¿ø°¡ÀÔ [2] °³¹ßÀÚ È¸¿ø°¡ÀÔ");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("È¸¿ø Å¸ÀÔÀ» ¼±ÅÃÇÏ¼¼¿ä >> ");
			s = scan.next();
			switch (s) {
			case "1":
			case "2":
				break;
			default:
				System.out.println("´Ù½ÃÀÔ·ÂÇÏ¼¼¿ä.");
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
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1]RPG [2]FPS [3]SPORTS [4]ARCADE [5]µÚ·Î°¡±â" );
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¼±È£ÇÏ´Â Àå¸£¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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
			System.out.println("Áßº¹µÈ IDÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇÏ¼¼¿ä.");
			System.out.print("ID : ");
			new_id = scan.next();
		}
		new_user.setUser_id(new_id);

		System.out.print("PASSWORD : ");
		new_user.setPwd(scan.next());
		System.out.print("PASSWORD confirm : ");
		while (!new_user.getPwd().equals(scan.next())) {
			System.out.println("ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
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
			System.out.println("Áßº¹µÈ IDÀÔ´Ï´Ù. ´Ù½Ã ÀÔ·ÂÇÏ¼¼¿ä.");
			System.out.print("ID : ");
			new_id = scan.next();
		}
		new_user.setUser_id(new_id);

		System.out.print("PASSWORD : ");
		new_user.setPwd(scan.next());
		System.out.print("PASSWORD confirm : ");
		while (!new_user.getPwd().equals(scan.next())) {
			System.out.println("ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
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
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("[1] RPG [2] FPS [3] AOS [4]Shooting [5] etc ");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.print("¼±È£ÇÏ´Â °ÔÀÓÀå¸£ >> ");
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
				System.out.println("´Ù½Ã ÀÔ·ÂÇÏ¼¼¿ä ");
				System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.print("[1] RPG [2] FPS [3] AOS [4]Shooting [5] etc ");
				System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
				System.out.println("¼±È£ÇÏ´Â °ÔÀÓÀå¸£ >> ");
				favorite = scan.next();
				continue;
			}
			return result;
		}

	}

	public static String user_init() {
		while (true) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ¸¶ÀÌÆäÀÌÁö [2] »óÁ¡ [3] Á¾·á");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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

	}// À¯Àú ÃÊ±âÈ­¸é

	public static String user_mypage() {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] º¸À¯ ±Ý¾× [2] º¸À¯ °ÔÀÓ¸ñ·Ï [3] È¸¿øÁ¤º¸º¯°æ [4] µÚ·Î°¡±â ");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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

	public static String user_mypage_wallet() { // Áö°©

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ÃæÀü [2] Ã³À½À¸·Î ");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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

	public static String wallet_charge() { // ÃæÀü

		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ÃæÀü±Ý¾× [2] µÚ·Î°¡±â ");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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

	public static String user_mypage_drop() { // Å»Åð

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("Å»ÅðÇÏ½Ã°Ú½À´Ï±î?");
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ¿¹ [2] ¾Æ´Ï¿À ");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
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
		// °ÔÀÓ¸®½ºÆ® Ãâ·Â

		System.out.println("°ÔÀÓ ¹øÈ£¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
		scan.next();

		// ¼±ÅÃÇÑ°ÔÀÓ ÇÃ·¹ÀÌ?
	}

	public static String user_market_search() { // »óÁ¡ [2]
		while (true) {
			// °ÔÀÓ ¸®½ºÆ® Ãß°¡ ÇØ¼­ ÀÔ·Â
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ÀÌ¸§  [2] Àå¸£  [3] µ¹¾Æ°¡±â ");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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
		System.out.print("ÃæÀüÇÒ ±Ý¾×À» ÀÔ·ÂÇÏ¼¼¿ä >> ");
		return scan.nextInt();
	}

	public static int money_minus() {
		System.out.print("ÀÎÃâÇÒ ±Ý¾×À» ÀÔ·ÂÇÏ¼¼¿ä >> ");
		return -scan.nextInt();
	}

	public static String user_market() { // »óÁ¡ ¸ÞÀÎ
		while (true) {
			// °ÔÀÓ ¸®½ºÆ® Ãß°¡ ÇØ¼­ ÀÔ·Â
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ÃßÃµ °ÔÀÓ  [2] °ÔÀÓ °Ë»ö  [3] µÚ·Î °¡±â");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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

	public static String user_market_purchase() { // »óÁ¡[1][1]
		while (true) {
			// ÃßÃµ °ÔÀÓ ¸®½ºÆ® Ãß°¡ ÇØ¼­ ÀÔ·Â
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] °ÔÀÓ ±¸¸Å [2] µÚ·Î °¡±â");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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
		switch (SteamView.user_market_purchase()) {// db¿¡¼­ ÃßÃµ°ÔÀÓ Á¤º¸ ºÒ·¯¿ÂÈÄ ÀÔ·Â ¹Þ¾Æ¼­ ÇÏ³ª¼±ÅÃ
		case "1":
			// db¿¡ ±¸¸ÅÁ¤º¸ Ãß°¡
			System.out.println("±¸¸Å°¡ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
			break;
		case "2":
			System.out.println("±¸¸Å°¡ Ãë¼Ò µÇ¾ú½À´Ï´Ù.");
			b = false;
			break;

		}
		return b;

	}

	public static String dev_init() {
		while (true) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] °ÔÀÓ [2] Money [3] ¸¶ÀÌÆäÀÌÁö [4] Á¾·á");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
			String input = scan.next();
			switch (input) {
			case "1":

			case "2":

			case "3": // dev_mypage() ·Î < --

			case "4":
				break;
			default:
				continue;
			}
			return input;
		}

	}

//[1] ³» °ÔÀÓ ÇöÈ² [2] °ÔÀÓ ÆÇ¸Å µî·Ï [3] °ÔÀÓ ¼öÁ¤ µî·Ï [4] °ÔÀÓ Á¦°Å
	public static String mygame() {
		while (true) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] °ÔÀÓ µî·Ï [2] °ÔÀÓ ¼öÁ¤ [3] °ÔÀÓ »èÁ¦ [4] µÚ·Î°¡±â");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
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
		// ÆÇ¸ÅÇÒ °ÔÀÓ¿¡ ´ëÇÑ Á¤º¸¸¦ ÀÔ·Â¹Þ¾Æ sell_game¿¡ µî·Ï
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println(" ÆÇ¸ÅÇÒ °ÔÀÓ¿¡ ´ëÇÑ Á¤º¸¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println("°ÔÀÓ ÀÌ¸§ :");
		dev_sellgame.setName(scan.next());
		System.out.println("°ÔÀÓ °¡°Ý :");
		dev_sellgame.setPrice(scan.nextInt());
		System.out.println("°ÔÀÓ Àå¸£ :");
		dev_sellgame.setGenre(scan.next());
		System.out.println("°ÔÀÓ ¼³¸í :");
		dev_sellgame.setGame_info(scan.next());
		System.out.println("* " + dev_sellgame.getName() + " * °ÔÀÓÀÌ µî·ÏµÇ¾ú½À´Ï´Ù.");
		return dev_sellgame;
	}

	public static String updategame() {
		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("¾÷µ¥ÀÌÆ® ÇÒ °ÔÀÓ ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä.");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		return scan.next();

	}

	public static String updategame_by() {
		while (true) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¼öÁ¤ÇÒ Á¤º¸¸¦ È®ÀÎÇØÁÖ¼¼¿ä - [1] °ÔÀÓ °¡°Ý [2] °ÔÀÓ Àå¸£ [3] °ÔÀÓ ¼³¸í [4] µ¹¾Æ°¡±â");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >>");
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
		System.out.print("°ÔÀÓ ¹øÈ£ : ");
		int updatewhat1 = scan.nextInt();
		return updatewhat1;
	}

	public static int update_price() {
		System.out.print("¹Ù²Ü °¡°Ý : ");
		int updatewhat1 = scan.nextInt();
		return updatewhat1;
	}

	public static String update_genre() {
		System.out.print("¹Ù²Ü Àå¸£ : ");
		String updatewhat2 = scan.next();
		return updatewhat2;
	}

	public static String update_info() {
		System.out.print("¹Ù²Ü ¼³¸í : ");
		String updatewhat3 = scan.next();
		return updatewhat3;
	}

	public static String deletegame() {
		while (true) {
			System.out.println("»èÁ¦ÇÒ °ÔÀÓ¿¡ ´ëÇÑ ÀÌ¸§À» ÀÔ·ÂÇØÁÖ¼¼¿ä. ");
//   for (GameVO game : games){
//   System.out.println(game);
			String deletegame = scan.next();
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("(deletegame)À» Á¤¸» »èÁ¦ÇÏ½Ã°Ú½À´Ï±î?" + "\n" + "[1] ³× [2] ¾Æ´Ï¿À");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >>");
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
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ¼öÀÍÁ¶È¸ [2] ÀÜ¾× [3] ÀÎÃâ [4] µÚ·Î°¡±â");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >>");
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
			System.out.println("ºñ¹Ð¹øÈ£¸¦ º¯°æÇÏ½Ã°Ú½À´Ï±î? ");
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ¼ö¶ô [2] ¾Æ´Ï¿À");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.println("¹øÈ£¸¦ ¼±ÅÃÇÏ¼¼¿ä >>");
			String input = scan.next();
			switch (input) {
			case "1": // update±â´ÉÀ¸·Î ÆÐ½º¿öµå ¾÷µ¥ÀÌÆ®

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
		System.out.print("ÇÃ·¹ÀÌÇÏ½Ç °ÔÀÓÀ» ¹øÈ£¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
		int game_num = scan.nextInt();

		return game_num;
	}

	public static int select_game() {
		boolean gamein = false;
		GameDAO check = new GameDAO();
		int game_num =0;
		while (!gamein) {
			System.out.print("±¸¸ÅÇÏ½Ç °ÔÀÓÀ» ¹øÈ£¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
			game_num = scan.nextInt();		
			for (GameVO e : check.super_select_game()) {
				if (e.getNum() == game_num) {
					gamein = true;
					break; 
				}
			}
			if(gamein == false) {
			System.out.println("µî·ÏµÇÁö ¾ÊÀº °ÔÀÓ¹øÈ£ ÀÔ´Ï´Ù.");
			}
		}

		System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
		System.out.println("[1] ±¸¸ÅÈ®Á¤  [2] ±¸¸ÅÃë¼Ò >> ");
		System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
		System.out.println("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] °ÔÀÓ±¸¸Å [2] µÚ·Î°¡±â");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >>");
			String input = scan.next();
			switch (input) {
			case "1": // update±â´ÉÀ¸·Î ÆÐ½º¿öµå ¾÷µ¥ÀÌÆ®
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
			System.out.println("Á¤¸»·Î È¸¿ø Å»Åð ÇÏ½Ã°Ú½À´Ï±î? ");
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1]¿¹ [2] ¾Æ´Ï¿À");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] ºñ¹Ð¹øÈ£º¯°æ [2] È¸¿øÅ»Åð [3] µ¹¾Æ°¡±â");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
			String input = scan.next();
			switch (input) {
			case "1": // devpw_update() ÀÌµ¿ /

			case "2": // dev_delete() À¸·Î ÀÌµ¿ /

			case "3": // ÇÁ·Î±×·¥ Á¾·á
				break;
			default:
				continue;
			}
			return input;
		}

	}

	public static String super_menu() {
		while (true) {
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("[1] È¸¿ø»èÁ¦ [2] °ÔÀÓ»èÁ¦ [3] Á¾·á");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			System.out.print("¸Þ´º¸¦ ¼±ÅÃÇÏ¼¼¿ä >> ");
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