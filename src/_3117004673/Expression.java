package _3117004673;

import java.util.Random;

//生成表达式
public class Expression 
{
	
	static Random ran=new Random();
	
	public static String expression(int bound) 
	{
		
		String ziexp1 = null,ziexp2 = null;
		
		//概率结合不同的子表达式
		int i = ran.nextInt(4);
		switch(i) 
		{
		
		case 0:
			ziexp1 = RandomNum.nextNumber(bound);
			ziexp2 = RandomNum.nextNumber(bound);
            break;
		case 1:
			ziexp1 = RandomNum.nextNumber(bound);
			ziexp2 = SubExpression.ziepression(bound);
			break;
		case 2:
			ziexp1 = SubExpression.ziepression(bound);
			ziexp2 = RandomNum.nextNumber(bound);
			break;
		case 3:
			ziexp1 = SubExpression.ziepression(bound);
			ziexp2 = SubExpression.ziepression(bound);
			break;
		default :
		}
		
		String operater = operater();
		String exp = ziexp1 +" "+operater+" "+ ziexp2;
		return exp;
	}

	
	public static String operater()
	{
	
		int opnum = ran.nextInt(4);
		switch(opnum)
		{
		
		case 0:
			return "+";
		case 1:
			return "-";
		case 2:
		    return "×";
		case 3:
			return "÷";
		}
		return null;
	}	
	
}
