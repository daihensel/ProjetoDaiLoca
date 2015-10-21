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
 * Populartabelafuncionario generated by hbm2java
 */
@Entity
@Table(name = "Populartabelafuncionario", schema = "public")
public class Populartabelafuncionario implements java.io.Serializable {

    @Id
    @Column(name = "idpessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpessoa;
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
  @Column(name = "rg", nullable = false, length = 45)
    private String rg;
    @Column(name = "cpf", nullable = false, length = 45)
    private String cpf;
	@Column(name = "descricaocontato", nullable = false, length = 45)
    private String descricaocontato;
    @Temporal(TemporalType.DATE)
    @Column(name = "dt_admissao", nullable = false, length = 13)
    private Date dtAdmissao;
    @Column(name = "login", length = 30)
    private String login;
	@Column(name = "descricaofuncao", nullable = false, length = 45)
    private String descricaofuncao;
    
    public Populartabelafuncionario() {
    }

    

    public int getIdpessoa() {
        return this.idpessoa;
    }

    public void setIdpessoa(int Idpessoa) {
        this.idpessoa = Idpessoa;
    }

	    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
	
    public Date getDtAdmissao() {
        return this.dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmissao) {
        this.dtAdmissao = dtAdmissao;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
	 public String getDescricaofuncao() {
        return this.descricaofuncao;
    }

    public void setDescricaofuncao(String descricaofuncao) {
        this.descricaofuncao = descricaofuncao;
    }

	
	
}