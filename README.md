# animalPjt

#### dbeaver 에 table 생성 코드 (**** 표시 부분 이름 바꿔서 추가하기)
```
Mammals
Birds
Reptiles
Amphibians
```

```code 

CREATE TABLE **Amphibians** (
    id        NUMBER(8) PRIMARY KEY,
    name      VARCHAR2(50),
    ordinal   VARCHAR2(50),
    branch    VARCHAR2(50),
    location  VARCHAR2(50)
);

-- 2. 시퀀스 생성
CREATE SEQUENCE **amphibians_seq**
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 3. 트리거 생성
CREATE OR REPLACE TRIGGER **amphibians_trigger**
BEFORE INSERT ON **amphibians**
FOR EACH ROW
WHEN (NEW.id IS NULL)
BEGIN
  SELECT **amphibians_seq**.NEXTVAL INTO :NEW.id FROM dual;
END;


```
