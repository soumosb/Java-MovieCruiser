-- Include table data insertion, updation, deletion and select scripts


INSERT INTO moviecruiser.user(us_name) 
VALUES('Billie'); 

INSERT INTO moviecruiser.user(us_name) 
VALUES('Joe'); 

-- INSERTING MOVIE

INSERT INTO moviecruiser.movie(mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser)
VALUES('Avatar', '2787965087', 'Yes', '2017/03/15', 'Science Fiction', 'Yes'),
('The Avengers', '1518812988',	'Yes',	'2017/12/23',	'Superhero',	'No'),
(' Titanic',	'2187463944',	'Yes',	'2017/08/21',	'Romance', 'No'),
('Jurassic World', '1671713208',	'No',	'2017/07/02',	'Science Fiction',	'Yes'),
('Avengers: End Game',	'2750760348',	'Yes',	'2022/11/02',	'Superhero',	'Yes');

-- DISPLAYS USER

SELECT * FROM moviecruiser.user;

-- DISPLAY MOVIE LIST

SELECT * FROM moviecruiser.movie;

-- DISPLAYS MOVIE LIST FOR CUSTOMER

SELECT *
FROM moviecruiser.movie
WHERE mo_date_of_launch < CURDATE() AND mo_active= 'Yes';

SELECT * FROM movie where mo_id = 3;

-- EDIT MOVIE

UPDATE moviecruiser.movie
SET mo_title = 'Forrest Gump', mo_box_office = '275981368', mo_genre = 'Drama'
WHERE mo_id=3;

-- ADD MOVIE TO FAVORITE

INSERT INTO moviecruiser.favorite(fv_us_id, fv_mo_id)
VALUES ('1', '3'), ('1', '1'), ('1', '2');

SELECT * FROM moviecruiser.favorite;

-- DISPLAY CART ITEMS 

SELECT m.mo_title as "Title", m.mo_box_office as "Box Office" , m.mo_genre as "Genre" from moviecruiser.movie m, moviecruiser.favorite f where f.fv_mo_id = m.mo_id and fv_us_id =1;

-- CALCULATING CART TOTAL

SELECT COUNT(mo_id) as "No. Of Favorites"
FROM moviecruiser.movie m, moviecruiser.favorite f where m.mo_id = f.fv_mo_id and f.fv_us_id=1;

-- DELETE FROM FAVORITE

DELETE FROM moviecruiser.favorite WHERE fv_us_id=1 and fv_mo_id=2;