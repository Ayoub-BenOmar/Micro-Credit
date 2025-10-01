package util;

import model.Professionnel;

import java.time.LocalDate;
import java.time.Period;

public class ProfessionnelValidation {

    public static boolean validateProfessionnel(Professionnel professionnel) {
        return validateName(professionnel.getName())
                && validateName(professionnel.getLastName())
                && validateBirthDate(professionnel.getBirthDate())
                && validateCity(professionnel.getCity())
                && validateRevenue(professionnel.getRevenue())
                && validateImmatriculation(professionnel.getFiscaleImmatriculation())
                && validateActivityField(professionnel.getActivityField())
                && validateActivity(professionnel.getActivity());
    }

    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 2;
    }

    public static boolean validateBirthDate(LocalDate birthDate) {
        if (birthDate == null) return false;

        LocalDate today = LocalDate.now();
        if (birthDate.isAfter(today)) return false;

        int age = Period.between(birthDate, today).getYears();
        return age >= 18;
    }

    public static boolean validateCity(String city) {
        return city != null && !city.trim().isEmpty();
    }

    public static boolean validateRevenue(double revenue) {
        return revenue > 0;
    }

    public static boolean validateImmatriculation(String immatriculation) {
        return immatriculation != null && !immatriculation.trim().isEmpty();
    }

    public static boolean validateActivityField(String field) {
        return field != null && !field.trim().isEmpty();
    }

    public static boolean validateActivity(String activity) {
        return activity != null && !activity.trim().isEmpty();
    }
}
