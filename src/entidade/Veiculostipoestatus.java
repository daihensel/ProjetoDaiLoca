/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Daiane
 */
@Entity
@Table(name = "Veiculostipoestatus", schema = "public")
public class Veiculostipoestatus implements Serializable {
     @Id
    @Column(name = "idveiculo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idveiculo;
    @Column(name = "descricaoveiculo", nullable = false, length = 45)
    private String descricaoveiculo;
    @Column(name = "descricaotipo", nullable = false, length = 45)
    private String descricaotipo;
    @Column(name = "descricaostatus", nullable = false, length = 45)
    private String descricaostatus;
    
    public Veiculostipoestatus() {
    
}
    
     public int getIdveiculo() {
        return this.idveiculo;
    }

    public void setIdveiculo(int idveiculo) {
        int oldIdveiculo = this.idveiculo;
        this.idveiculo = idveiculo;
       
    }
        public String getDescricaoVeiculo() {
        return this.descricaoveiculo;
    }

    public void setDescricaoVeiculo(String descricaoveiculo) {
        String oldDescricaoveiculo = this.descricaoveiculo;
        this.descricaoveiculo = descricaoveiculo;
    }
        
   public String getDescricaoTipo() {
        return this.descricaotipo;
    }

    public void setDescricaoTipo(String descricaotipo) {
        String oldDescricaoTipo = this.descricaotipo;
        this.descricaotipo = descricaotipo;
        
    }
        public String getDescricaoStatus() {
        return this.descricaostatus;
    }

    public void setDescricaoStatus(String descricaostatus) {
        String oldDescricaoStatus = this.descricaostatus;
        this.descricaostatus = descricaostatus;
        
    }
        
    
}
