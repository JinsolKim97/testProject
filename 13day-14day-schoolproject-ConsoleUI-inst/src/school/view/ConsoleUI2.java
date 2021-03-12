package school.view;

import java.util.Scanner;

import school.model.Employee;
import school.model.Person;
import school.model.SchoolService;
import school.model.Student;
import school.model.Teacher;
import school.model.exception.DuplicateTelException;
import school.model.exception.PersonNotFoundException;

//구성원 추가 및 전체회원보기, 검색 , 삭제
public class ConsoleUI2 {
	private SchoolService service = new SchoolService();
	private Scanner scanner = new Scanner(System.in);

	public void execute() {
		System.out.println("*******학사관리프로그램을 시작합니다 ver5******");
		// 제어문 label --> 아래 5 종료시 break만 명시하면 해당 switch문만
		// 벗어나므로 아래 while문 전체를 벗어나야 프로그램이 종료되므로
		// 레이블을 이용한다
		exit: while (true) {
			System.out.println("1. 추가 2. 삭제 3. 검색 4. 전체회원보기 5.종료");
			String menu = scanner.nextLine();// 사용자로부터 메뉴번호를 입력받는다
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
				System.out.println("**전체구성원보기**");
				service.printAll();
				break;
			case "5":
				System.out.println("*******학사관리프로그램을 종료합니다******");
				break exit;// while문을 벗어나도록 레이블을 사용한다
			default: // 1~5 아닌 값은 default에서 처리
				System.out.println("잘못된 입력값입니다!");
			}// switch
		} // while
		scanner.close();
	}// execute method
		// 구성원 추가 작업을 담당하는 메서드

	public void addView() {
		String menu = null;
		while (true) {
			System.out.println("입력할 구성원의 종류를 선택하세요 1.학생  2.선생님 3.직원");
			menu = scanner.nextLine();
			if (menu.equals("1") || menu.equals("2") || menu.equals("3")) {
				break;
			} else {
				System.out.println("학생, 선생님, 직원(1~3번)중 하나의 메뉴를 선택하세요!");
			}
		}

		
		//중복된 전화번호일 경우 다시 입력받도록 코드를 추가한다
		String tel = null;
		while(true) {
			System.out.println("1. 전화번호를 입력하세요!");
			tel = scanner.nextLine();	
			try {
				//tel이 존재하지 않으면 PersonNotFoundException 발생되고 이는 tel이 존재하지 않아 등록 가능한 tel임을 의미
				service.findPersonByTel(tel);
				System.out.println(tel+" tel은 중복됩니다. 다시 입력하세요!");
			} catch (PersonNotFoundException e) {
				break; //등록 가능한 tel임으로 while문을 벗어난다
			}
		}
		
		System.out.println("2. 이름을 입력하세요!");
		String name = scanner.nextLine();
		System.out.println("3. 주소를 입력하세요!");
		String address = scanner.nextLine();
		Person person = null;
		switch (menu) {
		case "1":
			System.out.println("4. 학번을 입력하세요!");
			String stuId = scanner.nextLine();
			person = new Student(tel, name, address, stuId);
			break;
		case "2":
			System.out.println("4. 과목을 입력하세요!");
			String subject = scanner.nextLine();
			person = new Teacher(tel, name, address, subject);
			break;
		case "3":
			System.out.println("4. 부서를 입력하세요!");
			String dept = scanner.nextLine();
			person = new Employee(tel, name, address, dept);
			break;
		}
		try {
			service.addPerson(person);
			System.out.println("리스트에 추가:" + person);
		} catch (DuplicateTelException e) {
			System.out.println(e.getMessage());
		}
	}// addView method

	public void findView() {
		System.out.println("조회할 구성원의 전화번호를 입력하세요");
		String tel = scanner.nextLine();
		try {
			Person p = service.findPersonByTel(tel);
			System.out.println("조회결과:" + p);
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}// find method

	public void deleteView() {
		System.out.println("삭제할 구성원의 전화번호를 입력하세요");
		String tel = scanner.nextLine();
		try {
			service.deletePersonByTel(tel);
			System.out.println(tel + "에 해당하는 구성원을 삭제하였습니다.");
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}// delete method
}// class
