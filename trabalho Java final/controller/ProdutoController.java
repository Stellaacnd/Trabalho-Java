package controller;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarPorCodigo(String codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }
}
