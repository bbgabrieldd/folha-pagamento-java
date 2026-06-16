package model;

import java.math.BigDecimal;

public interface IFuncionario {
    int getMatricula();
    String getNome();
    String getCargo();
    BigDecimal getSalario();
    int getDependentes();
    int getFilhosMenores14();
}