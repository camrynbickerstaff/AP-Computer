//Camryn Bickerstaff
//
//

import java.util.*;
public class State
{
	private String state, party;
	private int population, electoral;
	int populationVote = 0;	int vote = 0;
	int republicanVote = 0;
	int democratVote = 0;
	
	public State(String s, int p, int e, String pa)
	{
		state = s;
		population = p;
		electoral = e;
		party = pa;
	}
	
	
	public void populationVotes()
	{
		populationVote = (int)(population*(.4));
	}


	public void getVotes()
	{
		republicanVote = 0;
		democratVote = 0;
		if(party.equals("D"))
		{
			for(int i = 0; i <= populationVote; i++)
			{
				vote = ((int)((Math.random()*100)+1));
				if(vote <= 51)
				{
					democratVote = democratVote + 1;
				}
				else
				{
					republicanVote = republicanVote + 1;	
				}	
			}
		}
		
		else if(party.equals("R"))
		{
			for(int i = 0; i <= populationVote; i++)
			{
				vote = ((int)((Math.random()*100)+1));
				if(vote <= 51)
				{
					republicanVote = republicanVote + 1;
				}
				else
				{
					democratVote = democratVote + 1;	
				}
			}	
		}
		
		else if(party.equals("S"))
		{
			for(int i = 0; i <= populationVote; i++)
			{
				vote = ((int)(Math.random()*2)+1);
				if(vote == 1)
				{
					republicanVote = republicanVote + 1;
				}
				else if(vote == 2)
				{
					democratVote = democratVote + 1;	
				}
					
			}	
		}
		if(democratVote == republicanVote)
		{
			vote = ((int)(Math.random()*2)+1);
				if(vote == 1)
				{
					republicanVote = republicanVote + 1;
				}
				else if(vote == 2)
				{
					democratVote = democratVote + 1;	
				}
		}
		
	}
	
	public int getDemVotes()
	{
		return democratVote;
	}

	public int getRepVotes()
	{
		return republicanVote;
	}
	
	public int getElectoralVote()
	{
		return electoral;
	}
	
	public String getName()
	{
		return state;
	}
	
	public String getParty()
	{
		if(party.equals("R"))
		{
			return "Republican";
		}
		else if(party.equals("D"))
		{
			return "Democratic";
		}
		else if(party.equals("S"))
		{
			return "Swing";
		}
		return "";
	}
}	
