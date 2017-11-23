package com.web.oa.commons;

public class SQLTip {
    public static String save(boolean flag){
        return flag?"新增成功":"新增失败";
    }
    public static String delete(boolean flag){
        return flag?"删除成功":"删除失败";
    }
    public static String update(boolean flag){
        return flag?"修改成功":"修改失败";
    }
}
