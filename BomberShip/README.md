# Projeto `BomberShip`

# Descrição Resumida do Jogo

> É um jogo multiplayer em que o objetivo será afundar todos os navios inimigos e obter a maior pontuação.

# Equipe
* `Erica Yuri Nunes de Oliveira ` - `196486`
* `Henrique Akira Akagi` - `198741` 

# Vídeos do Projeto

## Vídeo da Prévia
[![Video Previa BomberShip](http://img.youtube.com/vi/sgqUdKl3V-0/0.jpg)](https://youtu.be/sgqUdKl3V-0)

## Vídeo do jogo

# Slides do Projeto

## Slides da Prévia
[Slides Previa](https://drive.google.com/file/d/1fVwJ0_IudIibsqP890Q834rIGh3J3KBR/view?usp=sharing)

## Slides da Apresentação Final

## Relatório de Evolução
No processo de desenvolvimento do jogo, houve a necessidade de alterações na arquitetura inicial, assim como nas classes e interfaces utilizadas.
A arquitetura inicial do jogo é mostrada abaixo:

![arquitetura inicial](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/Components%20-%20inicial.png)

Ao repensar sobre as decisões que faziam mais sentido para o nosso projeto, compactamos alguns componentes e retiramos outros que não serviam o propósito até chegarmos na arquitetura final.

Nós decidimos abandonar a ideia inicial de níveis de jogo, com o componente montador implementando diferentes interfaces a cada nível. Decidimos passar o nível selecionado por meio da conexão e montar o nosso jogo, simplificando a arquitetura.

Uma das principais dificuldades do grupo nos primeiros laboratórios era a comunicação, que dificulta a progressão do projeto em ambiente remoto. Este problema foi resolvido com boas práticas de programação, comentários no código e commits menores e regulares.



# Link para os arquivos java
[Componentes](https://github.com/e196486/TimEca/tree/master/BomberShip/src/src)
 

# Documentação dos Componentes

# Diagramas

## Diagrama Geral do Projeto
   ![Diagrama Geral](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/VisaoGeral.png)

## Diagrama Geral de Componentes
Este é o diagrama compondo componentes do projeto BomberShip:

   ![Diagrama Analise](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/Components%20-%20final.png)

## Componente `Mar`

> O Mar será responsável pelo 'tabuleiro' do jogo. Ele terá celulas e peças (como navio, armadilhas e bau do tesouro) 
![Mar](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/Mar%20component.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `marComponent.Mar`
Autores | `Erica e Henrique`
Interfaces | `IMarVisual, IMarRefactor`

### Interfaces

Interfaces associadas a esse componente:

  ![InterfaceMar](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/InterfaceMar.png)


## Componente `View`

> O View será responsável por criar as visualizações do tabuleiro e dos itens do jogo através das classes PlayerView e ItensView
![View](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/View%20component.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `viewComponent`
Autores | `Erica e Henrique`
Interfaces | `IBuildView, IItemRefactor, ILogRefactor`

### Interfaces

Interfaces associadas a esse componente:

![InterfaceView](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/InterfaceView.png)
   

## Componente `Controle`

> O Controle irá executar as jogadas. Então a partir de um Listener dentro do mar(na peça) vamos ter o input de peças clicadas e movidas e atualizar o Mar. Teremos o InComponent e o OutComponent, responsáveis respectivamente por receber dados e enviar dados para o outro jogador.
![Conexao](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/Controle%20component.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `controleComponent`
Autores | `Erica e Henrique`
Interfaces | `IMarListener`

### Interfaces

Interfaces associadas a esse componente:

![InterfaceControle](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/InterfaceControle.png)

## Componente `Conexao`


> A Conexao vai ser responsável através de socket por estar conectada com o outro player e receber e enviar dados para que o controle possa atuar no jogo 

![Conexao](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/ConexaoComponent.png)
 
**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `conexaoComponent`
Autores | `Erica e Henrique`
Interfaces | `ICommandIn, ICommandOut`

### Interfaces

Interfaces associadas a esse componente:

![InterfaceConexao](https://github.com/e196486/TimEca/blob/master/BomberShip/assets/docs/InterfaceConexao.png)

## Detalhamento das Interfaces

### Interface `IMarVisual`

`Interface responsável pela comunicação com mar e impressão das atualizações de jogo`

~~~
public interface IMarVisual {

	public Mar getThis();
	public Component getcelulaMar(int coluna, int linha);

}
~~~

Método | Objetivo
-------| --------
`getThis()` | `Pega o objeto Mar para passar por parâmetro`
`getcelulaMar(int coluna, int linha)` | `Pega a celula referente a linha e coluna da visualização.`


### Interface `IMarListener`

`Interface responsável por atualizar o controle das iterações no mar (cliques de botões)`

~~~
public interface IMarListener {
	
	public void celulaAcionada(int i, int j) ;

}
~~~

Método | Objetivo
-------| --------
`celulaAcionada(int i, int j)` | `Pega a celula acionada e faz os movimentos necessários`


### Interface `IMarRefactor`

`Interface responsável por atualizar o mar com base nos parâmetros definidos pelo controle`

~~~
public interface IMarRefactor {

	public Celula getCelula(int i, int j);

}
~~~

Método | Objetivo
-------| --------
`getCelula(int i, int j)` | `Devolve a célula localizada nas coordenadas do parêmetro`


### Interface `IItemRefactor`

`Interface responsável por atualizar os itens na View com base nos comandos do controle`

~~~
public interface IItemRefactor {
	
	void setPontos(int Pontos);
	void setMunicao(int Municao);
	void setDicas(int Dicas);
	void setDicaEnable();
	boolean isBtnDicas();
	void setDicaUnclicked();
	
}
~~~

Método | Objetivo
-------| --------
`setPontos(int Pontos)` | `atualiza a quantidade de pontos para o int 'Pontos'`
`setMunicao(int Municao)` | `atualiza a quantidade de munição para o int 'Municao'`
`setDicas(int Dicas)` | `atualiza a quantidade de Dicas para o int 'Dicas'`
`setDicaEnable()` | `faz com que o botão de dicas funcione`
`isBtnDicas()` | `retorna se o campo dica é um botão`
`setDicaUnclicked()` | `faz com que o botão dica não esteja clicado.`
 

### Interface `IItemRefactor`

`Interface responsável por atualizar os itens na View com base nos comandos do controle`

~~~
public interface IItemRefactor {
	
	void setPontos(int Pontos);
	void setMunicao(int Municao);
	void setDicas(int Dicas);
	void setDicaEnable();
	boolean isBtnDicas();
	void setDicaUnclicked();
	
}
~~~

Método | Objetivo
-------| --------
`setPontos(int Pontos)` | `atualiza a quantidade de pontos para o int 'Pontos'`
`setMunicao(int Municao)` | `atualiza a quantidade de munição para o int 'Municao'`
`setDicas(int Dicas)` | `atualiza a quantidade de Dicas para o int 'Dicas'`
`setDicaEnable()` | `faz com que o botão de dicas funcione`
`isBtnDicas()` | `retorna se o campo dica é um botão`
`setDicaUnclicked()` | `faz com que o botão dica não esteja clicado.`

### Interface `ICommandIn`

`Interface responsável por receber informações .`

~~~
public interface ICommandIn {

	void aguardaServerRequest();
	Object getPlayer();
	String recebeDados();
	boolean getConexaoAceita();
	void enviaDados(String string);

}
~~~

Método | Objetivo
-------| --------
`aguardaServerRequest()` | `Aguarda a conexão do Client para dar andamento na jogada, caso não tenha conexão aceita`
`getPlayer()` | `Pega o player`
`recebeDados()` | `recebe os dados do outro player`
`getConexaoAceita()` | `recebe o boolean conexãoAceita, que verifica se existe uma conexão`
`enviaDados(String string)` | `O enviaDados manda a Jogada 'string' para o outro Player`

### Interface `ICommandOut`

`Interface responsável por enviar informações .`

~~~
public interface ICommandOut {

	void enviaDados(String string);

}
~~~

Método | Objetivo
-------| --------
`enviaDados(String string)` | `O enviaDados manda a Jogada 'string' para o outro Player`

 
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
