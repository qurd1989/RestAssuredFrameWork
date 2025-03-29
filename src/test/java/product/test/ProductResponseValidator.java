package product.test;

import io.restassured.response.Response;
import org.junit.Assert;
import product.pojo.Product;
import product.utils.ResponseValidator;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductResponseValidator {
    private static final Logger logger = Logger.getLogger(ProductResponseValidator.class.getName());
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void validateResponse(Response response) {
        ResponseValidator.validateStatusCode(response, 200);
        logger.log(Level.INFO, ANSI_GREEN + "Status code validated successfully." + ANSI_RESET);

        Product product = response.as(Product.class);

        // Validate product ID
        Assert.assertEquals("Product ID is not as expected", 1, product.getId());
        logger.log(Level.INFO, ANSI_GREEN + "Product ID validated successfully." + ANSI_RESET);

        // Validate product title
        Assert.assertEquals("Product title is not as expected", "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops", product.getTitle());
        logger.log(Level.INFO, ANSI_GREEN + "Product title validated successfully." + ANSI_RESET);

        // Validate product price
        double price = product.getPrice();
        Assert.assertTrue("Product price is not within the expected range", price >= 1.0 && price <= 1000.0);
        logger.log(Level.INFO, ANSI_GREEN + "Product price validated successfully." + ANSI_RESET);

        // Validate product description
        Assert.assertEquals("Product description is not as expected", "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday", product.getDescription());
        logger.log(Level.INFO, ANSI_GREEN + "Product description validated successfully." + ANSI_RESET);

        // Validate product category
        Assert.assertEquals("Category is not as expected", "men's clothing", product.getCategory());
        logger.log(Level.INFO, ANSI_GREEN + "Product category validated successfully." + ANSI_RESET);

        // Validate product image
        Assert.assertEquals("Image URL is not as expected", "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg", product.getImage());
        logger.log(Level.INFO, ANSI_GREEN + "Product image URL validated successfully." + ANSI_RESET);

        // Validate product rating
        int ratingCount = product.getRating().getCount();
        Assert.assertEquals("Rating count is not as expected", ratingCount > 0 && ratingCount < 5 );
        logger.log(Level.INFO, ANSI_GREEN + "Product rating count validated successfully." + ANSI_RESET);

        Assert.assertEquals("Count is not as expected", 120, product.getRating().getCount());
        logger.log(Level.INFO, ANSI_GREEN + "Product rating count validated successfully." + ANSI_RESET);
    }
}