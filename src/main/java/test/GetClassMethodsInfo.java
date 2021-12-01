package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.Person;
import org.junit.Test;

public class GetClassMethodsInfo {

	public static void main(String[] args) {
		GetClassMethodsInfo med = new GetClassMethodsInfo();
		// չʾ��������
		med.invokeSetter("entity.Person", "name", "java.lang.String", "����");
		// չʾPerson���еķ�����Ϣ
		//med.showMethod();
	}

	@Test
	public void invokeSetter(String clsName, String propName, String propType,
			Object propValue) {

		try {
			// ͨ�����䴴��һ��ʵ��
			Class cls = Class.forName(clsName);
			Object obj = cls.newInstance();

			String firstLetter = propName.substring(0, 1).toUpperCase();
			String methodName = "set" + firstLetter + propName.substring(1);
			// ���ݷ������Ͳ����б��ȡsetter����
			Method method = cls.getDeclaredMethod(methodName, Class.forName(propType));
			// �����Ҫ������ͨ��setAccessable�������趨Ϊ���Է���
			// method.setAccessible(true);
			// ���÷���������
			method.invoke(obj, propValue);

			System.out.println(obj);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showMethod() {

		Method[] methods;
		try {
			// ��ȡPerson�е����з�����
			// ����������������Ĭ�ϣ��������ʺ�˽�з��������������̳еķ���,
			// ��������ӿڲ������κη��������ߴ� Class �����ʾһ���������͡�һ��������� void����˷�������һ������Ϊ 0
			// �����顣
			methods = Class.forName("entity.Person")
					.getDeclaredMethods();

			// չʾ������һЩ��Ϣ
			System.out.println("===========����չʾ==========");
			for (Method method : methods) {
				System.out.println("��������" + method.getName());
				System.out.println("����ֵ���ͣ�" + method.getReturnType().getName());

				// ��ȡ�����Ĳ����б�
				Class[] params = method.getParameterTypes();
				if (params.length == 0) {
					System.out.println("�÷���û�в���");
				} else {
					System.out.print("�÷����Ĳ����б�Ϊ��[");
					for (int i = 0; i < params.length; i++) {
						if (i != 0)
							System.out.print(", ");
						System.out.print(params[i].getName());
					}
					System.out.println("]");
				}

				// ��ȡ�������������ӿڵ�Class����
				Class declaringClass = method.getDeclaringClass();
				System.out.println("���������ڣ�" + declaringClass.getName() + " ��");

				// ��ȡ�����׳����쳣���ͣ���throws�Ӿ����������쳣
				Class[] exceptions = method.getExceptionTypes();
				if (exceptions.length > 0) {
					System.out.print("�÷����׳����쳣�У�[");
					for (int i = 0; i < exceptions.length; i++) {
						if (i != 0)
							System.out.print(", ");
						System.out.print(exceptions[i].getName());
					}
					System.out.println("]");
				}

				System.out.println("----------------------------");
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
