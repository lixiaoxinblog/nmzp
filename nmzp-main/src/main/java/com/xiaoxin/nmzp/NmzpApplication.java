package com.xiaoxin.nmzp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaoxin.nmzp","com.ruoyi"})
public class NmzpApplication {
    public static void main(String[] args) {
        SpringApplication.run(NmzpApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  牛马招聘启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "            _                            \n" +
                "  _ _      (_)    _  _    _ __    __ _   \n" +
                " | ' \\     | |   | +| |  | '  \\  / _` |  \n" +
                " |_||_|   _|_|_   \\_,_|  |_|_|_| \\__,_|  \n" +
                "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| \n" +
                "\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' \n ");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
