package tp.command;

import tp.*;

public class ListPatientListCommand extends Command {

    @Override
    public String execute(DoctorList doctorList, PatientList patientList, NurseList nurseList,
                          AppointmentList appointmentList, Ui ui, DoctorStorage doctorStorage,
                          PatientStorage patientStorage,NurseStorage nurseStorage,
                          AppointmentStorage appointmentStorage) throws IHospitalException {
        return patientList.toString();
    }
}
