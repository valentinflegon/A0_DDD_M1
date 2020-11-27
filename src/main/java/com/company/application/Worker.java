package com.company.application;

import java.io.IOException;

public class Worker extends Thread{
    private Commands commands;
    boolean flag = true;
    public Worker(Commands c){
        this.commands = c;
    }

    @Override
    public void run(){

        while (flag == true){
            Command c = this.commands.getCommand();
            if (c != null){

                c.execute();
                System.out.println("execute ");
            }
        }
    }

}
