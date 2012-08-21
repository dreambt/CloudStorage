package cn.im47.cloud.storage.ftp;

import org.apache.ftpserver.ftplet.*;

import java.io.IOException;

/**
 * ftp 文件事件通知类
 * <p/>
 * User: baitao.jibt@gmail.com
 * Date: 12-8-19
 * Time: 上午9:00
 */
public class FileFtplet extends DefaultFtplet {

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
