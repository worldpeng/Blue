package Blue_08;

import java.util.Arrays;
import java.util.Scanner;

public class 填空题_承压计算 {
	static int num=5;//换成31即可
	public static void main(String[] args) {
		
			Scanner scan=new Scanner(System.in);
			double[][] a=new double[num][num];
			a[0][0]=scan.nextDouble();
			int i,j;
			for(i=1;i<num;i++) {
				for(j=0;j<i+1;j++) {
					if(j==0)
					 a[i][j]=scan.nextDouble()+a[i-1][j]/2;
					else
						a[i][j]=scan.nextDouble()+a[i-1][j-1]/2+a[i-1][j]/2;
				}
			}
//			double max=a[num-1][0];
//			for(i=1;i<=num-1;i++) {
//				if(a[num-1][i]>max)
//					max=a[num-1][i];
//			}
//			System.out.println(max);
			for(i=0;i<num;i++)
				System.out.println(a[num-1][i]);
		}
	

}
