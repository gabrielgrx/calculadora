package menu;

import calculadora.CalculadoraArea;
import calculadora.CalculadoraImc;
import calculadora.CalculadoraPadrao;

import java.util.Scanner;

public class Menu {
    private int opcao;

    public Menu() {
        System.out.println("#### CALCULADORA ####");
        System.out.println("Digite o número correspondente a calculadora que deseja utilizar");
        System.out.println("1. Calculadora Padrão");
        System.out.println("2. Calculadora IMC");
        System.out.println("3. Calculadora Área");
        System.out.println("0. Desligar calculadora");
        escolha();
    }

    private void escolha() {
        Scanner scanner = new Scanner(System.in);
        this.setOpcao(scanner.nextInt());
        switch (this.getOpcao()) {
            case 1:
                CalculadoraPadrao calculadoraPadrao = new CalculadoraPadrao();
                break;
            case 2:
                CalculadoraImc calculadoraImc = new CalculadoraImc();
                break;
            case 3:
                CalculadoraArea calculadoraArea = new CalculadoraArea();
                break;
            case 0:
                desligarCalculadora();
                break;
            default:
        }
    }

    private static void desligarCalculadora(){
        System.out.println("## DESLIGANDO CALCULADORA ##");
    }

    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
}
