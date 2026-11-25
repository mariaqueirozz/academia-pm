public class PlanoPremium extends Plano {
    public PlanoPremium(String nome, double valorMensal) {
        super(nome, valorMensal);
    }

    @Override
    public boolean permiteAtividade(Atividade atividade) { return true; }

    @Override
    public String toString() { return "[Premium] " + super.toString(); }
}