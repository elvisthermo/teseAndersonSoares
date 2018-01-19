/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import doutorado.tese.io.ManipuladorArquivo;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Anderson Soares
 */
public class TesteTreemapAPI {

    public static void main(String[] args) {
        // Defining the data, column names and types
        ManipuladorArquivo manipulador = new ManipuladorArquivo();
        manipulador.lerArquivo(new File("C:\\Users\\Anderson Soares\\Documents\\carros_teste3.txt"));

        Object[][] data = new Object[manipulador.getLinhas().length - 2][manipulador.getCabecalho().length];
        Object[] columnNames = manipulador.getCabecalho();
        final Class[] columnTypes = manipulador.getClassTipos();

        for (int lin = 0; lin < manipulador.getLinhas().length - 2; lin++) {
            String[] linha = manipulador.getDadosLinha(lin + 2);
            for (int col = 0; col < linha.length; col++) {
                Object valorConvertido = verificarTipoDado(linha[col], columnTypes[col]);
                data[lin][col] = valorConvertido;
            }
        }
        
        // Creating a standard Swing TableModel
        TableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        // Creating the TreeMap
//        TreeMap treeMap = new TreeMap(tableModel);
//        try {
//            // Tuning the appearance of the TreeMap
//            treeMap.setAlgorithm(AlgorithmFactory.SQUARIFIED);
//            treeMap.setSizeByName("PESO");
//            treeMap.setColor(3);
//            treeMap.setBackgroundByName("MARCA");
//            treeMap.setLabels();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // Creating a frame to display
        final JFrame frame = new JFrame("Hello from the TreeMap World!");
        frame.setSize(800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(treeMap);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Responsavel por fazer a analise do tipo do dado.
     * Essa analise e importante para que o DataModel que sera
     * enviado ao treemap possa carregar o treemap corretamente.
     * @param dado
     * @param type
     * @return O dado convertido em seu tipo original
     */
    public static Object verificarTipoDado(String dado, Class type) {
        Object valorConvertido = null;
        if (dado != null && dado.length() != 0) {
            if (type.equals(Integer.class)) {
                valorConvertido = Integer.parseInt(dado);
            } else if (type.equals(Double.class)) {
                valorConvertido = Double.parseDouble(dado);
            } else if (type.equals(Float.class)) {
                valorConvertido = Float.parseFloat(dado);
            } else {
                valorConvertido = dado;
            }
        } else {
            valorConvertido = null;
        }
        return valorConvertido;
    }    
}
