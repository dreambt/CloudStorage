package cn.im47.cloud.storage.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 通用控制器
 * User: baitao.jibt@gmail.com
 * Date: 12-5-20
 * Time: 下午16:50
 */
@Controller
public class GeneralController {

    /**
     * 首页显示菜单，静态+
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/{path}", method = RequestMethod.GET)
    public String index(@PathVariable("path") String path) {
        return path + "/index";
    }

}
