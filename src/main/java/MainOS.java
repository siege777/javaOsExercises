import java.util.Scanner;

public class MainOS {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int secim=10;
        while(secim!=0){
        System.out.println("" +
                "1- İşletim sistemi bilgisi göster\n" +
                "2- Java runtime bilgisi göster\n" +
                "3- Diskleri listele\n" +
                "4- Belirli bir klasördeki dosyaları listele\n" +
                "5- Belirli bir dizindeki ve altında tüm dosyaları listele\n" +
                "6- Çalışan process listesini göster\n" +
                "0- Çıkış");
        secim = sc.nextInt();
        sc.nextLine();

        switch(secim){
            case 1:
                SystemInfoService.showSystemInfo();
                break;
            case 2:
                break;
            case 3:
                FileService fs = new FileService();
                fs.showDiskInfo();
                break;
            case 4:
                System.out.println("Lütfen bir PATH giriniz: ");
                String path1 = sc.nextLine();
                FileService.listFiles(path1);
                break;
            case 5:
                System.out.println("Lütfen bir PATH giriniz: ");
                String path2 = sc.nextLine();
                FileService.recursiveListFiles(path2);
                break;
            case 6:
                ProcessService ps = new ProcessService();
                ps.listProcesses();
                break;
            case 0:
                break;

        }



        }

    }
}
