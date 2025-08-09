package ex30;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agrupa {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Maria", 7.5));
        alunos.add(new Aluno("Joao", 5.5));
        alunos.add(new Aluno("Carlos", 4.5));
        alunos.add(new Aluno("Joel", 9.25));
        alunos.add(new Aluno("Renan", 8.5));
        alunos.add(new Aluno("Helena", 9.5));
        alunos.add(new Aluno("Matias", 3.5));
        alunos.add(new Aluno("Raissa", 6.5));

        Map<String, List<Aluno>> grupos = new TreeMap<>();
        List<Aluno> aprovados = new ArrayList<>();
        List<Aluno> recuperacao = new ArrayList<>();
        List<Aluno> reprovados = new ArrayList<>();

        for (Aluno aluno : alunos) {
            if (aluno.getNota() >= 7) {
                aprovados.add(aluno);
            } else if (aluno.getNota() < 5) {
                reprovados.add(aluno);
            } else {
                recuperacao.add(aluno);
            }
        }
        grupos.put("aprovados", aprovados);
        grupos.put("reprovados", reprovados);
        grupos.put("recuperacao", recuperacao);
    }
}
