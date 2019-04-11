//Camryn Bickerstaff
//
//
public class TicTacToe
{
	private int spot, computerSpot;
	private String[][] board;
	private String letter;
	private int[][] nothaBoard;
	private int[][] scoreBoard;
	public int win, p2win;
	private int[] winningCombo;
	
	public static String printScoreBoard(int[][] scoreBoard)
	{
		System.out.println(scoreBoard[0][0] + " | " + scoreBoard[0][1] + " | " + scoreBoard[0][2]);
		System.out.println("---------");
		System.out.println(scoreBoard[1][0] + " | " + scoreBoard[1][1] + " | " + scoreBoard[1][2]);
		System.out.println("---------");
		System.out.println(scoreBoard[2][0] + " | " + scoreBoard[2][1] + " | " + scoreBoard[2][2]);
		return "";	
	}
	public static String printExampleBoard()
	{
		System.out.println("         |         |         ");
		System.out.println("         |         |         ");
		System.out.println("    1    |    2    |    3    ");
		System.out.println("         |         |         ");
		System.out.println("         |         |         ");		
		System.out.println("---------+---------+---------");
		System.out.println("         |         |         ");
		System.out.println("         |         |         ");
		System.out.println("    4    |    5    |    6    ");
		System.out.println("         |         |         ");
		System.out.println("         |         |         ");		
		System.out.println("---------+---------+---------");
		System.out.println("         |         |         ");
		System.out.println("         |         |         ");
		System.out.println("    7    |    8    |    9    ");
		System.out.println("         |         |         ");
		System.out.println("         |         |         ");
		return "";
	}
	public static String printBoard(String[][] board)
	{
		System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
		System.out.println("--+---+--");
		System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
		System.out.println("--+---+--");
		System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
		return "";
	}

