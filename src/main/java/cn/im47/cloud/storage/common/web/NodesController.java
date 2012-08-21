package cn.im47.cloud.storage.common.web;

import cn.im47.cloud.storage.common.service.file.NodesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {

        return "";
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public String put() {

        return "";
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public String del() {

        return "";
    }

    @Autowired
    public void setNodesManager(NodesManager nodesManager) {
        this.nodesManager = nodesManager;
    }

}
