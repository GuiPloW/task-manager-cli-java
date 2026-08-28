<div align="center">

# ☕ Task Manager CLI

### Gerenciador de tarefas desenvolvido em Java

Projeto desenvolvido para aplicar conceitos de **Java, Programação Orientada a Objetos, arquitetura em camadas, persistência de dados e tratamento de exceções** em uma aplicação funcional executada pelo terminal.

</div>

---

## 📖 Sobre o projeto

O **Task Manager CLI** é uma aplicação de linha de comando para gerenciamento de tarefas.

O projeto foi desenvolvido com o objetivo de colocar em prática conceitos importantes do desenvolvimento Java, separando responsabilidades entre as diferentes camadas da aplicação e evitando concentrar toda a lógica em uma única classe.

A aplicação permite gerenciar tarefas através de um menu interativo no terminal e mantém os dados persistidos entre as execuções.

---

## ⚙️ Funcionalidades

- ➕ Criar novas tarefas
- 📋 Listar tarefas cadastradas
- 🔍 Buscar tarefas
- ✏️ Atualizar informações de uma tarefa
- ✅ Alterar o status de uma tarefa
- 🗑️ Remover tarefas
- 💾 Persistir os dados entre execuções
- ⚠️ Validar entradas do usuário
- 🛡️ Tratar erros através de exceções

---

## 🧱 Arquitetura

O projeto foi organizado em camadas para separar as responsabilidades da aplicação:

```text
br.com.guilherme.taskmanager
│
├── model
│   └── Task
│
├── repository
│   └── ...
│
├── service
│   └── TaskService
│
├── ui
│   └── TaskMenu
│
├── exception
│   ├── TaskNotFoundException
│   └── StorageException
│
└── Main
```

### `model`

Representa as entidades e os dados utilizados pela aplicação.

### `repository`

Responsável pelo acesso e persistência dos dados.

### `service`

Contém as regras de negócio e faz a comunicação entre a interface e a camada de persistência.

### `ui`

Responsável pela interação com o usuário através do terminal.

### `exception`

Contém exceções específicas da aplicação, permitindo um tratamento de erros mais organizado.

---

## 🛠️ Tecnologias utilizadas

<div align="center">

<img src="https://skillicons.dev/icons?i=java,maven,git,github,idea" />

</div>

- **Java**
- **Maven**
- **Git**
- **GitHub**
- **IntelliJ IDEA**

---

## 💡 Conceitos aplicados

Durante o desenvolvimento foram aplicados conceitos como:

- Programação Orientada a Objetos
- Encapsulamento
- Separação de responsabilidades
- Arquitetura em camadas
- Repository Pattern
- Service Layer
- Persistência de dados
- Tratamento de exceções
- Validação de entrada
- Collections
- Manipulação de arquivos
- Git e versionamento de código

---

## ▶️ Como executar

### Pré-requisitos

Para executar o projeto, é necessário possuir:

- **Java JDK 21** ou superior
- **Git**
- **Maven**

### 1. Clone o repositório

```bash
git clone https://github.com/GuiPloW/task-manager-cli-java.git
```

### 2. Entre na pasta do projeto

```bash
cd task-manager-cli-java
```

### 3. Compile o projeto

```bash
mvn clean package
```

### 4. Execute a aplicação

Execute a classe principal do projeto através da sua IDE.

Após iniciar, o menu interativo será exibido no terminal.

---

## 🎯 Objetivo do projeto

Este projeto faz parte do meu processo de aprendizado em **desenvolvimento Back-end com Java**.

A proposta foi construir uma aplicação simples, mas estruturada de forma próxima a projetos reais, aplicando separação de responsabilidades, persistência e tratamento adequado de erros.

Ele também serve como base para projetos mais avançados envolvendo:

`Spring Boot` • `APIs REST` • `PostgreSQL` • `Docker`

---

## 👨‍💻 Autor

<div align="center">

**Guilherme Magalhães**

Desenvolvedor Java & Back-end em formação

<br>

<a href="https://github.com/GuiPloW">
  <img src="https://img.shields.io/badge/GitHub-GuiPloW-181717?style=for-the-badge&logo=github">
</a>

<a href="https://www.linkedin.com/in/guiplow/">
  <img src="https://img.shields.io/badge/LinkedIn-Guilherme%20Magalhães-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white">
</a>

</div>

---

<div align="center">

⭐ Se este projeto foi útil ou interessante, considere deixar uma estrela.

</div>
