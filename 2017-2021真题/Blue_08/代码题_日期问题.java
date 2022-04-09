package Blue_08;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 代码题_日期问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("/");
        sc.close();
        String st1,st2,st3;
        st1 = change(s[0])+"-"+s[1]+"-"+s[2];
        st3 = change(s[2])+"-"+s[0]+"-"+s[1];
        st2 = change(s[2])+"-"+s[1]+"-"+s[0];
        LocalDate sDate1,sDate2,sDate3;
        //LocalDate是一个不可变的日期时间对象，表示日期，通常被视为年-月-日。也可以访问其他日期字段
        ArrayList<LocalDate> mn = new ArrayList<>();
        //ArrayList 是一个数组队列，提供了相关的添加、删除、修改、遍历等功能 https://www.runoob.com/java/java-arraylist.html
        //LocalDate: 泛型数据类型，用于设置 objectName 的数据类型，只能为引用数据类型。
        //objectName: 对象名 mn
        if(isvalid(st1)){
            sDate1 = LocalDate.parse(st1);
            mn.add(sDate1);
        }
        if(isvalid(st2)&&!st2.equals(st1)){
            sDate2 = LocalDate.parse(st2);
            mn.add(sDate2);
        }
        if(isvalid(st3)&&!st3.equals(st2)&&!st3.equals(st1)){
            sDate3 = LocalDate.parse(st3);
            mn.add(sDate3);
        }
        for(int i=0;i<mn.size();i++){
            for(int j=i;j<mn.size();j++){
                if(mn.get(i).isAfter(mn.get(j))){
                    LocalDate t = mn.get(i);
                    mn.set(i, mn.get(j));
                    mn.set(j, t);
                }
            }
        }
        for(int i=0;i<mn.size();i++){
            System.out.println(mn.get(i));
        }
        
    }
    public static String change(String s){
        int m = Integer.parseInt(s); //Integer.parseInt String 转 int
        StringBuffer t = new StringBuffer(s).reverse();
        if(m<=59){
            t.append("02");
        }else{
            t.append("91");
        }
        return t.reverse().toString();
    }

    public static Boolean isvalid(String s){
        try{
            LocalDate.parse(s);
        }catch(Exception e){
            return false;
        }
        return true;
    }

}