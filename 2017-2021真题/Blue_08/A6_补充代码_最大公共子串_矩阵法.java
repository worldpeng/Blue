package Blue_08;

/*最大公共子串长度问题就是： 求两个串的所有子串中能够匹配上的最大长度是多少。
比如："abcdkkk" 和 "baabcdadabc"， 可以找到的最长的公共子串是"abcd",所以最大公共子串长度为 4。
下面的程序是采用矩阵法进行求解的，这对串的规模不大的情况还是比较有效的解法。
请分析该解法的思路，并补全划线部分缺失的代码
*/
public class A6_补充代码_最大公共子串_矩阵法 {
	 static int f(String s1, String s2)
	    {
	        char[] c1 = s1.toCharArray();
	        char[] c2 = s2.toCharArray();
	        int[][] a = new int[c1.length+1][c2.length+1];
	        int max = 0;
	        for(int i=1; i<a.length; i++){
	            for(int j=1; j<a[i].length; j++){
	                if(c1[i-1]==c2[j-1]) {
	                    a[i][j] = a[i-1][j-1]+1; 
	                    if(a[i][j] > max) 
	                    	max = a[i][j];
	                }
	            }
	        }
	        return max;
	    }
	    
	    public static void main(String[] args){
	        int n = f("abcdkkk", "baabcdadabc");
	        System.out.println(n);
	        System.out.println(f("aaakkkabababa", "baabababcdadabc"));
	        System.out.println(f("abccbaacbcca", "ccccbbbbbaaaa"));
	        System.out.println(f("abcd", "xyz"));
	        System.out.println(f("ab", "ab"));
	        
	    }

}
