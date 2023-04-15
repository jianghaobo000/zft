package cdu.jhb.account.service;

import cdu.jhb.account.api.AccountServiceI;
import cdu.jhb.account.command.AccountModExe;
import cdu.jhb.account.command.AccountQryExe;
import cdu.jhb.account.dto.data.AccountDTO;
import cdu.jhb.domain.account.Account;
import cdu.jhb.util.Convert;
import cdu.jhb.util.GetMsg;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
* @description: TODO
* @author jhb
* @date 2023/2/28 13:02
* @version 1.0
*/
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountServiceI {

    private final AccountModExe accountModExe;

    private final AccountQryExe accountQryExe;

    /**
     * 获取验证码图片
     * @param response
     * @return
     */
    @Override
    public void getMsg(HttpServletResponse response) {
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","No-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        BufferedImage image= GetMsg.getMsg();
        try {
            ImageIO.write(image,"JPEG",response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 验证登录信息正确性
     * @return
     */
    @Override
    public Boolean verification(String name,String password,String code,String countryCode) throws Exception {
        if(accountQryExe.findCountryCode(countryCode)) {
            return accountQryExe.findAccountByName(name,password,code,countryCode);
        }
        return false;
    }

    /**
     * 获取账户列表
     * @return
     */
    @Override
    public List<AccountDTO> getAccountList() {
        return accountQryExe.getAccountList();
    }
}
