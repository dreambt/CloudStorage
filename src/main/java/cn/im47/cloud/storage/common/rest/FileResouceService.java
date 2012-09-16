package cn.im47.cloud.storage.common.rest;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文件资源的REST服务
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-8-9
 * Time: 下午7:16
 */
@Controller
@RequestMapping(value = "/api/file")
public class FileResouceService {

    @Autowired
    private UploadedFileManager fileManager;

    private static final String APP_KEY = "";

    /**
     * 获得分类编号为id 的所有文件
     *
     * @param id 结点id
     * @return
     */
    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UploadedFile> listByNode(@PathVariable("id") Long id,
                                         @RequestParam(value = "offset", defaultValue = "0") int offset,
                                         @RequestParam(value = "limit", defaultValue = "10") int limit) {
        return fileManager.getByNode(APP_KEY, id, offset, limit);
    }

    /**
     * 获得分类编号为id 的文件数量
     *
     * @param id 结点id
     * @return
     */
    @RequestMapping(value = "/count/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public long countByNode(@PathVariable("id") Long id) {
        return fileManager.countByNode(APP_KEY, id);
    }

}
