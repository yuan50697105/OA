package com.web.oa.controller;

import com.web.oa.commons.AuthCodeUtils;
import com.web.oa.commons.WebCommons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthCodeController {
    @RequestMapping("getAuthCode")
    public void getAuthCode(HttpSession session, HttpServletResponse response){
        String code= AuthCodeUtils.getCode();
        session.setAttribute(WebCommons.AUTH_CODE,code);
        try {
            ImageIO.write(AuthCodeUtils.getCodeImg(code),"JPEG",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("checkAuthCode")
    public Map checkAuthCode(String code,HttpSession session){
        String session_code = (String)session.getAttribute(WebCommons.AUTH_CODE);
        Map map = new HashMap();
        map.put("msg", "验证码正确");
        map.put("flag", 0);
        if(!StringUtils.isEmpty(code)){
            if(!code.equalsIgnoreCase(session_code)){
                map.put("msg", "验证码不正确");
                map.put("flag", 2);
            }
        }else{
            map.put("msg", "请输入验证码");
            map.put("flag", 1);
        }

        return map;
    }
}
