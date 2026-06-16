package view;

import service.FuncionarioService;
import javax.swing.JOptionPane;

public class MenuPrincipal {

    public static void executar(FuncionarioService service) {

        int opcao;

        do {
            String op = JOptionPane.showInputDialog(
                    "1 - Incluir\n2 - Listar\n3 - Folha\n0 - Sair");

            if (op == null) return;

            opcao = Integer.parseInt(op);

            switch (opcao) {
                case 1 -> TelaCadastroFuncionario.executar(service);
                case 2 -> TelaListaFuncionarios.executar(service);
                case 3 -> TelaFolhaPagamento.executar(service);
            }

        } while (opcao != 0);
    }
}