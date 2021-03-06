package com.itheima.swordRefersToOffer;

import java.util.ArrayList;

/**
 * @author YXH
 * @date 2019/11/18 - 15:01
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrixClockwise {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0 || col == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        int left = 0,top = 0,bottom = row - 1,right = col - 1;
        while(left <= right && top <= bottom){
            for(int i = left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            for(int j = top+1;j<=bottom;j++){
                list.add(matrix[j][right]);
            }
            if (top != bottom) {
                for(int t = right-1;t>=left;t--){
                    list.add(matrix[bottom][t]);
                }
            }
            if(left != right) {
                for(int k = bottom-1;k>top;k--){
                    list.add(matrix[k][left]);
                }
            }
            top++;left++;right--;bottom--;
        }
        return list;
    }
}
