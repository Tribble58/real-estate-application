create schema if not exists real_estate;

create table if not exists real_estate.houses(
                    id serial primary key,
                    address varchar(255),
                    city varchar(255),
                    state varchar(255),
                    country varchar(255)
                    );