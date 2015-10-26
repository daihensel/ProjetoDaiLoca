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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Funcionario generated by hbm2java
 */
@Entity
@Table(name = "funcionario", schema = "public")
public class Funcionario implements java.io.Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "foreign", parameters =
    @Parameter(name = "property", value = "pessoa"))
    @Column(name = "pessoa_idpessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pessoaIdpessoa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcao_idfuncao", nullable = false)
    private Funcao funcao;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Pessoa pessoa;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_admissao", nullable = false, length = 13)
    private Date dtAdmissao;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_demissao", length = 13)
    private Date dtDemissao;
    @Column(name = "num_ctps", nullable = false, length = 45)
    private String numCtps;
    @Column(name = "serie_ctps", nullable = false, length = 45)
    private String serieCtps;
    @Column(name = "login", length = 30)
    private String login;
    @Column(name = "senha", length = 15)
    private String senha;
    @OneToMany(fetch=FetchType.LAZY, mappedBy="funcionario")

    private Set<Reserva> reservas = new HashSet(0);
    @OneToMany(fetch=FetchType.LAZY, mappedBy="funcionario")
     private Set<Locacao> locacaos = new HashSet(0);

    public Funcionario() {
    }

    public Funcionario(Funcao funcao, Pessoa pessoa, Date dtAdmissao, String numCtps, String serieCtps) {
        this.funcao = funcao;
        this.pessoa = pessoa;
        this.dtAdmissao = dtAdmissao;
        this.numCtps = numCtps;
        this.serieCtps = serieCtps;
    }

    public Funcionario(entidade.Funcao funcao, Pessoa pessoa, Date dtAdmissao, Date dtDemissao, String numCtps, String serieCtps, String login, String senha, Set reservas, Set locacaos) {
       this.funcao = funcao;
       this.pessoa = pessoa;
       this.dtAdmissao = dtAdmissao;
       this.dtDemissao = dtDemissao;
       this.numCtps = numCtps;
       this.serieCtps = serieCtps;
       this.login = login;
       this.senha = senha;
       this.reservas = reservas;
       this.locacaos = locacaos;
    }

    public int getPessoaIdpessoa() {
        return this.pessoaIdpessoa;
    }

    public void setPessoaIdpessoa(int pessoaIdpessoa) {
        this.pessoaIdpessoa = pessoaIdpessoa;
    }

    public Funcao getFuncao() {
        return this.funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getDtAdmissao() {
        return this.dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public Date getDtDemissao() {
        return this.dtDemissao;
    }

    public void setDtDemissao(Date dtDemissao) {
        this.dtDemissao = dtDemissao;
    }

    public String getNumCtps() {
        return this.numCtps;
    }

    public void setNumCtps(String numCtps) {
        this.numCtps = numCtps;
    }

    public String getSerieCtps() {
        return this.serieCtps;
    }

    public void setSerieCtps(String serieCtps) {
        this.serieCtps = serieCtps;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public Set getReservas() {
        return this.reservas;
    }
    
    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }

    public Set getLocacaos() {
        return this.locacaos;
    }
    
    public void setLocacaos(Set locacaos) {
        this.locacaos = locacaos;
    }
}
