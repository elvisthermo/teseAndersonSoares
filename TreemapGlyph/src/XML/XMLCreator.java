/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import doutorado.tese.dynabeans.DynaBean;
import doutorado.tese.dynabeans.DynaBeanAttribute;
import doutorado.tese.io.ManipuladorArquivo;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author Anderson Soares
 */
public class XMLCreator {

    ManipuladorArquivo manipulador;

    public XMLCreator() {
    }

    public String montarXML(Object obj) {
        XStream stream = new XStream(new DomDriver());
        stream.alias("Nodo", DynaBean.class);
        stream.alias("branch", DynaBeanAttribute.class);
//        stream.addImplicitCollection(DynaBean.class, "attributes");
        stream.addImplicitMap(DynaBean.class, "attributes", Integer.class, "tipo");
        stream.useAttributeFor(DynaBean.class, "nome");
//        stream.useAttributeFor(DynaBean.class, "attributes");
//        stream.omitField(DynaBean.class, "string");
        stream.setMode(XStream.NO_REFERENCES);
        String out = stream.toXML(obj);
//        System.out.println(out);
        return out;
    }

    public Object carrega(InputStream inputStream) {
        XStream stream = new XStream(new DomDriver());
//        stream.alias(negociacao, Negociacao.class);
        return stream.fromXML(inputStream);
    }

//    public static void main(String[] args) {
//        XMLCreator xml = new XMLCreator();
//        xml.montarXML();
//    }
}
