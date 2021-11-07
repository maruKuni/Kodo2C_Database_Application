drop table t_quake;
create table t_quake(
    quake_code char(6) primary key,
    quake_time timestamp,
    quake_center_prefecture varchar(20),
    quake_center_area varchar(20),
    latitude real,
    longitude real,
    magnitude real,
    depth varchar(6),
    maxlv smallint
);