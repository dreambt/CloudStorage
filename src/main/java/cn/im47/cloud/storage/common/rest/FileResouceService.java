package cn.im47.cloud.storage.common.rest;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 文件资源的REST服务
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-4-9
 * Time: 下午7:16
 */
@Controller
@RequestMapping(value = "/file")
public class FileResouceService {

    private UploadedFileManager fileManager;

    private static final Logger logger = LoggerFactory.getLogger(FileResouceService.class);

    /**
     * 根据编号id查询航班信息
     *
     * @param appKey
     * @param id
     */
    @RequestMapping(value = "/{appKey}/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    // @Produces({"application/x-javascript", MediaType.APPLICATION_JSON})
    public ResponseEntity<?> get(@PathVariable("appKey") String appKey, @PathVariable("id") Long id) {
        UploadedFile file = fileManager.get(appKey, id);
        if (file == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(file, HttpStatus.OK);
    }

    @Autowired
    public void setFileManager(@Qualifier("uploadedFileManagerImpl") UploadedFileManager fileManager) {
        this.fileManager = fileManager;
    }

}
