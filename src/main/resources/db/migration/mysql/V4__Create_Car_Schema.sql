CREATE TABLE IF NOT EXISTS car
(
    carId INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR (30),
    transmission VARCHAR (30),
    bodyType VARCHAR (30)
    yearCar VARCHAR (30),
    status VARCHAR (30)
    price INT,
    branchId INT,
    FOREIGN KEY(branchId) REFERENCES branch(branchId)

    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;