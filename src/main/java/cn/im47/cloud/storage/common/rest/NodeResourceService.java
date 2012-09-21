package cn.im47.cloud.storage.common.rest;

import cn.im47.cloud.storage.common.entity.node.Node;
import cn.im47.cloud.storage.common.service.node.NodeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 存储结点控制器
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-7-16
 * Time: 下午10:54
 */
@Controller
@RequestMapping(value = "/api/node")
public class NodeResourceService {

    @Autowired
    private NodeManager nodeManager;

    private static final String APP_KEY = "";

    /**
     * 获得所有节点,ajax
     *
     * @return
     */
    @RequestMapping(value = "getTree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Node> getTree() {
        return nodeManager.getTree(APP_KEY);
    }

    /**
     * 获得编号为id 的分类, ajax返回
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Node get(@PathVariable("id") Long id) {
        return nodeManager.get(APP_KEY, id);
    }

    /**
     * 获得分类编号为id 的所有分类， ajax返回
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getChildren/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Node> getChildren(@PathVariable("id") Long id) {
        return nodeManager.getChildren(APP_KEY, id);
    }

}
