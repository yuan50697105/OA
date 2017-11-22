CREATE TABLE contacts
(
  contactsId  BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  userId      BIGINT       NULL,
  orgId       BIGINT       NULL,
  name        VARCHAR(255) NULL,
  sex         VARCHAR(255) NULL,
  head        VARCHAR(255) NULL,
  zipCode     VARCHAR(255) NULL,
  address     VARCHAR(255) NULL,
  telephone   VARCHAR(255) NULL,
  mobilePhone VARCHAR(255) NULL,
  email       VARCHAR(255) NULL,
  QQ          VARCHAR(255) NULL,
  remark      TEXT         NULL
);

CREATE TABLE department
(
  departmentId   BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  orgId          BIGINT       NULL,
  superiorId     BIGINT       NULL,
  departmentName VARCHAR(255) NULL,
  introduce      TEXT         NULL
);

CREATE TABLE departmentmembers
(
  id           BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  orgId        BIGINT       NULL,
  departmentId BIGINT       NULL,
  userId       BIGINT       NULL,
  roleId       BIGINT       NULL,
  role         VARCHAR(255) NULL,
  positionId   BIGINT       NULL,
  position     VARCHAR(255) NULL,
  remark       TEXT         NULL,
  rank         INT          NULL
);

CREATE TABLE goods
(
  goodsId        BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  orgId          BIGINT       NULL,
  goodsName      VARCHAR(255) NULL,
  price          DOUBLE       NULL,
  units          VARCHAR(255) NULL,
  status         VARCHAR(255) NULL,
  introduce      VARCHAR(255) NULL,
  remark         VARCHAR(255) NULL,
  purchasingDate DATE         NULL
);

CREATE TABLE hibernate_sequence
(
  nexval BIGINT NULL
);

CREATE TABLE impower
(
  Id            BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  orgId         BIGINT       NULL,
  roleId        BIGINT       NULL,
  departmentId  BIGINT       NULL,
  menuId        BIGINT       NULL,
  inputTime     DATE         NULL,
  inputUserId   BIGINT       NULL,
  inputUserName VARCHAR(255) NULL,
  rank          INT          NULL
);

CREATE TABLE meetingroom
(
  roomId   BIGINT       NOT NULL
    PRIMARY KEY,
  remark   VARCHAR(255) NULL,
  roomName VARCHAR(255) NULL,
  status   VARCHAR(255) NULL
);

CREATE TABLE meetingroomask
(
  askId     BIGINT       NOT NULL
    PRIMARY KEY,
  endTime   DATETIME     NULL,
  operTime  DATETIME     NULL,
  remark    VARCHAR(255) NULL,
  roomId    BIGINT       NULL,
  startTime DATETIME     NULL,
  status    VARCHAR(255) NULL,
  userId    BIGINT       NULL,
  roomName  VARCHAR(255) NULL,
  userName  VARCHAR(255) NULL
);

CREATE TABLE menu
(
  menuId             BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  orgId              BIGINT       NULL,
  menuName           VARCHAR(255) NULL,
  menuIcon           VARCHAR(255) NULL,
  functionCode       BIGINT       NULL,
  functionIntroduce  VARCHAR(255) NULL,
  parameter          VARCHAR(255) NULL,
  parameterIntroduce VARCHAR(255) NULL,
  type               VARCHAR(255) NULL,
  grade              VARCHAR(255) NULL,
  rank               INT          NULL,
  superiorId         BIGINT       NULL,
  superiorName       VARCHAR(255) NULL,
  url                VARCHAR(255) NULL,
  windowNmae         VARCHAR(255) NULL,
  dataWindowNmae     VARCHAR(255) NULL,
  menuType           VARCHAR(255) NULL,
  openWay            VARCHAR(255) NULL,
  toolIcon           VARCHAR(255) NULL,
  help               VARCHAR(255) NULL,
  status             VARCHAR(255) NULL,
  toolMessage        VARCHAR(255) NULL,
  displayNo          VARCHAR(255) NULL,
  combinationKey     VARCHAR(255) NULL,
  mouseEnteredIcon   VARCHAR(255) NULL,
  mouseClickedIcon   VARCHAR(255) NULL,
  invalidIcon        VARCHAR(255) NULL,
  navigationNo       VARCHAR(255) NULL,
  updateTime         DATE         NULL,
  divClass           VARCHAR(255) NULL,
  liId               VARCHAR(255) NULL,
  tagaId             VARCHAR(255) NULL
);

