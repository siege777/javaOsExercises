import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ShellService {
    public void startShell() {
        String os = System.getProperty("os.name").toLowerCase();
        Scanner sc = new Scanner(System.in);
        String command = "";

        while(!command.equalsIgnoreCase("exit")) {
            System.out.println("Komut giriniz: ");
            command = sc.nextLine();

            if(command.equalsIgnoreCase("exit")) {
                System.out.println("Çıkılıyor...");
                break;
            }

            if(command.trim().isEmpty()) {
                continue;
            }

            try {
                Process p;

                if(os.contains("win")) {
                    p = Runtime.getRuntime().exec(new String[]{"cmd", "/c", command});
                }
                else {
                    p = Runtime.getRuntime().exec(new String[]{"sh", "-c", command});
                }

                BufferedReader br = new BufferedReader(
                        new InputStreamReader(p.getInputStream())
                );

                BufferedReader errorBr = new BufferedReader(
                        new InputStreamReader(p.getErrorStream())
                );

                String line;

                while((line = br.readLine()) != null) {
                    System.out.println(line);
                }

                while((line = errorBr.readLine()) != null) {
                    System.out.println(line);
                }

            }
            catch(IOException e) {
                System.out.println("Process başlatılırken hata oluştu.");
            }
        }
    }
}