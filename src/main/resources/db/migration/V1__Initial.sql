CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE TABLE orders (
                          "TECH$CHANGE_DATE" DATE NOT NULL,
                          "TECH$INS_AUDIT_ID" INTEGER,
                          "TECH$ROW_STATUS" CHAR(1) NOT NULL,
                          "APPLICATION_ID" VARCHAR(100) NOT NULL,
                          "APPLICATION_NUM" VARCHAR(255) NOT NULL,
                          "INN_TXT" VARCHAR(100)    NOT NULL,
                          "CLIENT_NAME_TXT" VARCHAR(4000) NOT NULL,
                          "BEGIN_DATE" DATE NOT NULL,
                          "END_DATE" DATE,
                          "CHANNEL_NAME_TXT" VARCHAR(1000) NOT NULL,
                          "CREATION_NAME_TXT" VARCHAR(1000) NOT NULL,
                          "REGISTRATION_DEPARTMENT_TXT" VARCHAR(255) NOT NULL,
                          id uuid DEFAULT uuid_generate_v4 (),
                          PRIMARY KEY(id)
);