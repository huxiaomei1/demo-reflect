package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.Person;
import org.junit.Test;

public class GetClassFieldsInfo {

	public static void main(String[] args) {
		GetClassFieldsInfo fieldTest = new GetClassFieldsInfo();
		// �鿴�ֶ���Ϣ
		fieldTest.showFields();
		// ֱ�ӷ����ֶ�
		fieldTest.accessField();
	}

	@Test
	public void showFields() {

		Field[] fields;
		try {
			// ��ȡPerson�е������ֶΣ�
			// ����������������Ĭ�ϣ��������ʺ�˽���ֶΣ����������̳е��ֶ�,
			// ��������ӿڲ������κ��ֶΣ����ߴ� Class �����ʾһ���������͡�һ��������� void����˷�������һ������Ϊ 0 �����顣
			fields = Class.forName("entity.Person").getDeclaredFields();

			// չʾ�ֶε�һЩ��Ϣ
			System.out.println("===========�ֶ�չʾ==========");
			for (Field field : fields) {
				System.out.println("�ֶ�����" + field.getName());
				System.out.println("���ͣ�" + field.getType().getName());
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

	@Test
	public void accessField() {

		// ������ʾͨ���������Person���ֶ�
		try {
			// ͨ���������һ��Personʵ��
			Class cls = Class.forName("entity.Person");
			Object obj = cls.newInstance();

			// ��ȡname�ֶ�
			Field name = cls.getDeclaredField("name");
			// name�ֶ�Ϊprivate�������ѳ�������ʷ�Χ������ֱ�ӷ���
			// ͨ��setAccessable�������趨Ϊ���Է���
			name.setAccessible(true);
			// ��ȡֵ��һ��
			System.out.println("��ֵǰ��name��" + name.get(obj));
			// Ϊname�ֶθ�ֵ
			name.set(obj, "������");
			// չʾһ�¸�ֵЧ��
			System.out.println("��ֵ���name��" + name.get(obj));
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
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
