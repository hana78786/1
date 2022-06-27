package access.sample;

public class TsetProtected {
public static void main(String[] args) {
	Parent parent = new Parent();
	Child child = new Child();
	
	parent.num=100;
	child.insert();
	child.out();
}
}
