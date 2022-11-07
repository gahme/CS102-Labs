//********************************************************************
//  Maze.java       Author: Lewis/Loftus
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

public class Maze
{
   private final int TRIED = 7; //Previously 3
   private final int PATH = 8; //Previously 7

   // Colours represented as ints
   private final int DEFAULT = 1;
   private final int RED = 2;
   private final int GREEN = 3;
   private final int BROWN = 4;


   // private int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
   //                          {1,0,1,1,1,0,1,1,1,1,0,0,1},
   //                          {0,0,0,0,1,0,1,0,1,0,1,0,0},
   //                          {1,1,1,0,1,1,1,0,1,0,1,1,1},
   //                          {1,0,1,0,0,0,0,1,1,1,0,0,1},
   //                          {1,0,1,1,1,1,1,1,0,1,1,1,1},
   //                          {1,0,0,0,0,0,0,0,0,0,0,0,0},
   //                          {1,1,1,1,1,1,1,1,1,1,1,1,1} };

   // private int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
   //                          {1,0,1,1,1,0,1,1,1,1,0,0,1},
   //                          {0,0,0,0,1,0,1,0,1,0,1,0,0},
   //                          {1,1,1,0,1,1,1,0,1,0,1,1,1},
   //                          {1,0,1,0,0,0,0,1,1,1,0,0,1},
   //                          {1,0,GREEN,0,0,0,GREEN,1,0,1,1,1,1},
   //                          {1,0,0,0,0,0,0,0,0,0,0,0,0},
   //                          {1,1,1,BROWN,0,0,0,BROWN,1,1,1,1,1} };

   // private int[][] grid = {{1, 0, 0, 0, 0, 0},
   //                                  {1, 1, RED, 0, 0, 0},
   //                                  {0, 0, 0, 0, RED, 1}};

   // private int[][] grid = {{1, 1, 0, 0, 0, 0},
   //                                  {1, 1, RED, 1, 1, 0},
   //                                  {1, 1, 1, RED, 1, 0},
   //                                  {0, 0, 0, 1, 1, 1}};

   // private int[][] grid = {{1, 1, 1, RED, 1, 1},
   //                                  {0, 1, 1, 1, 1, 1},
   //                                  {0, 1, 0, 0, 0, 0},
   //                                  {0, 0, 0, RED, 0, 1}};

   private int[][] grid = {{1, RED, 0, RED, 1, 1},
                                    {0, 0, 0, 0, 0, GREEN},
                                    {0, 0, 0, 1, 0, 0},
                                    {0, 0, 0, 0, 0, 0},
                                    {GREEN, BROWN, 0, 0, BROWN,1}};



   //-----------------------------------------------------------------
   //  Attempts to recursively traverse the maze. Inserts special
   //  characters indicating locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column)
   {
      boolean done = false;
      
      if (valid(row, column)){
         int colour = grid[row][column];

         if (colour == DEFAULT){      
            // Normal exploration (up, down, left, right)

            grid[row][column] = TRIED;  // this cell has been tried

            if (row == grid.length-1 && column == grid[0].length-1){
               done = true;  // the maze is solved
            } else{
               done = traverse (row+1, column);     // down
               if (!done)
                  done = traverse (row, column+1);  // right
               if (!done)
                  done = traverse (row-1, column);  // up
               if (!done)
                  done = traverse (row, column-1);  // left
            }

         } else{
            // Portal exploration (to portal exit)

            grid[row][column] = TRIED;
            int exitRow = portalExitRow(colour);
            int exitColumn = portalExitColumn(colour);
            grid[exitRow][exitColumn] = DEFAULT;

            done = traverse(exitRow, exitColumn);
         }
            

         if (done)  // this location is part of the final path
            grid[row][column] = PATH;
      }

      return done;
   }
   
   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously tried
         if (1 <= grid[row][column] && grid[row][column] <= 4)
            result = true;

      return result;
   }

   //-----------------------------------------------------------------
   // Determine portal exit coordinates
   //-----------------------------------------------------------------
   private int portalExitRow(int colour){
      for (int row=0; row < grid.length; row++){
         for (int column=0; column < grid[row].length; column++){
            if (grid[row][column] == colour) return row;
         }
      }
      return -1;
   }

   private int portalExitColumn(int colour){
      for (int row=0; row < grid.length; row++){
         for (int column=0; column < grid[row].length; column++){
            if (grid[row][column] == colour) return column;
         }
      }
      return -1;
   }

   //-----------------------------------------------------------------
   //  Returns the maze as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }
}
