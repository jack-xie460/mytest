package _3117004673;

import java.util.Random;

//�����ӱ��ʽ
public class SubExpression {
	
	static Random ran=new Random();

	public static String ziepression(int bound) {
	
		String num1,num2,ziexp;
        num1= RandomNum.nextNumber(bound);//������1
        num2= RandomNum.nextNumber(bound);//������2
        String operater = operater();//�����
        //�ӱ��ʽ��������Ϊ��
        //������������Ϊ'-'ʱ
        if(!operater.equals("-"))
        	ziexp = num1 +" "+operater +" "+ num2;
        //�������Ϊ'-'ʱ
        else {
        	//������Ϊ����
        	if(num1.indexOf('/') == -1)
        	{
        		//����ҲΪ����
                if(num2.indexOf('/') == -1) 
                {    
                	int i = Integer.parseInt(num1);
                	int j = Integer.parseInt(num2);
                	if(i < j)
                		ziexp = ziepression(bound);
                }
                ziexp = num1 +" "+operater +" "+ num2;
        	}
        	else if(num2.indexOf('/') == -1)
        	    ziexp = ziepression(bound);
        	else {
        		String num11 = num1.replaceAll("[\\(\\)]","");
        		String num21 = num1.replaceAll("[\\(\\)]","");
        		String[] str1 = num11.split("/");
        		String[] str2 = num21.split("/");
        		double i = (double)Integer.parseInt(str1[0])/Integer.parseInt(str1[1]);
        		double j = (double)Integer.parseInt(str2[0])/Integer.parseInt(str2[1]);
        		if(i>j)
        			ziexp = num1 +" "+operater +" "+ num2;
        		else
        			ziexp = ziepression(bound);
        			
        	}
        }
        //������ɴ����Ż��߲������ŵ��ӱ��ʽ
        int i = ran.nextInt(3);
        if(i!=0)
        	return ziexp;
        else 
        	return "("+ziexp+")";
	}

	public static String operater(){
	
		int opnum = ran.nextInt(4);
		switch(opnum) {
		
		case 0:
			return "+";
		case 1:
			return "-";
		case 2:
		    return "��";
		case 3:
			return "��";
		}
		return null;
	}	
}
