import controller.PessoaController;
import controller.ProdutoController;
import controller.PedidoController;
import model.PessoaBase;
import model.Produto;
import model.PedidoVenda;
import view.MenuView;

public class Main {
    public static void main(String[] args) {
        MenuView view = new MenuView();
        PessoaController pessoaController = new PessoaController();
        ProdutoController produtoController = new ProdutoController();
        PedidoController pedidoController = new PedidoController();

        int opcao = -1;
        while (opcao != 0) {
            view.exibirMenuPrincipal();
            opcao = view.lerOpcao();
            switch (opcao) {
                case 1:
                    PessoaBase novaPessoa = view.lerPessoa();
                    pessoaController.adicionarPessoa(novaPessoa);
                    System.out.println("Pessoa cadastrada com sucesso!");
                    break;
                case 2:
                    Produto novoProduto = view.lerProduto();
                    produtoController.adicionarProduto(novoProduto);
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 3:
                    // Cadastro de pedido (simplificado)
                    System.out.println("--- Cadastro de Pedido ---");
                    System.out.println("Clientes disponíveis:");
                    for (PessoaBase p : pessoaController.listarPessoas()) {
                        System.out.println(p.getCodigo() + " - " + p.getNome());
                    }
                    System.out.print("Digite o código do cliente: ");
                    String codCliente = new java.util.Scanner(System.in).nextLine();
                    PessoaBase cliente = pessoaController.buscarPorCodigo(codCliente);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }
                    java.util.List<Produto> produtosPedido = view.lerProdutosParaPedido(produtoController.listarProdutos());
                    PedidoVenda pedido = new PedidoVenda("P" + System.currentTimeMillis(), cliente, null);
                    for (Produto prod : produtosPedido) {
                        pedido.adicionarProduto(prod);
                    }
                    pedidoController.adicionarPedido(pedido);
                    System.out.println("Pedido cadastrado com sucesso! Total: R$" + pedido.getMontanteTotal());
                    break;
                case 4:
                    System.out.println("--- Pessoas cadastradas ---");
                    for (PessoaBase p : pessoaController.listarPessoas()) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    System.out.println("--- Produtos cadastrados ---");
                    for (Produto p : produtoController.listarProdutos()) {
                        System.out.println(p);
                    }
                    break;
                case 6:
                    System.out.println("--- Pedidos cadastrados ---");
                    for (PedidoVenda p : pedidoController.listarPedidos()) {
                        System.out.println(p);
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

