package cn.im47.cloud.storage.common.rest;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 文件资源的REST服务
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-4-9
 * Time: 下午7:16
 */
@Controller
@RequestMapping(value = "/api/file")
public class FileResouceService {

    @Autowired
    private UploadedFileManager fileManager;

    private static final String APP_KEY = "";

    /**
     * 获得分类编号为id 的所有文件， ajax返回
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getByNode/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<UploadedFile> getByNode(@PathVariable("id") Long id) {
        return fileManager.getByNode(APP_KEY, id);
    }

}
