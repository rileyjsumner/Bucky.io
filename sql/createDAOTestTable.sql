CREATE DATABASE IF NOT EXISTS buckyio;
USE buckyio;
DROP TABLE IF EXISTS test;
CREATE TABLE IF NOT EXISTS test (
	id INT NOT NULL auto_increment,
    stringTest VARCHAR(100),
    integerTest INT,
    doubleTest DOUBLE,
    longTest LONG,
    booleanTest BOOLEAN,
    floatTest FLOAT,
    shortTest SMALLINT,
    objectTest REAL,
    blobTest BLOB,
    bigDecimalTest DOUBLE PRECISION,
    dateTest DATE,
    timeTest TIME,
    timestampTest TIMESTAMP,
    urlTest CHAR,
    
    PRIMARY KEY(id)
);