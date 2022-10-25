package calculadora;

import java.util.Scanner;

public class CalculadoraPadrao implements Calculadora{

    private int opcao;
    private boolean calculadoraLigada = true;

    public CalculadoraPadrao() {
        calcular();
    }

    @Override
    public void calcular() {

        while (this.calculadoraLigada) {
            System.out.println("#### CALCULADORA PADRÃO ####");
            System.out.println("Escolha uma das operaçãos aritiméticas abaixo:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Divisão");
            System.out.println("4. Multiplicação");
            System.out.println("0. Desligar calculadora");

            Scanner scanner = new Scanner(System.in);
            int opcaoCalcular = scanner.nextInt();

            switch (opcaoCalcular) {
                case 1 -> soma();
                case 2 -> subtracao();
                case 3 -> divisao();
                case 4 -> multiplicacao();
                case 0 -> desligar();
                default -> {
                    System.out.println("Você não selecionou nenhuma das opções apresentadas. Selecione alguma das opções");
                }
            }
        }
    }

    @Override
    public void desligar() {
        System.out.println("## DESLIGANDO CALCULADORA ##");
        this.calculadoraLigada = false;
    }

    private static void soma() {
        System.out.println("Digite os 2 números que deseja somar:");
        Scanner numero1 = new Scanner(System.in);
        Scanner numero2 = new Scanner(System.in);
        double num1 = numero1.nextDouble();
        double num2 = numero2.nextDouble();
        System.out.println(num1 + num2);
    }

    private static void subtracao() {
        System.out.println("Digite os 2 números que deseja subtrair:");
        Scanner numero1 = new Scanner(System.in);
        Scanner numero2 = new Scanner(System.in);
        double num1 = numero1.nextDouble();
        double num2 = numero2.nextDouble();
        System.out.println(num1 - num2);
    }

    private static void divisao() {
        try {
            System.out.println("Digite os 2 números que deseja dividir:");
            Scanner numero1 = new Scanner(System.in);
            Scanner numero2 = new Scanner(System.in);
            double num1 = numero1.nextDouble();
            double num2 = numero2.nextDouble();
            System.out.println(num1 / num2);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
    }

    private static void multiplicacao() {
        System.out.println("Digite os 2 números que deseja multiplicar:");
        Scanner numero1 = new Scanner(System.in);
        Scanner numero2 = new Scanner(System.in);
        double num1 = numero1.nextDouble();
        double num2 = numero2.nextDouble();
        System.out.println(num1 * num2);
    }


    public int getOpcao() {
        return opcao;
    }

    public void setOpcao(int opcao) {
        this.opcao = opcao;
    }
}
