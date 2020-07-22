package com.itheima.leetcode.ByteDance;

import java.util.Stack;

/**
 * @author YXH
 * @date 2020/7/19 - 11:06
 * <p>
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
 * 这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * <p>
 * 示例 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，
 * 因为岛屿只能包含水平或垂直的四个方向的 1 。
 * <p>
 * 示例 2:
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class TheLargestAreaOfTheIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }

        int max = 0;
        //循环遍历二维数组，直到遇到岛屿
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    //遇到岛屿时，将当前坐标当作种子，执行种子填充算法
                    int temp = cal(new Location(i, j), grid);
                    if(max < temp) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    public int cal(Location local, int[][] grid) {
        Stack<Location> s = new Stack<Location>();
        s.push(local);
        int sum = 0;

        while(!s.empty()) {
            local = s.pop();
            int i = local.i;
            int j = local.j;

            if(grid[i][j] != 0) {
                grid[i][j] = 0;
                sum++;
            }
            //按照左、上、右、下的顺序将为1的土地入栈
            if(j - 1 >= 0 && grid[i][j - 1] == 1) {
                s.push(new Location(i, j - 1));
            }
            if(i - 1 >= 0 && grid[i - 1][j] == 1) {
                s.push(new Location(i - 1, j));
            }
            if(j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                s.push(new Location(i, j + 1));
            }
            if(i + 1 < grid.length && grid[i + 1][j] == 1) {
                s.push(new Location(i + 1, j));
            }
        }
        return sum;
    }
}

class Location {
    public int i;
    public int j;

    Location(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
