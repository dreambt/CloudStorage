package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.account.User;
import cn.im47.cloud.storage.common.entity.file.Nodes;
import cn.im47.cloud.storage.common.service.account.UserManager;
import cn.im47.cloud.storage.common.service.account.impl.UserManagerImpl;
import cn.im47.cloud.storage.common.service.file.NodesManager;
import cn.im47.cloud.storage.common.web.account.GroupListEditor;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * 使用@ModelAttribute, 实现Struts2 Preparable二次绑定的效果。
 * 因为@ModelAttribute被默认执行, 而其他的action url中并没有${id}，所以需要独立出一个Controller.
 * <p/>
 * User: baitao.jibt (dreambt@gmail.com)
 * Date: 12-3-18
 * Time: 下午8:57
 */
@Controller
@RequestMapping(value = "/nodes")
public class NodesDetailController {

    private NodesManager nodesManager;

    private static final String APP_KEY = "";

    /**
     * 跳转到分类修改界面
     *
     * @param nodes
     * @param model
     * @return
     */
    @RequestMapping(value = "edit/{id}")
    public String updateForm(@ModelAttribute("nodes") Nodes nodes, Model model) {
        if (null == nodes) {
            model.addAttribute("info", "该分类不存在，请刷新重试");
            return "redirect:/file/list";
        }
        model.addAttribute("nodes", nodes);

        return "account/userForm";
    }

    /**
     * 修改分类信息
     *
     * @param nodes
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "save/{id}")
    public String save(@ModelAttribute("nodes") Nodes nodes, RedirectAttributes redirectAttributes) {
        if (null == nodes) {
        redirectAttributes.addFlashAttribute("info", "该分类不存在，请刷新重试");
        return "redirect:/file/userinfo";
    }

    nodesManager.update(APP_KEY, nodes);
    redirectAttributes.addFlashAttribute("info", "修改分类成功");
    return "redirect:/file/userinfo";
}

    @ModelAttribute("nodes")
    public Nodes getAccount(@PathVariable("id") Long id) {
        return nodesManager.get(APP_KEY, id);
    }

    @Autowired
    public void setNodesManager(NodesManager nodesManager) {
        this.nodesManager = nodesManager;
    }
}