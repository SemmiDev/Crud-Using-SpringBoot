CREATE DATABASE IF NOT EXISTS akademik;
USE akademik;

CREATE TABLE IF NOT EXISTS mahasiswa(
nim VARCHAR(10) NOT NULL,
name VARCHAR(50) NOT NULL,
ipk FLOAT(4,2) NOT NULL,
jurusan VARCHAR(25) NOT NULL,
PRIMARY KEY(nim)
)ENGINE=InnoDB;

 INSERT INTO mahasiswa VALUES('075410099','Sammidev',4.00,'Teknologi Informasi');
 INSERT INTO mahasiswa VALUES('075410100','Adisti',4.00,'Pendidikan Bahasa Inggris');
 INSERT INTO mahasiswa VALUES('075410101','Soeltan',3.99,'Teknik Sipil');
