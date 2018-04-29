package com.bangcle.utils;

import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Attribute;
import org.dom4j.Element;
import org.springframework.util.ResourceUtils;

import java.io.File;

@Slf4j
public class FuncUtil {
    public static String getRootPath() {
        try {
            String strPath = ResourceUtils.getURL("classpath:").getPath();
            strPath = ResourceUtils.getURL("classpath:").getPath();
            File file = new File("");

            return file.getAbsolutePath();
        } catch (Exception e) {
            log.error("", e);
        }
        return "";
    }

}
