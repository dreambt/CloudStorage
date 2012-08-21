package cn.im47.cloud.storage.webservice;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.FileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springside.modules.mapper.BeanMapper;
import org.springside.modules.mapper.JsonMapper;
import org.springside.modules.memcached.SpyMemcachedClient;
import org.springside.modules.rest.RsResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * 单程航班资源的REST服务
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-4-9
 * Time: 下午7:16
 */
@Path("/file")
public class FileResouceService {

    private FileManager fileManager;

    private static final Logger logger = LoggerFactory.getLogger(FileResouceService.class);

    private static JsonMapper mapper = new JsonMapper();

    private SpyMemcachedClient spyMemcachedClient;

    @Context
    private UriInfo uriInfo;

    /**
     * 根据编号id查询航班信息
     *
     * @param appKey
     * @param id
     */
    @GET
    @Path("{id}")
    @Produces({"application/x-javascript", MediaType.APPLICATION_JSON})
    public String get(@QueryParam("callback") @DefaultValue("callback") String callback, @PathParam("app") String appKey, @PathParam("id") Long id) {
        try {
            UploadedFile file = fileManager.get(appKey, id);
            return mapper.toJsonP(callback, BeanMapper.map(file, UploadedFile.class));
        } catch (NullPointerException e) {
            String message = "航班信息不存在(id=" + id + ").";
            throw RsResponse.buildException(Response.Status.NOT_FOUND, message);
        } catch (RuntimeException e) {
            throw RsResponse.buildDefaultException(e);
        }
    }

    @Autowired
    public void setFileManager(@Qualifier("fileManagerImpl") FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Autowired
    public void setSpyMemcachedClient(SpyMemcachedClient spyMemcachedClient) {
        this.spyMemcachedClient = spyMemcachedClient;
    }

}
