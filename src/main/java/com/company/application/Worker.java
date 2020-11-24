package com.company.application;

public class Worker extends Thread{
    private Commands commands;

    public Worker(Commands c){
        this.commands = c;
    }

    @Override
    public void run(){
        while (true){
            Command c = this.commands.getCommand();
            if (c != null){
                c.execute();
            }
        }
    }


}
