package com.ruoyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {"com.xiaoxin.nmzp","com.ruoyi"})
@MapperScan(basePackages = {"com.ruoyi.system.mapper","com.xiaoxin.nmzp.mapper"})
public class RuoYiApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  牛马招聘启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                "            _                            \n" +
                "  _ _      (_)    _  _    _ __    __ _   \n" +
                " | ' \\     | |   | +| |  | '  \\  / _` |  \n" +
                " |_||_|   _|_|_   \\_,_|  |_|_|_| \\__,_|  \n" +
                "_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"|_|\"\"\"\"\"| \n" +
                "\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-' \n ");
    }
}
