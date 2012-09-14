package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.Node;
import cn.im47.cloud.storage.common.service.file.NodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-7-18
 * Time: 下午8:57
 */
@Controller
@RequestMapping(value = "/node")
public class NodeDetailController {

    @Autowired
    private NodeManager nodeManager;

    private static final String APP_KEY = "";

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String save(@ModelAttribute("node") Node node, RedirectAttributes redirectAttributes) {
        if (null == node) {
            redirectAttributes.addFlashAttribute("info", "该分类不存在，请刷新重试");
            return "redirect:/file/userinfo";
        }

        nodeManager.update(APP_KEY, node);
        redirectAttributes.addFlashAttribute("info", "修改分类成功");
        return "redirect:/node/list";
    }

    @ModelAttribute("node")
    public Node getAccount(@RequestParam("id") Long id) {
        return nodeManager.get(APP_KEY, id);
    }

}
