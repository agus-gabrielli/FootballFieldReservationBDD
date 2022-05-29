package org.fiuba;

import org.fiuba.exceptions.AlreadyReservedHourException;
import org.fiuba.exceptions.NotReservedHourException;

public class ReservationHour {

    private boolean isFree;
    private String personThatReserved;

    public ReservationHour(){
        this.isFree = true; // Todas las horas de reserva por defecto empiezan estando libres
    }

    public ReservationHour reserveHour(String personThatReserved){
        if(! this.isFree){
            throw new AlreadyReservedHourException("Hour already reserved by " + personThatReserved);
        }
        this.isFree = false;
        this.personThatReserved = personThatReserved;
        return this;
    }

    public boolean isFree(){
        return this.isFree;
    }

    public String wasReservedBy(){
        if(this.isFree){
            throw new NotReservedHourException("Hour not yet reserved");
        }
        return this.personThatReserved;
    }
}
