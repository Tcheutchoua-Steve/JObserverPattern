/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StackImplementation;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TcheutchouaSteve
 */
public class StackCMPrompt extends Thread implements Observer {
    
    private static JStack stack = null; 
    Scanner input = new Scanner(System.in);
    
    public StackCMPrompt(JStack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        super.run(); 
     
            System.out.println("******** -------- Main Menu   --------- ********** ");
            System.out.println("Enter a number to perform the corresponding operation");
            System.out.println(" 1- Push To Stack\n 2- Pop From Stack\n 3- Top Of The Stack\n 4- Empty The Stack\n 5- Check if Stack isEmpty\n 6- Check if Stack isFull");
            System.out.println("Make a Choice : ");
            int operation ;
            boolean resultPrinted = false ;
            while (true) {
                operation = input.nextInt();
                resultPrinted = true;
                if((operation != 0) && (resultPrinted == true)){
                    displayUpdate(operation);
                }
                resultPrinted = false ;
            }
       
    }
            
    
    
     public static int requestPush(){
         Scanner in = new Scanner(System.in);
         int elt = Integer.valueOf(in.nextLine());
         return elt;
     }

    @Override
    public void update(Observable o, Object arg) {
        try {
            System.out.println("Stack has been updated " + arg);
            //(new StackCMPrompt(this.stack)).start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public  void displayUpdate(int optn){
        try {
        switch (optn) {
                case 1:
                    System.out.println("Enter element to be pushed");
                    this.stack.push(input.nextInt());
                    break;
                case 2:
                    System.out.println("The element poped is " + this.stack.pop());
                    break;
                case 3:
                    System.out.println("Top element is " + this.stack.top());
                    break;
                case 4:
                    this.stack.empty();
                    System.out.println("Stack emptied successfully");
                    break;
                case 5:
                    System.out.println(this.stack.isEmpty());
                    break;
                case 6:
                    System.out.println(this.stack.isFull());
                    break;
    }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
