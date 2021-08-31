-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 09-Dez-2016 às 21:03
-- Versão do servidor: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projeto1.1`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `agen`
--
CREATE TABLE `agen` (
`nome_prof` varchar(45)
,`iddisciplinas` int(10)
,`disciplina` varchar(45)
,`iddias` int(10)
,`dias` varchar(45)
,`dia2` varchar(45)
,`horario` varchar(45)
,`assunto` varchar(45)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `agendamento`
--

CREATE TABLE `agendamento` (
  `idagendamento` int(10) NOT NULL,
  `alunos` int(10) NOT NULL,
  `data_agen` date NOT NULL,
  `dias` int(10) NOT NULL,
  `assuntos` int(10) NOT NULL,
  `soma` int(10) DEFAULT NULL,
  `situacao` varchar(20) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `descricao` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `agendamento`
--

INSERT INTO `agendamento` (`idagendamento`, `alunos`, `data_agen`, `dias`, `assuntos`, `soma`, `situacao`, `status`, `descricao`) VALUES
(1, 1, '2016-11-08', 1, 3, 1, 'Concluído', '1º Atendimento', 'O aluno sanou a dúvida.'),
(2, 2, '2016-11-14', 3, 6, 1, 'Concluído', '1º Atendimento', 'O aluno tirou dúvidas sobre estruturas de decisão e repetição.'),
(3, 3, '2016-11-25', 4, 7, 1, 'Pendente', 'Aguardando confirmação', NULL),
(4, 4, '2016-11-16', 6, 13, 1, 'Pendente', 'Aguardando confirmação', NULL),
(5, 5, '2016-11-25', 2, 3, 1, 'Pendente', 'Aguardando confirmação', NULL),
(6, 6, '2016-11-08', 1, 4, 1, 'Concluído', '1º Atendimento', 'O aluno sanou sua dúvida.'),
(7, 7, '2016-11-15', 5, 14, 1, 'Concluído', 'Retorno', 'O aluno retornou ao plantão com a mesma dúvida sobre inferência estatística.'),
(8, 8, '2016-11-24', 6, 12, 1, 'Pendente', 'Aguardando confirmação', NULL),
(9, 11, '2016-11-25', 1, 1, 1, 'Concluído', 'Retorno', 'A aluna tirou suas dúvidas sobre Case.'),
(11, 13, '2016-11-29', 4, 10, 1, 'Pendente', 'Aguardando confirmação', NULL),
(12, 14, '2016-12-12', 1, 1, 1, 'Pendente', 'Adiado', 'não foi possivel efetuar o atendimento no dia 06/12/2016'),
(13, 1, '2016-11-21', 3, 5, 1, 'Pendente', 'Aguardando confirmação', NULL),
(14, 7, '2016-11-17', 2, 2, 1, 'Pendente', 'Aguardando confirmação', NULL),
(15, 13, '2016-12-07', 3, 8, 1, 'Pendente', 'Aguardando confirmação', NULL),
(16, 13, '2016-12-05', 3, 11, 1, 'Pendente', 'Aguardando confirmação', NULL),
(17, 1, '2016-11-23', 3, 8, 1, 'Pendente', 'Aguardando confirmação', NULL),
(19, 2, '2016-12-07', 2, 2, 1, 'Pendente', 'Aguardando confirmação', NULL),
(20, 5, '2016-12-09', 2, 4, 1, 'Concluído', '1º Atendimento', 'A aluna tirou dúvidas sobre seu TCC'),
(44, 7, '2016-12-06', 5, 14, 1, 'Pendente', 'Aguardando confirmação', NULL),
(45, 3, '2016-11-24', 6, 12, 1, 'Pendente', 'Aguardando confirmação', NULL),
(46, 4, '2016-11-30', 2, 1, 1, 'Pendente', 'Aguardando confirmação', NULL),
(47, 1, '2016-11-28', 1, 3, 1, 'Pendente', 'Adiado', 'Remarcado para o dia 28/11/2016 pois não houve tempo para cumprir todos os atendimentos.\nAtt: Professor Ednan.'),
(49, 3, '2016-11-28', 3, 8, 1, 'Pendente', 'Aguardando confirmação', NULL),
(50, 16, '2016-11-16', 2, 2, 1, 'Pendente', 'Aguardando confirmação', NULL),
(52, 13, '2016-11-22', 1, 2, 1, 'Pendente', 'Aguardando confirmação', NULL),
(54, 8, '2016-11-22', 5, 12, 1, 'Concluído', '1º Atendimento', 'A aluna tirou dúvidas sobre sistema de equações.'),
(76, 1, '2016-12-12', 3, 6, 1, 'Cancelado', 'Aguardando confirmação', NULL),
(83, 1, '2016-12-20', 1, 2, 1, 'Pendente', 'Confirmado', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunos`
--

