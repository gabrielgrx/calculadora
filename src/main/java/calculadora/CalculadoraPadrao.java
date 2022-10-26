package calculadora;

import menu.Menu;

import java.util.Scanner;

public class CalculadoraPadrao implements Calculadora {

    private int opcao;
    private boolean statusCalculadora = true;

    public CalculadoraPadrao() {
        calcular();
    }

    @Override
    public void calcular() {

        while (this.statusCalculadora) {
            System.out.println("#### CALCULADORA PADRÃO ####");
            System.out.println("Escolha uma das operaçãos aritiméticas abaixo:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Divisão");
            System.out.println("4. Multiplicação");
            System.out.println("9. Voltar ao menu principal");
            System.out.println("0. Desligar calculadora");

            Scanner scanner = new Scanner(System.in);
            int opcaoCalcular = scanner.nextInt();

            switch (opcaoCalcular) {
                case 1 -> soma();
                case 2 -> subtracao();
                case 3 -> divisao();
                case 4 -> multiplicacao();
                case 9 -> {
                    this.statusCalculadora = false;
                    Menu.escolha();
                }
                case 0 -> desligar();
                default -> System.out.println("Você não selecionou nenhuma das opções apresentadas. Selecione alguma das opções");
            }
        }
    }

    @Override
    public void desligar() {
        System.out.println("## DESLIGANDO CALCULADORA ##");
        this.statusCalculadora = false;
    }

    private static void soma() {
        System.out.println("Digite os 2 números que deseja somar:");
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        System.out.println("A soma dos números " + num1 + " e " + num2 + " é igual a: " + (num1 + num2));
    }

    private static void subtracao() {
        System.out.println("Digite os 2 números que deseja subtrair:");
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        System.out.println("A subtração do número " + num1 + " pelo " + num2 + " é igual a: " + (num1 - num2));
    }

    private static void divisao() {
        try {
            System.out.println("Digite os 2 números que deseja dividir:");
            Scanner scanner = new Scanner(System.in);
            double num1 = scanner.nextDouble();
            double num2 = scanner.nextDouble();
            System.out.println("A divisão do número " + num1 + " pelo " + num2 + " é igual a: " + (num1 / num2));
        } catch (ArithmeticException e) {
            System.out.println("Você não pode dividir por 0. Escolha outro número.");
            divisao();
        }
    }

    private static void multiplicacao() {
        System.out.println("Digite os 2 números que deseja multiplicar:");
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();
        System.out.println("A multiplicação do número " + num1 + " pelo " + num2 + " é igual a: " + (num1 * num2));
    }
}
