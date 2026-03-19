YasmimPortfolio - Meu Primeiro App Android

Bem-vindo ao repositório do meu primeiro projeto nativo desenvolvido no Android Studio. 
Este é um aplicativo de portfólio pessoal criado para consolidar meus estudos iniciais em Kotlin e Jetpack Compose.

Sobre mim e projeto

 Sou a Yasmim Pinheiro, estudante do 1º semestre de Análise e Desenvolvimento de Sistemas. Este app é o meu primeiro projeto nativo Android. 
Embora o mercado na minha cidade, Santa Bárbara d'Oeste - SP seja mais focado em outras áreas, escolhi o Kotlin por me apaixonar pela modernidade
e eficiência da linguagem. Usei a plataforma oficial do Google Developers para guiar meu aprendizado.

O nascimento do projeto.

Abri o Android Studio e cliquei em "New Project", escolhi o "Empty Compose Activity". Dei o nome ao projeto (YasmimDev) e o Android Studio, 
sozinho criou pastas. Assim deixando o projeto pronto com a estrutura de pastas que a google recomenda, separando o código da parte visual.

O Gradle 

 Abri o arquivo chamado build.gradle.kts (Module: app). Dentro tem um bloco chamado dependencies {...}, para meu app funcionar 
 o projeto escreveu linhas lá dentro como: implematation("androidx.navigation:navigation-compose:2.7.7"). Depois de escrever cliquei no Sync now o elefantinho azul.
 O Gradle leu o nome e foi na internet, baixou a ferramenta e instalou no meu projeto, fazendo o trabalho pesado por mim.

 O .gitignore

 Abri o arquivo que fica do lado esquerdo e escrevi nomes de pastas lá dentro, como .idea/. Fazendo com o que esteja dentro destas pastas fique
 apenas no meu computador e não para os outros. Configurando as pastas local e arquivos temporários garanti que meu repositório no GitHub ficasse 
 limpo, contendo apenas o código-fonte necessário.

 O Git e i GitHub

  Digitei git add ., para pegar todas as mudanças feitas por mim e salvar. Logo em seguida usei git commit -m, para explicar e registrae cada etapa do
  desenvolvimento da minha criação. O git push para mandar para o site do GitHub, tornando o meu aplicativo portifólio online.

Destaques do código

 O código foi desenvolvido focado em UI Declarativa e interatividade. Aqui estão os principais pontos:
 
 Gerenciamento de Estado (Dark Mode)

 Esta localizada no começo do codigo.
 
 var darkMode by remember { mutableStateOf(false) }
 
 criei uma boolean que começa desligada (false)
 O remember faz o app não esquecer se a luz está acesa ou apagada toda vez que o celular gira ou a tela atualiza. Quando você clica no
 botão, o valor muda, e o Compose "redesenha" tudo o que depende dessa cor. No estágio, chame isso de Recomposição.
 Implementei um sistema de tema dinâmico. 
 Ou seja, então usei remember e mutableStateOf para criar a variável darkMode. Quando o usuário clica no botão, 
 o app "lembra" da escolha e realiza a Recomposição, redesenhando a interface com as novas cores.

 a imagem a seguir

 

Navegação Nativa

Utilizei o NavHost para gerenciar rotas entre a tela principal e a tela de projetos. Isso permite uma experiência fluida, permitindo que o usuário navegue e volte 
(popBackStack) sem perder o contexto.

Integração com o Sistema (Intents)

O app "conversa" com o Android através de Intents Implícitos. Os botões de contato acionam automaticamente o WhatsApp ou o E-mail do celular:
Context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))

O "Botão Surpreendente" (Animações)
Este é um componente customizado que criei para explorar as APIs de animação do Compose:

Efeito de Escala: O botão diminui ao ser clicado (animateFloatAsState).

Gradiente Animado: Usei infiniteRepeatable para criar um brilho que se move constantemente no fundo do botão, proporcionando um visual moderno e fluido.

