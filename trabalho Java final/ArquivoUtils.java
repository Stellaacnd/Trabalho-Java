import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.PessoaBase;
import model.Produto;

public class ArquivoUtils {

    public static void salvarPessoa(PessoaBase pessoa, String listaPessoas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(listaPessoas, true))) {
            writer.write(pessoa.toString());
            writer.newLine(); 
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public static void salvarProduto(Produto produto, String listaProdutos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(listaProdutos, true))) {
            writer.write(produto.toString());
            writer.newLine(); 
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public static void salvarPedido(String pedido, String listaPedidos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(listaPedidos, true))) {
            writer.write(pedido);
            writer.newLine(); 
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    // Método para exibir o menu lido de um arquivo .txt
    public static void exibirMenuDeArquivo(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o menu: " + e.getMessage());
        }
    }

    public static void listarArquivo(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void registrarLog(String mensagem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(java.time.LocalDateTime.now() + " - " + mensagem);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao gravar no log: " + e.getMessage());
        }
    }

    public static void atualizarProduto(String codigo, String novaDescricao, double novoCusto, double novoPrecoVenda, String novoFornecedor, String listaProdutos) {
        try {
            java.util.List<String> linhas = new java.util.ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(listaProdutos))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (linha.startsWith("Código: " + codigo + ",")) {
                        linha = "Código: " + codigo + ", Desc: " + novaDescricao + ", Custo: R$" + novoCusto + ", Preço: R$" + novoPrecoVenda + ", Fornecedor: " + novoFornecedor;
                    }
                    linhas.add(linha);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(listaProdutos))) {
                for (String l : linhas) {
                    writer.write(l);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    public static void removerProduto(String codigo, String listaProdutos) {
        try {
            java.util.List<String> linhas = new java.util.ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(listaProdutos))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (!linha.startsWith("Código: " + codigo + ",")) {
                        linhas.add(linha);
                    }
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(listaProdutos))) {
                for (String l : linhas) {
                    writer.write(l);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    public static void atualizarPessoa(String codigo, String novoNome, String novoSobrenome, String novoTipo, String listaPessoas) {
        try {
            java.util.List<String> linhas = new java.util.ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(listaPessoas))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (linha.startsWith("Código: " + codigo + ",")) {
                        linha = "Código: " + codigo + ", Nome: " + novoNome + " " + novoSobrenome + ", Tipo: " + novoTipo;
                    }
                    linhas.add(linha);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(listaPessoas))) {
                for (String l : linhas) {
                    writer.write(l);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

    public static void removerPessoa(String codigo, String listaPessoas) {
        try {
            java.util.List<String> linhas = new java.util.ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(listaPessoas))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    if (!linha.startsWith("Código: " + codigo + ",")) {
                        linhas.add(linha);
                    }
                }
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(listaPessoas))) {
                for (String l : linhas) {
                    writer.write(l);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao remover pessoa: " + e.getMessage());
        }
    }
}