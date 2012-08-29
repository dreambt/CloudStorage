package cn.im47.cloud.storage.common.web.file;

import cn.im47.cloud.storage.common.entity.file.Nodes;
import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.NodesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 存储结点控制器
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午10:54
 */
@Controller
@RequestMapping(value = "/nodes")
public class NodesController {

    private NodesManager nodesManager;

    private static final String APP_KEY = "";

    /**
     * 获得编号为id 的分类, ajax返回
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Nodes get(@PathVariable("id") Long id) {
        return nodesManager.get(APP_KEY, id);
    }

    /**
     * 获得分类编号为id 的所有分类， ajax返回
     * @param id
     * @return
     */
    @RequestMapping(value = "/getChildren/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Nodes> getChildren(@PathVariable("id") Long id) {
        return nodesManager.getChildren(APP_KEY, id);
    }

    /**
     * 跳转到添加分类页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("nodes", new Nodes());
        return "nodes/edit";
    }

    /**
     * 保存分类信息
     *
     * @param model
     * @param nodes
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(Model model, Nodes nodes) {

        if(nodesManager.save(APP_KEY, nodes) > 0) {
            model.addAttribute("info", "添加分类成功");
        } else {
            model.addAttribute("error", "添加分类失败");
        }
        return "redirect:/nodes/getChildren";
    }

    /**
     * 删除分类
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(Model model, @PathVariable("id") Long id) {
        if(nodesManager.delete(APP_KEY, id) > 0) {
            model.addAttribute("info", "删除文件成功");
        } else {
            model.addAttribute("error", "删除文件失败");
        }
        return "nodes/getChildren";
    }

    @Autowired
    public void setNodesManager(NodesManager nodesManager) {
        this.nodesManager = nodesManager;
    }

}
