/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.HibernateUtil;
import static java.awt.Frame.MAXIMIZED_BOTH;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import bean.ChatMessage;
import bean.ChatMessage.Action;
import entidade.Veiculostipoestatus;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import org.hibernate.Query;
import service.ClienteService;

/**
 *
 * @author Daiane
 */
public class FormPrincipal extends javax.swing.JFrame {
    
    private Socket socket;
    private ChatMessage message;
    private ClienteService service;
    private String login;

    /**
     * Creates new form Principal
     */
    public FormPrincipal(String login) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
          this.popularTabelaVeiculos();
        pnChat.setVisible(false);
        tfNome.setText(login);
        this.btConectaActionPerformed(null);
        this.login=login;
    }
    
    private class ListenerSocket implements Runnable {
        
        private ObjectInputStream input;
        
        public ListenerSocket(Socket socket) {
            try {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        @Override
        public void run() {
            ChatMessage message = null;
            try {
                while ((message = (ChatMessage) input.readObject()) != null) {
                    Action action = message.getAction();

                    if (action.equals(Action.CONNECT)) {
                        connected(message);
                    } else if (action.equals(Action.DISCONNECT)) {
                        disconnected();
                        socket.close();
                    } else if (action.equals(Action.SEND_ONE)) {
                        System.out.println("::: " + message.getTexto() + " :::");
                        receive(message);
                    } else if (action.equals(Action.USERS_ONLINE)) {
                        refreshOnlines(message);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private void connected(ChatMessage message) {
        if (message.getTexto().equals("NO")) {
            this.tfNome.setText("");
            JOptionPane.showMessageDialog(this, "Tente com novo nome");
            return;
        }
        this.message = message;
        this.btConecta.setEnabled(false);
        this.tfNome.setEnabled(false);
        
        this.btSair.setEnabled(true);
        this.taEnvia.setEnabled(true);
        //this.taRecebe.setEditable(true);
        this.btEnviar.setEnabled(true);
        this.btLimpar.setEnabled(true);

        // JOptionPane.showMessageDialog(this, "Conexão realizada com sucesso!");
    }
    
    private void disconnected() {
        
        this.btConecta.setEnabled(true);
        this.tfNome.setEditable(true);
        
        this.btSair.setEnabled(false);
        this.taEnvia.setEnabled(false);
        // this.taRecebe.setEditable(false);
        this.btEnviar.setEnabled(false);
        this.btLimpar.setEnabled(false);
        
        taRecebe.setText("");
        taEnvia.setText("");
        
        JOptionPane.showMessageDialog(this, "Você saiu");
        
    }
    
    private void receive(ChatMessage message) {
        
        this.taRecebe.append(message.getNome() + " diz: " + message.getTexto() + "\n");
        
    }
    
    private void refreshOnlines(ChatMessage message) {
        
        Set<String> nomes = message.getSetOnlines();
        nomes.remove(message.getNome());
        String[] array = (String[]) nomes.toArray(new String[nomes.size()]);
        listaOnlines.setListData(array);
        listaOnlines.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaOnlines.setLayoutOrientation(JList.VERTICAL);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp = new javax.swing.JDesktopPane();
        pnGeral = new javax.swing.JPanel();
        pnMenus = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        pnTotais = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnLogados = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaOnlines = new javax.swing.JList();
        btAbrirChat = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pnChat = new javax.swing.JPanel();
        pnConectar = new javax.swing.JPanel();
        tfNome = new javax.swing.JTextField();
        btConecta = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        pnConversa = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taRecebe = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        taEnvia = new javax.swing.JTextArea();
        btLimpar = new javax.swing.JButton();
        btEnviar = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeiculos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Novo Fornecedor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Nova Locação");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Carro.png"))); // NOI18N
        jButton6.setText("Novo Veículo");

        jButton7.setText("Nova Manutenção");

        jButton8.setText("Novo Cliente");

        jButton4.setText("Nova Reserva");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setText("Status de Veículos:");

        jLabel2.setText("Disponíveis:");

        jLabel3.setText("5");

        jLabel4.setText("1");

        jLabel5.setText("Em manutenção:");

        jLabel6.setText("10");

        jLabel7.setText("Reservados:");

        jLabel8.setText("9");

        jLabel9.setText("Locados:");

        jLabel10.setText("Total:");

        jLabel11.setText("25");

        javax.swing.GroupLayout pnTotaisLayout = new javax.swing.GroupLayout(pnTotais);
        pnTotais.setLayout(pnTotaisLayout);
        pnTotaisLayout.setHorizontalGroup(
            pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTotaisLayout.createSequentialGroup()
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTotaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(pnTotaisLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(pnTotaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnTotaisLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(pnTotaisLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))))
                    .addGroup(pnTotaisLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTotaisLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addGap(48, 48, 48))
        );
        pnTotaisLayout.setVerticalGroup(
            pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTotaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(21, 21, 21))
        );

        pnLogados.setBorder(javax.swing.BorderFactory.createTitledBorder("Onlines"));

        jScrollPane4.setViewportView(listaOnlines);

        btAbrirChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Chat.png"))); // NOI18N
        btAbrirChat.setText("Abrir chat");
        btAbrirChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirChatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnLogadosLayout = new javax.swing.GroupLayout(pnLogados);
        pnLogados.setLayout(pnLogadosLayout);
        pnLogadosLayout.setHorizontalGroup(
            pnLogadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(btAbrirChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnLogadosLayout.setVerticalGroup(
            pnLogadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLogadosLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAbrirChat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Nova Devolução");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenusLayout = new javax.swing.GroupLayout(pnMenus);
        pnMenus.setLayout(pnMenusLayout);
        pnMenusLayout.setHorizontalGroup(
            pnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenusLayout.createSequentialGroup()
                .addGroup(pnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnLogados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTotais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnMenusLayout.setVerticalGroup(
            pnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenusLayout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(pnLogados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTotais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnConectar.setBorder(javax.swing.BorderFactory.createTitledBorder("Conectado no chat como:"));

        tfNome.setEnabled(false);
        tfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeActionPerformed(evt);
            }
        });

        btConecta.setText("Conecta");
        btConecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConectaActionPerformed(evt);
            }
        });

        btSair.setText("Sair");
        btSair.setEnabled(false);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnConectarLayout = new javax.swing.GroupLayout(pnConectar);
        pnConectar.setLayout(pnConectarLayout);
        pnConectarLayout.setHorizontalGroup(
            pnConectarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConectarLayout.createSequentialGroup()
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btConecta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSair)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnConectarLayout.setVerticalGroup(
            pnConectarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConectarLayout.createSequentialGroup()
                .addGroup(pnConectarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConecta)
                    .addComponent(btSair))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pnConversa.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat"));

        taRecebe.setEditable(false);
        taRecebe.setColumns(20);
        taRecebe.setRows(5);
        taRecebe.setDoubleBuffered(true);
        taRecebe.setEnabled(false);
        jScrollPane2.setViewportView(taRecebe);

        taEnvia.setColumns(20);
        taEnvia.setRows(5);
        taEnvia.setEnabled(false);
        jScrollPane3.setViewportView(taEnvia);

        btLimpar.setText("Limpar");
        btLimpar.setEnabled(false);
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btEnviar.setText("Enviar");
        btEnviar.setEnabled(false);
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Enter para enviar");

        javax.swing.GroupLayout pnConversaLayout = new javax.swing.GroupLayout(pnConversa);
        pnConversa.setLayout(pnConversaLayout);
        pnConversaLayout.setHorizontalGroup(
            pnConversaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConversaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnConversaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnConversaLayout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEnviar)))
                .addContainerGap())
        );
        pnConversaLayout.setVerticalGroup(
            pnConversaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnConversaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnConversaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLimpar)
                    .addComponent(btEnviar)
                    .addComponent(jCheckBox1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnChatLayout = new javax.swing.GroupLayout(pnChat);
        pnChat.setLayout(pnChatLayout);
        pnChatLayout.setHorizontalGroup(
            pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChatLayout.createSequentialGroup()
                .addGroup(pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnConversa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        pnChatLayout.setVerticalGroup(
            pnChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnConectar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnConversa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        tbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Ká Sport", "Esportivo", "Disponível"},
                {"Corolla", "Executivo", "Locado"},
                {"Camaro", "Esportivo", "Disponível"},
                {"Novo Uno", "Econônico", "Reservado"},
                {"Novo Fusion", "Executivo Luxo", "Disponível"},
                {"Ranger", "4x4 Especial", "Disponível"}
            },
            new String [] {
                "Veículo", "Tipo", "Status"
            }
        ));
        jScrollPane1.setViewportView(tbVeiculos);

        javax.swing.GroupLayout pnGeralLayout = new javax.swing.GroupLayout(pnGeral);
        pnGeral.setLayout(pnGeralLayout);
        pnGeralLayout.setHorizontalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGeralLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnMenus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );
        pnGeralLayout.setVerticalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMenus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dp.add(pnGeral);
        pnGeral.setBounds(0, 0, 1470, 750);

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastros");

        jMenuItem2.setText("Usuários");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Tipo Veiculo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Funcionário");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");
        jMenuBar1.add(jMenu3);

        jMenu5.setText("Configurações");
        jMenuBar1.add(jMenu5);

        jMenu4.setText("Ajuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, 1212, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dp, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IfFornecedor janela = new IfFornecedor();
        janela.setSize(590, 430);
        dp.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        IfReservaVeiculos janela = new IfReservaVeiculos();
        janela.setSize(600, 610);
        dp.add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btConectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConectaActionPerformed
        String nome = tfNome.getText();
//        if (tfNome.getText().length() > 0) {
//            nome = tfNome.getText();
//        } else {
//            JOptionPane.showMessageDialog(this, "Digite um nome para logar no chat!");
//        }
        if (!nome.isEmpty()) {
            this.message = new ChatMessage();
            this.message.setAction(Action.CONNECT);
            this.message.setNome(nome);
            
            this.service = new ClienteService();
            this.socket = this.service.connect();
            
            new Thread(new ListenerSocket(socket)).start();
        }
        this.service.send(message);
    }//GEN-LAST:event_btConectaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        
        this.message.setAction(Action.DISCONNECT);
        this.service.send(message);
        disconnected();
    }//GEN-LAST:event_btSairActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        taEnvia.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        String textoEnvia = taEnvia.getText();
        String nome = message.getNome();
        
        message = new ChatMessage();
        
        if (listaOnlines.getSelectedIndex() > -1) {
            message.setNome((String) listaOnlines.getSelectedValue());
            message.setAction(Action.SEND_ONE);
            listaOnlines.clearSelection();
        } else {
            message.setAction(Action.SEND_ALL);
        }
        if (!textoEnvia.isEmpty()) {
            message.setNome(nome);
            message.setTexto(textoEnvia);
            taRecebe.append("Você disse: " + textoEnvia + "\n");
            service.send(message);
        }
        taEnvia.setText("");

    }//GEN-LAST:event_btEnviarActionPerformed

    private void btAbrirChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirChatActionPerformed
        
        if (btAbrirChat.getText().equals("Fechar chat")) {
            btAbrirChat.setText("Abrir chat");
            pnChat.setVisible(false);
        } else {
            btAbrirChat.setText("Fechar chat");
            pnChat.setVisible(true);
        }
    }//GEN-LAST:event_btAbrirChatActionPerformed

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfNomeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DgConsultaLocacao tela = new DgConsultaLocacao();
        tela.setVisible(true);
        //tela.setSize(200, 200);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
   
        IfTipoVeiculo janela = new IfTipoVeiculo();
        // janela.setSize(600, 610);
        dp.add(janela);
        janela.setVisible(true);
      
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       IfFuncionario janela = new IfFuncionario(login);
        System.out.println("login é:"+login);
       dp.add(janela);
       janela.setVisible(true);
     
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
    public void popularTabelaVeiculos() {
       // try{
        DefaultTableModel tabelaModelo = (DefaultTableModel) tbVeiculos.getModel();
        tabelaModelo.setNumRows(0);
        
        Session sessao = null;
        
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        
//        Iterator query = sessao.createQuery("select v.idveiculo, v.descricao, t.descricao, s.descricao\n"
//                + "FROM Veiculo v, Tipoveiculo t, Statusveiculo s\n"
//                + "WHERE v.tipoveiculo=t.tipoveiculo\n"
//                + "AND s.statusveiculo=v.statusveiculo").list().iterator();
        
//         Iterator query = sessao.createQuery(" from Veiculostipoestatus").list().iterator();
//        while (query.hasNext()) {
//            Object[] tuple = (Object[]) query.next();
//            Veiculostipoestatus idveiculo = (Veiculostipoestatus) tuple[0]; //id
//            Veiculostipoestatus descricaov = (Veiculostipoestatus) tuple[1]; //desc veiculo
//            Veiculostipoestatus descricaot = (Veiculostipoestatus) tuple[2]; //desc tipo
//            Veiculostipoestatus descricaos = (Veiculostipoestatus) tuple[3]; //desc status
//            tabelaModelo.addRow(tuple);
//        }
        
        Query query = (Query) sessao.createQuery(" FROM Veiculostipoestatus");
        List<Veiculostipoestatus> dadosVTS = (List<Veiculostipoestatus>) query.list();
        
        for (Veiculostipoestatus v : dadosVTS) {
           tabelaModelo.addRow(new Object[]{
              //  v.getIdveiculo(),
                v.getDescricaoVeiculo(),
                v.getDescricaoTipo(),
                v.getDescricaoStatus(),          });
        }
        
        sessao.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println("erro ao chamar view: " + e);
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrirChat;
    private javax.swing.JButton btConecta;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btSair;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listaOnlines;
    private javax.swing.JPanel pnChat;
    private javax.swing.JPanel pnConectar;
    private javax.swing.JPanel pnConversa;
    private javax.swing.JPanel pnGeral;
    private javax.swing.JPanel pnLogados;
    private javax.swing.JPanel pnMenus;
    private javax.swing.JPanel pnTotais;
    private javax.swing.JTextArea taEnvia;
    private javax.swing.JTextArea taRecebe;
    private javax.swing.JTable tbVeiculos;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables
}
