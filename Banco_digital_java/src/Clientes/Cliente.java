package Clientes;

public abstract class Cliente {

    private static int SEQUENCIAID = 1;
    protected String nome;
    protected Integer id;

    protected String tipoConta;



    protected Integer numeroDocumento;

    public Cliente() {
    }

    public Cliente(String nome, Integer numeroDocumento) {
        this.nome = nome;
        this.id = SEQUENCIAID++;
        this.numeroDocumento = numeroDocumento;

    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getTipoConta() {
        return tipoConta;
    }
}
