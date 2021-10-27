create table t_tsunami(
    quake_code char(6) primary key,
    tsunami_area varchar(10) primary key,
    firstwave_time timestamp,
    maxwave_time timestamp,
    maxwave_height varchar(6),
    tsunami_prefecture varchar(4)
);
