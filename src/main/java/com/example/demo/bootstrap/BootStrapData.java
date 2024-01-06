package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        // adding sample products
        if(productRepository.count() == 0) {
            Product prod1 = new Product("Basic PC", 400, 20);
            Product prod2 = new Product("CPU + Mobo Combo", 100, 30);
            Product prod3 = new Product("CPU + RAM Combo", 150, 10);
            Product prod4 = new Product("CPU + GPU Combo", 600, 5);
            Product prod5 = new Product("Gaming PC", 1000, 17);
            productRepository.save(prod1);
            productRepository.save(prod2);
            productRepository.save(prod3);
            productRepository.save(prod4);
            productRepository.save(prod5);
        }

        // adding sample parts
        if(partRepository.count() == 0) {
            InhousePart part1 = new InhousePart();
            InhousePart part2 = new InhousePart();
            InhousePart part3 = new InhousePart();
            InhousePart part4 = new InhousePart();
            OutsourcedPart part5 = new OutsourcedPart();

            part1.setName("CPU");
            part1.setPrice(100);
            part1.setInv(60);
            part1.setMinInv(5);
            part1.setMaxInv(200);

            part2.setName("Motherboard");
            part2.setPrice(200);
            part2.setInv(50);
            part2.setMinInv(5);
            part2.setMaxInv(200);

            part3.setName("PSU");
            part3.setPrice(70);
            part3.setInv(50);
            part3.setMinInv(5);
            part3.setMaxInv(200);

            part4.setName("RAM");
            part4.setPrice(100);
            part4.setInv(100);
            part4.setMinInv(5);
            part4.setMaxInv(200);

            part5.setName("GPU");
            part5.setPrice(500);
            part5.setInv(26);
            part5.setCompanyName("Nvidia");
            part5.setMinInv(0);
            part5.setMaxInv(70);

            partRepository.save(part1);
            partRepository.save(part2);
            partRepository.save(part3);
            partRepository.save(part4);
            partRepository.save(part5);
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
