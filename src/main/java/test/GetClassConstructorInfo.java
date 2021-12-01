package test;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class GetClassConstructorInfo{
	@Test
	public void test1() throws Exception{
		// ���� ���õ��ֽ����ļ�
		Class cls = Class.forName("entity.Person");
		// ͨ���ֽ����ļ���������
		Object obj = cls.newInstance();

		System.out.println(obj.toString());
	}

	@Test
	public void test2() throws Exception{
		Class cls = Class.forName("entity.Person");
		//��ȡ��Ĺ��캯��
		 Constructor[] consts = cls.getDeclaredConstructors(); 
		 System.out.println("=============���캯��չʾ============");
		 for(Constructor con : consts){
			 Class[] params = con.getParameterTypes();
			 if(params.length == 0){
				 System.out.println("�˹��캯��û�в���");
			 }else{
				 System.out.println("�˹��캯���Ĳ����б�Ϊ����");
				 for(int i=0; i<params.length; i++){
					 if(i!=0){
						 System.out.println(",");
					 }
				 }
			 }
		 }
	}
	
	public static void main(String[] args) throws Exception {
		GetClassConstructorInfo cons = new GetClassConstructorInfo();
		cons.test1();
	}
}
