package ex29;

import java.util.LinkedList;

public class Historico {
    
    private LinkedList<String> historico;
    private static int indice = 0;

    public Historico() {
        this.historico = new LinkedList<>();
    }

    public LinkedList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(LinkedList<String> historico) {
        this.historico = historico;
    }

    public void visitar(String url) {
        historico.add(url);
        indice = historico.size() - 1;
    }

    public String voltar() {
        return historico.get(--indice);
    }

    public String avancar() {
        return historico.get(++indice);
    }
}
