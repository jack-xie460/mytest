package _3117004673;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//ʹ�� -n ��������������Ŀ�ĸ���
public class AmountOfExp
{
	
	private static int amount;
	
	public static int getAmount() 
	{
		return amount;
	}
    
	//�ж�����ָ�������ȷ����ָ������ȡ������Ŀ������
	public static boolean method()
	{
		
		Pattern p = Pattern.compile("(-)(n)(\\s+)(\\d{1,})");
	    Scanner scan = new Scanner(System.in);
	    String str = scan.nextLine();
	    Matcher m = p.matcher(str);
	    boolean bo = m.matches();
	    String[] sarr ;
	    if(!bo) 
	    	System.out.println("������ĸ�ʽ���Ϸ����밴�ո�ʽ�������룬���磺-n 10");
	    else 
	    { 
	    	sarr = str.split("\\s+");
	    	amount = Integer.parseInt(sarr[1]);
	    }
	    return bo;
	}

}
