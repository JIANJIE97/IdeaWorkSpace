package fun.jianjie.miniorder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MiniOrderProductApplication {
    public static void main(String[] args) {
        System.out.println("测试idea进行push代码");
        SpringApplication.run(MiniOrderProductApplication.class,args);
    }
}
