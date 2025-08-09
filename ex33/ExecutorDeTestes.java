package ex33;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecutorDeTestes {
    
    public static void executarTestes(Object obj) throws IllegalAccessException, InvocationTargetException {
        
        Class classe = obj.getClass();
        Method[] metodos = classe.getDeclaredMethods();

        for (Method metodo : metodos) {
            if (metodo.isAnnotationPresent(Teste.class)) {
                metodo.invoke(obj);
            }
        }
    }
}
