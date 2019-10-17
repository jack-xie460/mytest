package _3117004673;

import java.util.HashMap;
import java.util.Stack;

//传入生成的表达式计算出结果
public class Calculate 
{
	//用HashMap存储运算符及其优先级
	 HashMap<String,Integer> opls;
	 String str0;
	 
	 //构造函数，并初始化各个运算符的优先级
	 public Calculate(String str0) 
	 {
		 this.str0 = str0;
		 if(opls==null) 
		 {
			 opls = new HashMap<String,Integer>(4);
	            opls.put("+",0);
	            opls.put("-",0);
	            opls.put("×",1);
	            opls.put("÷",1);
		 }
	 }

	//将中缀表达式转化成后缀表达式
	public String houzhuiexp() 
	{
		//出去空格符
		String str = str0.replace(" ","");
		//将中缀表达式分割放入数组
		String[] strArray = split(str);
		//后缀表达式存储栈
		Stack<String> houzhuiSta = new Stack<String>();
		//临时栈
		Stack<String> temStack = new Stack<String>();
		
		for(String src:strArray) 
		{
			//将操作数直接压入后缀表达式的栈
			if(isNum(src))
				houzhuiSta.push("("+src+")");
			else //操作数或者括号
			{   
				if(temStack.isEmpty()||src.equals("("))
				{   //"("或临时栈为空  
					temStack.push(src);
				}
				else 
				{   
					if(isLow(temStack.peek(),src))
					{
						if(!src.equals(")"))
						{   ////优先级比临时栈栈首值的低
							while((!temStack.isEmpty())&&(isLow(temStack.peek(),src))) 
							{
								houzhuiSta.push(temStack.pop());
							}
							temStack.push(src);
						}else//为")" 
						{   //临时栈栈首的值不为"("
							while((!temStack.isEmpty())&&!(temStack.peek().equals("("))) 
							{
								houzhuiSta.push(temStack.pop());
							}
							//临时栈栈首的值为"("
							if((!temStack.isEmpty())&&(temStack.peek().equals("(")))
							{	
								temStack.pop();
							}
						}
					}else 
					{
						temStack.push(src);
					}
				}		
			}
		}
		//将临时栈的剩余值压入后缀栈
		while(!temStack.empty())
		{	
			houzhuiSta.push(temStack.pop());
		}
		//将后缀栈中的后缀表达式转化为字符串返回
		StringBuilder sb1 = new StringBuilder();
		for(String str1:houzhuiSta) 
		{
			sb1.append(str1);
		}
		houzhuiSta.clear();
		return sb1.toString();
		
	}
	
	//分割表达式
	public String[] split(String str) 
	{
		
		StringBuilder sb = new StringBuilder(str.length()*2);
		for(char ch:str.toCharArray()) 
		{
			
			if(ch=='+'||ch=='-'||ch=='×'||ch=='÷'||ch=='('||ch==')') 
			{
				sb.append(",");
				sb.append(ch);
				sb.append(",");
			}
			else 
			{
				sb.append(ch);
			}
		}
		String src = sb.toString().replaceAll(",{2,}",",");
		return src.split(",");
		
	}
	
	//分割后缀表达式
	public String[] splitHou(String str) 
	{
		
		StringBuilder sb = new StringBuilder(str.length());
		int i = 0;
		for(char ch:str.toCharArray()) 
		{
			if(ch=='+'||ch=='-'||ch=='×'||ch=='÷') 
			{
				sb.append(",");
				sb.append(ch);
			}
			else if(ch=='('||ch==')') 
			{
				if(i>=1) 
				{
					sb.append(',');
				}
			}
			else
			{
				sb.append(ch);
				i++;
			}
		}
		String src = sb.toString().replaceAll(",{2,}",",");
		return src.split(",");
		
	}
	
