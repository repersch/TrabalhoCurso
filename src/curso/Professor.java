package curso;

import java.util.ArrayList;

public class Professor {

    private String registroFuncional;
    private String nome;
    private String dataNascimento;
    private String sexo;
    private String areaPesquisa;
    private String universidade;
    private ArrayList<String> emails = new ArrayList<>();
    private ArrayList<String> telefones = new ArrayList<>();

    public Professor() {
    }

    public Professor(String registroFuncional, String nome, String dataNascimento, String sexo, String areaPesquisa, String universidade, ArrayList<String> emails, ArrayList<String> telefones) {
        this.registroFuncional = registroFuncional;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.areaPesquisa = areaPesquisa;
        this.universidade = universidade;
        this.emails = emails;
        this.telefones = telefones;
    }

    public void adicionaEmail (String email) {
        if (email != null) {
            emails.add(email);
        }
    }

    public void adicionaTelefone (String telefone) {
        if (telefone != null) {
            telefones.add(telefone);
        }
    }

    public String getRegistroFuncional() {
        return registroFuncional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getAreaPesquisa() {
        return areaPesquisa;
    }

    public void setAreaPesquisa(String areaPesquisa) {
        this.areaPesquisa = areaPesquisa;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public void setEmails(ArrayList<String> emails) {
        this.emails = emails;
    }

    public ArrayList<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Professor: [" +
                "Registro Funcional: '" + registroFuncional + '\'' +
                "| Nome: '" + nome + '\'' +
                "| Data de nascimento: " + dataNascimento +
                "| Sexo: '" + sexo + '\'' +
                "| Área de pesquisa: '" + areaPesquisa + '\'' +
                "| Universidade: '" + universidade + '\'' +
                "| E-mails: '" + emails + '\'' +
                "| Telefones: '" + telefones + '\'' +
                ']';
    }
}
