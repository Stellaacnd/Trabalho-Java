package controller;

import model.PedidoVenda;
import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private List<PedidoVenda> pedidos = new ArrayList<>();

    public void adicionarPedido(PedidoVenda pedido) {
        pedidos.add(pedido);
    }

    public List<PedidoVenda> listarPedidos() {
        return pedidos;
    }
}
