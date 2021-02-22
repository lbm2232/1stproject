package kr.co.smhrd.steam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.smhrd.steam.model.GameVO;
import kr.co.smhrd.steam.model.UserVO;

public class GameDAO implements GameDAOI {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@smhrdai.cp9am5l5aof2.us-east-2.rds.amazonaws.com:1521:ORCL";
		String id = "smhrd";
		String pw = "coding12";
		try {
//			con = DriverManager.getConnection(url, id, pw);
			con = DriverManager.getConnection(url, id, pw);
//			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return con;
	}

	private void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// nothing
			}
		}
	}

	@Override
	public void insert_user(UserVO new_user) {
		String sql = "insert into CUSTOMER VALUES(?,?,?,?,?)";
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, new_user.getUser_id());
			ps.setString(2, new_user.getPwd());
			ps.setInt(3, new_user.getType());
			ps.setString(4, new_user.getGenre());
			ps.setInt(5, new_user.getMoney());

			if (ps.executeUpdate() == 1) {
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
				System.out.println("�α��� ȭ������ ��ȯ�˴ϴ�.");
			} else {
				System.out.println("ȸ������ ���� - �ߺ��� ���̵� �����մϴ�.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public int cash_check(String new_user_id) {

		String sql = "select money from CUSTOMER where user_id = ? ";
		Connection conn = getConnection();
		int money = -1;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, new_user_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				money = rs.getInt("money");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return money;
	}

	@Override
	public void cash_plus(String new_user_id, int pay) {
		String sql = "update CUSTOMER set money=? where user_id=?";
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cash_check(new_user_id) + pay);
			ps.setString(2, new_user_id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public GameVO select_by_name(String name) {
		// TODO Auto-generated method stub
		String sql = "select * from game where name = ?";
		GameVO selected_game = new GameVO();
		Connection conn = getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				selected_game.setNum(rs.getInt("num"));
				selected_game.setName(rs.getString("name"));
				selected_game.setPrice(rs.getInt("price"));
				selected_game.setGenre(rs.getString("genre"));
				selected_game.setDev_name(rs.getString("dev_name"));
				selected_game.setGame_info(rs.getString("game_info"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return selected_game;
	}

	@Override
	public ArrayList<GameVO> select_by_genre(String genre) {
		String sql = "select * from game where genre = ?";
		ArrayList<GameVO> selected_games = new ArrayList<GameVO>();

		PreparedStatement ps;
		try {
			Connection conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				GameVO s_game = new GameVO();
				s_game.setNum(rs.getInt("num"));
				s_game.setName(rs.getString("name"));
				s_game.setPrice(rs.getInt("price"));
				s_game.setGenre(rs.getString("genre"));
				s_game.setDev_name(rs.getString("dev_name"));
				s_game.setGame_info(rs.getString("game_info"));
				selected_games.add(s_game);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selected_games;

	}

	@Override
	public ArrayList<GameVO> select_by_score(String score) {
		String sql = "select * from game where score = ?"; 
		ArrayList<GameVO> selected_games = new ArrayList<GameVO>();
		Connection conn = getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, score);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				GameVO s_game = new GameVO();
				s_game.setNum(rs.getInt("num"));
				s_game.setName(rs.getString("name"));
				s_game.setPrice(rs.getInt("price"));
				s_game.setGenre(rs.getString("genre"));
				s_game.setDev_name(rs.getString("dev_name"));
				s_game.setGame_info(rs.getString("game_info"));
				selected_games.add(s_game);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int search_game_price(int num) {
		String sql = "select price from game where num = ?";
		int price = 10000;
		Connection conn = getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				price = rs.getInt("price");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	@Override
	public String search_game_name(int num) {
		String sql = "select name from game where num = ?";
		String name = "";
		Connection conn = getConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				name = rs.getString("name");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public ArrayList<GameVO> purchased_game(String user_id) {
		String url = "jdbc:oracle:thin:@smhrdai.cp9am5l5aof2.us-east-2.rds.amazonaws.com:1521/ORCL";
		String id = "smhrd";
		String pw = "coding12";
		Connection conn = getConnection();
		ArrayList<GameVO> result = new ArrayList<GameVO>();
		try {
			conn = DriverManager.getConnection(url, id, pw);
			String sql = "select * from shop where customer_user_id = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int gnum = rs.getInt("game_num");
				String sql2 = "select * from game where num = ? ";
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, gnum);
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					GameVO g = new GameVO();
					g.setName(rs2.getString("name"));
					g.setNum(rs2.getInt("num"));

					result.add(g);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void insert_purchsed(String user_id, int game_num) {
		String sql = "insert into SHOP VALUES(?,?,?)";
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setInt(2, game_num);
			ps.setInt(3, search_game_price(game_num));
			if (ps.executeUpdate() == 1) {
				System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
			} else {
				System.out.println("���Ž���");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public UserVO search_user(String user_id) {
		String sql = "select * from customer where user_id = ?";
		int b = 0;
		Connection conn = getConnection();
		PreparedStatement ps;
		UserVO user = new UserVO();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setUser_id(rs.getString("user_id"));
				user.setPwd(rs.getString("pwd"));
				user.setMoney(rs.getInt("money"));
				user.setType(rs.getInt("type"));
				user.setGenre(rs.getString("genre"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	public void print(ArrayList arr) {
		for (Object o : arr) {
			System.out.println(o);
		}
	}

	// �����ڸ޴�

	// (0-1) ���Ӹ�� ȣ�� : Game DB���� ������ ID�� ��ġ�ϴ� ������ �̸��� ȣ���ϱ� (5/all)
	public ArrayList<GameVO> Search_game_by_uname(String s) {
		Connection con = null;
		ArrayList<GameVO> gv = new ArrayList<GameVO>();

		try {
			con = getConnection();
			String SQL = "select * from game where dev_name=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setObject(1, s);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { // 5���� ���� �Ϸ��� for������ �ؾߵǴµ� ���� �� ��
				GameVO g = new GameVO();
				g.setNum(rs.getInt("num"));
				g.setName(rs.getString("name"));
				g.setPrice(rs.getInt("price"));
				g.setDev_name(rs.getString("dev_name"));
				g.setGenre(rs.getString("genre"));
				g.setGame_info(rs.getString("GAME_INFO"));
				gv.add(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gv;
	}

	// (0-2) ���� ȣ�� : Game DB���� �Է��� Name�� ��ġ�ϴ� ���� ȣ���ϱ�
	public GameVO import_gamename(String name) {
		Connection con = null;
		GameVO g = new GameVO();
		try {
			con = getConnection();

			String SQL = "select * from game where NAME = ?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				g.setNum(rs.getInt("num"));
				g.setDev_name(rs.getString("name"));
				g.setPrice(rs.getInt("price"));
				g.setGenre(rs.getString("genre"));
				g.setName(rs.getString("dev_name"));
				g.setGame_info(rs.getString("game_info"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return g;
	}

	// (0-3) ���� Ȯ�� : Customer DB���� ������ID�� ��ġ�ϴ� ȸ�������� ����(ID,PWD) ȣ���ϱ�
	public UserVO import_devprofile(String user_id) {
		Connection con = null;
		UserVO uv = new UserVO();
		try {
			con = getConnection();
			String SQL = "select * from customer where user_id=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, user_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				uv.setUser_id(rs.getString("user_id"));
				uv.setPwd(rs.getString("pwd"));
				uv.setMoney(rs.getInt("money"));
				uv.setType(rs.getInt("type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uv;
	}

	// (0-4) �����̸��� �ް� ����Ȯ���ϱ�
	public int check_price(String name) {
		Connection con = null;
		int g_price = 0;
		try {
			con = getConnection();
			String SQL = "select price from game where name=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				g_price = rs.getInt("price");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return g_price;
	}

	// (0-5) �����̸��� �ް� �帣Ȯ���ϱ�
	public String check_genre(String name) {
		Connection con = null;
		String g_genre = null;
		try {
			con = getConnection();
			String SQL = "select genre from game where name=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				g_genre = rs.getString("genre");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return g_genre;
	}

	// (0-6) �����̸��� �ް� ����Ȯ���ϱ�
	public String check_game_info(String name) {
		Connection con = null;
		String g_game_info = null;
		try {
			con = getConnection();
			String SQL = "select game_info from game where name=?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				g_game_info = rs.getString("game_info");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return g_game_info;
	}

	// (1-1) ���ӵ�� : �����̸�, ����, �帣, ������ �Է¹޾� Game DB�� ���̵�� �Բ� �ø���
	public void put_game(GameVO gv) {
		Connection con = null;
		try {
			con = getConnection();
			String SQL = "insert into game values(seqq.nextval,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, gv.getName());
			ps.setInt(2, gv.getPrice());
			ps.setString(3, gv.getGenre());
			ps.setString(4, gv.getDev_name()); // ���� ����� ���� ���ߵ�
			ps.setString(5, gv.getGame_info());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (1-2) ���Ӽ��� P : (0-4)�� ���ؼ� ȣ����� ���ӿ� ���ؼ� ���� ������ �����ְ� ������ �� �Է� �ޱ�
	public void update_game_price(int num, int price) {
		Connection con = null;
//	      SteamDAO dao = new SteamDAO();
//	      String a = dao.check_price("�����̸�");
//	      System.out.println(a);
		try {

			con = getConnection();
			String SQL = "update game set price=? where num = ?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, price);
			ps.setInt(2, num);

			ps.executeUpdate();
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (1-3) ���Ӽ��� G : (0-2)�� ���ؼ� ȣ����� ���ӿ� ���ؼ� ���� �帣�� �����ְ� ������ �� �Է� �ޱ�
	public void update_game_genre(int gnum, String genre) {
		Scanner scan = new Scanner(System.in);
		Connection con = null;
//	      SteamDAO dao = new SteamDAO();
//	      String a = dao.check_genre("�����̸�");
//	      System.out.println(a);
		try {
			con = getConnection();
			String SQL = "update game set genre=? where num = ?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, genre);
			ps.setInt(2, gnum);
			ps.executeUpdate();
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (1-4) ���Ӽ��� D : (0-2)�� ���ؼ� ȣ����� ���ӿ� ���ؼ� ���� ������ �����ְ� ������ �� �Է� �ޱ�
	public void update_game_info(int gnum, String info) {
		Connection con = null;
//	      SteamDAO dao = new SteamDAO();
//	      String a = dao.check_game_info("�����̸�");
//	      System.out.println(a);
		try {
			con = getConnection();
			String SQL = "update game set game_info=? where num = ?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, info);
			ps.setInt(2, gnum);
			ps.executeUpdate();
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// (1-5) ���ӻ��� : (0-3)�� ���ؼ� ȣ����� ���ӿ� ���ؼ� ���� �̸��� �����ְ�, ���� ������ ������ ���θ� ���� ��
	// Ȯ�ο� �����Ѵٸ� Game DB���� (0-3)�� ���� ���� �����ϱ�
	@Override
	public void delete_game(int num) {
		// game table ���� ���� ����
		Connection conn = null;
		conn = getConnection();
		try {
			String sql = "DELETE SHOP WHERE GAME_NUM=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
			sql = "DELETE GAME WHERE NUM = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("���� ������ �Ϸ�Ǿ����ϴ�");

	}

	@Override
	public int income(int num) {
		Connection con = null;
		int income = 0;
		try {
			con = getConnection();
			String SQL = "select * from shop where game_num = ?";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, num);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				income += rs.getInt("price");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return income;
	}

	@Override
	public int total_income(String user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String update_devpwd() {
		Scanner scan = new Scanner(System.in);
		System.out.println("����й�ȣ�� �����մϴ٣�");
		System.out.print("���̵� �Է��ϼ��� >> ");
		String user_id = scan.next();
		System.out.print("�ٲ� ��й�ȣ�� �Է��ϼ��� >> ");
		String pwd = scan.next();
		String sql = "update customer set pwd = ? where user_id =?";
		Connection conn = null;
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, user_id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("��й�ȣ�� ������ �Ϸ��߽��ϴ�");
		return null;
	}

	@Override
	// (3-2) ȸ�� Ż�� : (0-4)�� ���� ȸ�������� Ȯ�ν�Ű�� , �������θ� ���� ���� �� DB���� ������ ID�� ��ġ�ϴ� ���� �����ϱ�
	public String delete_devprofile() {
		Scanner scan = new Scanner(System.in);
		System.out.print("���̵� �Է����ּ��� >> ");
		String user_id = scan.next();
		System.out.println("���̵� �����մϴ�");
		String sql1 = "delete from shop where customer_user_id=?"; // shop table ���� �ڽ�Ű ���� ����
		String sql2 = "delete from customer where user_id=?"; // customer table ���� ���� ����
		Connection conn = null;
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, user_id);
			ps.executeUpdate();
			System.out.println("������ �ִ� ��� �������������� �����Ͽ����ϴ�.");
		} catch (Exception e) {
//           e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setString(1, user_id);
			ps.executeUpdate();
			System.out.println("Ż��ó���� �Ϸ�Ǿ����ϴ�");
		} catch (Exception e) {
//           e.printStackTrace();
		}

		return null;
	}

	@Override
	public void super_delete_user(String id) {
		String sql1 = "delete from shop where customer_user_id=?"; // shop table ���� �ڽ�Ű ���� ����
		String sql2 = "delete from customer where user_id=?"; // customer table ���� ���� ����
		Connection conn = null;
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setString(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void super_select_user() {

		String sql = "select * from CUSTOMER ";
		Connection conn = getConnection();
		UserVO u = new UserVO();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u.setGenre(rs.getString("genre"));
				u.setUser_id((rs.getString("user_id")));
				u.setPwd(rs.getString("pwd"));
				u.setType(rs.getInt("type"));
				u.setMoney(rs.getInt("money"));

				System.out.println(u);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<GameVO> super_select_game() {

		String sql = "select * from game ";
		Connection conn = getConnection();
		
		ArrayList<GameVO> list = new ArrayList<GameVO>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GameVO u = new GameVO();
				u.setNum(rs.getInt("num"));
				u.setName(rs.getString("name"));
				u.setPrice(rs.getInt("price"));
				u.setGenre(rs.getString("genre"));
				u.setDev_name(rs.getString("dev_name"));
				u.setGame_info(rs.getString("game_info"));
				list.add(u);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return list;

	}

	@Override
	public void delete_user(String new_user_id) {
		// TODO Auto-generated method stub

	}

	@Override
	public int import_totalincome(String user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<GameVO> import_eachincome(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int import_withdraw(String user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int import_moneycheck(String user_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
