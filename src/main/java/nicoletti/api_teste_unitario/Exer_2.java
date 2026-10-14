package nicoletti.api_teste_unitario;

public class Exer_2 {
    public String verificaEstacaoPeloNumero(int num) {
        return switch (num) {
            case 1 -> "É verão\nE o tempo está quente.";
            case 2 -> "É outono\nE as árvores estão perdendo as suas folhas.";
            case 3 -> "É inverno\nE está frio.";
            case 4 -> "É primavera\nE as árvores estão floridas.";
            default -> throw new IllegalArgumentException("O valor não está entre o intervalo permitido!");
        };
    }
}
