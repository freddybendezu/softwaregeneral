CREATE TABLE CLIENTE(
  CLIENTE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  NOMBRE VARCHAR(64),
  APELLIDO VARCHAR(64),
  EMAIL VARCHAR(64),
  DIRECCION VARCHAR(64),
  PAIS VARCHAR(32),
  DEPARTAMENTO VARCHAR(12),
  TELEFONO VARCHAR(24)
);