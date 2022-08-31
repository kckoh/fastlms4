package com.zerobase.fastlms.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminBannerController {
    @GetMapping("/admin/banner/list.do")
    public String bannerList() {

        return "/admin/banner/list.html";
    }


    @GetMapping("/admin/banner/add.do")
    public String bannerAdd() {
        return "/admin/banner/add.html";
    }
}
