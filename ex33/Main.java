package ex33;

import java.lang.reflect.InvocationTargetException;

public class Main {
    
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        
        MinhaClasseDeTeste teste = new MinhaClasseDeTeste();
        ExecutorDeTestes.executarTestes(teste);
    }
}
