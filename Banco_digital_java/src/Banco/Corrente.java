package Banco;

import Clientes.Cliente;

public class Corrente extends Conta{
    public Corrente( Cliente cliente) {
        super(cliente);
    }

    @Override
    public String getTipoConta() {
        return "Conta Corrente";
    }

    @Override
    public void imprimirInfoPadrao() {
        System.out.println("Extrato da " + this.getTipoConta());
        super.imprimirInfoPadrao();
    }
}
