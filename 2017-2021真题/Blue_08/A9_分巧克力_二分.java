package Blue_08;

import java.util.Scanner;

/*9、分巧克力
 * 儿童节那天有 K 位小朋友到小明家做客。小明拿出了珍藏的巧克力招待小朋友们。
 * 小明一共有 N块巧克力，其中第 i块是 Hi*Wi 的方格组成的长方形。为了公平起见，
小明需要从这 N块巧克力中切出 K 块巧克力分给小朋友们。切出的巧克力需要满足：
形状是正方形，边长是整数;
大小相同;
例如一块 6x5 的巧克力可以切出 6 块 2x2 的巧克力或者 2 块 3x3 的巧克力。
当然小朋友们都希望得到的巧克力尽可能大，你能帮小明计算出最大的边长是多少么？
输入描述
	第一行包含两个整数 N,K
	以下 N 行每行包含两个整数 H_i,W_i
	输入保证每位小朋友至少能获得一块 1x1 的巧克力。
输出描述
	输出切出的正方形巧克力最大可能的边长。
输入
2 10
6 5
5 6
输出	 2
*/

public class A9_分巧克力_二分 {
	public static void main(String[] args) {
		int n,k;
		int []h=new int[10000];
		int []w=new int[10000];
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		for(int i=0;i<n;i++) {
			h[i]=sc.nextInt();
			w[i]=sc.nextInt();
		}
		
		int l=1;
		int r=100001;//左 右边界值
		int ans=0;
		// 二分法依次试 用找合适或者后继的二分法
		while (l<=r) {
			int mid=(l+r)/2;
			int cnt=0;
			
			//每块都按照len 来切割
			for(int i=0;i<n;i++) {
				cnt+=(h[i]/mid)*(w[i]/mid);//计算所有巧克力的长宽 按长度为mid边长切 结果能切处几个
			}
			if(cnt>=k) { //只要符合， L就会+1 所以停止的时候 L大于刚刚好的时候
				l=mid+1;
				ans=mid;
			}
			else {
				r=mid-1;
			}
		}
		System.out.println(ans);
	}
}
