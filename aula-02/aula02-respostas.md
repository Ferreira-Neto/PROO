# JVM, Versionamento
## Roteiro de Atividades

- Nome: Vicente Ferreira  
- Data: 23/08/2026  


---
*A JVM é uma máquina virtual Java responsável por interpretar em diferentes sistemas operacionais o "código intermediário"  byetecode gerado pelo compilador.*  

### Atividade 1: Identificando operadores

A.  
*&= (E bit a bit + atribuição)  
  |= (OU bit a bit + atribuição)  
   ^= (XOR bit a bit + atribuição)*  
   
B/C.  

int a = 2;  
int b = 3;  
a &= b;  
System.out.println(a);//2//  

int c = 12;  
int d = 3;  
c |= d;  
System.out.println(c);//15//  

int e = 5;  
int f = 3;  
e ^= f;  
System.out.println(e); //6//  
}
}  

 

---

### Atividade 2: JVM e o princípio *Write once, run anywhere*

1. _https://www.youtube.com/watch?v=EQZfuIJ49hI_  
2. Isso é possível porque a JVM converte o código em bytecode, que pode rodar em qualquer sistema operacional.  
O compilador C gera código de máquina diretamente para uma arquitetura e SO específicos, porque o formato do executável e as chamadas de sistema são diferentes. Não existe uma camada intermediária tipo JVM. Então, para rodar em outra plataforma, seria necessário recompilar o código-fonte.  

_ _  

**(c):**
- Informe o prompt exato que você utilizou:  
**Quais as diferenças entre bytecode, JVM, JRE e
JDK.**  
- Registre a resposta gerada pela IA:  

**Bytecode**  
É o arquivo gerado quando você compila seu código Java com javac. Não é código-fonte (o .java que você escreve) nem é código de máquina nativo (o que o processador executa diretamente) — é um formato intermediário, padronizado, feito de instruções simples que qualquer JVM sabe interpretar. Fica salvo no arquivo .class.

**JVM (Java Virtual Machine)**  

É o programa que executa o bytecode. Ela lê as instruções do .class e as traduz para instruções que o processador da sua máquina realmente entende — seja interpretando linha a linha, seja compilando partes com o JIT (Just-In-Time) para ganhar performance. É a JVM que existe em versões diferentes para Windows, Linux e macOS, e que torna o mesmo bytecode executável em qualquer uma dessas plataformas.

**JRE (Java Runtime Environment)**

É o pacote necessário para rodar programas Java. Contém a JVM mais as bibliotecas padrão da linguagem (classes prontas como String, ArrayList, Scanner, etc., que qualquer programa Java pode usar). Se você só precisa executar um programa Java já pronto (um .jar, por exemplo), o JRE é suficiente.

**JDK (Java Development Kit)**

É o pacote necessário para desenvolver programas Java. Contém o JRE inteiro mais as ferramentas de desenvolvimento: o compilador javac, o javap (que mostra o bytecode), depuradores, entre outras. Se você quer escrever e compilar código, precisa do JDK — é por isso que você tem, por exemplo, o jdk-26.0.2.1 instalado no seu Windows.

Resumindo em camadas
JDK
 └─ inclui o JRE
      └─ inclui a JVM
 └─ + ferramentas de desenvolvimento (javac, javap, debugger...)
Relação com "write once, run anywhere"

Você usa o JDK para escrever e compilar seu código uma única vez, gerando bytecode. Esse mesmo bytecode roda em qualquer computador que tenha um JRE instalado (que já traz a JVM certa para aquele sistema operacional) — sem precisar reescrever ou recompilar o código-fonte para cada plataforma.  
**- Registre, com suas palavras, a sua resposta:**  
Bytecode é o arquivo .class gerado pelo interpretador JVM, funciona como um código intermediário, para ser executado em diferentes SOs.  
JVM é a máquina virtual java que executa o bytecode em diferentes SO.
JRE é um pacote com recursos para rodar programas java, contendo a JVM e mais as bibliotecas padrão da linguagem.  
JDK é o pacote para desenvolver programas java, contendo o JRE inteiro, e ferramentas de desenvolvimeto, como o javac e javap.
A relação com write once, run anywhere, vem da capacidade da JDK compilar o código uma vez, gerando bytecode, e esse bytecode roda em qualquer máquina que tenha o JRE, que por sua vez acompanha a JVM certa para o SO utilizado.  

---

### Atividade 3: Criação de repositório no GitHub

- a. "git add" move as alterações do working directory para a staging area (também chamada de "index"). Ele apenas marca quais mudanças serão incluídas no próximo commit não cria nenhum registro permanente no histórico.  
"git commit" pega o que está na staging area e cria um snapshot permanente no histórico do repositório local, com um hash único, autor, data e mensagem.  
As alterações não são perdidas, elas ficam "penduradas" localmente, gravadas no disco em .git/index e no diretório de trabalho. Ao abrir o terminal e rodar git status, você verá os arquivos ainda marcados como "staged" (prontos para commit). Eles não foram enviados ao GitHub, isso só aconteceria depois de um commit seguido de push.  

- b. Indica que o repositório local e repositório remoto são duas cópias independentes do histórico, sincronizadas manualmente.  
O commit só afeta o repositório local (na sua máquina, dentro da pasta .git).  
O GitHub só sabe da existência de um commit quando você manda essa informação com git push.  
    
c. Apoio de IA:  
- Informe o prompt exato que você utilizou: o commit foi "Create readme"
Avalie se a mensagem de commit  segue boas práticas (ex.: convenção de commits semânticos, como feat:, fix:, chore:).

- Registre a resposta gerada pela IA:  
Falta o prefixo de tipo (feat:, fix:, chore:, docs:, etc.). Toda mensagem no padrão semântico começa com um tipo que categoriza a mudança. Criar/adicionar um arquivo de documentação como o README se encaixa no tipo docs:.
Verbo no infinitivo/gerúndio em inglês misturado sem padrão — "Create" está no imperativo em inglês, o que até é aceitável (a convenção recomenda modo imperativo: "add", não "added" ou "adding"), mas fica inconsistente se o resto do projeto for documentado em português.
Mensagem genérica demais — não deixa claro o que exatamente foi adicionado ou por quê, embora para um README simples isso seja mais tolerável.

- Com base na resposta da IA, reescreva sua mensagem de commit seguindo a convenção sugerida e explique, em uma frase, por que mensagens de commit padronizadas são úteis em projetos colaborativos.  
Sugestão de reescrita seguindo a convenção:
docs: adicionar README Repositório de exercícios da disciplina de POO.  
ou, mantendo em inglês para consistência com convenções internacionais:  
docs: add README with Repository of exercises for the OOP.    
Mensagens padronizadas facilitam a leitura do histórico do projeto por qualquer pessoa da equipe, permitem gerar changelogs automaticamente e tornam mais fácil localizar quando e por que uma mudança específica foi feita.  

---

### Atividade 4: Exercícios HackerRank

https://github.com/Ferreira-Neto/poo-ifsp-2026-Vicente-Ferreira/tree/main/hackerrank/src/aula02
