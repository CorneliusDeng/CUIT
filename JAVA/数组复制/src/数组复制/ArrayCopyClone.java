package 数组复制;

public class ArrayCopyClone 
{

	public static void main(String[] args) 
	{
        int[] array1 = { 1, 2, 3, 4, 5 };
        
        
        //方法一，clone()方法
        int[] array2 = array1.clone();
        for (int i = 0; i < array2.length; i++) 
        {
           System.out.print(array2[i]+",");
        }
        
        
        System.out.println("");
        
        /*方法二，使用System.arraycopy方法
        arraycopy()方法是System类的一个静态方法（并且是本地方法，效率非常高），
        	其可以方便的实现数组拷贝功能，System.arraycopy()方法的结构如下：
        	System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        	Object src : 原数组
   			int srcPos : 从元数据的起始位置开始
　　			Object dest : 目标数组
　　			int destPos : 目标数组的开始起始位置
　　			int length  : 要copy的数组的长度*/
        int [] array3 = new int[5];
        System.arraycopy(array1, 0, array3, 0, array1.length);
        // 输出array2结果
        for (int i = 0; i < array3.length; i++) 
        {
          System.out.print(array3[i] + ",");
        }
        
        System.out.println("");
        
        //方法三，一般方法，循环赋值
        int []array4 = new int[5];
        
        for (int j = 0; j < array1.length; j++)
        {
        	array4[j] = array1[j];
        	System.out.print(array4[j]+",");
        }
        
        

	}

}
