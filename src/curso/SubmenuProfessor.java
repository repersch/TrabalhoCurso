package curso;

import java.util.HashMap;
import java.util.Map;

public class SubmenuProfessor {

    private static Map<String, Professor> listaProfessores = new HashMap<>();

    public void cadastrarProfessor(Professor professor) {
        if (listaProfessores.containsKey(professor.getRegistroFuncional())) {
            return;
        }
        listaProfessores.put(professor.getRegistroFuncional(), professor);
    }

    public void listarTodosProfessores() {
        for (Map.Entry<String, Professor> p : listaProfessores.entrySet()) {
            System.out.println(p.getValue());
        }
    }

    public Professor listarProfessorPorRegistro(String registroFuncional) {
        return listaProfessores.get(registroFuncional);
    }

    public Professor excluirProfessor(String registroFuncional) {
       return listaProfessores.remove(registroFuncional);
    }

    public void editarProfessor(String registroFuncional, Professor professorNovo) {
        if (listaProfessores.containsKey(registroFuncional)) {
            listaProfessores.put(registroFuncional, professorNovo);
        }
    }

    public boolean existeProfessor(String registroFuncional) {
        return listaProfessores.containsKey(registroFuncional);
    }

}
