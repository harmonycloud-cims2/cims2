
DROP TABLE IF EXISTS `PATIENT`;
create table `PATIENT`
(
  ID           NUMBER(20) default NULL not null
    primary key,
  IS_DELETED   NUMBER(1) default 0     not null,
  GMT_CREATE   TIMESTAMP(6),
  CREATOR      VARCHAR2(64),
  GMT_MODIFIED TIMESTAMP(6),
  MODIFIER     VARCHAR2(64),
  USERNAME     VARCHAR2(100),
  TYPE         NUMBER
)

