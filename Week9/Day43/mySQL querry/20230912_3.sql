use world;
select * from city;
desc city;

explain (select * from city where id = 80);

create index icity on city(population);

explain (select * from city where population = 10);