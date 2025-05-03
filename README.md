# GCT052 - Programação Orientada a Objetos

**Professor:** Dr. Johnatan Alves de Oliveira  
**Instituto de Ciências, Tecnologia e Inovação (ICTIN)**  
**Universidade Federal de Lavras - 2025/1**

## Trabalho Prático I

- **Pontos:** 10  
- **Data de entrega:** 04/05/2025 até 23:59

---

## Procedimento para a entrega

1. Crie um projeto no GitHub.
2. Crie os arquivos de código-fonte necessários para a solução da questão em **Java**.
3. Cada aluno deve ter os seus commits no GitHub.
4. Trabalho em grupo de **até 2 pessoas**.
5. Compacte a pasta criada no item 1.
6. Faça a entrega do arquivo compactado no UFLA Virtual, na tarefa destinada à prática, **e o link do GitHub do projeto**.
7. Não utilize **acentos** ou **caracteres especiais** em nomes de pastas e arquivos.
8. **Bom trabalho!**

---

## Objetivo do Projeto

Desenvolver um **Sistema de Gerenciamento de Estacionamento de Veículos** utilizando **POO em Java**.  
O sistema deve permitir:

- Registrar entrada e saída de veículos;
- Calcular tarifas de acordo com o tempo de permanência;
- Consultar status do estacionamento.

---

## Descrição do Problema

A empresa **"TÔ QUEBRADA"** possui um estacionamento com vagas para:

### 1. Carros
- **Vagas disponíveis:** 50  
- **Tarifa:** R$ 5,00/hora  
- **Tempo máximo:** 12 horas  
- **Exemplo:** 5h = R$ 25,00

### 2. Motos
- **Vagas disponíveis:** 30  
- **Tarifa:** R$ 3,00/hora  
- **Tempo máximo:** 24 horas  
- **Exemplo:** 4h = R$ 12,00

### 3. Caminhões
- **Vagas disponíveis:** 10  
- **Tarifa:** R$ 10,00/hora  
- **Tempo máximo:** 48 horas  
- **Exemplo:** 2h = R$ 20,00

### Multas por atraso

- **Carros:** R$ 5,00/hora extra  
- **Motos:** R$ 3,00/hora extra  
- **Caminhões:** R$ 10,00/hora extra  

> A multa é calculada na saída e somada ao valor total. Veículos com multa não podem entrar novamente.

---

## Objetivo do Sistema

- Controlar entrada/saída;
- Calcular tarifas;
- Impedir exceder número de vagas;
- Relatórios:
  - Vagas disponíveis;
  - Valor total arrecadado;
  - Lista de veículos estacionados.

---

## Operações do Sistema

1. **Registrar Entrada**  
   - Informar: placa, tipo de veículo, horário.
   - Verifica se há vaga disponível.

2. **Registrar Saída**
   - Calcula permanência e tarifa.
   - Verifica tempo excedido e aplica multa.
   - Remove o veículo.
   - Soma valor ao total arrecadado.

3. **Consultar Vagas Disponíveis**
4. **Consultar Veículos Estacionados**
5. **Gerar Relatório de Tarifas**

---

## Exemplo de Uso

### Entradas

1. Tipo: **Carro** | Placa: ABC-1234 | Entrada: 10h00  
2. Tipo: **Moto**  | Placa: XYZ-5678 | Entrada: 12h00  
3. Tipo: **Caminhão** | Placa: LMN-9876 | Entrada: 09h00

### Saídas

1. **Carro ABC-1234**  
   - Entrada: 10h00  
   - Saída: 15h00  
   - Tarifa: R$ 25,00  

2. **Moto LMN-1234**  
   - Entrada: 09h00  
   - Saída: 14h30  
   - Tempo: 5h30  
   - Tarifa: R$ 16,50  
   - Multa: Nenhuma  

3. **Carro XYZ-9876**  
   - Entrada: 10h00  
   - Saída: 18h00  
   - Tarifa: R$ 40,00  
   - Multa: R$ 25,00  
   - Total: R$ 65,00  

4. **Caminhão LMN-9876**  
   - Entrada: 09h00  
   - Saída: 15h00 do dia seguinte  
   - Tempo: 30h  
   - Tarifa: R$ 300,00  
   - Multa: R$ 0,00  

---

## Exemplos de Relatórios

### 1. Entrada e Saída

