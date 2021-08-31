# Projeto-Pratico-4periodo
SISTEMA DE GERENCIAMENTO DO APOIO METODOLÓGICO AO DISCENTE
##
SISTEMA DE GERENCIAMENTO DO APOIO METODOLÓGICO AO DISCENTE 

Anna Christinne Oliveira 
Eduardo Emerson da Silva Rocha²
Emanuel Angêlo da Silva |Almeida²
Gustavo Gomes Farias²
Lourival Costa Soares Júnior² 
Arikleyton de Oliveira Ferreira 

1 	INTRODUÇÃO

O Programa de Apoio Metodológico ao Discente da UNDB tem como principal objetivo melhorar o desempenho dos alunos na elaboração dos trabalhos acadêmicos semestrais, os Cases e Papers. O programa dispõe de professores especializados em cada uma das disciplinas que abrangem o desenvolvimento de um desses trabalhos, com horários fixos durante a semana. De forma simples, todo o processo funciona com o agendamento por parte do aluno, a partir do preenchimento de formulários/fichas, com informações básicas do atendimento (disciplina, dúvida, etc..). Ao fim de cada mês um relatório é gerado, com o intuito de evidenciar as principais dificuldades, as dúvidas mais frequentes e todas as informações relevantes a cerca do corpo estudantil. Todo esse processo, desde o agendamento até o relatório mensal, é feito de forma manual, o que torna extremamente lento a obtenção de qualquer relatório.
Com isso, é fácil identificar a necessidade pela automação de todo o processo realizado pelo programa, o que torna o programa mais rápido e ainda mais eficiente. Para isso, é necessário o desenvolvimento de um sistema que transforme todo o processo em algo automático, que realize desde o agendamento de atendimento até o relatório mensal de cada disciplina.


2 	OBJETIVOS

 2.1 Objetivo Geral

●	Automatizar o sistema de plantão tira dúvidas, onde haja uma rapidez, prática e facilidade ao agendar uma reunião com os professores e ao realizar relatórios referentes a esses agendamentos e encontros.

2.2 Objetivos Específicos

●	Sistematizar o plantão de apoio aos alunos
●	Facilitar o agendamento das reuniões
●	Automatizar o processo de preenchimento de fichas
●	Organizar o processo de registros das reuniões
●	Agilizar o processo de geração de relatórios finais

3 	METODOLOGIA

Será apresentado um paper do tipo relatório. A metodologia usada para gerir as tarefas e organizar a equipe será Scrum, com Sprints de duas semanas de duração. A metodologia usada para escrever o artigo será a pesquisa bibliográfica, com base em artigos científicos e livros, sendo informado o tema “Análise e Desenvolvimento de um software para apoio metodológico ao discente”. Será então elaborado um plano provisório de assunto, identificação das fontes, leitura do material e, então, será feita a construção lógica do trabalho e redação do artigo científico.
Para uma maior compreensão do problema relacionado ao desenvolvimento do sistema, são realizadas entrevistas e/ou reuniões com os professores para entender o seu real trabalho com o plantão de tira dúvidas para, assim, atendermos todas as necessidades dos professores para um melhor desenvolvimento dos seus plantões com os alunos. 
A ferramenta utilizada para gerenciamento das tarefas, a partir dos métodos do Scrum, será o Trello, ferramenta bastante utilizada por desenvolvedores. Ela auxilia, por meio de tabelas e colunas, na definição de metas, divisão de tarefas para alcançá-las, tal como a delimitação de tempo para resolução de cada uma delas.
Com relação ao planejamento, além do Trello, utilizamos um cronograma de atividades (para um maior controle das tarefas executadas ou que ainda serão executadas), onde é anexado a atividade, o responsável, a data e o status.  
Para o desenvolvimento do sistema, usaremos:
●	Eclipe: é uma IDE de desenvolvimento Java, onde será utilizado para elaborar todo o sistema;
●	Java fx Scene Builder: para criar as telas em fxml; 
○	FXML é um XML baseado linguagem de marcação de interface de usuário criado por Oracle Corporation para definir a interface de usuário de um JavaFX aplicação.
●	CSS: design das cores do sistema;
○	é uma linguagem de folhas de estilo utilizada para definir a apresentação de documentos escritos em uma linguagem de marcação, como HTML ou XML. O seu principal benefício é a separação entre o formato e o conteúdo de um documento.
●	MySql: é o sistema de gerenciamento de banco de dados que vai ser usado para o armazenamento dos dados. 

