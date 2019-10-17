package _3117004673;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//����̨�������������Ŀ�ʹ𰸷��ڶ�Ӧ�ĵ���
public class Produce 
{
	
	public static void start() throws IOException 
	{
		
		File exerciseFile = new File("E:\\java\\�����ҵ\\src\\jieduitest01\\Exercises.txt");
		File answerFile = new File("E:\\java\\�����ҵ\\src\\jieduitest01\\Answer.txt");
		FileWriter writeToExercisefile =new FileWriter(exerciseFile);
		FileWriter writeToAnswerfile =new FileWriter(answerFile);
		
		System.out.println("����������Ҫ���ɵ���Ŀ����������������10����Ŀ�ĸ�ʽ��-n 10��");
		while(!AmountOfExp.method()) {}
		int amount = AmountOfExp.getAmount();
		
		System.out.println("����������Ҫ���ɵ���Ŀ����ֵ�ķ�Χ����������ֵ��10���ڸ�ʽ��-r 10��");
		while (!BoundOfNum.method()) {}
		int bound = BoundOfNum.getBound();
		
		String expression;
		//�ɱ�����洢��׺���ʽ���Բ���
		StringBuilder expressionSet = new StringBuilder();
		//ѭ����ӡ��Ŀ�ʹ�
		long startTime = System.currentTimeMillis();
		for(int i=0;i<amount;i++) 
		{
			expression =Expression.expression(bound);
			Calculate cal = new Calculate(expression);
			String houzhuiExp = cal.houzhuiexp();
			
			//�����ĺ�׺���ʽ��֮ǰ���ظ�����������ͬ����Ŀ
			if(expression.indexOf(houzhuiExp)!=-1) 
			{
				i--;
				continue;
			}
			
			expressionSet.append(houzhuiExp);
			String result = cal.calculate();
			
			//������̲�������
			if(result.equals("?")) 
			{
				i--;
				continue;
			}
			
			writeToExercisefile.write(i+1 +" ��" + expression + "="+"\n");
			writeToAnswerfile.write(i+1 +"��" + result + "\n" );
			
		}	
		writeToExercisefile.close();
		writeToAnswerfile.close();
		long endTime = System.currentTimeMillis();
		System.out.println("������Ŀ�ʹ��ܺ�ʱ��" + (endTime - startTime)+"ms");
	}

	
}	
		
		
		
	
	

