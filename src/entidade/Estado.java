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
 * Estado generated by hbm2java
 */
@Entity
@Table(name = "estado", schema = "public"
)
public class Estado implements java.io.Serializable {

    @Id
    @Column(name = "idestado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idestado;
    @Column(name = "descricao", nullable = false, length = 45)
    private String descricao;
    @Column(name = "uf", nullable = false, length = 5)
    private String uf;
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
//    private Set<Cidade> cidades = new HashSet(0);

    public Estado() {
    }

    public Estado(int idestado, String descricao, String uf) {
        this.idestado = idestado;
        this.descricao = descricao;
        this.uf = uf;
    }

//    public Estado(int idestado, String descricao, String uf, Set cidades) {
//        this.idestado = idestado;
//        this.descricao = descricao;
//        this.uf = uf;
//        this.cidades = cidades;
//    }

    public int getIdestado() {
        return this.idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

//    public Set getCidades() {
//        return this.cidades;
//    }
//
//    public void setCidades(Set cidades) {
//        this.cidades = cidades;
//    }

}
