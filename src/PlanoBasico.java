import java.util.HashSet;
import java.util.Set;

public class PlanoBasico extends Plano implements ControladorPresenca {
    private Set<String> acessosHoje = new HashSet<>();

    public PlanoBasico(String nome, double valorMensal) {
        super(nome, valorMensal);
    }

    @Override
    public boolean permiteAtividade(Atividade atividade) {
        return atividade.isIndividual();
    }

    @Override
    public void registrarPresenca(String nomeCliente) {
        if (acessosHoje.contains(nomeCliente)) {
            System.out.println("Limite de 1 acesso por dia atingido para " + nomeCliente + ".");
        } else {
            acessosHoje.add(nomeCliente);
            System.out.println("Acesso registrado: " + nomeCliente);
        }
    }

    @Override
    public String toString() { return "[Básico] " + super.toString(); }
}