# SCAR - (Software de Condomínio Adaptado a Residência)

## Telas e sua funcionalidades: 

### Tela Login
![Tela de Login](SCAR-TELAS/TelaLogin.png)
* Ao digitar cpf e senha e clicar em cadastrar será chamada o método de autenticação de login
* Caso o usuário seja Síndico ou Porteiro, e digitar cpf e senha corretos, eles prosseguirá
* Caso o Funcionário de outro departamento tente logar, irá aparecer uma mensagem dizendo: "ACESSO NEGADO"
* Conta tambmém com uma pequena função de ocultar ou vizualizar senha 


#### Mensagem de Bem-vindo
![BV](SCAR-TELAS/BV.png)
* Caso a autenticação de login dê certo, esta mensagem será exibida e o usuário será lançado para a Tela Home

### Tela Home
![Tela Home](SCAR-TELAS/TelaHome.png)
* Na Tela Home no código fonte possui uma função que consegue diferenciar o tipo de usuario, se é porteiro ou se é síndico, se for porteiro ele não terá acesso às telas de
Cadastro, caso ele seja síndico ele pode cadastrar Funcionários, Moradores e Unidades.
* A telaHome é estartada com a tela de Atividades aberta, na tela de Atividades, o Síndico cadastra ou excluir uma atividade e o Porteiro pode marcar a atividade como concluída e possui também a opção
de ver as atividades concluídas.
* Na TelaHome possui um icone de casa que ao navegar para outra tela e apertar no icone Home ele volte para a tela Home.
* Possui também na lateral esquerda 6 botões que levam para suas respectivas telas.
* Na parte inferior possui dois ícones: um de ajuda e outro de configurações.

#### Opções de Cadastro
![BV](SCAR-TELAS/Cadastro.png)
* Ao apertar no Cadastro ele Mostra as opções de cadastro disponíveis.


### Tela Cadastro de Funcionário
![Tela Home](SCAR-TELAS/TelaCadastroFunc.png)
* Em cadastro de Funcionário, ao preencher os campos e chegar no campo de departamento, terá as opções com os departamentos disponíveis, ao clicar em porteiro ou síndico ele tornará visível uma
label e um campo de texto que receberá a senha do funcionário e quando ele for cadastrado ele irá aparecer na tabela abaixo.


### Tela Cadastro de Morador
![Tela Home](SCAR-TELAS/TelaCadastroMorador.png)
* Na tela de Cadastro de Morador, o usuário preenche os campos e ele só pode ser registrado caso ele tenha uma casa, então existe uma tabela na parte inferior central que traz uma lista de casas
e o Morador será ligado a uma dessas casas quando o usuario preencher os campos clicar na tabela e apertar em cadastrar ele será cadastrado.
*Na parte superior fica duas opções: cadastrar e deletar esta está presente nas telas de funcionário, morador e unidade.

### Tela Cadastro de Unidade
![Tela Home](SCAR-TELAS/TelaCadastroUnidade.png)
* Nesta tela o usuario deverá preecher os campos 

### Tela Deletar
![Tela Home](SCAR-TELAS/TelaDeletarFunc.png)

### Opções de Relatório
![BV](SCAR-TELAS/Relatorio.png)

#### Exemplo de Relatório
![BV](SCAR-TELAS/RelatorioReserva.png)

### Opções de Rserva
![BV](SCAR-TELAS/reserva.png)

#### Tela de Fazer Reservas
![BV](SCAR-TELAS/TelaFzReserva.png)

### Tela em Desenvolvimento
![BV](SCAR-TELAS/TelaEmDev.png)
