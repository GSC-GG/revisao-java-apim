package classes_abstratas;

import java.util.ArrayList;

public final class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.setAno(ano);
        this.setMes(mes);
        this.setDia(dia);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        ArrayList<Integer> dias = new ArrayList<>();
        dias.add(2);
        dias.add(4);
        dias.add(6);
        dias.add(9);
        dias.add(11);
        if ((dia < 1)
                || (dia > 32)
                || (dia > 29 && this.mes != 2)
                || (dia > 30 && dias.contains(this.mes))
                || (dia == 29 && this.mes == 2
                && (this.ano % 400 != 0 || (this.ano % 100 != 0 && this.ano % 4 != 0)))) {
            throw new IllegalArgumentException("Dia invalido!");
        }
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mes invalido!");
        }
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return (this.dia + "/" + this.mes + "/" + this.ano);
    }

}
