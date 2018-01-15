/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.dynabeans;

import XML.XMLCreator;
import doutorado.tese.io.ManipuladorArquivo;
import java.io.File;

/**
 *
 * @author Anderson Soares
 */
public class TesteDynaBean {

    public static void main(String[] args) {
        ManipuladorArquivo manipulador = new ManipuladorArquivo();
        manipulador.lerArquivo(new File("C:\\Users\\Anderson Soares\\Documents\\carros_teste3.txt"));

        DynaBean bean = DynaBeanFactory.newInstance("TreemapItem", manipulador);

//        for (int linha = 3; linha < manipulador.getLinhas().length; linha++) {
        String[] dadosLinha = manipulador.getDadosLinha(63);
        for (int col = 0; col < manipulador.getCabecalho().length; col++) {
            bean.setAttribute(manipulador.getCabecalho()[col], dadosLinha[col], manipulador.getClassTipos()[col]);
        }
//        }
//        for (String cabecalho : manipulador.getCabecalho()) {
//            System.out.println(cabecalho + "\t" + bean.getAttribute(cabecalho));
//        }

        String xmlFull = "<?xml version=\"1.0\"?>\n<Nodo nome=\"Root\">\n";
        xmlFull += "\t<Nodo nome=\"GASOLINA\">\n";
        XMLCreator creator = new XMLCreator();
        String item = creator.montarXML(bean);
        xmlFull += "\t"+item+"\n";
        xmlFull += "\t</Nodo>\n";
        xmlFull += "</Nodo>";
        System.out.println(xmlFull);
    }
}
