package com.itheima.swordRefersToOffer;

import java.util.Stack;

/**
 * @author YXH
 * @date 2019/11/18 - 15:03
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数
 * （时间复杂度应为O（1））。
 */
public class StackContainingTheMianFunction {
    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();
    public void push(int node) {
        s1.push(node);
        if(s2.isEmpty()||s2.peek()>=node) {
            s2.add(node);
        } else{
            s2.add(s2.peek());
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
