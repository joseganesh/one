package ValidationUtil;

import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Validation 
{

//method for type the number
	public static boolean number(String num)
	{
		boolean flg=false;
		Pattern pattern = Pattern.compile("^[0-9, ]+$");
		 Matcher m = pattern.matcher(num);
		if (m.matches())
		{
			flg=true;
		}
		return flg;
	}
	
	
	//method for type the text in the text
	public static boolean text(String tex)
	{
		boolean flag=false;
		Pattern pattern = Pattern.compile("^[a-z,A-Z]+");
		 Matcher m = pattern.matcher(tex);
		 if (m.matches())
			{
				flag=true;
			}
			return flag;
	}
	
	
	//method for type the text and number
	
	public static boolean textnum(String texnum)
	{
		boolean flage=false;
		Pattern pattern = Pattern.compile("^[a-z,A-Z,0-9]+");
		 Matcher m = pattern.matcher(texnum);
		 if (m.matches())
			{
				flage=true;
			}
			return flage;
	}
	
	
	
	
	//method for email validation
	
	public static boolean email(String emai)
	{
		boolean flagel=false;
		Pattern pattern = Pattern.compile("[a-zA-Z0-9._-][a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]");
		 Matcher m = pattern.matcher(emai);
		 if (m.matches())
			{
				flagel=true;
			}
			return flagel;
	}
	
	
}
