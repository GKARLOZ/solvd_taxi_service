-- use solvd_taxi_service;
-- INSERT INTO Vehicles(license_plate, vehicle_model)
-- VALUES("34j33k","Ford F150"); 

-- INSERT INTO Vehicles(license_plate,vehicle_model)
--  VALUES
--  ("rf34j", "Ford F130"),
--  ("3434j", "Ford F140"),
--   ("gt34j", "Ford F10");



-- Select * FROM Vehicles;

-- INSERT INTO Driver_licenses(license_number,date_of_birth, expiration_date)
-- VALUES("3J3FH323421","1789-12-23","2023-05-01");

-- INSERT INTO Driver_licenses(license_number,date_of_birth, expiration_date)
-- VALUES("gt6FH323421","1889-12-23","2024-05-01"),
-- ("xd3FH323421","1989-12-23","2123-05-01"),
-- ("vf1FH323421","2789-12-23","2023-05-01");

-- SELECT * FROM Driver_licenses;

-- INSERT INTO Profiles(name, phone)
-- VALUES("Eddy", " (321)123-1234");

-- INSERT INTO Profiles(name, phone)
-- VALUES("Fredy", "(221)123-1234"),
-- ("Shredy", "(432)123-1234"),
-- ("Ready", "(567)123-1234");

-- INSERT INTO Profiles(name, phone)
-- VALUES("Eddy", " (321)123-1234");

-- INSERT INTO Profiles(name, phone)
-- VALUES("Fredy", "(221)123-1234"),
-- ("Shredy", "(432)123-1234"),
-- ("Ready", "(567)123-1234");

-- SELECT * FROM Profiles;


-- INSERT INTO Users(email,profile_id, vehicle_id,driver_license_id)
-- VALUES("pepito@gmail.com",1,1,1);

-- INSERT INTO Users(email,profile_id, vehicle_id,driver_license_id)
-- VALUES("asdfa@gmail.com",2,1,2),
-- ("peadf@gmail.com",3,1,3),
-- ("eddaweo@gmail.com",4,3,4);

-- Select * FROM Users;

-- INSERT INTO ride_types(type,cost_per_mile)
-- VALUES ("standard", ".50"),
-- ("luxury",".90");

-- Select * FROM ride_types;

-- INSERT INTO Promo_codes(code,discount,expiration_date)
-- VALUES ("TAXI40", .75, "2023-12-30"),
-- ("TAXIfriend",.20,"2023-04-21");

-- SELECT * FROM Promo_codes;


-- INSERT INTO payment_methods(method,details)
-- VALUES("Debit","Visa"),
-- ("Credit", " Visa"),
-- ("Reward Points"," 1500points"),
-- ("Paypal","@john");

-- SELECT * FROM PAYMENT_METHODS;

-- INSERT INTO Rides( pickup_location, dropoff_location, ride_status, user_id, ride_type_id)
-- VALUES(" 123 apple st, San Francisco", "321 orange, Fresno"," DONE ", 2,1),
-- (" 323 Pineapple st, San Francisco", "321 orange, Fresno"," DONE ", 3,2);

-- SELECT * FROM RIDES;

-- INSERT INTO trips(start_date_time, end_date_time, distance, ride_id, promo_id)
-- VALUES(NOW(),now(),22,1,1),
-- (NOW(),now(),22,2,2);

-- SELECT * FROM TRIPS;

-- INSERT INTO INVOICES(tax_amount,total_amount, trip_id)
-- VALUES(4.23, 55.43,1),(8.2,78.32, 2);

-- SELECT * FROM invoices;

-- INSERT INTO PAYMENTS(payment_status,invoice_id,payment_method_id)
-- VALUES("PAID", 1,2), ("NON PAYMENT", 2,1);

-- SELECT * FROM PAYMENTS;



-- 10 UPDATES-----------------------------------------------------------------------------------------------------

-- SELECT * from Profiles;

