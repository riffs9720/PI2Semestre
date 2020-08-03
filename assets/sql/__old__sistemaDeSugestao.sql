-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sistemaDeSugestao
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sistemaDeSugestao` ;

-- -----------------------------------------------------
-- Schema sistemaDeSugestao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistemaDeSugestao` DEFAULT CHARACTER SET utf8 ;
USE `sistemaDeSugestao` ;

-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`tipoPerfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`tipoPerfil` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`tipoPerfil` (
  `idTipoPerfil` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoPerfil`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`tipoFiltro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`tipoFiltro` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`tipoFiltro` (
  `idTipoFiltro` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoFiltro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`filtro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`filtro` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`filtro` (
  `idFiltro` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(30) NOT NULL,
  `tipoPerfil_idTipoPerfil` INT NOT NULL,
  `tipoFiltro_idTipoFiltro` INT NOT NULL,
  PRIMARY KEY (`idFiltro`),
  INDEX `fk_filtro_tipoPerfil1_idx` (`tipoPerfil_idTipoPerfil` ASC),
  INDEX `fk_filtro_tipoFiltro1_idx` (`tipoFiltro_idTipoFiltro` ASC),
  CONSTRAINT `fk_filtro_tipoPerfil1`
    FOREIGN KEY (`tipoPerfil_idTipoPerfil`)
    REFERENCES `sistemaDeSugestao`.`tipoPerfil` (`idTipoPerfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_filtro_tipoFiltro1`
    FOREIGN KEY (`tipoFiltro_idTipoFiltro`)
    REFERENCES `sistemaDeSugestao`.`tipoFiltro` (`idTipoFiltro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`tipoIdentificacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`tipoIdentificacao` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`tipoIdentificacao` (
  `idTipoIdentificacao` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoIdentificacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`usuarioCadastro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`usuarioCadastro` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`usuarioCadastro` (
  `idUsuarioCadastro` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `dtNascimento` DATE NOT NULL,
  `genero` CHAR(1) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `numeroIdentificacao` INT NOT NULL,
  `dtCadastro` DATE NOT NULL,
  `tipoPerfil_id_tipoPerfil` INT NOT NULL,
  `tipoIdentificacao_id_tipoIdentificacao` INT NOT NULL,
  PRIMARY KEY (`idUsuarioCadastro`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  INDEX `fk_usuarioCadastro_tipoPerfil1_idx` (`tipoPerfil_id_tipoPerfil` ASC),
  INDEX `fk_usuarioCadastro_tipoIdentificacao1_idx` (`tipoIdentificacao_id_tipoIdentificacao` ASC),
  CONSTRAINT `fk_usuarioCadastro_tipoPerfil1`
    FOREIGN KEY (`tipoPerfil_id_tipoPerfil`)
    REFERENCES `sistemaDeSugestao`.`tipoPerfil` (`idTipoPerfil`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarioCadastro_tipoIdentificacao1`
    FOREIGN KEY (`tipoIdentificacao_id_tipoIdentificacao`)
    REFERENCES `sistemaDeSugestao`.`tipoIdentificacao` (`idTipoIdentificacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`usuarioAcesso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`usuarioAcesso` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`usuarioAcesso` (
  `idUsuarioAcesso` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `senha` CHAR(32) NOT NULL,
  `usuarioCadastro_idUsuarioCadastro` INT NOT NULL,
  PRIMARY KEY (`idUsuarioAcesso`),
  INDEX `fk_usuarioAcesso_usuarioCadastro_idx` (`usuarioCadastro_idUsuarioCadastro` ASC),
  CONSTRAINT `fk_usuarioAcesso_usuarioCadastro`
    FOREIGN KEY (`usuarioCadastro_idUsuarioCadastro`)
    REFERENCES `sistemaDeSugestao`.`usuarioCadastro` (`idUsuarioCadastro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`status` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`status` (
  `idStatus` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idStatus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`ocorrencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`ocorrencia` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`ocorrencia` (
  `idOcorrencia` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `nomeUsuario` VARCHAR(45) NOT NULL,
  `assunto` VARCHAR(45) NOT NULL,
  `conteudo` TEXT NOT NULL,
  `dtOcorrencia` DATE NOT NULL,
  `usuarioAcesso_idUsuarioAcesso` INT NOT NULL,
  `status_idStatus` INT NOT NULL,
  PRIMARY KEY (`idOcorrencia`),
  INDEX `fk_ocorrencia_usuarioAcesso1_idx` (`usuarioAcesso_idUsuarioAcesso` ASC),
  INDEX `fk_ocorrencia_status1_idx` (`status_idStatus` ASC),
  CONSTRAINT `fk_ocorrencia_usuarioAcesso1`
    FOREIGN KEY (`usuarioAcesso_idUsuarioAcesso`)
    REFERENCES `sistemaDeSugestao`.`usuarioAcesso` (`idUsuarioAcesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ocorrencia_status1`
    FOREIGN KEY (`status_idStatus`)
    REFERENCES `sistemaDeSugestao`.`status` (`idStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`departamento` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`departamento` (
  `idDepartamento` INT NOT NULL AUTO_INCREMENT,
  `nomeDepartamento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idDepartamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`sugestao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`sugestao` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`sugestao` (
  `idSugestao` INT NOT NULL AUTO_INCREMENT,
  `conteudo` VARCHAR(45) NOT NULL,
  `dtSugestao` DATETIME NOT NULL,
  `assunto` VARCHAR(45) NOT NULL,
  `usuarioAcesso_id_usuarioAcesso` INT NOT NULL,
  `departamento_idDepartamento` INT NOT NULL,
  `tipoSugestao` VARCHAR(20) NOT NULL,
  `status_idStatus` INT NOT NULL,
  PRIMARY KEY (`idSugestao`),
  INDEX `fk_sugestao_usuarioAcesso1_idx` (`usuarioAcesso_id_usuarioAcesso` ASC),
  INDEX `fk_sugestao_departamento1_idx` (`departamento_idDepartamento` ASC),
  INDEX `fk_sugestao_status1_idx` (`status_idStatus` ASC),
  CONSTRAINT `fk_sugestao_usuarioAcesso1`
    FOREIGN KEY (`usuarioAcesso_id_usuarioAcesso`)
    REFERENCES `sistemaDeSugestao`.`usuarioAcesso` (`idUsuarioAcesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sugestao_departamento1`
    FOREIGN KEY (`departamento_idDepartamento`)
    REFERENCES `sistemaDeSugestao`.`departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_sugestao_status1`
    FOREIGN KEY (`status_idStatus`)
    REFERENCES `sistemaDeSugestao`.`status` (`idStatus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`avaliacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`avaliacao` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`avaliacao` (
  `idAvaliacao` INT NOT NULL AUTO_INCREMENT,
  `resposta` TEXT NOT NULL,
  `aprovado` TINYINT(1) NOT NULL,
  `dtAvaliacao` DATETIME NOT NULL,
  `sugestao_idSugestao` INT NOT NULL,
  `usuarioAcesso_idUsuarioAcesso` INT NOT NULL,
  PRIMARY KEY (`idAvaliacao`),
  INDEX `fk_avaliacao_sugestao1_idx` (`sugestao_idSugestao` ASC),
  INDEX `fk_avaliacao_usuarioAcesso1_idx` (`usuarioAcesso_idUsuarioAcesso` ASC),
  CONSTRAINT `fk_avaliacao_sugestao1`
    FOREIGN KEY (`sugestao_idSugestao`)
    REFERENCES `sistemaDeSugestao`.`sugestao` (`idSugestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_usuarioAcesso1`
    FOREIGN KEY (`usuarioAcesso_idUsuarioAcesso`)
    REFERENCES `sistemaDeSugestao`.`usuarioAcesso` (`idUsuarioAcesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`comentarioSugestao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`comentarioSugestao` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`comentarioSugestao` (
  `idComentarioSugestao` INT NOT NULL AUTO_INCREMENT,
  `conteudo` VARCHAR(255) NOT NULL,
  `dtComentario` DATETIME NOT NULL,
  `numeroCurtida` INT(10) NULL,
  `usuarioAcesso_idUsuarioAcesso` INT NOT NULL,
  `sugestao_idSugestao` INT NOT NULL,
  PRIMARY KEY (`idComentarioSugestao`),
  INDEX `fk_comentarioSugestao_usuarioAcesso1_idx` (`usuarioAcesso_idUsuarioAcesso` ASC),
  INDEX `fk_comentarioSugestao_sugestao1_idx` (`sugestao_idSugestao` ASC),
  CONSTRAINT `fk_comentarioSugestao_usuarioAcesso1`
    FOREIGN KEY (`usuarioAcesso_idUsuarioAcesso`)
    REFERENCES `sistemaDeSugestao`.`usuarioAcesso` (`idUsuarioAcesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_comentarioSugestao_sugestao1`
    FOREIGN KEY (`sugestao_idSugestao`)
    REFERENCES `sistemaDeSugestao`.`sugestao` (`idSugestao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemaDeSugestao`.`usuarioAcesso_has_departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemaDeSugestao`.`usuarioAcesso_has_departamento` ;

CREATE TABLE IF NOT EXISTS `sistemaDeSugestao`.`usuarioAcesso_has_departamento` (
  `usuarioAcesso_idUsuarioAcesso` INT NOT NULL,
  `departamento_idDepartamento` INT NOT NULL,
  PRIMARY KEY (`usuarioAcesso_idUsuarioAcesso`, `departamento_idDepartamento`),
  INDEX `fk_usuarioAcesso_has_departamento_departamento1_idx` (`departamento_idDepartamento` ASC),
  INDEX `fk_usuarioAcesso_has_departamento_usuarioAcesso1_idx` (`usuarioAcesso_idUsuarioAcesso` ASC),
  CONSTRAINT `fk_usuarioAcesso_has_departamento_usuarioAcesso1`
    FOREIGN KEY (`usuarioAcesso_idUsuarioAcesso`)
    REFERENCES `sistemaDeSugestao`.`usuarioAcesso` (`idUsuarioAcesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarioAcesso_has_departamento_departamento1`
    FOREIGN KEY (`departamento_idDepartamento`)
    REFERENCES `sistemaDeSugestao`.`departamento` (`idDepartamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
