CREATE TABLE IF NOT EXISTS rental
(
    rentalId
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    nameRental
    VARCHAR
(
    30
),
    internetDomain VARCHAR
(
    30
),
    contactAddress VARCHAR
(
    50
),
    owner VARCHAR
(
    30
)
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;