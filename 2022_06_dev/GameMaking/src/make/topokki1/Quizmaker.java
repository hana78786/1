package make.topokki1;

public class Quizmaker {
	
	

	public String Quizmaker(int a) {
		String quizNum[] = new String[10];
		
		
		quizNum[0] = "�ڹ��� Ư¡ 5������ �Ʒ��� ����\n 1) ��ü ���� ���α׷���(OOP) \n 2) �ڵ� �޸� ����(gc)\n 3) �ü���� ������ \n 4) ��Ƽ������ ����  5)���� �ε� ����\n";
		quizNum[1] = "ĸ��ȭ �������� ���� ������ ���� ������ public���� �޼���� private���� �����Ѵ�";
		quizNum[2] = "�������̽��� ���� ��Ӹ� �����ϴ�";
		quizNum[3] = "�θ�-�ڽ� Ŭ������ ���� ��Ӹ� �����ϴ�";
		quizNum[4] = "String�� float, int�� ũ��� 4����Ʈ�� ����";
		quizNum[5] = "a = 1 ; b = 2 ; \n" + "c = ++a + b--; �϶� c�� ���� 3�̴� ";
		quizNum[6] = "final�� ���������� ����� �� �ִ�";
		quizNum[7] = "1_num�� ���������� ����� �� ����";
		quizNum[8] = "String a =\"2\" ; String b =\"3\"; �϶� \n System.out.println(a+b);�� ���� 5�̴�";

		quizNum[9] = "String a =\"2\" ; String b =\"3\"; �϶� \n System.out.println(a+b);�� ���� 23�̴�";

		
		return quizNum[a];


	}
	
	public boolean Answer(int a) {
		boolean quizAnswer[] = {true, false, false, true, true, false, false, true, false, true };// �� ����
		
		return quizAnswer[a];
	}
}
