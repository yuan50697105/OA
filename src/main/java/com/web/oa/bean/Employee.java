package com.web.oa.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.File;
import java.util.Date;

public class Employee {
    private Long userId; // 用户Id
    private Long orgId;// 机构Id
    private Long departmentMembersId; // 用户Id
    private String userName;// 帐号
    private String userPassword;// 密码
    private String name;// 姓名
    private String head;// 照片
    private File headFile;// 照片
    private String headFileFileName;// 图片文件名
    private String headFileContentType;// 图片文件类型
    private Date createTime;// 建立时间
    private Date expireTime;// 注销时间
    private String mark;// 有效标志 1：启用 2：停用
    private String spellCode;// 拼音码
    private String wtu;// 五笔码
    private String privateKey;// 私钥
    private String sex;// 性别
    private String nation;// 民族
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;// 出生日期
    private String age;// 照片
    private String identityCard;// 身份证号码
    private String politicsStatus;// 政治面貌
    private String maritalStatus;// 婚姻状况
    private String school;// 毕业学校
    private String education;// 学历
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date graduationDate;// 毕业时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date workTime;// 参加工作时间
    private String major;// 专业
    private String nativePlace;// 籍贯
    private String zipCode;// 邮政编码
    private String address;// 地址
    private String telephone;// 联系电话
    private String mobilePhone;// 手机
    private String email;// 电子信箱
    private String QQ;// 电子信箱
    private String remark;// 备注
    private Long userRoleId;// 职位
    private String userRole;// 职位

    private Long roleId;// 职位
    private String role;// 职位
    private Long positionId;// 职位
    private String position;// 职位
    private Long departmentId;// 部门Id
    private Long superiorId;// 上级部门
    private String departmentName;// 部门名称
    private String introduce;// 部门描述
    private String inputTime;// 登记时间
    private String roleName;// 角色名字
    private String permission;// 角色权限
    private String duty;// 角色责任
    private Long rank;// 角色级别
    private String remarks;// 备注

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getDepartmentMembersId() {
        return departmentMembersId;
    }

    public void setDepartmentMembersId(Long departmentMembersId) {
        this.departmentMembersId = departmentMembersId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public File getHeadFile() {
        return headFile;
    }

    public void setHeadFile(File headFile) {
        this.headFile = headFile;
    }

    public String getHeadFileFileName() {
        return headFileFileName;
    }

    public void setHeadFileFileName(String headFileFileName) {
        this.headFileFileName = headFileFileName;
    }

    public String getHeadFileContentType() {
        return headFileContentType;
    }

    public void setHeadFileContentType(String headFileContentType) {
        this.headFileContentType = headFileContentType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }

    public String getWtu() {
        return wtu;
    }

    public void setWtu(String wtu) {
        this.wtu = wtu;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Long superiorId) {
        this.superiorId = superiorId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getInputTime() {
        return inputTime;
    }

    public void setInputTime(String inputTime) {
        this.inputTime = inputTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
