
package com.bangcle;

import com.bangcle.utils.ParaUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

  public static void main(String[] args) {
    log.info("start run application...");
    //当进行单元测试时，不走这个方法，所以用这个标志来识别当前是否正在单元测试
    ParaUtil.TESTING = false;
    SpringApplication.run(Application.class);
    log.info("Application is running!");
  }

}
