import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		ArrayList<Player> player = new ArrayList<Player>();
		ArrayList<Achieve> achieve = new ArrayList<Achieve>();
		ArrayList<Achievement> achievement = new ArrayList<Achievement>();
		ArrayList<ComparePlayer> cmpPlayer = new ArrayList<ComparePlayer>();
		ArrayList<Play> play = new ArrayList<Play>();
		ArrayList<Game> game = new ArrayList<Game>();
		ArrayList<Friend> fren = new ArrayList<Friend>();

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		while (true) {
			System.out.print("Enter the option below" + "\n[1] ADD Player " + "\n[2] ADD Game" + "\n[3] ADD Achievement"
					+ "\n[4] ADD Friends" + "\n[5] Plays" + "\n[6] Achieve" + "\n[7] Friends Who Play"
					+ "\n[8] Compare Player" + "\n[9] Summarize Player" + "\n[10] Summarize Game"
					+ "\n[11] Summarize Achievement" + "\n[12] Achievement Ranking" + "\n[13] Exit"
					+ "\n CHOICE   :   ");
			int option = scan.nextInt();

			switch (option) {
			case 1:// ADD Player

				System.out.print("Player ID : ");
				int id = scan.nextInt();

				System.out.print("Player Name  : ");
				String name = scan2.nextLine();

				player.add(new Player(id, name));

				break;
			case 2:// ADD Game

				System.out.print("Game ID : ");
				int gameid = scan.nextInt();

				System.out.print("Game Name  : ");
				String gameName = scan2.nextLine();

				game.add(new Game(gameid, gameName));

				break;
			case 3:// ADD Achievement

				System.out.print("Achievement ID : ");
				int achievementId = scan.nextInt();

				System.out.print("achievement Name  : ");
				String achievementName = scan2.nextLine();

				System.out.print("Achievement Points : ");
				int achievementPoints = scan.nextInt();

				System.out.print("Game Id  : ");
				int gId = scan.nextInt();

				achievement.add(new Achievement(gId, achievementId, achievementName, achievementPoints));

				break;
			case 4:// ADD Friends

				System.out.print("Friend 1 ID : ");
				int f1Id = scan.nextInt();

				System.out.print("Friend 2 ID : ");
				int f2Id = scan.nextInt();

				fren.add(new Friend(f1Id, f2Id));

				break;
			case 5://Plays

				System.out.print("Player ID : ");
				int PId = scan.nextInt();

				System.out.print("Game ID : ");
				int GId = scan.nextInt();

				System.out.print("Player IGN : ");
				String PIGN = scan2.nextLine();

				play.add(new Play(PId, GId, PIGN));

				break;
			case 6://Achieve
				System.out.print("Player ID : ");
				int PlayerId = scan.nextInt();

				System.out.print("Game ID : ");
				int GameId = scan.nextInt();

				System.out.print("Achievement ID : ");
				int AchievementId = scan.nextInt();

				achieve.add(new Achieve(PlayerId, GameId, AchievementId));

				break;
			case 7:
				// Friends Who Play
				System.out.print("Player ID : ");
				PlayerId = scan.nextInt();

				System.out.print("Game ID : ");
				GameId = scan.nextInt();

				System.out.println("Friend Name    :      Friend ID      :       Player IGN");
				int v = -1;
				for (int i = 0; i < fren.size(); i++) {
					if (fren.get(i).getId1() == PlayerId) {
						for (int j = 0; j < play.size(); j++) {
							if (play.get(j).getGameId() == GameId  && play.get(j).getPlayerId()==fren.get(i).getId2()) {
								for (int k = 0; k < player.size(); k++) {
									if (player.get(k).getId() == fren.get(i).getId2()) {
										System.out.println(player.get(k).getName() + "\t\t" + player.get(k).getId()
												+ "\t\t" + play.get(j).getName());
										v = 0;
									}

								}
							}
						}
					}
				}

				if (v == 0)
					System.out.println("No Such Result Found");
				break;
			case 8:
				//Compare Player
				System.out.print("Player ID1 : ");
				PlayerId = scan.nextInt();
				System.out.print("Player ID2 : ");
				int PlayerId2 = scan.nextInt();
				System.out.print("Game ID : ");
				int gameId = scan.nextInt();

				for (int a = 0; a < game.size(); a++) {
					if (gameId == game.get(a).getId()) {
						System.out.println("Game Name :" + game.get(a).getName());
						break;
					}
				}

				for (int b = 0; b < player.size(); b++) {
					if (PlayerId == player.get(b).getId()) {
						System.out.println("Player 1 Name : " + player.get(b).getName());
					}

					if (PlayerId2 == player.get(b).getId()) {
						System.out.println("Player 2 Name : " + player.get(b).getName());
					}
				}

				System.out.println("Achievement for Player 1\n");
				System.out.println("Achievment name \t Achievement Score \t Achievement ID");
				System.out.println("--------------------------------------------------------------------------------");

				int score = 0;
				for (int c = 0; c < achieve.size(); c++) {
					if (PlayerId == achieve.get(c).getpId() && gameId == achieve.get(c).getgId()) {
						for (int d = 0; d < achievement.size(); d++) {
							if (achieve.get(c).getaId() == achievement.get(d).getaId()
									&& achievement.get(d).getgId() == gameId) {
								System.out.println(achievement.get(d).getaName() + "\t" + achievement.get(d).getPoints()
										+ "\t" + achievement.get(d).getaId());
								score += achievement.get(d).getPoints();
							}
						}
					}
				}

				System.out.println("Total score for player 2 : " + score);

				System.out.println("Achievement for Player 2\n");
				System.out.println("Achievment name \t Achievement Score \t Achievement ID");
				System.out.println("--------------------------------------------------------------------------------");

				int score2 = 0;
				for (int c = 0; c < achieve.size(); c++) {
					if (PlayerId2 == achieve.get(c).getpId() && gameId == achieve.get(c).getgId()) {
						for (int d = 0; d < achievement.size(); d++) {
							if (achieve.get(c).getaId() == achievement.get(d).getaId()
									&& achievement.get(d).getgId() == gameId) {
								System.out.println(achievement.get(d).getaName() + "\t" + achievement.get(d).getPoints()
										+ "\t" + achievement.get(d).getaId());
								score2 += achievement.get(d).getPoints();
							}
						}
					}
				}

				System.out.println("Total score for player 2 : " + score2);

				break;
			case 9:
				//Summarize Player
				System.out.print("Player ID : ");
				PlayerId = scan.nextInt();
				String IGN;
				for (int i = 0; i < player.size(); i++) {
					if (player.get(i).getId() == PlayerId) {
						System.out.println("Player Name : " + player.get(i).getName());
						int pt = 0;
						int h = 0;
						if (h == 0) {
							System.out.println("Game \t Achievement \t GameScore \t IGN");
							System.out.println("-------------------------------------------------------------------");
							h++;
						}
						for (int j = 0; j < play.size(); j++) {

							if (play.get(j).getPlayerId() == PlayerId) {
								for (int k = 0; k < game.size(); k++) {
									if (game.get(k).getId() == play.get(j).getGameId()) {
										System.out.print(game.get(k).getName() + "\t");

										int t = 0, o = 0, p = 0;
										for (int u = 0; u < achieve.size(); u++) {
											if (achieve.get(u).getpId() == PlayerId
													&& achieve.get(u).getgId() == game.get(k).getId()) {
												t++;
												
												for (int ui = 0; ui < achievement.size(); ui++) {
													if (achievement.get(ui).getgId() == game.get(k).getId() && 
															achievement.get(ui).getaId() == achieve.get(u).getaId()) {
														o++;
														p += achievement.get(ui).getPoints();
														pt += achievement.get(ui).getPoints();
													}
												}
											}
										}

										for (int u = 0; u < achievement.size(); u++) {
											if (achievement.get(u).getgId() == game.get(k).getId()  ) {
												o++;
												//p += achievement.get(u).getPoints();
												//pt += achievement.get(u).getPoints();
											}
										}
										if(p!=0)
											System.out.print(t + "/" + o + "\t" + p + "\t" + play.get(j).getName() + "\n");
									}
								}
							}
						}

						if (h == 0)
							System.out.println("NO Result Found");

						System.out.println("" + "total score : " + pt + "\nFriend \t GameScore");

						for (int a = 0; a < fren.size(); a++) {
							int k = 0;
							if (player.get(i).getId() == fren.get(a).getId1()) {
								for (int y = 0; y < achieve.size(); y++) {
									if (fren.get(a).getId2() == achieve.get(y).getpId()) {
										for (int u = 0; u < achievement.size(); u++) {
											if (achieve.get(y).getgId() == achievement.get(u).getgId()
													&& achieve.get(y).getaId() == achievement.get(u).getaId()) {
												k += achievement.get(u).getPoints();
											}
										}
									}
								}
								for (int hi = 0; hi < player.size(); hi++) {
									if (fren.get(a).getId2() == player.get(hi).getId()) {
										System.out.print(player.get(hi).getName() + "\t" + k + "\n");
									}
								}
							}

						}

					}
				}

				break;
			case 10:
				//Summarize Game
				System.out.println("Game ID : ");
				int gmId = scan.nextInt();
				int l = -1;
				for (int a = 0; a < game.size(); a++) {
					if (gmId == game.get(a).getId()) {
						System.out.println("Game Name : " + game.get(a).getName());
						for (int b = 0; b < play.size(); b++) {
							if (gmId == play.get(b).getGameId()) {
								int p = 0, s = 0, points = 0;
								for (int c = 0; c < achieve.size(); c++) {
									if (achieve.get(c).getpId() == play.get(b).getPlayerId()
											&& gmId == achieve.get(c).getgId()) {
										p++;
										for (int d = 0; d < achievement.size(); d++) {
											if (achievement.get(d).getgId() == gmId
													&& achievement.get(d).getaId() == achieve.get(c).getaId()) {
												points += achievement.get(d).getPoints();
											}
										}

									}
								}

								for (int d = 0; d < achievement.size(); d++) {
									if (achievement.get(d).getgId() == gmId) {
										s++;
									}
								}

								if (l == -1) {
									System.out
											.println("Player name \t Player ID \t Achievement \t Game Points \t  IGN ");
									System.out.println(
											"-------------------------------------------------------------------------------------------------------------------------------");
								}

								for (int r = 0; r < player.size(); r++) {
									if (player.get(r).getId() == play.get(b).getPlayerId()) {
										System.out.println(player.get(r).getName() + "\t" + play.get(b).getPlayerId()
												+ p + "/" + s + "\t" + points + "\t" + play.get(b).getName());
									}
								}

							}
						}
					}
				}
				break;
			case 11:
				//Summarize Achievement
				System.out.print("Game  ID : ");
				 gId = scan.nextInt();
				
				System.out.print("Achievement  ID : ");
				int aId = scan.nextInt();
				System.out.println("Player Id \t Player Name");
				System.out.println("---------------------------------------------------------------------");
				
				for(int a=0;a<achieve.size();a++){
					if(achieve.get(a).getaId()==aId && achieve.get(a).getgId()==gId){
						for(int b=0;b<player.size();b++){
							if(achieve.get(a).getpId()==player.get(b).getId()){
								System.out.println(player.get(b).getId()+"\t"+player.get(b).getName());
							}
						}
					}
				}

				break;
			case 12:
				//Achievement Ranking
				int n = -1;

				for (int a = 0; a < player.size(); a++) {
					int point = 0;
					for (int b = 0; b < achieve.size(); b++) {
						if (player.get(a).getId() == achieve.get(b).getpId()) {
							for (int c = 0; c < achievement.size(); c++) {
								if (achievement.get(c).getgId() == achieve.get(b).getgId()
										&& achievement.get(c).getaId() == achieve.get(b).getaId()) {
									point += achievement.get(c).getPoints();
								}
							}
						}
					}
					if (n == -1) {
						System.out.println("Player Name  \t Player ID \t Game Score ");
						System.out.println("--------------------------------------------------------------------");
					}
					System.out.println(player.get(a).getName() + "\t" + player.get(a).getId() + "\t" + point);
				}
				break;
			case 13:
				System.exit(0);

			}

		}
	}

}
