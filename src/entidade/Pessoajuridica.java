package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Pessoajuridica generated by hbm2java
 */
@Entity
@Table(name = "pessoajuridica", schema = "public")
public class Pessoajuridica implements java.io.Serializable {

    @GenericGenerator(name = "generator", strategy = "foreign", parameters =
    @Parameter(name = "property", value = "pessoa"))
    @Id
    @Column(name = "pessoa_idpessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pessoaIdpessoa;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Pessoa pessoa;
    @Column(name = "cnpj", nullable = false, length = 20)
    private String cnpj;
    @Column(name = "inscricaoest", length = 20)
    private String inscricaoest;

    public Pessoajuridica() {
    }

    public Pessoajuridica(Pessoa pessoa, String cnpj) {
        this.pessoa = pessoa;
        this.cnpj = cnpj;
    }

    public Pessoajuridica(Pessoa pessoa, String cnpj, String nome, String inscricaoest) {
        this.pessoa = pessoa;
        this.cnpj = cnpj;
        this.inscricaoest = inscricaoest;
    }

    public int getPessoaIdpessoa() {
        return this.pessoaIdpessoa;
    }

    public void setPessoaIdpessoa(int pessoaIdpessoa) {
        this.pessoaIdpessoa = pessoaIdpessoa;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }



    public String getInscricaoest() {
        return this.inscricaoest;
    }

    public void setInscricaoest(String inscricaoest) {
        this.inscricaoest = inscricaoest;
    }
}
