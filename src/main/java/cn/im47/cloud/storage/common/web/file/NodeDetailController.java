package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.Node;
import cn.im47.cloud.storage.common.service.file.NodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 使用@ModelAttribute, 实现Struts2 Preparable二次绑定的效果。
 * 因为@ModelAttribute被默认执行, 而其他的action url中并没有${id}，所以需要独立出一个Controller.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-18
 * Time: 下午8:57
 */
@Controller
@RequestMapping(value = "/node")
public class NodeDetailController {

    private NodeManager nodeManager;

    private static final String APP_KEY = "";

    /**
     * 跳转到分类修改界面
     *
     * @param node
     * @param model
     * @return
     */
    @RequestMapping(value = "edit/{id}")
    public String updateForm(@ModelAttribute("node") Node node, Model model) {
        if (null == node) {
            model.addAttribute("info", "该分类不存在，请刷新重试");
            return "redirect:/file/list";
        }
        model.addAttribute("node", node);

        return "account/userForm";
    }

    /**
     * 修改分类信息
     *
     * @param node
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save/{id}")
    public String save(@ModelAttribute("node") Node node, RedirectAttributes redirectAttributes) {
        if (null == node) {
            redirectAttributes.addFlashAttribute("info", "该分类不存在，请刷新重试");
            return "redirect:/file/userinfo";
        }

        nodeManager.update(APP_KEY, node);
        redirectAttributes.addFlashAttribute("info", "修改分类成功");
        return "redirect:/file/userinfo";
    }

    @ModelAttribute("node")
    public Node getAccount(@PathVariable("id") Long id) {
        return nodeManager.get(APP_KEY, id);
    }

    @Autowired
    public void setNodeManager(NodeManager nodeManager) {
        this.nodeManager = nodeManager;
    }
}