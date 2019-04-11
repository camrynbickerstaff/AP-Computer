//CamrynBickerstaff
//
//
import java.util.*;
import java.io.*;
public class BattleShipBoard
{
	public static void printCompBoard(String[][][] spot, int compBoard)
	{
		System.out.println("    A B C D E F G H I J");
		System.out.println("    -------------------");
		for(int j = 0; j < 10; j++)
		{

			if(j+1 != 10)
			{
				System.out.print(j+1 + " | " );
			}
			else
				System.out.print(j+1 + "| ");
			for(int k = 0; k < 10; k++)
			{
				System.out.print(spot[compBoard-1][j][k] + " ");
			}
			System.out.println();
		}
		System.out.println();	
	}
	
	public static void printHumanBoard(String[][][] spot, int humanBoard)
	{
		System.out.println("    A B C D E F G H I J");
		System.out.println("    -------------------");
		for(int j = 0; j < 10; j++)
		{
			if(j+1 != 10)
			{
				System.out.print(j+1 + " | " );
			}
			else
				System.out.print(j+1 + "| ");
			for(int k = 0; k < 10; k++)
			{
				System.out.print(spot[humanBoard-1][j][k] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void computerBoardThatHumanSees(String[][][] newSpot, int compBoard)
	{
		System.out.println("    A B C D E F G H I J");
		System.out.println("    -------------------");
		for(int j = 0; j < 10; j++)
		{
			if(j+1 != 10)
			{
				System.out.print(j+1 + " | " );
			}
			else
				System.out.print(j+1 + "| ");
			for(int k = 0; k < 10; k++)
			{
				System.out.print(newSpot[compBoard-1][j][k] + " ");
			}
			System.out.println();
		}
		System.out.println();	
	}
	
	public static void humanBoardThatHumanSees(String[][][] newSpot, int humanBoard)
	{
		System.out.println("    A B C D E F G H I J");
		System.out.println("    -------------------");
		for(int j = 0; j < 10; j++)
		{
			if(j+1 != 10)
			{
				System.out.print(j+1 + " | " );
			}
			else
				System.out.print(j+1 + "| ");
			for(int k = 0; k < 10; k++)
			{
				System.out.print(newSpot[humanBoard-1][j][k] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void humanShootAtCompBoard(String[][][] spot, int x, int y, int compBoard, String[][][] newSpot)
	{
		if(!(spot[compBoard-1][x-1][y-1].equals("w")))
		{
			newSpot[compBoard-1][x-1][y-1] = "X";
		}
		else
			newSpot[compBoard-1][x-1][y-1] = "O";
		computerBoardThatHumanSees(newSpot, compBoard);
	}
	
	public static void changeSpotScore(String[][][] spot, int humanBoard, int[][] spotScore, int x, int y)
	{
		if(!(spot[humanBoard-1][x-1][y-1].equals("w")))
		{
			if(x > 1 && y > 1 && x < 10 && y < 10)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x][y-1] = spotScore[x][y-1] + 1;
				spotScore[x-2][y-1] = spotScore[x-2][y-1] + 1;
				spotScore[x-1][y] = spotScore[x-1][y] + 1;
				spotScore[x-1][y-2] = spotScore[x-1][y-2] + 1;
			}
			else if(x == 1 && y == 1)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x][y-1] = spotScore[x][y-1] + 1;
				spotScore[x-1][y] = spotScore[x-1][y] + 1;
			}
			else if(x == 10 && y == 10)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x-2][y-1] = spotScore[x-2][y-1] + 1;
				spotScore[x-1][y-2] = spotScore[x-1][y-2] + 1;
			}
			else if(x == 10 && y == 1)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x-2][y-1] = spotScore[x-2][y-1] + 1;
				spotScore[x-1][y] = spotScore[x-1][y] + 1;
			}
			else if(x == 1 && y == 10)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x-1][y-2] = spotScore[x-1][y-2] + 1;
				spotScore[x][y-1] = spotScore[x][y-1] + 1;
			}
			else if(x == 1 && y != 1 && y != 10)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x-1][y-2] = spotScore[x-1][y-2] + 1;
				spotScore[x][y-1] = spotScore[x][y-1] + 1;
				spotScore[x-1][y] = spotScore[x-1][y] + 1;
			}
			else if(x == 10 && y != 1 && y != 10)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x-1][y-2] = spotScore[x-1][y-2] + 1;
				spotScore[x-2][y-1] = spotScore[x-2][y-1] + 1;
				spotScore[x-1][y] = spotScore[x-1][y] + 1;
			}
			else if(y == 1 && x != 1 && x != 10)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x-2][y-1] = spotScore[x-2][y-1] + 1;
				spotScore[x][y-1] = spotScore[x][y-1] + 1;
				spotScore[x-1][y] = spotScore[x-1][y] + 1;
			}
			else if( y == 10 && x != 1 && x != 10)
			{
				spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
				spotScore[x-2][y-1] = spotScore[x-2][y-1] + 1;
				spotScore[x][y-1] = spotScore[x][y-1] + 1;
				spotScore[x-1][y-2] = spotScore[x-1][y-2] + 1;
			}
		}
		else
		{
			spotScore[x-1][y-1] = spotScore[x-1][y-1] - 50;
		}
	}
	
	public static String compShootAtHumanBoard(String[][][] spot, int humanBoard, String[][][] newSpot, int[][] spotScore)
	{
		int x = 0; 
		int y = 0;
		int topScore = 0;
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(spotScore[i][j] > topScore)
				{
					topScore = spotScore[i][j];
					x = i + 1;
					y = j + 1;
				}
			}
		}
		if(x == 0 && y == 0)
		{
			x = (int)(Math.random()*10)+1;
			y = (int)(Math.random()*10)+1;
		}
	
		if(!(spot[humanBoard-1][x-1][y-1].equals("w")) && !(newSpot[humanBoard-1][x-1][y-1].equals((char)171 + "")))
		{
			newSpot[humanBoard-1][x-1][y-1] = "X";
		}
		else if(!(newSpot[humanBoard-1][x-1][y-1].equals((char)171 + "")))
		{
			newSpot[humanBoard-1][x-1][y-1] = "O";
		}	
		String coor = "";
		coor = coor + x + "" + y;
		return coor;	
	}

	public static int whatBoatSunk(ArrayList<String> whatSunk, int ccarrier, int hcarrier,int cbattleship,int hbattleship,int cdestroyer,int hdestroyer,int hsubmarine,int csubmarine,int hpatroler,int cpatroler, ArrayList<Integer> whatSunkNum, String[][][] spot, int humanBoard, int compBoard, String[][][] newSpot)
	{
		int reset = -1;
		if(ccarrier == 5 && !(whatSunkNum.contains(0)))
		{
			reset = 0;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[compBoard-1][i][j].equals("c"))
					{
						newSpot[compBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(hcarrier == 5 && !(whatSunkNum.contains(1)))
		{
			reset = 1;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[humanBoard-1][i][j].equals("c"))
					{
						newSpot[humanBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(cbattleship == 4 && !(whatSunkNum.contains(2)))
		{
			reset = 2;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[compBoard-1][i][j].equals("b"))
					{
						newSpot[compBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(hbattleship == 4 && !(whatSunkNum.contains(3)))
		{
			reset = 3;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[humanBoard-1][i][j].equals("b"))
					{
						newSpot[humanBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(cdestroyer == 3 && !(whatSunkNum.contains(4)))
		{
			reset = 4;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[compBoard-1][i][j].equals("d"))
					{
						newSpot[compBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(hdestroyer == 3 && !(whatSunkNum.contains(5)))
		{
			reset = 5;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[humanBoard-1][i][j].equals("d"))
					{
						newSpot[humanBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(csubmarine == 3 && !(whatSunkNum.contains(6)))
		{
			reset = 6;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[compBoard-1][i][j].equals("s"))
					{
						newSpot[compBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(hsubmarine == 3 && !(whatSunkNum.contains(7)))
		{
			reset = 7;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[humanBoard-1][i][j].equals("s"))
					{
						newSpot[humanBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(cpatroler == 2 && !(whatSunkNum.contains(8)))
		{
			reset = 8;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[compBoard-1][i][j].equals("p"))
					{
						newSpot[compBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		if(hpatroler == 2 && !(whatSunkNum.contains(9)))
		{
			reset = 9;
			whatSunkNum.add(reset);
			for(int i = 0; i < 10; i++)
			{
				for(int j = 0; j < 10; j++)
				{
					if(spot[humanBoard-1][i][j].equals("p"))
					{
						newSpot[humanBoard-1][i][j] = (char)171 + "";
					}
				}
			}
		}
		return reset;
	}
	
}