package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

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
 * Populartabelareserva generated by hbm2java
 */
@Entity
@Table(name = "Populartabelareserva", schema = "public"
)
public class Populartabelareserva implements java.io.Serializable {

    @Id
    @Column(name = "idreserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idreserva;
    @Column(name = "nomecliente", nullable = false, length = 45)
    private String nomecliente;
    @Column(name = "rg", nullable = false, length = 45)
    private String rg;
    @Column(name = "cpf", nullable = false, length = 45)
    private String cpf;
    @Column(name = "descricaocontato", nullable = false, length = 45)
    private String descricaocontato;
    @Column(name = "dt_reserva", nullable = false, length = 13)
    private Date dtReserva;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_locacao", nullable = false, length = 13)
    private Date dtLocacao;
    @Column(name = "dias_pretendidos", nullable = false)
    private int diasPretendidos;
    @Column(name = "descricaoveiculo", nullable = false, length = 45)
    private String descricaoveiculo;
    @Column(name = "descricaotipo", nullable = false, length = 45)
    private String descricaotipo;

    public Populartabelareserva() {
    }

    public int getIdreserva() {
        return this.idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
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

    public String getDescricaocontato() {
        return this.descricaocontato;
    }

    public void setDescricaocontato(String descricaocontato) {
        this.descricaocontato = descricaocontato;
    }

    public Date getDtReserva() {
        return this.dtReserva;
    }

    public void setDtReserva(Date dtReserva) {
        this.dtReserva = dtReserva;
    }

    public Date getDtLocacao() {
        return this.dtLocacao;
    }

    public void setDtLocacao(Date dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public int getDiasPretendidos() {
        return this.diasPretendidos;
    }

    public void setDiasPretendidos(int diasPretendidos) {
        this.diasPretendidos = diasPretendidos;
    }

    public String getDescricaoVeiculo() {
        return this.descricaoveiculo;
    }

    public void setDescricaoVeiculo(String descricaoveiculo) {
        String oldDescricaoveiculo = this.descricaoveiculo;
        this.descricaoveiculo = descricaoveiculo;
    }

    public String getDescricaoTipo() {
        return this.descricaotipo;
    }

    public void setDescricaoTipo(String descricaotipo) {
        String oldDescricaoTipo = this.descricaotipo;
        this.descricaotipo = descricaotipo;

    }

}