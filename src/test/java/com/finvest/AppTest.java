package com.finvest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.InputMismatchException;

class AppTest {

    /**
     * CAMINHO FELIZ
     */

    @Test
    void testValorFinalCapitalInvestido1() {
        double valorCapital = 1000.0, taxaJuros = 0.1;
        int prazoInvestimento = 6;

        double expected = 1771.56;
        double actual = App.valorFinalCapitalInvestido(valorCapital, prazoInvestimento, taxaJuros);

        assertEquals(expected, actual);
    }

    @Test
    void testResultadoMesAMes1() {
        double valorCapital = 1000.0, taxaJuros = 0.1;
        int prazoInvestimento = 6;

        double[][] expected = { { 1100.0, 100.0 }, { 1210.0, 110.0 }, { 1331.0, 121.0 }, { 1464.1, 133.1 },
                { 1610.51, 146.41 }, { 1771.56, 161.05 } };

        double[][] actual = App.resultadoMesAMes(valorCapital, prazoInvestimento, taxaJuros);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testTaxaJurosValorFinal1() {
        double valorCapital = 1000.0, taxaJuros = 0.1;
        int prazoInvestimento = 6;

        double expected = 161.05;
        double actual = App.taxaJurosValorFinal(valorCapital, prazoInvestimento, taxaJuros);

        assertEquals(expected, actual);
    }

    /**
     * CAMINHO INFELIZ
     */

    @Test
    void testValorFinalCapitalInvestido2() {
    }

    @Test
    void testResultadoMesAMes2() {
    }

    @Test
    void testTaxaJurosValorFinal2() {
    }

}
