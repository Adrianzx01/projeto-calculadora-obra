# Calculadora de Materiais para Obra Residencial

Projeto da disciplina de **Desenvolvimento de Sistemas**. O sistema calcula o
consumo de materiais (concreto e tijolos) em fases de obras residenciais a partir
da planta informada pelo usuário, e permite salvar e consultar os orçamentos
gerados.

## Funcionalidades

- **Cadastro da planta:** o usuário adiciona as paredes da casa informando cômodo,
  dimensoes (largura, altura, comprimento, espessura) e se possuem porta/janela.
- **Cálculo de concreto:** volume de concreto necessário para as vigas baldrame
  (fundação).
- **Cálculo de tijolos:** quantidade de tijolos necessária para o fechamento das
  paredes.
- **Persistência de orçamentos:** cada cálculo é salvo no banco com um número de
  orçamento e o nome do usuário.
- **Consulta:** busca de orçamentos salvos pelo nome do usuário.
## Tecnologias

- Java 21
- Spring Boot 4.0.5
- Spring Data JPA + Hibernate (ORM para persistência)
- Banco de dados H2 (em memória)
- **JSF (Jakarta Faces) via JoinFaces 6.0.5 + PrimeFaces** (frontend)
- Maven
## Como executar

1. Importe o projeto no IntelliJ IDEA como projeto **Maven**
   (`File > Open` e selecione a pasta do projeto).
2. Aguarde o IntelliJ baixar as dependencias
   (aba Maven no lado direito > botao **Reload**).
3. Execute a classe `ProjetoCalculadoraApplication`.
4. Acesse a interface no navegador:
   `http://localhost:8080/index.xhtml`
### Console do banco de dados

Disponível em `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:obradb`
- **Usuário:** `sa`
- **Senha:** (em branco)
## Estrutura do projeto

```
src/main/java/com/example/projeto_calculadora
├── bean/OrcamentoBean.java          # Managed Bean: liga a tela JSF ao backend
├── controller/ObraController.java   # API REST (opcional, ainda disponivel)
├── model/                           # Entidades (Parede, Orcamento, Pilar)
├── repository/OrcamentoRepository.java  # Persistencia dos orcamentos (ORM)
└── service/CalculadoraService.java  # Regras de calculo e geracao de orcamento
 
src/main/resources
├── META-INF/resources/index.xhtml   # Tela principal (JSF/PrimeFaces)
└── application.properties           # Configuracoes do banco e do JSF
```

## API REST (disponivel, alem da interface)

Além da tela JSF, o backend também expõe os cálculos via REST:

- `POST /api/obra/concreto?alturaViga=0.3` — corpo: lista de paredes em JSON
- `POST /api/obra/tijolos?largTijolo=0.19&altTijolo=0.19` — corpo: lista de paredes em JSON
