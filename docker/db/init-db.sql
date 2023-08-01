create schema if not exists real_estate;

create table if not exists real_estate.houses(
                    id serial primary key,
                    address varchar(255),
                    city varchar(255),
                    state varchar(255),
                    country varchar(255)
                    );


insert into real_estate.houses (address, city, state, country)
values ('Челюскинцев 20, 12', 'Ржев', 'Тверская область', 'Россия');
insert into real_estate.houses (address, city, state, country)
values ('Новочеремушинская 23к1, 49', 'Москва', null, 'Россия');
