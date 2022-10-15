package Banco;

import Clientes.Cliente;

public class Poupanca extends Conta{
    public Poupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public String getTipoConta() {
        return "Conta Poupança";
    }

    @Override
    public void imprimirInfoPadrao() {
        System.out.println("Extrato da " + this.getTipoConta());
        super.imprimirInfoPadrao();
    }
}
