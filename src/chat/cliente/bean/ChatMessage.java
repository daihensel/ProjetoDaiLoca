/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.cliente.bean;

import java.awt.Desktop.Action;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author diego
 */
public class ChatMessage implements Serializable {
    
    private String nome;
    private String texto;
    private String nomeReservado;
    private Set<String> setOnlines = new HashSet<String>();
    private Action action;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the nomeReservado
     */
    public String getNomeReservado() {
        return nomeReservado;
    }

    /**
     * @param nomeReservado the nomeReservado to set
     */
    public void setNomeReservado(String nomeReservado) {
        this.nomeReservado = nomeReservado;
    }

    /**
     * @return the setOnlines
     */
    public Set<String> getSetOnlines() {
        return setOnlines;
    }

    /**
     * @param setOnlines the setOnlines to set
     */
    public void setSetOnlines(Set<String> setOnlines) {
        this.setOnlines = setOnlines;
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }
    
    public enum Action{
        CONECT, DISCONECT, SEND_ONE,SEND_ALL, USERS_ONLINE
    }
    
}
