package tp.command;

import tp.AppointmentList;
import tp.DoctorList;
import tp.PatientList;
import tp.Ui;
import tp.person.Doctor;
import tp.DoctorStorage;
import tp.PatientStorage;
import tp.IHospitalException;
import tp.AppointmentStorage;

public class DeleteDoctorCommand extends Command {
    private final int index;

    public DeleteDoctorCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(DoctorList doctorList, PatientList patientList,
                          AppointmentList appointmentList, Ui ui, DoctorStorage doctorStorage,
                          PatientStorage patientStorage,
                          AppointmentStorage appointmentStorage) throws IHospitalException {
        Doctor curr = doctorList.deleteDoctor(index);
        if (curr == null){
            return String.format("The index " + index + " is not valid in the doctor list");
        } else {
            return String.format(boundary + "Noted. I've removed this doctor:" + "\n" + curr
                    + "\n" + "Now you have " + doctorList.getSize()
                    + " doctors in the system." + System.lineSeparator() + boundary);
        }
    }
}
