package _3117004673;

//四则运算工具类
public class Math {

	//加法
	static String add(String num1,String num2)
    {
    	 String addResult;
    	 if(!num1.contains("/")) 
    	 {
    		 if(!num2.contains("/"))
    		 {
    			 int i = Integer.parseInt(num1);
    	         	 int j = Integer.parseInt(num2);
    	         	 addResult = i + j +"";
    		 }else 
    		 {
    			 int i = Integer.parseInt(num1);
    			 SplitFra sp =new SplitFra(num2);
    			 int numerater2 = sp.getNumberater();
    			 int deno2 = sp.getDeno();
    			 addResult = i*deno2 +numerater2 +"/" +deno2;
    		 }
    	 }else
    	 {
    		 if(!num2.contains("/")) 
    		 {
    			 int i = Integer.parseInt(num2);
    			 SplitFra sp =new SplitFra(num1);
    			 int numerater1 = sp.getNumberater();
    			 int deno1 = sp.getDeno();
    			 addResult = i*deno1 + numerater1 +"/" +deno1;
    		 }else 
    		 {
    			 SplitFra sp =new SplitFra(num1);
    			 SplitFra sp2 =new SplitFra(num2);
    			 int numerater1 = sp.getNumberater();
    			 int deno1 = sp.getDeno();
    			 int numerater2 = sp2.getNumberater();
    			 int deno2 = sp2.getDeno();
    			 addResult = numerater1*deno2 + numerater2*deno1 +"/"+(deno1*deno2);
    		 }
    	 }
    	return addResult;
     }
		 
		 //减法
		 static String sub(String num1,String num2) 
		 {
			 String subResult;
			 if(!num1.contains("/")) 
			 {
				 if(!num2.contains("/"))
				 {
					 int i = Integer.parseInt(num1);
	             	 int j = Integer.parseInt(num2);
	             	 subResult = i - j +"";
				 }else 
				 {
					 int i = Integer.parseInt(num1);
					 SplitFra sp =new SplitFra(num2);
					 int numerater2 = sp.getNumberater();
					 int deno2 = sp.getDeno();
					 subResult = i*deno2 - numerater2 +"/" +deno2;
				 }
			 }else
			 {
				 if(!num2.contains("/")) 
				 {
					 int i = Integer.parseInt(num2);
					 SplitFra sp =new SplitFra(num1);
					 int numerater1 = sp.getNumberater();
					 int deno1 = sp.getDeno();
					 subResult = numerater1 - i*deno1 +"/" +deno1;
				 }else 
				 {
					 SplitFra sp =new SplitFra(num1);
					 SplitFra sp2 =new SplitFra(num2);
					 int numerater1 = sp.getNumberater();
					 int deno1 = sp.getDeno();
					 int numerater2 = sp2.getNumberater();
					 int deno2 = sp2.getDeno();
					 subResult = numerater1*deno2 - numerater2*deno1 +"/"+(deno1*deno2);
				 }
			 }
			 if(subResult.contains("-")) 
			 {
				 return "?";//产生负数的标记
			 }
			 return subResult;
		 }
		 
		 //乘法
		 static String mul(String num1,String num2) 
		 {
			 String mulResult;
			 if(!num1.contains("/")) 
			 {
				 if(!num2.contains("/"))
				 {
					 int i = Integer.parseInt(num1);
	             	 int j = Integer.parseInt(num2);
	             	 mulResult = i * j +"";
				 }else 
				 {
					 int i = Integer.parseInt(num1);
					 SplitFra sp =new SplitFra(num2);
					 int numerater2 = sp.getNumberater();
					 int deno2 = sp.getDeno();
					 mulResult = i*numerater2 +"/" +deno2;
				 }
			 }else
			 {
				 if(!num2.contains("/")) 
				 {
					 int i = Integer.parseInt(num2);
					 SplitFra sp =new SplitFra(num1);
					 int numerater1 = sp.getNumberater();
					 int deno1 = sp.getDeno();
					 mulResult =numerater1 * i +"/" +deno1; 
				 }else 
				 {
					 SplitFra sp =new SplitFra(num1);
					 SplitFra sp2 =new SplitFra(num2);
					 int numerater1 = sp.getNumberater();
					 int deno1 = sp.getDeno();
					 int numerater2 = sp2.getNumberater();
					 int deno2 = sp2.getDeno();
					 mulResult = numerater1 * numerater2 +"/"+(deno1*deno2);
				 }
			 }
			return mulResult;
		 }
		 //除法
		 static String div(String num1,String num2) 
		 {
			 String divResult;
			 if(!num1.contains("/")) 
			 {
				 if(!num2.contains("/"))
				 {
					 int i = Integer.parseInt(num1);
	             	 int j = Integer.parseInt(num2);
	             	 divResult = i +"/" + j;
				 }else 
				 {
					 int i = Integer.parseInt(num1);
					 SplitFra sp =new SplitFra(num2);
					 int numerater2 = sp.getNumberater();
					 int deno2 = sp.getDeno();
					 divResult = i*deno2 +"/" +numerater2;
				 }
			 }else
			 {
				 if(!num2.contains("/")) 
				 {
					 int i = Integer.parseInt(num2);
					 SplitFra sp =new SplitFra(num1);
					 int numerater1 = sp.getNumberater();
					 int deno1 = sp.getDeno();
					 divResult =numerater1 + "/" + (deno1 *i); 
				 }else 
				 {
					 SplitFra sp =new SplitFra(num1);
					 SplitFra sp2 =new SplitFra(num2);
					 int numerater1 = sp.getNumberater();
					 int deno1 = sp.getDeno();
					 int numerater2 = sp2.getNumberater();
					 int deno2 = sp2.getDeno();
					 divResult = numerater1 * deno2 +"/"+(deno1*numerater2);
				 }
			 }
			return divResult;
		 }
	
}
