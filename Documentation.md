# 📂 Estrutura das Classes

---
## **User**

**Descrição:**  
Representa um usuário do sistema, contendo suas informações pessoais e contas bancárias associadas.

📌 **Atributos:**

🔹 **id (String)** – Identificador único do usuário (gerado via UUID).  
🔹 **name (String)** – Nome do usuário.  
🔹 **email (String)** – Endereço de e-mail do usuário.  
🔹 **cpf (String)** – Cadastro de Pessoa Física (CPF) do usuário.  
🔹 **phone (String)** – Número de telefone para contato.  
🔹 **address (String)** – Endereço residencial do usuário.  
🔹 **birthday (String)** – Data de nascimento do usuário.  
🔹 **accounts (List<Account>)** – Lista de contas bancárias associadas ao usuário.

📌 **Métodos:**

➕ **User(String name, String email, String cpf, String phone, String address, String birthday, List<Account> accounts)**  
➜ Inicializa um usuário com contas associadas.

🔹 Construtor que recebe os dados do usuário e uma lista de contas bancárias associadas.

➕ **User(String name, String email, String cpf, String phone, String address, String birthday)**  
➜ Inicializa um usuário sem contas associadas.

🔹 Construtor que recebe os dados do usuário sem contas associadas.

➕ **toString()**  
➜ Retorna uma representação textual do usuário com todas as suas informações.

🔹 Exibe as informações do usuário como nome, e-mail, CPF, telefone, endereço, data de nascimento e suas contas associadas.

➕ **Getters e Setters**  
➜ Métodos de acesso e modificação dos atributos da classe.

---

## **TransactionLog**

**Descrição:**  
Registra um log de uma transação realizada no sistema, incluindo informações sobre o status, valor e data/hora da operação.

📌 **Atributos:**

🔹 **transactionId (String)** – Identificador único da transação.  
🔹 **status (TransactionStatus)** – Status da transação (ex.: PENDING, COMPLETED, FAILED, CANCELED).  
🔹 **amount (BigDecimal)** – Valor da transação.  
🔹 **timestamp (LocalDateTime)** – Data e hora do registro da transação.

📌 **Métodos:**

➕ **TransactionLog(String transactionId, TransactionStatus status, BigDecimal amount)**  
➜ Inicializa um log de transação com ID, status e valor, registrando automaticamente o timestamp.

🔹 Construtor que define o ID da transação, o status, o valor e registra automaticamente a data e hora.

➕ **toString()**  
➜ Retorna uma representação textual do log da transação com todas as suas informações.

🔹 Exibe o ID da transação, status, valor e timestamp.

➕ **Getters e Setters**  
➜ Métodos de acesso e modificação dos atributos da classe.
---
## **TransactionService**

**Descrição:**  
Gerencia o processamento das transações, garantindo que elas sejam executadas corretamente.

📌 **Métodos:**

⚙️ **processTransaction(Transaction transaction)**  
➜ Processa uma transação recebida.

🔹 Exibe uma mensagem indicando o início do processamento.  
🔹 Chama o método **process()** da transação para executá-la.  
🔹 Exibe uma mensagem confirmando a finalização da transação.

💡 **Observação:**  
Este serviço não inclui validação de idempotência ou armazenamento da transação. Para evitar duplicações ou garantir persistência, uma implementação mais robusta pode ser necessária.

---

## **Login**

**Descrição:**  
Gerencia o processo de autenticação de usuários, permitindo login e logout no sistema.

📌 **Atributos:**

🔹 **loggedUser (User)** – Armazena o usuário atualmente autenticado.

📌 **Métodos:**

🔑 **loginUser(String email)**  
➜ Realiza a autenticação do usuário com base no e-mail informado.

🔹 Percorre a lista de usuários registrados em **RegisterService**.  
🔹 Se encontrar um e-mail correspondente, autentica o usuário e armazena em **loggedUser**.  
🔹 Exibe uma mensagem de sucesso ou erro caso o usuário não seja encontrado.

✅ **isUserLoggedIn()**  
➜ Verifica se há um usuário autenticado no sistema.

🔹 Retorna **true** se **loggedUser** não for **null**, indicando que há uma sessão ativa.

👤 **getLoggedUser()**  
➜ Retorna o usuário atualmente autenticado.

🚪 **logout()**  
➜ Encerra a sessão do usuário autenticado.

🔹 Define **loggedUser** como **null** e exibe uma mensagem de logout.

💡 **Observação:**  
O sistema de login é baseado apenas em e-mail, sem verificação de senha. Para maior segurança, recomenda-se implementar autenticação com credenciais seguras e armazenamento adequado.

