# Java Hello World

- Nome: Vicente Ferreira
- Data: 17/08/2026

---

### Atividade 1: Explorar IntelliJ

a. Qual o papel do debug realizado neste tutorial?

Identificar o erro do código.

b. O que significa `values.length` solicitado no passo 12 e por que ele é necessário?

Faz a leitura da quantidade de valores fornecidos. É necessário para corrigir o calculo, ao invés de retorna apenas a soma(result), ele fornece a quantidade de valores fornecidos para a divisão do calculo da média.

c. Você observou algum recurso novo para você nesta atividade? Cite todos os que você observou.

Intellij, e identificação de erros pelo debug.

---

### Atividade 2: Escrever o programa Hello World

a. Quais foram suas principais dificuldades para realizar esta atividade?

Sem dificuldades, apenas entender a diferença em Java.

b. Qual a versão do JDK que você utilizou nesta atividade?

oracle openjdk 26.0.2

---

### Atividade 3: Explorando os tipos primitivos e mensagens de erro

a. Qual a utilidade do tipo primitivo `boolean`?  
Valores lógicos true ou false (verdadeiro ou falso).


b. Quais foram os erros que você produziu? As mensagens de erro identificaram os problemas corretamente? Eram claras?

Erros de sintaxe, como falta do ";" e uso errado de alguns operadores lógicos.
Os erros foram identificados de maneira clara, sinalizando em qual linha do código e o tipo do erro.


c. Você encontrou, ou conhece, algum outro operador da linguagem não mencionado nesta atividade?

Operadores de incremento/decremento: ++ e --  
Operador de resto: %  
Operadores lógicos: && (E), || (OU), ! (negação)  
Operador ternário: ? :  

---

### Atividade 4: Explorando o Netbeans

a. Quais as principais diferenças que você observou entre IntelliJ e Netbeans?

Visual, escolha de linguagem na criação de projetos e autocomplete mais desenvolvido no Intellij.

b. Com apoio da IA, explique o que é IDE e qual a importância para o desenvolvimento de software. Informe o prompt que você usou. Informe a resposta gerada pela IA.

- **Prompt utilizado:** O que é IDE e qual a importância para o desenvolvimento de software ?
- **IA utilizada:** Gemini
- **Resposta gerada pela IA:**  
Uma IDE (Integrated Development Environment ou Ambiente de Desenvolvimento Integrado) é um software que reúne todas as ferramentas necessárias para criar, testar e depurar programas em uma única interface centralizada.
Componentes Principais de uma IDE
- Editor de Código: Inclui destaques de sintaxe (syntax highlighting), autocompletar inteligente (IntelliSense) e formatação automática.
- Compilador / Interpretador: Traduz o código-fonte em linguagem executável diretamente no ambiente.
- Depurador (Debugger): Permite inspecionar variáveis, analisar a memória e executar o código linha por linha com pontos de interrupção (breakpoints) para encontrar falhas.
- Ferramentas de Build e Automação: Gerenciam dependências, compilações complexas e testes unitários.
- Controle de Versão: Integração nativa com Git para criar branches, visualizar diferenças e realizar commits.
Importância no Desenvolvimento de Software  
- Ganho de Produtividade: Elimina a necessidade de alternar manualmente entre editores de texto soltos, terminais e compiladores externos.
- Detecção Precoce de Erros: Aponta falhas de sintaxe e tipos incorretos em tempo real, enquanto o código está sendo digitado.
- Refatoração Segura: Permite renomear variáveis, métodos ou classes em todo o projeto com um único comando sem quebrar dependências.
- Gestão de Projetos Grandes: Organiza centenas de arquivos de código, bibliotecas e configurações de maneira legível e navegável.
Exemplos Populares: VS Code, Visual Studio, IntelliJ IDEA, PyCharm e Eclipse.

---

### [Extra] Atividade 5: Novo recurso a partir do Java 21

**Registro do uso de IA (passo 1):**

- **Prompt fornecido:** Como habilitar o parâmetro --enable-preview no IntelliJ e no Netbeans para usar o recurso de Unnamed classes e Instance Main Methods do Java 21?  
- **IA utilizada:** ChatGPT  
- **Resposta da IA:** No IntelliJ, vá em File > Settings > Build, Execution, Deployment > Compiler > Java Compiler. Em 'Additional command line parameters', adicione --enable-preview. No Netbeans, vá em Properties do projeto, em 'Run', adicione --enable-preview em 'VM Options'. Ambos precisam estar usando JDK 21 ou superior.  

a. Este novo recurso é útil? Por quê?



b. Você conseguiu resolver o problema na primeira interação com a IA? Explique.

Sim, a versão que usei do JDK é a 26, então não havia necessidade do comando "--enable-preview".
Foi resolvido tirando a declaração "package app;" arquivos com void main() (chamados de "compact source files") não aceitam a declaração package.
O arquivo deve estar diretamente na pasta src (raiz), não dentro de uma pasta app.
