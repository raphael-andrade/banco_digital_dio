package Banco;

import Clientes.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private Cliente cliente;
    private  Conta conta;

    private List<Conta> contas = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Banco() {
    }

    public Banco(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta criarContaCorrente(Cliente cliente) {
        Conta contaCorrente = new Corrente(cliente);
        contas.add(contaCorrente);
        return contaCorrente;
    }

    public Conta criarContaPoupanca(Cliente cliente) {
        Conta contaPoupanca = new Poupanca(cliente);
        contas.add(contaPoupanca);
        return contaPoupanca;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public List<Conta> imprimirListaContas() {
        for (Conta lista : contas) {
            System.out.println(lista.getTipoConta());
            System.out.println(lista);
        }
        return null;
    }
    public List<Conta> getListaContas(){
        return contas;
    }
    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public void removerCliente(Cliente cliente){
        clientes.remove(cliente);
    }
    public List<Cliente>getListaClientes(){
        return clientes;
    }
    public Cliente getCliente(){

        return cliente;
    }
    public Conta getConta(){
        return conta;
    }
    }





