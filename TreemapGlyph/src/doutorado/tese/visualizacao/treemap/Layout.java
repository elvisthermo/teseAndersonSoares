/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doutorado.tese.visualizacao.treemap;

/**
* The interface for the treemap layoutSquarifiedTreemap algorithm.
*/
public interface Layout
{
   /**
    * Arrange the items in the given MapModel to fill the given rectangle.
    *
    * @param model The MapModel.
    */
   public void layoutSquarifiedTreemap(TreeMapNode model);
 }
