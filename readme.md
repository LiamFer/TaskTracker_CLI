

# 📋 Task CLI - Aplicativo de Gerenciamento de Tarefas no Terminal

Este projeto é uma solução para o desafio [Task Tracker](https://roadmap.sh/projects/task-tracker) do [roadmap.sh](https://roadmap.sh).

O **Task CLI** é uma aplicação de linha de comando desenvolvida em **Java**, que permite gerenciar tarefas diretamente pelo terminal. As tarefas são armazenadas em um arquivo `JSON` usando a biblioteca **Jackson**, e a interface de linha de comando é construída com **Picocli**.

---

## 🚀 Tecnologias Utilizadas

- **Java**
- **[Picocli](https://picocli.info/)** – Para criação de comandos CLI
- **[Jackson](https://github.com/FasterXML/jackson)** – Para manipulação de arquivos JSON
- **Java Time API** – Para registrar data/hora de criação e edição das tarefas

---

## ⚙️ Comandos disponíveis

```bash
taskcli [comando]
````

| Comando            | Descrição                                     |
| ------------------ | --------------------------------------------- |
| `add`              | Adiciona uma nova tarefa                      |
| `update`           | Atualiza uma tarefa existente                 |
| `delete`           | Deleta uma tarefa                             |
| `mark-in-progress` | Altera o status da tarefa para "Em Progresso" |
| `mark-done`        | Altera o status da tarefa para "Concluída"    |
| `mark-todo`        | Altera o status da tarefa para "A Fazer"      |
| `list`             | Lista todas as tarefas salvas                 |
| `-h`, `--help`     | Mostra a ajuda dos comandos                   |
| `-V`, `--version`  | Mostra a versão do programa                   |

---

## 📂 Armazenamento

Todas as tarefas são salvas automaticamente em um arquivo `tarefas.json` localizado no mesmo diretório do projeto.

---

## 🛠️ Como rodar

Você pode usar o script `.bat` para facilitar a execução dos comandos:

1. Compile o projeto com todos os `.jar` necessários no classpath.
2. Crie um arquivo `taskcli.bat` com o comando completo de execução.
3. Execute comandos diretamente via terminal:

```bash
taskcli add "Nova tarefa"
taskcli list
```

> Se quiser saber como configurar isso automaticamente, veja a seção de [automatização de execução via .bat](#).

---

## 📌 Desafio original

🔗 [https://roadmap.sh/projects/task-tracker](https://roadmap.sh/projects/task-tracker)

---

## 📸 Exemplo

```bash
> taskcli add "Estudar Java"
Task "Estudar Java" foi criada com Sucesso!

> taskcli list
-------------
ID: 1
Descrição: Estudar Java
Status: TODO
Criado: 2025-06-14T14:10:15
Editado em: 2025-06-14T14:10:15
-------------
```

---

## ✅ Funcionalidades extras (opcional)

* Registro automático de data/hora de criação e edição.
* Validação de IDs inexistentes.
* Filtros para status: TODO, IN\_PROGRESS, DONE.

