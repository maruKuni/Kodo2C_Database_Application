drop table t_tsunami;
create table t_tsunami(
    quake_code char(6),
    tsunami_prefecture varchar(20),
    tsunami_area varchar(10),
    firstwave_time timestamp,
    maxwave_time timestamp,
    maxwave_height varchar(6),
    PRIMARY KEY (quake_code,tsunami_area)
);
