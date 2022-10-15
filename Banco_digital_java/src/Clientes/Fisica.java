package Clientes;

public class Fisica extends Cliente {
    private double renda;

    public Fisica(String nome, Integer numeroDocumento, double renda) {
        super(nome, numeroDocumento);
        this.renda = renda;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    @Override
    public String getTipoConta() {
        return "FISICA";
    }
}
