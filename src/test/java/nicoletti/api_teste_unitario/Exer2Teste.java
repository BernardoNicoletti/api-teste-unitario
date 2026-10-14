package nicoletti.api_teste_unitario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Exer2Teste {
    @Test
    void todasEstacoesEChamadasSucessivas() {
        Exer_2 exercicio = new Exer_2();
        assertEquals("É verão\nE o tempo está quente.", exercicio.verificaEstacaoPeloNumero(1));
        assertEquals("É outono\nE as árvores estão perdendo as suas folhas.", exercicio.verificaEstacaoPeloNumero(2));
        assertEquals("É inverno\nE está frio.", exercicio.verificaEstacaoPeloNumero(3));
        assertEquals("É primavera\nE as árvores estão floridas.", exercicio.verificaEstacaoPeloNumero(4));
        assertEquals("É verão\nE o tempo está quente.", exercicio.verificaEstacaoPeloNumero(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0, 5, Integer.MAX_VALUE})
    void foraDoIntervalo(int numero) {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,() -> new Exer_2().verificaEstacaoPeloNumero(numero));
        assertEquals("O valor não está entre o intervalo permitido!", erro.getMessage());
    }
}
