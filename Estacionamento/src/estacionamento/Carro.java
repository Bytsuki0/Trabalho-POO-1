package estacionamento;

public class Carro extends Veiculo {
    private static final double TARIFA = 5.0;
    private static final double DURACAO_MAXIMA = 12.0;
    private static final double MULTA_POR_HORA = 5.0;

    public Carro(String placa, int horaEntrada, int minutoEntrada) {
        super(placa, horaEntrada, minutoEntrada);
    }
    @Override
    public double getTarifaPorHora() {
        return TARIFA;
    }

    @Override
    public double getDuracaoMaximaHoras() {
        return DURACAO_MAXIMA;
    }

    @Override
    public double getTarifaMultaPorHora() {
        return MULTA_POR_HORA;
    }
}