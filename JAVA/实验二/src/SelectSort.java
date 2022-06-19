import java.util.Scanner;
public class SelectSort 
{ 
    public static void sort(int[] arr)
    {
        for(int i = 0; i < arr.length - 1; i++) 
        {
            int index = i;//index代表最小元素的下标
            for (int j = i + 1; j < arr.length; j++) //j总是从i的下一个位置向下查找直到末尾
            {
                if (arr[j] < arr[index]) 
                {
                	index = j;//找出当前最小元素的位置
                }
            }
            if(arr[index] != arr[i])//如果index已经改变了
            {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }
    
    
    public static void main(String args[])
    {
    	Scanner reader = new Scanner(System.in);
    	int [] arr = new int[10];
    	int i;
    	
    	System.out.println("接下来请依次输入十个整型数据");
    	for (i = 0; i < 10; i++)
    	{
    		arr[i] = reader.nextInt();
    	}
    	
    	sort(arr);
    	
    	System.out.println("升序排列后的数组显示如下");
    	for (i = 0; i < 10; i++)
    	{
    		System.out.printf("%-3d", arr[i]);
    	}
    	
    	reader.close();
    	
    }
}