4 	FUNDAMENTAÇÃO TEÓRICA

Durante muito tempo o desenvolvimento de softwares seguia um modelo mais clássico denominado Modelo de Cascata. Loeser (2006) define que, nesse molde de desenvolvimento, o projeto passa por cinco etapas - análise, design, documentação, codificação e testes - antes de ser entregue o produto final ao cliente, diminuindo a morosidade do processo. Neste modelo, o cliente é uma parte importante no processo e sua participação é ativa. Mesmo que não esteja presente fisicamente, é essencial que ele participe do projeto, a fim de garantir seu sucesso. É responsabilidade do cliente, priorizar as funcionalidades que serão implementadas em cada um dos pedaços de software e eventualmente escolher aquelas que não serão priorizadas. Seu feedback constante alimenta o planejamento do projeto e a definição de atividades pela equipe.
Porém esse modelo prejudica a obtenção de respostas rápidas às exigências de mercado por parte da empresa, causando baixas taxas de sucesso nas entregas de softwares desenvolvidos. Por esse motivo decidimos utilizar um modelo de desenvolvimento alternativo para solucionar o problema apresentado, chamado Scrum.
Segundo Pressman (2006), o Scrum é um modelo de processo ágil que foi desenvolvido por Jeff Sutherland e por sua equipe no início da década de 90. Silva (2010) informa que o Scrum foi desenvolvido originalmente para ser implementado em equipes de desenvolvimento de software mas pode ser utilizado por qualquer empresa que necessite implementar processos de gerenciamento de projetos. 
O Scrum é um framework, ou seja, é um conjunto de práticas que torna tudo visível, ele não define o que fazer em toda circunstância. Logo, o Scrum deixa muitas decisões a critério da equipe porque acredita que a equipe sabe como melhor resolver um determinado problema, apresentado assim como quais práticas ela esta madura o suficiente para adotar.
Existem seis principais papeis no Scrum, que tem tarefas e finalidades especificas durante o processo e suas práticas:
●	Scrum Master: É um novo gerente introduzido ao Scrum. É responsável por garantir que o projeto seja realizado de acordo com as práticas, valores e regras do Scrum, e que ele avance conforme o planejado.
●	Product Owner: É oficialmente responsável pelo projeto, pelo gerenciamento, controle e por tornar visível a lista de Product Backlog. Ele é selecionado pelo Scrum Master, cliente e gerente.
●	Scrum Team: É o time do projeto que tem a autoridade para decidir as ações necessárias e organizá-las em ordem para atingir os objetivos de cada Sprint. O time, de forma organizada, controla como as tarefas devem ser executadas, sendo que não deve existir interferência externa, sendo um dos principais papeis do Scrum Master blindar o time de qualquer desvio do objetivo traçado.
●	Cliente: Participa nas tarefas relacionadas aos itens do Product Backlog para o sistema ser desenvolvido ou aprimorado.
●	Usuário: É responsável por utilizar o produto quando este estiver em produção.
●	Gerente: É responsável pela decisão final, juntamente com as normas e convenções a serem seguidas no projeto. O gerente também participa da definição das metas e dos requisitos.

