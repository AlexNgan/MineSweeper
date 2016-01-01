/* Author: Gloria 
 * 
 * This class contains the logic and methods that allow
 * the Mine Sweeper game to run properly. Two 12x12 arrays
 * are created when the program is run. The arrays are
 * filled with question marks and one is given mines.
 * 
 * Methods in this class update the console, determine if
 * the game is done, and the amount of mines around a tile.
 */

public class Game{
  public String[][] field = new String[12][12];   //12 rows, 12 columns.
  public String[][] display = new String[12][12]; //This is the field that is visible to the player.
  public Boolean isDone = false;
  
  private String unknown = " ? ";
  private String mine = " * ";
  private String empty = "   ";
  
  //Constructor places empty spaces in tiles.
  public Game(){
    int row = 0;
    int column = 0;
    
    for(int x = 0; x < field.length; x++){
      for(int y = 0; y < field[0].length; y++){
        //Places blank spaces in buffer zones.
        if((x == 0 || x == field.length - 1)||(y == 0 || y == field[0].length - 1)){
          field[x][y] = empty;
          display[x][y] = empty;
        }
        //Places ? in game field.
        else{
          field[x][y] = unknown;
          display[x][y] = unknown;
        }
      }
    }
  }
  
  //Displays the field.
  public static void printGame(String[][] str){
    for(int x = 1; x < str.length - 1; x++){   
      for(int y = 0; y < str[0].length ; y++){
        //Formats row.
        if(y > 0 && y < str[0].length)
          System.out.print("|");
        else
          System.out.println("");
        
        System.out.print(str[x][y]);  //Prints out content of each tile.
      }
    }
  }
  
  //Updates the console after every match.
  public void update(){
    printGame(field);
    System.out.println("");
    
    printGame(display);
    System.out.println("");
  }
  
  //Places 16 mines at random on the field.
  public void generateMines(){
    for(int m = 0; m < 16; m++){
      //Loops until a mine is placed.
      while(true){
        int x, y = 0;   //Clears vars.
        x = (int)(10*Math.random());
        y = (int)(10*Math.random());
        
        if(x >= 1 && x <= 10){
          if(y >= 1 && y <= 10){
            //Checks if a mine is present in a spot.
            if(!field[x][y].equals(mine)){
              field[x][y] = mine;
              break;
            }
          }
        }
      }
    }
  }
  
  //Detects number of mines around a selected tile.
  public int detect(int i, int j){
    int num = 0;
    for(int x = (i - 1); x < (i + 1); x++){
      for(int y = (j - 1); y < (j + 1); y++){
        if(field[x][y].equals(mine)){
          num++;
        }
      }
    }
    return num;
  }
  
  //Takes user's selected coordinates and adjusts the board.
  public void turn(int x, int y){
    while(true){
      if(display[x][y].equals(unknown) == true){
        display[x][y] = empty;
        break;
      }else if(display[x][y].equals(empty) == true){
        System.out.println("You've already selected this spot!");
        continue; //UNTESTED.
      }else if(display[x][y].equals(mine) == true){
        isDone = true;
        System.out.println("You've lost!");
      }
    }
  }
  
}
