/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.dynabeans;

import doutorado.tese.io.ManipuladorArquivo;
import java.util.HashMap;

/**
 *
 * @author Anderson Soares
 */
public class DynaBeanFactory {

    private DynaBeanFactory() {
    }

    public static DynaBean newInstance(String nomeBean, ManipuladorArquivo manipulador) {
        DynaBean retorno = null;
        HashMap<String, DynaBeanAttribute> attributes = new HashMap<>();

        try {
            String[] cabecalho = manipulador.getCabecalho();
            Class[] classTipos = manipulador.getClassTipos();
            
            String attName;
            Class attType;
            
            for (int i = 0; i < classTipos.length; i++) {
                attName = cabecalho[i];
                attType = classTipos[i];
                
                DynaBeanAttribute attribute = new DynaBeanAttribute(attName, attType);
                attributes.put(attName, attribute);
            }
            retorno = new DynaBean(nomeBean, attributes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
}
