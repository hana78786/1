package com.kh.adstarctex;

public abstract class Car {  //abstract �߻� Ŭ���� ����
		private String carName;
		
//		public void move(int x) {
//			System.out.println(x+"��ŭ �̵��մϴ�");
//		}
		
		public abstract void move(int x);
		//abstract  �߻�޼ҵ�� �߰�ȣ ���� ����
		// �߻� �޼ҵ尡 �ִ� Ŭ������ �ݵ�� �߻� Ŭ������ �����ؾ� ��!


		public void stop() {
			System.out.println("���� ����ϴ�.");
		}
}
