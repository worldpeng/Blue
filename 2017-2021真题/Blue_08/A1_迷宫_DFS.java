package Blue_08;
// https://www.lanqiao.cn/problems/641/learning/
public class A1_迷宫_DFS {
	static int count = 0;
	public static void main(String[] args) {
		char[][] map=new char[10][10];
		String temp[] = { "UDDLUULRUL", "UURLLLRRRU", "RRUURLDLRD", "RUDDDDUUUU", "URUDLLRRUU", "DURLRLDLRL",
                "ULLURLLRDU", "RDLULLRDDD", "UUDDUDUDLL", "ULRDLUURRR" };
		for (int i = 0; i < 10; i++) {
            map[i] = temp[i].toCharArray();
            System.out.println(map[i]);
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                dfs(i, j, map, map[i][j]);
            }
        }
        System.out.println(count);
        }
	 private static void dfs(int i, int j, char[][] map, char last) {
		 //深度出来8
		 if (i < 0 || i > 9 || j < 0 || j > 9) {
	            count++;
	            return;
	        }
	        if (map[i][j] == 'U') {
	            if (last == 'D') {
	                return;
	            }
	            dfs(i - 1, j, map, 'U');
	        }
	        if (map[i][j] == 'D') {
	            if (last == 'U') {
	                return;
	            }
	            dfs(i + 1, j, map, 'D');
	        }
	        if (map[i][j] == 'L') {
	            if (last == 'R') {
	                return;
	            }
	            dfs(i, j - 1, map, 'L');
	        }
	        if (map[i][j] == 'R') {
	            if (last == 'L') {
	                return;
	            }
	            dfs(i, j + 1, map, 'R');
	        }
	    }
	 
}

