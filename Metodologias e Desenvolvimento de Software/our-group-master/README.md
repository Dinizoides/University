# Relatório do Trabalho Final de Metodologias de Desenvolvimento de Software

# Parte 2: Implementação

### Ano Letivo 2019/2020

Docentes
- Prof. Pedro Patinho
- Prof. Pedro Salgueiro

Alunos
- João Abel         nº42941
- Dinis Matos       nº42738
- Fabrizzio Brandão nº43526

## Introdução

Para Metodologias e Desenvolvimento de Software, foi proposto numa [primeira parte do trabalho](https://gitlab.com/grupo-mds1/our-group/-/wikis/our-group.wiki/Relat%C3%B3rio-do-Trabalho-Final), aplicando os conhecimentos aprendidos ao longo do semestre, implementar um sistema automático de registo de presenças nas aulas.

Recorremos por isso, ao uso de diagramas de classe, use-case, sequência e atividade.

Para a segunda parte do trabalho, implementar em Java, um Sistema de Registo de Presenças, com base nos uses cases e diagramas de classes feitos anteriormente.

Este Sistema, consiste em duas aplicações (Leitor de Cartões e Gestão do Sistema).

## Desenvolvimento

### Decisões tomadas

* Em primeiro lugar decidimos realizar este projecto com o TDD. 

* Desta forma começamos por desenvolver os testes para as várias classes principais do programa, que se encontra no "Diagrama de Classe do Sistema Completo" [aqui](https://gitlab.com/grupo-mds1/our-group/-/wikis/our-group.wiki/Relat%C3%B3rio-do-Trabalho-Final).

* Assim foram criadas as respetivas issues iniciais no gitlab, e adicionadas outras ao longo do projecto.

* Também colocá-mos várias labels para organizar melhor as issues.

* Após o ínicio do projecto, e feitas algumas classes de teste, o projecto foi convertido para Maven e adicionadas as várias bibliotecas do JUnit, Hamcrest e JSON, assim como as dependencias necessárias.

* Decidimos optar por desenvolver em primeiro lugar a aplicação 1 - Leitor de Cartões.

* Por razões práticas, alteramos a estrutura de dados que tinhamos desenvolvido visto ser pedido um programa mais simples, e passar a ter apenas uma aula e um docente.

* Criamos e editamos também novas bibliotecas de JSON (mdadosMDS, Presencas) assim como alteramos as bibliotecas originais fornecidas na plataforma Moodle.

* No Leitor de Cartões, os valores da aula podem ser alterados. 

* Na Gestão do Sistema, optamos por um programa de tipo terminal (sem GUI). 

* Decidimos criar uma classe Main que permite ao utilizador escolher que aplicação quer usar.


## Conclusão

O trabalho foi realizado com sucesso.

A implementação das classes e dos respetivos diagramas foram realizadas assim como os testes de JUnit.

Realizar primeiro os testes foi benéfico no sentido de já ter uma ideia do que iriamos necessitar na classe original.

Foi possível aplicar o TDD e testar como é trabalhar com continuous integration e fazer alguns merges no projecto.