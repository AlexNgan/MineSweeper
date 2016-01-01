import java.util.Scanner;

/* Author: Gloria Ngan
 * 
 * This is the class that actually runs the methods of 
 * the game.
 */ 

public class GameRunner{
  
  //Displays rules at beginning of game.
  public static void init(){
    System.out.println("The object of the game is to clear the field of all safe tiles.");
    System.out.println("Play by entering the coordinates of a tile you'd like to select.");
    System.out.println("The range of the tiles is 1-10. The origin is the upper left tile.");
    System.out.println("There are 16 mines. Selecting a tile with a mine will end the game.");
  }
  
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
      
      if(game.finished() == true){
        break;
      }else if(game.finished() == false){
        game.turn(x,y);
        game.update();
      }
    }   
  }
}
