
/* Author: Mortyyy
 * 
 * This is the main class for the mine sweeper game.
 * Requires Game and GameRunner. 
 * 
 * The game displays a 10x10 "field" in the console.
 * "Mines" are generated at random and placed in the
 * grid, hidden from the player. The player chooses 
 * tiles in the grid to clear them. Adjacent tiles
 * will display the number of "mines" around them.
 * The game ends when the player selects a tile with
 * a mine.
 * 
 */ 

public class GameTest{
  public static void main(String[] args){
    GameRunner.init();
    GameRunner.test();
  }
}
