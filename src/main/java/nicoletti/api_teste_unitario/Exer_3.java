package nicoletti.api_teste_unitario;

public class Exer_3 {
    private final String nome;
    private final String sobrenome;
    private final String nomeSolteiraMae;
    private final String cidadeNatal;

    public Exer_3(String nome, String sobrenome, String nomeSolteiraMae, String cidadeNatal) {
        this.nome = validar(nome, 2, "Nome");
        this.sobrenome = validar(sobrenome, 3, "Sobrenome");
        this.nomeSolteiraMae = validar(nomeSolteiraMae, 2, "Nome de solteira da mãe");
        this.cidadeNatal = validar(cidadeNatal, 3, "Cidade natal");
    }

    private static String validar(String valor, int minimo, String campo) {
        if (valor == null || valor.trim().length() < minimo) {
            throw new IllegalArgumentException(campo + " deve ter pelo menos " + minimo + " caracteres.");
        }
        return valor.trim();
    }

    public String gerarNomeStarWars() {
        return sobrenome.substring(0, 3) + nome.substring(0, 2) + " "
                + nomeSolteiraMae.substring(0, 2) + cidadeNatal.substring(0, 3);
    }

    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public String getNomeSolteiraMae() { return nomeSolteiraMae; }
    public String getCidadeNatal() { return cidadeNatal; }
}
