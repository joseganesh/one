package jewelleryUtil;

public class ConverterInt 
{
	
	 static String[] unitdo ={"", " One", " Two", " Three", " Four", " Five",
		       " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
		       " Thirteen", " Fourteen", " Fifteen",  " Sixteen", " Seventeen", 
		       " Eighteen", " Nineteen"};
		    static String[] tens =  {"", "Ten", " Twenty", " Thirty", " Forty", " Fifty",
		       " Sixty", " Seventy", " Eighty"," Ninety"};
		    static String[] digit = {"", " Hundred", " Thousand", " Lakh", " Crore"};
		    //method
		    static String findStr(String a, String b){
		        String str ="";
		        int n =Integer.parseInt(a+b);
		        System.out.println(n);
		        
		        if(n <20)
		            str = unitdo[n];
		        else if(n%10 ==0)
		            str = tens[n/10];
		        else{
		            str  = tens[n/10]+unitdo[n%10];
		        }
		              
		        
		        return str;
		        
		    }
		    
		    public static void main(String[] arg){
		        String num = "1234";
		        String[] arr = new String[num.length()];
		        int k=0;
		        for(int i =num.length()-1 ; i > -1;i-- ){
		            arr[k] =num.substring(i, i+1);
		            System.out.println(num.substring(i, i+1));
		            k++;
		        }
		        
		        k =0;
		        String ans ="";
		        while(k < num.length()){
		            
		            if(k ==0){
		            String a =arr[k];
		            k++;
		            String b =arr[k];
		            ans= findStr(b,a)+ans;
		            k++;
		            }
		            if(k==2 && k < num.length()){
		                String a =arr[k];
		                int n =Integer.parseInt(a+"");
		                ans= unitdo[n] +" Hundred "+ans;
		                k++;
		            }
		            if(k==3 && k < num.length()){
		                String a =arr[k];
		                k++;
		                
		                String b ="";
		                        if(k < num.length())
		                        b =arr[k];
		                ans= findStr(b,a)+" Thousand "+ans;
		                k++;
		            }
		            if(k==5 && k < num.length()){
		                String a =arr[k];
		                k++;
		                
		                String b ="";
		                        if(k < num.length())
		                        b =arr[k];
		                ans= findStr(b,a)+" Lacks "+ans;
		                k++;
		            }
		        }
		        System.out.println(ans);
		        
		    }
		    

}
