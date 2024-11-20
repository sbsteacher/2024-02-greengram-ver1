package com.green.greengramver1.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.UUID;

@Slf4j
@Component //빈등록
public class MyFileUtils {
    private final String uploadPath;

    /*
    @Value("${file.directory}")은
    yaml 파일에 있는 file.directory 속성에 저장된 값을 생성자 호출할 때 값을 넣어준다.
     */
    public MyFileUtils(@Value("${file.directory}") String uploadPath) {
        log.info("MyFileUtils - 생성자: {}", uploadPath);
        this.uploadPath = uploadPath;
    }

    // path = "ddd/aaa"
    // D:/2024-02/download/greengram_ver1/ddd/aaa
    //디렉토리 생성
    public String makeFolders(String path) {
        File file = new File(uploadPath, path);
        file.mkdirs();
        return file.getAbsolutePath();
    }

    //파일명에서 확장자 추출
    public String getExt(String fileName) {
        int lastIdx = fileName.lastIndexOf(".");
        return fileName.substring(lastIdx);
    }

    //랜덤파일명 생성
    public String makeRandomFileName() {
        return UUID.randomUUID().toString();
    }

    //랜덤파일명 + 확장자 생성하여 리턴
    public String makeRandomFileName(String originalFileName) {
        return makeRandomFileName() + getExt(originalFileName);
    }

}


class Test {
    public static void main(String[] args) {
        MyFileUtils myFileUtils = new MyFileUtils("C:/temp");
        String randomFileName = myFileUtils.makeRandomFileName("707211_1532672215.jpg");
        System.out.println(randomFileName);
    }
}