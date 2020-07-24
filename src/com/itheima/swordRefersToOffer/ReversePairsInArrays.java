package com.itheima.swordRefersToOffer;

/**
 * @author YXH
 * @date 2020/7/24 - 21:12
 * <p>
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,
 * 求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * <p>
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * <p>
 * 示例1
 * 输入   1,2,3,4,5,6,7,0
 * 输出   7
 */
public class ReversePairsInArrays {
    public int InversePairs(int [] array) {
        return merge(array, 0, array.length-1);
    }
    public int merge(int[] nums, int start, int end){
        if(start>=end){
            return 0;
        }
        int mid=(start+end)/2;
        int count=0;
        count+=merge(nums, start, mid);
        count+=merge(nums,mid+1, end);
        // mid为中心左右各一半
        int[] temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int p=0;
        while(i<=mid&&j<=end){
            if(nums[i]<nums[j]){
                temp[p++]=nums[i++];
            }else{
                //注意:这里不加%1000000007会有问题
                count=(count+(mid-i+1))%1000000007;
                temp[p++]=nums[j++];
            }
        }
        if(i<=mid){
            while(i<=mid){
                temp[p++]=nums[i];
                i++;
            }
        }
        if(j<=end){
            while(j<=end){
                temp[p++]=nums[j];
                j++;
            }
        }
        for(int k=0;k<end-start+1;k++){
            nums[start+k]=temp[k];
        }
        return count;
    }
}
