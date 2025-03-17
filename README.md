# Projeto Fintech Fiap

Este projeto foi desenvolvido como parte de um trabalho acadêmico na FIAP (Faculdade de Informação e Administração Paulista), com o objetivo de simular um sistema de gerenciamento de transações financeiras. A aplicação é um sistema básico de uma fintech, permitindo o gerenciamento de usuários, registros de transações, autenticação de login e geração de extratos bancários.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **IntelliJ IDEA**: Ambiente de desenvolvimento integrado (IDE) utilizado para o desenvolvimento do projeto.
- **Git**: Controle de versão utilizado para o versionamento do código-fonte.

## Funcionalidades

- **Cadastro de Usuários**: Permite o registro de usuários, validando a duplicação de e-mails.
- **Autenticação de Login**: Sistema simples de login via e-mail.
- **Processamento de Transações**: Gerencia transações financeiras, registrando logs de cada operação.
- **Geração de Extratos Bancários**: Permite a geração de extratos bancários com base nas transações realizadas em um período.
- **Registro de Logs de Transações**: Cada transação é registrada com informações detalhadas, como status, valor e data/hora.

## Intuito do Projeto

Este projeto foi desenvolvido com o objetivo de:

- **Simular um sistema financeiro básico** de uma fintech, com funcionalidades essenciais como cadastro de usuários, processamento de transações e geração de extratos bancários.
- **Trabalho acadêmico da FIAP**, com foco em conceitos de programação orientada a objetos (POO) e desenvolvimento de sistemas financeiros.

## Como Clonar e Executar o Projeto

### Pré-requisitos

- **Java 21** ou superior instalado em sua máquina.
- **IntelliJ IDEA** ou outra IDE de sua preferência (recomenda-se o IntelliJ).
- **Git** instalado para clonar o repositório.

### Passos para Clonar o Repositório

1. Abra o terminal ou prompt de comando.
2. Navegue até o diretório onde deseja clonar o repositório.
3. Execute o seguinte comando para clonar o repositório:

```bash
git clone https://github.com/G-shiy/Fintech.git
```

### Como Executar no IntelliJ IDEA

1. **Importar o projeto**:

   - Abra o IntelliJ IDEA.
   - Selecione **"Open"** e navegue até o diretório onde o repositório foi clonado.
   - Selecione a pasta do projeto e clique em **"OK"** para abrir o projeto.
2. **Configurar o JDK**:

   - Verifique se o **Java 21** ou superior está configurado no IntelliJ IDEA.
   - Para configurar o JDK, vá até **File > Project Structure > Project** e selecione o JDK adequado.
3. **Executar o Projeto**:

   - Após abrir o projeto, localize a classe principal (`Main` ou outra classe com o método `main()`).
   - Clique com o botão direito na classe e selecione **"Run"** para executar o projeto.

### Como Usar

1. **Cadastro de Usuário**:  
   Ao rodar a aplicação, será solicitado o cadastro de um novo usuário, com informações como nome, e-mail, CPF, telefone e endereço.

2. **Autenticação**:  
   Após o cadastro, você pode realizar o login utilizando o e-mail registrado. O sistema não requer senha (para fins acadêmicos, recomendamos aprimorar a segurança).

3. **Processamento de Transações**:  
   O sistema permite registrar transações financeiras. Cada transação será registrada com um status (PENDING, COMPLETED, FAILED, CANCELED).

4. **Geração de Extratos**:  
   Após registrar transações, você pode gerar extratos bancários para visualizar o histórico de transações.


---

## Estrutura do Projeto

O projeto é organizado em várias classes principais, com funcionalidades como cadastro de usuários, processamento de transações, autenticação e geração de extratos. Confira abaixo a estrutura geral das principais classes:

- **User**: Representa um usuário do sistema.
- **TransactionLog**: Registra o log das transações realizadas.
- **TransactionService**: Gerencia o processamento de transações. (workingOn)
- **Login**: Gerencia o login e logout de usuários.
- **RegisterService**: Gerencia o processo de registro de novos usuários.
- **CardInfo**: Armazena as informações dos cartões de crédito/débito.
- **Statement**: Gera extratos bancários com base nas transações realizadas.

---

## Contribuições

Para acessar a organization do repositório acesse: https://github.com/taverna-fiap/fintech/
O repositório também se encontra no link: https://github.com/G-shiy/Fintech
## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo LICENSE para mais detalhes.
