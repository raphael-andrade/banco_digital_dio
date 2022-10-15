package Clientes;

public class Universitario extends Cliente {

    private String faculdade;
    public Universitario(String nome, Integer numeroDocumento,String faculdade) {
        super(nome, numeroDocumento);
        this.faculdade = faculdade;
    }

    public String getFaculdade() {
        return faculdade;
    }

    public void setFaculdade(String faculdade) {
        this.faculdade = faculdade;
    }

    @Override
    public String getTipoConta() {
        return "UNIVERSITARIA";
    }
}
