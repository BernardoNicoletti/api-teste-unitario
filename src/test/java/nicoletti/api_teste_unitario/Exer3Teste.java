package nicoletti.api_teste_unitario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class Exer3Teste {
    @Test
    void aplicaFormulaNaOrdemCorreta() {
        assertEquals("NicBe SiBlu", new Exer_3("Bernardo", "Nicoletti", "Silva", "Blumenau").gerarNomeStarWars());
    }
    @Test
    void aceitaComprimentosMinimosERemoveEspacosExternos() {
        assertEquals("SouAn LiRio", new Exer_3(" An ", " Sou ", " Li ", " Rio ").gerarNomeStarWars());
    }
    @Test
    void rejeitaCadaCampoCurto() {
        assertThrows(IllegalArgumentException.class, () -> new Exer_3("A", "Souza", "Silva", "Blumenau"));
        assertThrows(IllegalArgumentException.class, () -> new Exer_3("Ana", "So", "Silva", "Blumenau"));
        assertThrows(IllegalArgumentException.class, () -> new Exer_3("Ana", "Souza", "S", "Blumenau"));
        assertThrows(IllegalArgumentException.class, () -> new Exer_3("Ana", "Souza", "Silva", "Bl"));
    }
    @Test
    void rejeitaNulosEVazios() {
        assertThrows(IllegalArgumentException.class, () -> new Exer_3(null, "Souza", "Silva", "Blumenau"));
        assertThrows(IllegalArgumentException.class, () -> new Exer_3("Ana", null, "Silva", "Blumenau"));
        assertThrows(IllegalArgumentException.class, () -> new Exer_3("Ana", "Souza", null, "Blumenau"));
        assertThrows(IllegalArgumentException.class, () -> new Exer_3("Ana", "Souza", "Silva", null));
        assertThrows(IllegalArgumentException.class, () -> new Exer_3("  ", "Souza", "Silva", "Blumenau"));
    }
}