No Scrum o projeto é dividido em ciclos periódicos chamados Sprints. Cada Sprint varia entre uma semana a um mês, e representa um volume de esforço pré-definido dentro do qual um grupo de atividades deverá ser executado, e seu produto final será as funcionalidades que o cliente deseja implementar em um software são registradas em um Product Backlog, definido antes do início do projeto através de técnicas especiais de levantamento e registro de requisitos. Cada funcionalidade é estimada (esforço e prazo) e, em função da quantidade de profissionais envolvidos no projeto, este é dividido em Sprints (duração de 2 a 4 semanas).
No começo de cada Sprint é realizado um Sprint Planning Meeting (reunião de planejamento da Sprint), no qual o Product Owner define prioridades dentro do Product Backlog e a equipe seleciona as atividades que ela será capaz de implementar durante o Sprint sendo iniciado. As tarefas definidas para cada Sprint são realocadas do Product Backlog para um Sprint Backlog. Diariamente é realizada pela equipe uma breve reunião (Daily Scrum), com não mais que 15 minutos de duração, observando o progresso usando um gráfico chamado Sprint Burndown. O objetivo é cada integrante informar os avanços e dificuldades que estiverem impedindo alguma etapa do processo e priorizar as tarefas do dia corrente.
Ao fim de cada Sprint, a equipe passa pela Sprint Review Meeting, onde a equipe de desenvolvimento demonstra o produto gerado na Sprint e valida se o objetivo foi atingido ou não. Logo em seguida, é feita uma reunião de retrospectiva (Sprint Retrospective) para demonstrar as lições aprendidas e se os membros do time já planejam as atividades da próxima Sprint, reiniciando o ciclo.
Os papéis foram divididos entre os membros da equipe, ocorrendo a rotação de Scrum Master a cada duas semanas. A equipe decidiu por focar nas atividades com da data de entrega mais próxima, como documentação e prototipação, decidindo deixar a programação para a última etapa.

5 	EXECUÇÃO DA SOLUÇÃO

5.1 Descrição do Sistema




5.2 Levantamento de Requisitos

Após conversas com os professores de plantão, foram levantados os requisitos a seguir para que sejam satisfeitas suas as necessidades e sanar seus problemas.

5.1.1	Requisitos Funcionais

●	Cadastrar, alterar e remover usuários - Os usuários cadastrados realizam a ação de cadastrar novo usuário.
●	Alterar usuários – Os usuários cadastrados realizam a ação de alterar informações do usuário.
●	Remover usuários – Os usuários cadastrados realizam a função de remover usuário.
●	Realizar o agendamento do plantão - Os alunos realizam a ação de agendar um plantão tira-dúvidas; 
●	Documentar as dúvidas - Os usuários cadastrados documentam todas as dúvidas do aluno para deixar registrado para um possível relatório;
●	Pesquisar documento - Os usuários cadastrados pesquisam um ou um grupo de documentos existentes para obter informações;
●	Visualizar o documento individualmente - Os usuários cadastrados visualizam informações sobre determinado atendimento;
●	Criar formulários – Os usuários cadastrados obtêm formulários onde possam atender sua necessidade. 

5.1.2	Requisitos Não-Funcionais

●	O sistema será construído utilizando o paradigma de orientação à objeto, devendo ser implementado em Java;
●	O sistema será integrado a um banco de dados, devendo ser usado um banco MYSQL;
●	Todos os relatórios fornecidos pelo sistema devem seguir o padrão de relatórios da instituição;
●	 As ações no sistema devem ser realizadas somente por usuários cadastrados com permissão para realizá-las;
●	O sistema deverá funcionar em máquinas desktop de configuração básica.

5.1.3	Requisitos Normativos

●	Conhecimento sobre desenvolvimento de projetos;
●	Conhecimento sobre Programação Orientada a Objetos utilizando Java;
●	Conhecimento sobre linguagem MYSQL para banco de dados;
●	Adequação ao prazo.

6	PROTÓTIPOS DE INTERFACES
•	INTERFACES INICIAIS
Apresentaremos a seguir os protótipos das interfaces desenvolvidas para o sistema, assim como uma breve descrição de suas funções e resultados de suas validações. 

6.1	Tela inicial


Esta é a tela inicial do sistema, onde possibilitará a seleção de uma das três vertentes: 
•	Agendamento;
•	Login do professor;
•	Login do coordenador;


6.2	Agendamento


