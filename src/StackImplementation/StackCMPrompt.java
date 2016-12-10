/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StackImplementation;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * @author TcheutchouaSteve
 */
public class StackCMPrompt implements Observer {
    
    private static JStack stack = null; 

    public StackCMPrompt(JStack stack) {
        this.stack = stack;
    }
            
     public static void main(String[] args){
        //stack = new JStack(12);
        stack.create();

        stack.push(requestPush());
        stack.pop();
        System.out.println(stack);
        
        //System.out.println(stack);
    }
     
     public static int requestPush(){
         Scanner in = new Scanner(System.in);
         int elt = Integer.valueOf(in.nextLine());
         return elt;
     }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
}
