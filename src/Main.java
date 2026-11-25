import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Academia academia = new Academia();
        popular(academia);

        int op;
        do {
            System.out.println("\n===== ACADEMIA =====");
            System.out.println("1 - Associar atividade a plano");
            System.out.println("2 - Exibir atividades");
            System.out.println("3 - Exibir planos");
            System.out.println("4 - Exibir planos ativos");
            System.out.println("5 - Emitir certificado");
            System.out.println("6 - Registrar presença");
            System.out.println("7 - Remover atividades inativas");
            System.out.println("0 - Sair");
            op = lerInt("Escolha: ");

            switch (op) {
                case 1:
                    academia.exibirPlanos(false);
                    int p = lerInt("Índice do plano: ");
                    academia.exibirAtividades();
                    int a = lerInt("Índice da atividade: ");
                    if (academia.associarAtividadeAoPlano(p, a)) {
                        System.out.println("Atividade associada!");
                    } else {
                        System.out.println("Não foi possível associar (plano não permite ou já associada).");
                    }
                    break;
                case 2: academia.exibirAtividades(); break;
                case 3: academia.exibirPlanos(false); break;
                case 4: academia.exibirPlanos(true); break;
                case 5:
                    academia.exibirAtividades();
                    int ic = lerInt("Índice da atividade: ");
                    academia.emitirCertificado(ic, lerTexto("Nome do participante: "));
                    break;
                case 6:
                    academia.exibirAtividades();
                    int ip = lerInt("Índice da atividade: ");
                    academia.registrarPresenca(ip, lerTexto("Nome do participante: "));
                    break;
                case 7: academia.removerAtividadesInativas(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (op != 0);
    }

    private static void popular(Academia academia) {
        Atividade musc = new Musculacao("Musculação Livre", "07:00", 60, 30, 20);
        Atividade nat = new Natacao("Natação Adulto", "18:00", 45, 15, 1.8);
        Atividade spin = new Spinning("Spinning Noturno", "19:30", 50, 20, 15);
        spin.setStatus(StatusAtividade.INATIVA); // para testar a opção 7

        academia.cadastrarAtividade(musc);
        academia.cadastrarAtividade(nat);
        academia.cadastrarAtividade(spin);

        Plano basico = new PlanoBasico("Básico", 99.90);
        Plano premium = new PlanoPremium("Premium", 199.90);
        academia.cadastrarPlano(basico);
        academia.cadastrarPlano(premium);
    }

    private static int lerInt(String msg) {
        System.out.print(msg);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}