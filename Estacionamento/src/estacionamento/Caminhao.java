package estacionamento;

public class Caminhao extends Veiculo {
    private static final double TARIFA = 10.0;
    private static final double DURACAO_MAXIMA = 48.0;
    private static final double MULTA_POR_HORA = 10.0;

    public Caminhao(String placa, int horaEntrada, int minutoEntrada) {
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