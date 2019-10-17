package _3117004673;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//使用 -n 参数控制生成题目的个数
public class AmountOfExp
{
	
	private static int amount;
	
	public static int getAmount() 
	{
		return amount;
	}
    
	//判断输入指令，并从正确输入指令中提取生成题目的数量
	public static boolean method()
	{
		
		Pattern p = Pattern.compile("(-)(n)(\\s+)(\\d{1,})");
	    Scanner scan = new Scanner(System.in);
	    String str = scan.nextLine();
	    Matcher m = p.matcher(str);
	    boolean bo = m.matches();
	    String[] sarr ;
	    if(!bo) 
	    	System.out.println("您输入的格式不合法，请按照格式重新输入，例如：-n 10");
	    else 
	    { 
	    	sarr = str.split("\\s+");
	    	amount = Integer.parseInt(sarr[1]);
	    }
	    return bo;
	}

}
