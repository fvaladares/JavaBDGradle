
/*
        PARA ESTA AULA, BAIXE O INTELLIJ COMMUNITY PARA WINDOWS, VERSÃO ZIP!!!
        BAIXE O DBBROWSER FOR SQLITE PARA WINDOWS, EM VERSÃO ZIP (NO INSTALLER)
        https://sqlitebrowser.org/dl/

        https://github.com/fvaladares/ListaDeProdutosSqLiteFASEH/tree/a83940fdda3b5539e87f9c08546c54e8e326e5d2
 */

import java.util.List;

import javabdgradle.Product;
import javabdgradle.ProductDAO;

public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        // 1. CREATE - Adicionar novos produtos
        System.out.println("\n--- Adicionando Produtos ---");
        productDAO.addProduct(new Product("Notebook", 5500.00));
        productDAO.addProduct(new Product("Mouse", 75.50));
        productDAO.addProduct(new Product("Teclado Mecânico", 450.00));

        // 2. READ - Listar todos os produtos
        System.out.println("\n--- Lista de Produtos ---");
        List<Product> products = productDAO.getAllProducts();
        products.forEach(System.out::println);

        // 3. READ - Buscar um produto por ID (supondo que o Notebook tenha ID 1)
        System.out.println("\n--- Buscando Produto por ID (ID 1) ---");
        Product productFound = productDAO.getProductById(1);
        if (productFound != null) {
            System.out.println("Produto encontrado: " + productFound);
        } else {
            System.out.println("Produto com ID 1 não encontrado.");
        }

        // 4. UPDATE - Atualizar um produto (supondo que o Mouse tenha ID 2)
        System.out.println("\n--- Atualizando Produto (ID 2) ---");
        Product productToUpdate = new Product(2,
                "Mouse Sem Fio",
                199.99);
        productDAO.updateProduct(productToUpdate);

        System.out.println("\n--- Lista de Produtos após Atualização ---");
        productDAO.getAllProducts().forEach(System.out::println);

        // 5. DELETE - Excluir um produto (supondo que o Teclado Mecânico tenha ID 3)
        System.out.println("\n--- Excluindo Produto (ID 3) ---");
        productDAO.deleteProduct(3);

        System.out.println("\n--- Lista de Produtos após Exclusão ---");
        productDAO.getAllProducts().forEach(System.out::println);

        // Tentando excluir um produto que não existe
        System.out.println("\n--- Tentando Excluir Produto Inexistente (ID 99) ---");
        productDAO.deleteProduct(99);
    }
}