package alkaz.springweb2.services;

import alkaz.springweb2.entities.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service    //аннотация, которая говорит Спрингу, что этот класс является "сервисом" - частным случаем "компонента"
            //благодаря этому аннотация @ComponentScan на уровне конфигурации приложения автоматически
            //создает бин, помещает его в контекст и выполняет инициализацию
public class ProductsService {
    ArrayList<Product> products= new ArrayList<>();

    @PostConstruct  //аннотация, которая говорит Спрингу, что данный метод нужно вызвать для иницализации
                    //после создания бина
    public void fill(){
        try {
            products.add(new Product(1, "Курка", 500));
            products.add(new Product(2, "Млеко", 300));
            products.add(new Product(3, "Яйки", 125.99));
        }catch (Exception e){
            System.out.println("что-то не так с созданием продуктов");
        }
    }

    public ArrayList<Product> getAllList() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public Product findByName(String s){
        for (Product p: products ) {
            if (p.getName().equals(s))
                return p;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ProductsService{" +
                "products=" + products +
                '}';
    }
}
