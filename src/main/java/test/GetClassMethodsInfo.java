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
		// 展示方法调用
		med.invokeSetter("entity.Person", "name", "java.lang.String", "张三");
		// 展示Person类中的方法信息
		//med.showMethod();
	}

	@Test
	public void invokeSetter(String clsName, String propName, String propType,
			Object propValue) {

		try {
			// 通过反射创建一个实例
			Class cls = Class.forName(clsName);
			Object obj = cls.newInstance();

			String firstLetter = propName.substring(0, 1).toUpperCase();
			String methodName = "set" + firstLetter + propName.substring(1);
			// 根据方法名和参数列表获取setter方法
			Method method = cls.getDeclaredMethod(methodName, Class.forName(propType));
			// 如果需要，可以通过setAccessable方法，设定为可以访问
			// method.setAccessible(true);
			// 调用方法并传参
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
			// 获取Person中的所有方法，
			// 包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法,
			// 如果该类或接口不声明任何方法，或者此 Class 对象表示一个基本类型、一个数组类或 void，则此方法返回一个长度为 0
			// 的数组。
			methods = Class.forName("entity.Person")
					.getDeclaredMethods();

			// 展示方法的一些信息
			System.out.println("===========方法展示==========");
			for (Method method : methods) {
				System.out.println("方法名：" + method.getName());
				System.out.println("返回值类型：" + method.getReturnType().getName());

				// 获取方法的参数列表
				Class[] params = method.getParameterTypes();
				if (params.length == 0) {
					System.out.println("该方法没有参数");
				} else {
					System.out.print("该方法的参数列表为：[");
					for (int i = 0; i < params.length; i++) {
						if (i != 0)
							System.out.print(", ");
						System.out.print(params[i].getName());
					}
					System.out.println("]");
				}

				// 获取方法所属的类或接口的Class对象
				Class declaringClass = method.getDeclaringClass();
				System.out.println("方法声明在：" + declaringClass.getName() + " 中");

				// 获取方法抛出的异常类型，即throws子句中声明的异常
				Class[] exceptions = method.getExceptionTypes();
				if (exceptions.length > 0) {
					System.out.print("该方法抛出的异常有：[");
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
