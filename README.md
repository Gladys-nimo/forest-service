## WildLife tracker
## By Gladys Kanyora
10 December 2020
#  Description
An application that allows Rangers to track wildlife in a sightings areas
#Technology Used
Java
Html
Css
#Setup Instructions
1. Launch postgres
2. Type in psql
3. CREATE DATABASE wildlife_tracker
4.\c wildlife_tracker
5.CREATE TABLE animal (id SERIAL PRIMARY KEY, name varchar)
6. CREATE TABLE sighting (id SERIAL PRIMARY KEY, name varchar)
7. CREATE DATBASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker.
#licence
MIT open
