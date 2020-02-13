package CodingChallenges.FindNumOfIslands;

import org.junit.Test;

public class Solution {
    /**
     * Given method body to implement
     */
    public int numIslands(char[][] grid){
        int counter = 0;

        // Ausnahme
        if(grid == null || grid.length == 0)
            return 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                counter += islandCounter(grid, i, j);
            }
        }
        return counter;
    }

    private int islandCounter(char[][] array, int i, int j){
        // Randbedingungen
        if(i >= array.length || j >= array[0].length || i < 0 || j < 0 || array[i][j] == '0') {
            return 0;
        }

        array[i][j] = '0';

        islandCounter(array, i + 1,j);
        islandCounter(array,i, j + 1);
        islandCounter(array,i - 1, j);
        islandCounter(array, i,j - 1);

        return 1;
    }
}