CREATE TABLE notice
(
  noticeId    BIGINT       NOT NULL
    PRIMARY KEY,
  notice      VARCHAR(255) NULL,
  noticeName  VARCHAR(255) NULL,
  noticeType  VARCHAR(255) NULL,
  orgId       BIGINT       NULL,
  publishTime DATETIME     NULL,
  userId      BIGINT       NULL
);

CREATE TABLE organization
(
  orgId             BIGINT       NOT NULL
    PRIMARY KEY,
  superiorId        BIGINT       NULL,
  orgName           VARCHAR(255) NULL,
  type              VARCHAR(255) NULL,
  introduction      TEXT         NULL,
  registeredCapital VARCHAR(255) NULL,
  registerTime      DATE         NULL,
  status            VARCHAR(255) NULL,
  corporation       VARCHAR(255) NULL,
  telephone         VARCHAR(255) NULL,
  zipCode           VARCHAR(255) NULL,
  email             VARCHAR(255) NULL,
  address           VARCHAR(255) NULL,
  businessLicenseNo VARCHAR(255) NULL,
  remark            TEXT         NULL
);

CREATE TABLE role
(
  roleId       BIGINT       NOT NULL
    PRIMARY KEY,
  orgId        BIGINT       NULL,
  departmentId BIGINT       NULL,
  roleName     VARCHAR(255) NULL,
  permission   VARCHAR(255) NULL,
  duty         VARCHAR(255) NULL,
  introduce    VARCHAR(255) NULL,
  rank         BIGINT       NULL,
  remarks      VARCHAR(255) NULL,
  menuIds      VARCHAR(255) NULL
);

CREATE TABLE user
(
  userId       BIGINT       NOT NULL
    PRIMARY KEY,
  createTime   DATETIME     NULL,
  expireTime   DATETIME     NULL,
  mark         VARCHAR(255) NULL,
  orgId        BIGINT       NULL,
  position     VARCHAR(255) NULL,
  privateKey   VARCHAR(255) NULL,
  spellCode    VARCHAR(255) NULL,
  userName     VARCHAR(255) NULL,
  userPassword VARCHAR(255) NULL,
  wtu          VARCHAR(255) NULL
);

CREATE TABLE userdata
(
  userId         BIGINT       NOT NULL
    PRIMARY KEY,
  QQ             VARCHAR(255) NULL,
  address        VARCHAR(255) NULL,
  age            VARCHAR(255) NULL,
  birthdate      DATETIME     NULL,
  education      VARCHAR(255) NULL,
  email          VARCHAR(255) NULL,
  graduationDate DATETIME     NULL,
  head           VARCHAR(255) NULL,
  headFile       TINYBLOB     NULL,
  headFileNmae   VARCHAR(255) NULL,
  identityCard   VARCHAR(255) NULL,
  major          VARCHAR(255) NULL,
  maritalStatus  VARCHAR(255) NULL,
  mobilePhone    VARCHAR(255) NULL,
  name           VARCHAR(255) NULL,
  nation         VARCHAR(255) NULL,
  nativePlace    VARCHAR(255) NULL,
  orgId          BIGINT       NULL,
  politicsStatus VARCHAR(255) NULL,
  remark         VARCHAR(255) NULL,
  school         VARCHAR(255) NULL,
  sex            VARCHAR(255) NULL,
  telephone      VARCHAR(255) NULL,
  workTime       DATETIME     NULL,
  zipCode        VARCHAR(255) NULL
);

CREATE TABLE work
(
  workId             BIGINT AUTO_INCREMENT
    PRIMARY KEY,
  orgId              BIGINT       NULL,
  userId             BIGINT       NULL,
  workName           VARCHAR(255) NULL,
  work               TEXT         NULL,
  planStartDate      DATE         NULL,
  planEndDate        DATE         NULL,
  startDate          DATE         NULL,
  endDate            DATE         NULL,
  endPlanEndDate     DATETIME     NULL,
  startPlanStartDate DATETIME     NULL
);

