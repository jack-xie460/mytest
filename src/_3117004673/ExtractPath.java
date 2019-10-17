package _3117004673;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 判断输入指令是否正确，并从正确指令中提取目标文件位置
 * 题目文件位置可由getExeFilePath方法获得
 * 答案文件位置可由getAnswerFilePath方法获得
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
	    	System.out.println("您输入的格式不合法，请按照格式重新输入，格式：-e <exercisefile>.txt -a <answerfile>.txt）");
	    }else 
	    {
	    	sarr = str.split("\\s+");
	    	exeFilePath = sarr[1];
	    	answerFilePath = sarr[3];
	    	File src1 = new File(exeFilePath);
	    	File src2 = new File(answerFilePath);
	    	if(!(src1.exists()&&src2.exists())) 
	    	{
	    		System.out.println("您输入的文件夹我找不到啊！！！还请重新输入");
	    		bo = false;
	    	}
	    }
	    return bo;
	}
	
}
