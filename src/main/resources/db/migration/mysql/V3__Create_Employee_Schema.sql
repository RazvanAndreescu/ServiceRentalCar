CREATE TABLE IF NOT EXISTS employee
(
    employeeId
    INT
    PRIMARY
    KEY
    AUTO_INCREMENT,
    nameEmployee
    VARCHAR
(
    30
) NOT NULL,
    roleEmployee VARCHAR
(
    30
) NOT NULL,
    branchId INT,
    FOREIGN KEY
(
    branchId
) REFERENCES branch
(
    branchId
)

    ) ENGINE=InnoDB DEFAULT CHARSET=UTF8;