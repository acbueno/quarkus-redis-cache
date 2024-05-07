# Quarkus Redis Cache

Este é um exemplo simples de como usar o Redis como um mecanismo de cache em um aplicativo Quarkus.

## Pré-requisitos

- Java 11 ou superior instalado
- Docker e Docker Compose (opcional, apenas se você quiser executar o Redis localmente)

## Como usar

1. Clone este repositório: `git clone https://github.com/acbueno/quarkus-redis-cache.git`
2. Navegue até o diretório do projeto: `cd quarkus-redis-cache`
3. Execute o Redis usando Docker Compose (opcional): `docker-compose up -d`
4. Execute o aplicativo Quarkus: `./mvnw compile quarkus:dev`
5. Acesse `http://localhost:8080/cache` para ver o cache sendo utilizado.

## Configuração do Redis

O Redis é configurado usando as propriedades do aplicativo no arquivo `application.properties`. Certifique-se de ajustar as configurações conforme necessário para o seu ambiente.

## Contribuição

Sinta-se à vontade para contribuir com novas funcionalidades, correções de bugs ou melhorias de código. Basta enviar um pull request!

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.
