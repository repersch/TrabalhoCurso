package curso;

import java.util.HashMap;
import java.util.Map;

public class SubmenuDisciplina {

    private static Map<String, Disciplina> listaDisciplinas = new HashMap<>();


    public void cadastrarDisciplina(Disciplina disciplina) {
        if (!existeDisciplina(disciplina.getSigla())) {
            listaDisciplinas.put(disciplina.getSigla(), disciplina);
        }
    }

    public boolean existeDisciplina(String sigla) {
        return listaDisciplinas.containsKey(sigla);
    }

    public void listarTodasDisciplinas() {
        for (Map.Entry<String, Disciplina> d : listaDisciplinas.entrySet()) {
            System.out.println(d.getValue());
        }
    }

    public Disciplina listarDisciplinaPorSigla(String sigla) {
        return listaDisciplinas.get(sigla);
    }

    public void editarDisciplina(String sigla, Disciplina disciplina) {
        if (listaDisciplinas.containsKey(sigla)) {
            listaDisciplinas.put(sigla, disciplina);
        }
    }

    public Disciplina exluirDisciplinaPorSigla(String sigla) {
        return listaDisciplinas.remove(sigla);
    }
}
