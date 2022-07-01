package com.finvest;

import java.util.InputMismatchException;
import java.util.Scanner;
import utils.Helper;

public final class App {

    /**
     * MAIN
     */

    public static void main(String[] args) {
    }

    /**
     * MENU
     */

    public static void menu() {
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
    }

    public static void resultadoMesAMesView(double valorCapital, int prazoInvestimento, double taxaJuros) {
    }

    public static void taxaJurosValorFinalView(double valorCapital, int prazoInvestimento, double taxaJuros) {
    }

}
