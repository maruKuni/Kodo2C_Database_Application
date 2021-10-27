create table t_quake(
    quake_code char(6) primary key,
    quake_time timestamp,
    quake_center varchar(20),
    latitude real,
    longitude real,
    magnitude real,
    depth varchar(6),
    maxlv smallint
);