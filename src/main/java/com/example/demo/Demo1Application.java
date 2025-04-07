package com.example.demo;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Demo1Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // productRepository.save(new Product(null,"Computer",4300,4));
      //  productRepository.save(new Product(null,"Printer",5000,2));
      //      productRepository.save(new Product(null,"Phone",2000,10));
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("*******************");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p->{
            System.out.println(p);
        });

        System.out.println("---------------------3000---------------");
        List<Product> productList1 = productRepository.findByPrice(3000);
        productList1.forEach(p->{
            System.out.println(p);
        });

        System.out.println("--------C---------");
        List<Product> productList2 = productRepository.search("%C%");
        productList2.forEach(p->{
            System.out.println(p);
        });

        System.out.println("-------300----------");
        List<Product> productList4 = productRepository.searchByPrice(300);
        productList4.forEach(p->{
            System.out.println(p);
        });

    }
}
