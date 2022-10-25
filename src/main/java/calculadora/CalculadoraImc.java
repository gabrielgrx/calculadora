package calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraImc implements Calculadora{
    private float peso;
    private float altura;
    private int genero;

    public CalculadoraImc() {
        calcular();
    }

    @Override
    public void calcular() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("#### CALCULADORA IMC ####");
        calcularImc();
        imcGenero();
        System.out.println("Seu IMC é de " + calcularImc() + " e você está " + imcGenero());
        calcularNovoImcOuDesligarCalculadora();
    }

    @Override
    public void desligar() {
        System.out.println("## DESLIGANDO CALCULADORA ##");
    }

    private float calcularImc() throws InputMismatchException, IllegalArgumentException, ArithmeticException {
        System.out.println("Qual seu peso em kg?");
        Scanner peso = new Scanner(System.in);
        this.peso = peso.nextFloat();
        System.out.println("Qual sua altura em metros?");
        Scanner altura = new Scanner(System.in);
        this.altura = altura.nextFloat();

        float imc = this.peso / (this.altura * this.altura);
        return imc;
    }


    private String imcGenero() throws InputMismatchException, IllegalArgumentException {
        System.out.println("Digite 1 se você for homem e 2 se for mulher:");
        System.out.println("1. Homem");
        System.out.println("2. Mulher");
        Scanner genero = new Scanner(System.in);
        this.setGenero(genero.nextInt());

        String condicao = null;
        if (this.genero == 1) {
            if (calcularImc() < 19.1f) {
                condicao = "abaixo do peso";
            } else if (calcularImc() <= 25.8f) {
                condicao = "no peso normal";
            } else if (calcularImc() <= 27.3f) {
                condicao = "marginalmente acima do peso";
            } else if (calcularImc() <= 32.3) {
                condicao = "acima do peso ideal";
            } else {
                condicao = "obeso";
            }
        } else if (this.genero == 2) {
            if (calcularImc() < 20.7f) {
                condicao = "abaixo do peso";
            } else if (calcularImc() <= 26.4f) {
                condicao = "no peso normal";
            } else if (calcularImc() <= 27.8f) {
                condicao = "marginalmente acima do peso";
            } else if (calcularImc() <= 31.1) {
                condicao = "acima do peso ideal";
            } else {
                condicao = "obeso";
            }
        }
        return condicao;
    }

    private void calcularNovoImcOuDesligarCalculadora() {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Você gostaria de calcular um novo IMC ou gostaria de desligar a calculadora?");
        System.out.println("1. Calcular novo IMC");
        System.out.println("2. Desligar Calculadora");
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            calcular();
        } else if (opcao == 2) {
            desligar();
        } else {
            System.out.println("Digite alguma opção válida");
            calcularNovoImcOuDesligarCalculadora();
        }
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
}
