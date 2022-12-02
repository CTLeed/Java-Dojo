package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {

	
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician(int id) {
    	super(id);
    	this.patientNotes = new ArrayList<String>();
   }
    
    // TO DO: Implement HIPAACompliantUser!
    @Override
    public boolean assignPin(int pin) {
    	int length = (int) (Math.log10(pin) + 1);
    	if(length == 4) {
    		this.pin = pin;
    		return true;
    	} else {
    		return false;			
    	}
    }
    
    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	if(confirmedAuthID == this.id) {
    		return true;
    	} else {
    		return false;			
    	}
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }


}