---

## **RegisterService**

**Descrição:**  
Gerencia o processo de registro de novos usuários no sistema, garantindo que não haja duplicação de e-mails cadastrados.

📌 **Atributos:**

🔹 **users (List<User>)** – Lista estática que armazena todos os usuários registrados.

📌 **Métodos:**

📝 **registerUser()**  
➜ Realiza o registro de um novo usuário.

🔹 Solicita informações do usuário via entrada no console.  
🔹 Verifica se o e-mail informado já está cadastrado.  
🔹 Cria um novo objeto **User** e adiciona à lista de usuários.  
🔹 Exibe uma mensagem de sucesso ou erro caso o e-mail já esteja registrado.

📜 **getUsers()**  
➜ Retorna a lista de usuários cadastrados.

💡 **Observação:**  
O registro é feito via entrada no console, o que pode não ser ideal para aplicações web ou APIs. Para maior segurança e escalabilidade, recomenda-se utilizar um banco de dados e validações mais robustas.
---
## **CardInfo**

**Descrição:**  
Representa as informações de um cartão de crédito ou débito, incluindo dados como número do cartão, nome do titular, CVV, data de expiração e data de pagamento.

📌 **Atributos:**

🔹 **cardId (String)** – Identificador único do cartão.  
🔹 **cardName (String)** – Nome do titular do cartão.  
🔹 **cardNumber (String)** – Número do cartão.  
🔹 **cvv (String)** – Código de segurança do cartão (CVV).  
🔹 **expiration (String)** – Data de expiração do cartão (ex: "MM/AAAA").  
🔹 **paymentDate (String)** – Data do pagamento do cartão (ex: "dd/MM/yyyy").

📌 **Métodos:**

🔹 **Getters e Setters**  
➜ Métodos de acesso e modificação dos atributos da classe.
___
## **Statement**
**Descrição:**  
Representa o extrato bancário de uma conta em um determinado período, reunindo todas as transações realizadas nesse intervalo.

📌 **Atributos:**

🔹 **statementId (String)** – Identificador único do extrato.  
🔹 **account (Account)** – Conta bancária associada ao extrato.  
🔹 **transactions (List<Transaction>)** – Lista de transações incluídas no extrato.  
🔹 **period (String)** – Período do extrato (ex: "Jan/2025").

📌 **Métodos:**

➕ **generateStatement()**  
➜ Gera o extrato bancário com base nas transações realizadas no período.

🔹 Filtra as transações da conta dentro do período informado e gera o extrato.

➕ **getStatementDetails()**  
➜ Retorna os detalhes do extrato gerado.

🔹 Exibe as informações relacionadas às transações do período, como data, valor e status.

➕ **Getters e Setters**  
➜ Métodos de acesso e modificação dos atributos da classe.
---
## Login

**Descrição:**
Gerencia o processo de autenticação de usuários, permitindo login e logout no sistema.

📌 **Atributos:**

🔹 `loggedUser (User)` – Armazena o usuário atualmente autenticado.

📌 **Métodos:**

🔑 **loginUser(String email)**
➜ Realiza a autenticação do usuário com base no e-mail informado.

🔹 Percorre a lista de usuários registrados em `RegisterService`.
🔹 Se encontrar um e-mail correspondente, autentica o usuário e armazena em `loggedUser`.
🔹 Exibe uma mensagem de sucesso ou erro caso o usuário não seja encontrado.

✅ **isUserLoggedIn()**
➜ Verifica se há um usuário autenticado no sistema.

🔹 Retorna `true` se `loggedUser` não for `null`, indicando que há uma sessão ativa.

👤 **getLoggedUser()**
➜ Retorna o usuário atualmente autenticado.

🚪 **logout()**
➜ Encerra a sessão do usuário autenticado.

🔹 Define `loggedUser` como `null` e exibe uma mensagem de logout.

💡 **Observação:**
O sistema de login é baseado apenas em e-mail, sem verificação de senha. Para maior segurança, recomenda-se implementar autenticação com credenciais seguras e armazenamento adequado.

---

## TransactionStatus (Enum)

**Descrição:**
Define os possíveis estados de uma transação financeira no sistema.

📌 **Valores:**

🔹 `PENDING` – A transação foi iniciada e está aguardando processamento.
🔹 `COMPLETED` – A transação foi concluída com sucesso.
🔹 `FAILED` – A transação falhou durante o processamento.
🔹 `CANCELED` – A transação foi cancelada pelo usuário ou pelo sistema.

💡 **Observação:**
Este enum pode ser utilizado para controle de fluxo no processamento de transações, permitindo que o sistema reaja adequadamente a cada status.

