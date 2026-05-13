package pessoa;

public class Vendedor extends Funcionario{
    private int quantidadeVendas;

    public Vendedor(String nome, String cpf, String rg, String matricula) {
        super(nome, cpf, rg, matricula);
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(int quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }
}
