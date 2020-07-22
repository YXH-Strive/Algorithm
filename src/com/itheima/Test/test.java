package com.itheima.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author YXH
 * @date 2019/12/15 - 9:19
 */
public class test {
        public static void main(String[] args) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            Scanner in = new Scanner(System.in);
            int a = 0;
            while (in.hasNextInt()) {
                a = in.nextInt();
                System.out.println(a);
            }
            int[] test=new int[Integer.MAX_VALUE];
            for (int i = 0; i < test.length; i++) {
                test[i]=i;
            }
            Test(test,list);
            System.out.println(list);
        }

    private static ArrayList<Integer> Test (int test[],ArrayList<Integer> list){
        for (int i = 0; i < test.length; i++) {
            for (int j = i + 1; j < test.length; j++) {
                for(int k=j+1;k < test.length; k++) {
                    int z=(test[i]+test[k])/2;
                    if (test[i] < test[j] && test[j] < test[k] && z == test[j]) {
                        int temp;
                        temp = test[j];
                        test[j] = test[k];
                        test[k] = temp;
                        list.add(test[i]);
                        list.add(test[j]);
                        list.add(test[k]);
                    } else {
                        list.add(test[i]);
                        list.add(test[j]);
                        list.add(test[k]);
                    }
                }
            }
        }
        return list;
    }
}
