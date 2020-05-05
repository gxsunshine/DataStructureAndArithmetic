package com.gx.arithmetic.linkedListRelated;

/**
 * 解题思路：
 * 1，遍历这个二维数组，如果是岛（'1'），就进入感染函数，并且岛的数量加1
 * 2，感染函数实际，就是一个利用DFS思想向四周标注的过程，将所有相连接的'1'都标注成'2'，
 *    这样就避免了遍历二维数组被重复计算的情况，同时在感染的时候，也不会感染已经被感染过的了（'2'）
 *    这样感染递归也就更快了
 */

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: gx
 * @Date: Created in 2020/5/5 21:49
 * @Description: leetCode 200 - 岛屿的数量
 */
public class LeetCode200 {
    char[][] grid;

    // 初始化二维网格
    public void initGrid(){
        grid = new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
    }

    // 感染函数，DFS遍历
    public void DFSGrid(char[][] grid, int i, int j){
        // 如果超出边界之外，直接返回, 或者该位置不是岛屿'1'
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] != '1' ){
            return;
        }
        // 给访问了的位置标志为 ’2' ,避免重复访问
        grid[i][j] = '2';

        // DFS四周位置
        DFSGrid(grid, i, j+1);
        DFSGrid(grid, i+1, j);
        DFSGrid(grid, i, j-1);
        DFSGrid(grid, i-1, j);

        // 这里写的太重复
//        if((j + 1) < grid[0].length && grid[i][j+1] == '1'){
//            grid[i][j+1] = '2';
//            DFSGrid(grid, i, j+1);
//        }
//        if((i + 1) < grid.length && grid[i+1][j] == '1'){
//            grid[i+1][j] = '2';
//            DFSGrid(grid, i+1, j);
//        }
//        if((j - 1) > -1 && grid[i][j-1] == '1'){
//            grid[i][j-1] = '2';
//            DFSGrid(grid, i, j-1);
//        }
//        if((i - 1) > -1 && grid[i-1][j] == '1'){
//            grid[i-1][j] = '2';
//            DFSGrid(grid, i-1, j);
//        }
    }

    // 感染函数 - BFS遍历
    public void BFSGrid(char[][] grid, int i, int j){
        ArrayBlockingQueue<Location> queue =
                new ArrayBlockingQueue<Location>(grid.length * grid[0].length);
//                new ArrayBlockingQueue<Location>(1, true);
        queue.add(new Location(i, j));
        while(!queue.isEmpty()) {
            Location location = queue.poll();
            // 给访问了的位置标志为 ’2' ,避免重复访问
            grid[location.row][location.col] = '2';
            if ((location.col + 1) < grid[0].length && grid[location.row][location.col + 1] == '1') {
                queue.add(new Location(location.row, location.col + 1));
            }
            if ((location.row + 1) < grid.length && grid[location.row + 1][location.col] == '1') {
                queue.add(new Location(location.row + 1, location.col));
            }
            if ((location.col - 1) > -1 && grid[location.row][location.col - 1] == '1') {
                queue.add(new Location(location.row, location.col - 1));
            }
            if ((location.row - 1) > -1 && grid[location.row - 1 ][location.col] == '1') {
                queue.add(new Location(location.row - 1, location.col));
            }
        }
    }

    public static void main(String[] args) {
        LeetCode200 leetCode200 = new LeetCode200();
        leetCode200.initGrid();
        int numIsLands = 0;
        for(int i = 0; i < leetCode200.grid.length; i++){
            for(int j=0; j < leetCode200.grid[0].length; j++){
                if(leetCode200.grid[i][j] == '1'){
                    // 给访问了的位置标志为 ’2' ,避免重复访问
//                    leetCode200.grid[i][j] = '2';
                    numIsLands++;
                    // DFS 遍历
//                    leetCode200.DFSGrid(leetCode200.grid, i, j);
                    // BFS 遍历
                    leetCode200.BFSGrid(leetCode200.grid, i, j);
                }
            }
        }
        System.out.println("岛屿数为：" + numIsLands);
    }
}

class Location{
    int row;
    int col;
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
