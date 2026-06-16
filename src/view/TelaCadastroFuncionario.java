package view;

import service.FuncionarioService;
import model.Funcionario;

import javax.swing.*;
import java.math.BigDecimal;

public class TelaCadastroFuncionario {

    public static void executar(FuncionarioService service) {

        int matricula;

        while (true) {
            matricula = Integer.parseInt(JOptionPane.showInputDialog("Matrícula:"));

            if (service.existeMatricula(matricula)) {
                JOptionPane.showMessageDialog(null, "Essa matrícula já existe!");
            } else {
                break;
            }
        }

        String nome = JOptionPane.showInputDialog("Nome:");
        String cargo = JOptionPane.showInputDialog("Cargo:");
        BigDecimal salario = new BigDecimal(JOptionPane.showInputDialog("Salário:"));
        int dep = Integer.parseInt(JOptionPane.showInputDialog("Dependentes:"));
        int filhos = Integer.parseInt(JOptionPane.showInputDialog("Filhos menores de 14:"));

        Funcionario f = new Funcionario(matricula, nome, cargo, salario, dep, filhos);

        service.adicionar(f);

        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
    }
}