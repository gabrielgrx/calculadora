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
    public void deveVoltarAoMenuQuandoNaoEscolherOpcaoValidaEEscolherSoma() {
        systemInMock.provideLines("9","a");

        Menu menu = new Menu();
        String saida = systemOutRule.getLog();

        assertTrue(saida.contains("Você deve escolher umas das opções válidas."));
        assertTrue(saida.contains("O argumento digitado é invalido. Você tem que escolher um número dentre as opções."));
    }

}