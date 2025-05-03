package estacionamento;


public abstract class Veiculo {
    protected String placa;
    protected int horaEntrada;    
    protected int minutoEntrada; 

    public Veiculo(String placa, int horaEntrada, int minutoEntrada) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
    }

    public String getPlaca() {
        return placa;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    public abstract double getTarifaPorHora();
    public abstract double getDuracaoMaximaHoras();
    public abstract double getTarifaMultaPorHora();


    public double calcularTarifaBasica(double horasEstadia) {
        return horasEstadia * getTarifaPorHora();
    }

    public double calcularMulta(double horasEstadia) {
        double excesso = horasEstadia - getDuracaoMaximaHoras();
        if (excesso > 0) {
            return excesso * getTarifaMultaPorHora();
        }
        return 0;
    }

    public double calcularTarifaTotal(double horasEstadia) {
        return calcularTarifaBasica(horasEstadia) + calcularMulta(horasEstadia);
    }
}