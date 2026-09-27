# Conta bancária pelo terminal em Java

[![CI](https://github.com/barbozadevti/java-conta-terminal/actions/workflows/ci.yml/badge.svg)](https://github.com/barbozadevti/java-conta-terminal/actions/workflows/ci.yml)

Entrega do desafio de projeto **"Simulando uma Conta Bancária Através do Terminal/Console"**, da [DIO](https://www.dio.me), para praticar os fundamentos e a sintaxe do Java.

> Versão ampliada para portfólio: **[barbozadevti/cofre](https://github.com/barbozadevti/cofre)**, um banco digital completo em Spring Boot: Pix com QR Code, cheque especial, caixinhas, cartão virtual, perfis de cliente, caixa e gerente, e um terminal da agência que continua este desafio.

## O desafio

Criar a classe `ContaTerminal` e, pelo terminal, pedir ao usuário:

| Campo | Tipo | Exemplo |
|---|---|---|
| Número da conta | `int` | 1021 |
| Agência | `String` | 067-8 |
| Nome do cliente | `String` | Mario Andrade |
| Saldo | `double` | 237,48 |

Depois, exibir a mensagem de confirmação com os dados informados.

## Execução

```text
Por favor, digite o número da Conta !
1021
Por favor, digite o número da Agência !
067-8
Por favor, digite o nome do Cliente !
Mario Andrade
Por favor, digite o saldo !
237.48
Olá Mario Andrade, obrigado por criar uma conta em nosso banco, sua agência é 067-8, conta 1021 e seu saldo 237,48 já está disponível para saque.
```

## O que foi além do enunciado

- **Entrada validada:** número da conta inválido, campo vazio ou saldo negativo são pedidos de novo, com uma mensagem explicando o erro, em vez de derrubar o programa com exceção.
- **Nomes com espaço:** a leitura é feita por linha (`nextLine`), então "Mario Andrade" chega inteiro.
- **Vírgula ou ponto no saldo:** aceita `237,48` e `237.48`, e exibe o valor no formato brasileiro.
- **Teste automatizado:** `tests/testar.sh` compila o programa, envia entradas de exemplo e confere a mensagem final. O GitHub Actions roda os cenários a cada push.

## Como rodar

Requer o JDK 17 ou mais recente.

```bash
javac -encoding UTF-8 -d out src/ContaTerminal.java
java -cp out ContaTerminal
```

Para rodar os testes:

```bash
bash tests/testar.sh
```

## Conceitos praticados

Tipos primitivos e `String`, variáveis, entrada com `Scanner`, laços `while`, tratamento de exceções (`try/catch`), métodos estáticos, formatação com `printf` e `Locale`.
