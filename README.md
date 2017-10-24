# SpringMVCHibernateSecurity
# Reference(guide, tutorial link)
CREATE TABLE EMPLOYEE(
    id INT NOT NULL auto_increment, 
    name VARCHAR(50) NOT NULL,
    salary DOUBLE NOT NULL,
    ssn VARCHAR(30) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);
