-- 20200923
CREATE TABLE YRZ_MERCHANT_LIMIT
(	MERCHANT_LIMIT_ID BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
     MERCHANT_ID VARCHAR(32) COMMENT '商户ID',
     LIMIT_ITEM VARCHAR(32) COMMENT '约束项',
     LIMIT_VALUE VARCHAR(32) COMMENT '约束值',
     LIMIT_TYPE VARCHAR(32) COMMENT '约束类别',
     SOURCE_SYSTEM VARCHAR(32) COMMENT '所属系统',
     STATUS VARCHAR(10) COMMENT '状态(1:启用 0:停用)',
     CREATED_BY VARCHAR(32) COMMENT '创建人',
     CREATED_DATE DATE COMMENT '创建时间',
     UPDATED_BY VARCHAR(32) COMMENT '修改人',
     UPDATED_DATE DATE COMMENT '修改时间',
     CONSTRAINT PK_YRZ_MERCHANT_LIMIT PRIMARY KEY (MERCHANT_LIMIT_ID)
) ENGINE=InnoDB;

CREATE TABLE YRZ_MERCHANT_CONF
(	YRZ_MERCHANT_CONF_ID BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
     MERCHANT_ID VARCHAR(32) COMMENT '商户ID',
     MERCHANT_KEY VARCHAR(32) COMMENT '商户Key',
     MERCHANT_NAME VARCHAR(128) COMMENT '商户名称',
     ORG_ID VARCHAR(32) COMMENT '机构账号',
     PUBLIC_KEY VARCHAR(32) COMMENT '公钥',
     SOURCE_SYSTEM VARCHAR(32) COMMENT '所属系统',
     STATUS VARCHAR(10) COMMENT '状态(1:启用 0:停用)',
     CREATED_BY VARCHAR(32) COMMENT '创建人',
     CREATED_DATE DATE COMMENT '创建时间',
     UPDATED_BY VARCHAR(32) COMMENT '修改人',
     UPDATED_DATE DATE COMMENT '修改时间',
     CONSTRAINT PK_YRZ_MERCHANT_CONF PRIMARY KEY (YRZ_MERCHANT_CONF_ID)
) ENGINE=InnoDB;



insert into YRZ_MERCHANT_CONF ( merchant_id, merchant_key, merchant_name, org_id, public_key, source_system, status, created_by, created_date, updated_by, updated_date)
values ('CAS20180522150623', '95d64d617dff4720b5c77770ed95bd92', '中央审批系统', null, null, 'CAS', '1', 'admin', now(), null, null);
insert into YRZ_MERCHANT_CONF ( merchant_id, merchant_key, merchant_name, org_id, public_key, source_system, status, created_by, created_date, updated_by, updated_date)
values ('YRZ20181215604401', '6319dd2d032d503a92491398a76e1e2d', '壹融站', null, null, 'NLP', '1', 'admin', now(), null, null);
insert into YRZ_MERCHANT_CONF ( merchant_id, merchant_key, merchant_name, org_id, public_key, source_system, status, created_by, created_date, updated_by, updated_date)
values ('FGS201909250115001', 'BEirBUZWaSf5Aj66Serp9ToNgY8NwPID', '融资担保系统', null, null, 'FGS', '1', 'admin', now(), null, null);
insert into YRZ_MERCHANT_CONF ( merchant_id, merchant_key, merchant_name, org_id, public_key, source_system, status, created_by, created_date, updated_by, updated_date)
values ('SAS202006229527003', '6d3839333b19496b80bade6dd61cdd70', '壹融站智能风控系统', null, null, 'SAS', '1', 'admin', now(), null, null);

