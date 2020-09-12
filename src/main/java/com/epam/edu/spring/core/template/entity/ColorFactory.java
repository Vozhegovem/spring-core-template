package com.epam.edu.spring.core.template.entity;
import org.springframework.beans.factory.FactoryBean;
import java.util.Random;

public class ColorFactory implements FactoryBean<Color> {
    @Override
    public Color getObject() throws Exception {
        Color[] colors = Color.values();
        int colorNum = new Random().nextInt(colors.length);
        return  colors[colorNum];
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }
}
