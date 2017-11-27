package com.web.oa.controller;

import com.web.oa.bean.Contracts;
import com.web.oa.bean.User;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.ContractsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/contracts")
public class ContractsController {
    @Autowired
    private ContractsService contractsService;

    @RequestMapping("/getContractsList")
    public String getContractsList(String contractsName, HttpSession session) {
        User user = (User) session.getAttribute(WebCommons.USER);
        List<Contracts> contractsList = contractsService.getContractsList(contractsName, user.getUserId());
        return "work/contacts";
    }

    @RequestMapping("/getContracts")
    public String getContracts(Long contractsId, Model model) {
        Contracts contracts = contractsService.getContracts(contractsId);
        model.addAttribute("contracts", contracts);
        return "work/contractsEdit";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "work/addContacts";
    }

    @RequestMapping("/ajaxAddContracts")
    @ResponseBody
    public boolean ajaxAddContracrts(Contracts contracts, HttpSession session) {
        User user = (User) session.getAttribute(WebCommons.USER);
        contracts.setUserId(user.getUserId());
        contracts.setOrgId(user.getOrgId());
        return contractsService.save(contracts);
    }

    @RequestMapping("/ajaxDeleteContracts")
    @ResponseBody
    public boolean delete(Long contractsId) {
        return contractsService.delete(contractsId);
    }

    @RequestMapping("/ajaxUpdateContracts")
    @ResponseBody
    public boolean update(Contracts contracts, HttpSession session) {
        User user = (User) session.getAttribute(WebCommons.USER);
        contracts.setUserId(user.getUserId());
        contracts.setOrgId(user.getOrgId());
        return contractsService.update(contracts);
    }
}
