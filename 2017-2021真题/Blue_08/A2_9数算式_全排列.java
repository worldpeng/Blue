package Blue_08;

import java.util.Arrays;

/*https://www.lanqiao.cn/problems/638/learning/
 * 问题描述
观察如下的算式：
	9213 x 85674 = 789314562
左边的乘数和被乘数正好用到了1~9的所有数字，每个1次。
而乘积恰好也是用到了1~9的所有数字，并且每个1次。
请你借助计算机的强大计算能力，找出满足如上要求的9数算式一共有多少个？

 * （一）将0-9一共10个数进行全排列，然后去判断0的位置，如果0不在边缘，就可以分割成两部分，记录0的位置，就可以将2个数字用循环就出来，
 * 然后进行判断就可以了。
 * （二）直接就1-9一共9个数的全排列，然后用一个循环控制乘号的位置，每遍历一次，就将这个遍历好的数字用这个循环试一遍（把乘号插入进数字中进行尝试）。
 * 然后也可以得到两个数字，之后就可以判断了。这里要特别注意，最后的结果要除以2！！！！
*/

public class A2_9数算式_全排列 {
    static int[] arr = {1,2,3,4,5,6,7,8,9};
    static int result = 0;
    public static void main(String[] args) {
        f(0);
        System.out.println(result/2);
    }
    
    //全排列
    public static void f(int start){
        if(start == 8) {
        	//每次递归 都查找一次
            find();
            return;
        }
        int temp = 0;
        //全排列递归
        for(int i = start;i<9;i++) {
        	//从0开始，依次往后，到8，第一个数字出来
        	swap(arr,start,i);
            f(start+1);
            //右
            swap(arr,start,i);
        }
    }
    
    private static void swap(int[] arr, int start, int i) {
    	int temp;
    	temp=arr[start];
    	arr[start]=arr[i];
    	arr[i]=temp;
		
	}

	//查找是否符合
    public static void find() {
        int x = 0;
        int y = 0;
        int ans = 0;
        for(int j=0;j<9;j++) {
        	//j之前组成一个数
            x = tonum(0,j);
            //j+1之后组成一个数
            y = tonum(j+1,8);
            ans = x * y;
            //检查重复
            if(check(ans)) {
                result++;
            };
            
        }
    }
    //根据arr数组中的数，生成对应的数
    public static int tonum(int start,int end) {
        int ans = 0;
        for(int i = start;i<=end;i++){
            ans = ans * 10;
            ans = ans+arr[i];
        }
        return ans;
    }
  //判断是否重复
    public static boolean check(int ans) {
        int[] count = new int[10];
        int yushu = 0;
        //每一位数取余 对应数组 0->1
        while(ans>10){
            yushu = ans%10;
            count[yushu]++;
            ans = ans /10;
        }
        if(ans<10) {
            count[ans]++;
        }
        for(int i = 1;i<10;i++) {
            if(count[i]>1||count[i] ==0) {
                return false;
            }
        }
        return true;
    }
}