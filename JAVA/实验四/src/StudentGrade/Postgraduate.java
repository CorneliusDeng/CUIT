package StudentGrade;

public class Postgraduate extends Student
{
	public Postgraduate(String name, String type, float scoreJava, float scoreC, float scoreMath)
	{
		super(name, type, scoreJava, scoreC, scoreMath);
	}
	
	@Override
	public void RatingLevel(float a, float b, float c) 
	{
		/*Java成绩*/
		if (a >= 90 && a <= 100)
		{
			grade1 = "优秀";
		}
		else if (a >= 80 && a < 90)
		{
			grade1 = "良好";
		}
		else if (a >= 70 && a < 80)
		{
			grade1 = "一般";
		}
		else if (a >= 60 && a < 70)
		{
			grade1 = "及格";
		}
		else
		{
			grade1 = "不及格";
		}
		
		/*C成绩*/
		if (b >= 90 && b <= 100)
		{
			grade2 = "优秀";
		}
		else if (b >= 80 && b < 90)
		{
			grade2 = "良好";
		}
		else if (b >= 70 && b < 80)
		{
			grade2 = "一般";
		}
		else if (b >= 60 && b < 70)
		{
			grade2 = "及格";
		}
		else 
		{
			grade2 = "不及格";
		}
		
		/*高数成绩*/
		if (c >= 90 && c <= 100)
		{
			grade3 = "优秀";
		}
		else if (c >= 80 && c < 90)
		{
			grade3 = "良好";
		}
		else if (c >= 70 && c < 80)
		{
			grade3 = "一般";
		}
		else if (c >= 60 && c < 70)
		{
			grade3 = "及格";
		}
		else 
		{
			grade3 = "不及格";
		}

	}

	@Override
	public void display() 
	{
		System.out.printf("%s\t%s\t"
				+ "%.2f\t%s\t"
				+ "%.2f\t%s\t"
				+ "%.2f\t%s\n", 
				name, type, scoreJava, grade1, scoreC, grade2, scoreMath, grade3);
	}
	
	@Override
	public float getScoreJava() 
	{
		return scoreJava;
	}

	@Override
	public void setScoreJava(float sj) 
	{
		scoreJava = sj;
		
	}

	@Override
	public float getScoreC() 
	{
		return scoreC;
	}

	@Override
	public void setScoreC(float sc) 
	{
		scoreC = sc;
	}

	@Override
	public float getScoreMath() 
	{
		return scoreMath;
	}

	@Override
	public void setScoreMath(float sm) 
	{
		scoreMath = sm;
	}

}
