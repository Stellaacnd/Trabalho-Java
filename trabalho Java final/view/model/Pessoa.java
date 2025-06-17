package model;

public class Pessoa {
    protected String codigo;
    protected String nome;
    protected String sobrenome;

    public Pessoa(String codigo, String nome, String sobrenome) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
}
