import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class Patient {
    private String surname;
    private String name;
    private Date dateOfBirth;
    private boolean health;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

    public Patient(String surname, String name, Date dateOfBirth, boolean health) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
    }

    public Patient(String surname, String name, boolean health) {
        this.surname = surname;
        this.name = name;
        this.health = health;
    }

    public Patient(String surname, String name, String health) {
        this(surname, name, Boolean.getBoolean(health));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(surname, patient.surname) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(dateOfBirth, patient.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, dateOfBirth);
    }

    public String getSurame() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return dateOfBirth;
    }


    public boolean getHealth() {
        return health;
    }

    public String toString() {
        return "Patient {" +
                "name: " + name +
                "; surname: " + surname +
                "; date of birth: " + dateOfBirth +
                "; health: " + health + " }";
    }


}
