package com.web.oa.bean;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "myCache")
public class Menu {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long menuId;// 菜单编号
    private Long orgId;// 机构Id
    private String menuName;// 菜单名
    private String menuIcon;// 菜单图片
    private Long functionCode;// 功能代码
    private String functionIntroduce;// 功能描述
    private String parameter;// 参数
    private String parameterIntroduce;// 参数描述
    private String type;// 菜单类别 1：系统菜单 2：自定义菜单
    private String grade;// 菜单级别 0：系统管理  1：基础菜单 2：子菜单
    private Integer rank;// 排序
    private Long superiorId;// 上级菜单编号
    private String superiorName;// 上级菜单名
    private String url;// 请求链接
    private String windowNmae;// 窗口名称
    private String dataWindowNmae;// 数据窗口名称
    private String menuType;// 菜单项类别
    private String openWay;// 打开窗口方式
    private String toolIcon;// 工具条图片
    private String help;// MDI帮助
    private String status;// 状态标志 1：启用 2：停用
    private String toolMessage;// 工具条信息
    private String displayNo;// 显示序号
    private String combinationKey;// 组合键
    private String mouseEnteredIcon;// 按钮在鼠标放在上面的状态图形
    private String mouseClickedIcon;// 按钮在鼠标按下的状态图形
    private String invalidIcon;// 按钮无效状态图形
    private String navigationNo;// 导航台编号
    private Date updateTime;// 更新时间
    private String divClass;// <div class
    private String liId;// <li id
    private String tagaId;// <a id

    @Transient
    private List<Menu> menuList;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Long getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(Long functionCode) {
        this.functionCode = functionCode;
    }

    public String getFunctionIntroduce() {
        return functionIntroduce;
    }

    public void setFunctionIntroduce(String functionIntroduce) {
        this.functionIntroduce = functionIntroduce;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParameterIntroduce() {
        return parameterIntroduce;
    }

    public void setParameterIntroduce(String parameterIntroduce) {
        this.parameterIntroduce = parameterIntroduce;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Long getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Long superiorId) {
        this.superiorId = superiorId;
    }

    public String getSuperiorName() {
        return superiorName;
    }

    public void setSuperiorName(String superiorName) {
        this.superiorName = superiorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWindowNmae() {
        return windowNmae;
    }

    public void setWindowNmae(String windowNmae) {
        this.windowNmae = windowNmae;
    }

    public String getDataWindowNmae() {
        return dataWindowNmae;
    }

    public void setDataWindowNmae(String dataWindowNmae) {
        this.dataWindowNmae = dataWindowNmae;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getOpenWay() {
        return openWay;
    }

    public void setOpenWay(String openWay) {
        this.openWay = openWay;
    }

    public String getToolIcon() {
        return toolIcon;
    }

    public void setToolIcon(String toolIcon) {
        this.toolIcon = toolIcon;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToolMessage() {
        return toolMessage;
    }

    public void setToolMessage(String toolMessage) {
        this.toolMessage = toolMessage;
    }

    public String getDisplayNo() {
        return displayNo;
    }

    public void setDisplayNo(String displayNo) {
        this.displayNo = displayNo;
    }

    public String getCombinationKey() {
        return combinationKey;
    }

    public void setCombinationKey(String combinationKey) {
        this.combinationKey = combinationKey;
    }

    public String getMouseEnteredIcon() {
        return mouseEnteredIcon;
    }

    public void setMouseEnteredIcon(String mouseEnteredIcon) {
        this.mouseEnteredIcon = mouseEnteredIcon;
    }

    public String getMouseClickedIcon() {
        return mouseClickedIcon;
    }

    public void setMouseClickedIcon(String mouseClickedIcon) {
        this.mouseClickedIcon = mouseClickedIcon;
    }

    public String getInvalidIcon() {
        return invalidIcon;
    }

    public void setInvalidIcon(String invalidIcon) {
        this.invalidIcon = invalidIcon;
    }

    public String getNavigationNo() {
        return navigationNo;
    }

    public void setNavigationNo(String navigationNo) {
        this.navigationNo = navigationNo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDivClass() {
        return divClass;
    }

    public void setDivClass(String divClass) {
        this.divClass = divClass;
    }

    public String getLiId() {
        return liId;
    }

    public void setLiId(String liId) {
        this.liId = liId;
    }

    public String getTagaId() {
        return tagaId;
    }

    public void setTagaId(String tagaId) {
        this.tagaId = tagaId;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
}
