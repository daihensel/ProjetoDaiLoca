/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import static java.awt.Frame.MAXIMIZED_BOTH;
import bean.ChatMessage;
import bean.ChatMessage.Action;
import conf.Popula;
import conf.Utility;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import service.ClienteService;

/**
 *
 * @author Daiane
 */
public class FormPrincipal extends javax.swing.JFrame {

    public static String login;

    private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FormPrincipal.class.getName());
    private Socket socket;
    private ChatMessage message;
    private ClienteService service;

    /**
     * Creates new form Principal
     */
    public FormPrincipal(String login) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        atualizaDadosVeiculos();
        pnChat.setVisible(false);
        tfNome.setText(login);
        this.btConectaActionPerformed(null);
        this.login = login;
        logger.info("Logado");

    }

    private void atualizaDadosVeiculos() {
        Popula.popularTabelaVeiculosTipoEStatus(tbVeiculos);
        lbDisponiveis.setText(Utility.somaVeiculos(1));
        lbReservados.setText(Utility.somaVeiculos(2));
        lbLocados.setText(Utility.somaVeiculos(3));
        lbManutencao.setText(Utility.somaVeiculos(4));
        lbTotal.setText(String.valueOf(Integer.parseInt(lbDisponiveis.getText())
                + Integer.parseInt(lbReservados.getText())
                + Integer.parseInt(lbLocados.getText())
                + Integer.parseInt(lbManutencao.getText())));
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
        btNovoFornecedor = new javax.swing.JButton();
        btNovaLocacao = new javax.swing.JButton();
        btNovoVeiculo = new javax.swing.JButton();
        btNovaManut = new javax.swing.JButton();
        btNovoCliente = new javax.swing.JButton();
        btNovaReserva = new javax.swing.JButton();
        pnTotais = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbDisponiveis = new javax.swing.JLabel();
        lbManutencao = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbReservados = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbLocados = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        pnLogados = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaOnlines = new javax.swing.JList();
        btAbrirChat = new javax.swing.JButton();
        btNovaDevolucao = new javax.swing.JButton();
        btNovoPagamento = new javax.swing.JButton();
        btNovoCancelamento = new javax.swing.JButton();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeiculos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miUsuarios = new javax.swing.JMenuItem();
        miTipoVeiculo = new javax.swing.JMenuItem();
        miFuncionario = new javax.swing.JMenuItem();
        miTipoContato = new javax.swing.JMenuItem();
        miCidade = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btNovoFornecedor.setText("Novo Fornecedor");
        btNovoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoFornecedorActionPerformed(evt);
            }
        });

        btNovaLocacao.setText("Nova Locação");
        btNovaLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaLocacaoActionPerformed(evt);
            }
        });

        btNovoVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Carro.png"))); // NOI18N
        btNovoVeiculo.setText("Novo Veículo");
        btNovoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoVeiculoActionPerformed(evt);
            }
        });

        btNovaManut.setText("Nova Manutenção");
        btNovaManut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaManutActionPerformed(evt);
            }
        });

        btNovoCliente.setText("Novo Cliente");
        btNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoClienteActionPerformed(evt);
            }
        });

        btNovaReserva.setText("Nova Reserva");
        btNovaReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaReservaActionPerformed(evt);
            }
        });

        jLabel1.setText("Status de Veículos:");

        jLabel2.setText("Disponíveis:");

        lbDisponiveis.setText("5");

        lbManutencao.setText("1");

        jLabel5.setText("Em manutenção:");

        lbReservados.setText("10");

        jLabel7.setText("Reservados:");

        lbLocados.setText("9");

        jLabel9.setText("Locados:");

        jLabel10.setText("Total:");

        lbTotal.setText("25");

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
                        .addComponent(lbDisponiveis))
                    .addGroup(pnTotaisLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnTotaisLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbManutencao))
                            .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnTotaisLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbTotal))
                                .addGroup(pnTotaisLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbLocados)))))
                    .addGroup(pnTotaisLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbReservados)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        pnTotaisLayout.setVerticalGroup(
            pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTotaisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbDisponiveis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbManutencao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbReservados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbLocados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnTotaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lbTotal))
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
                .addComponent(btAbrirChat, javax.swing.GroupLayout.PREFERRED_SIZE, 62, Short.MAX_VALUE))
        );

        btNovaDevolucao.setText("Nova Devolução");
        btNovaDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovaDevolucaoActionPerformed(evt);
            }
        });

        btNovoPagamento.setText("Novo Pagamento");
        btNovoPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoPagamentoActionPerformed(evt);
            }
        });

        btNovoCancelamento.setText("Novo Cancelamento");
        btNovoCancelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoCancelamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenusLayout = new javax.swing.GroupLayout(pnMenus);
        pnMenus.setLayout(pnMenusLayout);
        pnMenusLayout.setHorizontalGroup(
            pnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenusLayout.createSequentialGroup()
                .addGroup(pnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btNovaReserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovaLocacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovoCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovoFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovaDevolucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovoVeiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(btNovaManut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnTotais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnLogados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovoPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovoCancelamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnMenusLayout.setVerticalGroup(
            pnMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenusLayout.createSequentialGroup()
                .addComponent(btNovaReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNovaLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNovoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNovaManut, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNovoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNovoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNovaDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btNovoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNovoCancelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnLogados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTotais, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                        .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(btEnviar))
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
                {"Ranger", "4x4 Especial", "Disponível"}
            },
            new String [] {
                "Veículo", "Tipo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbVeiculosMouseEntered(evt);
            }
        });
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 369, Short.MAX_VALUE))
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnMenus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dp.add(pnGeral);
        pnGeral.setBounds(0, 0, 1470, 750);

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastros");

        miUsuarios.setText("Status Veículo");
        miUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUsuariosActionPerformed(evt);
            }
        });
        jMenu2.add(miUsuarios);

        miTipoVeiculo.setText("Tipo Veículo");
        miTipoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTipoVeiculoActionPerformed(evt);
            }
        });
        jMenu2.add(miTipoVeiculo);

        miFuncionario.setText("Funcionário");
        miFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFuncionarioActionPerformed(evt);
            }
        });
        jMenu2.add(miFuncionario);

        miTipoContato.setText("Tipo Contato");
        miTipoContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miTipoContatoActionPerformed(evt);
            }
        });
        jMenu2.add(miTipoContato);

        miCidade.setText("Cidade");
        miCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCidadeActionPerformed(evt);
            }
        });
        jMenu2.add(miCidade);

        jMenuItem2.setText("Função");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setText("Documento");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem10.setText("Contatos");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        jMenuItem6.setText("Relatório de locações entre datas");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem7.setText("Relatório de locações entre datas por veículo");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Relatório de locações por veículo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Relatório de locações por cliente");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Configurações");

        jMenuItem3.setText("Permissão");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem5.setText("Alterar senha");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

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

    private void btNovoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoFornecedorActionPerformed
        IfFornecedor janela = new IfFornecedor();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);
        } else {
            logger.error("usuário sem permissão");
        }

    }//GEN-LAST:event_btNovoFornecedorActionPerformed

    private void btNovaReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaReservaActionPerformed
        IfReservaVeiculos janela = new IfReservaVeiculos();
        janela.setSize(600, 610);
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);
        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_btNovaReservaActionPerformed

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

    private void btNovaDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaDevolucaoActionPerformed
        IfDevolucao janela = new IfDevolucao();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);
        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_btNovaDevolucaoActionPerformed

    private void miUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUsuariosActionPerformed
        IfStatusVeiculo janela = new IfStatusVeiculo();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_miUsuariosActionPerformed

    private void miTipoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTipoVeiculoActionPerformed
        IfTipoVeiculo janela = new IfTipoVeiculo();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);
        } else {
            logger.error("sem permissao");
        }
    }//GEN-LAST:event_miTipoVeiculoActionPerformed

    private void miFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFuncionarioActionPerformed
        IfFuncionario janela = new IfFuncionario();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);
        } else {
            logger.error("usuário sem permissão");
        }

    }//GEN-LAST:event_miFuncionarioActionPerformed

    private void miTipoContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miTipoContatoActionPerformed
        IfTipoContato janela = new IfTipoContato();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);
        } else {
            logger.error("usuário sem permissão");
        }

    }//GEN-LAST:event_miTipoContatoActionPerformed

    private void btNovaLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaLocacaoActionPerformed
        IfLocacao janela = new IfLocacao();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);
        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_btNovaLocacaoActionPerformed

    private void btNovaManutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovaManutActionPerformed
        IfManutencaoVeiculos janela = new IfManutencaoVeiculos();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_btNovaManutActionPerformed

    private void btNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoClienteActionPerformed
        IfCliente janela = new IfCliente();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);
        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_btNovoClienteActionPerformed

    private void miCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCidadeActionPerformed
        IfCidade janela = new IfCidade();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_miCidadeActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        IfFuncao janela = new IfFuncao();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btNovoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoVeiculoActionPerformed
        IfVeiculo janela = new IfVeiculo();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_btNovoVeiculoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        IfPermissao janela = new IfPermissao();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        IfDocumento janela = new IfDocumento();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void btNovoPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoPagamentoActionPerformed
        IfPagamento janela = new IfPagamento();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_btNovoPagamentoActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        IfAlteraSenha janela = new IfAlteraSenha();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void tbVeiculosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVeiculosMouseEntered
        atualizaDadosVeiculos();
    }//GEN-LAST:event_tbVeiculosMouseEntered

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        DgFiltroRelatorioLocacaoEntreDatas janela = new DgFiltroRelatorioLocacaoEntreDatas();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        DgFiltroRelatorioLocacaoEntreDatasVeiculo janela = new DgFiltroRelatorioLocacaoEntreDatasVeiculo();
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        DgFiltroRelatorioLocacaoId janela = new DgFiltroRelatorioLocacaoId("veiculo");
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        DgFiltroRelatorioLocacaoId janela = new DgFiltroRelatorioLocacaoId("cliente");
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btNovoCancelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoCancelamentoActionPerformed
        IfCancelamento janela = new IfCancelamento();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_btNovoCancelamentoActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        IfContatos janela = new IfContatos();
        dp.add(janela);
        if (Utility.permitLer(janela) == true) {
            janela.setVisible(true);

        } else {
            logger.error("usuário sem permissão");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrirChat;
    private javax.swing.JButton btConecta;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btNovaDevolucao;
    private javax.swing.JButton btNovaLocacao;
    private javax.swing.JButton btNovaManut;
    private javax.swing.JButton btNovaReserva;
    private javax.swing.JButton btNovoCancelamento;
    private javax.swing.JButton btNovoCliente;
    private javax.swing.JButton btNovoFornecedor;
    private javax.swing.JButton btNovoPagamento;
    private javax.swing.JButton btNovoVeiculo;
    private javax.swing.JButton btSair;
    private javax.swing.JDesktopPane dp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbDisponiveis;
    private javax.swing.JLabel lbLocados;
    private javax.swing.JLabel lbManutencao;
    private javax.swing.JLabel lbReservados;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JList listaOnlines;
    private javax.swing.JMenuItem miCidade;
    private javax.swing.JMenuItem miFuncionario;
    private javax.swing.JMenuItem miTipoContato;
    private javax.swing.JMenuItem miTipoVeiculo;
    private javax.swing.JMenuItem miUsuarios;
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
