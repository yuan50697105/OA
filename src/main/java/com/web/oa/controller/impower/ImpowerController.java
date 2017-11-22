package com.web.oa.controller.impower;

import com.web.oa.service.ImpowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/impower")
public class ImpowerController {
    @Autowired
    private ImpowerService impowerService;
}
