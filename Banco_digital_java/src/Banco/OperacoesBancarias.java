package Banco;

public interface OperacoesBancarias {
     void saque(double valor);

     void deposito(double valor);

     void transferencia(double valor,OperacoesBancarias contaDestino);

     void imprimirInfoPadrao();
}
