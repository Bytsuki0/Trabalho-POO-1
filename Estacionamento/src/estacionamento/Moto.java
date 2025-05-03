package estacionamento;

public class Moto extends Veiculo {
    private static final double TARIFA = 3.0;
    private static final double DURACAO_MAXIMA = 24.0;
    private static final double MULTA_POR_HORA = 3.0;

    public Moto(String placa, int horaEntrada, int minutoEntrada) {
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