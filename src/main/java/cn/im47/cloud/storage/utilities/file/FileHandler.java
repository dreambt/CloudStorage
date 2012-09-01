package cn.im47.cloud.storage.utilities.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * 文件处理类
 * <p/>
 * User: pengfei.dongpf(pengfei.dong@gmail.com)
 * Date: 12-8-30
 * Time: 下午9:19
 */
public class FileHandler {

    private static final Logger logger = LoggerFactory.getLogger(FileHandler.class);

    /**
     * 通过管道复制文件
     *
     * @param fromFile
     * @param toFile
     * @return
     */
    public static void moveFile(File fromFile, File toFile) {
        Long length = fromFile.length();
        FileInputStream in = null;
        try {
            in = new FileInputStream(fromFile);
            FileOutputStream out = new FileOutputStream(toFile);
            FileChannel inC = in.getChannel();
            FileChannel outC = out.getChannel();
            while (true) {
                if (inC.position() == inC.size()) {
                    inC.close();
                    outC.close();
                }
                if ((inC.size() - inC.position()) < length)
                    length = inC.size() - inC.position();
                else
                    length = fromFile.length();
                inC.transferTo(inC.position(), length, outC);
                inC.position(inC.position() + length);
            }
        } catch (FileNotFoundException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 对文件 获得 md5
     *
     * @param file
     * @return
     */
    public static String getMD5(File file) {
        FileInputStream fis = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            logger.info("MD5摘要长度：" + md.getDigestLength());
            fis = new FileInputStream(file);
            byte[] buffer = new byte[2048];
            int length = -1;
            logger.info("开始生成摘要");
            long s = System.currentTimeMillis();
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            logger.info("摘要生成成功,总用时: " + (System.currentTimeMillis() - s)
                    + "ms");
            byte[] b = md.digest();
            return byteToHexStringSingle(b);//byteToHexString(b);
            // 16位加密
            // return buf.toString().substring(8, 24);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 独立把byte[]数组转换成十六进制字符串表示形式
     *
     * @param byteArray
     * @return
     * @author Bill
     * @create 2010-2-24 下午03:26:53
     */
    public static String byteToHexStringSingle(byte[] byteArray) {
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }

        return md5StrBuff.toString();
    }
}
