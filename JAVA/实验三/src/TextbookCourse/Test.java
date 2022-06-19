package TextbookCourse;

public class Test {
	public static void main(String[] args) 
	{
		System.out.println("************************课程1相关************************");
		Course Java = new Course("面向对象程序设计（Java）A", "文立玉老师"); 
		Textbook Javatextbook = new Textbook("Java程序设计精编教程","张跃平 耿祥义",
				"清华大学出版社",39.5,"978-7-302-47316-9");
		ReferenceBook JavaRebook1 = new ReferenceBook("JAVA核心技术卷1","霍斯特曼",
				"机械工业出版社",119,"978-7-111-54742-6");
		ReferenceBook JavaRebook2 = new ReferenceBook("JAVA核心技术卷2","霍斯特曼",
				"机械工业出版社",139,"978-7-111-57331-9");
		
		Java.display();
		System.out.println(" ");
		Javatextbook.display();
		System.out.println(" ");
		System.out.println("该课程的参考书信息如下");
		JavaRebook1.display();
		System.out.println(" ");
		JavaRebook2.display();
		System.out.println(" ");
		
		System.out.println("************************课程2相关************************");
		Course Python = new Course("Python程序设计", "曹亮老师"); 
		Textbook Pythontextbook = new Textbook("Python程序设计与算法基础教程", "江红 余青松",
				"清华大学出版社",59,"978-7-302-52483-0");
		ReferenceBook PythonRebook1 = new ReferenceBook("Python编程 从入门到实践","埃里克.马瑟斯",
				"人民邮电出版社",89,"978-7-115-42802-8");
		ReferenceBook PythonRebook2 = new ReferenceBook("Python编程入门指南","明日科技",
				"机械工业出版社",80,"978-7-121-35797-8");
		
		Python.display();
		System.out.println(" ");
		Pythontextbook.display();
		System.out.println(" ");
		System.out.println("该课程的参考书信息如下");
		PythonRebook1.display();
		System.out.println(" ");
		PythonRebook2.display();
		System.out.println(" ");
		
		System.out.println("************************课程3相关************************");
		Course DateStructure = new Course("数据结构", "张帆老师");
		Textbook DStextbook = new Textbook("数据结构C语言版", "严蔚敏",
				"人民邮电出版社",35,"978-7-115-37950-4");
		ReferenceBook DSRebook1 = new ReferenceBook("算法导论","罗伯特.斯科特维奇",
				"人民邮电出版社",99,"978-7-115-29380-0");
		ReferenceBook DSRebook2 = new ReferenceBook("数据结构与算法","迈克尔.古德里奇",
				"机械工业出版社",109,"978-7-111-60660-4");
		
		DateStructure.display();
		System.out.println(" ");
		DStextbook.display();
		System.out.println(" ");
		System.out.println("该课程的参考书信息如下");
		DSRebook1.display();
		System.out.println(" ");
		DSRebook2.display();
		System.out.println(" ");
	}
}
