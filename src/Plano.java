import java.util.ArrayList;
import java.util.List;

public abstract class Plano {
    private String nome;
    private double valorMensal;
    private StatusPlano status;
    private List<Atividade> atividades = new ArrayList<>();

    public Plano(String nome, double valorMensal) {
        this.nome = nome;
        this.valorMensal = valorMensal;
        this.status = StatusPlano.ATIVO;
    }

    public abstract boolean permiteAtividade(Atividade atividade);

    public boolean associarAtividade(Atividade atividade) {
        if (!permiteAtividade(atividade) || atividades.contains(atividade)) {
            return false;
        }
        atividades.add(atividade);
        return true;
    }

    public void removerAtividade(Atividade atividade) { atividades.remove(atividade); }

    public String getNome() { return nome; }
    public double getValorMensal() { return valorMensal; }
    public StatusPlano getStatus() { return status; }
    public void setStatus(StatusPlano status) { this.status = status; }
    public List<Atividade> getAtividades() { return atividades; }

    @Override
    public String toString() {
        String s = nome + " | R$ " + String.format("%.2f", valorMensal) + " | " + status;
        for (Atividade a : atividades) {
            s += "\n      - " + a.getNome();
        }
        return s;
    }
}