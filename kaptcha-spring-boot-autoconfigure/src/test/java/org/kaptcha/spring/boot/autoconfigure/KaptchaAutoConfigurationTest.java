/*******************************************************************************
 *
 * 
 *
 * Copyright (C) 2011-2019 by Sun : http://www.kingbase.com.cn
 *
 *******************************************************************************
 *
 *
 *    Email : snj1314@163.com
 *
 *
 ******************************************************************************/

package org.kaptcha.spring.boot.autoconfigure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 
 * 
 * @author Sun
 * @since 2019年11月7日
 * @version
 * 
 */
public class KaptchaAutoConfigurationTest {

  private AnnotationConfigApplicationContext context;

  @BeforeEach
  public void init() {
    this.context = new AnnotationConfigApplicationContext();
  }

  @AfterEach
  public void closeContext() {
    if (this.context != null) {
      this.context.close();
    }
  }

}
