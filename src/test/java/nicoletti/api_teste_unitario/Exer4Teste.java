package nicoletti.api_teste_unitario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class AtletaTest {
    @ParameterizedTest
    @CsvSource({"5,pré-mirim", "7,pré-mirim", "8,mirim", "10,mirim", "11,infantil", "13,infantil",
        "14,infanto-juvenil", "17,infanto-juvenil", "18,juvenil", "20,juvenil", "21,adulto", "22,adulto"})
    void limitesDasCategorias(int idade, String esperado) {
        assertEquals(esperado, new Exer_4("Ana", idade, 1.70, 60).classificarCategoria());
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void semCategoria(int idade) {
        assertThrows(IllegalArgumentException.class, () -> new Exer_4("Ana", idade, 1.70, 60).classificarCategoria());
    }
    @Test
    void calculaIMCComAlturaAoQuadrado() {
        assertEquals(20, new Exer_4("Ana", 25, 2, 80).calcularIMC(), 0.000001);
    }
    @ParameterizedTest
    @CsvSource({"18.49,Magreza", "18.5,Saudável", "24.9,Saudável", "24.99,Saudável", "25,Sobrepeso",
        "29.99,Sobrepeso", "30,Obesidade Grau I", "34.99,Obesidade Grau I",
        "35,Obesidade Grau II (severa)", "39.99,Obesidade Grau II (severa)",
        "40,Obesidade Grau III (morbida)", "45,Obesidade Grau III (morbida)"})
    void limitesIMC(double imc, String esperado) {
        assertEquals(esperado, new Exer_4("Ana", 25, 2, imc * 4).classificarIMC());
    }
    @ParameterizedTest
    @ValueSource(doubles = {0, -1, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY})
    void medidasInvalidas(double medida) {
        assertThrows(IllegalArgumentException.class, () -> new Exer_4("Ana", 25, medida, 60));
        assertThrows(IllegalArgumentException.class, () -> new Exer_4("Ana", 25, 1.70, medida));
    }
    @Test
    void dadosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Exer_4("Ana", -1, 1.70, 60));
        assertThrows(IllegalArgumentException.class, () -> new Exer_4(null, 25, 1.70, 60));
        assertThrows(IllegalArgumentException.class, () -> new Exer_4(" ", 25, 1.70, 60));
    }
}
