package service;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class FuncionarioService {

    private List<Funcionario> lista = new ArrayList<>();

    public void carregarDadosIniciais() {
        lista.add(new Funcionario(1, "Ana Silva", "Analista", new BigDecimal("3000"), 2, 1));
        lista.add(new Funcionario(2, "Bruno Souza", "Dev", new BigDecimal("5000"), 1, 1));
        lista.add(new Funcionario(3, "Carlos Lima", "Suporte", new BigDecimal("1800"), 3, 2));
        lista.add(new Funcionario(4, "Daniela Rocha", "Gerente", new BigDecimal("8000"), 0, 0));
        lista.add(new Funcionario(5, "Eduardo Alves", "Estagiário", new BigDecimal("1200"), 0, 0));
    }

    public boolean existeMatricula(int matricula) {
        for (Funcionario f : lista) {
            if (f.getMatricula() == matricula) return true;
        }
        return false;
    }

    public boolean adicionar(Funcionario f) {
        if (existeMatricula(f.getMatricula())) return false;
        lista.add(f);
        return true;
    }

    public List<Funcionario> listar() {
        return new ArrayList<>(lista);
    }
}