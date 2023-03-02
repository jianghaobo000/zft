package cdu.jhb.util;

import redis.clients.jedis.Jedis;

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
     * @param request
     * @return
     */
    public static BufferedImage getMsg(HttpServletRequest request){
        int width = 60 , height = 30;
        //创建一个图像，宽60 高30
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandomColor(200,250));
        g.fillRect(0,0,width,height);
        g.setFont(new Font("Times New Roman",Font.PLAIN,18));
        g.setColor(getRandomColor(160,200));
        //干扰线生成
        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x,y,x+xl,y+yl);
        }
        String strCode = "";
        for (int i = 0; i < 4; i++) {
            String strNumber = String.valueOf(random.nextInt(10));
            strCode = strCode+strNumber;
            //设置字体颜色
            g.drawString(strNumber,13*i+6,20);
        }
        System.out.println("当前验证码"+strCode);
        request.getSession().setAttribute("strCode",strCode);
        // 开启redis缓存
        Jedis jedis = new Jedis("127.0.0.1",6379);
        // 存入redis中
        jedis.set("code",strCode);
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
