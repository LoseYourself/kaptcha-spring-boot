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

package org.kaptcha.spring.boot.autoconfigure.properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.kaptcha.spring.boot.autoconfigure.properties.KaptchaProperties;

/**
 * 
 * 
 * @author Sun
 * @since 2019年11月7日
 * @version
 * 
 */
public class KaptchaPropertiesTest {

  @Test
  public void testBorder() {
    KaptchaProperties properties = new KaptchaProperties();

    assertEquals(true, properties.getBorder().isDrawn());
  }
}
