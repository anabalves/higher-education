# Estruturas de Dados: Terceira Lista De Exercícios 
> Descrição dos exercícios propostos:

1.  Uma fila é um tipo especial de lista com política que restringe a manipulação dos elementos. A política da fila é First In First Out (FIFO), o primeiro elemento adicionado será removido primeiro. Implemente uma classe denominada Fila com esta política.

Exemplo:

Fila Vazia

![Fila Vazia](https://i.imgur.com/4hEjRCS.png)

Adiciona um elemento (20)  
Qual é o índice do início da fila? _____________  
Qual é o elemento do início da fila? ___________  
Qual é o índice do final da fila? ______________  
Qual é o elemento do final da fila? ____________  

Adiciona um elemento (10)

![Fila Com Elementos](https://i.imgur.com/NJ5NUHt.png)

Qual é o índice do início da fila? _____________  
Qual é o elemento do início da fila? ___________  
Qual é o índice do final da fila? ______________  
Qual é o elemento do final da fila? ____________  

2.  Implemente uma Pilha para o problema apresentado no Exercício 1. Implemente também uma classe de teste que possui uma instância da classe Fila e uma instância da classe Pilha. Cada elemento removido da Fila deve ser adicionado no topo da Pilha. Cada elemento removido da Pilha deve ser adicionado no final da Fila.

  

3.  A classe Livro possuí atributos que são criados na classe concreta e acessados por meio dos métodos públicos da classe (getters e setters). Dado o cenário implemente uma Pilha em que:

-   Sejam criados em uma classe os atributos título do tipo de dado String e quantidade de exemplares do tipo de dado inteiro. Estes atributos devem ser acessados por meio de seus métodos públicos (getters e setters). Esta classe deve receber em seu método construtor a quantidade de elementos que a Pilha terá em sua capacidade.
-   Implemente uma classe que terá os métodos de push e pop, para realizar as operações de adicionar e remover os elementos da Pilha. Esta classe deverá conter um vetor estático chamado Livro dados[]
-   Crie um método que receba os dados de entrada para a Pilha.
-   Crie um método que realize a exibição dos elementos da Pilha.
-   Realize o teste de mesa para os cenários de inclusão e exclusão da Pilha.

  

4.  A classe Livro possuí os seguintes atributos que são criados na classe concreta e acessados por meio dos métodos públicos da classe (getters e setters). Dado o cenário implemente uma Fila em que:

-   Sejam criados em uma classe os atributos título do tipo de dado String e quantidade de exemplares do tipo de dado inteiro. Estes atributos devem ser acessados por meio de seus métodos públicos (getters e setters). Esta classe deve receber em seu método construtor a quantidade de elementos que a Fila terá em sua capacidade.
-   Implemente uma classe que terá os métodos de enqueue e dequeue, para realizar as operações de adicionar e remover os elementos da Fila. Esta classe deverá conter um vetor estático chamado Livro dados[]
-   Crie um método que receba os dados de entrada para a Fila.
-   Crie um método que realize a exibição dos elementos da Fila.
-   Realize o teste de mesa para os cenários de inclusão e exclusão da Fila.
