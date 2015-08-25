package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Manutencao generated by hbm2java
 */
@Entity
@Table(name = "manutencao", schema = "public")
public class Manutencao implements java.io.Serializable {

    @Id
    @Column(name = "idmanutencao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmanutencao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_idveiculo", nullable = false)
    private Veiculo veiculo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfornecedor", nullable = false)
    private Pessoajuridica pessoajuridica;
    @Column(name = "motivo", nullable = false, length = 100)
    private String motivo;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_manutencao", nullable = false, length = 13)
    private Date dtManutencao;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_retorno", nullable = false, length = 13)
    private Date dtRetorno;
    @Column(name = "observacao", length = 100)
    private String observacao;

    public Manutencao() {
    }

    public Manutencao(int idmanutencao, Veiculo veiculo, Pessoajuridica pessoajuridica, String motivo, Date dtManutencao, Date dtRetorno) {
        this.idmanutencao = idmanutencao;
        this.veiculo = veiculo;
        this.pessoajuridica = pessoajuridica;
        this.motivo = motivo;
        this.dtManutencao = dtManutencao;
        this.dtRetorno = dtRetorno;
    }

    public Manutencao(int idmanutencao, Veiculo veiculo, Pessoajuridica pessoajuridica, String motivo, Date dtManutencao, Date dtRetorno, String observacao) {
        this.idmanutencao = idmanutencao;
        this.veiculo = veiculo;
        this.pessoajuridica = pessoajuridica;
        this.motivo = motivo;
        this.dtManutencao = dtManutencao;
        this.dtRetorno = dtRetorno;
        this.observacao = observacao;
    }

    public Pessoajuridica getPessoajuridica() {
        return pessoajuridica;
    }

    public void setPessoajuridica(Pessoajuridica pessoajuridica) {
        this.pessoajuridica = pessoajuridica;
    }

    public int getIdmanutencao() {
        return this.idmanutencao;
    }

    public void setIdmanutencao(int idmanutencao) {
        this.idmanutencao = idmanutencao;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getMotivo() {
        return this.motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getDtManutencao() {
        return this.dtManutencao;
    }

    public void setDtManutencao(Date dtManutencao) {
        this.dtManutencao = dtManutencao;
    }

    public Date getDtRetorno() {
        return this.dtRetorno;
    }

    public void setDtRetorno(Date dtRetorno) {
        this.dtRetorno = dtRetorno;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
