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

import java.util.Properties;

import org.kaptcha.spring.boot.autoconfigure.properties.KaptchaProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;

/**
 * 
 * 
 * @author Sun
 * @since 2019年2月18日
 * @version
 * 
 */
@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties({ KaptchaProperties.class })
public class KaptchaAutoConfiguration {

  private final KaptchaProperties properties;

  public KaptchaAutoConfiguration(KaptchaProperties properties) {
    this.properties = properties;
  }

  @Bean
  @ConditionalOnMissingBean(Producer.class)
  public Producer producer() {
    StringUtils.isEmpty("");
    Properties props = new Properties();

    final KaptchaProperties.Border border = this.properties.getBorder();
    setProperty(props, Constants.KAPTCHA_BORDER, border.isDrawn() ? "yes" : "no");
    setProperty(props, Constants.KAPTCHA_BORDER_COLOR, border.getColor());
    setProperty(props, Constants.KAPTCHA_BORDER_THICKNESS, border.getThickness());

    final KaptchaProperties.Noise noise = this.properties.getNoise();
    setProperty(props, Constants.KAPTCHA_NOISE_IMPL, noise.getImpl());
    setProperty(props, Constants.KAPTCHA_NOISE_COLOR, noise.getColor());

    final KaptchaProperties.Obscurificator obscurificator = this.properties.getObscurificator();
    setProperty(props, Constants.KAPTCHA_OBSCURIFICATOR_IMPL, obscurificator.getImpl());

    final KaptchaProperties.Producer producer = this.properties.getProducer();
    setProperty(props, Constants.KAPTCHA_PRODUCER_IMPL, producer.getImpl());

    final KaptchaProperties.TextProducer textProducer = this.properties.getTextProducer();
    setProperty(props, Constants.KAPTCHA_TEXTPRODUCER_IMPL, textProducer.getImpl());
    setProperty(props, Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, textProducer.getChar().getString());
    setProperty(props, Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, textProducer.getChar().getLength());
    setProperty(props, Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, textProducer.getChar().getSpace());
    setProperty(props, Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, textProducer.getFont().getNames());
    setProperty(props, Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, textProducer.getFont().getColor());
    setProperty(props, Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, textProducer.getFont().getSize());

    final KaptchaProperties.Word word = this.properties.getWord();
    setProperty(props, Constants.KAPTCHA_WORDRENDERER_IMPL, word.getImpl());

    final KaptchaProperties.Background background = this.properties.getBackground();
    setProperty(props, Constants.KAPTCHA_BACKGROUND_IMPL, background.getImpl());
    setProperty(props, Constants.KAPTCHA_BACKGROUND_CLR_FROM, background.getClear().getFrom());
    setProperty(props, Constants.KAPTCHA_BACKGROUND_CLR_TO, background.getClear().getTo());

    final KaptchaProperties.Image image = this.properties.getImage();
    setProperty(props, Constants.KAPTCHA_IMAGE_WIDTH, image.getWidth());
    setProperty(props, Constants.KAPTCHA_IMAGE_HEIGHT, image.getHeight());

    Config config = new Config(props);
    return config.getProducerImpl();
  }

  void setProperty(Properties properties, String key, String value) {
    if (value == null || "".equals(value)) {
      return;
    }
    properties.setProperty(key, value);
  }

  void setProperty(Properties properties, String key, int value) {
    if (value <= 0) {
      return;
    }
    properties.setProperty(key, String.valueOf(value));
  }

  void setProperty(Properties properties, String key, String[] value) {
    if (value == null || value.length == 0) {
      return;
    }
    properties.setProperty(key, String.join(",", value));
  }

}
