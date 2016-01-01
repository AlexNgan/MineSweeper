import java.util.Scanner;

/* Author: Gloria Ngan
 * 
 * This is the class that actually runs the methods of 
 * the game.
 */ 

public class GameRunner{
   
  public static void test(){
    Game game = new Game();
    game.generateMines();
    game.update();
    Scanner scan = new Scanner(System.in);   
    
    while(true){
      int x, y = -1;
      System.out.print("Enter an x coordinate.");
      x = scan.nextInt();
      System.out.print("Enter a y coordinate.");
      y = scan.nextInt();
      
      if(game.isDone == false){
        //game.detect(x,y);
        game.turn(x,y);
        game.update();
      }else{
        break;
      }
    }   
  }
}
