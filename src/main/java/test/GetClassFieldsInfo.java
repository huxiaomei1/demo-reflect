package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import entity.Person;
import org.junit.Test;

public class GetClassFieldsInfo {

	public static void main(String[] args) {
		GetClassFieldsInfo fieldTest = new GetClassFieldsInfo();
		// 查看字段信息
		fieldTest.showFields();
		// 直接访问字段
		fieldTest.accessField();
	}

	@Test
	public void showFields() {

		Field[] fields;
		try {
			// 获取Person中的所有字段，
			// 包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段,
			// 如果该类或接口不声明任何字段，或者此 Class 对象表示一个基本类型、一个数组类或 void，则此方法返回一个长度为 0 的数组。
			fields = Class.forName("entity.Person").getDeclaredFields();

			// 展示字段的一些信息
			System.out.println("===========字段展示==========");
			for (Field field : fields) {
				System.out.println("字段名：" + field.getName());
				System.out.println("类型：" + field.getType().getName());
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

		// 本例演示通过反射操作Person的字段
		try {
			// 通过反射加载一个Person实例
			Class cls = Class.forName("entity.Person");
			Object obj = cls.newInstance();

			// 获取name字段
			Field name = cls.getDeclaredField("name");
			// name字段为private，这里已超出其访问范围，不能直接访问
			// 通过setAccessable方法，设定为可以访问
			name.setAccessible(true);
			// 先取值看一下
			System.out.println("赋值前的name：" + name.get(obj));
			// 为name字段赋值
			name.set(obj, "大柱子");
			// 展示一下赋值效果
			System.out.println("赋值后的name：" + name.get(obj));
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
