create table PATIENT
(
	ID NUMBER(11) default NULL not null
		primary key,
	IS_DELETED NUMBER(1) default 0 not null,
	GMT_CREATE TIMESTAMP(6),
	CREATOR VARCHAR2(64),
	GMT_MODIFIED TIMESTAMP(6),
	MODIFIER VARCHAR2(64),
	USERNAME VARCHAR2(100),
	TYPE NUMBER
)
/

comment on table PATIENT is '病人'
/

comment on column PATIENT.ID is 'id'
/

comment on column PATIENT.IS_DELETED is '删除标记'
/

comment on column PATIENT.GMT_CREATE is '创建时间'
/

comment on column PATIENT.CREATOR is '创建人'
/

comment on column PATIENT.GMT_MODIFIED is '更新时间'
/

comment on column PATIENT.MODIFIER is '更新者'
/

comment on column PATIENT.USERNAME is '病人用户名'
/

comment on column PATIENT.TYPE is '病人类型'
/