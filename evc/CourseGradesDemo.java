package evc;

public class CourseGradesDemo 
{
	public static void main(String[] arg)
	{
		GradeActivity lab = new GradeActivity();
		lab.setScore(85.00);
		
		PassFailExam pfe = new PassFailExam(20, 3, 70);
		
		Essay ess = new Essay(25, 18, 17, 20);
		
		FinalExam fie = new FinalExam(50, 10);
		
		CourseGrades courseGrade = new CourseGrades();
		courseGrade.setLab(lab);
		courseGrade.setPassFailExam(pfe);
		courseGrade.setEssay(ess);
		courseGrade.setFinalExam(fie);
		
		System.out.print(courseGrade);
	}
}
