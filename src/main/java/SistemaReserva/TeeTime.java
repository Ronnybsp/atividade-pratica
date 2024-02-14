package SistemaReserva;

import java.util.Date;

public class TeeTime {
    private Date dataHora;
    private boolean carrinhoDisponivel;
    private double preco;
    private int capacidadeMaximaJogadores;

    public TeeTime(Date dataHora, boolean carrinhoDisponivel, double preco, int capacidadeMaximaJogadores) {
        this.dataHora = dataHora;
        this.carrinhoDisponivel = carrinhoDisponivel;
        this.preco = preco;
        this.capacidadeMaximaJogadores = capacidadeMaximaJogadores;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public boolean isCarrinhoDisponivel() {
        return carrinhoDisponivel;
    }

    public void setCarrinhoDisponivel(boolean carrinhoDisponivel) {
        this.carrinhoDisponivel = carrinhoDisponivel;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getCapacidadeMaximaJogadores() {
        return capacidadeMaximaJogadores;
    }

    public void setCapacidadeMaximaJogadores(int capacidadeMaximaJogadores) {
        this.capacidadeMaximaJogadores = capacidadeMaximaJogadores;
    }

    
    
}