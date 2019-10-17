package _3117004673;

import java.util.Random;

//以字符串数据返回整数或真分数，整数形和分数的概率比为8：2
public class RandomNum 
{

	public static String nextNumber(int bound) 
	{
		
		Random ran = new Random();
		int i,j,allot;
		//随机生成整形操作数（也有可能被用作分子），不考虑操作数为零的情况
		i = 1+ran.nextInt(bound-1);
		String intNum = i+"";
		allot = ran.nextInt(10);
		if(allot<8) 
			return intNum;
		else
		{
		    //分母
			j = 1 + ran.nextInt(bound-1);
			//生成真分数
			if(i<j) 
			{
				 String fraction = "("+i+"/"+j+")";
			     return fraction;
			}
			    return nextNumber(bound);
		}
	}
}
