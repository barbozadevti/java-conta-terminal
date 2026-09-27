#!/usr/bin/env bash
# Compila o ContaTerminal e confere a saída com entradas de exemplo.
set -euo pipefail
cd "$(dirname "$0")/.."
mkdir -p out
javac -encoding UTF-8 -d out src/ContaTerminal.java

falhas=0
conferir() {
  local nome="$1" entrada="$2" esperado="$3"
  local saida
  saida=$(printf '%b' "$entrada" | java -Dstdout.encoding=UTF-8 -cp out ContaTerminal | tail -n 1 | tr -d '\r')
  if [[ "$saida" == "$esperado" ]]; then
    echo "ok    $nome"
  else
    echo "FALHA $nome"
    echo "  esperado: $esperado"
    echo "  obtido:   $saida"
    falhas=$((falhas + 1))
  fi
}

conferir "exemplo do desafio" \
  '1021\n067-8\nMario Andrade\n237.48\n' \
  'Olá Mario Andrade, obrigado por criar uma conta em nosso banco, sua agência é 067-8, conta 1021 e seu saldo 237,48 já está disponível para saque.'

conferir "saldo com vírgula" \
  '555\n0001\nAna Souza\n1500,5\n' \
  'Olá Ana Souza, obrigado por criar uma conta em nosso banco, sua agência é 0001, conta 555 e seu saldo 1500,50 já está disponível para saque.'

conferir "corrige entradas inválidas" \
  'abc\n-3\n42\n\n1234-5\nJoão da Silva\ndez\n-1\n0\n' \
  'Olá João da Silva, obrigado por criar uma conta em nosso banco, sua agência é 1234-5, conta 42 e seu saldo 0,00 já está disponível para saque.'

[[ $falhas -eq 0 ]] && echo "Todos os cenários passaram." || { echo "$falhas cenário(s) falharam."; exit 1; }
