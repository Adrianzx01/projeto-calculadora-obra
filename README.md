# 🦇 Calculadora de Materiais para Obra Residencial

Projeto desenvolvido para a disciplina de **Desenvolvimento de Sistemas** com o objetivo de automatizar o dimensionamento de materiais em fases de obras residenciais utilizando conceitos de Engenharia Civil e Computação.

## 📋 Sobre o Projeto
O sistema modela uma planta baixa como um **Grafo $G=(V, A)$**, onde:
* [cite_start]**Vértices (V):** Representam os encontros das paredes (Pilares). [cite: 24]
* [cite_start]**Arestas (A):** Representam as paredes que possuem dimensões de largura, comprimento, altura e espessura. [cite: 24, 25]

## 🚀 Funcionalidades
- [cite_start]**Modelagem de Planta Baixa:** Abstração de pilares e paredes com suporte a aberturas (portas e janelas). [cite: 24, 26]
- [cite_start]**Cálculo de Concreto:** Serviço REST para calcular o volume de concreto necessário para vigas baldrames (fundação). [cite: 63, 84]
- [cite_start]**Cálculo de Tijolos:** Serviço REST para calcular a quantidade de tijolos necessária para o fechamento das paredes. [cite: 89, 93]

## 🛠️ Tecnologias Utilizadas
- [cite_start]**Java 17/21** [cite: 77]
- [cite_start]**Spring Boot 3.x** [cite: 72]
- [cite_start]**Spring Data JPA & Hibernate** (ORM para persistência de dados) [cite: 8, 82]
- [cite_start]**H2 Database** (Banco de dados em memória para testes rápidos) [cite: 82]
- [cite_start]**Maven** (Gerenciador de dependências) [cite: 70]

## 🛣️ Endpoints

### 1. Calcular Volume de Concreto
`POST /api/obra/concreto?alturaViga=0.3`
- **Corpo da requisição:** Lista de objetos `Parede`.
- **Retorno:** Volume total em $m^3$.

### 2. Calcular Quantidade de Tijolos
`POST /api/obra/tijolos?largTijolo=0.19&altTijolo=0.19`
- **Corpo da requisição:** Lista de objetos `Parede`.
- **Retorno:** Quantidade total de unidades.

## 🔧 Como Executar
1. Clone o repositório:
   ```bash
   git clone [LINK_DO_SEU_REPOSITORIO]
