package make.topokki1;

public class Quizmaker {
	
	

	public String Quizmaker(int a) {
		String quizNum[] = new String[10];
		
		
		quizNum[0] = "자바의 특징 5가지는 아래와 같다\n 1) 객체 지향 프로그래밍(OOP) \n 2) 자동 메모리 관리(gc)\n 3) 운영체제에 독립적 \n 4) 멀티쓰레드 지원  5)동적 로딩 지원\n";
		quizNum[1] = "캡술화 과정에서 정보 은닉을 위해 변수는 public으로 메서드는 private으로 선언한다";
		quizNum[2] = "인터페이스는 단일 상속만 가능하다";
		quizNum[3] = "부모-자식 클래스는 단일 상속만 가능하다";
		quizNum[4] = "String과 float, int의 크기는 4바이트로 같다";
		quizNum[5] = "a = 1 ; b = 2 ; \n" + "c = ++a + b--; 일때 c의 값은 3이다 ";
		quizNum[6] = "final은 변수명으로 사용할 수 있다";
		quizNum[7] = "1_num은 변수명으로 사용할 수 없다";
		quizNum[8] = "String a =\"2\" ; String b =\"3\"; 일때 \n System.out.println(a+b);의 값은 5이다";

		quizNum[9] = "String a =\"2\" ; String b =\"3\"; 일때 \n System.out.println(a+b);의 값은 23이다";

		
		return quizNum[a];


	}
	
	public boolean Answer(int a) {
		boolean quizAnswer[] = {true, false, false, true, true, false, false, true, false, true };// 답 모음
		
		return quizAnswer[a];
	}
}
