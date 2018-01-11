/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.gui;

import com.macrofocus.treemap.AlgorithmFactory;
import com.macrofocus.treemap.TreeMap;
import doutorado.tese.io.ManipuladorArquivo;
import doutorado.tese.util.Coluna;
import java.io.File;
import java.util.Arrays;
import java.util.Vector;
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
//        Object[][] data = new Object[][]{
//            {"alfa-romeu", "gasolina", "sem", 2, "conversivel", "traseira", "frontal", 2548, 4, 111, 5000, 13495, 1986, "Europeu"},
//            {"bmw", "diesel", "sem", 2, "conversivel", "traseira", "frontal", 2548, 4, 111, 5000, 13495, 1986, "Europeu"},
//            {"alfa-romeu", "gasolina", "sem", 4, "conversivel", "traseira", "frontal", 2548, 4, 111, 5000, 13495, 1986, "Europeu"},
//            {"alfa-romeu", "gasolina", "sem", 2, "conversivel", "traseira", "frontal", 2548, 4, 111, 5000, 13495, 1986, "Europeu"},
//            {"alfa-romeu", "gasolina", "sem", 2, "conversivel", "traseira", "frontal", 2548, 4, 111, 5000, 13495, 1986, "Europeu"},};
        ManipuladorArquivo manipulador = new ManipuladorArquivo();
        manipulador.lerArquivo(new File("C:\\Users\\Anderson Soares\\Documents\\carros_teste3.txt"));
        manipulador.montarColunas(manipulador.getCabecalho(), manipulador.getTipos());
        for (int i = 0; i < manipulador.getColunas().length; i++) {
            Coluna c = manipulador.getColunas()[i];
            c.configurarDescricao(manipulador.getDadosColuna(manipulador.getCabecalho()[i]));
        }

        Vector data = new Vector();
        Vector columnNames = new Vector();
        Vector columnTypes = new Vector();

        columnNames.addAll(Arrays.asList(manipulador.getCabecalho()));
        columnTypes.addAll(Arrays.asList(manipulador.getClassTipos()));

        Vector lineData = new Vector();
        for (int lin = 0; lin < manipulador.getDadosColuna("MARCA").length; lin++) {
            String[] values = manipulador.getDadosLinha(lin + 2);
            for (int col = 0; col < values.length; col++) {
                String value = values[col];
                Object type = columnTypes.get(col);
                if (type.equals("String")) {
                    lineData.add(value);
                } else if (type.equals("Integer")) {
                    if (value != null && value.length() != 0) {
                        lineData.add(Integer.parseInt(value));
                    } else {
                        lineData.add(null);
                    }
                } else if (type.equals("Float")) {
                    if (value != null && value.length() != 0) {
                        lineData.add(Float.parseFloat(value));
                    } else {
                        lineData.add(null);
                    }
                } else if (type.equals("Double")) {
                    if (value != null && value.length() != 0) {
                        lineData.add(Double.parseDouble(value));
                    } else {
                        lineData.add(null);
                    }
                } else {
                    lineData.add(value);
                }
            }
            for (int i = 0; i < 1; i++) {
                data.add(lineData);
            }
        }
        // Creating a standard Swing TableModel
        TableModel tableModel = new TreeTableModel(data, columnNames, columnTypes);

        // Creating the TreeMap
        TreeMap treeMap = new TreeMap(tableModel);
        try {
            // Tuning the appearance of the TreeMap
            treeMap.setAlgorithm(AlgorithmFactory.SQUARIFIED);
            treeMap.setSizeByName("PESO");
            treeMap.setColor(2);
            treeMap.setBackgroundByName("MARCA");
            treeMap.setLabels();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Creating a frame to display
        final JFrame frame = new JFrame("Hello from the TreeMap World!");
        frame.setSize(1500, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(treeMap);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static class TreeTableModel extends DefaultTableModel {
        private Vector columnTypes;

        public TreeTableModel(Vector data, Vector columnNames, Vector columnTypes) {
            super(data, columnNames);
            this.columnTypes = columnTypes;
        }

        public Class<?> getColumnClass(int columnIndex) {
            Object type = columnTypes.get(columnIndex);
            if (type.equals("String")) {
                return String.class;
            } else if (type.equals("Integer")) {
                return Integer.class;
            } else if (type.equals("Float")) {
                return Float.class;
            } else if (type.equals("Double")) {
                return Double.class;
            } else {
                return Object.class;
            }
        }
    }
}
