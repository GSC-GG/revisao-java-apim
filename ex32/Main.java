package ex32;

import java.lang.reflect.Field;

public class Main {
    
    public static void main(String[] args) {
        
        try {
            Configuracao config = new Configuracao();
            Class classe = config.getClass();
            Field conexao = classe.getDeclaredField("urlConexao");
            conexao.setAccessible(true);
            conexao.set(config, "db.producao.com:5432");
    
            System.out.println(conexao.get(config));
        } catch (Exception e) {
        }
    }
}
