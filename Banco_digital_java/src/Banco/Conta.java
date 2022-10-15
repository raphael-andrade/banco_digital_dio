package Banco;

import Clientes.Cliente;

public class Conta implements OperacoesBancarias {
    private static final int AGENCIA_PADRAO = 1;
    private static int IDconta = 1000;

    protected int agencia;
    protected int conta;
    protected Cliente cliente;
    protected double saldo;

    public Conta() {
    }

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = IDconta++;
        this.cliente = cliente;
    }

    public  int getIDconta() {
        return IDconta;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public void saque(double valor) {
        saldo -= valor;
    }

    @Override
    public void deposito(double valor) {
        saldo += valor;
    }

    @Override
    public void transferencia(double valor, OperacoesBancarias contaDestino) {
        this.saque(valor);
        contaDestino.deposito(valor);
    }

    public String getTipoConta() {
        return null;
    }

    @Override
    public void imprimirInfoPadrao() {
        System.out.println("Titular da conta: " + cliente.getNome());
        System.out.println("Tipo de conta: " + cliente.getTipoConta());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Conta: " + this.conta);
        System.out.printf("Saldo: R$ %.2f", this.saldo);
    }

    @Override
    public String toString() {
        return String.format("Titular da conta: " + cliente.getNome()) + String.format("\n Tipo de conta: " + cliente.getTipoConta()) + String.format("\n Conta: " + conta) + String.format("\n Saldo: R$ %.2f", saldo);
    }
}
