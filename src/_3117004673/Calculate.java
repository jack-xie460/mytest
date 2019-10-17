package _3117004673;

import java.util.HashMap;
import java.util.Stack;

//�������ɵı��ʽ��������
public class Calculate 
{
	//��HashMap�洢������������ȼ�
	 HashMap<String,Integer> opls;
	 String str0;
	 
	 //���캯��������ʼ����������������ȼ�
	 public Calculate(String str0) 
	 {
		 this.str0 = str0;
		 if(opls==null) 
		 {
			 opls = new HashMap<String,Integer>(4);
	            opls.put("+",0);
	            opls.put("-",0);
	            opls.put("��",1);
	            opls.put("��",1);
		 }
	 }

	//����׺���ʽת���ɺ�׺���ʽ
	public String houzhuiexp() 
	{
		//��ȥ�ո��
		String str = str0.replace(" ","");
		//����׺���ʽ�ָ��������
		String[] strArray = split(str);
		//��׺���ʽ�洢ջ
		Stack<String> houzhuiSta = new Stack<String>();
		//��ʱջ
		Stack<String> temStack = new Stack<String>();
		
		for(String src:strArray) 
		{
			//��������ֱ��ѹ���׺���ʽ��ջ
			if(isNum(src))
				houzhuiSta.push("("+src+")");
			else //��������������
			{   
				if(temStack.isEmpty()||src.equals("("))
				{   //"("����ʱջΪ��  
					temStack.push(src);
				}
				else 
				{   
					if(isLow(temStack.peek(),src))
					{
						if(!src.equals(")"))
						{   ////���ȼ�����ʱջջ��ֵ�ĵ�
							while((!temStack.isEmpty())&&(isLow(temStack.peek(),src))) 
							{
								houzhuiSta.push(temStack.pop());
							}
							temStack.push(src);
						}else//Ϊ")" 
						{   //��ʱջջ�׵�ֵ��Ϊ"("
							while((!temStack.isEmpty())&&!(temStack.peek().equals("("))) 
							{
								houzhuiSta.push(temStack.pop());
							}
							//��ʱջջ�׵�ֵΪ"("
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
		//����ʱջ��ʣ��ֵѹ���׺ջ
		while(!temStack.empty())
		{	
			houzhuiSta.push(temStack.pop());
		}
		//����׺ջ�еĺ�׺���ʽת��Ϊ�ַ�������
		StringBuilder sb1 = new StringBuilder();
		for(String str1:houzhuiSta) 
		{
			sb1.append(str1);
		}
		houzhuiSta.clear();
		return sb1.toString();
		
	}
	
	//�ָ���ʽ
	public String[] split(String str) 
	{
		
		StringBuilder sb = new StringBuilder(str.length()*2);
		for(char ch:str.toCharArray()) 
		{
			
			if(ch=='+'||ch=='-'||ch=='��'||ch=='��'||ch=='('||ch==')') 
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
	
	//�ָ��׺���ʽ
	public String[] splitHou(String str) 
	{
		
		StringBuilder sb = new StringBuilder(str.length());
		int i = 0;
		for(char ch:str.toCharArray()) 
		{
			if(ch=='+'||ch=='-'||ch=='��'||ch=='��') 
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
	
	//�������
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
	
	//շת����������Լ��
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
	
	//�ж��Ƿ��ǲ�����
	 public boolean isNum(String str) 
	 {
	        for (char ch : str.toCharArray()) 
	        {
	            if(ch=='+'||ch=='-'||ch=='��'||ch=='��'||ch=='('||ch==')')
	                return false;
	        }
	        return true;
	 }
	 
	 //�Ƚ����ȼ�
	 public boolean isLow(String pop, String str) 
	 {
	        if(str.equals(")"))
	            return true;
	        if(opls.get(pop)==null||opls.get(str)==null)
	          return false;
	        return opls.get(pop)>=opls.get(str);
	 }   
	 
	 //���õݹ鷽�����ú�׺���ʽ������
	 public String calculate() 
	 {   
		 //��׺���ʽ
		 String houhzhuiExp = houzhuiexp();
		 String[] strs = splitHou(houzhuiexp());
		 //���õݹ�õ����
		 String exResult = recursion(strs);
		 //������̲�����������"?"
		 if(exResult.equals("?"))
		 {
			 return "?";
		 }
		 String result ;
		 //����Ƿ���������
		 if(exResult.contains("/")) 
		 {
			result = simplify(exResult);
		 }else 
		 {
			 result = exResult;
		 }	 
		 return result;
	 }
	 //�ݹ鷽��
	 public String recursion(String[] str) 
	 {   
		//��������Ƿ���ָ����ı�� 
		 boolean flag = false;
		 int nowlength = str.length;
		 if(str[str.length-1]==" ")
		 {	 
			 nowlength = str.length-1;
		 }else if(str.length == 1) //��׺���ʽ����Ϊ1��ݹ�������ؽ��
		 {
			 return str[0];
		 }
		 String[] nextstr = new String[nowlength-2];
		 for(int i = 2;i<nowlength;i++) 
		 {
			
			 if(str[i].equals("+")||str[i].equals("-")||str[i].equals("��")||str[i].equals("��")) 
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
					  //�и�������
					  if(result.equals("?")) 
					  {
						  flag = true;
					  }
					  break;
				  case "��":
					  result = Math.mul(num1,num2);
					  break;
				  case "��":
					  result = Math.div(num1,num2);
					  break;
				  default :
					  result = null;
				  }
				  //��׺���ʽÿ����һ�Σ��͹����µĺ�׺���ʽ
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
