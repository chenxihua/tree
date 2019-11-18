package cn.lingshi.tree.controller;

import cn.lingshi.tree.respon.Result;
import cn.lingshi.tree.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DevTreeController
 * @Create By: chenxihua
 * @Date: 2019/11/15 11:40
 **/

@RestController
@RequestMapping(value = "/devtree")
public class DevTreeController {



    @Autowired
    DomainService domainService;


    @GetMapping(value = "/getAlls")
    public Result getAllDomainTree(){
        return domainService.getDomainTree();
    }



}
