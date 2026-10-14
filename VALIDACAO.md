# Validação realizada

As classes Exer_1, Exer_2, Exer_5, Pessoa e Atleta foram compiladas com o compilador do Java 17.
O programa independente verificacao/Validacao.java executou 101 verificações de resultados e exceções; todas passaram.

Os testes JUnit foram implementados, mas NÃO puderam ser executados neste ambiente: o comando Maven clean test falhou ao acessar repo.maven.apache.org (falha de resolução DNS), antes da compilação do projeto. O teste de contexto Spring também não foi executado. A integração completa com Maven/Spring permanece para validação local.

Mantidas as versões originais do pom.xml e do Maven Wrapper. Não foi possível confirmar a disponibilidade das dependências originais devido ao bloqueio de rede.

Para executar a verificação independente no seu computador, a partir da pasta do projeto:

```sh
javac -encoding UTF-8 -d verificacao/classes src/main/java/nicoletti/api_teste_unitario/Exer_1.java src/main/java/nicoletti/api_teste_unitario/Exer_2.java src/main/java/nicoletti/api_teste_unitario/Exer_5.java src/main/java/nicoletti/api_teste_unitario/Pessoa.java src/main/java/nicoletti/api_teste_unitario/Atleta.java verificacao/Validacao.java
java -cp verificacao/classes Validacao
```

Para os testes da atividade, execute mvnw.cmd clean test no Windows (./mvnw.cmd clean test no PowerShell).
