package test;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class GetClassConstructorInfo{
	@Test
	public void test1() throws Exception{
		// 反射 ，拿到字节码文件
		Class cls = Class.forName("entity.Person");
		// 通过字节码文件创建对象
		Object obj = cls.newInstance();

		System.out.println(obj.toString());
	}

	@Test
	public void test2() throws Exception{
		Class cls = Class.forName("entity.Person");
		//获取类的构造函数
		 Constructor[] consts = cls.getDeclaredConstructors(); 
		 System.out.println("=============构造函数展示============");
		 for(Constructor con : consts){
			 Class[] params = con.getParameterTypes();
			 if(params.length == 0){
				 System.out.println("此构造函数没有参数");
			 }else{
				 System.out.println("此构造函数的参数列表为：【");
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
