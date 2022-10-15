package Clientes;

public class Empresarial extends Cliente{
    private String nomeEmpresa;
        public Empresarial(String nome, Integer numeroDocumento, String nomeEmpresa) {
        super(nome, numeroDocumento);
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    @Override
    public String getTipoConta() {
        return "EMPRESARIAL";
    }
}
