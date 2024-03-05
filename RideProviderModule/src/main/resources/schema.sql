create table ride_info (no_of_seats integer not null check (no_of_seats>=0), car_name varchar(255), car_type varchar(255), fuel_type varchar(255), rp_id varchar(255) not null, vechile_no varchar(255) not null, primary key (rp_id, vechile_no));
create table ride_provide (valid_upto date not null, adhar_card bigint not null, phone bigint not null, dl_no varchar(16) not null, email_id varchar(255), first_name varchar(255), last_name varchar(255), rp_id varchar(255) not null, status varchar(255), primary key (rp_id));
create table simles (occupancy integer not null check (occupancy>=0), smile_id integer not null, destination varchar(255), ride_info_rp_id varchar(255), ride_info_vechile_no varchar(255), rp_id varchar(255) not null, source varchar(255), primary key (smile_id));
alter table if exists ride_info add constraint FK65lemwkl0192ybn6gf85bcq4q foreign key (rp_id) references ride_provide;
alter table if exists simles add constraint FKs7e8br32x0jmpjtm3yh3yiydd foreign key (ride_info_rp_id, ride_info_vechile_no) references ride_info;