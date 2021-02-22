package kr.co.smhrd.steam.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.smhrd.steam.dao.GameDAO;
import kr.co.smhrd.steam.dao.GameDAOI;
import kr.co.smhrd.steam.model.GameVO;
import kr.co.smhrd.steam.model.UserVO;
import kr.co.smhrd.steam.view.SteamView;

public class Steamcontroller {

	private static UserVO current_user = new UserVO();
	private static UserVO input_user = new UserVO();
	private static GameDAOI dao = new GameDAO();
	private static ArrayList<GameVO> vd1 = new ArrayList<GameVO>();

	public static void appstart() {
		SteamView.start();
		switch (SteamView.select_login_join()) {
		case "2":
			switch (SteamView.select_join_type()) {
			case "1":
				dao.insert_user(SteamView.join("1"));
				break;
			case "2":
				dao.insert_user(SteamView.join2("2"));
				break;
			}// ���Ϲ��� ����� db�� ����
		case "1":
			input_user = SteamView.login();// db������ ��
			current_user = dao.search_user(input_user.getUser_id());
			if (SteamView.login_permit(input_user, current_user) == 1) {
				while (true) {
					switch (SteamView.user_init()) {
					case "1":
						switch (SteamView.user_mypage()) {
						case "1":
							current_user.setMoney(dao.cash_check(current_user.getUser_id()));
							System.out.println("���� �ܾ��� " + current_user.getMoney() + "�� �Դϴ�.");
							switch (SteamView.user_mypage_wallet()) {
							case "1":
								// db�� �����ϴ� �޼ҵ� ȣ��
								current_user.setMoney(SteamView.money_plus());
								dao.cash_plus(current_user.getUser_id(), current_user.getMoney());
								continue;
							case "2":
								continue;

							}
						case "2":
							vd1 = dao.purchased_game(current_user.getUser_id());
							if (vd1.size() == 0) {
								System.out.println("�����Ͻ� ������ �����ϴ�.");
							} else {

								for (int index = 0; index < vd1.size(); index++) {
									System.out.println("[ ���ӹ�ȣ = " + vd1.get(index).getNum() + ", �����̸� = " + " ]"
											+ vd1.get(index).getName());
								}
								int gnum = SteamView.select_game2();
								if (SteamView.update_permit(vd1, gnum)) {
									System.out.println("������ �������Դϴ�. ���� �̿뿡 ������ ��� �˼��մϴ�.");
								} else {
									System.out.println("�����Ͻ� ������ �ƴմϴ�.");
								}
							}
							continue;
						case "3":
							switch (SteamView.dev_mypage()) {
							case "1":
								switch (SteamView.devpw_update()) {
								case "1":
									dao.update_devpwd();
								case "2":
									continue;
								}
							case "2":
								switch (SteamView.dev_delete()) {
								case "1":
									dao.delete_devprofile();
									System.exit(1);
								case "2":
								}
								continue;
							case "3":
								continue;
							}
							break;
						case "4":
							continue;

						}
					case "2":
						while (true) {
							switch (SteamView.user_market()) {
							case "1":
								// select ��õ����
								dao.print(dao.select_by_genre(current_user.getGenre()));
								g_purch();
								continue;
							case "2":
								switch (SteamView.user_market_search()) {
								case "1":
									// select sort by name
									Scanner scan = new Scanner(System.in);
									System.out.print("���� ������ �Է��ϼ��� >>");
									String s = scan.next();
									if ((dao.select_by_name(s)).getName() == null) {
										System.out.println("�˻��� ������ �����ϴ�.");
									} else {
										System.out.println(dao.select_by_name(s));
										g_purch();
									}
									// db���� ���� ���� ���� �ޱ�

									continue;
								case "2":
									// select sort by genre
									String genre = SteamView.select_genre();
									if(genre == null) {
										continue;
									}else {
									dao.print(dao.select_by_genre(genre));
									g_purch();
									System.out.println("");
									continue;
									}
								case "3":
									continue;
								}
							case "3":
								break;
							}

							break;
						}
						continue;
					case "3":
						break;
					}
					break;
				}
			} else if (SteamView.login_permit(input_user, current_user) == 2) {
				while (true) {
					{
						switch (SteamView.dev_init()) {
						case "1":
							vd1 = dao.Search_game_by_uname((current_user.getUser_id()));
							System.out.println("������������������������������������������������");
							System.out.println("���� " + vd1.size() + "���� ������ �Ǹ� ���Դϴ�.");
							System.out.println("������������������������������������������������");
							dao.print(vd1);
							switch (SteamView.mygame()) {
							case "1":
								GameVO gv = SteamView.putgame();
								gv.setDev_name(current_user.getUser_id());
								dao.put_game(gv);
								continue;
							case "2":
								int gnum = SteamView.numselct();
								switch (SteamView.updategame_by()) {
								case "1":
									if (SteamView.update_permit(vd1, gnum)) {
										dao.update_game_price(gnum, SteamView.update_price());
									} else {
										System.out.println("���������� �����ϴ�.");
									}
									continue;
								case "2":
									if (SteamView.update_permit(vd1, gnum)) {
										dao.update_game_genre(gnum, SteamView.update_genre());
									} else {
										System.out.println("���������� �����ϴ�.");
									}
									continue;
								case "3":
									if (SteamView.update_permit(vd1, gnum)) {
										dao.update_game_info(gnum, SteamView.update_info());
									} else {
										System.out.println("���������� �����ϴ�.");
									}
									continue;
								}
								continue;
							case "3":
								gnum = SteamView.numselct();
								if (SteamView.update_permit(vd1, gnum)) {
									dao.delete_game(gnum);
								} else {
									System.out.println("���������� �����ϴ�.");
								}
								continue;
							case "4":
								continue;
							}
							break;
						case "2":
							int sum = 0;
							vd1 = dao.Search_game_by_uname((current_user.getUser_id()));
							System.out.println("����������������������������������������������������������������������������������");
							System.out.println("���� " + vd1.size() + "���� ������ �Ǹ� ���Դϴ�.");
							System.out.println("����������������������������������������������������������������������������������");
							dao.print(vd1);
							switch (SteamView.dev_money()) {
							case "1":
								for (int index = 0; index < vd1.size(); index++) {
									int income = dao.income(vd1.get(index).getNum());
									sum += income;
									System.out.println(vd1.get(index).getName() + " : " + income);
								}
								System.out.println("�Ѽ��� : " + sum);
								dao.cash_plus(current_user.getUser_id(), sum);
								continue;
							case "2":
								System.out.println("�ܾ� : " + dao.cash_check(current_user.getUser_id()));
								continue;
							case "3":
								int withdraw = -SteamView.money_minus();
								if (dao.cash_check(current_user.getUser_id()) <= withdraw) {
									System.out.println("�ܾ��� �����մϴ�.");
								} else {
									dao.cash_plus(current_user.getUser_id(), -withdraw);
								}
								continue;
							case "4":
								continue;
							}
							break;
						case "3":
							switch (SteamView.dev_mypage()) {
							case "1":
								switch (SteamView.devpw_update()) {
								case "1":
									dao.update_devpwd();
								case "2":
									continue;
								}
							case "2":
								switch (SteamView.dev_delete()) {
								case "1":
									dao.delete_devprofile();
									System.exit(1);
								case "2":
								}
								continue;
							case "3":
								continue;
							}
							break;
						case "4":
							System.exit(1);
						}
					}

				}
			} else if (SteamView.login_permit(input_user, current_user) == 3) {
				while (true) {
					switch (SteamView.super_menu()) {
					case "1":
						dao.super_select_user();
						Scanner scan = new Scanner(System.in);
						System.out.println("������ ȸ�� >>");
						dao.delete_user(scan.next());
						System.out.println("�����Ϸ�");
						break;
					case "2":
						dao.print(dao.super_select_game());
						dao.delete_game(SteamView.numselct());
						System.out.println("�����Ϸ�");
						break;
					case "3":
						System.exit(1);
						;
					}
				}
			} else {
				System.out.println("���̵�� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				appstart();
			}
		}

	}

	private static void g_purch() {
		switch (SteamView.game_purch()) {
		case "1":
			select_purch();
			System.out.println("");
			return;
		case "2":
			return;
		}
	}

	private static void select_purch() {
		int selected_game_num = SteamView.select_game();
		switch (selected_game_num) {
		case 0:
			System.out.println("���Ű� ��ҵǾ����ϴ�.");
			return;
		default:
			int cost = dao.search_game_price(selected_game_num);
			if (cost <= current_user.getMoney()) {
				dao.insert_purchsed(current_user.getUser_id(), selected_game_num);
				current_user.setMoney(current_user.getMoney() - cost);
				dao.cash_plus(current_user.getUser_id(), 0);
				System.out.println("�ܾ���" + current_user.getMoney() + "�Դϴ�.");
			} else {
				System.out.println("�ܾ��� �����մϴ�.");
			}
		}
	}

}
