package edu.csumb.cst438.productdb;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.csumb.cst438.productdb.repositores.IProductRepository;
import edu.csumb.cst438.productdb.model.Product;


@Component
public class ProductDbSeeder implements CommandLineRunner{
    @Autowired
    IProductRepository productRepo;

    @Override
    public void run(String... args) throws Exception {
        //String name, String description, String imageURL, Double  price, Integer stock
        Product ToolSet = new Product("Homeowner's Tool Set","Tools","All tools meet or exceed ANSI specs", "assets/img/Home_Tool_Kit.jpg", 48.49, 8);
        Product CircularSaw = new Product("Circular Saw","Tools","Cordless design provides optimal portability", "assets/img/Home_Tool_Kit.jpg", 69.00, 32);
        Product LawnMower = new Product("Push Mower","Outdoors" ,"6.75 ft. lb. gross torque 163cc Briggs & Stratton EXi OHV engine", "assets/img/Push_Lawn_Mower.jpg", 269.00, 64);
        Product HoseBibb = new Product("Hose Bibb","Plumbing", "Suitable for use in residential and commercial settings", "https://images.homedepot-static.com/productImages/b2a6d5b1-a31a-448e-bd81-bc066df83818/svn/everbilt-hose-bibbs-vhnstdb3eb-64_1000.jpg", 7.48, 44);
        Product PressLumber = new Product("Pressure-Treated Lumber", "Building Materials", "Lumber that's guaranteed to stand up to the elements for years", "https://images.homedepot-static.com/productImages/76f656c1-7cfb-4bf3-b5d3-b25ecd61d46c/svn/pressure-treated-lumber-342785-64_1000.jpg", 4.17, 544);
        Product PVCpipe = new Product("PVC Pipe in White", "Plumbing", "1/2 in. x 5 ft.", "https://images.homedepot-static.com/productImages/52330fd0-fb05-4d9c-90b8-7cab3355114e/svn/formufit-pvc-schedule-40-pipe-p012fgp-wh-5-64_1000.jpg", 4.21, 83);
        Product Compressor = new Product("Portable Air Compressor", "Tools", "Backed by the RIDGID 3-Year Warranty", "https://images.homedepot-static.com/productImages/a33af41d-a5fe-4725-be7d-d64da671ca95/svn/ridgid-portable-air-compressors-of45200ss-64_1000.jpg", 299.0, 14);
        Product GateSet = new Product("Post Latch Gate Set", "Building Materials", "Reversible pin allows for both right and left hand operation", "https://images.homedepot-static.com/productImages/d54503de-1509-4b9b-ac2c-8016db97fa56/svn/everbilt-fence-gate-latches-slide-bolts-18101-64_1000.jpg", 26.25, 54);
        Product ChainSaw = new Product("2-Stroke Cycle Chainsaw", "Outdoors", "Chainsaw vibration reduction system ensures smooth operation", "https://images.homedepot-static.com/productImages/8d769b88-cfee-4818-8e82-d531bb6821a0/svn/echo-gas-chainsaws-cs-355t-14-64_1000.jpg", 349.99, 3);
        Product PressureReg = new Product("Water Pressure Reducing Valve", "Plumbing", "Removable stainless steel strainer for easy cleaning", "https://images.homedepot-static.com/productImages/7502042d-5935-4ac3-82dd-ab5c90704b42/svn/watts-pressure-regulators-3-4-lf25aub-z3-64_1000.jpg", 95.98, 74);
        //delete db data
        productRepo.deleteAll();
        //add db seeds
        List<Product> productes = Arrays.asList(ToolSet, CircularSaw, LawnMower, HoseBibb,PressLumber,PVCpipe,Compressor, GateSet, ChainSaw, PressureReg);
        productRepo.saveAll(productes);
    }

}