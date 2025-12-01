# 📊 Portfolio Tracker
**Sistema de Gestão de Carteira de Investimentos**

Aplicação desktop desenvolvida em **Java**, com foco em **monitoramento e gestão de carteiras de investimento**, combinando **arquitetura robusta** e **experiência do usuário (UI/UX)** moderna.

**Ideia Geral**
Plataforma de gestão de carteira de investimentos, que permite acompanhar ativos e métricas essenciais, trazendo clareza e insights para decisões financeiras inteligentes.

---

## 🛠️ Stack Tecnológica e Arquitetura
O projeto foi construído utilizando os seguintes padrões e ferramentas para garantir modularidade e persistência de dados:

- **Linguagem e Design:** Java, aplicando o paradigma de Programação Orientada a Objetos (POO).  
- **Padrões de Arquitetura:** Implementação do padrão **MVC (Model-View-Controller)** adaptado, com camadas claras de:  
  - **Model:** Entidades de dados  
  - **DAO (Data Access Object):** Gerenciamento da persistência e transações com o banco de dados  
  - **View:** Interface gráfica  
- **Persistência de Dados:**  
  - Uso do **Hibernate/JPA** (Java Persistence API) para mapeamento Objeto-Relacional (ORM)  
  - Configuração e gestão do arquivo `persistence.xml`  
  - Mapeamento completo das entidades do Model para o banco de dados  
- **Interface Gráfica:**  
  - Desenvolvida em **Java Swing**, utilizando a IDE **NetBeans**  
  - Biblioteca externa de componentes visuais para melhor conforto visual  
- **Gerenciamento de Dependências:** **Apache Maven** para controle de bibliotecas e build do projeto  

---

## ⚙️ Funcionalidades Chave
- **Incorporação e Gestão de Ativos:**  
  Permite incorporar um ativo à carteira. Uma vez incorporado, é possível **comprar cotas, vender cotas, editar informações e desvincular o ativo da carteira** (vender todas as cotas disponíveis e remover da listagem).  

- **Métricas e Detalhes Personalizados:**  
  Exibição de informações específicas, como a **distribuição de cotas entre os tipos de investimento em formato de gráfico**, no painel principal e em uma dashboard.  

- **Transações:**  
  Todas as operações de compra/venda geram uma transação. É possível observar a lista dessas entradas e saídas, contendo:  
  - Tipo (Compra/Venda)  
  - Ticker  
  - Quantidade  
  - Preço Unitário  
  - Valor Total  
  - Data  

- **Listagem de Ações e FIIs:**  
  Acompanhamento da **cotação atual dos ativos** em tempo real.  
  Na listagem, estão disponíveis as opções: **Editar, Comprar, Vender e Desincorporar da Carteira**.  

- **Monitoramento Simulado de Mercado:**  
  Algoritmo interno gera valores aleatórios para simular cotações em tempo real, permitindo o cálculo dinâmico da rentabilidade.  

- **Exportação de Dados:**  
  Exportação de informações relativas a **Ativos e Transações** em arquivo `.csv`.  

---

## 📂 Estrutura do Projeto
src/
 ├── model/             # Entidades de dados
 ├── modelDAO/          # Camada DAO (persistência)
 ├── view/              # Interface gráfica (Swing)
 ├── util/              # Utilitários e helpers
 ├── modelReferencias/  # Arquivo JSON com informações mais detalhadas sobre as Ações
 └── resources/         # Arquivos de configuração (persistence.xml, etc.)



## Roadmap
[x] CRUD de ativos

[x] Registro de transações

[x] Dashboard com métricas

[x] Exportação de dados em .csv

[ ] Integração com API de mercado real

[ ] Exportação de relatórios avançados


## 👨‍💻 Autor
Desenvolvido por Vinícios 
📧 Contato: vinicioscarini10@gmail.com 
🔗 LinkedIn: https://www.linkedin.com/in/vinicios-c-2311b8301/

