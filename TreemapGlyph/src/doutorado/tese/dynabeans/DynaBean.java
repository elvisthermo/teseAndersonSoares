/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.dynabeans;

import java.util.HashMap;

/**
 *
 * @author Anderson Soares
 */
public class DynaBean {

    private String nome;
    private HashMap<String, DynaBeanAttribute> attributes;

    public DynaBean(String nome, HashMap<String, DynaBeanAttribute> attributes) {
        this.nome = nome;
        this.attributes = attributes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Object getAttribute(String att) {
        return attributes.get(att).getValor();
    }

    public void setAttribute(String att, Object value, Class tipo) {
        try {
            attributes.get(att).setValor(converterTipoCorreto(value, tipo));
        } catch (ClassCastException e) {
            throw e;
        }
    }

    private Object converterTipoCorreto(Object obj, Class tipo) {
        if (tipo.equals(Integer.class)) {
            return Integer.parseInt(obj.toString());
        } else if(tipo.equals(Double.class)){
            return Double.parseDouble(obj.toString());
        }else if (tipo.equals(Float.class)){
            return Float.parseFloat(obj.toString());
        }else if (tipo.equals(Boolean.class)){
            return Boolean.parseBoolean(obj.toString());
        }else{
            return String.valueOf(obj);
        }
    }
}
