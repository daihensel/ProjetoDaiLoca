/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.cliente.service;

import chat.cliente.bean.ChatMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket connect() {
        //aqui se tiver as maquinas na rede ao invez de localhost, colocar o ip do servidor
        try {
            this.socket = new Socket("localhost", 5555);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socket;
    }
    public void send(ChatMessage message){
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ClienteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
}
