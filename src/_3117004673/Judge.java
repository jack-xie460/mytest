package _3117004673;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ����ָ���Ŀ�ļ��ļ���������ļ��Ĵ𰸱Ƚ�
 * ����ȷ�ļ��������Ŀ��������Ŵ�ӡ��Grade.txt�ļ���
 */
public class Judge 
{

	public static void start() throws IOException 
	{
		System.out.println("���������Ĳ���ָ�������д𰸵ĶԴ�ͳ�ƣ�����ʽ��-e <exercisefile>.txt -a <answerfile>.txt��");
		while(!ExtractPath.method()) {}
		String exeFilePath = ExtractPath.getExeFilePath();
		String answerFilePath = ExtractPath.getAnswerFilePath();
		BufferedReader exe = new BufferedReader(new FileReader(exeFilePath));
		BufferedReader answer = new BufferedReader(new FileReader(answerFilePath));
		File grade = new File("E:\\java\\�����ҵ\\src\\jieduitest01\\Grade.txt");
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
			String[] exestrs = exep.split("��");
			String[] anstrs = anstr.split("��");
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
		System.out.println("ͳ�ƶԴ��ʱ��" + (endTime - startTime)+"ms");
	}
}
