import Banco.Banco;
import Clientes.Cliente;
import Clientes.Empresarial;
import Clientes.Fisica;
import Clientes.Universitario;
import Banco.Conta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Banco meuBanco = new Banco();
        boolean encerrar = false;
        while (!encerrar) {
            boolean criarConta = false;
            int tipoConta;
            System.out.println("Deseja criar uma nova conta? S/N");
            String novaConta = scan.next().toUpperCase();
            while (!criarConta) {
                if (novaConta.equals("N")) {
                    break;
                }
                System.out.println("Digite seu nome: ");
                String nome = scan.next().toUpperCase();
                System.out.println("Digite seu documento: ");
                Integer documento = scan.nextInt();
                System.out.println("Digite: 1 para conta UNIVERSITÁRIA \n2 para conta PESSOAL \n3 para conta EMPRESARIAL");
                tipoConta = scan.nextInt();

                switch (tipoConta) {
                    default -> System.out.println("Valor invalido");
                    case 1 -> {
                        System.out.println("Insira a faculdade");
                        String faculdade = scan.next();
                        Cliente clienteUniversitario = new Universitario(nome, documento, faculdade);
                        meuBanco.adicionarCliente(clienteUniversitario);
                        System.out.println("Cliente criado com sucesso");
                    }
                    case 2 -> {
                        System.out.println("Insira sua renda mensal");
                        double rendaMensal = scan.nextInt();
                        Cliente clienteFisico = new Fisica(nome, documento, rendaMensal);
                        System.out.println("Cliente criado com sucesso");
                        meuBanco.adicionarCliente(clienteFisico);
                    }
                    case 3 -> {
                        System.out.println("Insira o nome da sua empresa");
                        String nomeEmpresa = scan.next();
                        Cliente clienteEmpresa = new Empresarial(nome, documento, nomeEmpresa);
                        System.out.println("Cliente criado com sucesso");
                        meuBanco.adicionarCliente(clienteEmpresa);
                    }
                }
                System.out.println("Qual modelo da conta \n1 para Conta Corrente \n2 para conta Poupança ");
                int modeloConta = scan.nextInt();
                if (modeloConta == 1) {

                    for (Cliente clientes : meuBanco.getListaClientes()) {
                        if (Objects.equals(clientes.getNome(), nome)) {
                            meuBanco.criarContaCorrente(clientes);
                            System.out.println("Conta Corrente criada com sucesso");
                            for (Conta conta : meuBanco.getListaContas()) {
                                if (conta.getCliente() == clientes) {
                                    System.out.println("ID da sua conta: " + conta.getIDconta());
                                }
                            }
                        }
                    }

                }
                if (modeloConta == 2) {

                    for (Cliente clientes : meuBanco.getListaClientes()) {
                        if (Objects.equals(clientes.getNome(), nome)) {
                            meuBanco.criarContaPoupanca(clientes);
                            System.out.println("Conta Poupança criada com sucesso");
                            for (Conta conta : meuBanco.getListaContas()) {
                                if (conta.getCliente() == clientes) {
                                    System.out.println("ID da sua conta: " + conta.getIDconta());
                                }
                            }

                        }
                    }
                }
                criarConta = true;

            }

            boolean operaracaofinalizada = false;
            do {
                System.out.println("""
                        Insira uma opção:\s
                        Saque - digite 1\s
                        Deposito - digite 2\s
                        Transferencia - digite 3\s
                        Extrato - digite 4\s
                        Repetir alguma operação - digite 5\s
                        Retornar ao inicio - digite 9\s
                        Encerrar - digite 0\s""");
                int resposta = scan.nextInt();
                switch (resposta) {
                    case 1:
                        System.out.println("Insira da Id da conta");
                        int idConta = scan.nextInt();
                        System.out.println("Insira o valor");
                        double valor = scan.nextDouble();
                        for (Conta contas : meuBanco.getListaContas()) {
                            if (contas.getIDconta() == idConta) {
                                contas.saque(valor);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Insira da Id da conta");
                        idConta = scan.nextInt();
                        System.out.println("Insira o valor");
                        valor = scan.nextDouble();
                        for (Conta contas : meuBanco.getListaContas()) {
                            if (contas.getIDconta() == idConta) {
                                contas.deposito(valor);
                                System.out.println("Operação realizada");
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Insira da Id da conta de origem");
                        int idContaOrigem = scan.nextInt();
                        System.out.println("Insira da Id da conta de destino");
                        int idContaDestino = scan.nextInt();
                        System.out.println("Insira o valor");
                        valor = scan.nextDouble();
                        Conta contaDestino;
                        Conta contaOrigem;
                        for (Conta contas : meuBanco.getListaContas()) {
                            if (contas.getIDconta() == idContaDestino) {
                                contaDestino = contas;
                                if (contas.getIDconta() == idContaOrigem) {
                                    contaOrigem = contas;
                                    contaOrigem.transferencia(valor, contaDestino);
                                    System.out.println("Operação realizada");
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Insira da Id da conta");
                        idConta = scan.nextInt();
                        for (Conta contas : meuBanco.getListaContas()) {
                            if (contas.getIDconta() == idConta) {
                                contas.imprimirInfoPadrao();
                                System.out.println("\nOperação realizada");
                            }
                        }
                    case 5:
                        break;
                    case 9:
                        operaracaofinalizada = true;
                        break;
                    case 0:
                        operaracaofinalizada = true;
                        encerrar = true;
                        break;
                    default:
                        System.out.println("Opção invalida:");
                        break;
                }

            } while (!operaracaofinalizada);

        }
    }
}





