package Blue_08;

import java.util.Scanner;

/*小明几乎每天早晨都会在一家包子铺吃早餐。他发现这家包子铺有 N种蒸笼，其中第 i种蒸笼恰好能放 Ai个包子。
 * 每种蒸笼都有非常多笼，可以认为是无限笼。每当有顾客想买 X个包子，卖包子的大叔就会迅速选出若干笼包子来，
 * 使得这若干笼中恰好一共有 X个包子。
 * 比如一共有 3 种蒸笼，分别能放 3、4 和 5 个包子。当顾客想买 11 个包子时，大叔就会选 2 笼 3 个的再加 1 笼 5 个的（也可能选出 1 笼 3 个的再加 2 笼 4 个的）。
当然有时包子大叔无论如何也凑不出顾客想买的数量。比如一共有 3 种蒸笼，分别能放 4、5 和 6 个包子。而顾客想买 7 个包子时，大叔就凑不出来了。
小明想知道一共有多少种数目是包子大叔凑不出来的。
第一行包含一个整数 N
以下 N 行每行包含一个整数 Ai
输入
2  
4 5 
输出 6
https://blog.csdn.net/chenpeixing361/article/details/88422888
  */

public class A8_包子凑数_DP背包 {
	//用于存放包笼存放的包子数目
		static int[] a = new int[100];
		
		//用于判断1——100*100的正整数能否被凑齐,初始值为假
		static boolean[] dp = new boolean[100*100];
		
		//求最大公约数函数
		static int gcd(int a,int b) {
			if( b == 0) return a;
			else
				return gcd(b,a%b);
		}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for( int i=0; i<n; i++ ) {
			a[i] = sc.nextInt();
		}
		
		int m = a[0];
		//求出多个笼包的最大公约数
		for( int i=1; i<n; i++ ) {
			m = gcd(m,a[i]);
		}
		
		//如果最大公约数不为1,则输出INF
		if( m != 1) {
			System.out.println("INF");
		}
		//否则利用 完全背包  计算出凑不齐的包子方案数
		/*a[0]=4 ,a[1]=5
		 *       0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
		 * a[0]  √ × × × √ × × × √ ×  ×  ×  √  ×  ×  ×  √ 
		 * a[1]  √ × × × √ √ × × √ √  √  ×  √  √  √  √  √
		 */		
		else {
			dp[0] = true; //0 肯定可以
			for( int i=0; i<n; i++ ) {
				for( int j=0 ; a[i]+j <100*100; j++) {
					if(dp[j]) {
						dp[a[i]+j] = true;
					}
				}
			}
			int count = 0;
			for( int i=0; i<100*100; i++ ) {
				//该包子未被凑齐
				if( dp[i] == false) {
					//这里可以打印出凑不出的包子数目,便于验证
					//System.out.println(i);
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
