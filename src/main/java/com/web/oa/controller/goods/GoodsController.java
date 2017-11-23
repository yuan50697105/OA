package com.web.oa.controller.goods;

import com.web.oa.bean.Goods;
import com.web.oa.bean.User;
import com.web.oa.commons.WebCommons;
import com.web.oa.service.GoodsService;
import javafx.beans.value.WeakChangeListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    public String getGoodsManage(Model model){
        List<Goods> goodsList=goodsService.getGoodsList();
        model.addAttribute("goodsList",goodsList);
        return "goods/goods";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "goods/addGoods";
    }
    @RequestMapping("/ajaxAdd")
    @ResponseBody
    public boolean add(Goods goods, HttpSession session){
        User user= (User) session.getAttribute(WebCommons.USER);
        goods.setOrgId(user.getOrgId());
        return goodsService.save(goods);
    }
}
