package nicoletti.api_teste_unitario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Exer_5 {
    public double calcularImposto(double rendaAnual) {
        validarRenda(rendaAnual);
        BigDecimal aliquota;
        if (rendaAnual <= 4000) aliquota = new BigDecimal("0");
        else if (rendaAnual <= 9000) aliquota = new BigDecimal("0.058");
        else if (rendaAnual <= 25000) aliquota = new BigDecimal("0.15");
        else if (rendaAnual <= 35000) aliquota = new BigDecimal("0.275");
        else aliquota = new BigDecimal("0.30");
        return BigDecimal.valueOf(rendaAnual).multiply(aliquota)
                .setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String impostoPagar(String nome, String cpf, String uf, double rendaAnual) {
        if (nome == null || nome.isBlank() || cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("Nome e CPF são obrigatórios.");
        }
        if (uf == null || !(uf.equals("RS") || uf.equals("PR") || uf.equals("SC"))) {
            throw new IllegalArgumentException("UF deve ser RS, PR ou SC.");
        }
        return String.format(Locale.forLanguageTag("pt-BR"),
                "Imposto a pagar do contribuinte: %s inscrito no CPF: %s localizado em - %s\nImposto a pagar: R$%.2f",
                nome, cpf, uf, calcularImposto(rendaAnual));
    }

    private void validarRenda(double rendaAnual) {
        if (!Double.isFinite(rendaAnual) || rendaAnual < 0) {
            throw new IllegalArgumentException("Renda anual deve ser não negativa e finita.");
        }
    }
}
