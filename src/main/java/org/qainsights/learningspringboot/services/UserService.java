package org.qainsights.learningspringboot.services;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.qainsights.learningspringboot.entities.Address;
import org.qainsights.learningspringboot.entities.Category;
import org.qainsights.learningspringboot.entities.Product;
import org.qainsights.learningspringboot.entities.User;
import org.qainsights.learningspringboot.repositories.AddressRepository;
import org.qainsights.learningspringboot.repositories.ProfileRepository;
import org.qainsights.learningspringboot.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {


    private final UserRepository userRepository;

    private final EntityManager entityManager;

    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void showEntityStates() {

        var user = User.builder()
                .name("nknkn")
                .email("teer")
                .password("terer")
                .build();

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient/Detached");


        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient/Detached");



    }

    @Transactional
    public void showRelatedEntities() {
        var user = profileRepository.findById(2L).orElseThrow();
        System.out.println(user.getUser().getEmail());
    }

    public void persistRelated() {
        var user = User.builder()
                .name("fdfd")
                .email("tesT")
                .password("fdfdd")
                .build();

        var address = Address.builder()
                .street("st")
                .state("oj")
                .zip("1234")
                .city("testville")
                .build();

        user.addAddress(address);

        userRepository.save(user);

    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(3L).orElseThrow();
        var addr = user.getAddresses().getFirst();
        user.removeAddress(addr);
        userRepository.save(user);
    }

    public void saveProductWithCategory() {

        var category = Category.builder()
                .name("category1")
                .build();

        var prod1 = Product.builder()
                .name("product1")
                .price(BigDecimal.valueOf(12.23))
                .description("desc")
                .category(category)
                .build();

        productRepository.save(prod1);

    }

    @Transactional
    public void createProductWithExistingCategory() {
        var cat = categoryRepository.findById((byte) 1).orElseThrow();


        var prod2 = Product.builder()
                .name("prod2")
                .price(BigDecimal.ONE)
                .description("desc")
                .category(cat)
                .build();

        productRepository.save(prod2);



    }

    @Transactional
    public void addProductsToWishList() {
        var user = userRepository.findById(3L).orElseThrow();
        var prods = productRepository.findAll();

        prods.forEach(user::addProducts);

    }


    public void deleteProduct() {

        productRepository.deleteById(4L);
    }

    @Transactional
    public void updateProductPrices() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(12), (byte) 1);
    }

    public void fetchProducts() {
        var products = productRepository.findByCategory(new Category((byte) 1));
        System.out.println(products);
    }

    public void fetchUser() {
        var user = userRepository.findByEmail("test1@test.com").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers() {
        var users = userRepository.findAllWithAddresses();

        users.forEach((u) -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });


    }

}