	public static String alterSpotHuman(int spot, String[][] board, int[][] nothaBoard, String xoro)
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{

				if(nothaBoard[i][j] == spot)
				{
					board[i][j] = "" + xoro;
				}	
			}
		}
		return "";
	}
	public static String alterSpotHuman2(int spot, String[][] board, int[][] nothaBoard, String p2xoro)
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{

				if(nothaBoard[i][j] == spot)
				{
					board[i][j] = "" + p2xoro;
				}	
			}
		}
		return "";
	}
	public static String alterSpotComputer(int computerSpot, String[][] board, int[][] nothaBoard, String p2xoro)
	{
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{

				if(nothaBoard[i][j] == computerSpot)
				{
					board[i][j] = p2xoro;
				}	
			}
		}
		return "";	
	}
	public static String alterScore(int spot, int[][] scoreBoard, String[][] board, int[][] nothaBoard)
	{
	 	for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{
				if(spot == nothaBoard[i][j])
				{
					scoreBoard[i][j] = -50;
					if(board[1][1].equals("x"))
					{
						if(nothaBoard[i][j] == 1)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i+2][j+2] = scoreBoard[i+2][j+2] + 9;
						}
						else if(nothaBoard[i][j] == 2)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 1;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 1;
							scoreBoard[i+2][j] = scoreBoard[i+2][j] + 9;
						}
						else if(nothaBoard[i][j] == 3)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i+2][j-2] = scoreBoard[i+2][j-2] + 9;
						}
						else if(nothaBoard[i][j] == 4)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 1;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 1;
							scoreBoard[i][j+2] = scoreBoard[i][j+2] +9;
						}
						else if(nothaBoard[i][j] == 5)
						{
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 1;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 1;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 1;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 1;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 1;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 1;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 1;
						}
						else if(nothaBoard[i][j] == 6)
						{
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 1;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 1;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 1;
							scoreBoard[i][j-2] = scoreBoard[i][j-2] + 9;
						}
						else if(nothaBoard[i][j] == 7)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 1;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i-2][j+2] = scoreBoard[i-2][j+2] + 9;
						}
						else if(nothaBoard[i][j] == 8)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 1;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 1;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 1;
							scoreBoard[i-2][j] = scoreBoard[i-2][j] + 9;
						}
						else if(nothaBoard[i][j] == 9)
						{
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 1;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i-2][j-2] = scoreBoard[i-2][j-2] + 9;
						}
						
					}
					
					else if(board[1][1].equals("o") || board[1][1].equals(" "))
					{
						if(nothaBoard[i][j] == 1)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 1;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 1;
							scoreBoard[i][j+2] = scoreBoard[i][j+2] + 1;
							scoreBoard[i+2][j] = scoreBoard[i+2][j] + 1;
							
						}
						else if(nothaBoard[i][j] == 2)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 1;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 1;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 1;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 1;
						}
						else if(nothaBoard[i][j] == 3)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 1;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 1;
							scoreBoard[i][j-2] = scoreBoard[i][j-2] + 1;
							scoreBoard[i+2][j] = scoreBoard[i+2][j] + 1;
						}
						else if(nothaBoard[i][j] == 4)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 1;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 1;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 1;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 1;
						}
						else if(nothaBoard[i][j] == 5)
						{
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 1;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 1;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 1;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 1;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 1;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 1;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 1;
						}
						else if(nothaBoard[i][j] == 6)
						{
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 1;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 1;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 1;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 1;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 1;
						}
						else if(nothaBoard[i][j] == 7)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 1;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 1;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 1;
							scoreBoard[i][j+2] = scoreBoard[i][j+2] + 1;
							scoreBoard[i-2][j] = scoreBoard[i-2][j] + 1;
						}
						else if(nothaBoard[i][j] == 8)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 1;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 1;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 1;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 1;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 1;
						}
						else if(nothaBoard[i][j] == 9)
						{
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 1;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 1;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 1;
							scoreBoard[i][j-2] = scoreBoard[i][j-2] + 1;
							scoreBoard[i-2][j] = scoreBoard[i-2][j] + 1;
						}
						
					}	
				}
			}
	 	}
	 	return "";
	}
	 
	public static String alterCompScore(int computerSpot, int[][] scoreBoard, String[][] board, int[][] nothaBoard)
	{
	 	for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[i].length; j++)
			{

				if(computerSpot == nothaBoard[i][j])
				{
					scoreBoard[i][j] = -50;
					if(board[1][1].equals("o"))
					{
						if(nothaBoard[i][j] == 1)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i+2][j+2] = scoreBoard[i+2][j+2] + 6;
						}
						else if(nothaBoard[i][j] == 2)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 3;
							scoreBoard[i+2][j] = scoreBoard[i+2][j] + 6;
						}
						else if(nothaBoard[i][j] == 3)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i+2][j-2] = scoreBoard[i+2][j-2] + 6;
						}
						else if(nothaBoard[i][j] == 4)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 3;
							scoreBoard[i][j+2] = scoreBoard[i][j+2] + 6;
						}
						else if(nothaBoard[i][j] == 5)
						{
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 3;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 3;
						}
						else if(nothaBoard[i][j] == 6)
						{
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 3;
							scoreBoard[i][j-2] = scoreBoard[i][j-2] + 8;
						}
						else if(nothaBoard[i][j] == 7)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i-2][j+2] = scoreBoard[i-2][j+2] + 8;
						}
						else if(nothaBoard[i][j] == 8)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 3;
							scoreBoard[i-2][j] = scoreBoard[i-2][j] + 8;
						}
						else if(nothaBoard[i][j] == 9)
						{
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i-2][j-2] = scoreBoard[i-2][j-2] + 8;
						}
					}
					else if(board[1][1].equals("x"))
					{
						if(nothaBoard[i][j] == 1)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j+2] = scoreBoard[i][j+2] + 3;
							scoreBoard[i+2][j] = scoreBoard[i+2][j] + 3;
							
						}
						else if(nothaBoard[i][j] == 2)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 3;
						}
						else if(nothaBoard[i][j] == 3)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j-2] = scoreBoard[i][j-2] + 3;
							scoreBoard[i+2][j] = scoreBoard[i+2][j] + 3;
						}
						else if(nothaBoard[i][j] == 4)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 3;
						}
						else if(nothaBoard[i][j] == 5)
						{
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i+1][j+1] = scoreBoard[i+1][j+1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 3;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 3;
						}
						else if(nothaBoard[i][j] == 6)
						{
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i+1][j] = scoreBoard[i+1][j] + 3;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 3;
							scoreBoard[i+1][j-1] = scoreBoard[i+1][j-1] + 3;
						}
						else if(nothaBoard[i][j] == 7)
						{
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i][j+2] = scoreBoard[i][j+2] + 3;
							scoreBoard[i-2][j] = scoreBoard[i-2][j] + 3;
						}
						else if(nothaBoard[i][j] == 8)
						{
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i][j+1] = scoreBoard[i][j+1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 3;
							scoreBoard[i-1][j+1] = scoreBoard[i-1][j+1] + 3;
						}
						else if(nothaBoard[i][j] == 9)
						{
							scoreBoard[i-1][j-1] = scoreBoard[i-1][j-1] + 3;
							scoreBoard[i-1][j] = scoreBoard[i-1][j] + 3;
							scoreBoard[i][j-1] = scoreBoard[i][j-1] + 3;
							scoreBoard[i][j-2] = scoreBoard[i][j-2] + 3;
							scoreBoard[i-2][j] = scoreBoard[i-2][j] + 3;
						}
					}
				}	
			}
		}
		return "";
	}
	 
	public static boolean checkWinp2(String p2xoro, String[][] board, boolean p2win)
	{
		for(int j = 0; j < 3; j++)
		{
			if(board[0][j].equals(p2xoro))
			{
				if(board[1][j].equals(p2xoro) && board[2][j].equals(p2xoro))
				{
					p2win = true;
					break;
				}
			}
			if(board[j][0].equals(p2xoro))
			{
				if(board[j][1].equals(p2xoro) && board[j][2].equals(p2xoro))
				{
					p2win = true;
					break;
				}
			}
		}
		if(board[0][0].equals(p2xoro) && board[1][1].equals(p2xoro) && board[2][2].equals(p2xoro))
		{
			p2win = true;
		}
		else if(board[0][2].equals(p2xoro) && board[1][1].equals(p2xoro) && board[2][0].equals(p2xoro))
		{
			p2win = true;
		}
	 	return p2win;
	}
	
	public static boolean checkWinp1(String xoro, String[][] board, boolean win)
	{
		for(int j = 0; j < 3; j++)
		{
			if(board[0][j].equals(xoro))
			{
				if(board[1][j].equals(xoro) && board[2][j].equals(xoro))
				{
					win = true;
					break;
				}
			}
			if(board[j][0].equals(xoro))
			{
				if(board[j][1].equals(xoro) && board[j][2].equals(xoro))
				{
					win = true;
					break;
				}
			}
		}
		if(board[0][0].equals(xoro) && board[1][1].equals(xoro) && board[2][2].equals(xoro))
		{
			win = true;
		}
		else if(board[0][2].equals(xoro) && board[1][1].equals(xoro) && board[2][0].equals(xoro))
		{
			win = true;
		}
	 	return win;
	}
	
	public static String winningCombo(String xoro, String[][] board)
	{
		for(int j = 0; j < 3; j++)
		{
			if(board[0][j].equals(xoro))
			{
				if(board[1][j].equals(xoro) && board[2][j].equals(xoro))
				{
					board[0][j] = (char)15 + "";
					board[1][j] = (char)15 + "";
					board[2][j] = (char)15 + "";
					break;
				}
			}
			if(board[j][0].equals(xoro))
			{
				if(board[j][1].equals(xoro) && board[j][2].equals(xoro))
				{
					board[j][0] = (char)15 + ""; 
					board[j][1] = (char)15 + "";
					board[j][2] = (char)15 + "";
					break;
				}
			}
		}
		if(board[0][0].equals(xoro) && board[1][1].equals(xoro) && board[2][2].equals(xoro))
		{
			board[0][0] = (char)15 + "";
			board[1][1] = (char)15 + "";
			board[2][2] = (char)15 + "";
		}
		else if(board[0][2].equals(xoro) && board[1][1].equals(xoro) && board[2][0].equals(xoro))
		{
			board[0][2] = (char)15 + "";
			board[1][1] = (char)15 + ""; 
			board[2][0] = (char)15 + "";
		}
		return "";
	}

	public static String winningCombop2(String p2xoro, String[][] board)
	{
		for(int j = 0; j < 3; j++)
		{
			if(board[0][j].equals(p2xoro))
			{
				if(board[1][j].equals(p2xoro) && board[2][j].equals(p2xoro))
				{
					board[0][j] = (char)15 + "";
					board[1][j] = (char)15 + "";
					board[2][j] = (char)15 + "";
					break;
				}
			}
			if(board[j][0].equals(p2xoro))
			{
				if(board[j][1].equals(p2xoro) && board[j][2].equals(p2xoro))
				{
					board[j][0] = (char)15 + ""; 
					board[j][1] = (char)15 + "";
					board[j][2] = (char)15 + "";
					break;
				}
			}
		}
		if(board[0][0].equals(p2xoro) && board[1][1].equals(p2xoro) && board[2][2].equals(p2xoro))
		{
			board[0][0] = (char)15 + "";
			board[1][1] = (char)15 + "";
			board[2][2] = (char)15 + "";
		}
		else if(board[0][2].equals(p2xoro) && board[1][1].equals(p2xoro) && board[2][0].equals(p2xoro))
		{
			board[0][2] = (char)15 + "";
			board[1][1] = (char)15 + ""; 
			board[2][0] = (char)15 + "";
		}
		return "";
	}

	 
	 
	 
	 
	 
	 
	 
	 
	 
}