/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.frre.programacion;

/**
 *
 * @author developer
 */
public interface IBinaryTree {

    public void setValue(Object a);

    public Object getValue();

    public IBinaryTree getLeftSon();

    public IBinaryTree getRighSon();

    public void setLeftSon(IBinaryTree a);

    public void setRighSon(IBinaryTree a);
}
