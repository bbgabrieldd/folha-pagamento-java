package view;

import service.FuncionarioService;
import model.Funcionario;

import javax.swing.JOptionPane;
import java.math.RoundingMode;

public class TelaListaFuncionarios {

    public static void executar(FuncionarioService service) {

        var lista = service.listar();

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum funcionário cadastrado");
            return;
        }

        String resultado = "";

        for (Funcionario f : lista) {

            resultado += "Matrícula: " + f.getMatricula()
                    + " | Nome: " + f.getNome()
                    + " | Cargo: " + f.getCargo()
                    + " | Salário: R$ "
                    + f.getSalario().setScale(2, RoundingMode.HALF_UP)
                    + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }
}