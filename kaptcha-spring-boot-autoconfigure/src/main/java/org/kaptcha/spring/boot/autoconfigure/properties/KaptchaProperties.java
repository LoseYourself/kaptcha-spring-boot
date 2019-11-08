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

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * 
 * @author Sun
 * @since 2019年2月18日
 * @version
 * 
 */
@ConfigurationProperties(prefix = "kaptcha"/* "spring.kaptcha" */)
public class KaptchaProperties {

  /**
   * 
   */
  private Border border = new Border();

  private Noise noise = new Noise();

  private Obscurificator obscurificator = new Obscurificator();

  private Producer producer = new Producer();

  private TextProducer textProducer = new TextProducer();

  private Word word = new Word();

  private Background background = new Background();

  private Image image = new Image();

  public Border getBorder() {
    return border;
  }

  public void setBorder(Border border) {
    this.border = border;
  }

  public Noise getNoise() {
    return noise;
  }

  public void setNoise(Noise noise) {
    this.noise = noise;
  }

  public Obscurificator getObscurificator() {
    return obscurificator;
  }

  public void setObscurificator(Obscurificator obscurificator) {
    this.obscurificator = obscurificator;
  }

  public Producer getProducer() {
    return producer;
  }

  public void setProducer(Producer producer) {
    this.producer = producer;
  }

  public TextProducer getTextProducer() {
    return textProducer;
  }

  public void setTextProducer(TextProducer textProducer) {
    this.textProducer = textProducer;
  }

  public Word getWord() {
    return word;
  }

  public void setWord(Word word) {
    this.word = word;
  }

  public Background getBackground() {
    return background;
  }

  public void setBackground(Background background) {
    this.background = background;
  }

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
    this.image = image;
  }

  public static class Border {

    private boolean drawn = true;
    private String color;
    private int thickness;

    public boolean isDrawn() {
      return drawn;
    }

    public void setDrawn(boolean drawn) {
      this.drawn = drawn;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public int getThickness() {
      return thickness;
    }

    public void setThickness(int thickness) {
      this.thickness = thickness;
    }

  }

  public static class Noise {

    private String impl;
    private String color;

    public String getImpl() {
      return impl;
    }

    public void setImpl(String impl) {
      this.impl = impl;
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

  }

  public static class Obscurificator {

    private String impl;

    public String getImpl() {
      return impl;
    }

    public void setImpl(String impl) {
      this.impl = impl;
    }

  }

  public static class Producer {

    private String impl;

    public String getImpl() {
      return impl;
    }

    public void setImpl(String impl) {
      this.impl = impl;
    }

  }

  public static class TextProducer {

    private String impl;

    private Char character = new Char();

    private Font font = new Font();

    public String getImpl() {
      return impl;
    }

    public void setImpl(String impl) {
      this.impl = impl;
    }

    public Char getChar() {
      return character;
    }

    public void setChar(Char _char) {
      this.character = _char;
    }

    public Font getFont() {
      return font;
    }

    public void setFont(Font font) {
      this.font = font;
    }

    public static class Char {

      private String string;
      private int length;
      private int space;

      public String getString() {
        return string;
      }

      public void setString(String string) {
        this.string = string;
      }

      public int getLength() {
        return length;
      }

      public void setLength(int length) {
        this.length = length;
      }

      public int getSpace() {
        return space;
      }

      public void setSpace(int space) {
        this.space = space;
      }

    }

    public static class Font {

      private String[] names;
      private String color;
      private int size;

      public String[] getNames() {
        return names;
      }

      public void setNames(String[] names) {
        this.names = names;
      }

      public String getColor() {
        return color;
      }

      public void setColor(String color) {
        this.color = color;
      }

      public int getSize() {
        return size;
      }

      public void setSize(int size) {
        this.size = size;
      }

    }
  }

  public static class Word {

    private String impl;

    public String getImpl() {
      return impl;
    }

    public void setImpl(String impl) {
      this.impl = impl;
    }

  }

  public static class Background {

    private String impl;

    private Clear clear = new Clear();

    public String getImpl() {
      return impl;
    }

    public void setImpl(String impl) {
      this.impl = impl;
    }

    public Clear getClear() {
      return clear;
    }

    public void setClear(Clear clear) {
      this.clear = clear;
    }

    public static class Clear {

      private String from;
      private String to;

      public String getFrom() {
        return from;
      }

      public void setFrom(String from) {
        this.from = from;
      }

      public String getTo() {
        return to;
      }

      public void setTo(String to) {
        this.to = to;
      }

    }

  }

  public static class Image {

    private int width;
    private int height;

    public int getWidth() {
      return width;
    }

    public void setWidth(int width) {
      this.width = width;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }

  }

}
