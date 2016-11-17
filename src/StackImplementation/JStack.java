/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StackImplementation;

import com.sun.javafx.applet.ExperimentalExtensions;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author TcheutchouaSteve
 */
public class JStack {
    
    private int index ; 
    private int MAX = 10; 
    private int[] myArray; 

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getMAX() {
        return MAX;
    }

    public void setMAX(int MAX) {
        this.MAX = MAX;
    }
    
    public JStack(int max){
        this.MAX = max ;
       this.myArray = new int [MAX];
       this.index = -1;
    }
    
    // create and return a stack object
    public static JStack create(){
        JStack p = new JStack(100);
        return p;
    }
    
    /*public  void create(){
        this.myArray = new int[this.MAX];
    }*/
    
    //Take an elt and add it at the top of the stack
    public void push (int elt){
        if(!isFull()){
            this.myArray[this.index+1] = elt ;
            this.index++;
        }
    }
    
    //removes the element at the top of the stack
    public int pop (){
       // myArray = ArrayUtils.removeElement(myArray, myArray[index]);
        if(!isEmpty()){
            int toPop = this.myArray[index] ;
            this.myArray = (int[])ArrayUtils.removeElement(this.myArray, this.myArray[index]);
            //myArray[index] = null ;
            this.index -- ;
            return toPop;
        }
        else throw new IndexOutOfBoundsException("The Stack is empty");
    }
    
    public void empty(){
        // create a new object array with the same length
        index = -1 ;
    }
    
    public boolean isEmpty(){
        if (this.index < 0 )
            return true ;
        else
            return false;
    }
    
    public boolean isFull(){
        // array is full when the index correspond to the size of the stack
        if(this.index == this.MAX - 1)
            return true;
        else
            return false ; 
    }
    
    public int top() throws Exception{
        if(this.index < 0){
            Exception ex = new Exception("There are no elements in top you can't "
                    + "get the first element");
            throw ex;
        }
        else 
            return this.myArray[this.index];
    }

    @Override
    public String toString() {
        String display = "" ;
        for (int i = 0; i <= index; i++) {
            display += this.myArray[i] + " ";
        }
        return  display;
    }
    
    
}
