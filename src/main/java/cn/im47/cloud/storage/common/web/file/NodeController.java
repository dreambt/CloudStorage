package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.Node;
import cn.im47.cloud.storage.common.entity.file.NodeTypeEnum;
import cn.im47.cloud.storage.common.service.file.NodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * 存储结点控制器
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午10:54
 */
@Controller
@RequestMapping(value = "/node")
public class NodeController {

    private NodeManager nodeManager;

    private static final String APP_KEY = "";

    /**
     * 获得所有节点
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("nodes", nodeManager.getTree(APP_KEY));
        model.addAttribute("node", new Node());
        model.addAttribute("types", NodeTypeEnum.values());
        return "node/list";
    }

    /**
     * /**
     * 跳转到添加分类页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "create")
    public String create(Model model) {
        model.addAttribute("node", new Node());
        return "node/edit";
    }

    /**
     * 保存分类信息
     *
     * @param model
     * @param node
     * @return
     */
    @RequestMapping(value = "save")
    public String save(Model model, Node node) {
        if (nodeManager.save(APP_KEY, node) > 0) {
            model.addAttribute("info", "添加分类成功");
        } else {
            model.addAttribute("error", "添加分类失败");
        }
        return "redirect:/node/list";
    }

    /**
     * 删除分类
     *
     * @param redirectAttributes
     * @param id
     * @return
     */
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Node node = null;
        if (null != nodeManager.get(APP_KEY, id)) {
            node = nodeManager.get(APP_KEY, id);
            node.setNodeList(nodeManager.getChildren(APP_KEY, id));
        } else {
            redirectAttributes.addFlashAttribute("error", "该节点不存在");
            return "redirect:/node/list";
        }
        if (null != node.getNodeList() && 0 != node.getNodeList().size()) {
            redirectAttributes.addFlashAttribute("error", "该节点有子节点，不能删除");
        } else {
            if (nodeManager.delete(APP_KEY, id) > 0) {
                redirectAttributes.addFlashAttribute("info", "删除文件成功");
            } else {
                redirectAttributes.addFlashAttribute("error", "删除文件失败");
            }
        }
        return "redirect:/node/list";
    }

    @RequestMapping(value = "isUsedNodeName", method = RequestMethod.GET)
    @ResponseBody
    public boolean isUsedNodeName(@RequestParam("parentId") Long parentId, @RequestParam("nodeName") String nodeName) {
        return nodeManager.isUsedNodeName(APP_KEY, parentId, nodeName);
    }

    @Autowired
    public void setNodeManager(NodeManager nodeManager) {
        this.nodeManager = nodeManager;
    }

}
