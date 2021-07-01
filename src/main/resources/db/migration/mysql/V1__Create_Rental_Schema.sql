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
)NOT NULL,
    contactAddress VARCHAR
(
    50
)NOT NULL,
    owner VARCHAR
(
    30
)NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;