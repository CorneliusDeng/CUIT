
public class StringOption {

	public static void main(String[] args) 
	{
		String s = new String("We will go further to modify a String by copy! ");
        System.out.println("From String\"" + s + "\"");
        String sub1 = s.substring(19);//返回一个新字符串，它是此字符串的一个子字符串。该子字符串始于指定索引处的字符，一直到此字符串末尾
        String sub2 = s.substring(0,19);
        //返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始， endIndex:到指定的 endIndex-1处结束
        System.out.println("Get a sub string from index 19 to the end:" + sub1);
        System.out.println("Get a sub string from index 0 to 19:" + sub2);
        String cons =sub2.concat(sub1);//用于将多个字符串连接成一个字符串，sub1拼接在sub2之后
        System.out.println("Concat two sub string into one:\n" + cons);
        
        System.out.println(" ");
        
        char sub3 = s.charAt(9);
        //public char charAt (int index )该方法返回字符串中index位置上的字符，其中index值的范围是0～length-1
        System.out.println(" "+sub3);
        
        char[] sub4 = new char[20];
        s.getChars(0,19,sub4,0);
        System.out.println(sub4);//char类型的数组，System.out.println(a)不会输出数组a的引用而是输出全部元素的值
        /*如果要从字符串中提取一个以上的字符，则可以用此方法：
        public void getchars (int srcbegin,int end,char buf[],int dstbegin)
    	其中，srcbegin为要提取的第一个字符在源串中的位置，
    	end为要提取的最后一个字符在源串中的位置，字符数组buf[]存放目的字符串，dstbegin为提取的字符串在目的串中的起始位置。*/
        
        System.out.println(" ");
        
        System.out.println(Character.toLowerCase('A'));//返回转换后字符的小写形式，如果有的话；否则返回字符本身
        System.out.println(Character.toUpperCase('a'));//返回转换后字符的大写形式，如果有的话；否则返回字符本身
        
        System.out.println(" ");
        
        String Str = new String("         www.runoob.com    ");
        System.out.print("原始值 :（占位标记）" );
        System.out.print( Str );
        System.out.println("（占位标记）");


        System.out.print("删除头尾空白 :（占位标记）" );
        System.out.print( Str.trim() );//trim() 方法用于删除 	字符串的头尾空白符。
        System.out.println("（占位标记）");
        
        String banner = "One man, One vote";
        //返回指定字符在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索,如果此字符串中没有这样的字符，则返回 -1
        int subInd1 = banner.lastIndexOf("One", 10);
        System.out.println(subInd1);
	}

}
