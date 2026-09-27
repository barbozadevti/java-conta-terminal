import java.util.Locale;
import java.util.Scanner;

/**
 * Simula a abertura de uma conta bancária pelo terminal.
 *
 * Lê o número da conta, a agência, o nome do cliente e o saldo inicial
 * e exibe a mensagem de confirmação da abertura.
 */
public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero = lerNumero(scanner, "Por favor, digite o número da Conta !");
        String agencia = lerTexto(scanner, "Por favor, digite o número da Agência !");
        String nomeCliente = lerTexto(scanner, "Por favor, digite o nome do Cliente !");
        double saldo = lerSaldo(scanner, "Por favor, digite o saldo !");

        System.out.printf(Locale.of("pt", "BR"),
                "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque.%n",
                nomeCliente, agencia, numero, saldo);

        scanner.close();
    }

    /** Pede um número inteiro positivo até o usuário digitar um válido. */
    private static int lerNumero(Scanner scanner, String pergunta) {
        while (true) {
            String entrada = lerTexto(scanner, pergunta);
            try {
                int numero = Integer.parseInt(entrada);
                if (numero > 0) {
                    return numero;
                }
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            System.out.println("Número inválido. Digite apenas números maiores que zero.");
        }
    }

    /** Pede um texto até o usuário digitar algo diferente de vazio. */
    private static String lerTexto(Scanner scanner, String pergunta) {
        while (true) {
            System.out.println(pergunta);
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("A entrada terminou antes de todos os dados serem informados.");
            }
            String entrada = scanner.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println("Este campo não pode ficar vazio.");
        }
    }

    /** Pede o saldo aceitando vírgula ou ponto como separador decimal (ex.: 237,48 ou 237.48). */
    private static double lerSaldo(Scanner scanner, String pergunta) {
        while (true) {
            String entrada = lerTexto(scanner, pergunta).replace(",", ".");
            try {
                double saldo = Double.parseDouble(entrada);
                if (saldo >= 0) {
                    return saldo;
                }
            } catch (NumberFormatException e) {
                // cai na mensagem abaixo
            }
            System.out.println("Saldo inválido. Use números, por exemplo 237,48.");
        }
    }
}
