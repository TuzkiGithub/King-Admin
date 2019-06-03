/*
 * create tables for KING_ADMIN_DB
 * 2019/4/28 10:36:14
 */

set feedback off
set define off

-- ==================== 开始 sys_user
prompt creating table: sys_user...

create table sys_user
(
  id                            varchar2(64)          not null,
  sys_code                      varchar2(64),
  sys_name                      varchar2(256),
  req_cate                      varchar2(64),
  req_type                      varchar2(64),
  req_code                      varchar2(64),
  req_name                      varchar2(256),
  created_by                    varchar2(64),
  created_dept                  varchar2(64),
  created_date                  date,
  modified_by                   varchar2(64),
  modified_dept                 varchar2(64),
  modified_date                 date
);

comment on table sys_user is '系统用户表';

comment on column sys_user.id                             is '编号';
comment on column sys_user.sys_code                       is '系统编号';
comment on column sys_user.sys_name                       is '系统名称';
comment on column sys_user.req_cate                       is '需求分类。简单需求/标准需求';
comment on column sys_user.req_type                       is '需求类型。新增需求/系统故障/其他';
comment on column sys_user.req_code                       is '需求编号';
comment on column sys_user.req_name                       is '需求名称';
comment on column sys_user.created_by                     is '创建人';
comment on column sys_user.created_dept                   is '创建部门';
comment on column sys_user.created_date                   is '创建日期';
comment on column sys_user.modified_by                    is '修改人';
comment on column sys_user.modified_dept                  is '修改部门';
comment on column sys_user.modified_date                  is '修改日期';

prompt creating indexes for table: sys_user...
alter table sys_user add constraint sys_user_pk primary key (id);

--==================== 结束 sys_user


-- ==================== 开始 sys_role
prompt creating table: sys_role...

create table sys_role
(
  id                            varchar2(64)          not null,
  sys_code                      varchar2(64),
  sys_name                      varchar2(256),
  req_cate                      varchar2(64),
  req_type                      varchar2(64),
  req_code                      varchar2(64),
  req_name                      varchar2(256),
  apply_user_id                 varchar2(64),
  apply_user_name               varchar2(128),
  apply_contact                 varchar2(32),
  ent_id                        varchar2(64),
  created_by                    varchar2(64),
  created_dept                  varchar2(64),
  created_date                  date,
  modified_by                   varchar2(64),
  modified_dept                 varchar2(64),
  modified_date                 date
);

comment on table sys_role is '角色表';

comment on column sys_role.id                             is '编号';
comment on column sys_role.sys_code                       is '系统编号';
comment on column sys_role.sys_name                       is '系统名称';
comment on column sys_role.req_cate                       is '需求分类。简单需求/标准需求';
comment on column sys_role.req_type                       is '需求类型。新增需求/系统故障/其他';
comment on column sys_role.req_code                       is '需求编号';
comment on column sys_role.req_name                       is '需求名称';
comment on column sys_role.apply_user_id                  is '提出人编号';
comment on column sys_role.apply_user_name                is '提出人名称';
comment on column sys_role.apply_contact                  is '联系电话';
comment on column sys_role.ent_id                         is '实体编号';
comment on column sys_role.created_by                     is '创建人';
comment on column sys_role.created_dept                   is '创建部门';
comment on column sys_role.created_date                   is '创建日期';
comment on column sys_role.modified_by                    is '修改人';
comment on column sys_role.modified_dept                  is '修改部门';
comment on column sys_role.modified_date                  is '修改日期';

prompt creating indexes for table: sys_role...
alter table sys_role add constraint sys_role_pk primary key (id);

--==================== 结束 sys_role


/********************************
--必要的时候，用于drop表，以便重新运行create语句
drop table sys_user;
drop table sys_role;

********************************/

prompt Done.

set feedback on
set define on
