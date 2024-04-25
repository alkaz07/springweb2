package alkaz.springweb2.controllers;

import alkaz.springweb2.entities.Product;
import alkaz.springweb2.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller     //аннотация указывает Спрингу, что данный класс является контроллером, то есть его единственный
//экземпляр обрабаиывает какие-то http-запросы, то есть в нем будут методы с @GetMapping или @PostMapping
//если не сделать эту аннотацию, то и соответсвия адресам веб-страницы не найдется - и все сломается
public class ProductController {
    @Autowired      // автосвязывание текущего бина (productController) с бином productsService, который должен быть в контексте
                    // спрингового приложения
    ProductsService productsService;

    @GetMapping("/catalog") //привязка метода к обработке GET-запроса /catalog
    public String showCatalog(Model model){
        //System.out.println(productsService);      //проверили, что productService есть и даже проинициализирована
        ArrayList<Product> spisok = productsService.getAllList();
        model.addAttribute("spisok_productov", spisok);
        return "catalog";                           //передаем шаблон, который уже будет работать с model
    }
}
