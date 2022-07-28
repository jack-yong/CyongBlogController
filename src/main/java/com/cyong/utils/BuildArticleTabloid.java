package com.cyong.utils;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.utils
 * @Author: cyong
 * @CreateTime: 2022-07-22 18:59
 * @Description: 生成markdown摘要工具,这里就不处理了，交给前端进行处理。
 */
@Component
public class BuildArticleTabloid {
    public String buildArticleTabloid(String mdContent)
    {

//        String regBold ="(\\*\\*|__)(.*?)(\\*\\*|__)"; //粗体
//        String regItalic = "(\\*|_)(.*?)\\1"; //斜体
//        String regImage = "!\\[[^\\]]+\\\\]\\([^\\)]+\\)";
//        String regLink = "/\\[[\\s\\S]*?\\]\\([\\s\\S]*?\\)/g"; //标签
//        String
//        String regTitle = "^(#+)(\s+)";
//        String regblank = "\\s+";
        return mdContent;

    }
}
