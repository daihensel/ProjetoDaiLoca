/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daiane
 */
@Entity
@Table(name = "Veiculostipoestatusreserva", schema = "public")
public class Veiculostipoestatusreserva implements Serializable {

    @Id
    @Column(name = "idveiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idveiculo;
    @Column(name = "descricaoveiculo", nullable = false, length = 45)
    private String descricaoveiculo;
    @Column(name = "descricaotipo", nullable = false, length = 45)
    private String descricaotipo;
    @Temporal(TemporalType.DATE)
    @Column(name = "dtreserva", nullable = false, length = 13)
    private Date dtReserva;
    @Temporal(TemporalType.DATE)
    @Column(name = "dtlocacao", nullable = false, length = 13)
    private Date dtlocacao;
    @Temporal(TemporalType.DATE)
    @Column(name = "dtdevolucao", nullable = false)
    private Date dtdevolucao;
    @Column(name = "nomecliente", nullable = false, length = 45)
    private String nomecliente;

    public Veiculostipoestatusreserva() {

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
    
     public Date getDtReserva() {
        return this.dtReserva;
    }

    public void setDtReserva(Date dtReserva) {
        this.dtReserva = dtReserva;
    }

    public Date getDtLocacao() {
        return this.dtlocacao;
    }

    public void setDtLocacao(Date dtlocacao) {
        this.dtlocacao = dtlocacao;
    }

    public Date getDtDevolucao() {
        return this.dtdevolucao;
    }

    public void setDtDevolucao(Date dtdevolucao) {
        this.dtdevolucao = dtdevolucao;
    }
     public String getNomecliente() {
        return this.nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

}
