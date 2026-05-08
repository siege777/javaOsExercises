import java.io.File;

public class FileService {

    public void showDiskInfo() {

        for(File f : File.listRoots()) {

            System.out.println("Disk: " + f.getAbsolutePath());

            System.out.println(
                    "Diskteki toplam alan: "
                            + f.getTotalSpace() / (1024 * 1024)
                            + " MB"
            );

            System.out.println(
                    "Diskteki boş alan: "
                            + f.getFreeSpace() / (1024 * 1024)
                            + " MB"
            );

            System.out.println("----------------------");
        }
    }

    public static void listFiles(String path) {

        File f = new File(path);

        if(!f.exists()) {
            System.out.println("PATH bulunamadı.");
            return;
        }

        if(!f.isDirectory()) {
            System.out.println("Girilen path bir klasör değil.");
            return;
        }

        File[] files = f.listFiles();

        if(files == null) {
            System.out.println("Klasör okunamadı.");
            return;
        }

        for(File f1 : files) {

            if(f1.isFile()) {

                System.out.println(
                        "[DOSYA] "
                                + f1.getName()
                                + " | Boyut: "
                                + f1.length()
                                + " byte"
                );
            }

            else if(f1.isDirectory()) {

                System.out.println(
                        "[KLASÖR] "
                                + f1.getName()
                );
            }
        }
    }

    public  static void recursiveListFiles(String path){
        File f = new File(path);

        if(f.exists()){

            if(f.isDirectory()){

                File[] files = f.listFiles();

                if(files==null){
                    System.out.println("Klasör okunamadı.");
                    return;
                }

                for(File f1:files){

                    if(f1.isFile()){

                        System.out.println("[DOSYA] "
                                + f1.getAbsolutePath()
                                + " | Boyut: "
                                + f1.length()
                                + " byte");
                    }

                    else if (f1.isDirectory()){

                        System.out.println("[KLASÖR] "
                                + f1.getAbsolutePath());

                        recursiveListFiles(f1.getAbsolutePath());
                    }
                }
            }

            else{
                System.out.println("Girilen path bir klasör değil.");
            }
        }

        else{
            System.out.println("PATH bulunamadı");
        }
    }
    public static void searchFiles(String path, String keyword){
        File f = new File(path);
        if(f.exists()){
            if(f.isDirectory()){
                File[] files = f.listFiles();
                if(files==null){
                    System.out.println("Klasör okunamadı.");
                    return;
                }
                for(File f1:files){
                    if(f1.isFile()){

                        if(f1.getName().toLowerCase().contains(keyword.toLowerCase())){
                            System.out.println("[BULUNDU] " + f1.getAbsolutePath());
                        }
                    }
                    else if(f1.isDirectory()){
                        searchFiles(f1.getAbsolutePath(), keyword);
                    }
                }
            }
            else{
                System.out.println("Girilen path bir klasör değil.");
            }
        }
        else{
            System.out.println("PATH bulunamadı");
        }
    }
}