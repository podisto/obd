package com.simba.obd.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by podisto on 27/08/2021.
 */
@Controller
@RequestMapping
public class DashboardController {

    @GetMapping("/admin")
    public String display() {
        return "admin/dashboard";
    }
}