CREATE TABLE `alunos` (
  `idalunos` int(10) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `matricula` varchar(45) NOT NULL,
  `periodo` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `curso` varchar(45) NOT NULL,
  `data_nascimento` varchar(8) DEFAULT NULL,
  `sum` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `alunos`
--

INSERT INTO `alunos` (`idalunos`, `nome`, `matricula`, `periodo`, `email`, `curso`, `data_nascimento`, `sum`) VALUES
(1, 'Gustavo Gomes Farias', '002016862', '4º período', 'gustavogfarias142@gmail.com', 'Sistemas de Informação', '21031997', 1),
(2, 'Rodrigo Siqueira', '001234510', '1º período', 'rodrigos@gmail.com', 'Sistemas de Informação', '08051992', 1),
(3, 'Rafael Souza', '001234511', '1º período', 'rafael123@hotmail.com', 'Sistemas de Informação', '13071995', 1),
(4, 'Souza Santos', '001234512', '2º período', 'Santossouza@gmail.com', 'Sistemas de Informação', '20041987', 1),
(5, 'Rafaela Silva', '001234513', '4º período', 'rafaelass@gmail.com', 'Arquitetura', '04111990', 1),
(6, 'Sergio Mourinho', '001234514', '4º período', 'Mourinho80@gmail.com', 'Arquitetura', '09011981', 1),
(7, 'Rafisa Surita', '001234515', '3º período', 'Suritarafisa@gmail.com', 'Engenharia Civil', '19071992', 1),
(8, 'Maria dos Santos', '001234516', '8º período', 'mariasantos123@gmail.com', 'Engenharia de Produção', '14061976', 1),
(9, 'Marcos Assunção', '001234517', '6º período', 'AssuncaoMarcos@hotmail.com', 'Direito', '03101974', 1),
(10, 'Matheus Oliveira', '001234518', '6º período', 'Matoliveira20@gmail.com', 'Direito', '21021993', 1),
(11, 'Rafaela Matarazi', '001234519', '1º período', 'rmatarazi123@gmail.com', 'Direito', '04121990', 1),
(12, 'Paola dos Santos', '001234520', '5º período', 'Santospaola444@gmail.com', 'Direito', '19081975', 1),
(13, 'Emanuel Angelo', '001234521', '2º período', 'emanuelangelo@outlook.com.br', 'Sistemas de Informação', '14051989', 1),
(14, 'Lourival Afonso', '001234522', '7º período', 'afonso12345@hotmail.com', 'Educação Física', '18091972', 1),
(15, 'Eduardo Emerson', '002016493', '4ºperíodo', 'edu_mirador@hotmail.com', 'Sistemas de Informação', '08121988', 1),
(16, 'Sarah Morais', '00217821', '4ºperíodo', 'MoraisSarah142@gmail.com', 'Direito', '05041995', 1),
(17, 'Milton Júnior', '002016970', '3ºperíodo', 'annaoliveira305@gmail.com', 'Sistemas de Informação', '28061989', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `assuntos`
--

CREATE TABLE `assuntos` (
  `idassuntos` int(10) NOT NULL,
  `assunto` varchar(45) DEFAULT NULL,
  `disciplinas` int(10) NOT NULL,
  `sum` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `assuntos`
--

INSERT INTO `assuntos` (`idassuntos`, `assunto`, `disciplinas`, `sum`) VALUES
(1, 'Case', 1, 1),
(2, 'Paper', 1, 1),
(3, 'Artigo', 1, 1),
(4, 'TCC', 1, 1),
(5, 'Introdução à programação', 2, 1),
(6, 'Algoritmos e programação', 2, 1),
(7, 'Programação estruturada', 2, 1),
(8, 'Programação orientada à objeto', 2, 1),
(10, 'Estrutura de dados', 2, 1),
(11, 'Projeto Prático', 2, 1),
(12, 'Matemática Básica', 3, 1),
(13, 'Cálculo Diferencial', 3, 1),
(14, 'Estatística', 3, 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `coordenacao`
--
CREATE TABLE `coordenacao` (
`idprofessor` int(10)
,`nome_prof` varchar(45)
,`disciplina` varchar(45)
,`dias` varchar(45)
,`dia2` varchar(45)
,`horario` varchar(45)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `dias`
--

CREATE TABLE `dias` (
  `iddias` int(10) NOT NULL,
  `horario` varchar(45) DEFAULT NULL,
  `dias` varchar(45) DEFAULT NULL,
  `dia2` varchar(45) DEFAULT NULL,
  `professor` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `dias`
--

INSERT INTO `dias` (`iddias`, `horario`, `dias`, `dia2`, `professor`) VALUES
(1, '18:00 às 19:00', 'Segunda', 'Terça', 2),
(2, '18:00 às 19:00', 'Terça', 'Quinta', 3),
(3, '17:30 às 18:00', 'Segunda', 'Quarta', 4),
(4, '17:00 às 18:00', 'Quarta', 'Sexta', 5),
(5, '20:30 às 21:00', 'Quinta', 'Sexta', 6),
(6, '18:20 às 19:00', 'Sexta', 'Terça', 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplinas`
--

CREATE TABLE `disciplinas` (
  `iddisciplinas` int(10) NOT NULL,
  `disciplina` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `disciplinas`
--

INSERT INTO `disciplinas` (`iddisciplinas`, `disciplina`) VALUES
(1, 'Metodologia'),
(2, 'Programação'),
(3, 'Matemática');

-- --------------------------------------------------------

--
-- Stand-in structure for view `grafico`
--
CREATE TABLE `grafico` (
`curso` varchar(45)
,`assunto` varchar(45)
,`soma` int(10)
,`situacao` varchar(20)
,`dias` varchar(45)
,`nome_prof` varchar(45)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `prof`
--
CREATE TABLE `prof` (
`nome` varchar(45)
,`matricula` varchar(45)
,`curso` varchar(45)
,`periodo` varchar(45)
,`data_agen` date
,`idagendamento` int(10)
,`assunto` varchar(45)
,`horario` varchar(45)
,`idprofessor` int(10)
,`nome_prof` varchar(45)
,`status` varchar(50)
,`situacao` varchar(20)
,`descricao` varchar(500)
);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `idprofessor` int(10) NOT NULL,
  `nome_prof` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `disciplinas` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`idprofessor`, `nome_prof`, `login`, `senha`, `disciplinas`) VALUES
(1, 'Coordenadora Marineis', 'Marineis@undb.edu.br', '123456', NULL),
(2, 'Ednan', 'Ednan@undb.edu.br', '123456', 1),
(3, 'César', 'César@undb.edu.br', '123456', 1),
(4, 'Arikleyton', 'Arikleyton@undb.edu.br', '123456', 2),
(5, 'Alessandro', 'Alessandro@undb.edu.br', '123456', 2),
(6, 'Sandolini', 'Sandolini@undb.edu.br', '123456', 3),
(7, 'Wilson', 'Wilson@undb.edu.br', '123456', 3);

-- --------------------------------------------------------

--
-- Structure for view `agen`
--
DROP TABLE IF EXISTS `agen`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `agen`  AS  select `professor`.`nome_prof` AS `nome_prof`,`disciplinas`.`iddisciplinas` AS `iddisciplinas`,`disciplinas`.`disciplina` AS `disciplina`,`dias`.`iddias` AS `iddias`,`dias`.`dias` AS `dias`,`dias`.`dia2` AS `dia2`,`dias`.`horario` AS `horario`,`assuntos`.`assunto` AS `assunto` from (((`professor` join `disciplinas` on((`professor`.`disciplinas` = `disciplinas`.`iddisciplinas`))) join `dias` on((`professor`.`idprofessor` = `dias`.`professor`))) join `assuntos` on((`disciplinas`.`iddisciplinas` = `assuntos`.`disciplinas`))) ;

-- --------------------------------------------------------

--
-- Structure for view `coordenacao`
--
DROP TABLE IF EXISTS `coordenacao`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `coordenacao`  AS  select `professor`.`idprofessor` AS `idprofessor`,`professor`.`nome_prof` AS `nome_prof`,`disciplinas`.`disciplina` AS `disciplina`,`dias`.`dias` AS `dias`,`dias`.`dia2` AS `dia2`,`dias`.`horario` AS `horario` from ((`professor` join `disciplinas` on((`professor`.`disciplinas` = `disciplinas`.`iddisciplinas`))) join `dias` on((`professor`.`idprofessor` = `dias`.`professor`))) ;

-- --------------------------------------------------------

--
-- Structure for view `grafico`
--
DROP TABLE IF EXISTS `grafico`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `grafico`  AS  select `alunos`.`curso` AS `curso`,`assuntos`.`assunto` AS `assunto`,`agendamento`.`soma` AS `soma`,`agendamento`.`situacao` AS `situacao`,`dias`.`dias` AS `dias`,`professor`.`nome_prof` AS `nome_prof` from ((((`alunos` join `agendamento` on((`agendamento`.`alunos` = `alunos`.`idalunos`))) join `assuntos` on((`agendamento`.`assuntos` = `assuntos`.`idassuntos`))) join `dias` on((`agendamento`.`dias` = `dias`.`iddias`))) join `professor` on((`dias`.`professor` = `professor`.`idprofessor`))) ;

-- --------------------------------------------------------

--
-- Structure for view `prof`
--
DROP TABLE IF EXISTS `prof`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `prof`  AS  select `alunos`.`nome` AS `nome`,`alunos`.`matricula` AS `matricula`,`alunos`.`curso` AS `curso`,`alunos`.`periodo` AS `periodo`,`agendamento`.`data_agen` AS `data_agen`,`agendamento`.`idagendamento` AS `idagendamento`,`assuntos`.`assunto` AS `assunto`,`dias`.`horario` AS `horario`,`professor`.`idprofessor` AS `idprofessor`,`professor`.`nome_prof` AS `nome_prof`,`agendamento`.`status` AS `status`,`agendamento`.`situacao` AS `situacao`,`agendamento`.`descricao` AS `descricao` from ((((`alunos` join `agendamento` on((`agendamento`.`alunos` = `alunos`.`idalunos`))) join `assuntos` on((`agendamento`.`assuntos` = `assuntos`.`idassuntos`))) join `dias` on((`agendamento`.`dias` = `dias`.`iddias`))) join `professor` on((`dias`.`professor` = `professor`.`idprofessor`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agendamento`
--
ALTER TABLE `agendamento`
  ADD PRIMARY KEY (`idagendamento`),
  ADD KEY `fk_agendamento_alunos1_idx` (`alunos`),
  ADD KEY `fk_agendamento_dias1_idx` (`dias`),
  ADD KEY `fk_agendamento_assuntos1_idx` (`assuntos`);

--
-- Indexes for table `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`idalunos`);

--
-- Indexes for table `assuntos`
--
ALTER TABLE `assuntos`
  ADD PRIMARY KEY (`idassuntos`),
  ADD KEY `fk_duvidas_disciplinas1_idx` (`disciplinas`);

--
-- Indexes for table `dias`
--
ALTER TABLE `dias`
  ADD PRIMARY KEY (`iddias`),
  ADD KEY `fk_dias_professor2_idx` (`professor`);

--
-- Indexes for table `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD PRIMARY KEY (`iddisciplinas`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`idprofessor`),
  ADD KEY `fk_professor_disciplinas1_idx` (`disciplinas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agendamento`
--
ALTER TABLE `agendamento`
  MODIFY `idagendamento` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;
--
-- AUTO_INCREMENT for table `alunos`
--
ALTER TABLE `alunos`
  MODIFY `idalunos` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `assuntos`
--
ALTER TABLE `assuntos`
  MODIFY `idassuntos` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `dias`
--
ALTER TABLE `dias`
  MODIFY `iddias` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `disciplinas`
--
ALTER TABLE `disciplinas`
  MODIFY `iddisciplinas` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `idprofessor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `agendamento`
--
ALTER TABLE `agendamento`
  ADD CONSTRAINT `fk_agendamento_alunos1` FOREIGN KEY (`alunos`) REFERENCES `alunos` (`idalunos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_agendamento_assuntos1` FOREIGN KEY (`assuntos`) REFERENCES `assuntos` (`idassuntos`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_agendamento_dias1` FOREIGN KEY (`dias`) REFERENCES `dias` (`iddias`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `assuntos`
--
ALTER TABLE `assuntos`
  ADD CONSTRAINT `fk_duvidas_disciplinas1` FOREIGN KEY (`disciplinas`) REFERENCES `disciplinas` (`iddisciplinas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `dias`
--
ALTER TABLE `dias`
  ADD CONSTRAINT `fk_dias_professor2` FOREIGN KEY (`professor`) REFERENCES `professor` (`idprofessor`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `fk_professor_disciplinas1` FOREIGN KEY (`disciplinas`) REFERENCES `disciplinas` (`iddisciplinas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
