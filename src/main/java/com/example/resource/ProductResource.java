package com.example.resource;

import com.example.model.Product;
import com.example.repository.SolrProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

    @Autowired
    private SolrProductRepository solrProductRepository;

    @GetMapping
    public List<Product> all() {
        List<Product> products = new ArrayList<>();
        solrProductRepository.findAll().forEach(product -> products.add(product) );
        return products;
    }

    @GetMapping(path = "{name}")
    public List<Product> getByName(@PathVariable("name") String name) {
        return solrProductRepository.findByName(name);
    }

    @GetMapping(path = "findByCustomQuery/{name}")
    public Page<Product> findByCustomQuery(@PathVariable("name") String name,
                                   @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                   @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        return solrProductRepository.findByCustomQuery(name, PageRequest.of(offset, limit));
    }

    @GetMapping(path = "findByNamedQuery/{name}")
    public Page<Product> findByNamedQuery(@PathVariable("name") String name,
                                   @RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                   @RequestParam(value = "limit", defaultValue = "5") Integer limit) {
        return solrProductRepository.findByNamedQuery(name, PageRequest.of(offset, limit));
    }

    @PostConstruct
    public void productInitUpload() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("P001", "Samsung Galaxy S20"));
        products.add(new Product("P002", "Samsung Galaxy Note"));
        products.add(new Product("P003", "Samsung Galaxy M30S"));
        products.add(new Product("P004", "Apple iPhone 11"));
        products.add(new Product("P005", "Samsung Galaxy S20+ 5G"));
        products.add(new Product("P006", "Samsung Galaxy S10 Dual SIM 128GB 8GB RAM 4G LTE (UAE Version) - Prism Blue"));
        products.add(new Product("P007", "Huawei P30 Smartphone, Dual SIM, 128GB, 8GB RAM - Breathing Crystal"));
        products.add(new Product("P008", "Xtouch X Slider Dual sim 32MB (Yellow)"));
        products.add(new Product("P009", "OnePlus 7T Pro - 256GB, 8GB RAM, 4G LTE - Haze Blue (blue)"));
        products.add(new Product("P010", "Xiaomi Redmi 8 Smartphone, Dual SIM, 4GB RAM, 64GB, LTE - Sapphire Blue"));
        products.add(new Product("P011", "Samsung Galaxy S20"));
        products.add(new Product("P012", "Samsung Galaxy S20"));
        products.add(new Product("P013", "Samsung Galaxy Note"));
        products.add(new Product("P014", "Samsung Galaxy M30S"));
        products.add(new Product("P015", "Apple iPhone 11"));
        products.add(new Product("P016", "Samsung Galaxy S20+ 5G"));
        products.add(new Product("P017", "Samsung Galaxy S10 Dual SIM 128GB 8GB RAM 4G LTE (UAE Version) - Prism Blue"));
        products.add(new Product("P018", "Huawei P30 Smartphone, Dual SIM, 128GB, 8GB RAM - Breathing Crystal"));
        products.add(new Product("P019", "Xtouch X Slider Dual sim 32MB (Yellow)"));
        products.add(new Product("P020", "OnePlus 7T Pro - 256GB, 8GB RAM, 4G LTE - Haze Blue (blue)"));
        products.add(new Product("P021", "Xiaomi Redmi 8 Smartphone, Dual SIM, 4GB RAM, 64GB, LTE - Sapphire Blue"));
        products.add(new Product("P022", "Samsung Galaxy S20"));
        products.add(new Product("P023", "Samsung Galaxy S20"));
        products.add(new Product("P024", "Samsung Galaxy Note"));
        products.add(new Product("P025", "Samsung Galaxy M30S"));
        products.add(new Product("P026", "Apple iPhone 11"));
        products.add(new Product("P027", "Samsung Galaxy S20+ 5G"));
        products.add(new Product("P028", "Samsung Galaxy S10 Dual SIM 128GB 8GB RAM 4G LTE (UAE Version) - Prism Blue"));
        products.add(new Product("P029", "Huawei P30 Smartphone, Dual SIM, 128GB, 8GB RAM - Breathing Crystal"));
        products.add(new Product("P030", "Xtouch X Slider Dual sim 32MB (Yellow)"));
        products.add(new Product("P031", "OnePlus 7T Pro - 256GB, 8GB RAM, 4G LTE - Haze Blue (blue)"));
        products.add(new Product("P032", "Xiaomi Redmi 8 Smartphone, Dual SIM, 4GB RAM, 64GB, LTE - Sapphire Blue"));
        products.add(new Product("P033", "Samsung Galaxy S20"));
        solrProductRepository.saveAll(products);
    }

}
