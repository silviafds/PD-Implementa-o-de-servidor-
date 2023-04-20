# **Autentica��o e Autoriza��o em um Sistema Distribu�do**

Este projeto consiste em uma aplica��o de autentica��o e autoriza��o de acesso desenvolvido em Java para a disciplina Programa��o Distribu�da da Profa. Dra. Thais Vasconcelos Batista da UFRN no semestre 2023.1.

# Instalando e executando

Com o terminal aberto no diret�rio em que deseja baixar o projeto, digite:

    $ git clone https://github.com/silviafds/PD-servidor-RMI.git

Entre no diret�rio `src` do projeto do Servidor com:

    $ cd Servidor/src/

Para compilar, digite:
    
    $ javac autenticacao/RMI/Servidor.java 

E para executar o Servidor, digite:

    $ java autenticacao/RMI/Servidor

Agora, abra outro terminal na pasta ra�z do reposit�rio e entre no diret�rio `src` do projeto do Cliente com:

    $ cd Cliente/src/

Compile digitando:

    $ javac autenticacao/RMI/Cliente.java

E execute o Cliente com:

    $ java autenticacao/RMI/Cliente

Agora voc� pode testar o sistema de autentica��o e autoriza��o com sucesso.

Caso deseje, � poss�vel executar o Cliente com alguns arquivos de input pr�-definidos. Para isso, basta executar um dos seguintes comandos:

    $ java autenticacao/RMI/Cliente < inputUsuarios.txt
    $ # OU
    $ java autenticacao/RMI/Cliente < inputOperacoes.txt
    $ # OU
    $ java autenticacao/RMI/Cliente < input.txt


> Observa��o: O Servidor j� deve estar em execu��o.
---

Desenvolvido por [Diego](https://github.com/diegofilbal) e [Silvia](https://github.com/silviafds).