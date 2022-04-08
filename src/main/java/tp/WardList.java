package tp;

import tp.person.Doctor;
import tp.person.Nurse;
import tp.person.Patient;

import java.util.ArrayList;

public class WardList {
    public static String boundary = "____________________________________________________________"
            + System.lineSeparator();
    protected ArrayList<Ward> wards = new ArrayList<>();
    protected int countWard;

    public WardList() {
        countWard = 0;
    }

    public Ward getWard(int index) {
        return wards.get(index - 1);
    }

    /**
     * Adds a ward to ward list.
     *
     * @param doctor Doctor assigned for this ward.
     * @param patient Patient coming for this ward.
     * @param nurse Nurse assigned for this ward.
     */
    public void addWard(Doctor doctor, Patient patient, Nurse nurse, String number) {
        wards.add(new Ward(doctor, patient, nurse, number));
        countWard++;
    }

    public void addWard(Ward ward) {
        wards.add(ward);
    }

    /**
     * Deletes a ward from the list.
     *
     * @param index Index of the ward to be deleted.
     */
    public Ward deleteWard(int index) {
        Ward cur = wards.get(index - 1);
        wards.remove(index - 1);
        countWard -= 1;
        return cur;
    }

    /**
     * Get the list of ward of a given doctor.
     *
     * @param id ID of the doctor.
     * @return Ward list of the given doctor.
     */
    public WardList getWardListOfDoctorById(String id) {
        WardList warDoc = new WardList();
        for (Ward ward : wards) {
            if (ward.getDoctor().getId().equals(id)) {
                warDoc.addWard(ward);
            }
        }
        return warDoc;
    }


    public Ward searchWard(String num) {
        for (int i = 0; i < wards.size(); i++) {
            if (wards.get(i).getNumber().equals(num)) {
                return wards.get(i);
            }
        }
        return null;
    }

    public int getSize() {
        return countWard;
    }



    @Override
    public String toString() {
        String toPrint = boundary + "Here are the existing wards:" + System.lineSeparator();
        for (int i = 1; i <= countWard; i++) {
            toPrint += (i + ". " + getWard(i) + System.lineSeparator());
        }
        toPrint += ("Now you have " + countWard
                + " wards recorded in the system." + System.lineSeparator()
                + boundary);
        return toPrint;
    }
}