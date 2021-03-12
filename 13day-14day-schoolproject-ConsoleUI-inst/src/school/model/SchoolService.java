package school.model;

import java.util.Iterator;
import java.util.LinkedHashMap;

import school.model.exception.DuplicateTelException;
import school.model.exception.PersonNotFoundException;

public class SchoolService {
	// key : tel  value : Person �ڽ� ��ü ( Student, Teacher , Employee ) 
	private LinkedHashMap<String,Person> map=new LinkedHashMap<String,Person>();
	/*
	 * tel �� �ߺ��Ǹ� �߰����� �ʰ� ȣ���� ������ DuplicateTelException�� �߻����� �����Ѵ�(������)
	 */
	public void addPerson(Person person) throws DuplicateTelException {
		//tel �ߺ� ������ Ȯ�� 
		if(map.containsKey(person.getTel()))
			throw new DuplicateTelException(person.getTel()+"tel�� �ߺ��Ǿ� �߰��Ұ�!");
		map.put(person.getTel(), person);
	}
	public void printAll() {
		Iterator<Person> it=map.values().iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
	/**
	 * �Ű������� ���޵� tel�� �ش��ϴ� �������� �����ϸ� �ش� ������ ��ü�� ��ȯ 
	 * �Ű������� ���޵� tel�� �ش��ϴ� �������� �������� ������ PersonNotFoundException�� 
	 * �߻����� ȣ���� ������ �����Ѵ� 
	 * ( map�� ����� key�� �� �Ű������� ���޵� tel�� ��ġ�ϴ� key�� ������ ) 
	 * @param tel
	 * @return person
	 * @throws PersonNotFoundException 
	 */
	public Person findPersonByTel(String tel) throws PersonNotFoundException {
		if(map.containsKey(tel)==false)
			throw new PersonNotFoundException(tel+" tel�� �ش��ϴ� �������� �������� �ʽ��ϴ�");
		return map.get(tel); 
	}
	public Person deletePersonByTel(String tel) throws PersonNotFoundException {
		if(map.containsKey(tel)==false)
			throw new PersonNotFoundException(tel+" tel�� �ش��ϴ� �������� �������� �ʾ� ������ �� �����ϴ�!");
		return map.remove(tel);
	}
	public void updatePerson(Person person) throws PersonNotFoundException {
		if(map.containsKey(person.getTel())) {
			map.put(person.getTel(), person);//���� 
		}else {
			throw new PersonNotFoundException(person.getTel()+" tel �������� �������� �ʾ� �����Ұ�");			
		}
	}
}













