package evc;

public class PassFailActivity extends GradeActivity
{
	private double minPassingScore;

	public PassFailActivity(double mps)
	{
		minPassingScore = mps;
	}

   @Override
   public char getGrade()
   {
      char letterGrade;

      if (super.getScore() >= minPassingScore)
         letterGrade = 'P';
      else
         letterGrade = 'F';
      return letterGrade;
    }
}
