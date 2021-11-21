package com.cyong.utils;

import com.cyong.model.Result;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.utils
 * @Author: cyong
 * @CreateTime: 2021-11-21 18:36
 * @Description: 返回统一格式工具
 */
public class ResultUtil {
    public static Result success(String msg) {
        return success(200, msg);
    }

    public static Result success(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    public static Result success(Integer code, Object object, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setData(object);
        result.setMsg(msg);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
