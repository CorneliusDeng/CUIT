
import java.util.*;
public class Main9 
{

	public static void main(String[] args) 
	{
		Scanner reader = new Scanner(System.in);
		int num = 0, chartra = 0, blak = 0, other=0;  
		String str = reader.nextLine();
		
		char x[]=str.toCharArray(); 
		for(int i = 0; i < x.length; i++)
		{  
			if(Character.isDigit(x[i]))
			{  
				 num++;  
	        }
			else if(Character.isLetter(x[i]))
			{  
	               chartra++;  
	        }
			else if(Character.isSpace(x[i]))
			{  
	               blak++;  
	        }  
	        else
	        {  
	               other++;  
	        }  
		}
		
		System.out.println("字母个数："+chartra);  
		System.out.println("数字个数："+num);  
	    System.out.println("空格个数："+blak);  
	    System.out.println("其他字符个数："+other);  
		
		reader.close();
	}

}