package com.web.oa.commons;

public class SQLTip {
    /**
     * 保存操作提示信息
     *
     * @param flag 处理结果
     * @return 提示信息
     */
    public static String save(boolean flag) {
        return flag ? "新增成功" : "新增失败";
    }

    /**
     * 删除操作提示信息
     *
     * @param flag 处理结果
     * @return 提示信息
     */
    public static String delete(boolean flag) {
        return flag ? "删除成功" : "删除失败";
    }

    /**
     * 修改操作提示信息
     *
     * @param flag 处理结果
     * @return 提示信息
     */
    public static String update(boolean flag) {
        return flag ? "修改成功" : "修改失败";
    }
}
