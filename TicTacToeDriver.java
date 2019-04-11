//Camryn Bickerstaff
//
//
import java.util.*;
import java.io.*;
public class TicTacToeDriver
{
	public static void main(String[] args) throws Exception
	{
		Scanner input = new Scanner(System.in);
		
		//prints the spots
		String[][] board = new String[3][3];
		board[0][0] = " ";
		board[0][1] = " ";
		board[0][2] = " ";
		board[1][0] = " ";
		board[1][1] = " ";
		board[1][2] = " ";
		board[2][0] = " ";
		board[2][1] = " ";
		board[2][2] = " ";
		//sets the spots to the number you select	
		int[][] nothaBoard = new int[3][3];
		nothaBoard[0][0] = 1;
		nothaBoard[0][1] = 2;
		nothaBoard[0][2] = 3;
		nothaBoard[1][0] = 4;
		nothaBoard[1][1] = 5;
		nothaBoard[1][2] = 6;
		nothaBoard[2][0] = 7;
		nothaBoard[2][1] = 8;
		nothaBoard[2][2] = 9;
		
		//keep score so computer knows where to play
		int[][] scoreBoard = new int[3][3];
		scoreBoard[0][0] = 0;
		scoreBoard[0][1] = 0;
		scoreBoard[0][2] = 0;
		scoreBoard[1][0] = 0;
		scoreBoard[1][1] = 0;
		scoreBoard[1][2] = 0;
		scoreBoard[2][0] = 0;
		scoreBoard[2][1] = 0;
		scoreBoard[2][2] = 0;
		
		//winning combo
		int[] winningCombo = new int[3];
		
		//instructions, introduction
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.print("How many games do you want to play? ");
		int numGames = input.nextInt();
		System.out.print("Do you want to play the computer, or a friend? Enter the full word \"computer\"\nor, \"friend\" ");
		String play = input.next();
		if(!(play.equals("friend")) && !(play.equals("computer")))
		{
			System.out.print("Do you want to play the computer, or a friend? Enter the full word \"Computer\"\nor, \"friend\" ");
			play = input.next();
		}
		System.out.println();
		
		//more instructions
		System.out.println(TicTacToe.printExampleBoard());
		System.out.println("\nWhen playing the game, pick a number that corersponds with the block you want\nto fill in");
		System.out.println("You need 3 in a row to win!\n");
	//	Thread.sleep(5000);
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		
		//variables
		int spot = 0;
		int computerSpot = 0;
		String xoro = "";
		String p2xoro = "";
		boolean win = false;
		boolean p2win = false;
		int p1points = 0;
		int p2points = 0;
		int m = 0;
	
		//computer vs. human
		if(play.equals("computer"))
		{
			System.out.println("You get the first turn\n");
			for(int i = 0; i < numGames; i++)
			{
				System.out.println("Game: " + (i+1));
				System.out.println(TicTacToe.printExampleBoard());
				for(int j = 0; j < 9; j = j +0)
				{
					//human play
					xoro = "x";
					p2xoro = "o";
					System.out.print("Where do you want to play? ");
					spot = input.nextInt();
					
					//if enters already taken spot
					for(int k = 0; k < board.length; k++)
					{
						for(int l = 0; l < board.length; l++)
						{
							if(nothaBoard[k][l] == spot && (board[k][l].equals("x") || board[k][l].equals("o")))
							{
								System.out.print("Please pick a spot that is not taken. ");
								spot = input.nextInt();
							}
						}
					}
					//puts x on board
					TicTacToe.alterSpotHuman(spot, board, nothaBoard, xoro);
					TicTacToe.alterScore(spot, scoreBoard, board, nothaBoard);
					//System.out.println(TicTacToe.printScoreBoard(scoreBoard));
					System.out.println(TicTacToe.printBoard(board));
					//Thread.sleep(3000);
					
					//checks if a win
					win = TicTacToe.checkWinp1(xoro, board, win);
					if(win)
					{
						System.out.println("You won!\n");
						TicTacToe.winningCombo(xoro, board);
						System.out.println(TicTacToe.printBoard(board));
						Thread.sleep(4000);
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();						
						p1points = p1points + 1;
						break;
					}
					j++;
					if(j == 9)
					{
						break;
					}
					
					//computer play
					System.out.println("Now it's the computers turn");
					Thread.sleep(1000);
					int bigNum = 0;
					
					//picking computers spot
					if(board[1][1].equals(" "))
					{
						computerSpot = 5;
					}
					else
					{
						for(int k = 0; k < board.length; k++)
						{
							for(int l = 0; l < board[k].length; l++)
							{
								if(scoreBoard[k][l] > bigNum)
								{
									bigNum = scoreBoard[k][l];
									computerSpot = nothaBoard[k][l];
								}
							}
						}
						
					}
					
					//puts o on board
					TicTacToe.alterCompScore(computerSpot, scoreBoard, board, nothaBoard);
					//System.out.println(TicTacToe.printScoreBoard(scoreBoard));
					TicTacToe.alterSpotComputer(computerSpot, board, nothaBoard, p2xoro);
					System.out.println(TicTacToe.printBoard(board));
					
					//checks if win
					p2win = TicTacToe.checkWinp2(p2xoro, board, p2win);
					if(p2win)
					{
						System.out.println("The computer beat you! Loser\n");
						TicTacToe.winningCombop2(p2xoro, board);
						System.out.println(TicTacToe.printBoard(board));
						//Thread.sleep(5000);
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
						p2points = p2points + 1;
						break;
					}
					j++;
				}
				
				//if cat game
				if(!win && !p2win)
				{
					System.out.println("You both lose! MEOW\n");
				}
				System.out.println("Player 1: " + p1points);
				System.out.println("Player 2: " + p2points);
				
				//sets variables back
				win = false;
				p2win = false;
				board[0][0] = " ";
				board[0][1] = " ";
				board[0][2] = " ";
				board[1][0] = " ";
				board[1][1] = " ";
				board[1][2] = " ";
				board[2][0] = " ";
				board[2][1] = " ";
				board[2][2] = " ";
				scoreBoard[0][0] = 0;
				scoreBoard[0][1] = 0;
				scoreBoard[0][2] = 0;
				scoreBoard[1][0] = 0;
				scoreBoard[1][1] = 0;
				scoreBoard[1][2] = 0;
				scoreBoard[2][0] = 0;
				scoreBoard[2][1] = 0;
				scoreBoard[2][2] = 0;
			}
		}
		
		//human vs. human
		else if(play.equals("friend"))
		{
			System.out.print("X's or O's player 1? ");
			xoro = input.next();
			if(xoro.equals("x"))
			{
				p2xoro = "o";
			}
			else
			{
				p2xoro = "x";
			}
			for(int i = 0; i < numGames; i++)
			{
				System.out.println("Game " + (i + 1));
				System.out.println(TicTacToe.printExampleBoard());
				for(double j = 0; j < 9; j = j + 0)
				{
					//human 1 play
					System.out.print("Where do you want to play, player 1? ");
					spot = input.nextInt();
					for(int k = 0; k < board.length; k++)
					{
						for(int l = 0; l < board.length; l++)
						{
							if(nothaBoard[k][l] == spot && (board[k][l].equals("x") || board[k][l].equals("o")))
							{
								System.out.print("Please pick a spot that is not taken. ");
								spot = input.nextInt();
							}
						}
					}
					
					//changes spot on board
					TicTacToe.alterSpotHuman(spot, board, nothaBoard, xoro);
					System.out.println(TicTacToe.printBoard(board));
					
					//checks if win
					win = TicTacToe.checkWinp1(xoro, board, win);
					if(win)
					{
						System.out.println("You won Player 1!");	
						TicTacToe.winningCombo(xoro, board);
						System.out.println(TicTacToe.printBoard(board));
						Thread.sleep(6000);
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
						p1points = p1points + 1;
						break;
					}
					j++;
					if(j == 9)
					{
						break;
					}
					
					//human 2 play
					System.out.print("Where do you want to play, player 2? ");
					spot = input.nextInt();
					for(int k = 0; k < board.length; k++)
					{
						for(int l = 0; l < board.length; l++)
						{
							if(nothaBoard[k][l] == spot && (board[k][l].equals("x") || board[k][l].equals("o")))
							{
								System.out.print("Please pick a spot that is not taken. ");
								spot = input.nextInt();
							}
						}
					}
					
					//changes spot
					TicTacToe.alterSpotHuman2(spot, board, nothaBoard, p2xoro);
					System.out.println(TicTacToe.printBoard(board));
					
					//checks if win
					p2win = TicTacToe.checkWinp2(p2xoro, board, p2win);
					if(p2win)
					{
						System.out.println("You won Player 2!");
						TicTacToe.winningCombop2(p2xoro, board);
						System.out.println(TicTacToe.printBoard(board));
						Thread.sleep(4000);
						new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
						p2points = p2points + 1;
						break;
					}
					j++;
				}
				//if cat game
				if(!win && !p2win)
				{
					System.out.println("You both lose! MEOW");
				}
				//sets variables back
				System.out.println("Player 1: " + p1points);
				System.out.println("Player 2: " + p2points);
				win = false;
				p2win = false;
				board[0][0] = " ";
				board[0][1] = " ";
				board[0][2] = " ";
				board[1][0] = " ";
				board[1][1] = " ";
				board[1][2] = " ";
				board[2][0] = " ";
				board[2][1] = " ";
				board[2][2] = " ";
			}
		}
		
		//checks points to find winner
		if(p2points == p1points)
		{
			System.out.println("You tied, if player 1 can guess the number from 1 to 10, player 1 will win!");
			System.out.println("What's your guess player 1? " );
			int guess = input.nextInt();
			if(guess == 7)
			{
				System.out.println("YOU WON PLAYER 1!!!!!!!");
			}
			else if(play.equals("friend"))
			{
				System.out.println("YOU WON PLAYER 2!!!!!!");
			}
			else if(play.equals("computer"))
			{
				System.out.println("THE COMPUTER WON THE WHOLE THING!!!");
			}
		}
		if(play.equals("friend"))
		{
			if(p1points > p2points)
			{
				System.out.println("Way to go Player 1!!! You win!");
			}
			else if(p2points > p1points)
			{
				System.out.println("Way to go Player 2!!! You win!!");
			}
		}
		else if(play.equals("computer"))
		{
			if(p1points > p2points)
			{
				System.out.println("Way to go!!! You win!");
			}
			else if(p2points > p1points)
			{
				System.out.println("The Computer beat you!!");
			}
		}
		
		//CATS
		System.out.println("                         _");
        System.out.println("                        | \\");
        System.out.println("                        | |");
        System.out.println("                         | |");
        System.out.println("    |\\                   | |");
        System.out.println("   /, ~\\                / /");
        System.out.println("  X     `-.....-------./ /");
        System.out.println("   ~-. ~  ~              |");
        System.out.println("      \\             /    |");
        System.out.println("       \\  /_     ___\\   /");
        System.out.println("       | /\\ ~~~~~   \\ |");
        System.out.println("       | | \\        || |");
        System.out.println("       | |\\ \\       || )");
        System.out.println("      (_/ (_\\/      ((_/\n\n\n");
        
		System.out.println("               )\\._.,--....,'``.");       
		System.out.println(" .b--.        /;   _.. \\   _\\  (`._ ,."); 
		System.out.println("`=,-,-'~~~   `----(,_..'--(,_..'`-.;.'\n\n\n\n\n");
		
		System.out.println("	    *      ,MMM8&&&.            *");
		System.out.println("                  MMMM88&&&&&    .");
		System.out.println("                 MMMM88&&&&&&&");
		System.out.println("     *           MMM88&&&&&&&&");
		System.out.println("                 MMM88&&&&&&&&");
		System.out.println("                 'MMM88&&&&&&'");
		System.out.println("                   'MMM8&&&'      *");
		System.out.println("          |\\___/|");
		System.out.println("          )     (             .              \'");
		System.out.println("         =\\     /=");
		System.out.println("           )===(       *");
		System.out.println("          /     \\");
		System.out.println("          |     |");
		System.out.println("         /       \\");
		System.out.println("         \\       /");
		System.out.println("  _/\\_/\\_/\\__  _/_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_/\\_");
		System.out.println("  |  |  |  |( (  |  |  |  |  |  |  |  |  |  |");
		System.out.println("  |  |  |  | ) ) |  |  |  |  |  |  |  |  |  |");
		System.out.println("  |  |  |  |(_(  |  |  |  |  |  |  |  |  |  |");
		System.out.println("  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |");
		System.out.println("  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |\n");
		
		System.out.println("		                      ___");
		System.out.println("             |\\__/,|   (`\\        _.-|   |          |\\__/,|   (`\\");
		System.out.println("             |o o  |__ _) )      {   |   |          |o o  |__ _) )");
		System.out.println("           _.( T   )  `  /        \"-.|___|        _.( T   )  `  /");
		System.out.println(" n n._    ((_ `^--' /_<  \\         .--'-`-.     _((_ `^--\' /_<  \\");
		System.out.println(" <\" _ }=- `` `-\'(((/  (((/       .+|______|__.-||__)`-\'(((/  (((/\n");

		
	}
}