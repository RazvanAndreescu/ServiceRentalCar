INSERT INTO rental (nameRental, internetDomain, contactAddress, owner)
values ("Rent The Best", "www.rentthebest.com", "Bd. Unirii, nr. 10, Bucuresti, Bucuresti", "Popescu George");

INSERT INTO branch (address, rentalId)
values ("Str. Ion Creanga, nr.1, Baia Mare, Maramures", 1),
       ("Bd. Nicolae Titulescu, nr. 35, Cluj-Napoca, Cluj", 1),
       ("Bd. Unirii, nr. 10, Bucuresti, Bucuresti", 1),
       ("Splaiul Independentei, nr. 36-46, Sectorul 5, Buceresti", 1);

INSERT INTO employee (nameEmployee, roleEmployee, branchId)
values ("Sabou Bogdan", "manager", 1),
       ("Rus Razvan", "employee", 1),
       ("Trenea Tudor", "employee", 1),

       ("Teleptean Bogdan", "manager", 2),
       ("Suciu Mihai", "employee", 2),
       ("Popescu Adela", "employee", 2),

       ("Andreescu Razvan", "manager", 3),
       ("Maria Ardelean", "employee", 3),
       ("Sorin Dumitrache", "employee", 3),

       ("Laurentiu Miu", "manager", 4),
       ("Cosmin Popovici", "employee", 4),
       ("Mirela Tudorache", "employee", 4),
       ("Ana-Maria Radu", "employee", 4),
       ("Stela Mihailescu", "employee", 4);

INSERT INTO car (model, transmission, bodyType, yearCar, status, price, branchId)
values ("Audi A4", "automatic", "sedan", "2018", "available", 30, 1),
       ("Volkswagen Passat", "manual", "wagon", "2020", "not available", 35, 1),
       ("Volkswagen Polo", "manual", "hatchback", "2016", "not available", 24, 1),
       ("Ford Fiesta", "manual", "hatchback", "2018", "not available", 24, 1),
       ("Lexus ", "automatic", "suv", "2018", "available", 40, 1),

       ("BMW 3 series", "automatic", "sedan", "2019", "available", 35, 2),
       ("Opel Insignia", "manual", "wagon", "2015", "available", 27, 2),
       ("Toyota Yaris", "manual", "hatchback", "2017", "available", 24, 2),
       ("Peugeot 207", "manual", "hatchback", "2017", "available", 24, 2),
       ("BMW X5", "automatic", "suv", "2019", "available", 40, 2),

       ("Mercedes C-class", "automatic", "sedan", "2017", "not available", 32, 3),
       ("Lexus LS", "automatic", "luxury", "2020", "available", 45, 3),
       ("Mercedes S-class", "automatic", "luxury", "2019", "not available", 50, 3),
       ("Audi A8", "automatic", "luxury", "2020", "available", 50, 3),
       ("Volvo XC90", "automatic", "suv", "2018", "available", 40, 3),

       ("Dacia 1410", "manual", "wagon", "2000", "not available", 10, 4),
       ("Dacia Logan", "manual", "wagon", "2008", "not available", 20, 4),
       ("Dacia Sandero", "manual", "hatchback", "2020", "not available", 30, 4),
       ("Dacia Duster", "manual", "suv", "2018", "available", 40, 4);

INSERT INTO customer (nameCustomer, email, drivingExperience)
values ("Marian Bitanescu", "m.bitanescu@yahoo.com", 3),
       ("Ioana Alexandrescu", "i.alexandrecu@yahoo.com", 1),
       ("George Buhnici", "g.buhnici@gmail.com", 2),
       ("Ligia Danci", "l.danci@gmail.com", 2),
       ("Daniel Timis", "d.tms@yahoo.com", 3),
       ("Delia Stetco", "d.stetco@gmail.com", 1),
       ("Mihaela Stan", "mihaelastan@yahoo.com", 4),
       ("Miruna Cosmescu", "cosmescumiruna@gmail.com", 3),
       ("Camelia Toader", "toadercamelia@gmail.com", 7),
       ("Teodor Manzu", "manzuteodor@yahoo.com", 6);

INSERT INTO reservation (startDate, endDate, price, branchId, customerId, carId)
values ('2020-1-8', '2020-1-10', 120, 1, 1, 15),
       ('2020-2-11', '2020-2-15', 200, 2, 2, 14),
       ('2020-3-3', '2020-3-12', 500, 3, 3, 12),
       ('2020-4-20', '2020-4-25', 144, 2, 4, 8),
       ('2020-5-16', '2020-5-25', 350, 2, 5, 3),
       ('2020-6-13', '2020-6-20', 240, 1, 6, 1),
       ('2020-7-15', '2020-7-18', 100, 4, 7, 16),
       ('2020-8-6', '2020-8-13', 120, 4, 8, 17),
       ('2020-9-21', '2020-9-29', 180, 4, 9, 18),
       ('2020-10-5', '2020-10-11', 210, 4, 10, 19);
