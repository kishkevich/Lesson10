import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        ReadFromXML readFromXML = new ReadFromXML(hospital);
        readFromXML.read();
        System.out.println(hospital);


    }
}
