package Blue_08;
// https://www.lanqiao.cn/problems/646/learning/
public class 填空题_等差素数列 {
	public static void main(String[] args) {
		
		for(int i = 1;i<10000;i++){//指定初值
            for(int j = 1;j<1000;j++){//指定公差
                int k;
                for(k=0;k<=9;k++){//看10个数是否为素数
                    if(!isPrime(i+k*j))
                        break;
                }
                if(k==10) {
                    System.out.println(j);
                    return ;
                }
            }
        }
    }

    public static boolean isPrime(int num){
        for(int i = num-1;i>1;i--){
            if(num%i==0)
                return false;
        }
        return true;
    }
}
