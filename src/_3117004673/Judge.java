package _3117004673;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 输入指令将题目文件的计算结果与答案文件的答案比较
 * 将正确的及错误的题目数量和题号打印到Grade.txt文件中
 */
public class Judge 
{

	public static void start() throws IOException 
	{
		System.out.println("请输入您的操作指令来进行答案的对错统计：（格式：-e <exercisefile>.txt -a <answerfile>.txt）");
		while(!ExtractPath.method()) {}
		String exeFilePath = ExtractPath.getExeFilePath();
		String answerFilePath = ExtractPath.getAnswerFilePath();
		BufferedReader exe = new BufferedReader(new FileReader(exeFilePath));
		BufferedReader answer = new BufferedReader(new FileReader(answerFilePath));
		File grade = new File("E:\\java\\结对作业\\src\\jieduitest01\\Grade.txt");
		FileWriter writeToGrade = new FileWriter(grade);
		
		long startTime = System.currentTimeMillis();
		String exep = "";
		StringBuilder corretNum = new StringBuilder();
		StringBuilder wrongNum = new StringBuilder();
		int corret = 0;
		int wrong = 0;
	    int num = 1;
		while((exep = exe.readLine())!=null) 
		{
			String anstr = answer.readLine();
			String[] exestrs = exep.split("、");
			String[] anstrs = anstr.split("、");
			String str = exestrs[1].replaceAll("=", "");
			Calculate cal = new Calculate(str);
			String result = cal.calculate();
			String answerstr = anstrs[1];
			if(result.equals(answerstr)) 
			{
				corret++;
				corretNum.append(num + ",");
			}else 
			{
				wrong++;
				wrongNum.append(num + ",");
			}
			num++;
			
		}
		writeToGrade.write("Corret:  "+corret+"("+corretNum.toString()+")"+"\n");
		writeToGrade.write("Wrong:  "+wrong+"("+wrongNum.toString()+")");
		writeToGrade.close();
		exe.close();
		answer.close();
		long endTime = System.currentTimeMillis();
		System.out.println("统计对错耗时：" + (endTime - startTime)+"ms");
	}
}
