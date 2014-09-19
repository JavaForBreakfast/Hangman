import java.util.*;

public class Hangman {
   
   private String word;
   private int wrong;
   private ArrayList<Character> guesses;
   private Scanner scan;
   private String[] drawing;
   
   public static void main(String[] args) {
      Hangman h = new Hangman();
   }
   public Hangman() {
      scan = new Scanner(System.in);
      wrong = 0;
      guesses = new ArrayList<Character>();
      drawing = new String[6];
      setDrawings();
      System.out.println("Enter a word in all caps!");
      String a = scan.nextLine();
      word = a;
      System.out.println("You are on a piece of drift wood trying not to drown!");
      System.out.println("You have five wrong guesses before the drift wood disappears!");
      getGuess();
   }
   
   public void setDrawings() {
      drawing[0] = "O\n|\n_____";
      drawing[1] = "O\n|\n____";
      drawing[2] = "O\n|\n___";
      drawing[3] = "O\n|\n__";
      drawing[4] = "O\n|\n_";
      drawing[5] = "\\O/\n |\n~~~ \n";
   }
   
   public void setWrong(int a) {
      wrong = a;
   }
   
   public int getWrong() {
      return wrong;
   }
   
   public void resetAll(String w) {
      word = w;
      wrong = 0;
   }

   public boolean guess(String b) {
      guesses.add(b.charAt(0));
      for (int i = 0; i < word.length(); i++) {
         if ((b.charAt(0))==(word.charAt(i))) {
            return true;
         }
      }
      wrong++;
      return false;
   }
   
   public boolean printBoard() {
      System.out.println("You have guessed:");
      String st = "";
      int j = 0;
      for (Character s : guesses) {
         if (j == 0) {
            st += s;
            j++;
         }
         else {
            st += (", " + s);
         }
      }
      System.out.println(st + "\n\n");
      System.out.println("This is you:");
      System.out.println(drawing[wrong]);
      System.out.println("\n");
      if (wrong == 5) {
         return false;
      }
      System.out.println("So far you have...");
      boolean done = true;
      for (int i = 0; i < word.length(); i++) {
         if (guesses.contains(word.charAt(i))) {
            System.out.print(" " + word.charAt(i) + " ");
         } 
         else {
            System.out.print(" _ "); 
            done = false;
         }
      }
      System.out.println("\n");
      return done;
   }
   
   public void getGuess() {
      System.out.println("Time for your guess!");
      System.out.println("Type a letter IN CAPS!");
      String g = scan.nextLine();
      if (guesses.contains(g.charAt(0))) {
         System.out.println("You already guessed that!!!!");
         getGuess();
      }
      else {
         boolean done;
         if (guess(g)) {
            System.out.println("Correct!");
            done = printBoard();
            if (!done) {
               getGuess();
            }
            else {
               System.out.println("CONGRATS YOU WIN");
            }
         }
         else {
            System.out.println("OOPS");
            printBoard();
            if (wrong >= 5) {
                System.out.println("YOU LOSE");
            }
            else {
               getGuess();
            }
         }
      }
   }

}
