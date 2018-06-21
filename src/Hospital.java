import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Hospital {
    private Set<Patient> patients =new HashSet<>();

    public void add (Patient patient){
       patients.remove(patient);
        patients.add(patient);
       //patients.add(patient);
    }

    public String toString (){
        return "Hospital {" +
                "Patient: " + patients +
                " }";
    }

    public Set<Patient> getPatient() {
        return patients;
    }
}
