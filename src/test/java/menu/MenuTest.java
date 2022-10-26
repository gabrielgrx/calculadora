package menu;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class MenuTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream(); //permite escrever

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule().enableLog(); // permite ler

    @Test
    public void deveVoltarAoMenuQuandoNaoEscolherOpcaoValidaEDesligar() {
        systemInMock.provideLines("9","a","0");

        Menu menu = new Menu();
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Você deve escolher umas das opções válidas."));
        assertTrue(saida.contains("O argumento digitado é invalido. Você tem que escolher um número dentre as opções."));
        assertTrue(saida.contains("0. Desligar calculadora"));
    }

    @Test
    public void deveSomarEDesligar() {
        systemInMock.provideLines("1","1","2","2","0");

        Menu menu = new Menu();
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Soma"));
        assertTrue(saida.contains("4.0"));
        assertTrue(saida.contains("DESLIGANDO"));
    }
    @Test
    public void deveSomarEVoltarAoMenuEDesligar() {
        systemInMock.provideLines("1","1","2","2","9","0");

        Menu menu = new Menu();
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Soma"));
        assertTrue(saida.contains("4.0"));
    }
}