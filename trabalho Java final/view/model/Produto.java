package model;

public class Produto {
    private String codigo;
    private String descricao;
    private double custo;
    private double precoVenda;
    private String codigoFornecedor;

    public Produto(String codigo, String descricao, double custo, double precoVenda, String codigoFornecedor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.custo = custo;
        this.precoVenda = precoVenda;
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getCodigo() { return codigo; }
    public String getDescricao() { return descricao; }
    public double getCusto() { return custo; }
    public double getPrecoVenda() { return precoVenda; }
    public String getCodigoFornecedor() { return codigoFornecedor; }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Desc: " + descricao + ", Custo: R$" + custo + ", Preço: R$" + precoVenda + ", Fornecedor: " + codigoFornecedor;
    }
}
