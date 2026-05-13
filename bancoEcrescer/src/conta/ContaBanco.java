package conta;

import pessoa.Pessoa;

public class ContaBanco {

    private Pessoa titular;

    private int numero;
    private double saldo;

    public ContaBanco(int numero, Pessoa titular){
        this.numero = numero;
    }

    public ContaBanco(int numero, Pessoa titular, double saldoInicial){
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public boolean sacar(double valorASacar){
        if(this.saldo >= valorASacar){
            this.saldo = saldo - valorASacar;
            return true;
        }
        return false;
    }

    public void depositar(double valorADepositar){
        this.saldo = this.saldo + valorADepositar;
    }

    public boolean transferir(ContaBanco contaDestino, double valorATransferir) {
        boolean foiPossivelSacar = this.sacar(valorATransferir);
        if (foiPossivelSacar) {
            contaDestino.depositar(valorATransferir);
            return true;
        }
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

}
