package com.company.application;

public class Worker extends Thread{
    private Commands commands;

    public Worker(Commands c){
        this.commands = c;
    }

    @Override
    public void run(){
        boolean flag = true;
        while (flag == true){
            if (this.commands.sizeOfCommands() == 0){
                flag = false;
            }
            Command c = this.commands.getCommand();
            if (c != null){
                c.execute();
            }
        }
    }


}
