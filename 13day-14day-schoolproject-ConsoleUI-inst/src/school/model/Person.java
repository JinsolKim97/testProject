package school.model;
/**
 * 학교 구성원(학생,교사,직원)의 공통점을 모아 일반화한 클래스 
 * 구성원 정보의 공통된 멤버(속성과 기능)을 정의한다 
 * 해당 클래스는 자신의 객체가 별도로 생성될 필요가 없으므로 
 * abstract로 처리한다 
 * @author 잠자리
 *
 */
public abstract class Person {
	private String tel;
	private String name;
	private String address;
	public Person(String tel, String name, String address) {
		super();
		this.tel = tel;
		this.name = name;
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "tel=" + tel + ", name=" + name + ", address=" + address;
	}
	
}








