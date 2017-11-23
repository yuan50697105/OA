package com.web.oa.controller.work;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
import com.web.oa.bean.Contracts;
import com.web.oa.bean.User;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractsService contractsService;
    @RequestMapping("/getContractsMessage")
    public String getContracts(HttpSession session,Model model){
        User user= (User) session.getAttribute(WebCommons.USER);
        List<Contracts> contractsList=contractsService.getContractsByUserId(user.getUserId());
        return "work/contracts";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "work/addContracts";
    }
    public boolean add(Contracts contracts, HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        contracts.setUserId(user.getUserId());
        return contractsService.save(contracts);
    }

}
