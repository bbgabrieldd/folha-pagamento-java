package view;

import service.*;
import model.Funcionario;

import javax.swing.JOptionPane;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TelaFolhaPagamento {

    public static void executar(FuncionarioService service) {

        int matricula = lerInteiro("Matrícula:");

        Funcionario f = null;

        for (Funcionario func : service.listar()) {
            if (func.getMatricula() == matricula) {
                f = func;
                break;
            }
        }

        if (f == null) {
            JOptionPane.showMessageDialog(null, "Não encontrado!");
            return;
        }

        CalculadoraFolha c = new CalculadoraFolha();

        BigDecimal salario = f.getSalario();

        BigDecimal inss = c.calcularINSS(salario);
        BigDecimal irrf = c.calcularIRRF(salario, f.getDependentes(), inss);
        BigDecimal vt = c.calcularValeTransporte(salario);
        BigDecimal fam = c.calcularSalarioFamilia(salario, f.getFilhosMenores14());
        BigDecimal fgts = c.calcularFGTS(salario);

        BigDecimal liquido = c.calcularSalarioLiquido(salario, inss, irrf, vt, fam);

        JOptionPane.showMessageDialog(null,
                "Nome: " + f.getNome() +
                        "\nINSS: " + inss.setScale(2, RoundingMode.HALF_UP) +
                        "\nIRRF: " + irrf.setScale(2, RoundingMode.HALF_UP) +
                        "\nVT: " + vt.setScale(2, RoundingMode.HALF_UP) +
                        "\nFamília: " + fam.setScale(2, RoundingMode.HALF_UP) +
                        "\nFGTS: " + fgts.setScale(2, RoundingMode.HALF_UP) +
                        "\nLíquido: " + liquido.setScale(2, RoundingMode.HALF_UP));
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