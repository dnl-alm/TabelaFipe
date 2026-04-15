# 🚗 Tabela FIPE Consulta (Java + API)

Projeto em Java que consome a API pública da Tabela FIPE para consultar informações de veículos como **marcas, modelos, anos e valores**.

---

## 📌 Sobre o projeto

Este sistema permite consultar informações da Tabela FIPE diretamente pelo terminal.

Fluxo da aplicação:

1. Escolher tipo de veículo (Carro, Moto ou Caminhão)
2. Listar marcas disponíveis
3. Selecionar uma marca
4. Listar modelos da marca escolhida
5. Filtrar modelos por nome
6. Selecionar um modelo
7. Consultar informações detalhadas por ano do veículo
8. Exibir valores completos

---

## ⚙️ Tecnologias utilizadas

- Java 17+
- Jackson (JSON)
- API REST
- Stream API
- Records (DTOs)

---

## 🌐 API utilizada
https://parallelum.com.br/fipe/api/v1/


Endpoints principais:

- /carros/marcas
- /motos/marcas
- /caminhoes/marcas
- /modelos
- /anos
- /veiculo

---

## 🧠 Funcionalidades

- Listagem de marcas por tipo de veículo
- Listagem de modelos por marca
- Filtro de modelos por nome
- Consulta de anos disponíveis
- Busca de valores detalhados
- Exibição formatada no terminal

---

## 📂 Estrutura do projeto
br.com.tabelafipe
│
├── domain
│ └── Main.java
│
├── model
│ ├── DadosDTO.java
│ ├── ModelosDTO.java
│ └── VeiculoDTO.java
│
├── service
│ ├── ConsumoApi.java
│ └── ConverteDados.java

## 🔄 Fluxo da aplicação
Usuário escolhe veículo
↓
Busca marcas na API
↓
Usuário escolhe marca
↓
Busca modelos
↓
Filtra modelos
↓
Usuário escolhe modelo
↓
Busca anos
↓
Busca dados do veículo
↓
Exibe resultado final


---

## 💻 Exemplo de uso


Digite qual tipo de veículo você deseja ver:
Carro
Moto
Caminhão

Informe o código da marca:
59

Modelos:
Gol
Voyage
Polo

Digite o modelo:
Gol

Código do modelo:
5940

Veículos encontrados:
Valor: R$ 45.000
Ano: 2020
Combustível: Gasolina