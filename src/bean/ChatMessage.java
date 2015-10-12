/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

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
    private String nomeReservedo;
    private Set<String> setOnlines = new HashSet<String>();
    private Action action;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNomeReservedo() {
        return nomeReservedo;
    }

    public void setNomeReservedo(String nomeReservedo) {
        this.nomeReservedo = nomeReservedo;
    }

    public Set<String> getSetOnlines() {
        return setOnlines;
    }

    public void setSetOnlines(Set<String> setOnlines) {
        this.setOnlines = setOnlines;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
        
    public enum Action {
        CONNECT, DISCONNECT, SEND_ONE, SEND_ALL, USERS_ONLINE
    }
}
