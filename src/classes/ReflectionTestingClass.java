package classes;

import com.sun.source.tree.TypeParameterTree;

import java.lang.reflect.*;

public class ReflectionTestingClass {

    public static void main(String []args) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        ConcreteClass3 classObj = new ConcreteClass3();
        for(Method m : classObj.getClass().getDeclaredMethods()) {
//            System.out.println(m.getName());
//            System.out.println(m.getDeclaringClass());
//            System.out.println(m.getAnnotatedReturnType());
//            System.out.println(m.getParameterCount());
//            System.out.println(m.getModifiers() + " -> " + Modifier.toString(m.getModifiers()));
            if(m.getModifiers() == 2) {
                System.out.println(m.getModifiers() + " -> " + Modifier.toString(m.getModifiers()));
                m.setAccessible(true);
                System.out.println(m.getModifiers() + " -> " + Modifier.toString(m.getModifiers()));
                m.invoke(classObj);
            }
        }
    }

}
