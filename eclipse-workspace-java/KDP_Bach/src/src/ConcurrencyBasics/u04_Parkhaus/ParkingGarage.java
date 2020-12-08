package src.ConcurrencyBasics.u04_Parkhaus;

import java.util.ArrayList;

public class ParkingGarage
{
	//
	//Nun fehlt nur noch etwas debugging Code
	//
	
    private int freePlaces;
    
    public ParkingGarage(int places) {
        this.freePlaces = places;
    }

	public synchronized void enter() {
		//Wenn es noch genügend freien Platz hat! -> Abfragen und wait/notify Muster verwenden
		while (freePlaces == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		freePlaces--;
	}

	public synchronized void leave() {
		freePlaces++;
		//ein wartendes Auto kann nun einfahren! ->aufwecken
		notify();
	}
}
