Feature: Eu como usuario final
  			Quero acessar o site 
  			Para fazer uma reserva de um ticket

  Scenario Outline: Fazendo reserva pelo site usando massa do Excel
    Given que acesso o site
    And digito o nome de usuario "<userName>"
    And digito o a senha de usuario "<password>"
    And clico no botao SingIn
    And seleciono One Way
    And seleciono a departing from
    And seleciono arriving in
    And seleciono a data on e returning
    And seleciono a class
    And seleciono a quantidade de passengers
    And clico no botao continuar
    And seleciono o voos ida e volta
    And clico no botao continuar
    And infomo o nome "<name>" e sobrenome "<sobrenome>"
    And preencho o numero do cartao
    And preencho o nome do passageiro "<name>" , nome do meio "<nomeMeio>" e ultimo nome "<sobrenome>"
    Then realizo a compra segura do tickt de reserva
 

    Examples: 
      | userName | password | name  | nomeMeio | sobrenome |
      | mercury  | mercury  | Diego | Pereira  | Barroso   |
