package _3117004673;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ʹ�� -r ����������Ŀ����ֵ��Χ
public class BoundOfNum 
{

	private static int bound;
	
	public static int getBound()
	{
		return bound;
	}
    
	//�ж�����ָ���������ָ������ȡ��Ŀ����ֵ�ķ�Χ
	public static boolean method()
	{
		
		Pattern p = Pattern.compile("-r\\s+\\d+");
	    Scanner scan = new Scanner(System.in);
	    String str = scan.nextLine();
	    String[] sarr ;
	    Matcher m = p.matcher(str);
	    boolean bo = m.matches();
	    if(!bo) 
	    	System.out.println("������ĸ�ʽ���Ϸ����밴�ո�ʽ�������룬���磺-r 10");
	    else 
	    { 
	    	sarr = str.split("\\s+");
	    	bound = Integer.parseInt(sarr[1]);
	    }	
	    return bo;
	}
	
}
