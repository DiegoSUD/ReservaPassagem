
Feature: Eu como usuario final
					Quero acessar o site 
					Para fazer uma reserva de um ticket 


  Scenario Outline: Fazendo reserva pelo site
  
    Given que acesso o site
    And digito o nome de usuario "<userName>"
    And digito o a senha de usuario "<password>"
    And clico no botao SingIn
    And seleciono a cidade de origem
    And seleciono a cidade de destino
    And seleciono a data
    And seleciono a classe
    And seleciono a quantidade de passageiros
    And clico no botao continuar
    And seleciono o voo
    And clico no botao continuar
    And infomo o nome "<name>" e sobrenome "<sobrenome>"
	  And preencho o numero do cartao
	  And preencho o nome do passageiro "<name>" , nome do meio "<nomeMeio>" e ultimo nome "<sobrenome>"
	  Then realizo a compra segura
	  
	  Examples: 
	  |userName| password | name | nomeMeio |sobrenome  |
	  | mercury| mercury  |Diego | Pereira  |Barroso    |
	  
	  