public class ContaCorrente extends Conta {
    private static final double taxaManutencao = 50.0;

    public ContaCorrente(int numeroAgencia, int numeroConta, double saldo, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
    }

    public void descontarTaxaManutencao() {
        if (getSaldo() >= taxaManutencao) {
            setSaldo(getSaldo() - taxaManutencao);
            System.out.println("Taxa de manutenção descontada: " + taxaManutencao);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double simularOperacao(int meses) {
        double saldoSimulado = getSaldo();
        for (int i = 0; i < meses; i++) {
            descontarTaxaManutencao();
        }
        return getSaldo();
    }
}
