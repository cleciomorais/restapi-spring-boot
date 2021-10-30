
CREATE TABLE `pessoa` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `NOME` varchar(50) NOT NULL,
  `SOBRENOME` varchar(50) DEFAULT NULL,
  `ENDERECO` varchar(100) DEFAULT NULL,
  `GENERO` varchar(1) DEFAULT NULL,
  `dtnascimento` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
)