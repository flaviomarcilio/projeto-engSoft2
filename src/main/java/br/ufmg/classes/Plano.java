package br.ufmg.classes;

import br.ufmg.enums.OpcaoPagamento;
import br.ufmg.enums.TipoPlano;

import java.time.LocalDate;

public class Plano {
    private TipoPlano tipo;
    private double preco;
    private LocalDate dataCobranca;
    private OpcaoPagamento opcaoPagamento;

    public Plano(TipoPlano tipo, double preco, LocalDate dataCobranca, OpcaoPagamento opcaoPagamento) {
        this.tipo = tipo;
        this.preco = preco;
        this.dataCobranca = dataCobranca;
        this.opcaoPagamento = opcaoPagamento;
    }

    public Plano(TipoPlano tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    public TipoPlano getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlano tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getDataCobranca() {
        return dataCobranca;
    }

    public void setDataCobranca(LocalDate dataCobranca) {
        this.dataCobranca = dataCobranca;
    }

    public OpcaoPagamento getOpcaoPagamento() {
        return opcaoPagamento;
    }

    public void setOpcaoPagamento(OpcaoPagamento opcaoPagamento) {
        this.opcaoPagamento = opcaoPagamento;
    }
}
