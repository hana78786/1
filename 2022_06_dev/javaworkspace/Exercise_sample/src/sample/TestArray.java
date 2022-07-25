package sample;

public class TestArray {
public static void main(String[] args) {
	Person[] list = new Person[3]; //3명을 보관할 수 있는 객체 배열
	list[0] = new Person("김개똥",19,'남');
	list[1] = new Person("김말똥", 20, '남');
	list[2] = new Person("김소똥", 22, '여');
	//각 객체에 name age gender 순서대로 입력
	//Person(String name, int age, char gender)순서
	
	for(int i=0; i<list.length;i++) {
		System.out.println(list[i].getName());
	}
}
}
