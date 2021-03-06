/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import conf.ComboItens;
import conf.CombosDAO;
import conf.DAO;
import conf.Formatacao;
import conf.HibernateUtil;
import conf.Popula;
import conf.Utility;
import entidade.Cidade;
import entidade.Documentos;
import entidade.Estado;
import entidade.Populartabelaveiculo;
import entidade.Veiculo;
import entidade.Veiculosstatus;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Daiane
 */
public class IfDocumento extends javax.swing.JInternalFrame {

    private org.apache.log4j.Logger logger = Logger.getLogger(DgLogin.class.getName());
    private int codveiculo;
    int idDocumento = 0;

    /**
     * Creates new form IfDocumento
     */
    public IfDocumento() {
        initComponents();
        Utility.permit(btNovo, btSalvar, btEditar, btExcluir, this);
        habilitaCampos(false);
        this.pesquisa();
        jTabbedPane1StateChanged(null);
        codveiculo = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfDataInclusao = new javax.swing.JTextField();
        tfDataInclusao = Formatacao.getData();
        tfDescricao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTipo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfObservacoes = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfDescricaoVeiculo = new javax.swing.JTextField();
        tfTipoVeiculo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfAnoModelo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        tfKmAtual = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfAnoFabricacao = new javax.swing.JTextField();
        btPVeiculo = new javax.swing.JButton();
        tfValorDiaria = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDocumentos = new javax.swing.JTable();
        tfPesquisa = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btFechar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setTitle("Cadastro de Documentos");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        jLabel2.setText("Data Inclusão*:");

        tfDataInclusao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDataInclusaoKeyTyped(evt);
            }
        });

        tfDescricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDescricaoKeyTyped(evt);
            }
        });

        jLabel4.setText("Descrição*:");

        jLabel5.setText("Tipo*:");

        tfTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTipoKeyTyped(evt);
            }
        });

        jLabel6.setText("Observações:");

        tfObservacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfObservacoesKeyTyped(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Veículo"));

        jLabel8.setText("Descrição:");

        tfDescricaoVeiculo.setEditable(false);
        tfDescricaoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescricaoVeiculoActionPerformed(evt);
            }
        });

        tfTipoVeiculo.setEditable(false);

        jLabel9.setText("Tipo:");

        tfAnoModelo.setEditable(false);

        jLabel11.setText("Ano Modelo:");

        jLabel12.setText("Marca:");

        tfMarca.setEditable(false);

        tfKmAtual.setEditable(false);

        jLabel13.setText("Km atual:");

        tfAnoFabricacao.setEditable(false);

        btPVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/procurar_20x20.png"))); // NOI18N
        btPVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPVeiculoActionPerformed(evt);
            }
        });

        tfValorDiaria.setEditable(false);

        jLabel25.setText("Valor Diária:");

        jLabel18.setText("Ano Fabric.:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfDescricaoVeiculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btPVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfTipoVeiculo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfKmAtual, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMarca)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(tfDescricaoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btPVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfTipoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAnoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(tfAnoFabricacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(tfValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(tfKmAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfObservacoes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDescricao)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfDataInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTipo)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDataInclusao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(35, 35, 35)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cadastro Documentos", jPanel1);

        jPanel2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel2FocusGained(evt);
            }
        });

        jLabel3.setText("Busca");

        tbDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Descrição", "Veículo", "Data Inclusão", "Tipo", "Observações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDocumentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDocumentos);

        tfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPesquisaKeyReleased(evt);
            }
        });

        btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/procurar_20x20.png"))); // NOI18N
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta Documentos", jPanel2);

        jToolBar1.setRollover(true);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/novo_32x32.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btNovo);

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar_32x32.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(btSalvar);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/bExcluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setPreferredSize(new java.awt.Dimension(71, 39));
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jToolBar1.add(btExcluir);

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/bEditar.png"))); // NOI18N
        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btEditar);
        jToolBar1.add(jSeparator1);

        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar_32x32.png"))); // NOI18N
        btFechar.setText("Fechar");
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });
        jToolBar1.add(btFechar);

        jLabel7.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed

        if (tfDescricao.getText().trim().length() > 0 && tfTipo.getText().trim().length() > 0
                && tfDataInclusao.getText().trim().length() > 0) {

            Documentos doc = new Documentos();
            doc.setIddocumentos(idDocumento);
            doc.setDescricao(tfDescricao.getText());
            doc.setObservacoes(tfObservacoes.getText());
            doc.setTipo(tfTipo.getText());
            doc.setDtInclusao(Formatacao.converteParaDataAMD(tfDataInclusao.getText()));

            Object[] object;
            object = (Object[]) Popula.retornaVeiculo(codveiculo);
            List<Veiculo> l = (List<Veiculo>) object[0];
            for (Veiculo lin : l) {
                Veiculo v = lin;
                doc.setVeiculo(v);
            }

            DAO.salvarDocumento(doc);
            pesquisa();
            habilitaCampos(false);

        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btFecharActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        habilitaCampos(true);
        idDocumento = 0;
        jTabbedPane1.setSelectedIndex(0);
        btNovo.setEnabled(false);
        btSalvar.setEnabled(true);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (jTabbedPane1.getSelectedIndex() == 1) {
            if (tbDocumentos.getSelectedRow() >= 0) {
                String cod = String.valueOf(tbDocumentos.getValueAt(tbDocumentos.getSelectedRow(), 0));
                int codigo = Integer.parseInt(cod);
                List<Documentos> l = Popula.popularTabelaDocumento(codigo, String.valueOf(codigo), tbDocumentos);
                for (Documentos lin : l) {
                    idDocumento = lin.getIddocumentos();
                    tfDescricao.setText(lin.getDescricao());
                    this.defineCodigoVeiculo(lin.getVeiculo().getIdveiculo());
                    tfDataInclusao.setText(Formatacao.ajustaDataDMA(String.valueOf((lin.getDtInclusao()))));
                    tfTipo.setText(lin.getTipo());
                    tfObservacoes.setText(lin.getObservacoes());
                }
                jTabbedPane1.setSelectedIndex(0);
                habilitaCampos(true);
                btNovo.setEnabled(false);
                btSalvar.setEnabled(true);

                tfDescricao.requestFocus();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione algum registro!");
            }
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained

    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        if (jTabbedPane1.getSelectedIndex() == 1) {
            habilitaCampos(false);
            pesquisa();
            btSalvar.setEnabled(false);
            btEditar.setEnabled(true);
            btNovo.setEnabled(true);
            btExcluir.setEnabled(true);
        } else if (jTabbedPane1.getSelectedIndex() == 0) {
            btSalvar.setEnabled(false);
            btEditar.setEnabled(false);
            btNovo.setEnabled(true);
            btExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jPanel2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel2FocusGained

    }//GEN-LAST:event_jPanel2FocusGained

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        pesquisa();
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void tfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaKeyReleased
        pesquisa();
    }//GEN-LAST:event_tfPesquisaKeyReleased

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained

    }//GEN-LAST:event_jPanel1FocusGained

    private void tfDataInclusaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDataInclusaoKeyTyped

    }//GEN-LAST:event_tfDataInclusaoKeyTyped

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (jTabbedPane1.getSelectedIndex() == 1) {
            if (tbDocumentos.getSelectedRow() >= 0) {
                Object[] options = {" Sim ", " Não "};
                String descricao = String.valueOf(tbDocumentos.getValueAt(tbDocumentos.getSelectedRow(), 1));
                int opcaoExcluir = JOptionPane.showOptionDialog(this.getContentPane(), "Deseja excluir o registro "
                        + descricao + "?",
                        "Informação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);

                if (opcaoExcluir == 0) {
                    int id = (int) tbDocumentos.getValueAt(tbDocumentos.getSelectedRow(), 0);
                    System.out.println("id a ser excluido:" + id);
                    if (DAO.deletarDocumento(id)) {
                        JOptionPane.showMessageDialog(null, "Registro excluído!");
                        pesquisa();
                    } else {
                        JOptionPane.showMessageDialog(null, "Problemas ao excluir");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione algum registro!");
            }
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void tfDescricaoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescricaoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescricaoKeyTyped

    private void tfTipoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTipoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTipoKeyTyped

    private void tfObservacoesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfObservacoesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfObservacoesKeyTyped

    private void tfDescricaoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescricaoVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescricaoVeiculoActionPerformed

    private void btPVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPVeiculoActionPerformed
        DgConsultaVeiculo tela = new DgConsultaVeiculo(null, null, null, this);
        tela.setVisible(true);
    }//GEN-LAST:event_btPVeiculoActionPerformed

    private void tbDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDocumentosMouseClicked
        if (evt.getClickCount() > 1) {
            btEditarActionPerformed(null);
        }
    }//GEN-LAST:event_tbDocumentosMouseClicked

    public void habilitaCampos(Boolean tf) {
        if (tf == false) {
            limpaCampos();
            btNovo.setEnabled(true);
            btSalvar.setEnabled(false);
        }
        tfDescricao.setEnabled(tf);
        tfDataInclusao.setEnabled(tf);
        tfTipo.setEnabled(tf);
        tfObservacoes.setEnabled(tf);
        btPVeiculo.setEnabled(tf);
        tfDescricaoVeiculo.setEnabled(false);
        tfTipoVeiculo.setEnabled(false);
        tfMarca.setEnabled(false);
        tfAnoModelo.setEnabled(false);
        tfAnoFabricacao.setEnabled(false);
        tfValorDiaria.setEnabled(false);
        tfKmAtual.setEnabled(false);
    }

    public void limpaCampos() {
        tfDescricao.setText("");
        tfDataInclusao.setText("");
        tfTipo.setText("");
        tfObservacoes.setText("");
        tfDescricaoVeiculo.setText("");
        tfTipoVeiculo.setText("");
        tfMarca.setText("");
        tfAnoModelo.setText("");
        tfAnoFabricacao.setText("");
        tfValorDiaria.setText("");
        tfKmAtual.setText("");
    }

    public void pesquisa() {
        int cod = 0;
        if (tfPesquisa.getText().length() > 0 && tfPesquisa.getText().matches("[0-9]")) {
            cod = Integer.parseInt(tfPesquisa.getText());
        }
        Popula.popularTabelaDocumento(cod, tfPesquisa.getText(), tbDocumentos);
    }

    public void defineCodigoVeiculo(int cod) {

        codveiculo = cod;
        List<Veiculosstatus> l = Popula.popularTabelaVeiculo(cod, String.valueOf(cod), tbDocumentos, "");
        for (Veiculosstatus lin : l) {
            Veiculosstatus v = lin;
            tfDescricaoVeiculo.setText(v.getDescricaoVeiculo());
            tfTipoVeiculo.setText(v.getDescricaoTipo());
            tfMarca.setText(v.getMarca());
            tfAnoModelo.setText(String.valueOf(v.getAnoModelo()));
            tfAnoFabricacao.setText(String.valueOf(v.getAnoFabricacao()));
            tfValorDiaria.setText(String.valueOf(v.getValorDiaria()));
            tfKmAtual.setText(String.valueOf(v.getKmAtual()));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btPVeiculo;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbDocumentos;
    private javax.swing.JTextField tfAnoFabricacao;
    private javax.swing.JTextField tfAnoModelo;
    private javax.swing.JTextField tfDataInclusao;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JTextField tfDescricaoVeiculo;
    private javax.swing.JTextField tfKmAtual;
    private javax.swing.JTextField tfMarca;
    private javax.swing.JTextField tfObservacoes;
    private javax.swing.JTextField tfPesquisa;
    private javax.swing.JTextField tfTipo;
    private javax.swing.JTextField tfTipoVeiculo;
    private javax.swing.JTextField tfValorDiaria;
    // End of variables declaration//GEN-END:variables
}
