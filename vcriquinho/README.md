# VCRiquinho
![Diagrama de classes](docs/diagrama.png)

Justificativa para as escolhas de design:
- Todos os clientes possuem atributos em comum (tais como nome e e-mail), portanto faz sentido que haja uma classe Cliente, da qual herdem os clientes PF e PJs, com suas especificidades respectivas; similar para os diferentes modelos de conta, que herdam de uma classe Conta, da qual recebem o atributo "saldo", e os diferentes produtos;
- Tanto a conta CDI quanto a de Investimento Automático possuem alguma forma de rendimento e taxa de serviço aplicados, calculados a partir de certa definição particular; portanto, faz sentido ambas implementarem um método de cálculo de saldo, realizado a partir de uma interface;
- Cada cliente pode ter 1 ou mais contas; inicialmente pensou-se em fazer o cliente possuir uma lista de contas que seria impedida de estar vazia, mas por questões de praticidade, fez-se a conta referenciar o cliente ao qual pertence.