package curso;

public class Disciplina {

    private String sigla;
    private String nome;
    private String ementa;
    private String livroBibliografia;
    private Integer numeroCreditos;
    private Integer caragaHoraria;

    public Disciplina() {
    }

    public Disciplina(String sigla, String nome, String ementa, String livroBibliografia, Integer numeroCreditos, Integer caragaHoraria) {
        this.sigla = sigla;
        this.nome = nome;
        this.ementa = ementa;
        this.livroBibliografia = livroBibliografia;
        this.numeroCreditos = numeroCreditos;
        this.caragaHoraria = caragaHoraria;
    }

    public String getSigla() {
        return sigla;
    }

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

    public String getLivroBibliografia() {
        return livroBibliografia;
    }

    public void setLivroBibliografia(String livroBibliografia) {
        this.livroBibliografia = livroBibliografia;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public Integer getCaragaHoraria() {
        return caragaHoraria;
    }

    public void setCaragaHoraria(Integer caragaHoraria) {
        this.caragaHoraria = caragaHoraria;
    }

    @Override
    public String toString() {
        return "Disciplina: [" +
                "Sigla: '" + sigla + '\'' +
                " | Nome: '" + nome + '\'' +
                " | ementa: '" + ementa + '\'' +
                " | livroBibliografia: '" + livroBibliografia + '\'' +
                " | numeroCreditos: " + numeroCreditos +
                " | caragaHoraria: " + caragaHoraria +
                ']';
    }
}
