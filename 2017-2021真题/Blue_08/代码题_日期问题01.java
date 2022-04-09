package Blue_08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * 02/03/04
2002-03-04
2004-02-03
2004-03-02
 * */
public class 代码题_日期问题01 {
    //注意日要大于1，月也要大于1，注意取值范围
    static int[] mons = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
    static List<String> res = new ArrayList<String>();
    public static void main(String[] args) {
        
        //有采用年/月/日的，有采用月/日/年的，还有采用日/月/年的。 
        //1960 年 1 月 1 日至 2059 年 12 月 31 日
        //多个日期按从早到晚排列。
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.next().split("/");
        scanner.close();
        String a = s[0];
        String b = s[1];
        String c = s[2]; 
        //年/月/日的
        //判断年月日
        D(a,b,c); 
        //月/日/年的
        //如果是年月日的格式，看符不符合条件，以月开头看第一个符不符合，如果月是大于12的，说明
        //不符合，因为没有月份大于12的
        D(c,a,b);
        //日/月/年的。
        D(c,b,a);
        Collections.sort(res); //排序
        for(String str:res) {//遍历输出
            System.out.println(str);
        } 
    }
    
    public static void D(String year,String mon,String day) {
        
        StringBuilder str = new StringBuilder();
        
        if(Integer.valueOf(year)<60) {
            year = 20+year;
            str.append(year);

        }else {
            year = 19+year;
            str.append(year);
        }
        str.append("-"); 
        if(Integer.valueOf(year)%4==0 && Integer.valueOf(year)%100!=0 || Integer.valueOf(year)%400==0) {
            //闰年
            mons[1] = 29;  
        }else {
            mons[1] = 28;
        }
        if(Integer.valueOf(mon)>12)
        	return;
        str.append(mon);
        str.append("-");
        
        int m = Integer.valueOf(mon);
        
        if(m<=0)return;
        
        if(Integer.valueOf(day)>mons[m-1])return;
        
        if(Integer.valueOf(day)<1)return;
        
        str.append(day);
        
    if(!res.contains(str.toString()))
        res.add(str.toString());
    }
}
