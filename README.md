![Happy-Box.png](https://github.com/user-attachments/assets/07f72551-c80d-496c-83cb-8a57dce926c6)

# Toy Control System — Testes Automatizados e Performance com Postman, Selenium e K6

🧸 Esse projeto teve como foco principal garantir a qualidade de uma aplicação web de gerenciamento de brinquedos por meio de testes automatizados — tanto funcionais (interface e API), quanto não-funcionais (performance).

Foram utilizados diferentes frameworks e ferramentas para simular o uso real da aplicação, validar o comportamento esperado e observar o desempenho sob carga. Tudo foi documentado de forma clara e prática, com o objetivo de facilitar a análise e a apresentação do trabalho.

---

## 🧩 Introdução

Esse projeto foi desenvolvido com base na aplicação "Toy Control System", já pronta e funcional. Nosso papel foi atuar como um time de QA: criar, automatizar e executar testes que comprovem o bom funcionamento da aplicação e sua estabilidade sob carga.

Todos os testes foram organizados e planejados para cobrir os principais cenários de uso da aplicação, desde as funcionalidades básicas de CRUD até a resposta da API em situações de stress.

---

## 🎯 Objetivos do Projeto

✅ Automatizar testes funcionais da **interface web** usando Selenium ✅ Automatizar testes funcionais da **API REST** com Postman e scripts de validação ✅ Simular cenários de carga com **K6** para medir performance da aplicação ✅ Documentar claramente todas as etapas e decisões técnicas tomadas ✅ Organizar o projeto em uma estrutura compreensível para qualquer avaliador

---

## 🛠️ Tecnologias Utilizadas

- **Java + Selenium + JUnit** → Testes funcionais da interface (UI)
- **Postman + Newman** → Testes automatizados da API
- **K6 (JavaScript)** → Testes de performance
- **ChromeDriver + Selenium Manager** → Execução dos testes de UI sem abrir o navegador
- **IntelliJ IDEA** → Desenvolvimento dos testes
- **Notion / GitHub** → Organização e entrega da documentação

---

## 🧪 Testes Automatizados da API (Postman)

📂 Criamos uma **coleção de testes no Postman** contendo os principais endpoints da API:

- `GET /brinquedos` → Listagem geral
- `POST /brinquedos` → Criação de brinquedo (com corpo JSON válido)
- `PUT /brinquedos/{id}` → Edição de brinquedo existente
- `DELETE /brinquedos/{id}` → Exclusão por ID

📌 Cada requisição contém:

- Headers com `Content-Type: application/json`
- Body com dados validados
- Scripts de testes Postman (`pm.test`) que verificam códigos de status e presença de campos no retorno
- Casos de teste negativos (como dados ausentes ou ID inválido)

✅ Os testes foram executados usando o *Runner* do Postman e também por linha de comando com o **Newman**, garantindo automação total.

---

## 🖱️ Testes Automatizados da Interface (Selenium)

📂 A suíte de testes com Selenium foi escrita em Java usando JUnit e está organizada com clareza:

### ✅ Principais Classes de Teste

1. `ToyCreateTest` → Testa se a criação de um novo brinquedo funciona
2. `ToySearchTest` → Testa a busca por nome de brinquedo
3. `ToyEditTest` → Edita o primeiro brinquedo da lista
4. `ToyDeleteTest` → Remove o primeiro brinquedo da lista
5. `ToyWorkflowTest` → Executa o fluxo completo: criar → editar → deletar
6. `BaseTest` → Classe base que configura o Selenium e o WebDriver (modo headless)

### 🧠 Organização do Código

- Os elementos e interações estão encapsulados em classes separadas:
    - `ToyPage` → Interações com a listagem de brinquedos
    - `ToyFormModal` → Manipulação do formulário de criação/edição
    - `DeleteConfirmDialog` → Confirmação de exclusão
- Os testes usam asserções (`assertTrue`, `assertEquals`) para validar resultados visuais e dados exibidos

💡 Tudo pode ser executado direto do IntelliJ. O uso de `headless` evita abrir o navegador, deixando a automação mais rápida e estável.

---

## 📈 Testes de Performance com K6

📂 Foi criado um script de teste chamado `performanceTest.js` com a seguinte configuração:

- 20 usuários simultâneos (VUs)
- Execução por 30 segundos
- Três cenários simulados:
    - Acesso à página principal (`GET /`)
    - Criação de brinquedo (`POST /brinquedos`)
    - Busca por brinquedos (`GET /brinquedos?search=`)

📊 Resultados:

- Tempos de resposta foram registrados
- Verificações de status de cada requisição foram feitas
- O POST inicialmente falhou por indisponibilidade momentânea do endpoint, mas o erro foi resolvido

✅ No final, o teste demonstrou que a API responde bem em cenários com múltiplos acessos simultâneos.

---

## 📂 Estrutura de Pastas do Projeto

```
📁 src/test/java/com/brinquedos/...
├── BaseTest.java
├── ToyCreateTest.java
├── ToySearchTest.java
├── ToyEditTest.java
├── ToyDeleteTest.java
├── ToyWorkflowTest.java
└── pages/
    ├── ToyPage.java
    ├── ToyFormModal.java
    └── DeleteConfirmDialog.java

📁 src/test/k6/
└── performanceTest.js

📁 postman/
└── toy-api-collection.json
└── toy-api-test_run.json

```

---

## 📹 Roteiro para Apresentação em Vídeo

🎥 Para facilitar a explicação, siga esse roteiro:

1. Introduza o projeto e o objetivo da entrega
2. Mostre os testes de interface funcionando no IntelliJ com JUnit
3. Mostre os testes da API sendo executados no Postman Runner
4. Execute o teste de performance no terminal com o K6
5. Mostre a estrutura do projeto e onde ficam os arquivos principais
6. Abra essa documentação e use como guia para explicar cada etapa

---

## 🔚 Conclusão

Todos os critérios do desafio de QA foram cumpridos:

✅ Testes funcionais da interface e API ✅ Testes de performance automatizados ✅ Scripts organizados e claros ✅ Documentação detalhada para avaliação

💡 Como próximos passos para evolução:

- Automatizar execução via GitHub Actions (CI/CD)
- Adicionar testes com cobertura maior de cenários negativos
- Testar responsividade e usabilidade com ferramentas modernas como Cypress ou Playwright

✅ **Projeto finalizado e validado com sucesso!**
