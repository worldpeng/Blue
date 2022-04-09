package Blue_08;
//DFS 问题
/*题目中已经有明显的暗示——沿着格子边线剪开。
只看每一个格子的顶点及边，可以把整个方格放置到一个二维坐标中，则中心对称点就是（3,3）。
从（3,3）点出发，有四个方向可以走
1.横坐标不变，纵坐标加1
2.横坐标不变，纵坐标减1
3.纵坐标不变，横坐标加1
4.纵坐标不变，横坐标减1
以上的每一个操作，也就对应了代码中的dir数组,尝试每一种割出两个完全一方向，变化当前的坐标，并利用辅佐函数标记当前坐标已经被访问过。
同时将其关于（3,3）中心对称的点标记已经访问。（你要想分样的图形，分割线一定是中心对称的！！！）
一旦走到边界，计数器加一。
*/

public class A4_填空题_方格分割_DFS {
	private static int[][] ans = new int[7][7];//把方格看成带点 即7x7
	static int count = 0;
	static int [][]dir= {{0,1},{0,-1},{-1,0},{1,0}};//下 上 左 右
	
	public static void main(String[] args) {
		ans[3][3]=1;
		dfs(3,3);
		System.out.println(count/4);
	}
	
	private static void dfs(int i, int j) {
		//已经走到边界
		if(i==6 && i==0 && j==0 && j==6 ) {
			count++;
			return;
		}
		//中间过程
		for (int j2 = 0; j2 < 4; j2++) {//四个方向挨着dfs
			//下一步的方向
			int x=i +dir[j2][0];
			int y=j +dir[j2][1];
			if(ans[x][y]!=1) {//该点未被访问
				ans[x][y]=1;
				ans[6-x][6-y]=1;//标记对称点
				dfs(x,y);
				ans[x][y] = 0;
	            ans[6-x][6-y] = 0;//回溯
			}
		}

	}
}
