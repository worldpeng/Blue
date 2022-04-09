package Blue_08;

import java.util.Scanner;

/*题目描述 2022-03-24 22:04:08
考虑一种简单的正则表达式：
只由 x ( ) | 组成的正则表达式。
小明想求出这个正则表达式能接受的最长字符串的长度。
例如 ((xx|xxx)x|(x|xx))xx 能接受的最长字符串是： xxxxxx，长度是 6。
*/

public class A7_代码题_正则问题_DFS {
	static int pos = 0;//当前的位置
	static int len;//字符串长度
	static char[] chars;//字符数组
	
	//深度遍历
	static int dfs() {
        int max = 0;
        int cur = 0;
        while (pos < len) {
            if (chars[pos] == '(') {
                //进入下一层搜索
                pos++;
                cur += dfs();
            } else if (chars[pos] == '|') {
                pos++;
                //选出较大的一部分
                max=Math.max(max, cur);

                cur = 0;//cur归零

            } else if (chars[pos] == ')') {
                //一组匹配结束  回溯
                pos++;
                break;
            } else {
                //直接加一
                pos++;
                cur++;
            }
        }
        max=Math.max(max, cur);
        return max;
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		chars=s.next().toCharArray();
		len = chars.length;
        System.out.println(dfs());
	}

}
