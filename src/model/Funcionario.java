package model;

import java.math.BigDecimal;

public class Funcionario implements IFuncionario {

    private final int matricula;
    private final String nome;
    private final String cargo;
    private final BigDecimal salario;
    private final int dependentes;
    private final int filhosMenores14;

    public Funcionario(int matricula, String nome, String cargo,
                       BigDecimal salario, int dependentes, int filhosMenores14) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.dependentes = dependentes;
        this.filhosMenores14 = filhosMenores14;
    }

    public int getMatricula() { return matricula; }
    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public BigDecimal getSalario() { return salario; }
    public int getDependentes() { return dependentes; }
    public int getFilhosMenores14() { return filhosMenores14; }
}