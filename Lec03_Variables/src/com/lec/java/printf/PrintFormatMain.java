package com.lec.java.printf;

public class PrintFormatMain {

	public static void main(String[] args) {
		System.out.println("����ȭ�� ���: printf(), String.format()");
		
		double pi = Math.PI; // ������ ��
		System.out.println(pi);
		
		// printf : print with format
		// printf("���Ĺ��ڿ�", ��1, ��2, ...)
		// '���Ĺ��ڿ�' �ȿ��� %�� �����ϴ� ���������ڵ�
		
		System.out.printf("������ %f\n", pi);
		System.out.printf("������ %.4f\n", pi);
		
		int age = 10;
		short grade = 3;
		
		System.out.printf("�� ���̴� %d���Դϴ�. �г��� %d�г��Դϴ�\n", age, grade);
		
		//�Ҽ��� ���� ����
		double height = 182.3;
		System.out.printf("���� %d���Դϴ�. Ű�� %.1fcm�Դϴ�.\n", age, height);
		
		//����� ����, �¿� ����
		System.out.printf("|%d|%d|%d|\n", 100, 200, 300);
		System.out.printf("|%5d|%5d|%5d|\n", 100, 200, 300); // ����� 5ĭ, ��������(�⺻)
		System.out.printf("|%-5d|%-5d|%-5d|\n", 100, 200, 300); // ����� 5ĭ, ��������(�⺻)

		System.out.printf("�� �̸��� [%10s]�Դϴ�. �������� %c ���Դϴ�.\n", "����ȣ", 'B');
		
		double rate = 134423.0 / 345678.0;
		System.out.printf("�հ����� %.1f%%�Դϴ�", rate);
		
		System.out.printf("|%05d|%05d|%05d|\n", 100, 200, 300);
		
		String fmt = "�ּ� : %s, �����ȣ[%05d]";
		System.out.printf(fmt + "\n", "����", 12345);
		System.out.printf(fmt + "\n", "����", 44);
		System.out.printf(fmt + "\n", "�뱸", 776);
		
		String.format("�հ����� %.1f%% �Դϴ�", rate);
		String result = String.format("�հ����� %.1f%% �Դϴ�", rate);
		System.out.println(result);
	}

}
