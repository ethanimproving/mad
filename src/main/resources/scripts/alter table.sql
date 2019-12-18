use improving;

create table movie(  
    movieId int unsigned auto_increment not null primary key,
	title varchar(96) not null,
	year varchar(8) not null,
	rating int,
	runTime int
);

-- Add soft delete 

ALTER TABLE movie
ADD isDeleted boolean;

SET SQL_SAFE_UPDATES = 0;

UPDATE movie
SET isDeleted = false
WHERE rating > 0;

-- Add version control 

ALTER TABLE movie
ADD startDate datetime default current_timestamp,
ADD endDate datetime;

ALTER TABLE movie
DROP PRIMARY KEY,
ADD PRIMARY KEY(movieId,startDate);

-- Insert movies

INSERT INTO movie(movieId,title,year,rating,runTime)
VALUES
  (1,'Impactful',1953,2,112),
  (2,'Intelligent Lock',1941,7,181),
  (3,'Incentivize Ukraine Pizza',1936,6,157),
  (4,'Garden Tasty Drives',1901,3,115),
  (5,'Application',1901,2,141),
  (6,'Experiences District Generic',1982,4,163),
  (7,'Synergized',1986,9,159),
  (8,'Connecting',1912,5,186),
  (9,'Capacitor ADP',1955,7,159),
  (10,'Soap Approach index',1975,9,179),
  (11,'Dedicated',1975,2,152);