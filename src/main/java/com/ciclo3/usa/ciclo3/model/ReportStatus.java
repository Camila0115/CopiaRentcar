package com.ciclo3.usa.ciclo3.model;

public class ReportStatus {

    private Integer completed;
    private Integer cancelled;
    
    public ReportStatus (int completed, int cancelled){

        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted(){
        return completed;
    }

    public void setCompleted(int completed){
        this.completed = completed;
    }

    public int getCancelled(){
        return cancelled;
    }

    public void setCancelled(int cancelled){
        this.cancelled = cancelled;
    }
}
