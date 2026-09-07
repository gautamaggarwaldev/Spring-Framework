package in.ggklass;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
// import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Lazy
@Scope("prototype")
public class CartService implements BeanNameAware, ApplicationContextAware /*DisposableBean*/ {

    Map<Integer,String> mp;

    CartService() {
        mp = new HashMap<>();
        System.out.println("cart service constructor called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context name is " + applicationContext);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is " + name);
    }

    
    @PostConstruct
    public void start() {
        System.out.println("Bean is ready");
        mp.put(1,"Garima");
        mp.put(2,"Gautam");
    }

    public void addCart() {
        System.out.println("Added in cart");
    }
    
    public String getValue(int key) {
        return mp.get(key);
    }

    @PreDestroy
    public void stop() {
        mp.clear();
        System.out.println("Bean is getting destroyed");
    }

    
    // @Override
    // public void destroy() throws Exception {
    //     mp.clear();
    //     System.out.println("Bean is getting destroyed");
    // }

    

}

// public class CartService {

//     Map<Integer,String> mp;

//     CartService() {
//         mp = new HashMap<>();
//         System.out.println("cart service constructor called");
//     }

//     public void addCart() {
//         System.out.println("Added in cart");
//     }

//     public void start() {
//         System.out.println("Bean is ready");
//         mp.put(1,"Garima");
//         mp.put(2,"Gautam");
//     }

//     public String getValue(int key) {
//         return mp.get(key);
//     }
// }

// @Component
// public class CartService implements InitializingBean {

//     Map<Integer,String> mp;

//     CartService() {
//         mp = new HashMap<>();
//         System.out.println("cart service constructor called");
//     }

//     public void addCart() {
//         System.out.println("Added in cart");
//     }

//     @Override
//     public void afterPropertiesSet() throws Exception {
//         System.out.println("Bean is ready");
//         mp.put(1,"Garima");
//         mp.put(2,"Gautam");
//     }

//     public String getValue(int key) {
//         return mp.get(key);
//     }
// }