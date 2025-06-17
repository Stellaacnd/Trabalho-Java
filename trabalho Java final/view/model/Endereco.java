package model;

public class Endereco {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String tipoEndereco;

    public Endereco(String cep, String logradouro, String numero, String complemento, String tipoEndereco) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.tipoEndereco = tipoEndereco;
    }

    public String getCep() { return cep; }
    public String getLogradouro() { return logradouro; }
    public String getNumero() { return numero; }
    public String getComplemento() { return complemento; }
    public String getTipoEndereco() { return tipoEndereco; }

    @Override
    public String toString() {
        return tipoEndereco + ": " + logradouro + ", " + numero + " (" + complemento + ") - CEP: " + cep;
    }
}
