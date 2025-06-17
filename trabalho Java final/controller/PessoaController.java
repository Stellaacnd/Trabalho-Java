package controller;

import model.PessoaBase;
import java.util.ArrayList;
import java.util.List;

public class PessoaController {
    private List<PessoaBase> pessoas = new ArrayList<>();

    public void adicionarPessoa(PessoaBase pessoa) {
        pessoas.add(pessoa);
    }

    public List<PessoaBase> listarPessoas() {
        return pessoas;
    }

    public PessoaBase buscarPorCodigo(String codigo) {
        for (PessoaBase p : pessoas) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }
}
