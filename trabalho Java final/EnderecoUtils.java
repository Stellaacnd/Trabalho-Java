import java.util.List;
import model.Endereco; 

public class EnderecoUtils {
    public static boolean validarLista(List<Endereco> enderecos){
        for (Endereco endereco : enderecos) {
            if (!validarEndereco(endereco)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarEndereco(Endereco endereco) {
        return endereco.getLogradouro() != null && !endereco.getLogradouro().isBlank()
            && endereco.getNumero() != null && !endereco.getNumero().isBlank()
            && endereco.getComplemento() != null && !endereco.getComplemento().isBlank()
            && endereco.getCep() != null && !endereco.getCep().isBlank()
            && endereco.getTipoEndereco() != null && !endereco.getTipoEndereco().isBlank();
    }
}