/*public class Main11 
{

	public static void main(String[] args) 
	{
		Student [] student = new Student[3];
		
		student[0] = new Undergraduate("zhang", "本科生", 56f);
		student[1] = new Postgraduate("li", "研究生", 56f);
		student[2] = new Postgraduate("wu", "研究生", 88f);
		
		//计算等级
		for (int i = 0; i < 3; i++)
		{
			student[i].RatingLevel(student[i].scoreJava);
			System.out.printf("%s的Java课程等级为：%s\n", student[i].name, student[i].gradejava);
		}
		

	}

}

abstract class Student 
{
	protected String name;
	protected String type;
	protected float scoreJava;//Java成绩
	protected String gradejava;//Java等级
	
	public Student(String name, String type, float scoreJava)
	{
		this.name = name;
		this.type = type;
		this.scoreJava = scoreJava;
	}
	
	public abstract void RatingLevel(float a);
	public abstract float getScoreJava();
	public abstract void setScoreJava(float sj);
}

class Undergraduate extends Student
{
	public Undergraduate(String name, String type, float scoreJava)
	{
		super(name, type, scoreJava);
	}

	public void RatingLevel(float a) 
	{
		if (a >= 80 && a <= 100)
		{
			gradejava = "优秀";
		}
		else if (a >= 70 && a < 80)
		{
			gradejava = "良好";
		}
		else if (a >= 60 && a < 70)
		{
			gradejava = "一般";
		}
		else if (a >= 50 && a < 60)
		{
			gradejava = "及格";
		}
		else 
		{
			gradejava = "不及格";
		}
		
	}

	public float getScoreJava() 
	{
		return scoreJava;
	}

	public void setScoreJava(float sj) 
	{
		scoreJava = sj;
	}
}

class Postgraduate extends Student
{
	public Postgraduate(String name, String type, float scoreJava)
	{
		super(name, type, scoreJava);
	}

	public void RatingLevel(float a) 
	{
		if (a >= 90 && a <= 100)
		{
			gradejava = "优秀";
		}
		else if (a >= 80 && a < 90)
		{
			gradejava = "良好";
		}
		else if (a >= 70 && a < 80)
		{
			gradejava = "一般";
		}
		else if (a >= 60 && a < 70)
		{
			gradejava = "及格";
		}
		else 
		{
			gradejava = "不及格";
		}
		
	}

	public float getScoreJava() 
	{
		return scoreJava;
	}

	public void setScoreJava(float sj) 
	{
		scoreJava = sj;
	}
}*/