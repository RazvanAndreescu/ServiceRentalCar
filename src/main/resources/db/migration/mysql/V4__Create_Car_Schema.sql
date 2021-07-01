CREATE TABLE IF NOT EXISTS car
(
    carId
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    model
    VARCHAR
(
    30
) NOT NULL,
    transmission VARCHAR
(
    30
) NOT NULL,
    bodyType VARCHAR
(
    30
) NOT NULL,
    yearCar VARCHAR
(
    30
) NOT NULL,
    status VARCHAR
(
    30
) NOT NULL,
    price INT,
    branchId INT,
    FOREIGN KEY
(
    branchId
) REFERENCES branch
(
    branchId
)

    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;