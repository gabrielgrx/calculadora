package calculadora;

import menu.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraImc implements Calculadora {
    private float peso;
    private float altura;
    private int genero;
    private double imc;
    private String condicao;

    public CalculadoraImc() {
        calcular();
    }

    @Override
    public void calcular() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("#### CALCULADORA IMC ####");
        calcularImc();
        imcGenero();
        System.out.printf("O seu IMC é de %.2f e você está %s",this.imc, this.condicao);
        calcularNovoImcOuDesligarCalculadora();
    }

    @Override
    public void desligar() {
        System.out.println("## DESLIGANDO CALCULADORA ##");
    }

    private double calcularImc() throws InputMismatchException, IllegalArgumentException, ArithmeticException {
        System.out.println("Qual seu peso em kg?");
        Scanner peso = new Scanner(System.in);
        this.peso = peso.nextFloat();
        System.out.println("Qual sua altura em metros?");
        Scanner altura = new Scanner(System.in);
        this.altura = altura.nextFloat();

        this.imc = this.peso / (this.altura * this.altura);
        return this.imc;
    }


    private String imcGenero() throws InputMismatchException, IllegalArgumentException {
        System.out.println("Digite 1 se você for homem e 2 se for mulher:");
        System.out.println("1. Homem");
        System.out.println("2. Mulher");
        Scanner genero = new Scanner(System.in);
        this.genero = genero.nextInt();

        if (this.genero == 1) {
            if (this.imc < 19.1f) {
                this.condicao = "abaixo do peso";
            } else if (this.imc <= 25.8f) {
                this.condicao = "no peso normal";
            } else if (this.imc <= 27.3f) {
                this.condicao = "marginalmente acima do peso";
            } else if (this.imc <= 32.3) {
                this.condicao = "acima do peso ideal";
            } else {
                this.condicao = "obeso";
            }
        } else if (this.genero == 2) {
            if (this.imc < 20.7f) {
                this.condicao = "abaixo do peso";
            } else if (this.imc <= 26.4f) {
                this.condicao = "no peso normal";
            } else if (this.imc <= 27.8f) {
                this.condicao = "marginalmente acima do peso";
            } else if (this.imc <= 31.1) {
                this.condicao = "acima do peso ideal";
            } else {
                this.condicao = "obeso";
            }
        } else {
            System.out.println("Você precisa escolher alguma das opções.");
            imcGenero();
        }
        return this.condicao;
    }

    private void calcularNovoImcOuDesligarCalculadora() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Você gostaria de calcular um novo IMC ou gostaria de desligar a calculadora?");
        System.out.println("1. Calcular novo IMC");
        System.out.println("9. Voltar ao menu principal");
        System.out.println("0. Desligar Calculadora");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            calcular();
        } else if (opcao == 0) {
            desligar();
        } else if (opcao == 9) {
            Menu.escolha();
        } else {
            System.out.println("Digite alguma opção válida");
            calcularNovoImcOuDesligarCalculadora();
        }
    }
}
