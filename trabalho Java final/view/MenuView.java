package view;

import model.PessoaBase;
import model.Endereco;
import model.Produto;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MenuView {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenuPrincipal() {
        System.out.println("====== MENU PRINCIPAL ======");
        System.out.println("1 - Cadastrar pessoa");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Cadastrar pedido");
        System.out.println("4 - Listar pessoas");
        System.out.println("5 - Listar produtos");
        System.out.println("6 - Listar pedidos");
        System.out.println("0 - Sair");
        System.out.println("===========================");
    }

    public int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public PessoaBase lerPessoa() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Tipo de pessoa (Cliente, Fornecedor, Ambos): ");
        String tipoPessoa = scanner.nextLine();
        PessoaBase pessoa = new PessoaBase(codigo, nome, sobrenome, tipoPessoa);
        boolean adicionarMaisEnd = true;
        while (adicionarMaisEnd) {
            System.out.print("Deseja adicionar um endereço para esta pessoa? (s/n): ");
            String respEnd = scanner.nextLine();
            if (!respEnd.equalsIgnoreCase("s")) break;
            System.out.print("CEP: ");
            String cep = scanner.nextLine();
            System.out.print("Logradouro (Rua): ");
            String logradouro = scanner.nextLine();
            System.out.print("Número: ");
            String numero = scanner.nextLine();
            System.out.print("Complemento: ");
            String complemento = scanner.nextLine();
            System.out.print("Tipo de endereço (Residencial, Comercial, Entrega, etc): ");
            String tipoEndereco = scanner.nextLine();
            Endereco endereco = new Endereco(cep, logradouro, numero, complemento, tipoEndereco);
            pessoa.addEndereco(endereco);
        }
        return pessoa;
    }

    public Produto lerProduto() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Custo (R$): ");
        double custo = Double.parseDouble(scanner.nextLine());
        System.out.print("Preço de venda (R$): ");
        double precoVenda = Double.parseDouble(scanner.nextLine());
        System.out.print("Código do fornecedor: ");
        String codFornecedor = scanner.nextLine();
        return new Produto(codigo, descricao, custo, precoVenda, codFornecedor);
    }

    public List<Produto> lerProdutosParaPedido(List<Produto> produtosDisponiveis) {
        List<Produto> produtosPedido = new ArrayList<>();
        boolean adicionarMais = true;
        while (adicionarMais) {
            System.out.println("Produtos disponíveis:");
            for (Produto p : produtosDisponiveis) {
                System.out.println(p);
            }
            System.out.print("Digite o código do produto: ");
            String codigo = scanner.nextLine();
            Produto prod = null;
            for (Produto p : produtosDisponiveis) {
                if (p.getCodigo().equals(codigo)) {
                    prod = p;
                    break;
                }
            }
            if (prod != null) {
                produtosPedido.add(prod);
                System.out.println("Produto adicionado ao pedido.");
            } else {
                System.out.println("Produto não encontrado!");
            }
            System.out.print("Adicionar mais produtos? (s/n): ");
            String resp = scanner.nextLine();
            adicionarMais = resp.equalsIgnoreCase("s");
        }
        return produtosPedido;
    }
}
