package CodingChallenges.FindNumOfIslands;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestClass {
    Solution s;


    @Before
    public void init(){
        s = new Solution();
    }

    @Test
    public void map_with_only_water(){
        char[][] map = {
            {'0','0','0','0'},
            {'0','0','0','0'},
            {'0','0','0','0'}
        };
        int answer = s.numIslands(map);

        assertEquals(0,answer);
    }

    @Test
    public void map_with_only_land(){
        char[][] map = {
                {'1','1','1','1'},
                {'1','1','1','1'},
                {'1','1','1','1'}
        };
        int answer = s.numIslands(map);

        assertEquals(1,answer);
    }

    @Test
    public void simpleMap(){
        char[][] map = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        int answer = s.numIslands(map);

        assertEquals(3,answer);
    }

    @Test
    public void h_Map(){
        char[][] map = {
                {1,1,1},
                {0,1,0},
                {1,1,1}
        };
        int answer = s.numIslands(map);

        assertEquals(1,answer);
    }
}
