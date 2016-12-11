/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StackImplementation;

import com.sun.javafx.applet.ExperimentalExtensions;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author TcheutchouaSteve
 */
public class JStack extends Observable {
    
    private int index ; 
    private int MAX = 10; 
    private int[] myArray; 
    private static List<Observer> observerList ;
    
    
    public JStack(int max){
        this.MAX = max ;
       this.myArray = new int [MAX];
       this.index = -1;
       observerList = new ArrayList<>();
       setChanged();
        notifyObservers(observerList);
    }
    
    
    // create and return a stack object
    public static JStack create(){
        JStack p = new JStack(100);
        return p;
    }

    
    
    //Take an elt and add it at the top of the stack
    public void push (int elt){
        if(!isFull()){
            this.myArray[this.index+1] = elt ;
            this.index++;
            //setChanged();
            notifyObservers(elt);
        }
    }
       
    //removes the element at the top of the stack
    public int pop (){
        if(!isEmpty()){
            int toPop = this.myArray[index] ;
            this.myArray = (int[])ArrayUtils.removeElement(this.myArray, this.myArray[index]);
            this.index -- ;
            //setChanged();           // mark as value changed
            notifyObservers(5);     // trigger notification
            
            return toPop;
        }
        else throw new IndexOutOfBoundsException("The Stack is empty");
    }
       
    public void empty(){
        // create a new object array with the same length
        index = -1 ;
        //setChanged();
        notifyObservers();
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

    
    /*@Override
    public String toString() {
        String display = "" ;
        for (int i = 0; i <= index; i++) {
            display += this.myArray[i] + " ";
        }
        return  display;
    }*/

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); 
        if(o != null){
            observerList.add(o);
        }
    }
    
    
    
}
