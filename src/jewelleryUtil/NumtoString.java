package jewelleryUtil;




public class NumtoString  {
	
	

	// code for converting Amount to word

//	public static final String[] tensNames = { "", " Ten", " Twenty",
//			" Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty",
//			" Ninety" };
//
//	public static final String[] numNames = { "", " One", " Two", " Three",
//			" Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
//			" Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen",
//			" Sixteen", " Seventeen", " Eighteen", " Nineteen" };
//
//	public static String convertLessThanOneThousand(int number) {
//		String soFar;
//
//		if (number % 100 < 20) {
//			soFar = numNames[number % 100];
//			number /= 100;
//		} else {
//			soFar = numNames[number % 10];
//			number /= 10;
//
//			soFar = tensNames[number % 10] + soFar;
//			number /= 10;
//		}
//		if (number == 0)
//			return soFar;
//		return numNames[number] + " Hundred" + soFar;
//	}
//
//	public static String convertAmountToWord(Double numberfrmuser) {
//
//		String str = Double.toString(numberfrmuser);
//		String[] temp;
//
//		String delimiter = "\\.";
//		/* given string will be split by the argument delimiter provided. */
//		temp = str.split(delimiter);
//		/* print substrings */
//		for (int i = 0; i < temp.length; i++) {
//			// System.out.println(temp[i]);
//		}
//		Long number = Long.parseLong(temp[0]);
//		Long number1 = Long.parseLong(temp[1]);
//		// 0 to 999 999 999 999
//
//		if (number == 0) {
//			return "Zero";
//		}
//
//		String snumber = Double.toString(number);
//
//		// pad with "0"
//		String mask = "000000000000";
//		DecimalFormat df = new DecimalFormat(mask);
//		snumber = df.format(number);
//
//		// XXXnnnnnnnnn
//		int billions = Integer.parseInt(snumber.substring(0, 3));
//		// nnnXXXnnnnnn
//		int millions = Integer.parseInt(snumber.substring(3, 6));
//		// nnnnnnXXXnnn
//		int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
//		// nnnnnnnnnXXX
//		int thousands = Integer.parseInt(snumber.substring(9, 12));
//
//		String tradBillions;
//		switch (billions) {
//		case 0:
//			tradBillions = "";
//			break;
//		case 1:
//			tradBillions = convertLessThanOneThousand(billions) + " Billion ";
//			break;
//		default:
//			tradBillions = convertLessThanOneThousand(billions) + " Billion ";
//		}
//		String result = tradBillions;
//
//		String tradMillions;
//		switch (millions) {
//		case 0:
//			tradMillions = "";
//			break;
//		case 1:
//			tradMillions = convertLessThanOneThousand(millions) + " Million ";
//			break;
//		default:
//			tradMillions = convertLessThanOneThousand(millions) + " Million ";
//		}
//		result = result + tradMillions;
//
//		String tradHundredThousands;
//		switch (hundredThousands) {
//		case 0:
//			tradHundredThousands = "";
//			break;
//		case 1:
//			tradHundredThousands = "One Thousand ";
//			break;
//		default:
//			tradHundredThousands = convertLessThanOneThousand(hundredThousands)
//					+ " Thousand ";
//		}
//		result = result + tradHundredThousands;
//
//		String tradThousand;
//		tradThousand = convertLessThanOneThousand(thousands);
//		result = result + tradThousand;
//
//		// remove extra spaces!
//		return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
//
//	}

	
	


    static String[] unitdo ={"", " One", " Two", " Three", " Four", " Five",
       " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
       " Thirteen", " Fourteen", " Fifteen",  " Sixteen", " Seventeen", 
       " Eighteen", " Nineteen"};
    static String[] tens =  {"", "Ten", " Twenty", " Thirty", " Forty", " Fifty",
       " Sixty", " Seventy", " Eighty"," Ninety"};
    static String[] digit = {"", " Hundred", " Thousand", " Lakh", " Crore"};
   static int r;


    static //Count the number of digits in the input number
    int numberCount(int num)
    {
        int cnt=0;

        while (num>0)
        {
          r = num%10;
          cnt++;
          num = num / 10;
        }

          return cnt;
    }


    static //Function for Conversion of two digit

    String twonum(int numq)
    {
         int numr, nq;
         String ltr="";

         nq = numq / 10;
         numr = numq % 10;

         if (numq>19)
           {
         ltr=ltr+tens[nq]+unitdo[numr];
           }
         else
           {
         ltr = ltr+unitdo[numq];
           }

         return ltr;
    }

    static //Function for Conversion of three digit

    String threenum(int numq)
    {
           int numr, nq;
           String ltr = "";

           nq = numq / 100;
           numr = numq % 100;

           if (numr == 0)
            {
            ltr = ltr + unitdo[nq]+digit[1];
             }
           else
            {
            ltr = ltr +unitdo[nq]+digit[1]+" and"+twonum(numr);
            }
           return ltr;

    }


    public static String convertAmountToWord(Double numberfrmuser)  throws Exception{
     

          //Defining variables q is quotient, r is remainder

          int len, q=0, r=0;
          String ltr = " ";
          String Str = "Rupees";
          
String arr[]=(numberfrmuser+"").split("\\.");
int num = Integer.parseInt(arr[0]+"");
          if (num <= 0) 
        	  
        	  
        	  Str="Zero or Negative number not for conversion";

          while (num>0)
          {

             len = numberCount(num);

             //Take the length of the number and do letter conversion

             switch (len)

             {
                  case 8:
                          q=num/10000000;
                          r=num%10000000;
                          ltr = twonum(q);
                          Str = Str+ltr+digit[4];
                          num = r;
                          break;

                  case 7:
                  case 6:
                          q=num/100000;
                          r=num%100000;
                          ltr = twonum(q);
                          Str = Str+ltr+digit[3];
                          num = r;
                          break;

                  case 5:
                  case 4:

                           q=num/1000;
                           r=num%1000;
                           ltr = twonum(q);
                           Str= Str+ltr+digit[2];
                           num = r;
                           break;

                  case 3:


                            if (len == 3)
                                r = num;
                            ltr = threenum(r);
                            Str = Str + ltr;
                            num = 0;
                            break;

                  case 2:

                           ltr = twonum(num);
                           Str = Str + ltr;
                           num=0;
                           break;

                  case 1:
                           Str = Str + unitdo[num];
                           num=0;
                           break;
                  default:

                          num=0;
                          Str="Exceeding Crore....No conversion";
                          System.exit(1);


              }
                          if (num==0)
                        	  Str=Str+" Only";
          }
     
	return Str;
          
      
         }

      
	
	
	
	
	


	
	
	public static void main(String[] arg){
		try {
			System.out.println(convertAmountToWord(123548.54));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

