package curso;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {


    public static void main(String[] args) {


        SubmenuProfessor submenuProfessor = criaDadosProfessores();
        SubmenuDisciplina submenuDisciplina = criaDadosDisciplinas();


        int opcaoPrincipal = 0;
        while (opcaoPrincipal != 3) {
            opcaoPrincipal = mostraMenuPrincipal();

            if (opcaoPrincipal == 1) {

                int opcaoProfessor = 0;
                while (opcaoProfessor != 6) {

                    opcaoProfessor = mostraSubmenuProfessor();

                    switch (opcaoProfessor) {
                        case 1 -> submenuProfessor.listarTodosProfessores();
                        case 2 -> listarUmProfessor(submenuProfessor);
                        case 3 -> {
                            Professor novoProfessor = criarProfessor(submenuProfessor);
                            if (novoProfessor != null) {
                                submenuProfessor.cadastrarProfessor(novoProfessor);
                                System.out.println("\nProfessor cadastrado com sucesso!\n");
                            }
                        }
                        case 4 -> alterarDadosProfessor(submenuProfessor);
                        case 5 -> excluirRegistroProfessor(submenuProfessor);
                    }

                }
            } else if (opcaoPrincipal == 2){

                int opcaoDisciplina = 0;
                while (opcaoDisciplina != 6) {
                    opcaoDisciplina = mostraSubmenuDisciplina();

                   switch (opcaoDisciplina) {
                       case 1 -> submenuDisciplina.listarTodasDisciplinas();
                       case 2 -> listarUmaDisciplina(submenuDisciplina);
                       case 3 -> {
                           Disciplina novaDisciplina = criarDisciplina(submenuDisciplina);
                           if (novaDisciplina != null) {
                               submenuDisciplina.cadastrarDisciplina(novaDisciplina);
                               System.out.println("\nDisciplina cadastrada com sucesso!\n");
                           }
                       }
                       case 4 -> alterarDadosDisciplina(submenuDisciplina);
                       case 5 -> excluirRegistroDisciplina(submenuDisciplina);
                   }
                }
            }
        }
    }

    private static void excluirRegistroDisciplina(SubmenuDisciplina submenuDisciplina) {
        Scanner scanner = new Scanner(System.in);

        String sigla = obterSigla();

        Disciplina disciplina = submenuDisciplina.listarDisciplinaPorSigla(sigla);

        if (disciplina != null) {
            System.out.println("Excluir dados da disciplina " + disciplina.getNome() + "?\n" +
                    "Digite \"S\" para confirmar ou qualquer outro botão para cancelar: ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                submenuDisciplina.exluirDisciplinaPorSigla(sigla);
                System.out.println("\nRegistro excluído com sucesso.");
            } else {
                System.out.println("\nExclusão cancelada.");
            }
        } else {
            System.out.println("Não existe disciplina cadastrada com essa sigla.");
        }
    }

    private static void alterarDadosDisciplina(SubmenuDisciplina submenuDisciplina) {

        Scanner scanner = new Scanner(System.in);

        String sigla = obterSigla();
        if (submenuDisciplina.existeDisciplina(sigla)) {

            Disciplina disciplina = submenuDisciplina.listarDisciplinaPorSigla(sigla);

            System.out.println("Alterar dados da disciplina: " + disciplina.getNome());
            System.out.print("Ementa: ");
            disciplina.setEmenta(scanner.nextLine());

            System.out.print("Número de créditos: ");
            disciplina.setNumeroCreditos(scanner.nextInt());
            System.out.print("Carga horária: ");
            disciplina.setCargaHoraria(scanner.nextInt());

            submenuDisciplina.editarDisciplina(sigla, disciplina);
            System.out.println("Dados alterados com sucesso.");

        } else {
            System.out.println("Não existe disciplina cadastrada com essa sigla.");
        }
    }


    private static Disciplina criarDisciplina(SubmenuDisciplina submenuDisciplina) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a sigla: ");
        String sigla = scanner.nextLine();
        if (submenuDisciplina.existeDisciplina(sigla)) {
            System.out.println("Sigla já cadastrada.");
            return null;
        }
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Ementa: ");
        String ementa = scanner.nextLine();
        ArrayList<String> livrosBibliograficos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Livro bibliografia " + (i + 1) + ": ");
            livrosBibliograficos.add(scanner.nextLine());
        }
        System.out.print("Número de créditos: ");
        Integer numeroCreditos = scanner.nextInt();
        System.out.print("Carga horária: ");
        Integer caragaHoraria = scanner.nextInt();

        return new Disciplina(sigla, nome, ementa, livrosBibliograficos, numeroCreditos, caragaHoraria);

    }

    private static void listarUmaDisciplina(SubmenuDisciplina submenuDisciplina) {

        Disciplina disciplina = submenuDisciplina.listarDisciplinaPorSigla(obterSigla());

        if (disciplina != null) {
            System.out.println(disciplina);
        } else {
            System.out.println("Não existe disciplina cadastrada com essa sigla.");
        }

    }

    private static String obterSigla() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nSigla da disciplina: ");
        return scanner.nextLine();
    }


    private static Professor criarProfessor(SubmenuProfessor submenuProfessor) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Registro funcional: ");
        String registroFuncional = scanner.nextLine();
        if (submenuProfessor.existeProfessor(registroFuncional)) {
            System.out.println("Registro funcional já cadastrado.");
            return null;
        }
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Sexo: ");
        String sexo = scanner.nextLine();
        System.out.print("Área de pesquisa: ");
        String areaPesquisa = scanner.nextLine();
        System.out.print("Universidade: ");
        String universidade = scanner.nextLine();

        ArrayList<String> emails = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("E-mail " + (i + 1) + ": ");
            emails.add(scanner.nextLine());
        }

        ArrayList<String> telefones = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Telefone " + (i + 1) + ": ");
            telefones.add(scanner.nextLine());
        }


        return new Professor(registroFuncional, nome, dataNascimento, sexo, areaPesquisa, universidade, emails, telefones);

    }


    private static void alterarDadosProfessor(SubmenuProfessor submenuProfessor) {

        Scanner scanner = new Scanner(System.in);

        String registroFuncional = obterRegistroFuncional();

        if (submenuProfessor.existeProfessor(registroFuncional)) {

            Professor professor = submenuProfessor.listarProfessorPorRegistro(registroFuncional);

            System.out.println("Alterar dados do(a) professor(a): " + professor.getNome());
            System.out.print("Área de pesquisa: ");
            professor.setAreaPesquisa(scanner.nextLine());
            System.out.print("Universidade: ");
            professor.setUniversidade(scanner.nextLine());

            submenuProfessor.editarProfessor(registroFuncional, professor);
            System.out.println("\nDados alterados com sucesso.");

        } else {
            System.out.println("Não existe professor cadastrado com esse Registro Funcional.");
        }
    }

    private static void excluirRegistroProfessor(SubmenuProfessor submenuProfessor) {

        Scanner scanner = new Scanner(System.in);

        String registroFuncional = obterRegistroFuncional();

        Professor professor = submenuProfessor.listarProfessorPorRegistro(registroFuncional);

        if (professor != null) {
            System.out.println("Excluir dados do(a) professor(a) " + professor.getNome() + "?\n" +
                    "Digite \"S\" para confirmar ou qualquer outro botão para cancelar: ");
            String confirmacao = scanner.nextLine();

            if (confirmacao.equalsIgnoreCase("S")) {
                submenuProfessor.excluirProfessor(registroFuncional);
                System.out.println("\nRegistro excluído com sucesso.");
            } else {
                System.out.println("\nExclusão cancelada.");
            }

        } else {
            System.out.println("Não existe professor cadastrado com esse Registro Funcional.");
        }

    }

    private static void listarUmProfessor(SubmenuProfessor submenuProfessor) {

        String registroFuncional = obterRegistroFuncional();

        Professor professor = submenuProfessor.listarProfessorPorRegistro(registroFuncional);

        if (professor != null) {
            System.out.println(professor);
        } else {
            System.out.println("Não existe professor cadastrado com esse Registro Funcional.");
        }

    }

    private static String obterRegistroFuncional() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nRegistro funcional: ");
        return scanner.nextLine();
    }


    private static int mostraMenuPrincipal() {

        Scanner scanner = new Scanner(System.in);

        String menuPrincipal = "\n-------- MENU PRINCIPAL --------\n\n" +
                "\t1. Submenu de Professores\n" +
                "\t2. Submenu de Disciplinas\n" +
                "\t3. Sair\n\n" +
                "Digite a opção desejada: ";

        System.out.print(menuPrincipal);
        return scanner.nextInt();
    }


    private static int mostraSubmenuProfessor() {

        Scanner scanner = new Scanner(System.in);

        String submenuProfessor = "\n-------- SUBMENU PROFESSOR  --------\n\n" +
                "\t1. Listar todos os professores\n" +
                "\t2. Listar um professor\n" +
                "\t3. Cadastrar professor\n" +
                "\t4. Alterar dados de um professor\n" +
                "\t5. Excluir dados de um profesor\n" +
                "\t6. Sair\n\n" +
                "Digite a opção desejada: ";

        System.out.print(submenuProfessor);
        return scanner.nextInt();
    }

    private static int mostraSubmenuDisciplina() {

        Scanner scanner = new Scanner(System.in);

        String submenuDisciplina = "\n-------- SUBMENU DISCIPLINA  --------\n\n" +
                "\t1. Listar todos as disciplinas\n" +
                "\t2. Listar uma disciplina\n" +
                "\t3. Cadastrar disciplina\n" +
                "\t4. Alterar dados de uma disciplina\n" +
                "\t5. Excluir dados de uma disciplina\n" +
                "\t6. Sair\n\n" +
                "Digite a opção desejada: ";

        System.out.print(submenuDisciplina);
        return scanner.nextInt();
    }


    private static SubmenuProfessor criaDadosProfessores() {

        ArrayList<String> emails = new ArrayList<>();
        emails.add("minerva@mail.com");
        emails.add("mcgonagall@mail.com");

        ArrayList<String> telefones = new ArrayList<>();
        telefones.add("(16)998562544");
        telefones.add("(16)998854544");
        telefones.add("(16)998562958");

        Professor p1 = new Professor("1212589-45",
                "Minerva McGonagall",
                "13/11/1967",
                "feminino",
                "Transfiguração",
                "USP",
                emails,
                telefones);

        ArrayList<String> emails2 = new ArrayList<>();
        emails2.add("hagrid@mail.com");
        emails2.add("rubeo@mail.com");
        emails2.add("rubeohagrid@mail.com");

        ArrayList<String> telefones2 = new ArrayList<>();
        telefones2.add("(16)998547125");
        telefones2.add("(16)945854544");
        telefones2.add("(16)998964515");

        Professor p2 = new Professor("1523659-21",
                "Rúbeo Hagrid",
                "06/12/1928",
                "masculino",
                "Biologia",
                "Ufscar",
                emails2,
                telefones2);

        ArrayList<String> emails3 = new ArrayList<>();
        emails3.add("snape@mail.com");
        emails3.add("severo@mail.com");

        ArrayList<String> telefones3 = new ArrayList<>();
        telefones3.add("(16)985412653");
        telefones3.add("(16)988542651");

        Professor p3 = new Professor("8523652-14",
                "Severo Snape",
                "09/01/1960",
                "masculino",
                "Quimica",
                "USP",
                emails3,
                telefones3);

        ArrayList<String> emails4 = new ArrayList<>();
        emails4.add("lupin@mail.com");
        emails4.add("remo@mail.com");
        emails4.add("remolupin@mail.com");

        ArrayList<String> telefones4 = new ArrayList<>();
        telefones4.add("(16)998256325");
        telefones4.add("(16)988484561");

        Professor p4 = new Professor("1256329-65",
                "Remo Lupin",
                "10/03/1960",
                "masculino",
                "Física",
                "Ufscar",
                emails4,
                telefones4);

        SubmenuProfessor submenuProfessor = new SubmenuProfessor();
        submenuProfessor.cadastrarProfessor(p1);
        submenuProfessor.cadastrarProfessor(p2);
        submenuProfessor.cadastrarProfessor(p3);
        submenuProfessor.cadastrarProfessor(p4);
        return submenuProfessor;
    }



    private static SubmenuDisciplina criaDadosDisciplinas() {

        ArrayList<String> livros = new ArrayList<>();
        livros.add("POO na prática");
        livros.add("JavaScript na prática");
        livros.add("Engenharia na prática");
        livros.add("Calculando");


        Disciplina d1 = new Disciplina("1001", "Programação Orientada a Objetos", "1000123-12", livros, 8, 120);
        Disciplina d2 = new Disciplina("1002", "Programação WEB", "1000133-03", livros, 4, 60);
        Disciplina d3 = new Disciplina("1003", "Engenharia de Software", "1000177-08", livros, 8, 120);
        Disciplina d4 = new Disciplina("1004", "Probabilidade e Estatística", "1000144-79", livros, 8, 120);

        SubmenuDisciplina submenuDisciplina = new SubmenuDisciplina();
        submenuDisciplina.cadastrarDisciplina(d1);
        submenuDisciplina.cadastrarDisciplina(d2);
        submenuDisciplina.cadastrarDisciplina(d3);
        submenuDisciplina.cadastrarDisciplina(d4);

        return submenuDisciplina;


    }

}
