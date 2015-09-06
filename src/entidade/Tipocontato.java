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
import javax.persistence.Table;

/**
 * Tipocontato generated by hbm2java
 */
@Entity
@Table(name = "tipocontato", schema = "public")
public class Tipocontato implements java.io.Serializable {

    @Id
    @Column(name = "idtipo_contato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtipoContato;
    @Column(name = "descricao", nullable = false, length = 60)
    private String descricao;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tipocontato")
    private Set contatos = new HashSet(0);

    public Tipocontato() {
    }

    public Tipocontato(int idtipoContato, String descricao) {
        this.idtipoContato = idtipoContato;
        this.descricao = descricao;
    }

    public Tipocontato(int idtipoContato, String descricao, Set contatos) {
        this.idtipoContato = idtipoContato;
        this.descricao = descricao;
        this.contatos = contatos;
    }

    public int getIdtipoContato() {
        return this.idtipoContato;
    }

    public void setIdtipoContato(int idtipoContato) {
        this.idtipoContato = idtipoContato;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set getContatos() {
        return this.contatos;
    }

    public void setContatos(Set contatos) {
        this.contatos = contatos;
    }
}
