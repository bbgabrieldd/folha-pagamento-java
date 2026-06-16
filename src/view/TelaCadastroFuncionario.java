package view;

import service.FuncionarioService;
import model.Funcionario;

import javax.swing.*;
import java.math.BigDecimal;

public class TelaCadastroFuncionario {

    public static void executar(FuncionarioService service) {

        int matricula;

        while (true) {
            matricula = lerInteiro("Matrícula:");

            if (service.existeMatricula(matricula)) {
                JOptionPane.showMessageDialog(null, "Essa matrícula já existe!");
            } else {
                break;
            }
        }

        String nome = JOptionPane.showInputDialog("Nome:");
        String cargo = JOptionPane.showInputDialog("Cargo:");

        BigDecimal salario = new BigDecimal(JOptionPane.showInputDialog("Salário:"));

        int dep = lerInteiro("Dependentes:");
        int filhos = lerInteiro("Filhos menores de 14:");

        Funcionario f = new Funcionario(matricula, nome, cargo, salario, dep, filhos);

        service.adicionar(f);

        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
    }
    
    private static int lerInteiro(String mensagem) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensagem);

            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite um valor válido!");
                continue;
            }

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Número inválido!");
            }
        }
    }
}