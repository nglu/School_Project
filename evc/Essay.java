package evc;

public class Essay extends GradeActivity
{
	private double grammar, spelling, length, content;
	
	public Essay(int gra, int spe, int len, int con)
	{
		grammar = gra;
		spelling = spe;
		length = len;
		content = con;
		setScore(gra + spe + len + con);
	}
	
	public double getGrammarScore()
	{
		return grammar;
	}
	
	public double getSpellingScore()
	{
		return spelling;
	}
	
	public double getLengthScore()
	{
		return length;
	}
	
	public double getContentScore()
	{
		return content;
	}
}
