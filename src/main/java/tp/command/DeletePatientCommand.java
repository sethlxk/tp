package tp.command;

import tp.*;
import tp.person.Patient;

public class DeletePatientCommand extends Command {
    private final int index;

    public DeletePatientCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(DoctorList doctorList, PatientList patientList, NurseList nurseList,
                          AppointmentList appointmentList, Ui ui, DoctorStorage doctorStorage,
                          PatientStorage patientStorage,NurseStorage nurseStorage,
                          AppointmentStorage appointmentStorage) throws IHospitalException {
<<<<<<< HEAD
        Patient curr = patientList.deletePatient(index);
        if (curr == null){
            return String.format("The index " + index + " is not valid in the patient list");
        } else {
            return String.format(boundary + "Noted. I've removed this patient:" + "\n" + curr
                    + "\n" + "Now you have " + patientList.getSize()
                    + " patients in the system." + System.lineSeparator() + boundary);
=======
        if (index > patientList.getSize()) {
            throw new IHospitalException("The patient does not exist.\n");
>>>>>>> e8a22e36ae93e6b853dff89eb8c1215ae8212bef
        }

        Patient curr = patientList.deletePatient(index);
        return String.format(boundary + "Noted. I've removed this patient:" + curr
                                     + "\n" + "Now you have " + patientList.getSize()
                                     + " patients in the system." + System.lineSeparator() + boundary);
    }
}
