package hk.health.framework.adapter.outbound.sftp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SftpTest {
    @Autowired
    private FileSystemService fileSystemService;

    @Test
    public void sftpUpload() throws Exception {
        File file = new File("C:\\Users\\psy\\Desktop\\stfp测试.txt");
        InputStream inputStream = new FileInputStream(file);

        boolean uploadFile = fileSystemService.uploadFile("root/psy/" + file.getName(), inputStream);
        if (uploadFile) {
            System.out.println("success.....");
        } else {
            System.out.println("failure.....");
        }

        inputStream.close();
    }

    @Test
    public void download() throws Exception {
        File file = fileSystemService.downloadFile("root/psy/stfp测试.txt");
        if (file == null) {
            throw new FileNotFoundException("File not found!");
        }
        System.out.println(file.getName());

        file.delete();
    }

    @Test
    public void deleteFile() throws Exception {
        System.out.println(fileSystemService.deleteFile("root/psy/stfp测试.txt"));
    }
}
