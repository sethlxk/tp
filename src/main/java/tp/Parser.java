package tp;

import java.util.Scanner;

public class Parser {

    public Parser() {

    }

    public static String getCommand() {
        String command;
        Scanner in = new Scanner(System.in);
        command = in.nextLine();
        return command;
    }

    public Command parse(String fullCommand) throws IHospitalException {
        if (fullCommand.contains("add doctor")) {
            String id;
            String dummy = fullCommand.trim();
            if (dummy.indexOf("/id") > dummy.indexOf("/n") || dummy.indexOf("/id") > dummy.indexOf("/ph")
                || dummy.indexOf("/id") > dummy.indexOf("/e") || dummy.indexOf("/n") > dummy.indexOf("/ph")
                    || dummy.indexOf("/n") > dummy.indexOf("/e") || dummy.indexOf("/ph") > dummy.indexOf("/e")) {
                throw new IHospitalException("The format of input is wrong, can check the order");
            }

            int idIndex = dummy.indexOf("/id") + 4;
            int nameIndex = dummy.indexOf("/n");
            id = dummy.substring(idIndex, nameIndex).trim();
            nameIndex += 3;
            int phoneNumberIndex = dummy.indexOf("/ph");
            String name = dummy.substring(nameIndex, phoneNumberIndex).trim();
            phoneNumberIndex += 4;
            int emailIndex = dummy.indexOf("/e");
            String phoneNumber = dummy.substring(phoneNumberIndex, emailIndex).trim();
            emailIndex += 3;
            String email = dummy.substring(emailIndex).trim();
            return new AddDoctorCommand(id, name, phoneNumber, email, false);

        } else if (fullCommand.contains("get") && fullCommand.contains("appointment")) {
            //get appointment /d 123456
            String dummy = fullCommand.trim();
            String id =  dummy.substring(dummy.indexOf("/d") + 3).trim();
            return new GetAppointmentsOfDoctorCommand(id);
        } else if (fullCommand.contains("sort appointment")) {
            return new SortAppointmentByTimeCommand();
        } else if (fullCommand.contains("add patient")) {
            String id;
            String dummy = fullCommand.trim();
            String name;
            String phoneNumber;
            try {
                int idIndex = dummy.indexOf("/id") + 4;
                int nameIndex = dummy.indexOf("/n");
                id = dummy.substring(idIndex, nameIndex).trim();
                nameIndex += 3;
                int phoneNumberIndex = dummy.indexOf("/ph");
                name = dummy.substring(nameIndex, phoneNumberIndex).trim();
                phoneNumberIndex += 4;
                int emailIndex = dummy.indexOf("/e");
                phoneNumber = dummy.substring(phoneNumberIndex, emailIndex).trim();
                emailIndex += 3;
                int symptomIndex = dummy.indexOf("/s");
                String email = dummy.substring(emailIndex,symptomIndex).trim();
                symptomIndex += 3;
                int descIndex = dummy.indexOf("/d");
                String symptom = dummy.substring(symptomIndex,descIndex).trim();
                descIndex += 3;
                String description = dummy.substring(descIndex).trim();
                return new AddPatientCommand(id, name, phoneNumber, email, symptom,description);
            } catch (Exception e) {
                System.out.println("The input format of the patient information is wrong.");
            }

        } else if (fullCommand.contains("add appointment")) {
            String time;
            String dummy = fullCommand.trim();
            int timeIndex = dummy.indexOf("/t");
            int doctorIndex = dummy.indexOf("/d");
            timeIndex += 3;
            time = dummy.substring(timeIndex, doctorIndex).trim();
            int patientIndex = dummy.indexOf("/p");
            doctorIndex += 3;
            String s = dummy.substring(doctorIndex, patientIndex).trim();

            doctorIndex = Integer.parseInt(s);
            patientIndex += 3;
            s = dummy.substring(patientIndex).trim();
            patientIndex = Integer.parseInt(s);
            return new AddAppointmentCommand(doctorIndex, patientIndex, time);
        } else if (fullCommand.contains("delete doctor")) {
            String dummy = fullCommand.trim();
            int index = Integer.parseInt(dummy.substring(dummy.length() - 1));
            return new DeleteDoctorCommand(index);
        } else if (fullCommand.contains("delete patient")) {
            String dummy = fullCommand.trim();
            int index = Integer.parseInt(dummy.substring(dummy.length() - 1));
            return new DeletePatientCommand(index);
        } else if (fullCommand.contains("delete appointment")) {
            String dummy = fullCommand.trim();
            int index = Integer.parseInt(dummy.substring(dummy.length() - 1));
            return new DeleteAppointmentCommand(index);
        } else if (fullCommand.contains("list doctor")) {
            return new ListDoctorListCommand();
        } else if (fullCommand.contains("list appointment")) {
            return new ListAppointmentListCommand();
        } else if (fullCommand.contains("list patient")) {
            return new ListPatientListCommand();
        } else if (fullCommand.contains("help")) {
            return new HelpCommand();
        } else if (fullCommand.contains("add patient description")) {
            String dummy = fullCommand.trim();
            int patientIndex = dummy.indexOf("/p");
            int descriptionIndex = dummy.indexOf("/d");
            int patientID = Integer.parseInt(dummy.substring(patientIndex, descriptionIndex).trim());
            descriptionIndex += 3;
            String description = dummy.substring(descriptionIndex);
            return new AddPatientDescriptionCommand(description, patientID);
        } else if (fullCommand.contains("search doctor")) {
            String dummy = fullCommand.trim();
            dummy = dummy.substring(dummy.length() - 4);
            return new SearchDoctorCommand(dummy);
        } else if (fullCommand.contains("search patient")) {
            String dummy = fullCommand.trim();
            dummy = dummy.substring(dummy.length() - 4);
            return new SearchPatientCommand(dummy);
        } else if (fullCommand.contains("search appointment")) {
            String dummy = fullCommand.trim();
            dummy = dummy.substring(17);
            return new SearchAppointmentCommand(dummy);
        } else {
            throw new IHospitalException("Invalid command given");
        }

        return null;
    }
}


