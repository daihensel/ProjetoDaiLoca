package entidade;
// Generated 17/08/2015 19:54:52 by Hibernate Tools 4.3.1

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 * Cidade generated by hbm2java
 */
@Entity
@Table(name = "cidade", schema = "public")
public class Cidade implements java.io.Serializable {

    

    @Id
    @Column(name = "idCidade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idcidade;

    private Estado estado;
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cidade")
    private Set enderecos = new HashSet(0);

    public Cidade() {
    }

    public Cidade(int idcidade, Estado estado, String descricao, int paisIdpais1) {
        this.idcidade = idcidade;
        this.estado = estado;
        this.descricao = descricao;
    }

    public Cidade(int idcidade, Estado estado, String descricao, Set enderecos) {
        this.idcidade = idcidade;
        this.estado = estado;
        this.descricao = descricao;
        this.enderecos = enderecos;
    }

    public int getIdcidade() {
        return this.idcidade;
    }

    public void setIdcidade(int idcidade) {
        int oldIdcidade = this.idcidade;
        this.idcidade = idcidade;

    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado estado) {
        Estado oldEstado = this.estado;
        this.estado = estado;

    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;

    }

    public Set getEnderecos() {
        return this.enderecos;
    }

    public void setEnderecos(Set enderecos) {
        this.enderecos = enderecos;
    }

}
