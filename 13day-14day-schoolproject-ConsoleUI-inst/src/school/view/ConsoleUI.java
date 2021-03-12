package school.view;

import java.util.Scanner;

import school.model.Employee;
import school.model.Person;
import school.model.SchoolService;
import school.model.Student;
import school.model.Teacher;
import school.model.exception.DuplicateTelException;
import school.model.exception.PersonNotFoundException;

//������ �߰� �� ��üȸ������, �˻� , ����
public class ConsoleUI {
	private SchoolService service = new SchoolService();
	private Scanner scanner = new Scanner(System.in);

	public void execute() {
		System.out.println("*******�л�������α׷��� �����մϴ� ver5******");
		// ��� label --> �Ʒ� 5 ����� break�� �����ϸ� �ش� switch����
		// ����Ƿ� �Ʒ� while�� ��ü�� ����� ���α׷��� ����ǹǷ�
		// ���̺��� �̿��Ѵ�
		exit: while (true) {
			System.out.println("1. �߰� 2. ���� 3. �˻� 4. ��üȸ������ 5.����");
			String menu = scanner.nextLine();// ����ڷκ��� �޴���ȣ�� �Է¹޴´�
			switch (menu) {
			case "1":
				addView();
				break;
			case "2":
				deleteView();
				break;
			case "3":
				findView();
				break;
			case "4":
				System.out.println("**��ü����������**");
				service.printAll();
				break;
			case "5":
				System.out.println("*******�л�������α׷��� �����մϴ�******");
				break exit;// while���� ������� ���̺��� ����Ѵ�
			default: // 1~5 �ƴ� ���� default���� ó��
				System.out.println("�߸��� �Է°��Դϴ�!");
			}// switch
		} // while
		scanner.close();
	}// execute method
		// ������ �߰� �۾��� ����ϴ� �޼���

	public void addView() {
		System.out.println("�Է��� �������� ������ �����ϼ��� 1.�л�  2.������ 3.����");
		String menu = scanner.nextLine();
		System.out.println("1. ��ȭ��ȣ�� �Է��ϼ���!");
		String tel = scanner.nextLine();
		System.out.println("2. �̸��� �Է��ϼ���!");
		String name = scanner.nextLine();
		System.out.println("3. �ּҸ� �Է��ϼ���!");
		String address = scanner.nextLine();
		Person person = null;
		switch (menu) {
		case "1":
			System.out.println("4. �й��� �Է��ϼ���!");
			String stuId = scanner.nextLine();
			person = new Student(tel, name, address, stuId);
			break;
		case "2":
			System.out.println("4. ������ �Է��ϼ���!");
			String subject = scanner.nextLine();
			person = new Teacher(tel, name, address, subject);
			break;
		case "3":
			System.out.println("4. �μ��� �Է��ϼ���!");
			String dept = scanner.nextLine();
			person = new Employee(tel, name, address, dept);
			break;
		}
		try {
			service.addPerson(person);
			System.out.println("����Ʈ�� �߰�:" + person);
		} catch (DuplicateTelException e) {
			System.out.println(e.getMessage());
		}
	}// addView method

	public void findView() {
		System.out.println("��ȸ�� �������� ��ȭ��ȣ�� �Է��ϼ���");
		String tel = scanner.nextLine();
		try {
			Person p = service.findPersonByTel(tel);
			System.out.println("��ȸ���:" + p);
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}// find method
	public void deleteView() {
		System.out.println("������ �������� ��ȭ��ȣ�� �Է��ϼ���");
		String tel=scanner.nextLine();
		try {
			service.deletePersonByTel(tel);
			System.out.println(tel+"�� �ش��ϴ� �������� �����Ͽ����ϴ�.");
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}//delete method 
}// class




















