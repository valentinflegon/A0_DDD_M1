package com.company.application;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private List<Command> commands;

    public Commands() {
        this.commands = new ArrayList<>();
    }

    //AJOUT D'UNE COMMANDE A EXECUTER A LA LISTE
    public synchronized void pushCommand(Command c){
        this.commands.add(c);

    }


    //RECUPERE LA COMMANDE A EXECUTER
    public synchronized Command getCommand(){
        if (this.commands.size() > 0) {
            return this.commands.remove(0);
        } else {
            return null;
        }
    }

    public int sizeOfCommands(){
        return this.commands.size();
    }
}
