package cn.im47.cloud.storage.ftp;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.NodeManager;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import cn.im47.cloud.storage.utilities.file.FileHandler;
import org.apache.commons.net.ntp.TimeStamp;
import org.apache.ftpserver.ftplet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * ftp 文件事件通知类
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-8-19
 * Time: 上午9:00
 */
public class FileFtplet extends DefaultFtplet {

    private static final Logger logger = LoggerFactory.getLogger(DefaultFtplet.class);

    private static final String FILE_PATH = "D:/";

    private static final String JAVA_PATH = "D:/sources/CloudStorage/";

    private static final String APP_KEY = "";

    @Autowired
    private UploadedFileManager uploadedFileManager;

    @Autowired
    private NodeManager nodeManager;

    /**
     * TODO 用户建立连接时调用，可用于记录系统当前登录人数
     *
     * @param session
     * @return
     * @throws FtpException
     * @throws IOException
     */
    @Override
    public FtpletResult onConnect(FtpSession session) throws FtpException,
            IOException {
        return null;
    }

    /**
     * TODO 用户断开连接时调用，可用于记录系统当前登录人数
     *
     * @param session
     * @return
     * @throws FtpException
     * @throws IOException
     */
    @Override
    public FtpletResult onDisconnect(FtpSession session) throws FtpException,
            IOException {
        return null;
    }

    /**
     * TODO 文件上传结束时调用，将上传文件保存到云端，同时在数据库记录相关信息
     *
     * @param session
     * @param request
     * @return
     * @throws FtpException
     * @throws IOException
     */
    @Override
    public FtpletResult onUploadEnd(FtpSession session, FtpRequest request)
            throws FtpException, IOException {
        /* 上传文件信息 */
        String realName = request.getArgument();
        String suffix = realName.substring(realName.lastIndexOf(".") + 1, realName.length());

        /* 当前用户信息 */
        User user = session.getUser();

        /* 对文件md5 */
        File fromFile = new File(JAVA_PATH + realName);
        int fileSize = ((Long)fromFile.length()).intValue();
        String md5 = FileHandler.MD5(fromFile);
        String timeStamp = new TimeStamp(new Date()).toString();
        int length = timeStamp.length();
        timeStamp = timeStamp.substring(length - 8, length);
        String fileKey = md5 + timeStamp;
        String crc32 = FileHandler.CRC32(fromFile);

        /* 复制文件 */
        FileHandler.moveFile(fromFile, new File(FILE_PATH + fileKey + "." + suffix));

        /*入数据库*/
        UploadedFile uploadedFile = new UploadedFile();
        // TODO 前台获得数据
        uploadedFile.setNode(nodeManager.get(APP_KEY, 2L));     //TODO 节点
        uploadedFile.setFileKey(fileKey + "." + suffix);
        uploadedFile.setCustomName(realName);   //TODO 自定义名称
        uploadedFile.setRealName(realName);
        uploadedFile.setSize(fileSize);               //单位为B
        uploadedFile.setMd5(md5);
        uploadedFile.setCRC(crc32);
        uploadedFile.setShared(false);
        uploadedFile.setStatus(true);
        uploadedFile.setDeleted(false);
        uploadedFileManager.save(APP_KEY, uploadedFile);

        return null;
    }

    /**
     * TODO 文件下载开始下载时调用，可用于记录文件下载次数
     *
     * @param session
     * @param request
     * @return
     * @throws FtpException
     * @throws IOException
     */
    @Override
    public FtpletResult onDownloadStart(FtpSession session, FtpRequest request)
            throws FtpException, IOException {
        return null;
    }


}
