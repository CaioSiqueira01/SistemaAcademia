import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Outras classes (Membro, Aula, RegistroFrequencia, Academia) permanecem as mesmas

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Academia academia = new Academia();
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Academia");
            System.out.println("1. Cadastrar Membro");
            System.out.println("2. Registrar Aula");
            System.out.println("3. Listar Aulas Disponíveis");
            System.out.println("4. Inscrever Membro em Aula");
            System.out.println("5. Registrar Frequência");
            System.out.println("6. Listar Registros de Frequência");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do membro: ");
                    String nomeMembro = scanner.nextLine();
                    System.out.print("Digite o ID do membro: ");
                    int idMembro = scanner.nextInt();
                    System.out.print("Pagamento em dia? (true/false): ");
                    boolean pagamentoEmDia = scanner.nextBoolean();
                    scanner.nextLine(); // Limpa o buffer

                    Membro membro = new Membro(nomeMembro, idMembro, pagamentoEmDia);
                    academia.adicionarMembro(membro);
                    System.out.println("Membro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome da aula: ");
                    String nomeAula = scanner.nextLine();
                    System.out.print("Digite o nome do instrutor: ");
                    String instrutor = scanner.nextLine();
                    System.out.print("Digite a capacidade máxima da aula: ");
                    int capacidadeMaxima = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer

                    Aula aula = new Aula(nomeAula, instrutor, capacidadeMaxima);
                    academia.adicionarAula(aula);
                    System.out.println("Aula registrada com sucesso!");
                    break;

                case 3:
                    System.out.println("\nAulas Disponíveis:");
                    for (Aula a : academia.getAulas()) { // Usando o getter getAulas()
                        System.out.println("- " + a.getNome() + " (Instrutor: " + a.getInstrutor() +
                                        ", Capacidade: " + a.getMembrosInscritos().size() + "/" +
                                        a.getCapacidadeMaxima() + ")");
                    }
                    break;

                case 4:
                    System.out.print("Digite o ID do membro: ");
                    int idParaInscricao = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Digite o nome da aula: ");
                    String aulaParaInscricao = scanner.nextLine();

                    if (academia.inscreverMembroEmAula(idParaInscricao, aulaParaInscricao)) {
                        System.out.println("Membro inscrito com sucesso na aula " + aulaParaInscricao);
                    } else {
                        System.out.println("Falha na inscrição. Verifique se o pagamento está em dia ou se há vagas.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o ID do membro: ");
                    int idParaFrequencia = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Digite o nome da aula: ");
                    String aulaParaFrequencia = scanner.nextLine();

                    academia.registrarFrequencia(idParaFrequencia, aulaParaFrequencia, new Date());
                    System.out.println("Frequência registrada com sucesso!");
                    break;

                case 6:
                    System.out.println("\nRegistros de Frequência:");
                    for (RegistroFrequencia registro : academia.listarRegistrosFrequencia()) {
                        String dataFormatada = formatoData.format(registro.getData());
                        System.out.println("Aula: " + registro.getAula().getNome() +
                                           ", Membro: " + registro.getMembro().getNome() +
                                           ", Data: " + dataFormatada);
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
