public class ContaPoupanca extends Conta {
    private static final double taxaRendimento = 0.05;
    public ContaPoupanca(int numeroAgencia, int numeroConta, double saldo, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
    }

    public void rendimento() {
        double rendimento = getSaldo() * taxaRendimento;
        deposito(rendimento);
        System.out.println("Rendimento atual: " + rendimento);
    }
    public double simularOperacao(int meses) {
        double saldoP = getSaldo();

        for (int i = 0; i < meses; i++) {
            saldoP += (taxaRendimento * saldoP);
        }
        
        return saldoP - getSaldo();
    }
}
