package util;

import model.Employe;

import java.time.*;
import java.time.LocalDate;

public class EmployeValidation {
    public static boolean validateEmploye(Employe employe) {
        return validateName(employe.getName())
                && validateName(employe.getLastName())
                && validateBirthDate(employe.getBirthDate())
                && validateCity(employe.getCity())
                && validateSalary(employe.getSalary())
                && validateSeniority(employe.getSeniority());
    }

    public static boolean validateName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() >= 2;
    }

    public static boolean validateBirthDate(LocalDate birthDate) {
        if (birthDate == null)
            return false;

        LocalDate today = LocalDate.now();

        if (birthDate.isAfter(today))
            return false;

        int age = Period.between(birthDate, today).getYears();

        return age >= 18;
    }

    public static boolean validateCity(String city) {
        return city != null && !city.trim().isEmpty();
    }

    public static boolean validateSalary(double salary) {
        return salary > 0;
    }

    public static boolean validateSeniority(double seniority) {
        return seniority >= 0;
    }
}
