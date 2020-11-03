package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/11/3 - 11:32
 * <p>
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。例如
 * a b c e
 * s f c s
 * a d e e
 * ​
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b
 * 占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class PathsInMatrices {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int[] flag = new int[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (help(matrix, rows, cols, str, 0, flag, i, j)) {
                    return true;
                }
            }
        }
        return false;


    }

    public boolean help(char[] matrix, int rows, int cols, char[] str, int cur, int[] flag, int r, int c) {
        //int row, int col表明当前的坐标的行列值
        //flag表明那些曾经在路径中出现过的节点的坐标
        //cur表示当前需要匹配的字符的位置，是下一个待访问的节点，不需关系其有效性，因为最后一个元素是‘、0’
        int index = cols * r + c;
        if (r >= 0 && r < rows && c >= 0 && c < cols && flag[index] == 0) {
            if (matrix[index] == str[cur]) {
                cur = cur + 1;
                if (cur >= str.length) {
                    return true;
                }
                flag[index] = 1;
                if (help(matrix, rows, cols, str, cur, flag, r - 1, c) ||
                        help(matrix, rows, cols, str, cur, flag, r + 1, c) ||
                        help(matrix, rows, cols, str, cur, flag, r, c - 1) ||
                        help(matrix, rows, cols, str, cur, flag, r, c + 1)) {
                    return true;
                }
                flag[index] = 0;
                return false;
            }
            return false;
        }

        return false;
    }
}
