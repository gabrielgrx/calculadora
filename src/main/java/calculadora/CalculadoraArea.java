package calculadora;

import menu.Menu;

import java.util.Scanner;

public class CalculadoraArea implements Calculadora {
    private boolean statusCalculadora = true;
    private final float pi = 3.14f;
    public CalculadoraArea() {
        calcular();
    }

    @Override
    public void calcular() {
        while (this.statusCalculadora) {
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
                case 9 -> {
                    Menu.escolha();
                    this.statusCalculadora = false;
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

    private void areaCirculo() {
        System.out.println("Digite o raio do circulo em metros:");
        Scanner scanner = new Scanner(System.in);
        double raio = scanner.nextDouble();
        double area = (raio * raio) * this.pi;
        System.out.println("A área do circulo é de : " + area + "m");
    }

    private void areaRetangulo() {
        System.out.print("Digite a base do retangulo em metros:");
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        System.out.print("Digite a altura do retangulo em metros:");
        Scanner scanner2 = new Scanner(System.in);
        double altura = scanner2.nextDouble();
        double area = base * altura;
        System.out.print("A área do retangulo é de : " + area+"m");
    }
}
