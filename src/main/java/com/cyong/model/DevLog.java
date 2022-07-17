package com.cyong.model;

import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.model
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:33
 * @Description: 开发日志实体类
 */
@Data
public class DevLog {
    private Integer DevLogId;

    private String DevLogTitle;

    private String DevLogContent;

    private  Byte DevLogType;

    private Date  DevLogCreateTime;
}
