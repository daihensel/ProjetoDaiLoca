package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

import java.math.BigDecimal;
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
 * Populartabelalocacao generated by hbm2java
 */
@Entity
@Table(name = "Populartabelalocacao", schema = "public")
public class Populartabelalocacao implements java.io.Serializable {

    @Id
    @Column(name = "idlocacao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idlocacao;
    @Column(name = "nomecliente", nullable = false, length = 45)
    private String nomecliente;
    @Column(name = "rg", nullable = false, length = 45)
    private String rg;
    @Column(name = "cpf", nullable = false, length = 45)
    private String cpf;
    @Column(name = "telefone", nullable = false, length = 45)
    private String telefone;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_locacao", nullable = false, length = 13)
    private Date dtlocacao;
    @Column(name = "dtdevolucao", nullable = false)
    private Date dtdevolucao;
    @Column(name = "valor_total", nullable = false, precision = 11)
    private BigDecimal valorTotal;
    @Column(name = "num_parcelas", nullable = false)
    private int num_parcelas;
    @Column(name = "descricaoveiculo", nullable = false, length = 45)
    private String descricaoveiculo;
    @Column(name = "descricaotipoveiculo", nullable = false, length = 45)
    private String descricaotipoveiculo;

    public Populartabelalocacao() {
    }

    public int getIdlocacao() {
        return this.idlocacao;
    }

    public void setIdlocacao(int idlocacao) {
        this.idlocacao = idlocacao;
    }

    public String getNomecliente() {
        return this.nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getnum_parcelas() {
        return this.num_parcelas;
    }

    public void setnum_parcelas(int num_parcelas) {
        this.num_parcelas = num_parcelas;
    }

    public String getDescricaoVeiculo() {
        return this.descricaoveiculo;
    }

    public void setDescricaoVeiculo(String descricaoveiculo) {
        String oldDescricaoveiculo = this.descricaoveiculo;
        this.descricaoveiculo = descricaoveiculo;
    }

    public String getDescricaoTipoVeiculo() {
        return this.descricaotipoveiculo;
    }

    public void setDescricaoTipoVeiculo(String descricaotipoveiculo) {
        String olddescricaotipoveiculo = this.descricaotipoveiculo;
        this.descricaotipoveiculo = descricaotipoveiculo;

    }
}
