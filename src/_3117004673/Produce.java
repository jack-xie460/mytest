package _3117004673;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//控制台输入命令，生成题目和答案放在对应文档中
public class Produce 
{
	
	public static void start() throws IOException 
	{
		
		File exerciseFile = new File("E:\\java\\结对作业\\src\\jieduitest01\\Exercises.txt");
		File answerFile = new File("E:\\java\\结对作业\\src\\jieduitest01\\Answer.txt");
		FileWriter writeToExercisefile =new FileWriter(exerciseFile);
		FileWriter writeToAnswerfile =new FileWriter(answerFile);
		
		System.out.println("请输入您想要生成的题目数量：（例如生成10道题目的格式：-n 10）");
		while(!AmountOfExp.method()) {}
		int amount = AmountOfExp.getAmount();
		
		System.out.println("请输入您想要生成的题目中数值的范围：（例如数值在10以内格式：-r 10）");
		while (!BoundOfNum.method()) {}
		int bound = BoundOfNum.getBound();
		
		String expression;
		//可变数组存储后缀表达式用以查重
		StringBuilder expressionSet = new StringBuilder();
		//循环打印题目和答案
		long startTime = System.currentTimeMillis();
		for(int i=0;i<amount;i++) 
		{
			expression =Expression.expression(bound);
			Calculate cal = new Calculate(expression);
			String houzhuiExp = cal.houzhuiexp();
			
			//产生的后缀表达式与之前的重复，即产生相同的题目
			if(expression.indexOf(houzhuiExp)!=-1) 
			{
				i--;
				continue;
			}
			
			expressionSet.append(houzhuiExp);
			String result = cal.calculate();
			
			//计算过程产生负数
			if(result.equals("?")) 
			{
				i--;
				continue;
			}
			
			writeToExercisefile.write(i+1 +" 、" + expression + "="+"\n");
			writeToAnswerfile.write(i+1 +"、" + result + "\n" );
			
		}	
		writeToExercisefile.close();
		writeToAnswerfile.close();
		long endTime = System.currentTimeMillis();
		System.out.println("生成题目和答案总耗时：" + (endTime - startTime)+"ms");
	}

	
}	
		
		
		
	
	

