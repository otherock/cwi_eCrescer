import org.junit.Assert;
import org.junit.Test;
import pessoa.Funcionario;
import pessoa.Gerente;
import pessoa.Vendedor;

public class FuncionarioTest {
    //deve calcular o salario com acrescimo de 10% quando consultado com bonificação

    @Test
    public void deveCalcularSalarioAcrescidoDe10PorCentoQuandoConsultadoOSalarioComBonificacao(){
        //arrange
        Funcionario arthur = new Funcionario("Arthur Rocha", "85589900000", "090909099292", "0001");
        arthur.setSalario(1000);
        double salarioComBonificacaoEsperado = 1100;

        //act
        double salarioComBonus = arthur.getSalarioComBonus();

        //assert
        Assert.assertEquals(salarioComBonificacaoEsperado, salarioComBonus, 0.01);
    }

    @Test
    public void deveCalcularSalarioCorretamenteQuandoOBonusForDinamico(){
        //arrange
        Funcionario joao = new Funcionario("Joao Rocha", "85589342200", "090909099292", "0001");
        joao.setSalario(1000);
        double salarioComBonificacaoEsperado = 1150;

        //act
        double salarioComBonus = joao.getSalarioComBonus(15);

        //assert
        Assert.assertEquals(salarioComBonificacaoEsperado, salarioComBonus, 0.01);
    }


    @Test
    public void exemploVender(){
        Funcionario carlos = new Gerente("Carlos Silva", "997663362", "12348651", "0001");

    }

}
