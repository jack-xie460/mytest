package _3117004673;
//��ȡ���ӷ�ĸ
public class SplitFra {

	private int numberater;	
	private int deno;
	
	public int getNumberater() 
	{
		return numberater;
	}
	public int getDeno() 
	{
		return deno;
	}	
	
	public SplitFra(String str) 
	{
		String[] str1 = str.split("/");
		this.numberater = Integer.parseInt(str1[0]);
		this.deno = Integer.parseInt(str1[1]);
	}
}
