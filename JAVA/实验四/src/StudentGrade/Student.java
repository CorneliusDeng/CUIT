package StudentGrade;

public abstract class Student 
{
	protected String name;
	protected String type;
	protected float scoreJava, scoreC, scoreMath;//Java成绩，C语言成绩， 高数成绩
	protected String grade1, grade2, grade3;//Java等级，C语言等级，高数等级
	
	public Student(String name, String type, float scoreJava, float scoreC, float scoreMath)
	{
		this.name = name;
		this.type = type;
		this.scoreJava = scoreJava;
		this.scoreC = scoreC;
		this.scoreMath = scoreMath;
	}
	
	public abstract void RatingLevel(float a, float b, float c);
	
	public abstract void display();
	
	public abstract float getScoreJava();
	public abstract void setScoreJava(float sj);
	
	public abstract float getScoreC();
	public abstract void setScoreC(float sc);
	
	public abstract float getScoreMath();
	public abstract void setScoreMath(float sm);

}
