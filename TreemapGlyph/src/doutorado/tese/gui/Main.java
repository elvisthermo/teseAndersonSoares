/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import doutorado.tese.io.ManipuladorArquivo;
import doutorado.tese.util.Coluna;
import doutorado.tese.util.Flags;
import doutorado.tese.util.Metadados;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author Anderson
 */
public class Main extends javax.swing.JFrame implements PropertyChangeListener {

    /**
     * Creates new form Main
     */
    public Main() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        painelEsquerda = new javax.swing.JPanel();
        painelDireita = new javax.swing.JPanel();
        botaoGerarTreemap = new javax.swing.JButton();
        checkLegenda = new javax.swing.JCheckBox();
        checkGlyph = new javax.swing.JCheckBox();
        checkStarGlyph = new javax.swing.JCheckBox();
        tamanhoTreeampComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        legendaComboBox = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        variaveisStarList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        painelLegenda = new javax.swing.JTextPane();
        progressoBarra = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        hierarquiaList = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Treemap Glyphs");

        jSplitPane1.setDividerLocation(1000);

        javax.swing.GroupLayout painelEsquerdaLayout = new javax.swing.GroupLayout(painelEsquerda);
        painelEsquerda.setLayout(painelEsquerdaLayout);
        painelEsquerdaLayout.setHorizontalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 999, Short.MAX_VALUE)
        );
        painelEsquerdaLayout.setVerticalGroup(
            painelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 529, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(painelEsquerda);

        painelDireita.setBorder(javax.swing.BorderFactory.createTitledBorder("Settings"));

        botaoGerarTreemap.setText("Show Treemap");
        botaoGerarTreemap.setEnabled(false);
        botaoGerarTreemap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarTreemapActionPerformed(evt);
            }
        });

        checkLegenda.setText("Label:");
        checkLegenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkLegendaActionPerformed(evt);
            }
        });

        checkGlyph.setText("Glyph");
        checkGlyph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGlyphActionPerformed(evt);
            }
        });

        checkStarGlyph.setText("Star glyph");
        checkStarGlyph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkStarGlyphActionPerformed(evt);
            }
        });

        tamanhoTreeampComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        tamanhoTreeampComboBox.setEnabled(false);

        jLabel1.setText("Size:");

        jLabel2.setText("hierarchy:");

        legendaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---" }));
        legendaComboBox.setToolTipText("");
        legendaComboBox.setEnabled(false);

        jLabel3.setText("variables:");

        variaveisStarList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "---" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        variaveisStarList.setEnabled(false);
        jScrollPane1.setViewportView(variaveisStarList);

        painelLegenda.setEditable(false);
        painelLegenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Subtitle StarGlyph"));
        jScrollPane2.setViewportView(painelLegenda);

        progressoBarra.setName("teste"); // NOI18N
        progressoBarra.setStringPainted(true);

        hierarquiaList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "---" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(hierarquiaList);

        javax.swing.GroupLayout painelDireitaLayout = new javax.swing.GroupLayout(painelDireita);
        painelDireita.setLayout(painelDireitaLayout);
        painelDireitaLayout.setHorizontalGroup(
            painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDireitaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDireitaLayout.createSequentialGroup()
                        .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoGerarTreemap, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelDireitaLayout.createSequentialGroup()
                                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(checkLegenda)
                                    .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tamanhoTreeampComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(legendaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 112, Short.MAX_VALUE)))))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addGroup(painelDireitaLayout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelDireitaLayout.createSequentialGroup()
                            .addComponent(checkStarGlyph)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(checkGlyph, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDireitaLayout.createSequentialGroup()
                        .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(progressoBarra, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(jSeparator4))
                        .addGap(106, 106, 106))))
        );
        painelDireitaLayout.setVerticalGroup(
            painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDireitaLayout.createSequentialGroup()
                .addComponent(progressoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tamanhoTreeampComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDireitaLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 91, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(legendaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkLegenda))
                .addGap(6, 6, 6)
                .addComponent(botaoGerarTreemap, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkStarGlyph)
                    .addComponent(checkGlyph))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jSplitPane1.setRightComponent(painelDireita);

        fileMenu.setText("File");

        fileMenuItem.setText("File");
        fileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(fileMenuItem);

        jMenuBar1.add(fileMenu);

        helpMenu.setText("Help");
        helpMenu.setToolTipText("");

        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String[] parseListString2Vetor(List<String> lista) {
        String[] convertida = new String[lista.size()];
        for (int i = 0; i < convertida.length; i++) {
            convertida[i] = lista.get(i);
        }
        return convertida;
    }

    private void botaoGerarTreemapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarTreemapActionPerformed
        limparPainelEsquerda();
        String itemTamanho = tamanhoTreeampComboBox.getSelectedItem().toString();
        String itemLegenda = legendaComboBox.getSelectedItem().toString();
        String[] itensHierarquia = parseListString2Vetor(hierarquiaList.getSelectedValuesList());
        List<String> variaveisStarGlyph = variaveisStarList.getSelectedValuesList();

        VisualizationsArea v = new VisualizationsArea(painelEsquerda.getWidth(), painelEsquerda.getHeight(),
                manipulador, itemTamanho, itensHierarquia, itemLegenda, variaveisStarGlyph);
        painelEsquerda.add(v.getView());
        painelEsquerda.repaint();
        prepararLegendaStarGlyph(variaveisStarGlyph);
        progressoBarra.setVisible(false);
        
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                v.teste();
//            }
//        }).start();;
        
    }//GEN-LAST:event_botaoGerarTreemapActionPerformed

    private void checkStarGlyphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkStarGlyphActionPerformed
        if (checkStarGlyph.isSelected()) {
            Flags.setShowStarGlyph(true);
            variaveisStarList.setEnabled(true);
        } else {
            Flags.setShowStarGlyph(false);
            variaveisStarList.setEnabled(false);
        }
    }//GEN-LAST:event_checkStarGlyphActionPerformed

    private void checkLegendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkLegendaActionPerformed
        if (checkLegenda.isSelected()) {
            Flags.setShowLegenda(true);
            legendaComboBox.setEnabled(true);
        } else {
            Flags.setShowLegenda(false);
            legendaComboBox.setEnabled(false);
        }
    }//GEN-LAST:event_checkLegendaActionPerformed

    private void checkGlyphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGlyphActionPerformed
        if (checkGlyph.isSelected()) {
            Flags.setShowGlyph(true);            
        } else {
            Flags.setShowGlyph(false);            
        }
    }//GEN-LAST:event_checkGlyphActionPerformed

    private void fileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "TXT & CSV Files", "txt", "csv");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();

            progressoBarra.setVisible(true);
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            //Instances of javax.swing.SwingWorker are not reusuable, so
            //we create new instances as needed.
            task = new Task();
            task.addPropertyChangeListener(this);
            task.execute();
        }
    }//GEN-LAST:event_fileMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton botaoGerarTreemap;
    private javax.swing.JCheckBox checkGlyph;
    private javax.swing.JCheckBox checkLegenda;
    private javax.swing.JCheckBox checkStarGlyph;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fileMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JList<String> hierarquiaList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JComboBox<String> legendaComboBox;
    private javax.swing.JPanel painelDireita;
    private javax.swing.JPanel painelEsquerda;
    private javax.swing.JTextPane painelLegenda;
    private javax.swing.JProgressBar progressoBarra;
    private javax.swing.JComboBox<String> tamanhoTreeampComboBox;
    private javax.swing.JList<String> variaveisStarList;
    // End of variables declaration//GEN-END:variables
    private ManipuladorArquivo manipulador;
    private File selectedFile;
    private Task task;

    class Task extends SwingWorker<Void, Void> {

        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            int progress = 0;
            //Initialize progress property.
            setProgress(0);
            int ordem = 0;
            while (progress < 100) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignore) {
                    ignore.printStackTrace();
                }
                //Make progress.     
                ordem++;
                progress = executaTarefas(ordem, progress);
                setProgress(Math.min(progress, 100));
            }
            return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            setCursor(null); //turn off the wait cursor
        }
    }

    private int executaTarefas(int ordem, int porcentagem) {
        int tarefas = 8;
        switch (ordem) {
            case 1:
                manipulador = new ManipuladorArquivo();
                manipulador.lerArquivo(selectedFile);
                porcentagem = (ordem * 100) / tarefas;
                break;
            case 2:
                try {
                    manipulador.montarColunas(manipulador.getCabecalho(), manipulador.getTipos());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                porcentagem = (ordem * 100) / tarefas;
                break;
            case 3:
                try {
                    manipulador.carregarItensTreemap();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                porcentagem = (ordem * 100) / tarefas;
                break;
            case 4:
                try {
                    for (int i = 0; i < manipulador.getColunas().length; i++) {
                        Coluna c = manipulador.getColunas()[i];
                        c.configurarDescricao(manipulador.getDadosColuna(manipulador.getCabecalho()[i]));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                porcentagem = (ordem * 100) / tarefas;
                break;
            case 5:
                loadItensTamanhoTreemap();
                porcentagem = (ordem * 100) / tarefas;
                break;
            case 6:
                loadItensLegendaTreemap();
                porcentagem = (ordem * 100) / tarefas;
                break;
            case 7:
                loadVariaveisStartGlyph();
                porcentagem = (ordem * 100) / tarefas;
                break;
            case 8:
                loadItensHierarquiaTreemap();
                porcentagem = (ordem * 100) / tarefas;
                break;
            default:
                throw new AssertionError();
        }
        return porcentagem;
    }

    private void limparPainelEsquerda() {
        painelEsquerda.removeAll();
        painelEsquerda.repaint();
    }

    private void loadItensTamanhoTreemap() {
        List<String> itens = new ArrayList<>();
        for (String cabecalho : manipulador.getCabecalho()) {
            String tipo = manipulador.getMapaCabecalho().get(cabecalho);
            if (tipo.equalsIgnoreCase(Metadados.TipoDados.Integer.name())) {
                itens.add(cabecalho);
            }
        }
        atualizarComboBox(tamanhoTreeampComboBox, itens);
        tamanhoTreeampComboBox.setEnabled(true);
    }

    private void loadItensLegendaTreemap() {
        List<String> itens = new ArrayList<>();
        itens.addAll(Arrays.asList(manipulador.getCabecalho()));
        atualizarComboBox(legendaComboBox, itens);
        botaoGerarTreemap.setEnabled(true);
    }

    private void loadItensHierarquiaTreemap() {
        List<String> list = new ArrayList<>();
        for (Coluna c : manipulador.getColunas()) {
            if (c.getDescription().equals(Metadados.Descricao.CATEGORICAL)) {
                list.add(c.getName());
            }
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(list.toArray());
        hierarquiaList.setModel(model);
        hierarquiaList.setEnabled(true);
    }

    private void atualizarComboBox(JComboBox comboBox, List<String> itens) {
        Object[] items = itens.toArray();
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        comboBox.setModel(model);        
    }

    private void loadVariaveisStartGlyph() {
        List<String> itens = new ArrayList<>();
        for (String cabecalho : manipulador.getCabecalho()) {
            String tipo = manipulador.getMapaCabecalho().get(cabecalho);
            if (tipo.equalsIgnoreCase(Metadados.TipoDados.Integer.name())
                    || tipo.equalsIgnoreCase(Metadados.TipoDados.Double.name())) {
                itens.add(cabecalho);
            }
        }
        Object[] items = itens.toArray();
        DefaultComboBoxModel model = new DefaultComboBoxModel(items);
        variaveisStarList.setModel(model);
//        variaveisStarList.setEnabled(true);
    }

    private void appendToPane(JTextPane tp, String msg, Color c) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

    private void prepararLegendaStarGlyph(List<String> itensVariaveisStarGlyph) {
        painelLegenda.setEditable(true);
        painelLegenda.setText("");
        for (int i = 0; i < itensVariaveisStarGlyph.size(); i++) {
            appendToPane(painelLegenda, itensVariaveisStarGlyph.get(i) + "\n", Color.decode(Flags.getCor()[i]));
        }
        painelLegenda.setEditable(false);
    }

    /**
     * Invoked when task's progress property changes.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (Flags.PROGRESS == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressoBarra.setValue(progress);
        }
    }
}
