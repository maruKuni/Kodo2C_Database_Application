drop table t_eacharealv;
create table t_eacharealv(
    quake_code char(6),
    quake_prefecture varchar(20),
    quake_area varchar(20),
    lv smallint,
    PRIMARY KEY (quake_code,quake_area)
);