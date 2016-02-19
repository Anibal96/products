import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) == null){
            stock.add(item);
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product producto = findProduct(id);
        if (producto == null){
            System.out.println("Error la id introducida no coincide con ningun producto");
        }
        else{
            producto.increaseQuantity(amount);
            System.out.println("Se a introduccido la cantidad asignada de ese producto al stock");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product productoId = null;
        int cont = 0;
        while (stock.size() > cont && productoId == null){
            if (stock.get(cont).getID() == id){
                productoId = stock.get(cont);
            }
            cont++;
        }
        return productoId;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int cantidad = 0;
        Product producto = findProduct(id); 
        if (producto != null) {
            cantidad = producto.getQuantity();
        }
        return cantidad;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for(Product producto : stock){
            //La clase producto al contener el método toString no es necesario hacer referencia a este para
            //imprimir los productos (Java lo hace por defecto)
            System.out.println(producto);
        }
    }

    /**
     * Método que imprime los detalles de todos los productos cuyo stock está por debajo de un determinado número
     */
    public void underGivenNumberInStock(int cantidad)
    {
        for(Product producto : stock){
            if (producto.getQuantity() < cantidad){
                System.out.println(producto);
            }
        }
    }
}