A Tela acima representa o espaço do agendamento do aluno, onde poderão inserir seus dados relacionados ao curso para agendar o encontro com um dos professores do plantão tira-dúvidas. Os campos necessários para o agendamento são: Nome, número da matrícula, curso, período, data do agendamento, dúvida predominante e o professor disponível.

6.3	Login do professor/coordenador












Esta tela é a de login do professor e coordenador que terão como principal função, restringir o nível de acesso a determinado usuário, ou seja, para prosseguir, será necessário o login e a senha de um dos professores ou do coordenador.

6.4	Tela do professor


Após a inserção do login e senha de um dos professores corretamente, exibirá está tela do professo, onde mostrará todos os agendamentos marcados nos dias em que estão disponíveis. Esta tela terá a função de informar o professor o número de agendamentos marcados em um determinado período de tempo, e possibilitar a geração de um relatório as informações do agendamento.










6.5	Tela do coordenador












Após inserir o login e a senha do coordenador, o sistema irá exibir esta tela, que é o ambiente do coordenador onde será exibido a porcentagem de dúvidas mais frequentes a partir do número de agendamentos realizados podendo ser filtrado por curso e período. Esta tela tem função principalmente de oferecer informações mais refinadas ao coordenador, para informar de forma intuitiva, em qual ponto é a fonte de dúvidas.

6.6	Tela do coordenador (tabela de relatórios gerados)












Após clicar no botão “Exibir relatórios” na tela anterior, o sistema se direcionará para esta tela, que exibirá todos os relatórios feitos que poderá ser filtrado por professor, garantindo assim, um maior controle do número de atendimentos realizados.

•	INTERFACES FINAIS
- Tela inicial
		
	Tela que dá acesso a quatro possiblidades:
•	Agendamentos;
•	Professor/Coordenador;
•	Acesse o site;
•	Ajuda.





- Agendamento

	Tela que tem acesso ao login do aluno já cadastrado, onde ao logar, é encaminhado para agendar seu atendimento.













7	MODELAGEM DOS DADOS (DER)

A partir da análise de requisitos realizada anteriormente, desenvolvemos o Diagrama Entidade-Relacionamento.

 












Após início do projeto sentiu-se a necessidade de atualizar o DER. Desenvolvemos então, uma nova versão para o mesmo.

 

8 	UML
9	 PRODUTO FINAL
9.1 Descrição do Produto

O produto final construído pela equipe foi um sistema para automatizar o processo de plantão tira-dúvidas em uma instituição. Simplificando, agilizando e tornando mais seguro o controle deste processo.

9.2 Aplicabilidade do Produto

O produto pode ser usado por qualquer instituição que tenha como objetivo sanar as dúvidas dos alunos de forma automatizada, e também, obter relatórios dos atendimentos realizados pelos professores.


9.3 Público-alvo

O público-alvo são instituições que buscam ferramentas para agilizar o processo de ajudar o aluno em determinada dúvida, tendo como suporte um sistema totalmente voltado para suas necessidades.

9.4 Aspectos Sociais

Com a automatização do plantão tira-dúvidas em uma instituição, a comunidade se beneficiará da agilidade no processo de sanar dúvidas dos alunos, pois assim que um atendimento for realizado, a coordenadora possui a competência de extrair relatório dos atendimentos, afim de realizar um controle de todos os processos realizados.

10 	CONCLUSÃO







11 	REFERÊNCIAS

DEVMEDIA. Engenharia de Software 2 - Técnicas para Levantamento de Requisitos.
Disponível:&lt;http://www.devmedia.com.br/engenharia-de- software-2- tecnicas-para-
levantamento-de- requisitos/9151&gt;. Acesso em: 27/09/2016

GIL, Antônio Carlos. Como elaborar projeto de pesquisa. São Paulo: Atlas, 2010.

PROFISSIONAIS TI. Levantamento de Requisitos: Você sabe o que é?. Disponível em:
&lt;http://www.profissionaisti.com.br/2011/06/levantamento-de- requisitos-voce- sabe-o- que-e/&gt;. Acesso em: 27/09/2016
