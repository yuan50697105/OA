package com.web.oa.controller;

import com.web.oa.commons.WebCommons;
import com.web.oa.utils.AuthCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthCodeController {
    @RequestMapping("/getAuthCode")
    public void getAuthCode(HttpSession session, HttpServletResponse response) {
        String code = AuthCodeUtils.getCode();
        System.out.println(code);
        session.setAttribute(WebCommons.AUTH_CODE, code);
        try {
            ImageIO.write(AuthCodeUtils.getCodeImg(code), "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/checkAuthCode")
    @ResponseBody
    public Map<String, Object> getVerifyCode(String code, HttpSession session) {
        String sesssionCode = (String) session.getAttribute(WebCommons.AUTH_CODE);
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(code)) {
            map.put(WebCommons.AUTH_FLAG, 1);
            map.put(WebCommons.AUTH_MSG, "验证码不能为空");
        } else if (!code.equalsIgnoreCase(sesssionCode)) {
            map.put(WebCommons.AUTH_FLAG, 2);
            map.put(WebCommons.AUTH_MSG, "验证码错误，请重新输入");
        } else {
            map.put(WebCommons.AUTH_FLAG, 3);
        }
        return map;
    }
}
