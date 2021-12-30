create table rooms (
	id serial,
	room_number integer,
	del_flg boolean
);

create table aggregation_log (
	id serial,
	access_token varchar(36),
	resistration_date timestamp,
	notification smallint
);