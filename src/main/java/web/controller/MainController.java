package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("*")
public class MainController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public MainController() {
        logger.info("Main controller created.");
    }

    @ResponseBody
    @RequestMapping()
    public ModelAndView getIndex() {

        logger.info("Method getIndex()");
        return new ModelAndView("main/index");
    }
}
