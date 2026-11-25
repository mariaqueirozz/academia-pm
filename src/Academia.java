import java.util.ArrayList;
import java.util.List;

public class Academia {
    private List<Atividade> atividades = new ArrayList<>();
    private List<Plano> planos = new ArrayList<>();

    public void cadastrarAtividade(Atividade a) { atividades.add(a); }
    public void cadastrarPlano(Plano p) { planos.add(p); }

    public boolean associarAtividadeAoPlano(int idxPlano, int idxAtividade) {
        if (!planoValido(idxPlano) || !atividadeValida(idxAtividade)) return false;
        return planos.get(idxPlano).associarAtividade(atividades.get(idxAtividade));
    }

    public void exibirAtividades() {
        if (atividades.isEmpty()) System.out.println("Nenhuma atividade cadastrada.");
        for (int i = 0; i < atividades.size(); i++) {
            System.out.println(i + " - " + atividades.get(i));
        }
    }

    public void exibirPlanos(boolean apenasAtivos) {
        boolean achou = false;
        for (int i = 0; i < planos.size(); i++) {
            Plano p = planos.get(i);
            if (!apenasAtivos || p.getStatus() == StatusPlano.ATIVO) {
                System.out.println(i + " - " + p);
                achou = true;
            }
        }
        if (!achou) System.out.println("Nenhum plano encontrado.");
    }

    public void emitirCertificado(int idx, String nome) {
        if (!atividadeValida(idx)) { System.out.println("Atividade inválida."); return; }
        Atividade a = atividades.get(idx);
        if (a instanceof Certificavel) {
            ((Certificavel) a).emitirCertificado(nome);
        } else {
            System.out.println("Esta atividade não emite certificado.");
        }
    }

    public void registrarPresenca(int idx, String nome) {
        if (!atividadeValida(idx)) { System.out.println("Atividade inválida."); return; }
        Atividade a = atividades.get(idx);
        if (a instanceof ControladorPresenca) {
            ((ControladorPresenca) a).registrarPresenca(nome);
        } else {
            System.out.println("Esta atividade não controla presença.");
        }
    }

    public void removerAtividadesInativas() {
        List<Atividade> inativas = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a.getStatus() == StatusAtividade.INATIVA) inativas.add(a);
        }
        for (Plano p : planos) {
            for (Atividade a : inativas) p.removerAtividade(a);
        }
        atividades.removeAll(inativas);
        System.out.println(inativas.size() + " atividade(s) inativa(s) removida(s).");
    }

    private boolean atividadeValida(int i) { return i >= 0 && i < atividades.size(); }
    private boolean planoValido(int i) { return i >= 0 && i < planos.size(); }
}