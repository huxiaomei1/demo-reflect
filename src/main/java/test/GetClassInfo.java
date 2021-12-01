package test;

import org.junit.Test;

public class GetClassInfo {
	@Test
	public void test(String className) throws Exception{
		//��ȡPerson�����
		Class cls = Class.forName(className);
		
		//��ȡ���ڵİ���
		Package pkg = cls.getPackage();
		System.out.println(cls.getSimpleName() + "�����ڣ�" + pkg.getName() + "����");
		System.out.println("--------------------------");
		
		//��ȡ�˶�������ʾ��ʵ�壨�ࡢ�ӿڡ��������ͻ�void���ĳ���Class
		//����˶�����Object�ࡢһ���ӿڡ�һ���������ͻ�void�����ĳ��෵��Null
		//����˶�����һ�������࣬���ر�ʾObject���Class����
		Class superClass = cls.getSuperclass();
		System.out.println(cls.getSimpleName() + "�ĳ����ǣ�" + superClass.getName());
		System.out.println("--------------------------");
		
		//��ȡPerson����ʵ�ֵĽӿ�
		//���Person��û��ʵ���κεĽӿڣ�����һ������Ϊ0������
		//���Person����һ���������ͻ�����void����ôҲ����һ������Ϊ0������
		Class[] interfaces = cls.getInterfaces();
		System.out.println("��ʵ�ֵĽӿ��У�");
		for(Class c : interfaces){
			System.out.println(c.getName());
		}
		System.out.println("---------------------------");
	}
	
	public static void main(String[] args) throws Exception{
		GetClassInfo getci = new GetClassInfo();
		getci.test("entity.Person");
	}
}
