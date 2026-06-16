import service.FuncionarioService;
import view.MenuPrincipal;

public class Main {

    public static void main(String[] args) {

        FuncionarioService service = new FuncionarioService();
        service.carregarDadosIniciais();

        MenuPrincipal.executar(service);
    }
}