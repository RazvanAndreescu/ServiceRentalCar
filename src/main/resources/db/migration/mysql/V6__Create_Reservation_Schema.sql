CREATE TABLE IF NOT EXISTS reservation
(
    reservationId INT PRIMARY KEY AUTO_INCREMENT,

    startDate DATE,
    endDate DATE,
    price INT,
    branchId INT,
    FOREIGN KEY (branchId) REFERENCES branch(branchId),

    customerId INT ,
    FOREIGN KEY (customerId) REFERENCES customer(customerId),

    carId INT,
    FOREIGN KEY (carId) REFERENCES car(carId),

    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;