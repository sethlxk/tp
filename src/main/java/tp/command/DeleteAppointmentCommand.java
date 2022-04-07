package tp.command;

import tp.*;

public class DeleteAppointmentCommand extends Command {
    int index;

    public DeleteAppointmentCommand(){

    }

    public DeleteAppointmentCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute(DoctorList doctorList, PatientList patientList, NurseList nurseList,
                          AppointmentList appointmentList, Ui ui, DoctorStorage doctorStorage,
                          PatientStorage patientStorage,NurseStorage nurseStorage,
                          AppointmentStorage appointmentStorage) throws IHospitalException {
<<<<<<< HEAD
        Appointment curr = appointmentList.deleteAppointment(index);
        if (curr == null){
            return String.format("The index " + index + " is not valid in the appointment list");
        } else {
            return String.format(boundary + "Noted. I've removed this appointment:\n" + curr
                    + "\n" + "Now you have " + (appointmentList.getSize())
                    + " appointments recorded in the system." + System.lineSeparator() + boundary);
=======
        if (index > appointmentList.getSize()) {
            throw new IHospitalException("The appointment does not exist.\n");
>>>>>>> e8a22e36ae93e6b853dff89eb8c1215ae8212bef
        }

        Appointment curr = appointmentList.deleteAppointment(index);
        return String.format(boundary + "Noted. I've removed this appointment:\n" + curr
                                     + "\n" + "Now you have " + (appointmentList.getSize())
                                     + " appointments recorded in the system." + System.lineSeparator() + boundary);
    }
}
