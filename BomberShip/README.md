# Projeto `BomberShip`

# Descrição Resumida do Jogo

> É um jogo multiplayer em que o objetivo será derrotar o inimigo e fazer a maior pontuação.

# Equipe
* `Erica Yuri Nunes de Oliveira ` - `196486`
* `Henrique Akira Akagi` - `198741` 

# Vídeos do Projeto

## Vídeo da Prévia
[![Video Previa BomberShip](http://img.youtube.com/vi/sgqUdKl3V-0/0.jpg)](https://youtu.be/sgqUdKl3V-0)

# Slides do Projeto

## Slides da Prévia
[Slides Previa](https://drive.google.com/file/d/1fVwJ0_IudIibsqP890Q834rIGh3J3KBR/view?usp=sharing)

 

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto
   ![Diagrama Geral](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/VisaoGeral.png)

## Diagrama Geral de Componentes
 ![Diagrama Analise](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/Components.png)

## Componente `Mar`

> O Mar será responsável pelo 'tabuleiro' do jogo. Ele terá celulas e peças (como navio, armadilhas e bau do tesouro) 
![Mar](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/Mar%20component.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `marComponent.Mar`
Autores | `Erica e Henrique`
Interfaces | `IMarListener, IBuildMar`

### Interfaces

Interfaces associadas a esse componente:



## Componente `View`

> O View será responsável por criar as visualizações do tabuleiro e dos itens do jogo através das classes PlayerView e ItensView
![View](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/View%20component.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `viewComponent`
Autores | `Erica e Henrique`
Interfaces | `IMarVisual, IBuildView`

### Interfaces

Interfaces associadas a esse componente:


## Componente `Panel`

> O painel ficará responsável por exibir visualmente para o usuário e permitir que sejam criados os botoes, representados pelas celulas, para que o jogo inicie. 
![Painel](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/Panel%20component.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `panelComponent`
Autores | `Erica e Henrique`
Interfaces | `IVisual, IBuildPanel`

### Interfaces

Interfaces associadas a esse componente:


## Componente `Controle`

> O Controle irá executar as jogadas. Então a partir de um Listener dentro do mar(na peça) vamos ter o input de peças clicadas e movidas e atualizar o Mar. Teremos o InComponent e o OutComponent, responsáveis respectivamente por receber dados e enviar dados para o outro jogador.
![Conexao](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/Controle%20component.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `controleComponent`
Autores | `Erica e Henrique`
Interfaces | `IMarRefactor, ICommandOut, ItemRefactor`

### Interfaces

Interfaces associadas a esse componente:

## Componente `Conexao`


> A Conexao vai ser responsável através de socket por estar conectada com o outro player e receber e enviar dados para que o controle possa atuar no jogo 
![Conexao](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/ConexaoComponent.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `conexaoComponent`
Autores | `Erica e Henrique`
Interfaces | `ICommandIn, IBuildConexao`

### Interfaces

Interfaces associadas a esse componente:


## Componente `Montador`
![Montador](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/MontadorComponent.png)

> O montador vai ser o primeiro componente ativado e atuar uma unica vez; Ele será responsável por criar o jogo e os demais componentes. Ao ativar a conexão, também pegará o tabuleiro inimigo para deixar a tela setada; 

 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `montadorComponent`
Autores | `Erica e Henrique`
Interfaces | `-`
 
 

## Detalhamento das Interfaces

### Interface `IMarVisual`

`Interface responsável pela comunicação com mar e impressão das atualizações de jogo`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`


### Interface `IMarListener`

`Interface responsável por atualizar o controle das iterações no mar (cliques de botões)`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`


### Interface `IMarRefactor`

`Interface responsável por atualizar o mar com base nos parâmetros definidos pelo controle`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IBuildMar`

`Interface responsável por criar o mar`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IVisual`

`Interface responsável por enviar para o Panel todos os dados de cada Visualização e imprimir`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IBuildView`

`Interface responsável por criar os JPanel`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`


### Interface `ItemRefactor`

`Interface responsável por atualizar os itens na View com base nos comandos do controle`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `ICommandIn`

`Interface responsável por receber informações .`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `ICommandOut`

`Interface responsável por enviar informações .`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`


### Interface `IBuildControle`

`Interface responsável criar o Controle .`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IBuildConexao`

`Interface responsável criar a conexao .`

~~~
public interface IBuildConexao {
	
	public boolean conecta();
	public void iniciaServer();
	public void SetMar(String arq);
	public String getPlayer();
	public String getMarInimigo();
	public Conexao getThis();

}
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IBuildMar`

`Interface responsável criar o Mar.`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`

### Interface `IBuildPanel`

`Interface responsável criar o JPanel.`

~~~
<Interface em Java.>
~~~

Método | Objetivo
-------| --------
`<id do método em Java>` | `<objetivo do método e descrição dos parâmetros>`


 
# Plano de Exceções

## Diagrama da hierarquia de exceções 

Diagrama da conexão 
 ![Diagrama de Exceções na conexão](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/plano%20de%20Exception%20conexao.png)
 
Diagrama do mapa
 ![Diagrama de Exceções no mapa](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/plano%20de%20Exception%20map.png)

## Descrição das classes de exceção

Classe | Descrição
----- | -----
InvalidMap | Engloba todas as exceções do mapa
InvalidMapImport | erros importação do mapa
InvalidMapContent | erros de leitura do mapa
ConectionError | Engloba todas as exceções de conexao
InvalidEnemy | quando não foi possível localizar o inimigo (ele saiu da partida)
InvalidClient | quando não foi possível se conectar com o cliente
InvalidMove | quando a jogada é invalida
NullServer | quando o servidor ainda não existe
