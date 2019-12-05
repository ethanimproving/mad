package org.improving.mad.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppAPIController {

    @GetMapping("/")
    public String home() {
        return "json data";
    }
}
