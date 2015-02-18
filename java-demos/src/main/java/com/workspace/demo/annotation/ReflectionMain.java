package com.workspace.demo.annotation;

import java.lang.reflect.Method;

/**
 * Created by deepak.barr on 17/2/15.
 */
public class ReflectionMain {
    public static void main(String[] args) throws Exception{


        Class<TestAnnotations> obj = TestAnnotations.class;

        if (obj.isAnnotationPresent(Annotate2.class)) {

            for (Method m : obj.getMethods()) {

                if (m.getAnnotation(Demo.class) != null) {
                    Demo d = (Demo) m.getAnnotation(Demo.class);
                    if (d.enabled()) {
                        System.out.println("Calling "+ m.getName());
                        m.invoke(obj.newInstance());
                    }
                    else
                        System.out.println("Not Calling "+ m.getName());
                }
            }
        }
    }
}
