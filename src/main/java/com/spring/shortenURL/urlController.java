package com.spring.shortenURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class urlController {

    private Map<String, String> map = new HashMap<>();

    @RequestMapping("/url")
    public String open() {
        return "/shortenURL";
    }


    @RequestMapping(value = "/url/originURL", method = RequestMethod.GET)
    public String getOriginURL(@RequestParam(name = "originURL") String originURL, Model model) {
        String keyValue = Base52ShortURL.generateShortURL(originURL);
        map.put(keyValue, originURL);

        String shortURL = "http://localhost:8080/url/" + keyValue;
        model.addAttribute("shortURL", shortURL);
        return "/shortenURL";
    }

    @RequestMapping(value = "/url/{keyValue}", method=RequestMethod.GET)
    public String redirectOriginURL(@PathVariable String keyValue) {
        System.out.println("keyValue : " + keyValue);
        String url = map.get(keyValue);
        System.out.println("url은 이거다 : " + url);

        if (url.contains("https://")) {
            return "redirect:" + url;
        } else {
            return "redirect:https://" + url;
        }
    }

}
