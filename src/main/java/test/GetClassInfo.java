package test;

import org.junit.Test;

public class GetClassInfo {
	@Test
	public void test(String className) throws Exception{
		//获取Person类对象
		Class cls = Class.forName(className);
		
		//获取类在的包名
		Package pkg = cls.getPackage();
		System.out.println(cls.getSimpleName() + "定义在：" + pkg.getName() + "包中");
		System.out.println("--------------------------");
		
		//获取此对象所表示的实体（类、接口、基本类型或void）的超类Class
		//如果此对象是Object类、一个接口、一个基本类型或void，他的超类返回Null
		//如果此对象是一个数组类，返回表示Object类的Class对象
		Class superClass = cls.getSuperclass();
		System.out.println(cls.getSimpleName() + "的超类是：" + superClass.getName());
		System.out.println("--------------------------");
		
		//获取Person类所实现的接口
		//如果Person类没有实现任何的接口，返回一个长度为0的数组
		//如果Person类是一个基本类型或者是void，那么也返回一个长度为0的数组
		Class[] interfaces = cls.getInterfaces();
		System.out.println("所实现的接口有：");
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
