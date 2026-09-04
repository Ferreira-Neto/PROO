# Estruturas de controle. Wrappers e autoboxing
## Roteiro de Atividades

- Nome: Vicente Ferreira
- Data: 03/09/2026

---

### Atividade 1: Wrappers e autoboxing e a armadilha do ‘==‘  

- 1.2  
Par dentro da faixa(== ): true  
Par dentro da faixa (.equal()): true  
Par dentro da faixa(== ): false  
Par dentro da faixa (.equal()): true

- 3  
Com valor_1 127  
Par dentro da faixa(== ): true  
Par dentro da faixa (.equal()): true  
Par dentro da faixa(== ): false  
Par dentro da faixa (.equal()): true  

  Com valor_ 128  
  Par dentro da faixa(== ): false  
  Par dentro da faixa (.equal()): true  
  Par dentro da faixa(== ): false  
  Par dentro da faixa (.equal()): true  

- **A-**  Quando se cria a variável Integer x1 = 100, o Java faz o autoboxing, convertendo automaticamente o int literal 100 em um objeto Integer, Só que a JVM mantém um cache interno("Integer pool"), com objetos Integer já criados para todos os valores entre -128 e 127. Quando é feito autoboxing de um valor dentro dessa faixa, o Java reaproveita o mesmo objeto cache em vez de criar um novo, por isso x1 == x2 da true, as duas variáveis apontam para o mesmo objeto na memória.  
Já para valor fora da faixa(200), não existe cache, cada autoboxing cria um objeto novo na memória. Por isso y1 == y2 da false, são dois objetos diferentes, mesmo tendo o mesmo valor 200 dentro deles. O .equals() sempre da true porque ele compara os valores dos objetos.  
  
- **B-** Isso não é uma falha de projeto, é um comportamento documentado na especificação da JLS, que exige que as implementações de Java façam cache de Integer no intervalo -128 a 127 como otimização de memória, evitando criar objetos repetidos para valores pequenos, muito comuns em código. A evidência que sustenta é a mudança no resultado exatamente no limite dos valores, se fosse um bug aleatório não haveria essa mudança no resultado padronizada no limite dos valores.  

- **C-**  
• Informe o prompt exato que você utilizou:  
Explique o mecanismo de cache
de Integer (também chamado de "Integer pool") na especificação da linguagem Java  

• Registre a resposta gerada pela IA:  

Mecanismo de cache de Integer ("Integer pool") na especificação Java  
O que a especificação diz:  
A Java Language Specification (JLS), na seção sobre conversões de boxing (autoboxing), estabelece uma regra específica: ao fazer o boxing de um valor do tipo primitivo byte, short, char, int ou long que esteja dentro de determinadas faixas, o compilador deve produzir referências para objetos já existentes, reaproveitando-os, em vez de criar objetos novos toda vez.  
Para o tipo int (que gera objetos Integer), essa faixa garantida pela especificação é exatamente -128 a 127.  
Por que existe essa faixa  
A ideia por trás disso é otimização de memória e performance. Valores pequenos, especialmente entre -128 e 127, são extremamente comuns em programas Java (contadores, índices de loops, códigos de status, etc.). Se cada autoboxing desses valores criasse um objeto novo, o programa geraria uma quantidade enorme de objetos Integer repetidos e descartáveis, sobrecarregando o garbage collector à toa.  
Para evitar isso, a JVM mantém internamente um array/cache pré-populado com um objeto Integer para cada valor entre -128 e 127 — geralmente chamado de "Integer Cache" ou "Integer pool". Esse cache é criado na classe interna Integer.IntegerCache, que existe desde o Java 5 (quando o autoboxing foi introduzido).  
Como funciona na prática  
Quando você escreve:  
java  
Integer x = 100;  
o compilador transforma isso, por trás dos panos, em algo equivalente a:  
java  
Integer x = Integer.valueOf(100);  
O método Integer.valueOf(int) é o que consulta o cache: se o valor pedido estiver entre -128 e 127, ele retorna a referência para o objeto já existente no cache, em vez de instanciar um novo Integer com new Integer(...). Fora dessa faixa, valueOf cria um objeto novo a cada chamada.  
Isso explica por que dois Integer com o mesmo valor pequeno (100 e 100) resultam em == verdadeiro (mesma referência de objeto no cache), enquanto dois Integer com o mesmo valor grande (200 e 200) resultam em == falso (objetos diferentes, mesmo tendo o mesmo valor interno).  
Ponto importante da especificação  
A JLS garante o cache obrigatoriamente apenas para essa faixa (-128 a 127). Implementações da JVM podem, opcionalmente, estender esse cache para valores maiores (e o Hotspot/OpenJDK permite inclusive configurar esse limite superior via a flag -XX:AutoBoxCacheMax=), mas não é garantido por padrão fora da faixa oficial — por isso o comportamento fora de -128 a 127 não deve ser assumido como confiável em código real, e a comparação de valores Integer sempre deveria ser feita com .equals(), nunca com ==.  

