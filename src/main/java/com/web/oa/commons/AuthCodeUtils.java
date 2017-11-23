package com.web.oa.commons;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AuthCodeUtils {
    /**
     * 生成验证码字符串
     * @return 验证码
     */
    public static String getCode() {
        String string = "123456789QWERTYUIPASDFGHJKLZXCVBNM";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int a = random.nextInt(string.length());
            stringBuilder.append(string.charAt(a));
        }
        return stringBuilder.toString();
    }

    /**
     * 根据输入的字符串生成验证码图片
     * @param code 验证码字符串
     * @return 验证码图片
     */
    public static BufferedImage getCodeImg(String code) {
        BufferedImage bufferedImage = new BufferedImage(88, 28, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, 88, 28);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("宋体", Font.PLAIN, 24));
        for (int i = 0; i < code.length(); i++) {
            graphics.drawString(code.charAt(i) + "", i * 20, 20);
        }
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            int x1 = random.nextInt(88);
            int x2 = random.nextInt(88);
            int y1 = random.nextInt(28);
            int y2 = random.nextInt(28);
            graphics.drawLine(x1, y1, x2, y2);
        }
        return bufferedImage;
    }
}
