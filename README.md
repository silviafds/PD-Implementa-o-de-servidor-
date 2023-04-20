# **Autenticação e Autorização em um Sistema Distribuído**

Este projeto consiste em uma aplicação de autenticação e autorização de acesso desenvolvido em Java para a disciplina Programação Distribuída da Profa. Dra. Thais Vasconcelos Batista da UFRN no semestre 2023.1.

# Instalando e executando

Com o terminal aberto no diretório em que deseja baixar o projeto, digite:

    $ git clone https://github.com/silviafds/PD-servidor-RMI.git

Entre no diretório `src` do projeto do Servidor com:

    $ cd Servidor/src/

Para compilar, digite:
    
    $ javac autenticacao/RMI/Servidor.java 

E para executar o Servidor, digite:

    $ java autenticacao/RMI/Servidor

Agora, abra outro terminal na pasta raíz do repositório e entre no diretório `src` do projeto do Cliente com:

    $ cd Cliente/src/

Compile digitando:

    $ javac autenticacao/RMI/Cliente.java

E execute o Cliente com:

    $ java autenticacao/RMI/Cliente

Agora você pode testar o sistema de autenticação e autorização com sucesso.

Caso deseje, é possível executar o Cliente com alguns arquivos de input pré-definidos. Para isso, basta executar um dos seguintes comandos:

    $ java autenticacao/RMI/Cliente < inputUsuarios.txt
    $ # OU
    $ java autenticacao/RMI/Cliente < inputOperacoes.txt
    $ # OU
    $ java autenticacao/RMI/Cliente < input.txt


> Observação: O Servidor já deve estar em execução.
---

Desenvolvido por [Diego](https://github.com/diegofilbal) e [Silvia](https://github.com/silviafds).