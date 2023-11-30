import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteOperacoes {
    private List<Cliente> listaClientes;
    private List<Conta> listaContas;
    public TesteOperacoes() {
        this.listaClientes = new ArrayList<>();
        this.listaContas = new ArrayList<>();
    }

    public void criarConta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o nome do cliente:");
        String nome = sc.nextLine();
        System.out.println("Informe o endereço do cliente:");
        String endereco = sc.nextLine();
        System.out.println("Informe a profissão do cliente:");
        String profissao = sc.nextLine();

        Cliente cliente = new Cliente(nome, endereco, profissao);
        listaClientes.add(cliente);

        System.out.println("Informe o tipo de conta (poupanca ou corrente):");
        String tipoConta = sc.nextLine();

        System.out.println("Informe o número da agência:");
        int numeroAgencia = sc.nextInt();
        System.out.println("Informe o número da conta:");
        int numeroConta = sc.nextInt();
        System.out.println("Informe o saldo inicial:");
        double saldo = sc.nextDouble();

        if (tipoConta.equalsIgnoreCase("poupanca")) {
            ContaPoupanca contaPoupanca = new ContaPoupanca(numeroAgencia, numeroConta, saldo, cliente);
            listaContas.add(contaPoupanca);
        } else if (tipoConta.equalsIgnoreCase("corrente")) {
            ContaCorrente contaCorrente = new ContaCorrente(numeroAgencia, numeroConta, saldo, cliente);
            listaContas.add(contaCorrente);
        } else {
            System.out.println("Tipo de conta inválido.");
        }
        System.out.println("Conta criada com sucesso!");
        sc.close();
    }
        
    public void realizarOperacoes() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Informe o número da agência e conta do remetente:");
            int agenciaRemetente = sc.nextInt();
            int contaRemetente = sc.nextInt();

            System.out.println("Informe o número da agência e conta do destinatário:");
            int agenciaDestinatario = sc.nextInt();
            int contaDestinatario = sc.nextInt();

            Conta contaRemetenteObj = buscarConta(agenciaRemetente, contaRemetente);
            Conta contaDestinatarioObj = buscarConta(agenciaDestinatario, contaDestinatario);

            if (contaRemetenteObj != null && contaDestinatarioObj != null) {
                System.out.println("Informe o valor da transferência:");
                double valorTransferencia = sc.nextDouble();

                contaRemetenteObj.transferencia(contaDestinatarioObj, valorTransferencia);
                System.out.println("Transferência realizada com sucesso");
            } else {
                System.out.println("Conta remetente ou destinatário não encontrada.");
            }
            sc.close();
    }

    public void exibirSaldo() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Informe o número da agência e conta do cliente:");
            int numeroAgencia = sc.nextInt();
            int numeroConta = sc.nextInt();

            Conta conta = buscarConta(numeroAgencia, numeroConta);

            if (conta != null) {
                System.out.println("Informe a quantidade de meses para simular o saldo:");
                int meses = sc.nextInt();

                conta.exibirSaldo();

                if (conta instanceof ContaPoupanca) {
                    System.out.println("Saldo simulado após " + meses + " meses: " + ((ContaPoupanca) conta).simularOperacao(meses));
                } else if (conta instanceof ContaCorrente) {
                    System.out.println("Saldo simulado após " + meses + " meses: " + ((ContaCorrente) conta).simularOperacao(meses));

            } else {
                System.out.println("Conta não encontrada.");
            }
            sc.close();
        }
    }

    public void apresentarMenu() {
        Scanner sc = new Scanner(System.in);
        boolean menuOn = true;

        while (menuOn) {
            System.out.println("\nMenu:");
            System.out.println("1. Criar conta");
            System.out.println("2. Realizar operações");
            System.out.println("3. Exibir saldo");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção (1-4):");
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    realizarOperacoes();
                    break;
                case 3:
                    exibirSaldo();
                    break;
                case 4:
                    menuOn = false;
                    System.out.println("Fim do Programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        sc.close();
    }

    private Conta buscarConta(int numeroAgencia, int numeroConta) {
        for (Conta conta : listaContas) {
            if (conta.getNumeroAgencia() == numeroAgencia && conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TesteOperacoes teste = new TesteOperacoes();
        teste.apresentarMenu();
    }
    
}
