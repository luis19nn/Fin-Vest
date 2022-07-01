package com.finvest;

import java.util.InputMismatchException;
import java.util.Scanner;
import utils.Helper;

public final class App {

    /**
     * MAIN
     */

    public static void main(String[] args) {
        menu();
    }

    /**
     * MENU
     */

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        double valorCapital = 0.0, taxaJuros = 0.0;
        int prazoInvestimento = 0, opcao = 0;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n\n#####################################");
            System.out.println("############ BEM-VINDO(A) ###########");
            System.out.println("############   FIN-VEST   ###########");
            System.out.println("#####################################");

            System.out.println("\nSelecione uma opção abaixo: ");
            System.out.println("1 - Definir Valores");
            System.out.println("2 - Verificar o Valor Final do Capital Investido");
            System.out.println("3 - Verificar o Resultado Obtido Mês a Mês");
            System.out.println("4 - Verificar Quanto Representa a Taxa de Juros no Valor Final");
            System.out.println("5 - Sair do Sistema");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    while (true) {
                        try {
                            System.out.printf("\nInforme o valor do capital a ser investido, em reais: ");
                            valorCapital = sc.nextDouble();

                            System.out.printf("\nInforme o prazo do investimento, em meses: ");
                            prazoInvestimento = sc.nextInt();

                            System.out.printf("\nInforme a taxa de juros da aplicação, em decimal: ");
                            taxaJuros = sc.nextDouble();

                            if (valorCapital > 0.0 && prazoInvestimento > 0.0 && taxaJuros > 0.0) {
                                break;
                            } else {
                                throw new InputMismatchException();
                            }
                        } catch (InputMismatchException e) {
                            System.out.printf("\nInforme um valor válido!\n\n");
                        } finally {
                            Helper.clearBuffer(sc);
                        }
                    }

                    System.out.println("\nOs valores foram definidos com sucesso!");

                    break;
                case 2:
                    if (valorCapital > 0.0 && prazoInvestimento > 0.0 && taxaJuros > 0.0) {
                        valorFinalCapitalInvestidoView(valorCapital, prazoInvestimento, taxaJuros);
                    } else {
                        System.out.println("\nEspere! Defina os valores primeiro, antes de utilizar o sistema!" +
                                "\nNão esqueça que só é aceito número positivos maiores que zero!");
                    }

                    break;
                case 3:
                    if (valorCapital > 0.0 && prazoInvestimento > 0.0 && taxaJuros > 0.0) {
                        resultadoMesAMesView(valorCapital, prazoInvestimento, taxaJuros);
                    } else {
                        System.out.println("\nEspere! Defina os valores primeiro, antes de utilizar o sistema!");
                    }

                    break;
                case 4:
                    if (valorCapital > 0.0 && prazoInvestimento > 0.0 && taxaJuros > 0.0) {
                        taxaJurosValorFinalView(valorCapital, prazoInvestimento, taxaJuros);
                    } else {
                        System.out.println("\nEspere! Defina os valores primeiro, antes de utilizar o sistema!");
                    }

                    break;
                case 5:
                    System.out.println("\nVolte sempre!\n");
                    continuar = false;

                    break;
                default:
                    System.out.println("\nOpção inválida!\n");

                    break;
            }
        }

        sc.close();
    }

    /**
     * MÉTODOS DE RENTABILIDADE
     */

    public static double valorFinalCapitalInvestido(double valorCapital, int prazoInvestimento, double taxaJuros) {
        if (valorCapital <= 0.0 || prazoInvestimento <= 0.0 || taxaJuros <= 0.0) {
            throw new InputMismatchException();
        }

        double valorFinal = 0.0;

        valorFinal = valorCapital * Math.pow(1 + taxaJuros, prazoInvestimento);
        valorFinal = Math.floor(valorFinal * 100) / 100;

        return valorFinal;
    }

    public static double[][] resultadoMesAMes(double valorCapital, int prazoInvestimento, double taxaJuros) {
        if (valorCapital <= 0.0 || prazoInvestimento <= 0.0 || taxaJuros <= 0.0) {
            throw new InputMismatchException();
        }

        double[][] valorFinal = new double[prazoInvestimento][2];

        for (int i = 0; i < prazoInvestimento; i++) {
            valorFinal[i][0] = valorCapital * Math.pow(1 + taxaJuros, (i + 1));
            valorFinal[i][0] = Math.floor(valorFinal[i][0] * 100) / 100;

            if (i == 0) {
                valorFinal[i][1] = valorCapital * taxaJuros;
            } else {
                valorFinal[i][1] = valorFinal[i - 1][0] * taxaJuros;
            }
            valorFinal[i][1] = Math.floor(valorFinal[i][1] * 100) / 100;
        }

        return valorFinal;
    }

    public static double taxaJurosValorFinal(double valorCapital, int prazoInvestimento, double taxaJuros) {
        if (valorCapital <= 0.0 || prazoInvestimento <= 0.0 || taxaJuros <= 0.0) {
            throw new InputMismatchException();
        }

        double capitalFinal = 0.0, taxaFinal = 0.0;

        capitalFinal = valorCapital * Math.pow(1 + taxaJuros, prazoInvestimento - 1);
        taxaFinal = capitalFinal * taxaJuros;
        taxaFinal = Math.floor(taxaFinal * 100) / 100;

        return taxaFinal;
    }

    /**
     * VIEWS PARA OS MÉTODOS DE RENTABILIDADE
     */

    public static void valorFinalCapitalInvestidoView(double valorCapital, int prazoInvestimento, double taxaJuros) {
        double valorFinal = valorFinalCapitalInvestido(valorCapital, prazoInvestimento, taxaJuros);

        System.out.println("\n#####################################");
        System.out.printf("O valor final do capital investido após o período informado é de: %.2f", valorFinal);
        System.out.println("\n#####################################");
    }

    public static void resultadoMesAMesView(double valorCapital, int prazoInvestimento, double taxaJuros) {
        double[][] resMes = resultadoMesAMes(valorCapital, prazoInvestimento, taxaJuros);

        System.out.println("\n#####################################");
        System.out.println("O resultado mês a mês do seu investimento é de: \n");

        System.out.printf("|Capital            |Juros no Mês       |\n");
        System.out.printf("|---------------------------------------|\n");

        for (int i = 0; i < prazoInvestimento; i++) {
            System.out.printf("|R$%.2f          |R$%.2f           |\n", resMes[i][0], resMes[i][1]);
        }

        System.out.println("\n#####################################");
    }

    public static void taxaJurosValorFinalView(double valorCapital, int prazoInvestimento, double taxaJuros) {
        double taxaFinal = taxaJurosValorFinal(valorCapital, prazoInvestimento, taxaJuros);

        System.out.println("\n#####################################");
        System.out.printf("A taxa de juros no valor final é de: %.2f", taxaFinal);
        System.out.println("\n#####################################");
    }

}
