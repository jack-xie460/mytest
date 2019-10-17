package _3117004673;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//使用 -r 参数控制题目中数值范围
public class BoundOfNum 
{

	private static int bound;
	
	public static int getBound()
	{
		return bound;
	}
    
	//判断输入指令，并从输入指令中提取题目中数值的范围
	public static boolean method()
	{
		
		Pattern p = Pattern.compile("-r\\s+\\d+");
	    Scanner scan = new Scanner(System.in);
	    String str = scan.nextLine();
	    String[] sarr ;
	    Matcher m = p.matcher(str);
	    boolean bo = m.matches();
	    if(!bo) 
	    	System.out.println("您输入的格式不合法，请按照格式重新输入，例如：-r 10");
	    else 
	    { 
	    	sarr = str.split("\\s+");
	    	bound = Integer.parseInt(sarr[1]);
	    }	
	    return bo;
	}
	
}
