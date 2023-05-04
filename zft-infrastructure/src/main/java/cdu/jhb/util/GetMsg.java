package cdu.jhb.util;

import cdu.jhb.common.Constant;
import redis.clients.jedis.Jedis;
import sun.awt.image.PixelConverter;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
* @description: 获取验证码工具类
* @author jhb
* @date 2023/3/1 13:22
* @version 1.0
*/
public class GetMsg {

    /**
     * 生成验证码，并将验证码存入session中，以ip为key
     * @return
     */
    public static BufferedImage getMsg(){
        int width = 60 , height = 30;
        //创建一个图像，宽60 高30
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(Color.white);
        g.fillRect(0,0,width,height);
        g.setFont(new Font(Constant.FONT_TIMES_NEW_ROMAN,Font.PLAIN,18));
        g.setColor(new Color(12,102,255));
        //干扰线生成
        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x,y,x+xl,y+yl);
        }
        String strCode = "";
        String charStr = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 4; i++) {
            String str = String.valueOf(charStr.charAt(random.nextInt(charStr.length())));
            strCode = strCode + str;
            //设置字体颜色
            g.drawString(str,13*i+6,20);
        }
        // 开启redis缓存
        Jedis jedis = new Jedis();
        // 存入redis中
        jedis.set(Constant.VALID_CODE,strCode);
        g.dispose();
        return image;
    }

    /**
     * 随机获取颜色的方法
     * @return
     */
    public static Color getRandomColor (int fc , int bc){
        Random random = new Random();
        Color reandomColor = null;
        if(fc > 255){
            fc = 255;
        }
        if(bc > 255){
            bc = 255;
        }
        int r =fc + random.nextInt(bc-fc);
        int g = fc + random.nextInt(bc-fc);
        int b = fc + random.nextInt(bc-fc);
        reandomColor = new Color(r,g,b);
        return reandomColor;
    }

}
