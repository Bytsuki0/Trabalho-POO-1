package estacionamento;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Sistema de Estacionamento ---");
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Registrar Saída");
            System.out.println("3. Consultar Vagas Disponíveis");
            System.out.println("4. Listar Veículos Estacionados");
            System.out.println("5. Gerar Relatório de Receita");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt(); scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Tipo (Carro/Moto/Caminhão): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Hora de entrada (0-23): ");
                    int horaEnt = scanner.nextInt();
                    System.out.print("Minuto de entrada (0-59): ");
                    int minEnt = scanner.nextInt(); scanner.nextLine();
                    estacionamento.registrarEntrada(tipo, placa, horaEnt, minEnt);
                    break;
                case 2:
                    System.out.print("Placa: ");
                    String placaSaida = scanner.nextLine();
                    System.out.print("Hora de saída (0-23): ");
                    int horaSai = scanner.nextInt();
                    System.out.print("Minuto de saída (0-59): ");
                    int minSai = scanner.nextInt(); scanner.nextLine();
                    estacionamento.registrarSaida(placaSaida, horaSai, minSai);
                    break;
                case 3:
                    estacionamento.mostrarStatus();
                    break;
                case 4:
                    estacionamento.listarVeiculos();
                    break;
                case 5:
                    estacionamento.mostrarRelatorioReceita();
                    break;
                case 6:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
