# Java e refatoração: melhorando códigos com boas práticas

## Aula 1: Refatoração

- Aprendemos a extrair código em métodos, com o intuito de melhorar a legibilidade do nosso código, facilitando assim sua manutenção;
- Entendemos o problema do código duplicado e como resolvê-lo para evitar inconsistências no código, caso haja alteração em um ponto do código duplicado e no outro não;
- Vimos que o ideal para resolver o código duplicado é aplicar a reutilização de código, em que o código fica presente em apenas um local e referenciá-lo ao utilizá-lo. Dessa forma, toda manutenção será feita em apenas um local.

A aplicação será integrada com uma API externa, que será a responsável por salvar pets e abrigos da aplicação console, assim como retorná-los quando fizermos a requisição através da aplicação console. Essa API está incluída no formato .jar no nosso projeto que vamos utilizar para o curso. E para testar a aplicação console precisamos iniciar o arquivo .jar. Para isso, podemos usar o seguinte comando:

```
java -jar api.jar
```

## Aula 2: SOLID

- Aprendemos que o S do acrônimo SOLID significa Single Responsability Principle, em português, princípio da responsabilidade única, ou seja, uma classe deve ter um, e somente um, motivo para mudar;
- Separamos nosso código em classes para que ficassem coesas e com apenas uma responsabilidade;
- Criamos classes de configurações para reaproveitá-las nas classes de serviço, evitando assim código duplicado.

## Aula 3: Criando domínios

- Aprendemos a criar classes de domínio, que são classes que representam "coisas" do mundo real;
- Conhecemos a biblioteca Jackson, que auxilia na serialização e deserialização de objetos fornecendo recursos para transformar um objeto Json em um objeto Java e vice-versa;
- Testamos nossa aplicação, após todas as refatorações, para garantir que a mesma continua funcional.

## Aula 4: Teste Automatizados

- Aprendemos o que são testes automatizados e o quanto eles podem auxiliar no feedback da aplicação, bem como na validação dos cenários;
- Criamos um teste de unidade, que valida o retorno do método listarAbrigo;
- Conhecemos a biblioteca junit, que fornece recursos para criarmos testes de unidade e a biblioteca mockito, que fornece recursos para simulação de objetos.

## Aula 5: Padrões de Projeto

- Aprendemos o padrão Command, que visa encapsular uma solicitação como um objeto, o que lhe permite parametrizar outros objetos com diferentes solicitações.
- Melhoramos nosso código usando o switch expressions, permitindo trocar os if’s e else’s que tornavam a classe AdopetConsoleApplication difícil de ler.

### Diferença entre Command e Strategy

Durante a refatoração do nosso código, utilizamos o padrão de projeto Command. Este padrão é comumente confundido com outro padrão de projeto: o Strategy. Apesar de ambos serem padrões comportamentais, eles possuem diferenças e servem para casos diferentes. Que tal conhecer as diferenças e pós e contras de cada um?

Tanto o padrão de projeto Command quanto o Strategy são padrões comportamentais, isso significa que eles se concentram na forma como as classes interagem e delegam responsabilidades. No entanto, eles têm propósitos diferentes e são usados em contextos diferentes.

#### Padrão Command

O padrão Command é usado para encapsular uma solicitação como um objeto, permitindo parametrizar clientes com diferentes solicitações, enfileirar solicitações, registrar o log de solicitações e até mesmo desfazer as operações. Ele separa o remetente (quem faz a solicitação) do receptor (quem executa a ação), permitindo flexibilidade em adicionar novos comandos e mantendo o acoplamento baixo.

#### Exemplo em Java:

Um sistema de controle remoto possui botões que podem executar diferentes ações, como ligar a TV, ligar o som, aumentar o volume etc. Cada botão é um comando encapsulado.

```
interface Command {
    void execute();
}

class TVOnCommand implements Command {
    private TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}
```

#### Padrão Strategy:

O padrão Strategy é usado para definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Isso permite que os algoritmos variem independentemente dos clientes que os usam. Ele é particularmente útil quando você tem várias estratégias ou formas de realizar uma tarefa e deseja escolher dinamicamente a estratégia correta.

#### Exemplo em Java:

Um sistema de pagamentos aceita diferentes formas de pagamento, como cartão de crédito, PayPal, transferência bancária etc. Cada forma de pagamento é uma estratégia encapsulada.

```

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(int amount) {
        // Process credit card payment
    }
}
```

#### Propósitos

- O Command é usado para encapsular solicitações como objetos, permitindo controle e gerenciamento de ações.
- O Strategy é usado para definir algoritmos intercambiáveis, permitindo escolher a estratégia certa em tempo de execução.

#### Usos

- Command é frequentemente usado para históricos, filas de comandos e operações desfazer/refazer.

- Strategy é usado para escolher entre diferentes algoritmos ou estratégias de execução.

#### Flexibilidade

- Command tem flexibilidade na execução de ações e histórico de comandos.

- Strategy tem flexibilidade na escolha de algoritmos.

Ambos os padrões podem ser úteis em diferentes situações e contextos. A escolha entre eles depende da natureza do problema que você está resolvendo e das necessidades do seu design.