• A explicação da IA menciona explicitamente a faixa de valores [−128,127]? Compare
como resultado observado no passo 4 — a explicação é consistente com o comportamento
que você mediu experimentalmente?  
Sim, é mencionado a faixa de valores (-128 a 127), e foi consistente com o teste. Por isso para comparações de valores Integer deve sempre ser usado ".equals()".  




### Atividade 2: Coerção de Tipos x Casting — Onde está a diferença?  

- **A-**
  1 = Coerção int para long widening  
  2 = Coerção int para long  
  3 = Coerção int para float  
  4 = Coerção float para double  
  5 = Casting double para long. Precisa do (long) explícito, é narrowing perde a parte decimal  
  6 = Coerção int * float = float. A multiplicação já resulta em float automaticamente  
  7 = Casting double para int. Precisa do (int) explícito, é narrowing perde a parte decimal  
  
- **B-**
O casting de double/float para tipos inteiros em Java não arredonda, ele trunca (descarta) a parte decimal, sempre "cortando para baixo" em direção a zero. Por isso 7.8 vira 7, não 8. Se fosse -7.8, viraria -7 (trunca em direção a zero, não "para baixo" no sentido matemático). Para arredondar de verdade, seria necessário usar Math.round() antes do casting.  
  
- **C-**
• Informe o prompt exato que você utilizou:

Identifique a diferença entre coerção e casting, e  por que a linguagem Java exige que o programador escreva o casting explicitamente em conversões que podem causar perda de dados (narrowing), mas permite que o compilador faça a coerção sozinho em conversões que não perdem dados (widening) ?
Exemplo de uma conversão que, mesmo sendo "widening" ainda pode causar pequena perda de precisão em Java.  

• Registre a resposta gerada pela IA:  

Diferença entre coerção e casting  
Coerção (também chamada de conversão implícita ou widening conversion) é quando o compilador faz a conversão de tipo automaticamente, sem que o programador precise escrever nada explícito. Isso acontece em conversões consideradas "seguras" — de um tipo menor para um tipo maior (int → long → float → double), onde, em teoria, nenhuma informação é perdida.  
Casting é quando o programador precisa escrever explicitamente a conversão, usando a sintaxe (tipo) valor. Isso é exigido em conversões consideradas "arriscadas" — de um tipo maior para um tipo menor (narrowing), como double → int ou long → int, onde existe risco real de perda de dados (parte decimal truncada, ou até overflow se o valor for grande demais para o tipo de destino).  

Por que Java exige o casting explícito só no narrowing  
A exigência do casting explícito funciona como uma proteção deliberada de design da linguagem: o compilador força o programador a "assinar embaixo", reconhecendo conscientemente que aquela conversão pode perder dados. Se o Java permitisse narrowing implícito (sem casting), seria fácil perder precisão sem perceber — por exemplo, atribuir sem querer um double com casas decimais importantes a uma variável int, e só descobrir o bug quando o programa já estivesse rodando em produção.  
Já no widening, como a conversão nunca perde dados (um int sempre cabe perfeitamente em um long, por exemplo), não há motivo para exigir essa "assinatura" do programador — o compilador pode fazer a conversão automaticamente, com segurança.  
Em resumo: o casting explícito é uma barreira posta pela linguagem para que erros de perda de dados sejam decisões deliberadas e visíveis no código, não acidentes silenciosos.  

Exemplo de widening que ainda perde precisão  
Embora tecnicamente seja "widening" (de um tipo com menos bits para um com mais bits), a conversão de long para float (ou long para double) pode perder precisão, mesmo sem exigir casting explícito:  

java  
public class WideningComPerda {  
    public static void main(String[] args) {  
        long numeroGrande = 123456789123456789L;  
        float comoFloat = numeroGrande; // widening implícito, SEM casting  

        System.out.println("long:  " + numeroGrande);  
        System.out.println("float: " + comoFloat);  
    }  
}  

Saída esperada:  
long:  123456789123456789  
float: 1.23456792E17  

Por que isso acontece: long usa 64 bits para armazenar um número inteiro exato. Já float também usa apenas 32 bits no total, dos quais só uma parte (a mantissa, cerca de 24 bits) é dedicada a representar os dígitos significativos do número — o restante é usado para o expoente. Isso significa que float (e mesmo double, com sua mantissa de 52 bits) não tem "casas" suficientes para representar exatamente números inteiros muito grandes. O valor é arredondado para o float mais próximo que a representação de ponto flutuante consegue expressar, perdendo os dígitos menos significativos.  
Esse é o exemplo clássico citado quando se fala de "widening com perda de precisão": a conversão é permitida sem casting (porque tecnicamente float tem uma faixa de valores maior que long), mas isso não garante que o valor exato seja preservado — só garante que o valor convertido não vai "estourar" a faixa representável do tipo de destino.  
  


