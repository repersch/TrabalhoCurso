package curso;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {

    static Disciplina disciplina;

    @BeforeAll
    public static void init() {

        ArrayList<String> bibliografiaInicial = new ArrayList<>();
        bibliografiaInicial.add("Livro sobre Programação 1");
        bibliografiaInicial.add("Livro sobre Banco de Dados");
        bibliografiaInicial.add("Livro sobre Redes de Computadores");

        disciplina = new Disciplina("INTC", "Introdução à Computação", "Noções básicas de computação", bibliografiaInicial, 8, 80);

    }

    @Order(1)
    @DisplayName("Teste de Get e Set - sigla da Disciplina")
    @ParameterizedTest
    @ValueSource(strings = {"PW1", "AP1", "BDS1"})
    void getSetSigla(String sigla) {
        disciplina.setSigla(sigla);

        assertAll(
                () -> assertEquals(sigla, disciplina.getSigla()),
                () -> assertNotEquals("POO", disciplina.getSigla())
        );
    }

    @Order(2)
    @DisplayName("Teste de Get e Set - nome da Disciplina")
    @ParameterizedTest
    @ValueSource(strings = {"Programação para Web", "Algoritmo e Programação", "Banco de Dados"})
    void getSetNome(String nome) {

        disciplina.setNome(nome);

        assertAll(
                () -> assertEquals(nome, disciplina.getNome()),
                () -> assertNotEquals("Programação Orientada a Objetos", disciplina.getNome())
        );
    }

    @Order(3)
    @DisplayName("Teste de Get e Set - ementa")
    @ParameterizedTest
    @ValueSource(strings = {"Desenvolvimento de aplicativos Web", "Conceitos básicos de lógica de programação", "Conceitos básicos de banco de dados"})
    void getSetEmenta(String ementa) {

        disciplina.setEmenta(ementa);

        assertAll(
                () -> assertEquals(ementa, disciplina.getEmenta()),
                () -> assertNotEquals("teste", disciplina.getEmenta())
        );
    }



    @Order(4)
    @DisplayName("Teste de Get e Set - Bibliografia")
    @Test
    void getSetBibliografia() {

        ArrayList<String> bibliografia = new ArrayList<>();
        bibliografia.add("JavaScript: O Guia Definitivo(2012)");
        bibliografia.add("Algoritmos: Teoria e Prática(2015)");
        bibliografia.add("Banco de dados - Projeto e Implementação (2018)");

        disciplina.setLivrosBibliografia(bibliografia);

        assertLinesMatch(disciplina.getLivrosBibliografia(), bibliografia);
    }


    @Order(5)
    @DisplayName("Teste de Get e Set - Créditos")
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 8})
    void getSetNumeroCreditos(int creditos) {
        disciplina.setNumeroCreditos(creditos);
        assertAll(
                () -> assertEquals(creditos, disciplina.getNumeroCreditos()),
                () -> assertNotEquals(12, disciplina.getNumeroCreditos())
        );
    }

    @Order(6)
    @DisplayName("Teste de Get e Set - Carga Horária")
    @ParameterizedTest
    @ValueSource(ints = {40, 80, 120})
    void getCaragaHoraria(int cargaHoraria) {
        disciplina.setCargaHoraria(cargaHoraria);
        assertAll(
                () -> assertEquals(cargaHoraria, disciplina.getCargaHoraria()),
                () -> assertNotEquals(250, disciplina.getCargaHoraria())
        );
    }

}