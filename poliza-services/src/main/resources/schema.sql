CREATE TABLE POLIZA(
  POLIZA_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  VEHICULO_ID BIGINT NOT NULL,
  CLIENTE_ID BIGINT NOT NULL,
  FECHA DATE
);