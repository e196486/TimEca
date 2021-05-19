# Lab06 - O Mundo de Wumpus
## Arquivos Java do jogo
- Adicionar o caminho do arquivo .csv nos argumentos

[lab06](https://github.com/e196486/TimEca/tree/master/lab06/src/mc322/lab06)
## Destaques de Arquitetura
### Confronto do Herói
		
		...

			insereComponente(heroi);
			room[heroi.linha][heroi.coluna].atualizaChar();
			
			String[] resultadoConfronto = room[linhaTarget][colunaTarget].confronto(status);
			
			status.Confronto(resultadoConfronto);
			

		}

A caverna entende os confrontos do herói quando este se movimenta (encapsulamento).
Se adicionarmos um componente extra na sala, o código permanece o mesmo pois o confronto não precisa saber quais componentes estão na sala.
