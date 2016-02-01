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
			
			//CHANGE
			String option = scan.nextLine().trim();
			
			if (option.isEmpty()){
				continue;
			}
			
			String[] promptDivider = option.split("\"");
			String[] Command = promptDivider[0].split(" ");
			
			String[] prompts = option.split(" ");
			//String commandFirst = Command[0];
			

			switch (Command[0]) {
			case "AddPlayer":// ADD Player

				System.out.println(promptDivider[0]);
				//System.out.print("Player ID : ");
				int id = Integer.parseInt(prompts[1]);

				//System.out.print("Player Name  : ");
				String name = promptDivider[1];

				player.add(new Player(id, name));

				break;
			case "AddGame":// ADD Game

				//System.out.print("Game ID : ");
				int gameid = Integer.parseInt(prompts[1]);

				//System.out.print("Game Name  : ");
				String gameName = promptDivider[1];

				game.add(new Game(gameid, gameName));

				break;
			case "AddAchievement":// ADD Achievement

				//System.out.print("Game Id  : ");
				int gId = Integer.parseInt(prompts[1]);
				
				//System.out.print("Achievement ID : ");
				int achievementId = Integer.parseInt(prompts[2]);

				//System.out.print("Achievement Name  : ");
				String achievementName = promptDivider[1];

				//System.out.print("Achievement Points : ");
				int achievementPoints = Integer.parseInt(promptDivider[2].trim());

				achievement.add(new Achievement(gId, achievementId, achievementName, achievementPoints));

				break;
			case "AddFriends":// ADD Friends

				//System.out.print("Friend 1 ID : ");
				int f1Id = Integer.parseInt(prompts[1]);

				//System.out.print("Friend 2 ID : ");
				int f2Id = Integer.parseInt(prompts[2]);

				fren.add(new Friend(f1Id, f2Id));
				fren.add(new Friend(f2Id, f1Id));

				break;
			case "Plays"://Plays

				//System.out.print("Player ID : ");
				int PId = Integer.parseInt(prompts[1]);

				//System.out.print("Game ID : ");
				int GId = Integer.parseInt(prompts[2]);

				//System.out.print("Player IGN : ");
				String PIGN =prompts[3];

				play.add(new Play(PId, GId, PIGN));

				break;
			case "Achieve":
				//Achieve
				//System.out.print("Player ID : ");
				int PlayerId = Integer.parseInt(prompts[1]);

				//System.out.print("Game ID : ");
				int GameId = Integer.parseInt(prompts[2]);

				//System.out.print("Achievement ID : ");
				int AchievementId = Integer.parseInt(prompts[2]);

				achieve.add(new Achieve(PlayerId, GameId, AchievementId));

				break;
			case "FriendsWhoPlay":
				// Friends Who Play
				//System.out.print("Player ID : ");
				PlayerId = Integer.parseInt(prompts[1]);

				//System.out.print("Game ID : ");
				GameId = Integer.parseInt(prompts[2]);

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
			case "ComparePlayers":
				//Compare Player
				//System.out.print("Player ID1 : ");
				PlayerId = Integer.parseInt(prompts[1]);
				//System.out.print("Player ID2 : ");
				int PlayerId2 = Integer.parseInt(prompts[2]);
				//System.out.print("Game ID : ");
				int gameId = Integer.parseInt(prompts[3]);

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
			case "SummarizePlayer":
				//Summarize Player
				//System.out.print("Player ID : ");
				PlayerId = Integer.parseInt(prompts[1]);
				String IGN;
				//
				for (int i = 0; i < player.size(); i++) {
					if (player.get(i).getId() == PlayerId) {
						System.out.println("Player Name : " + player.get(i).getName());
						int pt = 0;
						int h = 0;
						//Print output header
						if (h == 0) {
							System.out.println("Game \t Achievement \t GameScore \t IGN");
							System.out.println("-------------------------------------------------------------------");
							h++;
						}
						
						//Print friends, games played, and gamer points
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

						//Print total gamer score
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
								//Print friends' scores
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
			case "SummarizeGame":
				//Summarize Game
				//System.out.println("Game ID : ");
				int gmId = Integer.parseInt(prompts[1]);
				int l = -1;
				//Print all who have played and times achievements have been done
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
										System.out.println(player.get(r).getName() + "\t" + play.get(b).getPlayerId() + "\t" +
												+ p + "/" + s + "\t" + points + "\t" + play.get(b).getName());
									}
								}

							}
						}
					}
				}
				break;
			case "SummarizeAchievement":
				//Summarize Achievement
				System.out.print("Game  ID : ");
				gId = Integer.parseInt(prompts[1]);
				double haveAchieve = 0;
				double allPlayers = 0;
				
				System.out.print("Achievement  ID : ");
				int aId = Integer.parseInt(prompts[2]);
				System.out.println("Player Id \t Player Name");
				System.out.println("---------------------------------------------------------------------");
				
				//Print all players with this achievement
				for(int a=0;a<achieve.size();a++){
					if(achieve.get(a).getaId()==aId && achieve.get(a).getgId()==gId){
						for(int b=0;b<player.size();b++){
							if(achieve.get(a).getpId()==player.get(b).getId()){
								System.out.println(player.get(b).getId()+"\t"+player.get(b).getName());
								haveAchieve+=1;
								allPlayers+=1;
							}
							else{
								allPlayers+=1;
							}
						}
					}
				}
				System.out.println((haveAchieve/allPlayers) + " percent have achievement");

				break;
			case "AchievementRanking":
				//Achievement Ranking
				int n = -1;

				//Prints a record of all players and their gamer points
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
			case "Exit":
			//Exit program
				System.exit(0);

			}

		}
	}

}
