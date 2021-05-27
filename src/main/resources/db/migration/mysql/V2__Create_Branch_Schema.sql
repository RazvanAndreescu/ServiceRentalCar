CREATE TABLE IF NOT EXISTS branch
(
    branchId
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,

    address
    VARCHAR
(
    30
),
    rentalId INT,
    FOREIGN KEY
(
    rentalId
) REFERENCES rental
(
    rentalId
)
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;