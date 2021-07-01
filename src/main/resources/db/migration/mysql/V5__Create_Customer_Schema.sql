CREATE TABLE IF NOT EXISTS customer
(
    customerId
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    nameCustomer
    VARCHAR
(
    30
) NOT NULL,
    email VARCHAR
(
    30
) NOT NULL,
    drivingExperience INT

    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;