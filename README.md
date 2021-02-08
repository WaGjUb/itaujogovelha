# itaujogovelha
jogo da velha


* nivel1: Pasta com a primeira aplicacao base e testes unitarios tem um readme!!
* nivel2e3: Pasta com o deploy da AWS, tem o README gerado pelo sam CLI e um howtorun que escrevi para explicar como roda simplificadamente (aqui tem testes unitarios e fiz direto com o template do SAM CLI e fiz deploy na minha AWS pessoal -> endpoint: https://q8oonx75l9.execute-api.sa-east-1.amazonaws.com/Prod/jogovelha)

## Notas
* nao fiz teste de stress pois nao achei necessario tendo em vista que esta rodando numa lambda na AWS sendo portanto serverless, pode roda um hey no meu endpoint se quiser mas faça com moderacao para nao estourar minhas 1M free requests. Codigo para arrebentar de requests: hey -m POST -T "application/json" -d '{"jogo": ["OOO","XOX","XOX"]}' http://ENDPOINT/jogovelha (acredite, essa ferramenta é bem poderosa, ja derrubei alguns servidores e produçao com isso (da para instalar pelo brew -> brew install hey))
* A lambda esta no container docker com a imagem do java11