-- UPDATE Profiles
-- SET name = "pepe"
-- WHERE id = 4;

-- UPDATE Profiles
-- SET name = "Juanito"
-- WHERE id = 3;

-- Select * From Profiles;

-- Select * From Vehicles;

-- UPDATE Vehicles
-- SET vehicle_model = "Jeep Wrangler"
-- Where id = 4;

-- UPDATE Vehicles
-- SET vehicle_model = "Dodge Ram"
-- Where id = 3;

-- UPDATE Vehicles
-- SET vehicle_model = "Tesla"
-- Where id = 2;

-- Select * FROM Vehicles;


-- Select * from users;

-- UPDATE USERS
-- SET email = "jjjj@gmail.com"
-- WHERE profile_id = 3;

-- UPDATE USERS
-- SET email = "ppppp@gmail.com"
-- WHERE profile_id = 4;

-- UPDATE USERS
-- SET email = "mysupersecureEmail@gmail.com"
-- WHERE profile_id = 1;

-- Select * from Users;

-- Select * from driver_licenses;

-- UPDATE DRIVER_LICENSES
-- SET license_number = "E323dede4"
-- Where id = 1;

-- UPDATE DRIVER_LICENSES
-- SET license_number = "Q678dede4"
-- Where id = 2;

-- Select * from driver_licenses;


-- 10 deletions------------------------------------------------------------------------------------
--  Select * from profiles;
--  
--  DELETE FROM PROFILES
--  WHERE ID = 8;
--   DELETE FROM PROFILES
--  WHERE ID = 7;
--   DELETE FROM PROFILES
--  WHERE ID = 6;
--   DELETE FROM PROFILES
--  WHERE ID = 5;
--   DELETE FROM PROFILES
--  WHERE ID = 4;
--  
--  Select * from profiles;

-- Select * from Vehicles; 

-- DELETE FROM VEHICLES
-- WHERE ID = 10;
-- DELETE FROM VEHICLES
-- WHERE ID = 9;
-- DELETE FROM VEHICLES
-- WHERE ID = 8;
-- DELETE FROM VEHICLES
-- WHERE ID = 7;
-- DELETE FROM VEHICLES
-- WHERE ID = 6;
--  
--  Select  * from Vehicles;


-- 5 alter table -------------------------------------------------------------------------------------

-- Alter table Users
-- ADD address varchar(45);

-- Alter table Users
-- ADD phone_number varchar(45);

-- Alter table Users
-- ADD last_name varchar(45);

-- Select * from users;

-- Alter table Users
-- Drop column address;

-- Alter table Users
-- Drop column phone_number;

-- Alter table Users
-- Drop column last_name;

-- Select * from users;


-- 1 join all tables statement -------------------------------------------------------------------


-- Select * 
-- From users
-- left join vehicles on users.vehicle_id = vehicles.id 
-- left join driver_licenses on users.driver_license_id = driver_licenses.id 
-- left join profiles on users.profile_id = profiles.id 
-- left join rides on rides.user_id = users.id
-- left join ride_types on rides.ride_type_id = ride_types.id
-- left join reviews on reviews.ride_id = rides.id
-- left join trips on trips.ride_id = rides.id
-- left join promo_codes on trips.promo_id = promo_codes.id
-- left join invoices on invoices.trip_id = trips.id
-- left join payments on invoices.id = payments.invoice_id
-- left join payment_methods on payments.payment_method_id = payment_methods.id;



-- 5 statements with left, right, inner, outer joins

-- Select * From Users
-- Inner join Profiles on users.profile_id = profiles.id;

-- Select * From Users
-- INNER JOIN Driver_Licenses on users.driver_license_id = driver_licenses.id;


-- Select * From Users
-- Inner join Vehicles on users.vehicle_id = vehicles.id;

-- Select * From Rides
-- Inner join Trips on rides.id = trips.ride_id;

