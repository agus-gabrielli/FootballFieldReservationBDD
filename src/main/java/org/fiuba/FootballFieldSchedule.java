package org.fiuba;

import org.fiuba.exceptions.ClosedFieldException;
import org.fiuba.exceptions.ExcessOfReservationTimeException;
import org.fiuba.exceptions.OccupiedFieldException;

public class FootballFieldSchedule {
    private ReservationHour[] schedule;
    private static final String CLOSED_FIELD_MESSAGE = "Owners (Field Closed)";
    private final int OPENING_HOUR;
    private final int CLOSING_HOUR;


    // Modelo las horas del día con un arreglo de 24 ReservationHours
    public FootballFieldSchedule(int openingHour, int closingHour){
        this.OPENING_HOUR = openingHour;
        this.CLOSING_HOUR = closingHour;

        this.schedule = new ReservationHour[24];
        for (int i = 0; i < OPENING_HOUR; i++){
            this.schedule[i] = new ReservationHour().reserveHour(CLOSED_FIELD_MESSAGE);
        }
        for (int i = OPENING_HOUR; i < CLOSING_HOUR; i++){
            this.schedule[i] = new ReservationHour();
        }
        for (int i = CLOSING_HOUR; i < 23; i++){
            this.schedule[i] = new ReservationHour().reserveHour(CLOSED_FIELD_MESSAGE);
        }
    }

    public boolean isFieldFree(int startingHour, int finishingHour){
        int current_hour = startingHour;
        while (current_hour < finishingHour){
            if (! this.schedule[current_hour].isFree()) {
                return false;
            }
            current_hour += 1;
        }
        return true;
    }

    // Precondición: el período fue reservado por la misma persona
    public String periodIsReservedBy(int startingHour){
        return this.schedule[startingHour].wasReservedBy();
    }

    public void reserveField(int startingHour, int finishingHour, String reserverName){
        if (finishingHour - startingHour > 3){
            throw new ExcessOfReservationTimeException("Excess of reservation time");
        }
        if (startingHour >= CLOSING_HOUR || finishingHour < OPENING_HOUR || startingHour < OPENING_HOUR) {
            throw new ClosedFieldException("Field closed at specified time");
        }
        if(! this.isFieldFree(startingHour, finishingHour)){
            throw new OccupiedFieldException("Field is occupied sometime in the range specified");
        }
        int current_hour = startingHour;
        while (current_hour < finishingHour){
            this.schedule[current_hour].reserveHour(reserverName);
            current_hour += 1;
        }
    }
}
