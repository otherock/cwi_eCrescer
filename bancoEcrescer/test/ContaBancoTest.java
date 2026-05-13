import conta.ContaBanco;
import org.junit.Assert;
import org.junit.Test;
import pessoa.Pessoa;

public class ContaBancoTest {
    @Test
    public void deveAtualizarSaldoQuandoOcorrerUmSaque() {
        //arrange
        Pessoa arthur = new Pessoa("Arthur Rocha", "85589900000", "090909099292");
        ContaBanco contaArthur = new ContaBanco(111, arthur, 1000);
        double saldoEsperado = 700;

        //act
        contaArthur.sacar(300);

        //assert
        Assert.assertEquals(saldoEsperado, contaArthur.getSaldo(), 0.01);
    }

    @Test
    public void deveSacarComSucessoQuandoOcorrerUmSaque_comSaldoSuficiente() {
        //arrange
        Pessoa arthur = new Pessoa("Arthur Rocha", "85589900000", "090909099292");
        ContaBanco contaArthur = new ContaBanco(111, arthur);
        contaArthur.depositar(1000);

        //act
        boolean foiPossivelSacar = contaArthur.sacar(300);

        //assert
        Assert.assertTrue(foiPossivelSacar);
    }

    @Test
    public void naoDeveSacarQuandoOcorrerUmaTentativaDeSaqueSemSaldoSuficiente() {
        //arrange
        Pessoa arthur = new Pessoa("Arthur Rocha", "85589900000", "090909099292");
        ContaBanco contaArthur = new ContaBanco(111, arthur);
        contaArthur.depositar(1000);

        //act
        boolean foiPossivelSacar = contaArthur.sacar(1300);

        //assert
        Assert.assertFalse(foiPossivelSacar);

    }

    @Test
    public void deveManterOSaldoQuandoOcorrerUmaTentativaDeSaqueSemSaldoSuficiente() {
        //arrange
        Pessoa arthur = new Pessoa("Arthur Rocha", "85589900000", "090909099292");
        ContaBanco contaArthur = new ContaBanco(111, arthur);
        contaArthur.depositar(1000);
        double saldoEsperado = 1000;

        //act
        contaArthur.sacar(1200);

        //assert
        Assert.assertEquals(saldoEsperado, contaArthur.getSaldo(), 0.01);
    }

    @Test
    public void deveAtualizarSaldoQuandoOcorrerUmDeposito() {
        //arrange
        Pessoa arthur = new Pessoa("Arthur Rocha", "85589900000", "090909099292");
        ContaBanco contaArthur = new ContaBanco(111, arthur);
        contaArthur.depositar(1000);
        double saldoEsperado = 1500;

        //act
        contaArthur.depositar(500);

        //assert
        Assert.assertEquals(saldoEsperado, contaArthur.getSaldo(), 0.01);
    }


    //AULA 09 ENCAPSULAMENTO
    @Test
    public void deveAtualizarSaldoQuandoOcorrerUmaTransferencia() {
        //arrange
        Pessoa arthur = new Pessoa("Arthur Rocha", "85589900000", "090909099292");
        ContaBanco contaArthur = new ContaBanco(111, arthur);
        contaArthur.depositar(1000);

        Pessoa fernanda = new Pessoa("Fernanda Bittencourt", "72772777722", "3301301031");
        ContaBanco contaFernanda = new ContaBanco(111, fernanda);
        contaFernanda.depositar(2500);

        double saldoEsperadoContaOrigem = 400;

        //act
        contaArthur.transferir(contaFernanda, 600);

        //assert
        Assert.assertEquals(saldoEsperadoContaOrigem, contaArthur.getSaldo(), 0.01);
    }
}
