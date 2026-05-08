import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessService {
    String os = System.getProperty("os.name");
    public void listProcesses(){
    if (os.contains("Windows")) {
        try{
       Process p = Runtime.getRuntime().exec("tasklist"); //try-catch kullanımı gerekir
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            for(String line; (line = br.readLine()) != null; ){
                System.out.println(line);
            }
        }
        catch (IOException e){
            System.out.println("Process başlatılırken hata oluştu.");
        }
    }
    else if (os.contains("Linux") || os.contains("Mac")) {
        try{
        Process p = Runtime.getRuntime().exec("ps -e");
        InputStreamReader isr = new InputStreamReader(p.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        for(String line; (line = br.readLine()) != null; ){
            System.out.println(line);
        }

        }
        catch (IOException e){
            System.out.println("Process başlatılırken hata oluştu.");
        }
    }
    }
}
