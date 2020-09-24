CREATE TABLE "YRZ_MERCHANT_LIMIT"
(	"MERCHANT_LIMIT_ID" NUMBER NOT NULL ENABLE,
     "MERCHANT_ID" VARCHAR2(32),
     "LIMIT_ITEM" VARCHAR2(32),
     "LIMIT_VALUE" VARCHAR2(32),
     "LIMIT_TYPE" VARCHAR2(32),
     "SOURCE_SYSTEM" VARCHAR2(32),
     "STATUS" VARCHAR2(10),
     "CREATED_BY" VARCHAR2(32),
     "CREATED_DATE" DATE,
     "UPDATED_BY" VARCHAR2(32),
     "UPDATED_DATE" DATE,
     CONSTRAINT "PK_YRZ_MERCHANT_LIMIT" PRIMARY KEY ("MERCHANT_LIMIT_ID")
) ;
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."MERCHANT_LIMIT_ID" IS ' 主键ID';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."MERCHANT_ID" IS '商户ID';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."LIMIT_ITEM" IS '约束项';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."LIMIT_VALUE" IS '约束值';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."LIMIT_TYPE" IS '约束类别';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."SOURCE_SYSTEM" IS '所属系统';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."STATUS" IS '状态(1:启用 0:停用)';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."CREATED_BY" IS '创建人';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."CREATED_DATE" IS '创建时间';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."UPDATED_BY" IS '修改人';
COMMENT ON COLUMN "YRZ_MERCHANT_LIMIT"."UPDATED_DATE" IS '修改时间';
COMMENT ON TABLE "YRZ_MERCHANT_LIMIT"  IS '认证通商户约束表';


CREATE TABLE "YRZ_MERCHANT_CONF"
(	"YRZ_MERCHANT_CONF_ID" NUMBER NOT NULL ENABLE,
     "MERCHANT_ID" VARCHAR2(32),
     "MERCHANT_KEY" VARCHAR2(32),
     "MERCHANT_NAME" VARCHAR2(128),
     "ORG_ID" VARCHAR2(32),
     "PUBLIC_KEY" VARCHAR2(32),
     "SOURCE_SYSTEM" VARCHAR2(32),
     "STATUS" VARCHAR2(10),
     "CREATED_BY" VARCHAR2(32),
     "CREATED_DATE" DATE,
     "UPDATED_BY" VARCHAR2(32),
     "UPDATED_DATE" DATE,
     CONSTRAINT "PK_YRZ_MERCHANT_CONF" PRIMARY KEY ("YRZ_MERCHANT_CONF_ID")
);
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."YRZ_MERCHANT_CONF_ID" IS '主键ID';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."MERCHANT_ID" IS '商户ID';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."MERCHANT_KEY" IS '商户Key';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."MERCHANT_NAME" IS '商户名称';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."ORG_ID" IS '机构账号';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."PUBLIC_KEY" IS '公钥';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."SOURCE_SYSTEM" IS '所属系统';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."STATUS" IS '状态(1:启用 0:停用)';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."CREATED_BY" IS '创建人';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."CREATED_DATE" IS '创建时间';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."UPDATED_BY" IS '修改人';
COMMENT ON COLUMN "YRZ_MERCHANT_CONF"."UPDATED_DATE" IS '修改时间';
COMMENT ON TABLE "YRZ_MERCHANT_CONF"  IS '认证通商户配置表';




insert into YRZ_MERCHANT_CONF (yrz_merchant_conf_id, merchant_id, merchant_key, merchant_name, org_id, public_key, source_system, status, created_by, created_date, updated_by, updated_date)
values (1, 'CAS20180522150623', '95d64d617dff4720b5c77770ed95bd92', '中央审批系统', null, null, 'CAS', '1', 'admin', to_date('12-04-2019 11:10:11', 'dd-mm-yyyy hh24:mi:ss'), null, null);
insert into YRZ_MERCHANT_CONF (yrz_merchant_conf_id, merchant_id, merchant_key, merchant_name, org_id, public_key, source_system, status, created_by, created_date, updated_by, updated_date)
values (2, 'YRZ20181215604401', '6319dd2d032d503a92491398a76e1e2d', '壹融站', null, null, 'NLP', '1', 'admin', to_date('12-04-2019 11:10:11', 'dd-mm-yyyy hh24:mi:ss'), null, null);
insert into YRZ_MERCHANT_CONF (yrz_merchant_conf_id, merchant_id, merchant_key, merchant_name, org_id, public_key, source_system, status, created_by, created_date, updated_by, updated_date)
values (41, 'FGS201909250115001', 'BEirBUZWaSf5Aj66Serp9ToNgY8NwPID', '融资担保系统', null, null, 'FGS', '1', 'admin', to_date('25-09-2019 11:37:56', 'dd-mm-yyyy hh24:mi:ss'), null, null);
insert into YRZ_MERCHANT_CONF (yrz_merchant_conf_id, merchant_id, merchant_key, merchant_name, org_id, public_key, source_system, status, created_by, created_date, updated_by, updated_date)
values (61, 'SAS202006229527003', '6d3839333b19496b80bade6dd61cdd70', '壹融站智能风控系统', null, null, 'SAS', '1', 'admin', to_date('22-06-2020 13:40:20', 'dd-mm-yyyy hh24:mi:ss'), null, null);

