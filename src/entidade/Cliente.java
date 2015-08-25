package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "cliente", schema = "public")
public class Cliente implements java.io.Serializable {

    @GenericGenerator(name = "generator", strategy = "foreign", parameters =
    @Parameter(name = "property", value = "pessoa"))
    @Id
    @Column(name = "pessoa_idpessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pessoaIdpessoa;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Pessoa pessoa;
    @Column(name = "dt_cadastro", length = 45)
    private String dtCadastro;

    public Cliente() {
    }

    public Cliente(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cliente(Pessoa pessoa, String dtCadastro, Set locacaos, Set reservas) {
        this.pessoa = pessoa;
        this.dtCadastro = dtCadastro;

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

    public String getDtCadastro() {
        return this.dtCadastro;
    }

    public void setDtCadastro(String dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}
