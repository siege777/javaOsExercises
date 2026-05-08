public class SystemInfoService {
    public static void showSystemInfo() {
        System.out.println("OS name: " + System.getProperty("os.name"));
        System.out.println("OS version: " + System.getProperty("os.version"));
        System.out.println("OS architecture: " + System.getProperty("os.arch"));
        System.out.println("User name: " + System.getProperty("user.name"));
        System.out.println("User directory: " + System.getProperty("user.dir"));
        System.out.println("Java version: " + System.getProperty("java.version"));

    }
}
