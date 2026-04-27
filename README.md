# 🦇 Calculadora de Materiais para Obra Residencial

Projeto desenvolvido para a disciplina de **Desenvolvimento de Sistemas** com o objetivo de automatizar o dimensionamento de materiais em fases de obras residenciais utilizando conceitos de Engenharia Civil e Computação.

## 📋 Sobre o Projeto
O sistema modela uma planta baixa como um **Grafo $G=(V, A)$**, onde:
* **Vértices (V):** Representam os encontros das paredes (Pilares). 
* **Arestas (A):** Representam as paredes que possuem dimensões de largura, comprimento, altura e espessura. 

## 🚀 Funcionalidades
- **Modelagem de Planta Baixa:** Abstração de pilares e paredes com suporte a aberturas (portas e janelas). 
- **Cálculo de Concreto:** Serviço REST para calcular o volume de concreto necessário para vigas baldrames (fundação). 
- **Cálculo de Tijolos:** Serviço REST para calcular a quantidade de tijolos necessária para o fechamento das paredes. 

## 🛠️ Tecnologias Utilizadas
- **Java 17/21** 
- **Spring Boot 3.x** 
- **Spring Data JPA & Hibernate** (ORM para persistência de dados) 
- **H2 Database** (Banco de dados em memória para testes rápidos) 
- **Maven** (Gerenciador de dependências) 

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
   git clone [https://github.com/Adrianzx01/projeto-calculadora-obra.git]
