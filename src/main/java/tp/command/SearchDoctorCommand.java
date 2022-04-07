package tp.command;

import tp.*;
import tp.person.Doctor;

public class SearchDoctorCommand extends Command {
    protected String id;

    public SearchDoctorCommand(String id) {
        this.id = id;
    }

    @Override
    public String execute(DoctorList doctorList, PatientList patientList, NurseList nurseList,
                          AppointmentList appointmentList, Ui ui, DoctorStorage doctorStorage,
                          PatientStorage patientStorage,NurseStorage nurseStorage,
                          AppointmentStorage appointmentStorage) throws IHospitalException {
        Doctor curr = doctorList.searchDoctor(id);
        if (curr == null) {
<<<<<<< HEAD
            return String.format("There is no doctor with the id: " + id + " in the doctor list");
=======
            return String.format("There is no doctor with ID: " + id + "\n");
>>>>>>> e8a22e36ae93e6b853dff89eb8c1215ae8212bef
        }
        return String.format("Here's the doctor found: \n" + curr + "\n");
    }
}
