# Sistema de mergulho 

Projeto desenvolvido para a disciplina de sistemas de informações gerenciais visando entregar uma solução para uma empresa hipotética que realiza reparos subaquáticos.

Utilizei o Maven como gerenciador de dependências, JavaFX para a criação das interfaces gráficas, PostgreSQL como banco de dados para persistência de dados, JPA (Java Persistence API) e Hibernate para a camada de persistência, JUnit Jupiter para a realização de testes unitários e DBeaver como gerenciador de banco de dados. 
O projeto segue a arquitetura MVC.

Este sistema tem como objetivo o gerenciamento de mergulhos, registrando os relatórios de operação de mergulho (ROM) que são preenchidos diariamente por um supervisor para vários mergulhos realizados em um dia em uma determinada plataforma.
Existe também o checklist de cada mergulho, onde o supervisor deve confirmar que todos os itens estão de acordo para que o mergulho ocorra, evitando acidentes e imprevistos.

Uma ROM contém vários mergulhos, e um mergulho pertence a uma ROM.
Um mergulho contém um checklist e um checklist contém um mergulho.

Na tela inicial, é possível visualizar todas as ROMs já criadas, possibilitando alterar a ROM (inclusive seus mergulhos e checklists), excluir ou criar uma nova ROM.
É possível filtrar as ROMs por datas, facilitando a visualização e modificação caso necessário.

Caso selecione inclusão de nova ROM será direcionado para a tela de mergulho, onde deve preencher todas as informações do mergulho (inclusive o checklist desse mergulho) e também da ROM.
Para facilitar o trabalho do supervisor e garantir assertividade, o sistema calcula automáticamente o tempo de fundo do mergulhador ao inserir o tempo de descida e subida, e também cálculos para converter de PSI para BAR e Kgf/cm³ (quilograma-força por centímetro quadrado).
Com as informações da profundidade do mergulho, volume e pressão dos cilindros o sistema calcula também a autonomia do cilindro.


