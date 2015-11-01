/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daiane
 */
@Entity
@Table(name = "Populartabelaveiculo", schema = "public")
public class Populartabelaveiculo implements Serializable {

    @Id
    @Column(name = "idveiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idveiculo;
    @Column(name = "descricaoveiculo", nullable = false, length = 45)
    private String descricaoveiculo;
    @Column(name = "descricaotipo", nullable = false, length = 45)
    private String descricaotipo;
    @Column(name = "marca", nullable = false, length = 45)
    private String marca;
    @Column(name = "ano_fabricacao", nullable = false)
    private int anoFabricacao;
    @Column(name = "ano_modelo", nullable = false)
    private int anoModelo;
    @Column(name = "km_atual", nullable = false)
    private int kmAtual;
    @Column(name = "valor_diaria", nullable = false, precision = 11)
    private BigDecimal valorDiaria;

    public Populartabelaveiculo() {

    }

    public int getIdveiculo() {
        return this.idveiculo;
    }

    public void setIdveiculo(int idveiculo) {
        this.idveiculo = idveiculo;

    }

    public String getDescricaoVeiculo() {
        return this.descricaoveiculo;
    }

    public void setDescricaoVeiculo(String descricaoveiculo) {
        this.descricaoveiculo = descricaoveiculo;
    }

    public String getDescricaoTipo() {
        return this.descricaotipo;
    }

    public void setDescricaoTipo(String descricaotipo) {
        this.descricaotipo = descricaotipo;

    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        String oldMarca = this.marca;
        this.marca = marca;

    }

    public int getAnoFabricacao() {
        return this.anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;

    }

    public int getAnoModelo() {
        return this.anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;

    }

    public int getKmAtual() {
        return this.kmAtual;
    }

    public void setKmAtual(int kmAtual) {
        this.kmAtual = kmAtual;

    }

    public BigDecimal getValorDiaria() {
        return this.valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

}
