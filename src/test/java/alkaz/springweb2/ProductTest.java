package alkaz.springweb2;


import alkaz.springweb2.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {  //необходимые тесты, чтоб быть уверенными в составных частях программы
    @Test
    public void testCreation(){
        Assertions.assertDoesNotThrow(()->new Product(100, "Вася", 125));
        Assertions.assertThrows(Exception.class, ()->new Product(200, "Гриша", -125));
    }
}
