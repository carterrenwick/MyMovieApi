-- download/install H2 database (http://www.h2database.com/html/download.html)
-- launch h2 GUI with default settings (username: CTADMIN, password: verysecurepassphrase)

CREATE TABLE MOVIE (id number PRIMARY KEY, title varchar2(200), genre varchar2(200), rating number, release_date date);  

CREATE SEQUENCE MOVIE_SEQ
start with 1
increment by 1
minvalue 1
maxvalue 999999999
cycle;

INSERT into MOVIE values (MOVIE_SEQ.nextval, 'Source Code', 'Sci-Fi Action Thriller', .89, '2011-04-01'); 
INSERT into MOVIE values (MOVIE_SEQ.nextval, 'Hot Fuzz', 'Action Comedy', .79, '2007-03-14'); 
INSERT into MOVIE values (MOVIE_SEQ.nextval, 'Rush Hour', 'Action Comedy', .83, '1998-09-18'); 
INSERT into MOVIE values (MOVIE_SEQ.nextval, 'The Dark Knight', 'Superhero Action Adventure', 1, '2008-07-18'); 
INSERT into MOVIE values (MOVIE_SEQ.nextval, 'Uncut Gems', 'Crime Thriller', .81, '2019-12-25'); 
INSERT into MOVIE values (MOVIE_SEQ.nextval, 'Jaws', 'Thriller', .91, '1975-06-20');
INSERT into MOVIE values (MOVIE_SEQ.nextval, 'I Am Legend', 'Action Thriller', .99, '2007-12-14'); 