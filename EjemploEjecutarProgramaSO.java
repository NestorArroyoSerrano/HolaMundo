public class EjemploEjecutarProgramaSO {
    public static void main(String[] args) {

        Runtime rt = Runtime.getRuntime();
        Process proceso;

        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                proceso = rt.exec("notepad");
            } else if (os.contains("mac")) {
                proceso = rt.exec("open -a TextEdit");
            } else if (os.contains("nux") || os.contains("nix")) {
                proceso = rt.exec("gedit");
            } else {
                System.err.println("Sistema operativo no reconocido");
                System.exit(1);
                return;
            }
            proceso.waitFor();
        } catch (Exception e) {
            System.err.println("El comando es desconocido: " + e.getMessage());
            System.exit(1);
        }
        System.out.println("Se ha cerrado el editor");
        System.exit(0);
    }
}
