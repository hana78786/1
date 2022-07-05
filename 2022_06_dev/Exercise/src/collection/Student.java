package collection;

public class Student {
	private String name;
	private int score;
	
	
	public Student(){
		
	}
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;	
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "이름 : "+this.name+ " 점수 : "+this.score;
}
@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return ("이름 : "+this.name+ " 점수 : "+this.score).hashCode();
}

@Override
public boolean equals(Object obj) {
	
	if(obj instanceof Student) {
		Student std;
		std = (Student) obj;
		return this.hashCode()==std.hashCode();
		
	}else {
		
		return false;
	}
}

}
	
	
	
	

