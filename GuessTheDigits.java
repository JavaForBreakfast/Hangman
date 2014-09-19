import java.util.*;

// Should make this for any length number, just 5 for now

public class GuessTheDigits {
    private boolean unfinished = true;
    private int[] answer;
    private Scanner scan;
    private int guessNum = 1;
    private boolean giveUp = false;
  public GuessTheDigits() {
        answer = new int[5];
        setAnswer();
        scan = new Scanner(System.in);
        while(unfinished && !giveUp) {
             guess();
        }
        if (!unfinished) {
           System.out.println("Great job! You got it in " + (guessNum-1) + " guesses!");
         }
        else {
         System.out.println("The answer is... " + answer[0] + "" + answer[1] + "" + answer[2] + "" + answer[3] + "" + answer[4]);
        } 
  }
  
  
  public void setAnswer() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            answer[i] = rand.nextInt(9) + 1;
        }
  }
  
  public static void main(String[] args) {
        GuessTheDigits gtd = new GuessTheDigits();
  }
  
  public void guess() {
        System.out.println("Guess a 5 digit number... (guess number " + guessNum + ")");
        System.out.println("Type G if you want to give up!");
        guessNum++;
        String g = scan.nextLine();
        if (g.equals("G")) {
             giveUp = true;
        }
        else {
        boolean allRight = true;
        for (int i = 0; i < 5; i++) {
            int num = (int)(Character.getNumericValue(g.charAt(i)));
            if (num == answer[i]) {
                System.out.print("[IN CORRECT PLACE]");
            }
            // SUCH A GROSS WAY TO WRITE IT (BELOW)
            else if (answer[0]==num||answer[1]==num||answer[2]==num||answer[3]==num||answer[4]==num) {
                allRight = false;
                System.out.print("[NUMBER EXISTS]");
            }
            else {
                allRight = false;
                System.out.print("[NUMBER DOESN'T EXIST]");
            }
        }
        System.out.println("\n");
        if (allRight) {
            unfinished = false;
        }
        }
  }


}
