package _3117004673;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * �ж�����ָ���Ƿ���ȷ��������ȷָ������ȡĿ���ļ�λ��
 * ��Ŀ�ļ�λ�ÿ���getExeFilePath�������
 * ���ļ�λ�ÿ���getAnswerFilePath�������
 */
 public class ExtractPath {
	
	private static String exeFilePath;
	private static String answerFilePath;
	
	public static String getExeFilePath() 
	{
		return exeFilePath;
	}

	public static String getAnswerFilePath() 
	{
		return answerFilePath;
	}
    
	public static boolean method() 
	{

		Pattern p = Pattern.compile("(-)(e)(\\s+)(\\S+)(\\.)(txt)(\\s+)(-)(a)(\\s+)(\\S+)(\\.)(txt)");
	    Scanner scan = new Scanner(System.in);
	    String str = scan.nextLine();
	    Matcher m = p.matcher(str);
	    boolean bo = m.matches();
	    String[] sarr;
	    if(!bo) 
	    {
	    	System.out.println("������ĸ�ʽ���Ϸ����밴�ո�ʽ�������룬��ʽ��-e <exercisefile>.txt -a <answerfile>.txt��");
	    }else 
	    {
	    	sarr = str.split("\\s+");
	    	exeFilePath = sarr[1];
	    	answerFilePath = sarr[3];
	    	File src1 = new File(exeFilePath);
	    	File src2 = new File(answerFilePath);
	    	if(!(src1.exists()&&src2.exists())) 
	    	{
	    		System.out.println("��������ļ������Ҳ�����������������������");
	    		bo = false;
	    	}
	    }
	    return bo;
	}
	
}
