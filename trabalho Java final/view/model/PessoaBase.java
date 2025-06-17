package model;

import java.util.ArrayList;
import java.util.List;

public class PessoaBase extends Pessoa {
    private String tipoPessoa;
    private List<Endereco> enderecos = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();

    public PessoaBase(String codigo, String nome, String sobrenome, String tipoPessoa) {
        super(codigo, nome, sobrenome);
        this.tipoPessoa = tipoPessoa;
    }

    public void addEndereco(Endereco endereco) { enderecos.add(endereco); }
    public List<Endereco> getEnderecos() { return enderecos; }
    public void addProduto(Produto produto) { produtos.add(produto); }
    public List<Produto> getProdutos() { return produtos; }
}
