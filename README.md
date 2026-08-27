# Task Manager CLI - Java

Gerenciador de tarefas desenvolvido em Java para execução via linha de comando (CLI).

O projeto foi criado com foco na prática de Programação Orientada a Objetos (POO), organização em camadas, persistência de dados em JSON, tratamento de exceções e testes automatizados.

## Funcionalidades

O sistema permite:

- Criar tarefas
- Listar tarefas cadastradas
- Editar título e descrição
- Marcar tarefas como concluídas
- Excluir tarefas
- Manter os dados salvos entre execuções
- Validar dados informados pelo usuário
- Tratar tarefas inexistentes e erros de persistência

## Exemplo de uso

Ao iniciar a aplicação, o seguinte menu é exibido:

```text
===== GERENCIADOR DE TAREFAS =====
1 - Criar tarefa
2 - Listar tarefas
3 - Editar tarefa
4 - Concluir tarefa
5 - Excluir tarefa
0 - Sair
Escolha uma opção:
```

Exemplo de tarefas cadastradas:

```text
===== TAREFAS =====
[ ] #1 - Estudar Java
    Revisar Programação Orientada a Objetos

[X] #2 - Finalizar projeto
    Finalizar o gerenciador de tarefas CLI
```

`[ ]` representa uma tarefa pendente e `[X]` uma tarefa concluída.

## Tecnologias utilizadas

- Java 21
- Maven
- Jackson
- JUnit 5
- Git e GitHub
- IntelliJ IDEA

## Estrutura do projeto

```text
src/
├── main/
│   └── java/
│       └── br/com/guilherme/taskmanager/
│           ├── exception/
│           │   ├── StorageException.java
│           │   ├── TaskNotFoundException.java
│           │   └── ValidationException.java
│           │
│           ├── model/
│           │   └── Task.java
│           │
│           ├── persistence/
│           │   ├── JsonTaskStorage.java
│           │   └── TaskStorage.java
│           │
│           ├── repository/
│           │   └── TaskRepository.java
│           │
│           ├── service/
│           │   └── TaskService.java
│           │
│           ├── ui/
│           │   └── TaskMenu.java
│           │
│           └── Main.java
│
└── test/
    └── java/
        └── br/com/guilherme/taskmanager/
            ├── persistence/
            │   └── MemoryTaskStorage.java
            ├── repository/
            │   └── TaskRepositoryTest.java
            └── service/
                └── TaskServiceTest.java
```

## Arquitetura

O projeto foi dividido em responsabilidades para evitar concentração da lógica em uma única classe.

### Model

`Task` representa uma tarefa e mantém seus dados e comportamentos.

### UI

`TaskMenu` é responsável pela interação com o usuário através do terminal.

### Service

`TaskService` concentra as regras de negócio, como criação, edição, conclusão e validação das tarefas.

### Repository

`TaskRepository` é responsável pelo acesso e gerenciamento das tarefas.

### Persistence

A interface `TaskStorage` define o contrato de persistência.

A implementação `JsonTaskStorage` utiliza Jackson para salvar e recuperar as tarefas de um arquivo JSON.

Essa abstração permite utilizar diferentes formas de armazenamento sem alterar a regra de negócio.

```text
TaskService
     |
TaskRepository
     |
TaskStorage
     |
JsonTaskStorage
     |
 tasks.json
```

Nos testes, a implementação em JSON é substituída por armazenamento em memória:

```text
TaskRepository
     |
TaskStorage
     |
MemoryTaskStorage
```

Isso mantém os testes isolados dos dados reais da aplicação.

## Persistência

As tarefas são armazenadas localmente no arquivo:

```text
tasks.json
```

O arquivo é criado automaticamente durante a utilização da aplicação.

O `tasks.json` não é versionado no Git, pois contém dados gerados durante a execução.

Exemplo:

```json
[
  {
    "id": 1,
    "title": "Estudar Java",
    "description": "Revisar POO",
    "completed": false
  }
]
```

## Tratamento de exceções

O projeto possui exceções específicas para diferentes situações:

- `TaskNotFoundException` - tarefa solicitada não existe
- `ValidationException` - dados informados são inválidos
- `StorageException` - erro durante leitura ou gravação dos dados

## Testes

Os testes automatizados foram desenvolvidos utilizando JUnit 5.

São testadas operações como:

- Criação de tarefas
- Listagem
- Edição
- Conclusão
- Exclusão
- Validação de título
- Busca por ID
- Tratamento de tarefas inexistentes

Os testes utilizam `MemoryTaskStorage`, evitando alterações no arquivo `tasks.json` durante sua execução.

## Como executar

### Pré-requisitos

É necessário ter instalado:

- JDK 21
- Maven

Clone o repositório:

```bash
git clone git@github.com:GuiPlow/task-manager-cli-java.git
```

Entre na pasta:

```bash
cd task-manager-cli-java
```

Compile o projeto:

```bash
mvn clean compile
```

Os testes podem ser executados com:

```bash
mvn test
```

A aplicação também pode ser executada diretamente pela classe `Main` através de uma IDE como IntelliJ IDEA.

## Conceitos aplicados

Durante o desenvolvimento foram utilizados conceitos como:

- Programação Orientada a Objetos
- Encapsulamento
- Interfaces
- Polimorfismo
- Separação de responsabilidades
- Injeção de dependência
- Repository Pattern
- Persistência em JSON
- Tratamento de exceções
- Validação de regras de negócio
- Testes unitários
- Git e versionamento de código

## Autor

Guilherme Magalhães