package tp.command;

import tp.*;
import tp.person.Doctor;

public class DeleteDoctorCommand extends Command {
    private final int index;

    public DeleteDoctorCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(DoctorList doctorList, PatientList patientList, NurseList nurseList,
                          AppointmentList appointmentList, Ui ui, DoctorStorage doctorStorage,
                          PatientStorage patientStorage,NurseStorage nurseStorage,
                          AppointmentStorage appointmentStorage) throws IHospitalException {
<<<<<<< HEAD
        Doctor curr = doctorList.deleteDoctor(index);
        if (curr == null){
            return String.format("The index " + index + " is not valid in the doctor list");
        } else {
            return String.format(boundary + "Noted. I've removed this doctor:" + "\n" + curr
                    + "\n" + "Now you have " + doctorList.getSize()
                    + " doctors in the system." + System.lineSeparator() + boundary);
=======
        if (index > doctorList.getSize()) {
            throw new IHospitalException("The doctor does not exist.\n");
>>>>>>> e8a22e36ae93e6b853dff89eb8c1215ae8212bef
        }

        Doctor curr = doctorList.deleteDoctor(index);
        return String.format(boundary + "Noted. I've removed this doctor:" + curr
                                     + "\n" + "Now you have " + doctorList.getSize()
                                     + " doctors in the system." + System.lineSeparator() + boundary);
    }
}
