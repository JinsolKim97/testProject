package school.model;

import java.util.Iterator;
import java.util.LinkedHashMap;

import school.model.exception.DuplicateTelException;
import school.model.exception.PersonNotFoundException;

public class SchoolService {
	// key : tel  value : Person 자식 객체 ( Student, Teacher , Employee ) 
	private LinkedHashMap<String,Person> map=new LinkedHashMap<String,Person>();
	/*
	 * tel 이 중복되면 추가하지 않고 호출한 측으로 DuplicateTelException을 발생시켜 전파한다(던진다)
	 */
	public void addPerson(Person person) throws DuplicateTelException {
		//tel 중복 유무를 확인 
		if(map.containsKey(person.getTel()))
			throw new DuplicateTelException(person.getTel()+"tel이 중복되어 추가불가!");
		map.put(person.getTel(), person);
	}
	public void printAll() {
		Iterator<Person> it=map.values().iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
	/**
	 * 매개변수로 전달된 tel에 해당하는 구성원이 존재하면 해당 구성원 객체를 반환 
	 * 매개변수로 전달된 tel에 해당하는 구성원이 존재하지 않으면 PersonNotFoundException을 
	 * 발생시켜 호출한 측으로 전달한다 
	 * ( map에 저장된 key들 중 매개변수로 전달된 tel과 일치하는 key가 없으면 ) 
	 * @param tel
	 * @return person
	 * @throws PersonNotFoundException 
	 */
	public Person findPersonByTel(String tel) throws PersonNotFoundException {
		if(map.containsKey(tel)==false)
			throw new PersonNotFoundException(tel+" tel에 해당하는 구성원이 존재하지 않습니다");
		return map.get(tel); 
	}
	public Person deletePersonByTel(String tel) throws PersonNotFoundException {
		if(map.containsKey(tel)==false)
			throw new PersonNotFoundException(tel+" tel에 해당하는 구성원이 존재하지 않아 삭제할 수 없습니다!");
		return map.remove(tel);
	}
	public void updatePerson(Person person) throws PersonNotFoundException {
		if(map.containsKey(person.getTel())) {
			map.put(person.getTel(), person);//수정 
		}else {
			throw new PersonNotFoundException(person.getTel()+" tel 구성원이 존재하지 않아 수정불가");			
		}
	}
}













