
-- MySQL Demo schema


CREATE TABLE country_dim
(country_id INT, 
country_name VARCHAR(20),
CONSTRAINT pk_country_dim PRIMARY KEY (country_id)
);

insert into country_dim values(1,'USA');
insert into country_dim values(2,'UK');
insert into country_dim values(3,'India');
insert into country_dim values(4,'China');

CREATE TABLE state_dim
(state_id INT, 
state_name VARCHAR(20),
country_id int,
CONSTRAINT pk_state_dim PRIMARY KEY (state_id),
CONSTRAINT fk_state_dim_country FOREIGN KEY (country_id)
REFERENCES country_dim(country_id)

);

insert into state_dim values(1,'NY',1);
insert into state_dim values(2,'SF',1);
insert into state_dim values(3,'DEL',3);
insert into state_dim values(4,'MUM',3);
insert into state_dim values(5,'Bej',4);


CREATE TABLE city_dim
(city_id INT, 
city_name VARCHAR(20),
state_id int,
country_id int,
CONSTRAINT pk_city_dim PRIMARY KEY (city_id),
CONSTRAINT fk_city_dim_state FOREIGN KEY (state_id)
REFERENCES state_dim(state_id),
CONSTRAINT fk_city_dim_country FOREIGN KEY (country_id)
REFERENCES country_dim(country_id)
);

insert into city_dim values(1,'SF_1',2,1);
insert into city_dim values(2,'SF_2',2,1);
insert into city_dim values(3,'DEL_1',3,3);
insert into city_dim values(4,'MUM_1',4,3);
insert into city_dim values(5,'MUM_2',4,3);
insert into city_dim values(6,'Bej_1',5,4);


CREATE TABLE demog_fact
(
country_id int,
state_id int,
city_id INT, 
male_pop bigint,
female_pop bigint,
CONSTRAINT pk_demog_fact PRIMARY KEY (country_id,state_id,city_id)
);

