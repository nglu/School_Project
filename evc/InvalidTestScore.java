package evc;

public class InvalidTestScore extends Exception
{  
   public InvalidTestScore(int element, double score)
   {
      super("Invalid test score\nElement: " + element + " Invalid Score: " + score);
   }
}
