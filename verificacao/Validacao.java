import nicoletti.api_teste_unitario.*;
public class Validacao {
    static int checks;
    static void check(boolean ok) { checks++; if (!ok) throw new AssertionError("Falha " + checks); }
    static void rejeita(Runnable acao) {
        try { acao.run(); } catch (IllegalArgumentException e) { checks++; return; }
        throw new AssertionError("Exceção esperada");
    }
    public static void main(String[] args) {
        Exer_1 e1 = new Exer_1();
        for (int n : new int[]{0,2,-2,100,Integer.MIN_VALUE}) check(e1.validaNumeroInformado(n));
        for (int n : new int[]{1,-1,3,-3,Integer.MAX_VALUE}) check(!e1.validaNumeroInformado(n));
        Exer_2 e2 = new Exer_2();
        String[] estacoes = {"É verão\nE o tempo está quente.", "É outono\nE as árvores estão perdendo as suas folhas.",
            "É inverno\nE está frio.", "É primavera\nE as árvores estão floridas."};
        for(int i=0;i<4;i++) check(e2.verificaEstacaoPeloNumero(i+1).equals(estacoes[i]));
        check(e2.verificaEstacaoPeloNumero(1).equals(estacoes[0]));
        for(int n : new int[]{Integer.MIN_VALUE,-1,0,5,Integer.MAX_VALUE}) rejeita(() -> e2.verificaEstacaoPeloNumero(n));
        check(new Pessoa("Bernardo","Nicoletti","Silva","Blumenau").gerarNomeStarWars().equals("NicBe SiBlu"));
        check(new Pessoa(" An "," Sou "," Li "," Rio ").gerarNomeStarWars().equals("SouAn LiRio"));
        String[] dados = {"Ana","Souza","Silva","Blumenau"};
        for(int i=0;i<4;i++) {
            String[] curto=dados.clone(); curto[i]="A";
            rejeita(() -> new Pessoa(curto[0],curto[1],curto[2],curto[3]));
            String[] nulo=dados.clone(); nulo[i]=null;
            rejeita(() -> new Pessoa(nulo[0],nulo[1],nulo[2],nulo[3]));
        }
        rejeita(() -> new Pessoa("  ","Souza","Silva","Blumenau"));
        int[] idades={5,7,8,10,11,13,14,17,18,20,21,22};
        String[] categorias={"pré-mirim","mirim","infantil","infanto-juvenil","juvenil","adulto"};
        for(int i=0;i<idades.length;i++) check(new Atleta("Ana",idades[i],1.7,60).classificarCategoria().equals(categorias[i/2]));
        for(int idade : new int[]{0,4}) rejeita(() -> new Atleta("Ana",idade,1.7,60).classificarCategoria());
        check(new Atleta("Ana",25,2,80).calcularIMC()==20);
        double[] imcs={18.49,18.5,24.9,24.99,25,29.99,30,34.99,35,39.99,40,45};
        String[] classes={"Magreza","Saudável","Saudável","Saudável","Sobrepeso","Sobrepeso",
            "Obesidade Grau I","Obesidade Grau I","Obesidade Grau II (severa)","Obesidade Grau II (severa)",
            "Obesidade Grau III (morbida)","Obesidade Grau III (morbida)"};
        for(int i=0;i<imcs.length;i++) check(new Atleta("Ana",25,2,imcs[i]*4).classificarIMC().equals(classes[i]));
        for(double n : new double[]{0,-1,Double.NaN,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY}) {
            rejeita(() -> new Atleta("Ana",25,n,60)); rejeita(() -> new Atleta("Ana",25,1.7,n));
        }
        rejeita(() -> new Atleta("Ana",-1,1.7,60));
        rejeita(() -> new Atleta(null,25,1.7,60));
        rejeita(() -> new Atleta(" ",25,1.7,60));
        Exer_5 e5=new Exer_5();
        double[][] casos={{0,0},{4000,0},{4000.01,232},{4001,232.06},{9000,522},{9000.01,1350},{9001,1350.15},
            {25000,3750},{25000.01,6875},{25001,6875.28},{35000,9625},{35000.01,10500},
            {35001,10500.30},{40000,12000},{50000,15000},{4500.25,261.01}};
        for(double[] c : casos) check(Math.abs(e5.calcularImposto(c[0])-c[1])<0.000001);
        for(double n : new double[]{-0.01,-1,Double.NaN,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY}) rejeita(() -> e5.calcularImposto(n));
        for(String uf : new String[]{"SC","RS","PR"}) check(e5.impostoPagar("Bernardo","11111111111",uf,50000).equals(
            "Imposto a pagar do contribuinte: Bernardo inscrito no CPF: 11111111111 localizado em - " + uf + "\nImposto a pagar: R$15000,00"));
        rejeita(() -> e5.impostoPagar(null,"123","SC",0));
        rejeita(() -> e5.impostoPagar(" ","123","SC",0));
        rejeita(() -> e5.impostoPagar("Ana",null,"SC",0));
        rejeita(() -> e5.impostoPagar("Ana"," ","SC",0));
        rejeita(() -> e5.impostoPagar("Ana","123",null,0));
        rejeita(() -> e5.impostoPagar("Ana","123","SP",0));
        System.out.println(checks + " verificações aprovadas com Java 17.");
    }
}
