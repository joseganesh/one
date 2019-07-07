package jewelleryUtil;

public class ConvertInttoString 
{

	static String[] ones ={"", " One", " Two", " Three", " Four", " Five",
		       " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
		       " Thirteen", " Fourteen", " Fifteen",  " Sixteen", " Seventeen", 
		       " Eighteen", " Nineteen"};
	 static String[] tens =  {"", "Ten", " Twenty", " Thirty", " Forty", " Fifty",
		       " Sixty", " Seventy", " Eighty"," Ninety"};
	 static String[] digit = {"", " Hundred", " Thousand", " Lakh", " Crore"};
	 
	  static String findStr()
	  {
		  String num = "1234";
	        String[] arr = new String[num.length()];
	        int k=0;
	        for(int i =num.length()-1 ; i > -1;i-- ){
	           // arr[k] =num.substring(i, i+1);
	            arr[k] =num.charAt(i);
	            //System.out.println(num.substring(i, i+1));
	            k++;
	        }
		return null;
		  
	  }
	 
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
