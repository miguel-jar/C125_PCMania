import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.nome = "Edigio";
        cliente.cpf = 1901901901;

        Computador[] compras = new Computador[5];
        Computador[] modelosPC = new Computador[3];

        String[] marcas = { "Positivo", "Acer", "Vaio" };
        float[] precos = { 2300f, 5800f, 1800f };

        String[] sisOperacionais = { "Linux Ubuntu", " Windows 8", " Windows 10" };
        int[] tipoSisOperacionais = { 32, 64, 64 };

        String[] nomeMemorias = { "Pen-drive", "Pen-drive", "HD" };
        int[] capacidadeMemorias = { 16, 32, 1000 };

        String[][] hardware = { { "Pentium Core i3 ", "Memória RAM", "HD" },
                { "Pentium Core i5", "Memória RAM", "HD" },
                { "Pentium Core i7", "Memória RAM", "HD" } };

        int[][] capacidadeHardware = { { 2200, 8, 500 }, { 3370, 16, 1000 }, { 4500, 32, 2000 } };

        MemoriaUSB[] memorias = new MemoriaUSB[3];
        for (int g = 0; g < memorias.length; g++) {
            memorias[g] = new MemoriaUSB();
            memorias[g].nome = nomeMemorias[g];
            memorias[g].capacidade = capacidadeMemorias[g];
        }

        // Cria condfigurações de PC
        for (int a = 0; a < modelosPC.length; a++) {
            modelosPC[a] = new Computador();// cria um objeto computador dentro do vetor

            modelosPC[a].marca = marcas[a];// adiciona marca
            modelosPC[a].preco = precos[a];// adiciona preço

            modelosPC[a].sys.nome = sisOperacionais[a]; // adiciona nome sis. operacional
            modelosPC[a].sys.tipo = tipoSisOperacionais[a];

            for (int j = 0; j < 3; j++) {
                modelosPC[a].hardware[j] = new HardwareBasico();

                modelosPC[a].hardware[j].nome = hardware[a][j];
                modelosPC[a].hardware[j].capacidade = capacidadeHardware[a][j];
            }

            modelosPC[a].memoria = new MemoriaUSB();
            modelosPC[a].memoria = memorias[a];
        }

        Scanner teclado = new Scanner(System.in);
        int escolha;

        System.out.println("\nBem vindo à PC Mania ");

        while (true) {

            System.out.println("\nDeseja comprar qual promoção? ");
            System.out.println("  [1] Promoção 1");
            System.out.println("  [2] Promoção 2");
            System.out.println("  [3] Promoção 3");
            System.out.println("  [0] Finalizar compras");

            System.out.print("\nDigite sua escolha: ");
            escolha = teclado.nextInt();

            if (escolha == 0)
                break;

            switch (escolha) {
                case 1, 2, 3:
                    for (int i = 0; i < compras.length; i++)
                        if (compras[i] == null) {
                            compras[i] = new Computador();
                            compras[i] = modelosPC[escolha - 1];
                            break;
                        }
                    break;

                default:
                    System.out.println("\nPromoção não identificada");
            }
        }

        teclado.close();

        System.out.println("\n\nIndo para o carrinho de compras...");

        System.out.println("\nNome: " + cliente.nome);
        System.out.println("CPF: " + cliente.cpf);

        System.out.println("\nConfiguração dos PCs adiquiridos: ");
        for (int n = 0; n < compras.length; n++)
            if (compras[n] != null) {
                System.out.println("\n --> Computador " + (n + 1));
                compras[n].mostraPCConfigs();
            }

        cliente.listaCompras = compras;
        System.out.println("\nTotal da compra: " + cliente.calculaTotalCompra());

    }
}