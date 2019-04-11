//CamrynBickerstaff
//
//
import java.util.*;
import java.io.*;
import java.lang.*;

public class BattleShipDriver
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("BattleShipFile.txt");
		Scanner inputFile = new Scanner(file);
		Scanner input = new Scanner(System.in);
		String[][][] spot = new String[5][10][10];
		String[][][] newSpot = new String[5][10][10];
		int[][] spotScore = new int[10][10];
		int hcarrier = 0;
		int hbattleship = 0;
		int hdestroyer = 0;
		int hsubmarine = 0;
		int hpatroler = 0;
		int ccarrier = 0;
		int cbattleship = 0;
		int cdestroyer = 0;
		int csubmarine = 0;
		int cpatroler = 0;
		int hhits = 0;
		int chits = 0;
		int reset = -1;
		String bumanBoard = "";
		int humanBoard = 0;
		ArrayList<Integer> whatSunkNum = new ArrayList<Integer>();
		ArrayList<String> whatSunk = new ArrayList<String>();
		whatSunk.add("You sunk the computer's carrier!\n");
		whatSunk.add("The computer sunk your carrier!\n");
		whatSunk.add("You sunk the computer's battleship!\n");
		whatSunk.add("The computer sunk your battleship!\n");
		whatSunk.add("You sunk the computer's destroyer!\n");
		whatSunk.add("The computer sunk your destroyer!\n");
		whatSunk.add("You sunk the computer's submarine!\n");
		whatSunk.add("The computer sunk your submarine!\n");
		whatSunk.add("You sunk the computer's patrol boat!\n");
		whatSunk.add("The computer sunk your patrol boat!\n");

		// getting info from text file
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				for(int k = 0; k < 10; k++)
				{
					spot[i][j][k] = inputFile.next();
				}
			}	
		}
		                                                                                                                                                                   
        System.out.println("@@@@@@     @@@   @@@@@@@@@@@@@@@@ @@@@    @@@@@@   @@@   @@@@ @@@@  @@@  @@@@@@   ");                                                                                
        System.out.println("@@@  @@    @@@   @  @@  @@  @@  @  @@     @@@  @  @   @   @@   @@   @@@   @@  @@     ");                                                                             
        System.out.println("@@@  @@   @ @@   @  @@  @@  @@  @  @@     @@@    @@       @@   @@   @@@   @@  @@     ");                                                                         
        System.out.println("@@@  @@   @ @@      @@      @@     @@     @@@ @  @@@@     @@   @@   @@@   @@  @@     ");                                                                            
        System.out.println("@@@ @@    @ @@@     @@      @@     @@     @@@@@  @@@@@    @@   @@   @@@   @@  @@     ");                                                                            
        System.out.println("@@@ @@    @ @@@     @@      @@     @@     @@@@@   @@@@@   @@@@@@@   @@@   @@@@@     ");                                                                             
        System.out.println("@@@  @@   @ @@@     @@      @@     @@     @@@ @    @@@@@  @@   @@   @@@   @@       ");                                                                             
        System.out.println("@@@  @@   @@@@@     @@      @@     @@     @@@    @   @@@  @@   @@   @@@   @@      ");                                                                                
        System.out.println("@@@  @@  @   @@     @@      @@     @@     @@@    @    @   @@   @@   @@@   @@      ");                                                                                
        System.out.println("@@@  @@  @   @@@    @@      @@     @@  @  @@@  @  @   @   @@   @@   @@@   @@      ");                                                                                
        System.out.println("@@@@@@  @@   @@@   @@@@    @@@@   @@@@@@  @@@@@@   @@@   @@@@ @@@@  @@@  @@@@    \n\n");                                                                                 
                                                                                                                                                                                                        
                                                                                                                      
		System.out.println("                                     |__");
		System.out.println("                                     |\\/");
		System.out.println("                                     ---");
		System.out.println("                                     / | [");
		System.out.println("                              !      | |||");
		System.out.println("                            _/|     _/|-++\'");
		System.out.println("                        +  +--|    |--|--|_ |-");
		System.out.println("                     { /|__|  |/\\__|  |--- |||__/");
		System.out.println("                    +---------------___[}-_===_.\'____                 /\\");
		System.out.println("                ____`-\' ||___-{]_| _[}-  |     |_[___\\==--            \\/   _");
		System.out.println(" __..._____--==/___]_|__|_____________________________[___\\==--____,------\' .7");
		System.out.println("|                                                                     BB-61/");
		System.out.println(" \\_________________________________________________________________________|  ");                                                                                                                                                 

		
		System.out.println("\n                              Instructions: \n");
		System.out.println("                 The goal is to sink your opponent's ships");
		System.out.println("                There are five ships total for each player\n");
		System.out.println("                               " + (char)22 + " = water/blank");
		System.out.println("                               " + (char)15 + " = boat");
		System.out.println("                               X = hit");
		System.out.println("                               O = miss");
		System.out.println("                               " + (char)171 + " = sunken boat");
		Thread.sleep(10000);
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		
		
		while(humanBoard != 1 && humanBoard != 2 && humanBoard != 3 && humanBoard != 4 && humanBoard != 5)
		{
			System.out.print("Pick a number from 1 - 5 to choose your board ");	
			bumanBoard = input.next();
			switch(bumanBoard)
			{
				case "1": humanBoard = 1; break;
				case "2": humanBoard = 2; break;
				case "3": humanBoard = 3; break;
				case "4": humanBoard = 4; break;
				case "5": humanBoard = 5; break;
				
				
			}		
		}
		ArrayList<String> boards = new ArrayList<String>();
		boards.add("1");
		boards.add("2");
		boards.add("3");
		boards.add("4");
		boards.add("5");
		
		boards.remove(humanBoard + "");
	//	System.out.println(boards);
		int compBoardP = (int)(Math.random()*3);
		char compBoardS = (boards.get(compBoardP)).charAt(0);
		int compBoard = compBoardS - 48;
		
		for(int j = 0; j < 10; j++)
		{
			for(int k = 0; k < 10; k++)
			{
				newSpot[compBoard-1][j][k] = (char)22 + "";
				if(spot[humanBoard-1][j][k].equals("w"))
				{
					newSpot[humanBoard-1][j][k] = (char)22 + "";
				}
				else
				{
					newSpot[humanBoard-1][j][k] = (char)15 + "";
				}
			}
		}
		// prints out boards for me to test	
	//	System.out.println(humanBoard + " " + compBoard);
	//	BattleShipBoard.printCompBoard(spot, compBoard);
	//	BattleShipBoard.printHumanBoard(spot,humanBoard);
	
		//what is actually shown
		System.out.println("\nThis is the board that you will be shooting at\n");
		BattleShipBoard.computerBoardThatHumanSees(newSpot, compBoard);
		System.out.println("\nThis is your board\n");
		BattleShipBoard.humanBoardThatHumanSees(newSpot, humanBoard);
		
		//more variables
		
		int y = 0;
		int x = 0;
		String coor = "";
		String compCoor = "";
		ArrayList<String> doesContain = new ArrayList<String>();
		ArrayList<String> doesContainComp = new ArrayList<String>();
		Thread.sleep(5000);
		new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
		
		//actually starts game
		while(chits != 17 && hhits != 17)
		{
			//human play
			System.out.println("Computer Board: \n");
			BattleShipBoard.computerBoardThatHumanSees(newSpot, compBoard);
			do
			{
				x = 0;
				y = 0;
				
				while(x != 1 && x != 2 && x != 3 && x != 4 && x != 5 && x != 6 && x != 7 && x != 8 && x != 9 && x != 10)
				{
					System.out.println("Where do you want to shoot (1-10) ");
					String xx = input.next();
					switch(xx)
					{
						case "1": x = 1; break;
						case "2": x = 2; break;
						case "3": x = 3; break;
						case "4": x = 4; break;
						case "5": x = 5; break;
						case "6": x = 6; break;
						case "7": x = 7; break;
						case "8": x = 8; break;
						case "9": x = 9; break;
						case "10": x = 10; break;	
					}
				}
				
				while(y == 0)
				{
					System.out.println("Where do you want to shoot (a-j) ");
					String stx = input.next();
					
					switch(stx)
					{
						case "a": y = 1; break;
						case "b": y = 2; break;
						case "c": y = 3; break;
						case "d": y = 4; break;
						case "e": y = 5; break;
						case "f": y = 6; break;
						case "g": y = 7; break;
						case "h": y = 8; break;
						case "i": y = 9; break;
						case "j": y = 10; break;	
					}
					coor = x + "" + y;
				}
			}while(doesContain.contains(coor));
			
			doesContain.add(coor);
			
			//actually shooting at computers board
			BattleShipBoard.humanShootAtCompBoard(spot, x, y, compBoard, newSpot);
			if(newSpot[compBoard-1][x-1][y-1].equals("X"))
			{
				hhits = hhits + 1;
				System.out.println("You hit a ship!");
				switch(spot[compBoard-1][x-1][y-1])
				{
					case "c": ccarrier = ccarrier + 1; break;
					case "b": cbattleship = cbattleship + 1; break;
					case "d": cdestroyer = cdestroyer + 1; break;
					case "s": csubmarine = csubmarine + 1; break;
					case "p": cpatroler = cpatroler + 1; break;
				}
			}
			else if(newSpot[compBoard-1][x-1][y-1].equals("O"))
			{
				System.out.println("Better luck next time!");
			}
			//System.out.println(BattleShipBoard.whatBoatSunk(whatSunk, ccarrier, hcarrier, cbattleship, hbattleship, cdestroyer, hdestroyer, hsubmarine, csubmarine, hpatroler, cpatroler));
			reset = BattleShipBoard.whatBoatSunk(whatSunk, ccarrier, hcarrier, cbattleship, hbattleship, cdestroyer, hdestroyer, hsubmarine, csubmarine, hpatroler, cpatroler, whatSunkNum, spot, humanBoard, compBoard, newSpot);
			if(reset >= 0)
			{
				System.out.println(whatSunk.get(reset));
				whatSunk.set(reset, "");
			
			}
			if(reset == 6)
			{
				System.out.println("				");
				System.out.println("                             ?");
				System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~|^\"~~~~~~~~~~~~~~~~~~~~~~~~~o~~~~~~~~~~~");
				System.out.println("        o                   |                  o      __o");
				System.out.println("         o                  |                 o     |X__>");
				System.out.println("       ___o                 |                __o");
				System.out.println("     (X___>--             __|__            |X__>     o");
				System.out.println("                         |     \\                   __o");
				System.out.println("                         |      \\                |X__>");
				System.out.println("  _______________________|_______\\________________");
				System.out.println(" <                                                \\____________   _");
				System.out.println("  \\                                                            \\ (_)");
				System.out.println("   \\    O       O       O                                       >=)");
				System.out.println("    \\__________________________________________________________/ (_)");
				System.out.println("");
				System.out.println("                            ___");
				System.out.println("                           / o \\");
				System.out.println("                      __   \\   /   _");
				System.out.println("                        \\__/ | \\__/ \\");
				System.out.println("                       \\___//|\\___/\\");
				System.out.println("                        ___/ | \\___      ");    
				System.out.println("                             |     \\");
				System.out.println("                            /");
				System.out.println("	");
				Thread.sleep(4000);
			}
			reset = -1;
			if(hhits == 17)
			{
				break;
			}
			// for me to check if its working
			//System.out.println("c-" + ccarrier + " b-" + cbattleship + " d-" + cdestroyer + " s-" + csubmarine + " p-" + cpatroler);
			x = 0; 
			y = 0;
			
			//computer play
			Thread.sleep(3000);
			new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			System.out.println("Now it's the computer's turn\n");
			do
			{
				x = 0;
				y = 0;
				compCoor = BattleShipBoard.compShootAtHumanBoard(spot, humanBoard, newSpot, spotScore);
				
				//System.out.println("gets here11");
				//System.out.println(compCoor);
				if(compCoor.length() == 2)
				{
					//System.out.println("gets here");
					x = compCoor.charAt(0) - 48;
					y = compCoor.charAt(1) - 48;
				}
				else if(compCoor.length() == 3)
				{
					if(compCoor.charAt(1) == '0')
					{
						x = 10;
						y = compCoor.charAt(2) - 48;
					}
					else if(compCoor.charAt(2) == '0')
					{
						x = compCoor.charAt(0) - 48;
						y = 10;
					}
				}
				else if(compCoor.length() == 4)
				{
					x = 10;
					y = 10;
				}
			}while(doesContainComp.contains(compCoor));
			doesContainComp.add(compCoor);
			BattleShipBoard.humanBoardThatHumanSees(newSpot, humanBoard);
			BattleShipBoard.changeSpotScore(spot, humanBoard, spotScore, x, y);
		/*	for(int i = 0; i < 10; i++)
			{
				for(int j= 0; j < 10; j++)
				{
					System.out.print(spotScore[i][j] + " ");
				}
				System.out.println();
			}
		*/	
			if(newSpot[humanBoard-1][x-1][y-1].equals("X"))
			{
				chits = chits + 1;
				switch(spot[humanBoard-1][x-1][y-1])
				{
					case "c": hcarrier = hcarrier + 1; System.out.println("The computer hit your carrier!\n"); break;
					case "b": hbattleship = hbattleship + 1; System.out.println("The computer hit your battleship!\n"); break;
					case "d": hdestroyer = hdestroyer + 1; System.out.println("The computer hit your destroyer!\n"); break;
					case "s": hsubmarine = hsubmarine + 1; System.out.println("The computer hit your submarine!\n"); break;
					case "p": hpatroler = hpatroler + 1; System.out.println("The computer hit your patrol boat!\n"); break;
				}
		//	System.out.println("c-" + hcarrier + " b-" + hbattleship + " d-" + hdestroyer + " s-" + hsubmarine + " p-" + hpatroler);
			}
			else
			{
				System.out.println("The computer missed\n");
			}
			reset = BattleShipBoard.whatBoatSunk(whatSunk, ccarrier, hcarrier, cbattleship, hbattleship, cdestroyer, hdestroyer, hsubmarine, csubmarine, hpatroler, cpatroler, whatSunkNum, spot, humanBoard, compBoard, newSpot);
			if(reset >= 0)
			{
				System.out.println(whatSunk.get(reset));
				whatSunk.set(reset, "");
			}
			if(reset == 7)
			{
				System.out.println("				");
				System.out.println("                             ?");
				System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~|^\"~~~~~~~~~~~~~~~~~~~~~~~~~o~~~~~~~~~~~");
				System.out.println("        o                   |                  o      __o");
				System.out.println("         o                  |                 o     |X__>");
				System.out.println("       ___o                 |                __o");
				System.out.println("     (X___>--             __|__            |X__>     o");
				System.out.println("                         |     \\                   __o");
				System.out.println("                         |      \\                |X__>");
				System.out.println("  _______________________|_______\\________________");
				System.out.println(" <                                                \\____________   _");
				System.out.println("  \\                                                            \\ (_)");
				System.out.println("   \\    O       O       O                                       >=)");
				System.out.println("    \\__________________________________________________________/ (_)");
				System.out.println("");
				System.out.println("                            ___");
				System.out.println("                           / o \\");
				System.out.println("                      __   \\   /   _");
				System.out.println("                        \\__/ | \\__/ \\");
				System.out.println("                       \\___//|\\___/\\");
				System.out.println("                        ___/ | \\___      ");    
				System.out.println("                             |     \\");
				System.out.println("                            /");
				System.out.println("	");
				Thread.sleep(4000);
			}
			reset = -1;
			Thread.sleep(2000);
		}
		if(chits == 17)
		{
			System.out.println("The computer beat you!!\n");
			System.out.println("This was the computer's board: \n");
			for(int j = 0; j < 10; j++)
			{
				for(int k = 0; k < 10; k++)
				{
					if(spot[compBoard-1][j][k].equals("w"))
					{
						newSpot[compBoard-1][j][k] = (char)22 + "";
					}
					else
					{
						newSpot[compBoard-1][j][k] = (char)15 + "";
					}
				}
			}
			BattleShipBoard.humanBoardThatHumanSees(newSpot, compBoard);
		}
		else if(hhits == 17)
		{
			System.out.println("Way to go! You won!");
			System.out.println("Give me a high paw!\n");
			System.out.println("	 .-.   .-.");
	        System.out.println("        /   \\ /   \\ ");
	        System.out.println("    .-. |    |    | .-.");
	        System.out.println("   /   \\ \\  / \\  / /   \\");
	        System.out.println("   |   |  \'`.-.`\'  |   |");
	        System.out.println("    \\_.\' .-`   `-. \'._/");
	        System.out.println("      .-\'         \'-.");
	        System.out.println("     /               \\");
	        System.out.println("     |               |");
	        System.out.println("      \\             /");
	        System.out.println("       \'.___...___.\'");
		}				
	}
}