package service;

import java.math.BigDecimal;

public class CalculadoraFolha {

    private static final BigDecimal PERC_075 = new BigDecimal("0.075");
    private static final BigDecimal PERC_09  = new BigDecimal("0.09");
    private static final BigDecimal PERC_12  = new BigDecimal("0.12");
    private static final BigDecimal PERC_14  = new BigDecimal("0.14");

    public BigDecimal calcularINSS(BigDecimal salario) {

        if (salario.compareTo(new BigDecimal("1412.00")) <= 0)
            return salario.multiply(PERC_075);

        else if (salario.compareTo(new BigDecimal("2666.68")) <= 0)
            return salario.multiply(PERC_09);

        else if (salario.compareTo(new BigDecimal("4000.03")) <= 0)
            return salario.multiply(PERC_12);

        else
            return salario.multiply(PERC_14);
    }

    public BigDecimal calcularIRRF(BigDecimal salario, int dependentes, BigDecimal inss) {

        BigDecimal base = salario
                .subtract(inss)
                .subtract(new BigDecimal(dependentes).multiply(new BigDecimal("189.59")));

        if (base.compareTo(new BigDecimal("2259.20")) <= 0)
            return BigDecimal.ZERO;

        if (base.compareTo(new BigDecimal("2826.65")) <= 0)
            return base.multiply(new BigDecimal("0.075"))
                    .subtract(new BigDecimal("169.44"))
                    .max(BigDecimal.ZERO);

        if (base.compareTo(new BigDecimal("3751.05")) <= 0)
            return base.multiply(new BigDecimal("0.15"))
                    .subtract(new BigDecimal("381.44"))
                    .max(BigDecimal.ZERO);

        if (base.compareTo(new BigDecimal("4664.68")) <= 0)
            return base.multiply(new BigDecimal("0.225"))
                    .subtract(new BigDecimal("662.77"))
                    .max(BigDecimal.ZERO);

        return base.multiply(new BigDecimal("0.275"))
                .subtract(new BigDecimal("896.00"))
                .max(BigDecimal.ZERO);
    }

    public BigDecimal calcularValeTransporte(BigDecimal salario) {

        BigDecimal transporte = new BigDecimal("12.00")
                .multiply(new BigDecimal("20"));

        BigDecimal limite = salario.multiply(new BigDecimal("0.06"));

        return transporte.min(limite);
    }

    public BigDecimal calcularSalarioFamilia(BigDecimal salario, int filhos) {

        if (salario.compareTo(new BigDecimal("1819.26")) <= 0)
            return new BigDecimal(filhos).multiply(new BigDecimal("62.04"));

        return BigDecimal.ZERO;
    }

    public BigDecimal calcularFGTS(BigDecimal salario) {
        return salario.multiply(new BigDecimal("0.08"));
    }

    public BigDecimal calcularSalarioLiquido(
            BigDecimal salario,
            BigDecimal inss,
            BigDecimal irrf,
            BigDecimal vt,
            BigDecimal familia) {

        return salario
                .subtract(inss)
                .subtract(irrf)
                .subtract(vt)
                .add(familia);
    }
}