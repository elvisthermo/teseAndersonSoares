/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.dynabeans;

/**
 *
 * @author Anderson Soares
 */
public class DynaBeanAttribute {

    private String nome;
    private Class tipo;
    private Object valor;

    public DynaBeanAttribute(String nome, Class tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Class getTipo() {
        return tipo;
    }

    public void setTipo(Class tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        //verifica se o valor passado é valido para o tipo de atributo.
        //Ex: Atributos do tipo int não podem receber Strings
        if (tipo.isAssignableFrom(valor.getClass())) {
            //se o valor for valido, entao atribui o mesmo
            this.valor = valor;
        } else {
            //se nao for valido emitir uma Exception contendo o erro,
            //que informa que o tipo do valor passado como parametro, nao equivale ao
            //tipo do atributo do bean dinamico
            throw new ClassCastException("Tipos incompatíveis: " + tipo + "/" + valor.getClass());
        }

    }

}