-- Select * From Invoices
-- Inner join Trips on Invoices.trip_id = trips.id;
-- -- 5 left-------------------------------------------------------

-- Select * From Users
-- left join Profiles on users.profile_id = profiles.id;

-- Select * From Users
-- left JOIN Driver_Licenses on users.driver_license_id = driver_licenses.id;


-- Select * From Users
-- left join Vehicles on users.vehicle_id = vehicles.id;

-- Select * From Rides
-- left join Trips on rides.id = trips.ride_id;

-- Select * From Invoices
-- left join Trips on Invoices.trip_id = trips.id;

-- -- 5 right-----------------------------------------------------------------------

-- Select * From Users
-- right join Profiles on users.profile_id = profiles.id;

-- Select * From Users
-- right JOIN Driver_Licenses on users.driver_license_id = driver_licenses.id;


-- Select * From Users
-- right join Vehicles on users.vehicle_id = vehicles.id;

-- Select * From Rides
-- right join Trips on rides.id = trips.ride_id;

-- Select * From Invoices
-- right join Trips on Invoices.trip_id = trips.id;

-- -- 5 outer -------------------------------------------------------------------------------------------------


-- Select * From Users
-- left join Vehicles on users.vehicle_id = vehicles.id
-- Union
-- Select * From Users
-- right join Vehicles on users.vehicle_id = vehicles.id;

-- Select * From Invoices
-- right join Trips on Invoices.trip_id = trips.id
-- union
-- Select * From Invoices
-- left join Trips on Invoices.trip_id = trips.id;

--  Select * From Users
-- left JOIN Driver_Licenses on users.driver_license_id = driver_licenses.id
-- union
-- Select * From Users
-- right JOIN Driver_Licenses on users.driver_license_id = driver_licenses.id;
--  
-- Select * From Users
-- right join Vehicles on users.vehicle_id = vehicles.id
-- union
-- Select * From Users
-- left join Vehicles on users.vehicle_id = vehicles.id;

-- Select * From Rides
-- right join Trips on rides.id = trips.ride_id
-- union
-- Select * From Rides
-- left join Trips on rides.id = trips.ride_id;


-- 7 statements with aggregate functions and group by and without having.-----------------

-- SELECT  trip_id, sum(tax_amount) as tax
-- From Invoices
-- Group by trip_id;

-- SELECT vehicle_model, COUNT(vehicle_model)
-- From Vehicles
-- Group by vehicle_model;

-- SELECT ride_id, AVG(distance)
-- FROM trips
-- GROUP BY ride_id;

-- SELECT tax_amout, count(id)
-- FROM INVOICES
-- GROUP BY ID;

-- SELECT ID, min(TAX_AMOUNT)
-- FROM INVOICES
-- GROUP BY ID;

-- SELECT ride_id, max(distance)
-- FROM trips
-- GROUP BY ID;

-- select code, max(discount)
-- from promo_codes
-- group by code;


-- -- 7 statements with aggregate functions and group by and with having.--------------------------------


-- SELECT vehicle_model, COUNT(vehicle_model) as c
-- From Vehicles
-- Group by vehicle_model
-- having c > 1;

-- SELECT  trip_id, sum(tax_amount) as tax
-- From Invoices
-- Group by trip_id
-- having tax >11;

-- SELECT trip_id, max(total_amount) as m
-- FROM Invoices
-- GROUP BY trip_id
-- having m > 56;

-- SELECT  trip_id, min(tax_amount) as tax
-- From Invoices
-- Group by trip_id
-- having tax < 7;

-- select vehicle_model, count(vehicle_model) as c
-- from vehicles
-- group by vehicle_model
-- having  c = 3 ;

-- SELECT user_id, count(dropoff_location) as c
-- FROM rides
-- GROUP BY user_id
-- having c > 1;

-- select code, max(discount) as m
-- from promo_codes
-- group by code
-- having  m > .3;





