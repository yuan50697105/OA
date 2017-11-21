package com.web.oa.controller;

import com.web.oa.commons.WebCommons;
import com.web.oa.utils.AuthCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class AuthCodeController {
    @RequestMapping("getAuthCode")
    public void getAuthCode(HttpSession session, HttpServletResponse response) {
        String code = AuthCodeUtils.getCode();
        session.setAttribute(WebCommons.AUTH_CODE, code);
        try {
            ImageIO.write(AuthCodeUtils.getCodeImg(code), "JPEF", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
