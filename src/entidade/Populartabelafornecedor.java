package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Populartabelafornecedor generated by hbm2java
 */
@Entity
@Table(name = "Populartabelafornecedor", schema = "public")
public class Populartabelafornecedor implements java.io.Serializable {

    @Id
    @Column(name = "idpessoa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpessoa;
    @Column(name = "nome", nullable = false, length = 45)
    private String nome;
    @Column(name = "cnpj", nullable = false, length = 20)
    private String cnpj;
    @Column(name = "descricaocontato", nullable = false, length = 45)
    private String descricaocontato;
    @Column(name = "descricaoendereco", nullable = false, length = 45)
    private String descricaoendereco;
    @Column(name = "bairro", nullable = false, length = 45)
    private String bairro;
    @Column(name = "descricaocidade", nullable = false, length = 45)
    private String descricaocidade;

    public Populartabelafornecedor() {
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

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescricaocontato() {
        return this.descricaocontato;
    }

    public void setDescricaocontato(String descricaocontato) {
        this.descricaocontato = descricaocontato;
    }

    public String getDescricaoendereco() {
        return this.descricaoendereco;
    }

    public void setDescricaoendereco(String descricaoendereco) {
        this.descricaoendereco = descricaoendereco;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDescricaocidade() {
        return this.descricaocidade;
    }

    public void setDescricaocidade(String descricaocidade) {
        this.descricaocidade = descricaocidade;
    }

}
