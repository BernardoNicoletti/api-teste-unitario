package nicoletti.api_teste_unitario;

public class Exer_4 {
    private final String nome;
    private final int idade;
    private final double altura;
    private final double peso;

    public Exer_4(String nome, int idade, double altura, double peso) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório.");
        if (idade < 0) throw new IllegalArgumentException("Idade não pode ser negativa.");
        if (!Double.isFinite(altura) || altura <= 0 || !Double.isFinite(peso) || peso <= 0) {
            throw new IllegalArgumentException("Altura e peso devem ser positivos e finitos.");
        }
        this.nome = nome.trim();
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
    }

    public String classificarCategoria() {
        if (idade < 5) throw new IllegalArgumentException("Não existe categoria para menores de 5 anos.");
        if (idade <= 7) return "pré-mirim";
        if (idade <= 10) return "mirim";
        if (idade <= 13) return "infantil";
        if (idade <= 17) return "infanto-juvenil";
        if (idade <= 20) return "juvenil";
        return "adulto";
    }

    public double calcularIMC() { return peso / (altura * altura); }

    public String classificarIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) return "Magreza";
        if (imc < 25) return "Saudável";
        if (imc < 30) return "Sobrepeso";
        if (imc < 35) return "Obesidade Grau I";
        if (imc < 40) return "Obesidade Grau II (severa)";
        return "Obesidade Grau III (morbida)";
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }
}