	//化简分数
	String simplify(String exResult) 
	{
		SplitFra sp = new SplitFra(exResult);
		int numberater =sp.getNumberater();
		int deno =sp.getDeno();
		int comDiv = comDivisor(numberater,deno);
		
		if(comDiv == 0) 
		{
			return "0";
		}
		
		numberater /= comDiv;
		deno /= comDiv;
		int integer = numberater/deno;
		int fration = numberater%deno;
		if(integer == 0) 
		{
			return fration + "/" + deno;
		}else if (fration == 0)
		{
			return integer+"";
		}else
		{	
			return integer + "'" + fration + "/" +deno;
		}
	}
	
	//辗转相除法求最大公约数
	int comDivisor(int a,int b) 
	{   
		if(a == 0||b == 0)
		{
			return 0;
		}
		int c = 1;
		while(a % b != 0) 
		{
			c = a % b;
			a = b;
			b = c;
		}
		return b;
	}
	
	//判断是否是操作数
	 public boolean isNum(String str) 
	 {
	        for (char ch : str.toCharArray()) 
	        {
	            if(ch=='+'||ch=='-'||ch=='×'||ch=='÷'||ch=='('||ch==')')
	                return false;
	        }
	        return true;
	 }
	 
	 //比较优先级
	 public boolean isLow(String pop, String str) 
	 {
	        if(str.equals(")"))
	            return true;
	        if(opls.get(pop)==null||opls.get(str)==null)
	          return false;
	        return opls.get(pop)>=opls.get(str);
	 }   
	 
	 //调用递归方法利用后缀表达式计算结果
	 public String calculate() 
	 {   
		 //后缀表达式
		 String houhzhuiExp = houzhuiexp();
		 String[] strs = splitHou(houzhuiexp());
		 //调用递归得到结果
		 String exResult = recursion(strs);
		 //计算过程产生负数返回"?"
		 if(exResult.equals("?"))
		 {
			 return "?";
		 }
		 String result ;
		 //结果是分数，化简
		 if(exResult.contains("/")) 
		 {
			result = simplify(exResult);
		 }else 
		 {
			 result = exResult;
		 }	 
		 return result;
	 }
	 //递归方法
	 public String recursion(String[] str) 
	 {   
		//计算过程是否出现负数的标记 
		 boolean flag = false;
		 int nowlength = str.length;
		 if(str[str.length-1]==" ")
		 {	 
			 nowlength = str.length-1;
		 }else if(str.length == 1) //后缀表达式长度为1则递归结束返回结果
		 {
			 return str[0];
		 }
		 String[] nextstr = new String[nowlength-2];
		 for(int i = 2;i<nowlength;i++) 
		 {
			
			 if(str[i].equals("+")||str[i].equals("-")||str[i].equals("×")||str[i].equals("÷")) 
			 {
				  String num1 = str[i-2];
				  String num2 = str[i-1];
				  String operater = str[i];
				  String result;
				  switch(operater) 
				  {
				  case "+":
					  result = Math.add(num1,num2);
					  break;
				  case "-":
					  result = Math.sub(num1,num2);
					  //有负数产生
					  if(result.equals("?")) 
					  {
						  flag = true;
					  }
					  break;
				  case "×":
					  result = Math.mul(num1,num2);
					  break;
				  case "÷":
					  result = Math.div(num1,num2);
					  break;
				  default :
					  result = null;
				  }
				  //后缀表达式每计算一次，就构建新的后缀表达式
		          for(int i1=0;i1<nowlength-2;i1++) 
		          {
		         	  if(i1<i-2) 
		         	  {
		         		 nextstr[i1] = str[i1];
		         	  }else if(i1==i-2) 
		         	  {
		         		 nextstr[i1] = result;
		         	  }else 
		         	  {
		         		 nextstr[i1] = str[i1+2];
		         	  }
		          } 
		         break;
			 }
		 }
		 if(flag)
		 {
			return  "?";
		 }
		 return recursion(nextstr);
	 }
	 
}
