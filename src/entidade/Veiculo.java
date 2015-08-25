package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Veiculo generated by hbm2java
 */
@Entity
@Table(name = "veiculo", schema = "public")
public class Veiculo implements java.io.Serializable {

    @Id
    @Column(name = "idveiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idveiculo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipoveiculo", nullable = false)
    private Tipoveiculo tipoveiculo;
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;
    @Column(name = "marca", nullable = false, length = 45)
    private String marca;
    @Column(name = "ano_fabricacao", nullable = false)
    private int anoFabricacao;
    @Column(name = "ano_modelo", nullable = false)
    private int anoModelo;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_inclusao", nullable = false, length = 13)
    private Date dtInclusao;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_baixa", length = 13)
    private Date dtBaixa;
    private int kmAtual;

    public Veiculo() {
    }

    public Veiculo(int idveiculo, Tipoveiculo tipoveiculo, String descricao, String marca, int anoFabricacao, int anoModelo, Date dtInclusao, int kmAtual) {
        this.idveiculo = idveiculo;
        this.tipoveiculo = tipoveiculo;
        this.descricao = descricao;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.dtInclusao = dtInclusao;
        this.kmAtual = kmAtual;
    }

    public Veiculo(int idveiculo, Tipoveiculo tipoveiculo, String descricao, String marca, int anoFabricacao, int anoModelo, Date dtInclusao, Date dtBaixa, int kmAtual, Set locacaos, Set documentoses, Set reservas, Set manutencaos) {
        this.idveiculo = idveiculo;
        this.tipoveiculo = tipoveiculo;
        this.descricao = descricao;
        this.marca = marca;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.dtInclusao = dtInclusao;
        this.dtBaixa = dtBaixa;
        this.kmAtual = kmAtual;

    }

    public int getIdveiculo() {
        return this.idveiculo;
    }

    public void setIdveiculo(int idveiculo) {
        this.idveiculo = idveiculo;
    }

    public Tipoveiculo getTipoveiculo() {
        return this.tipoveiculo;
    }

    public void setTipoveiculo(Tipoveiculo tipoveiculo) {
        this.tipoveiculo = tipoveiculo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
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

    public Date getDtInclusao() {
        return this.dtInclusao;
    }

    public void setDtInclusao(Date dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public Date getDtBaixa() {
        return this.dtBaixa;
    }

    public void setDtBaixa(Date dtBaixa) {
        this.dtBaixa = dtBaixa;
    }

    public int getKmAtual() {
        return this.kmAtual;
    }

    public void setKmAtual(int kmAtual) {
        this.kmAtual = kmAtual;
    }
}
