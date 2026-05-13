package pessoa;

public class Funcionario extends Pessoa {
    public final double PERCENTUAL_PADRAO_BONUS = 10;
    public static final int CARGA_HORARIA_PADRAO = 220;

    private final double CEM = 100;

    private String matricula;
    private double cargaHoraria;


    public Funcionario(String nome, String cpf, String rg, String matricula) {
        super(nome, cpf, rg);
        this.matricula = matricula;
        this.cargaHoraria = CARGA_HORARIA_PADRAO;
    }

    public double getSalarioComBonus() {
        return this.salario + ((this.salario * PERCENTUAL_PADRAO_BONUS) / CEM);
    }

    public double getSalarioComBonus(double percentualBonus) {
        return this.salario + ((this.salario * percentualBonus) / CEM);
    }

}

