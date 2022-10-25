package menu;

import calculadora.CalculadoraArea;
import calculadora.CalculadoraImc;
import calculadora.CalculadoraPadrao;

import java.util.Scanner;

public class Menu {

    public Menu() {
        escolha();
    }

    public static void escolha() {

        System.out.println("#####################");
        System.out.println("#### CALCULADORA ####");
        System.out.println("#####################");

        System.out.println("Digite o número correspondente a calculadora que deseja utilizar");
        System.out.println("1. Calculadora Padrão");
        System.out.println("2. Calculadora IMC");
        System.out.println("3. Calculadora Área");
        System.out.println("0. Desligar calculadora");

        try {
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            switch (opcao) {
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
                    System.out.println("Você deve escolher umas das opções válidas.");
                    escolha();
            }
        } catch (Exception e){
            System.out.println("O argumento digitado é invalido. Você tem que escolher um número dentre as opções.");
            escolha();
        }
    }

    private static void desligarCalculadora() {
        System.out.println("## DESLIGANDO CALCULADORA ##");
    }

    private static String digitarOpcaoValida(){
        Scanner entrada = new Scanner(System.in);
        System.out.print("O argumento digitado é invalido. Você tem que escolher um número dentre as opções.");
        return entrada.nextLine();
    }
}
