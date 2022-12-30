package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MailListReader{

    public static List<String> read(String fileName) {
        BufferedReader br = null;
        List<String> mails = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String linea;
            while ((linea = br.readLine()) != null) {
            if (!linea.contains("@")) continue;
            mails.add(new String(linea));
        }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return mails;
    }
}
