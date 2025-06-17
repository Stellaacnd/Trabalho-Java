import model.PessoaBase;
import java.util.List;
import java.util.stream.Collectors;

public class FiltroMemoriaUtils {

    public static List<PessoaBase> filtrarPorNome(List<PessoaBase> pessoas, String nome) {
        return pessoas.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(nome))
                .collect(Collectors.toList());
    }

    public static List<PessoaBase> filtrarPorSobrenome(List<PessoaBase> pessoas, String sobrenome) {
        return pessoas.stream()
                .filter(p -> p.getSobrenome().equalsIgnoreCase(sobrenome))
                .collect(Collectors.toList());
    }

    public static List<PessoaBase> filtrarPorCidade(List<PessoaBase> pessoas, String cidade) {
        return pessoas.stream()
                .filter(p -> !p.getEnderecos().isEmpty() && p.getEnderecos().get(0).getLogradouro().equalsIgnoreCase(cidade))
                .collect(Collectors.toList());
    }
}