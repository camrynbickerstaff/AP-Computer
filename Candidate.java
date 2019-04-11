//Camryn Bickerstaff
//
//
public class Candidate
{
	private String name, state, party;

	
	public Candidate(String n, String s, String p)
	{
		name = n;
		state = s;
		party = p;
	}

	public String getName()
	{
		return name;
	}

	public String getState()
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