package cn.im47.cloud.storage.ftp;

import cn.im47.cloud.storage.common.entity.file.UploadedFile;
import cn.im47.cloud.storage.common.service.file.UploadedFileManager;
import cn.im47.cloud.storage.utilities.file.FileHandler;
import org.apache.ftpserver.ftplet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

/**
 * ftp 文件事件通知类
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-8-19
 * Time: 上午9:00
 */
public class FileFtplet extends DefaultFtplet {

    private static final Logger logger = LoggerFactory.getLogger(DefaultFtplet.class);

    private static final String PATH = "D:\\sources\\CloudStorage";

    @Autowired
    private UploadedFileManager uploadedFileManager;

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
        String virtualName = request.getArgument();
        String suffix = virtualName.substring(virtualName.lastIndexOf("."), virtualName.length());

        /* 当前用户信息 */
        User user = session.getUser();

        /* 对文件md5 */
        File fromFile = new File(user.getHomeDirectory() + virtualName);
        String realName = FileHandler.getMD5(fromFile);

        /* 复制文件 */
        FileHandler.moveFile(fromFile, new File(PATH + "/" + realName));

        /*入数据库*/
        //TODO
        UploadedFile uploadedFile = new UploadedFile();

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
