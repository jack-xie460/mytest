package _3117004673;

import java.util.Random;

//���ַ������ݷ���������������������κͷ����ĸ��ʱ�Ϊ8��2
public class RandomNum 
{

	public static String nextNumber(int bound) 
	{
		
		Random ran = new Random();
		int i,j,allot;
		//����������β�������Ҳ�п��ܱ��������ӣ��������ǲ�����Ϊ������
		i = 1+ran.nextInt(bound-1);
		String intNum = i+"";
		allot = ran.nextInt(10);
		if(allot<8) 
			return intNum;
		else
		{
		    //��ĸ
			j = 1 + ran.nextInt(bound-1);
			//���������
			if(i<j) 
			{
				 String fraction = "("+i+"/"+j+")";
			     return fraction;
			}
			    return nextNumber(bound);
		}
	}
}
