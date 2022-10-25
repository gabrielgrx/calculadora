package calculadora;

import menu.Menu;

import java.util.Scanner;

public class CalculadoraArea implements Calculadora{
    private boolean calculadoraLigada = true;
    private float pi = 3.14f;

    public CalculadoraArea() {
        calcular();
    }
    @Override
    public void calcular() {
        while (this.calculadoraLigada) {
            System.out.println("#### CALCULADORA Área ####");
            System.out.println("Escolha uma das operaçãos abaixo:");
            System.out.println("1. Área do circulo");
            System.out.println("2. Área do retangulo");
            System.out.println("9. Voltar ao menu principal");
            System.out.println("0. Desligar calculadora");

            Scanner scanner = new Scanner(System.in);
            int opcaoCalcular = scanner.nextInt();

            switch (opcaoCalcular) {
                case 1 -> areaCirculo();
                case 2 -> areaRetangulo();
                case 9 -> Menu.escolha();
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

    private void areaCirculo() {
        System.out.println("Digite o raio do circulo:");
        Scanner scanner = new Scanner(System.in);
        double raio = scanner.nextDouble();
        double area = (raio * raio) * this.pi;
        System.out.println("A área do circulo é de : "+ area);
    }

    private void areaRetangulo() {
        System.out.println("Digite a base do retangulo:");
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        System.out.println("Digite a altura do retangulo:");
        Scanner scanner2 = new Scanner(System.in);
        double altura = scanner2.nextDouble();
        double area = base * altura;
        System.out.println("A área do retangulo é de : "+ area);
    }

    public boolean isCalculadoraLigada() {
        return calculadoraLigada;
    }

    public void setCalculadoraLigada(boolean calculadoraLigada) {
        this.calculadoraLigada = calculadoraLigada;
    }

    public float getPi() {
        return pi;
    }

    public void setPi(float pi) {
        this.pi = pi;
    }
}
