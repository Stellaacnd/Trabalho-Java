package model;

import java.util.ArrayList;
import java.util.List;

public class PedidoVenda {
    private String numeroPedido;
    private PessoaBase cliente;
    private Endereco enderecoEntrega;
    private List<Produto> produtosVendidos = new ArrayList<>();
    private double montanteTotal;

    public PedidoVenda(String numeroPedido, PessoaBase cliente, Endereco enderecoEntrega) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    public void adicionarProduto(Produto produto) {
        produtosVendidos.add(produto);
        calcularMontanteTotal();
    }

    public void calcularMontanteTotal() {
        montanteTotal = 0;
        for (Produto p : produtosVendidos) {
            montanteTotal += p.getPrecoVenda();
        }
    }

    public double getMontanteTotal() { return montanteTotal; }
}
