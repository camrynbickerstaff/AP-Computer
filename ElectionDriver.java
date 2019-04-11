//Camryn Bickerstaff
//
//
import java.io.*;
import java.util.*;

public class ElectionDriver
{
	public static void main(String[] args) throws Exception
	{
		File file = new File("Election.txt");
		Scanner input = new Scanner(file);
		
		State[] states = new State[51];
		
		Candidate[] candidate = new Candidate[2];
		candidate[0] = new Candidate("Phillip J. Fry", "New York", "R");
		candidate[1] = new Candidate("John A. Zoidberg", "California", "D");
		
		for(int i = 0; i <= 50; i++)
		{
			states[i] = new State(input.next(), input.nextInt(), input.nextInt(), input.next());
			input.nextLine();
		}
		System.out.println("At this election in year 3000, " + candidate[0].getName() + " a " + candidate[0].getParty() + " from " + candidate[0].getState() + " is \nrunning against " + candidate[1].getName() + " a " + candidate[1].getParty() + ", who is originally from \nDecapod 10, but claims his home state is " + candidate[1].getState()  + ".\n");
		Thread.sleep(1000);
		
		//popular votes for each state

		for(int i = 0; i <= 50; i++)
		{
			states[i].populationVotes();
			states[i].getVotes();
			//Thread.sleep(700);
			System.out.println("");
			System.out.println("At " + states[i].getName() + ", a " + states[i].getParty() + " state, ");
			if(states[i].getDemVotes() > states[i].getRepVotes())
			{
				System.out.println("	" + candidate[1].getName() + " beat " + candidate[0].getName() + " with a " + states[i].getDemVotes() + " to " + states[i].getRepVotes() + " win!\n");
			}
			else if(states[i].getRepVotes() > states[i].getDemVotes())
			{
				System.out.println("	" + candidate[0].getName() + " beat " + candidate[1].getName() + " with a " + states[i].getRepVotes() + " to " + states[i].getDemVotes() + " win!\n");
			}
			
		}
		System.out.println("\n\n\n\n\n\n\n\n");
		System.out.println("				Results:\n");
		
		//total popular votes for candidates
		
		int totalDemVotes = 0;
		int totalRepVotes = 0;
		for(int i = 0; i <= 50; i++)
		{
			totalDemVotes = totalDemVotes + states[i].getDemVotes();
			totalRepVotes = totalRepVotes + states[i].getRepVotes();
		}
		if(totalDemVotes > totalRepVotes)
		{
			System.out.println(candidate[1].getName() + " won the popular vote over " + candidate[0].getName() + " with a " + totalDemVotes + " to \n			      " + totalRepVotes + " win!\n\n\n\n" );
		}
		else if(totalRepVotes > totalDemVotes)
		{
			System.out.println(candidate[0].getName() + " won the popular vote over " + candidate[1].getName() + " with a " + totalRepVotes + " to \n			      " + totalDemVotes + " win!\n\n\n\n" );
		}
		
		//total electoral votes for candidates
		
		int totalEleDem = 0;
		int totalEleRep = 0;
		
		for(int i = 0; i<= 50; i++)
		{
			states[i].getElectoralVote();
			if(states[i].getDemVotes() > states[i].getRepVotes())
			{
				totalEleDem = totalEleDem + states[i].getElectoralVote();
			}
			
			else if(states[i].getRepVotes() > states[i].getDemVotes())
			{
				totalEleRep = totalEleRep + states[i].getElectoralVote();
			}
		
		}
		
		//Final Results (Electoral Vote Winner)
		
		if(totalEleDem > totalEleRep)
		{
			System.out.println("	" + candidate[1].getName() + " beat " + candidate[0].getName() + " with a " + totalEleDem + " to " + totalEleRep + " win!\n");
		}
		else if(totalEleRep > totalEleDem)
		{
			System.out.println("	" + candidate[0].getName() + " beat " + candidate[1].getName() + " with a " + totalEleRep + " to " + totalEleDem + " win!\n");
		}
		System.out.println("		Presenting your new President! Zoidberg!");
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		System.out.println("		__....-------....__");
        System.out.println("            ..--\'\"                   \"`-..");
        System.out.println("         .\'\"                              `.");
        System.out.println("       :\'                                   `,");
        System.out.println("     .\'                                       \".");
        System.out.println("    :                                           :");
        System.out.println("   :                                             b");
        System.out.println("  d                                              `b");
        System.out.println("  :                                               :");
        System.out.println("  :                                               b");
        System.out.println(" :                                                q");
        System.out.println(" :                                                `:");
        System.out.println(":                                                  :");
        System.out.println(",'                                                  :");
        System.out.println(":    _____                  _____                   p'");
        System.out.println(" \\,.-\'     `-.            .-\'     `-.                :");
        System.out.println(".\'           `.        .'           `.              :");
     System.out.println("/               \\      /               \\            p'");
    System.out.println(":      @          ;    :      @          ;           :");
    System.out.println("|                 |    |                 |           :");
    System.out.println(":                 ;    :                 ;          ,:");
    System.out.println(" \\               /      \\               /           p");
    System.out.println(" /`.           .'        `.           .'           :");
    System.out.println("q_  `-._____.-.            `-._____.-'             :");
    System.out.println(" /-__     .\"\"           \"-.__                    :'");
    System.out.println("(_    \"\"-.\'                   \"\"\"---bmw           :");
    System.out.println("  \"._.-\"\"                                        ,:");
    System.out.println(" ,\"\"                                             P");
   System.out.println("\".\"                                                :");
  System.out.println("\"      _.\"      .\"        .\"        _...           :");
 System.out.println("P     .\"        \"        .\'        ,\"####)          :");
System.out.println(":     .\"       .\"        /        ,'######'          :");
System.out.println(":     :       (        ,\"        ,########:         ,:");
System.out.println(" q    `.      '.       ,        :######,-'          :");
System.out.println(" `:    b       q       :        '--''\"\"             :");
System.out.println("  :     :      :       :        :                   :");
System.out.println("  :     :      `:      `.       \".                 :'");
System.out.println("  q_    :       :       :         )                :");
System.out.println("    \"\"\'b`._   ,.`.____,\' `._   _.\'                 ,");
System.out.println("       |.__\"\"\"              \"\"\"     _______.......\',");
System.out.println("     ,\'    \"\"\"\"\"\"\"-----.------\"\"\"\"\"\"\"               :");
System.out.println("     :                 :                            :");
System.out.println("     :                 :                            :");
System.out.println("     :.__              :           ________.......,\'");
System.out.println("         \"\"\"\"\"\"\"\"------\'------\"\"\"\"\"\"");	

		

		
	}
}