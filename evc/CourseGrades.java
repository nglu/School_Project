package evc;

public class CourseGrades implements Analyzable
{
	private GradeActivity[] grades = new GradeActivity[4];
	
	public void setLab(GradeActivity o)
	{
		grades[0] = o;
	}
	
	public void setPassFailExam(PassFailExam o)
	{
		grades[1] = o;
	}
	
	public void setEssay(Essay o)
	{
		grades[2] = o;
	}
	
	public void setFinalExam(FinalExam o)
	{
		grades[3] = o;
	}
	
	public double getAverage()
	{
		double sum = 0;
		for (int i = 0; i < grades.length; i++)
		{
			sum += grades[i].getScore();
		}
		return sum / grades.length;
	}
	
	public GradeActivity getHighest()
	{
		GradeActivity highest = new GradeActivity();
		highest = grades[0];
		for (int i = 0; i < (grades.length - 1); i++)
		{
			if (highest.getScore() < grades[i+1].getScore())
				highest = grades[i+1];
		}
		return highest;
	}
	
	public GradeActivity getLowest()
	{
		GradeActivity lowest = new GradeActivity();
		lowest = grades[0];
		for (int i = 0; i < (grades.length - 1); i++)
		{
			if (lowest.getScore() > grades[i+1].getScore())
				lowest = grades[i+1];
		}
		return lowest;
	}
	
	public String toString()
	{
		String str = "Lab Score: " + grades[0].getScore() + " --- Grade: " + grades[0].getGrade() +
				"\nPass/Fail Exam Score: " + grades[1].getScore() + " --- Grade: " + grades[1].getGrade() +
				"\nEssay Score: " + grades[2].getScore() + " --- Grade: " + grades[2].getGrade() +
				"\nFinal Exam Score: " + grades[3].getScore() + " --- Grade: " + grades[3].getGrade() +
				"\nAverage Score: " + getAverage() +
				"\nHighest Score: " + getHighest().getScore() +
				"\nLowest Score: " + getLowest().getScore();
		return str;
	}
}