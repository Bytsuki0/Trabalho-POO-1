package estacionamento;


public class Estacionamento {
    private static final int MAX_CARROS = 50;
    private static final int MAX_MOTOS = 30;
    private static final int MAX_CAMINHOES = 10;

    private Carro[] carros = new Carro[MAX_CARROS];
    private Moto[] motos = new Moto[MAX_MOTOS];
    private Caminhao[] caminhoes = new Caminhao[MAX_CAMINHOES];
    private double receitaTotal = 0;

    public void registrarEntrada(String tipo, String placa, int hora, int minuto) {
        switch (tipo.toLowerCase()) {
            case "carro":    inserirVeiculo(carros, placa, hora, minuto, "Carro"); break;
            case "moto":     inserirVeiculo(motos, placa, hora, minuto, "Moto"); break;
            case "caminhão":
            case "caminhao": inserirVeiculo(caminhoes, placa, hora, minuto, "Caminhão"); break;
            default:
                System.out.println("Tipo de veículo inválido.");
        }
    }

    @SuppressWarnings("unchecked")
	private <T extends Veiculo> void inserirVeiculo(T[] array, String placa, int hora, int minuto, String tipo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].getPlaca().equals(placa)) {
                System.out.println("Veículo já registrado no estacionamento.");
                return;
            }
            if (array[i] == null) {
                try {
                    T v = (T) Class.forName("" + tipo).getConstructor(String.class, int.class, int.class)
                              .newInstance(placa, hora, minuto);
                    array[i] = v;
                } catch (Exception e) {
                    if (tipo.equals("Carro"))    array[i] = (T) new Carro(placa, hora, minuto);
                    if (tipo.equals("Moto"))     array[i] = (T) new Moto(placa, hora, minuto);
                    if (tipo.equals("Caminhão")) array[i] = (T) new Caminhao(placa, hora, minuto);
                }
                System.out.println("Entrada registrada: " + tipo + " - Placa: " + placa +
                                   " às " + hora + "h" + String.format("%02d", minuto));
                return;
            }
        }
        System.out.println("Sem vagas disponíveis para " + tipo.toLowerCase() + "s.");
    }

    public void registrarSaida(String placa, int horaSaida, int minutoSaida) {
        if (processarSaida(carros, placa, horaSaida, minutoSaida)) return;
        if (processarSaida(motos, placa, horaSaida, minutoSaida)) return;
        if (processarSaida(caminhoes, placa, horaSaida, minutoSaida)) return;
        System.out.println("Veículo não encontrado no estacionamento.");
    }

    private <T extends Veiculo> boolean processarSaida(T[] array, String placa, int hora, int minuto) {
        for (int i = 0; i < array.length; i++) {
            T v = array[i];
            if (v != null && v.getPlaca().equals(placa)) {
                array[i] = null;
                int horaentrada = v.getHoraEntrada();
                int minentrada = v.getMinutoEntrada();
                int entradaMin = v.getHoraEntrada() * 60 + v.getMinutoEntrada();
                int saidaMin = hora * 60 + minuto;
                int totalMin = saidaMin - entradaMin;
                if (totalMin < 0) totalMin += 24 * 60; 
                double horasEstadia = totalMin / 60.0;
                double tarifa = v.calcularTarifaBasica(horasEstadia);
                double multa  = v.calcularMulta(horasEstadia);
                double total  = tarifa + multa;
                receitaTotal += total;
                System.out.printf("Saída: %s | Hora de Entrada:%dh%d | Hora de Saída:%dh%d | Duração: %.0f h | Tarifa: R$%.2f | Multa: R$%.2f | Total: R$%.2f%n",
                                  placa,horaentrada, minentrada, hora, minuto, horasEstadia, tarifa, multa, total);
                return true;
            }
        }
        return false;
    }

    public void mostrarStatus() {
        System.out.println("Vagas disponíveis - Carros: " + contarVagasLivres(carros) + "/" + MAX_CARROS);
        System.out.println("Vagas disponíveis - Motos: "   + contarVagasLivres(motos)  + "/" + MAX_MOTOS);
        System.out.println("Vagas disponíveis - Caminhões: " + contarVagasLivres(caminhoes) + "/" + MAX_CAMINHOES);
    }

    private <T> int contarVagasLivres(T[] array) {
        int livres = 0;
        for (T v : array) if (v == null) livres++;
        return livres;
    }

    public void listarVeiculos() {
        System.out.println("Veículos estacionados:");
        mostrarLista(carros);
        mostrarLista(motos);
        mostrarLista(caminhoes);
    }

    private <T extends Veiculo> void mostrarLista(T[] array) {
        for (T v : array) {
            if (v != null) {
                System.out.println(v.getClass().getSimpleName() +
                                   " | Placa: " + v.getPlaca() +
                                   " | Entrada: " + v.getHoraEntrada() + "h" +
                                   String.format("%02d", v.getMinutoEntrada()));
            }
        }
    }

    public void mostrarRelatorioReceita() {
        System.out.printf("Receita total até o momento: R$%.2f%n", receitaTotal);
    }
}
