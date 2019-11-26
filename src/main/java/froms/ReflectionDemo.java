package froms;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionDemo {

	
	
	public static void main(String[] args) throws Exception{
		//Creating object whose property is to be checked
		Test obj = new Test();
		
		//Creating Class object from the object using getclass method
		Class cls = obj.getClass();
		System.out.println("The name of class is "+ cls.getName());
		
		//Getting the constructor of the class through the object of the class
		Constructor constructor = cls.getConstructor();
		System.out.println("The name of constructor is "+ constructor.getName());
		
		
		Method[] methods = cls.getMethods();
		//printing method names
		
		for (Method method : methods) {
			System.out.println(method.getName());
			
		}
		
		
		
		
		
		
		
	}
	
	
}
