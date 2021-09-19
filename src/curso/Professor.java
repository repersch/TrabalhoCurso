package curso;

import java.time.LocalDateTime;
import java.util.Date;

public class Professor {

    private String registroFuncional;
    private String nome;
    private String dataNascimento;
    private String sexo;
    private String areaPesquisa;
    private String universidade;
    private String email;
    private String telefone;

    public Professor() {
    }

    public Professor(String registroFuncional, String nome, String dataNascimento, String sexo, String areaPesquisa, String universidade, String email, String telefone) {
        this.registroFuncional = registroFuncional;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.areaPesquisa = areaPesquisa;
        this.universidade = universidade;
        this.email = email;
        this.telefone = telefone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
                "| E-mail: '" + email + '\'' +
                "| Telefone: '" + telefone + '\'' +
                ']';
    }
}
