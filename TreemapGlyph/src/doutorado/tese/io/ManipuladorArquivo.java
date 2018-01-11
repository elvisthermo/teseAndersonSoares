/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.io;

import doutorado.tese.util.Coluna;
import doutorado.tese.visualizacao.treemap.TreeMapItem;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Anderson Soares
 */
public class ManipuladorArquivo {

    private Map<String, String> mapaCabecalho = new HashMap<>();
//    private Map<String, int[]> mapaMaiorMenor;
    private String[] cabecalho = {};
    private String[] tipos = {};
    private File file;
    private Charset charset;
    private StringBuilder bufferArquivo;
    private static Coluna[] colunas;
    private TreeMapItem[] itensTreemap;
    private String[] linhas;

    public ManipuladorArquivo() {
        charset = Charset.forName("iso-8859-1");
        bufferArquivo = new StringBuilder();
    }

    public void lerArquivo(File arquivo) {
        file = arquivo;
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            String line = null;
            int cont = 0;

            while ((line = reader.readLine()) != null) {
                if (cont == 0) {
                    cabecalho = montarCabecalho(line);
                }
                if (cont == 1) {
                    tipos = desvendarTiposDados(line);
                    montarMapaCabecalhoTipos(getCabecalho(), tipos);
                }
//                montarColunas(cabecalho, tipos);
                bufferArquivo.append(line).append("\n");
                cont++;
            }
            linhas = bufferArquivo.toString().split("\n");
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    /**
     * Responsavel por capturar os dados da coluna especificada
     *
     * @param nomeColuna
     * @return
     */
    public String[] getDadosColuna(String nomeColuna) {
//        String[] linhas = bufferArquivo.toString().split("\n");
        String[] dados = new String[linhas.length - 2];
        for (int numLinha = 2; numLinha < linhas.length; numLinha++) {
            String[] vetorLinha = linhas[numLinha].split("\t|,");
            for (int j = 0; j < cabecalho.length; j++) {
                if (cabecalho[j].equalsIgnoreCase(nomeColuna)) {
                    dados[numLinha - 2] = vetorLinha[j];
                    break;
                }
            }
        }
        return dados;
    }

    public String[] getDadosLinha(int numLinha) {
//        String[] linhas = bufferArquivo.toString().split("\n");
        String[] vetorLinha = linhas[numLinha].split("\t|,");
        return vetorLinha;
    }

    /**
     * Retorna um objeto coluna pelo nome da coluna
     *
     * @param nomeColuna String com o nome da coluna
     * @return O objeto coluna pesquisado
     */
    public static Coluna getColuna(String nomeColuna) {
        Coluna c = null;
        for (Coluna coluna : colunas) {
            if (coluna.getName().equalsIgnoreCase(nomeColuna)) {
                c = coluna;
            }
        }
        return c;
    }

    private String[] montarCabecalho(String line) {
        return line.split("\t|,");
    }

    private String[] desvendarTiposDados(String line) {
        return line.split("\t|,");
    }

    private void montarMapaCabecalhoTipos(String[] cabecalho, String[] tipos) {
        for (int i = 0; i < cabecalho.length; i++) {
            getMapaCabecalho().put(cabecalho[i], tipos[i]);
        }
    }

    /**
     * Hashmap key = Nome da Coluna --> value = Tipo de dado da coluna
     *
     * @return Mapa (Coluna --> Tipo)
     */
    public Map<String, String> getMapaCabecalho() {
        return mapaCabecalho;
    }

    /**
     * @return the cabecalho
     */
    public String[] getCabecalho() {
        return cabecalho;
    }

    /**
     * @return the bufferArquivo
     */
    public StringBuilder getBufferArquivo() {
        return bufferArquivo;
    }

    public Coluna[] montarColunas(String[] nomeColunas, String[] tipos) {
        colunas = new Coluna[cabecalho.length];
        for (int i = 0; i < nomeColunas.length; i++) {
            colunas[i] = new Coluna(this, nomeColunas[i], tipos[i]);
        }
        return colunas;
    }

    public Coluna[] montarColunas() {
        colunas = new Coluna[cabecalho.length];
        for (int i = 0; i < cabecalho.length; i++) {
            Coluna c = new Coluna(this, cabecalho[i], getMapaCabecalho().get(cabecalho[i]));
//            c.setDadosColuna(getDadosColuna(cabecalho[i]));
            c.configurarDescricao(getDadosColuna(cabecalho[i]));
            colunas[i] = c;
        }
        return getColunas();
    }

    /**
     * @return the colunas
     */
    public Coluna[] getColunas() {
        return colunas;
    }

    public String[] getTipos() {
        return tipos;
    }

    public Class[] getClassTipos() {
        Class[] classes = new Class[tipos.length];
        for (int i = 0; i < tipos.length; i++) {
            switch (tipos[i]) {
                case "STRING": classes[i] = String.class;
                break;
                case "INTEGER": classes[i] = Integer.class;
                break;
                case "DOUBLE": classes[i] = Double.class;
                break;
                case "FLOAT": classes[i] = Float.class;
                break;
                case "BOOLEAN": classes[i] = Boolean.class;
                break;
            };
        }
        return classes;
    }

    /**
     * @return the itensTreemap
     */
    public TreeMapItem[] getItensTreemap() {
        return itensTreemap;
    }

    /**
     * @param itensTreemap the itensTreemap to set
     */
    public void setItensTreemap(TreeMapItem[] itensTreemap) {
        this.itensTreemap = itensTreemap;
    }

    public void carregarItensTreemap() {
        int totalItens = getDadosColuna(getCabecalho()[0]).length;
        itensTreemap = new TreeMapItem[totalItens];
        for (int i = 0; i < totalItens; i++) {
            String[] dadosLinha = getDadosLinha(i + 2);
            TreeMapItem itemLocal = new TreeMapItem();
            for (int j = 0; j < dadosLinha.length; j++) {
                itemLocal.getMapaDetalhesItem().put(getColunas()[j], dadosLinha[j]);
            }
            itensTreemap[i] = itemLocal;
        }
    }

}
