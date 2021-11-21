package com.cyong.model;

import lombok.Data;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.model
 * @Author: cyong
 * @CreateTime: 2021-11-21 18:38
 * @Description: 返回结果实体类
 */
@Data
public class Result<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private  T data;
}
