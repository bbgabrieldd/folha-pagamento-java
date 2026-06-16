package view;

import service.FuncionarioService;
import model.Funcionario;

import javax.swing.JOptionPane;
import java.math.RoundingMode;

public class TelaListaFuncionarios {

    public static void executar(FuncionarioService service) {

        StringBuilder resultado = new StringBuilder();

        for (Funcionario f : service.listar()) {
            resultado.append("Matrícula: ").append(f.getMatricula())
                    .append(" | Nome: ").append(f.getNome())
                    .append(" | Cargo: ").append(f.getCargo())
                    .append(" | Salário: R$ ")
                    .append(f.getSalario().setScale(2, RoundingMode.HALF_UP))
                    .append("\n");
        }

        JOptionPane.showMessageDialog(null, resultado.toString());
    }
}