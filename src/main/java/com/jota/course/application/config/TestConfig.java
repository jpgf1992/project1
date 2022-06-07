package com.jota.course.application.config;

import com.jota.course.application.entities.Category;
import com.jota.course.application.entities.Order;
import com.jota.course.application.entities.Usuario;
import com.jota.course.application.entities.enums.OrderStatus;
import com.jota.course.application.repositories.CategoryRepository;
import com.jota.course.application.repositories.OrderRepository;
import com.jota.course.application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userReposiory;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITTING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.PAID, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED,u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userReposiory.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll((Arrays.asList(o1,o2,o3)));
        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
    }
}
