DROP TABLE IF EXISTS t2;
DROP TABLE IF EXISTS t3;
DROP TABLE IF EXISTS t1;
DROP TABLE IF EXISTS t4;

CREATE TABLE T1(
	roll INT(5) primary key,
	name VARCHAR(20),
	age INT(5)
);

CREATE TABLE T2(
	roll INT(5),
	address VARCHAR(20),
	FOREIGN KEY (roll) REFERENCES T1(roll) 
	ON UPDATE CASCADE on delete cascade
);

CREATE TABLE T3(
	roll INT(5),
	year VARCHAR(5),
	FOREIGN KEY (roll) REFERENCES T1(roll) 
	ON UPDATE CASCADE on delete cascade
);

CREATE TABLE T4(
	year VARCHAR(5) PRIMARY KEY,
	hostel VARCHAR(5)
);

ALTER TABLE T3 add CONSTRAINT fk_yr FOREIGN KEY(year) REFERENCES T4(year) ON UPDATE CASCADE ON DELETE CASCADE;

INSERT INTO T1 values(1,"akhi",20);
INSERT INTO T1 values(2,"surabhi",18);
INSERT INTO T1 values(3,"nikhi",16);
INSERT INTO T1 values(4,"sneha",14);
INSERT INTO T1 values(5,"avi",14);
INSERT INTO T1 values(6,"sam",20);

INSERT INTO T2 values(1,'hyd');
INSERT INTO T2 values(2,'nalgonda');
INSERT INTO T2 values(3,'hyd');
INSERT INTO T2 values(4,'chennai');
INSERT INTO T2 values(5,'vijayawada');
INSERT INTO T2 values(6,'karimnagar');

INSERT INTO T4 values('II','H1');
INSERT INTO T4 values('IV','H2');
INSERT INTO T4 values('V','H3');
INSERT INTO T4 values('XII','H4');

INSERT INTO T3 values(1,'XII');
INSERT INTO T3 values(2,'V');
INSERT INTO T3 values(3,'IV');
INSERT INTO T3 values(4,'II');
INSERT INTO T3 values(5,'II');
INSERT INTO T3 values(6,'XII');


