public class Cliente {
    String nome;
    long cpf;

    Computador[] listaCompras;

    float calculaTotalCompra() {
        float total = 0f;

        for (Computador c : listaCompras)
            if (c != null)
                total += c.preco;

        return total;
    }
}
