public class Computador {
    String marca;
    float preco;

    HardwareBasico[] hardware;
    MemoriaUSB memoria;
    SistemaOperacional sys;

    public Computador() {
        sys = new SistemaOperacional();
        hardware = new HardwareBasico[3];
    }

    void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: " + preco);

        System.out.println("\nSistema operacional: ");
        System.out.println("  Nome: " + sys.nome);
        System.out.println("  Tipo: " + sys.tipo + " bits");

        System.out.println("\nMemoria");
        System.out.println("  Nome: " + memoria.nome);
        System.out.println("  Capacidade: " + memoria.capacidade + " GB");

        System.out.println("\nHardware Básico");
        String unidade = "MHz";

        for (HardwareBasico ppk : hardware) {
            System.out.println("  Nome: " + ppk.nome);
            System.out.println("  Capacidade: " + ppk.capacidade + " " + unidade + "\n");
            unidade = "GB";
        }
    }

    void addMemoriaUSB(MemoriaUSB musb) {
        memoria.nome = musb.nome;
        memoria.capacidade = musb.capacidade;
    }

}
