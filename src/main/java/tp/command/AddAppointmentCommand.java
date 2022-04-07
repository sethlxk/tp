package tp.command;

import tp.*;
import tp.person.Doctor;
import tp.person.Patient;

import java.time.LocalDateTime;

public class AddAppointmentCommand extends Command {
    protected int doctorIndex;
    protected int patientIndex;
    protected LocalDateTime time;

    public AddAppointmentCommand() {

    }

    public AddAppointmentCommand(int doctorIndex, int patientIndex, String time) {
        this.doctorIndex = doctorIndex;
        this.patientIndex = patientIndex;
        this.time = LocalDateTime.parse(time);
    }


    @Override
    public String execute(DoctorList doctorList, PatientList patientList, NurseList nurseList,
                          AppointmentList appointmentList, Ui ui, DoctorStorage doctorStorage,
                          PatientStorage patientStorage,NurseStorage nurseStorage,
                          AppointmentStorage appointmentStorage) throws IHospitalException {

        if (doctorIndex <= 0 || doctorIndex > doctorList.getSize()) {
            throw new IHospitalException("The doctor does not exist in the doctor list.\n"
                    + "Please ensure you enter a valid doctor index or add a doctor first");
        }
        if (patientIndex <= 0 || patientIndex > patientList.getSize()) {
            throw new IHospitalException("The patient does not exist in the patient list.\n"
                    + "Please ensure you enter a valid patient index or add a patient first");
        if (doctorIndex > doctorList.getSize()) {
            throw new IHospitalException("The doctor does not exist\n");
        }
        if (patientIndex > patientList.getSize()) {
            throw new IHospitalException("The patient does not exist\n");
        }

        Doctor doctor = (Doctor) doctorList.getDoctor(doctorIndex);
        Patient patient = (Patient) patientList.getPatient(patientIndex);
        appointmentList.addAppointment(doctor, patient, time);
        return String.format(boundary + "Noted. I've added this appointment:\n"
                                     + appointmentList.getAppointment(appointmentList.getSize()) + "\n"
                                     + "Now you have " + appointmentList.getSize()
                                     + " appointments recorded in the system." + System.lineSeparator() + boundary);
    }
}
