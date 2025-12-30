# Formação Java 2024 - Rocketseat

## 📋 Descrição
Este repositório contém todos os materiais e projetos desenvolvidos na [Formação Java 2024](https://app.rocketseat.com.br/journey/java) da Rocketseat.

## 📑 Índice

- [Módulo 01: Fundamentos do Java](#-módulo-01-fundamentos-do-java)
- [Módulo 02: Java Collections](#-módulo-02-java-collections)
- [Módulo 03: Maven e JDBC](#-módulo-03-maven-e-jdbc)
- [Módulo 04: Fundamentos do Spring Boot](#-módulo-04-fundamentos-do-spring-boot)

---

## 💻 Módulo 01: Fundamentos do Java

Este módulo cobre os fundamentos essenciais da linguagem Java, desde sintaxe básica até conceitos avançados de programação orientada a objetos.

### 📚 Tópicos Abordados

#### 1. **Sintaxe Básica e Primeira Classe**
- Estrutura básica de uma classe Java
- Método `main`
- Declaração de variáveis e tipos primitivos
- Primeiro programa em Java

#### 2. **Tipos Wrappers (je05_tipos_wrappers)**
- Classes wrapper para tipos primitivos (Integer, Double, Boolean, etc.)
- Conversão entre tipos primitivos e objetos
- Autoboxing e unboxing

#### 3. **Operadores (je06_operadores)**
- **Operadores Aritméticos**: +, -, *, /, %
- **Operadores de Atribuição**: =, +=, -=, *=, /=
- **Operadores Relacionais**: ==, !=, <, >, <=, >=
- **Operadores Lógicos**: && (AND), || (OR), ! (NOT)
- **Operadores Unários**: ++, --, +, -
- **Operador Ternário**: condição ? valor_se_verdadeiro : valor_se_falso

#### 4. **Documentação e Comentários (je07_documentacao)**
- Comentários de linha única (//)
- Comentários de múltiplas linhas (/* */)
- JavaDoc para documentação de classes e métodos
- Boas práticas de documentação de código

#### 5. **JavaBeans (je08_javabeans)**
- Convenções JavaBeans
- Getters e Setters
- Encapsulamento de dados

#### 6. **Controle de Fluxo Condicional (je09_controle_fluxo)**
- Estruturas `if`, `else`, `else if`
- Estrutura `switch/case`
- Exemplos práticos: Caixa Eletrônico, Resultado Escolar, Sistema de Medidas

#### 7. **Estruturas de Repetição (je10_controle_fluxo_repeticao)**
- **for**: Laço controlado por contador
- **while**: Laço com condição pré-verificada
- **do-while**: Laço com condição pós-verificada
- **break**: Interromper execução do laço
- **continue**: Pular para próxima iteração

#### 8. **Tratamento de Exceções (je11_controle_fluxo_excecao)**
- Blocos `try/catch/finally`
- Tratamento de exceções com Scanner
- InputMismatchException
- Exceções personalizadas
- Projeto prático: AboutMe (entrada de dados do usuário)

#### 9. **Programação Orientada a Objetos (je12_poo)**
- Classes e Objetos
- Instanciação
- Construtores
- **Enums**: Criação e uso de tipos enumerados (EstadoBrasileiro)
- **Comparação de Objetos**: equals(), hashCode(), comparação de referências vs valores
- Atributos e métodos de instância

#### 10. **Classes Essenciais (je13_classes_essenciais)**
- **Classes String**: Métodos de manipulação de strings (concat, toLowerCase, toUpperCase, split)
- **StringBuilder**: Construção eficiente de strings
- **Classes Numéricas**: Wrappers e conversões
- **Scanner**: Leitura de dados do usuário
- **PrintStream**: System.out.println, System.err

#### 11. **Pilares da POO (je14_pilares_poo)**
- **Abstração**: Classes abstratas (ServicoMensagemInstantanea)
- **Herança**: Extensão de classes (FacebookMessenger, MSNMessenger, Telegram)
- **Polimorfismo**: Interfaces e implementações
- **Encapsulamento**: Modificadores de acesso

#### 12. **Java Time API (je15_java_time)**
- **LocalDate**: Trabalhando com datas
- **LocalTime**: Trabalhando com horas
- **LocalDateTime**: Combinação de data e hora
- **DateTimeFormatter**: Formatação de datas
- Manipulação de datas (plus, minus, isAfter, isBefore)
- Parsing e formatação de strings para datas

#### 13. **Java NIO - File I/O (je26_java_nio)**
- **Path e Paths**: Manipulação de caminhos de arquivos
- **Files**: Operações de leitura e escrita
- Leitura de arquivos (readAllLines, readAllBytes)
- Escrita de arquivos
- Trabalhando com arquivos CSV (layout delimitado e posicional)
- Projeto: Sistema de Cadastros com leitura/escrita de arquivos

#### 14. **Exceções Avançadas (je27_excessoes)**
- Criação de exceções personalizadas (EstadoValidadeException)
- Hierarquia de exceções
- Blocos try/catch aninhados
- Lançamento de exceções (throw, throws)

#### 15. **Expressões e Formatação (je28_expressoes)**
- **Expressões Simples**: Concatenação de strings
- **String.format()**: Formatação de strings
- **Expressões Avançadas**: Formatação com padrões (s, d, f, t)
- Formatação de números, datas e valores monetários
- Padrões de formatação personalizados

### 🎯 Projetos Práticos

- **Sistema de Livraria**: Projeto completo implementando classes (Autor, Livro, Emprestimo, Biblioteca) com operações de empréstimo e devolução
- **Sistema de Cadastros**: Sistema de leitura e escrita de arquivos usando Java NIO

---

## 📦 Módulo 02: Java Collections

Este módulo aborda as estruturas de dados e coleções do Java, essenciais para manipulação eficiente de conjuntos de dados.

### 📚 Tópicos Abordados

#### 1. **Arrays (je29_arrays/Arrays.java)**
- Declaração e inicialização de arrays
- Arrays unidimensionais
- Iteração sobre arrays (for tradicional e enhanced for)
- Acesso por índice

#### 2. **Listas (je29_arrays/Listas.java)**
- Interface `List` e implementações
- **ArrayList**: Lista dinâmica baseada em array
- Métodos essenciais: add(), remove(), get(), indexOf(), contains(), size()
- Iteração sobre listas

#### 3. **Conjuntos (je29_arrays/Conjuntos.java)**
- Interface `Set` e suas implementações
- **HashSet**: Conjunto sem ordem definida
- **LinkedHashSet**: Conjunto mantendo ordem de inserção
- **TreeSet**: Conjunto ordenado
- Propriedade de unicidade (sem elementos duplicados)

#### 4. **Mapas (je29_arrays/Mapas.java)**
- Interface `Map` e implementações
- **HashMap**: Mapa sem ordem definida
- **LinkedHashMap**: Mapa mantendo ordem de inserção
- **TreeMap**: Mapa ordenado por chave
- Operações: put(), get(), keySet(), values()
- Iteração sobre mapas usando Iterator

#### 5. **Generics (je29_arrays/Generics.java)**
- Tipagem genérica em coleções
- Type safety
- Collections com tipos específicos: `List<String>`, `List<Integer>`
- Métodos úteis: Collections.sort(), Collections.shuffle()
- Vantagens de usar Generics

### 🎯 Conceitos Aprendidos

- Diferenças entre List, Set e Map
- Quando usar cada tipo de coleção
- Performance e complexidade de operações
- Type safety com Generics
- Boas práticas no uso de Collections

---

## 🔧 Módulo 03: Maven e JDBC

Este módulo introduz o gerenciamento de dependências com Maven e a comunicação com bancos de dados usando JDBC.

### 📚 Tópicos Abordados

#### 1. **Apache Maven**
- Estrutura de projeto Maven
- Arquivo `pom.xml` (Project Object Model)
- Gerenciamento de dependências
- Ciclo de vida do Maven (compile, test, package)
- Diretórios padrão (src/main/java, src/test/java)

#### 2. **JDBC (Java Database Connectivity)**
- Conexão com banco de dados PostgreSQL
- Classe `Connection` e `DriverManager`
- **PreparedStatement**: Execução de consultas SQL parametrizadas
- **ResultSet**: Manipulação de resultados de consultas
- Operações CRUD (Create, Read, Update, Delete)

#### 3. **Padrão Repository**
- Classe `CadastroRepository`: Abstração de acesso a dados
- Métodos:
  - `incluir()`: INSERT de novos registros
  - `listar()`: SELECT de todos os registros
  - `buscar()`: SELECT de um registro específico
  - `alterar()`: UPDATE de registros
  - `excluir()`: DELETE de registros

#### 4. **Classe de Conexão (Conexao.java)**
- Singleton pattern para conexão
- Configuração de conexão (URL, usuário, senha)
- Gerenciamento de recursos

### 🗄️ Tecnologias Utilizadas

- **PostgreSQL**: Banco de dados relacional
- **PostgreSQL JDBC Driver**: Driver para conexão Java-PostgreSQL
- **Maven**: Gerenciador de dependências e build

### 🎯 Projeto Prático

- **Sistema de Cadastros**: Aplicação completa com persistência em banco de dados PostgreSQL, incluindo todas as operações CRUD

---

## 🚀 Módulo 04: Fundamentos do Spring Boot

Este módulo introduz o Spring Boot, framework que simplifica o desenvolvimento de aplicações Java enterprise.

### 📚 Tópicos Abordados

#### 1. **Spring Boot Essentials**
- Criação de projeto Spring Boot
- Anotação `@SpringBootApplication`
- Estrutura de projeto Spring Boot
- Spring Initializr

#### 2. **Configuração (application.yaml)**
- Arquivos de configuração YAML
- Configuração de propriedades da aplicação
- Perfis de configuração (dev, prod, etc.)

#### 3. **Dependências Spring Boot**
- **spring-boot-starter-webmvc**: Dependência para desenvolvimento web
- **spring-boot-devtools**: Ferramentas de desenvolvimento (hot reload)
- **spring-boot-starter-webmvc-test**: Dependências para testes

#### 4. **Maven Wrapper (mvnw)**
- Execução do Maven sem instalação prévia
- Independência de ambiente

### 🎯 Conceitos Iniciais

- Arquitetura de aplicações Spring Boot
- Inicialização de aplicações Spring
- Convenções sobre configuração (Convention over Configuration)
- Preparação para desenvolvimento web com Spring MVC

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Apache Maven**
- **PostgreSQL**
- **Spring Boot 4.0.1**
- **JDBC**

---

## 📚 Recursos de Aprendizado

- [Formação Java 2024 - Rocketseat](https://app.rocketseat.com.br/journey/java)
- [Documentação Oracle Java](https://docs.oracle.com/en/java/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Maven Documentation](https://maven.apache.org/guides/)

---

## 📄 Licença

Este repositório é para fins educacionais e contém materiais do curso Formação Java 2024 da Rocketseat.
