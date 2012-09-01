package cn.im47.cloud.storage.utilities.file;

import org.junit.Before;
import org.junit.Test;
import org.springside.modules.security.utils.Digests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 用途
 * User: pengfei.dongpf(pengfei.dong@gmail.com)
 * Date: 12-8-31
 * Time: 下午1:22
 */
public class FileHandlerTest {

    @Test
    public void testMoveFile() {
        File frmFile = new File("D:/TDDOWNLOAD/CLANNAD-中文版_Setup.exe");
        File toFile = new File("C:/b.exe");
        FileHandler.moveFile(frmFile, toFile);
        String str = FileHandler.getMD5(frmFile);
        System.out.println(str);
    }
}