insert into demog_fact values(1,1,1,40693,70082);
insert into demog_fact values(1,1,2,72935,35260);
insert into demog_fact values(1,1,3,47292,19777);
insert into demog_fact values(1,1,4,98464,99457);
insert into demog_fact values(1,1,5,78596,73598);
insert into demog_fact values(1,1,6,32466,98633);
insert into demog_fact values(1,2,1,76758,32996);
insert into demog_fact values(1,2,2,33000,58395);
insert into demog_fact values(1,2,3,1920,4836);
insert into demog_fact values(1,2,4,13449,47393);
insert into demog_fact values(1,2,5,70032,12434);
insert into demog_fact values(1,2,6,20399,43631);
insert into demog_fact values(1,3,1,35487,67101);
insert into demog_fact values(1,3,2,94198,38350);
insert into demog_fact values(1,3,3,47178,69161);
insert into demog_fact values(1,3,4,30479,20836);
insert into demog_fact values(1,3,5,27516,91211);
insert into demog_fact values(1,3,6,10420,38434);
insert into demog_fact values(1,4,1,80968,11040);
insert into demog_fact values(1,4,2,53110,38730);
insert into demog_fact values(1,4,3,83121,93514);
insert into demog_fact values(1,4,4,18834,474);
insert into demog_fact values(1,4,5,87820,16041);
insert into demog_fact values(1,4,6,78274,65433);
insert into demog_fact values(1,5,1,6845,28945);
insert into demog_fact values(1,5,2,9327,8029);
insert into demog_fact values(1,5,3,91871,81037);
insert into demog_fact values(1,5,4,51684,18103);
insert into demog_fact values(1,5,5,54336,86769);
insert into demog_fact values(1,5,6,46815,67388);
insert into demog_fact values(2,1,1,50152,4020);
insert into demog_fact values(2,1,2,31104,13104);
insert into demog_fact values(2,1,3,45210,68498);
insert into demog_fact values(2,1,4,56612,39857);
insert into demog_fact values(2,1,5,13106,25948);
insert into demog_fact values(2,1,6,36683,7293);
insert into demog_fact values(2,2,1,65455,92506);
insert into demog_fact values(2,2,2,61205,21025);
insert into demog_fact values(2,2,3,72874,87487);
insert into demog_fact values(2,2,4,54315,41888);
insert into demog_fact values(2,2,5,21188,68551);
insert into demog_fact values(2,2,6,1530,68220);
insert into demog_fact values(2,3,1,86879,24144);
insert into demog_fact values(2,3,2,73402,40836);
insert into demog_fact values(2,3,3,59715,77233);
insert into demog_fact values(2,3,4,85772,57881);
insert into demog_fact values(2,3,5,14592,49755);
insert into demog_fact values(2,3,6,42051,88862);
insert into demog_fact values(2,4,1,26579,52843);
insert into demog_fact values(2,4,2,31546,86493);
insert into demog_fact values(2,4,3,77985,71689);
insert into demog_fact values(2,4,4,8131,76464);
insert into demog_fact values(2,4,5,99488,85601);
insert into demog_fact values(2,4,6,65983,69234);
insert into demog_fact values(2,5,1,28341,14428);
insert into demog_fact values(2,5,2,39657,9763);
insert into demog_fact values(2,5,3,75544,19545);
insert into demog_fact values(2,5,4,17804,25233);
insert into demog_fact values(2,5,5,88372,84461);
insert into demog_fact values(2,5,6,50005,63114);
insert into demog_fact values(3,1,1,63979,10900);
insert into demog_fact values(3,1,2,41124,49531);
insert into demog_fact values(3,1,3,41367,62834);
insert into demog_fact values(3,1,4,63548,79011);
insert into demog_fact values(3,1,5,71338,42411);
insert into demog_fact values(3,1,6,92346,47737);
insert into demog_fact values(3,2,1,57879,59707);
insert into demog_fact values(3,2,2,59874,24598);
insert into demog_fact values(3,2,3,92553,24212);
insert into demog_fact values(3,2,4,70356,18369);
insert into demog_fact values(3,2,5,85137,63954);
insert into demog_fact values(3,2,6,60702,5814);
insert into demog_fact values(3,3,1,75389,44284);
insert into demog_fact values(3,3,2,6251,34545);
insert into demog_fact values(3,3,3,55492,73849);
insert into demog_fact values(3,3,4,23769,13789);
insert into demog_fact values(3,3,5,52062,7499);
insert into demog_fact values(3,3,6,69640,60852);
insert into demog_fact values(3,4,1,39312,9229);
insert into demog_fact values(3,4,2,26478,90865);
insert into demog_fact values(3,4,3,39749,1989);
insert into demog_fact values(3,4,4,64904,95578);
insert into demog_fact values(3,4,5,98040,60390);
insert into demog_fact values(3,4,6,81515,33443);
insert into demog_fact values(3,5,1,95695,23174);
insert into demog_fact values(3,5,2,55353,42497);
insert into demog_fact values(3,5,3,90945,49558);
insert into demog_fact values(3,5,4,15695,86413);
insert into demog_fact values(3,5,5,91415,41507);
insert into demog_fact values(3,5,6,13146,72272);
insert into demog_fact values(4,1,1,80848,17383);
insert into demog_fact values(4,1,2,11657,89521);
insert into demog_fact values(4,1,3,97055,61965);
insert into demog_fact values(4,1,4,9726,85560);
insert into demog_fact values(4,1,5,59728,3296);
insert into demog_fact values(4,1,6,18175,84542);
insert into demog_fact values(4,2,1,4040,91566);
insert into demog_fact values(4,2,2,97641,10227);
insert into demog_fact values(4,2,3,9769,64734);
insert into demog_fact values(4,2,4,21540,98604);
insert into demog_fact values(4,2,5,5300,5099);
insert into demog_fact values(4,2,6,79953,48167);
insert into demog_fact values(4,3,1,54409,23420);
insert into demog_fact values(4,3,2,17663,65308);
insert into demog_fact values(4,3,3,21962,10850);
insert into demog_fact values(4,3,4,80797,73858);
insert into demog_fact values(4,3,5,60959,91661);
insert into demog_fact values(4,3,6,10,40730);
insert into demog_fact values(4,4,1,97810,68075);
insert into demog_fact values(4,4,2,64777,6012);
insert into demog_fact values(4,4,3,81946,32638);
insert into demog_fact values(4,4,4,57841,71389);
insert into demog_fact values(4,4,5,61077,80537);
insert into demog_fact values(4,4,6,9984,59962);
insert into demog_fact values(4,5,1,23533,74679);
insert into demog_fact values(4,5,2,54223,37443);
insert into demog_fact values(4,5,3,61438,91288);
insert into demog_fact values(4,5,4,96320,32423);
insert into demog_fact values(4,5,5,20110,43832);
insert into demog_fact values(4,5,6,57908,68247);




