package curso;

import java.util.ArrayList;

public class Disciplina {

    private String sigla;
    private String nome;
    private String ementa;
    private ArrayList<String> livrosBibliografia;
    private Integer numeroCreditos;
    private Integer cargaHoraria;

    public Disciplina() {
    }

    public Disciplina(String sigla, String nome, String ementa, ArrayList<String> livrosBibliografia, Integer numeroCreditos, Integer caragaHoraria) {
        this.sigla = sigla;
        this.nome = nome;
        this.ementa = ementa;
        this.livrosBibliografia = livrosBibliografia;
        this.numeroCreditos = numeroCreditos;
        this.cargaHoraria = caragaHoraria;
    }

    public void adicionaLivro(String livro) {
        if (livro != null) {
            livrosBibliografia.add(livro);
        }
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla){ this.sigla = sigla; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<String> getLivrosBibliografia() {
        return livrosBibliografia;
    }

    public void setLivrosBibliografia(ArrayList<String> livrosBibliografia) {
        this.livrosBibliografia = livrosBibliografia;
    }

    @Override
    public String toString() {
        return "Disciplina [" +
                "Sigla: '" + sigla + '\'' +
                " | Nome: '" + nome + '\'' +
                " | Ementa: '" + ementa + '\'' +
                " | Livros Bibliografia: " + livrosBibliografia +
                " | Número de Créditos: " + numeroCreditos +
                " | Carga Horária: " + cargaHoraria +
                ']';
    }
}
