# Password Validator API

API para validações de senha. Para ser considerada uma senha válida, deve atender os seguintes requisitos:
* 9 ou mais caracteres;
* Ao menos 1 dígito;
* Ao menos 1 letra minúscula;
* Ao menos 1 caractere especial (!@#$%^&*()-+);
* Não possuir caracteres repetidos dentro do conjunto;
* Não possuir espaços em branco.
---

## **Endpoint**
  /password/validate

* **Método:**\
  `GET`

* **URL Params**

   **Obrigatório:**

   `password={String}`

* **Exemplo de resposta:**

    * **Code:** 200 OK <br />
      **Content:**
   ```json
   true
   ```
  
---
## **Arquitetura:**

![Alt text](https://user-images.githubusercontent.com/51386403/157352666-c505f249-208c-426c-82ca-2ec905d51804.png "Arquitetura")
* 1 - Controller conversa com a porta de entrada sem conhecer as classes que possuem as regras de negócio;
* 2 - Service constrói a cadeia de responsabilidade e conversa com a classe abstrata responsável por definir se a senha é válida ou não;
* 3 - Classe abstrata define métodos a serem implementados pelas classes filhas (cada uma possuirá uma regra de validação especifica dentro da cadeia) e possuí métodos em comum entre elas.

---
## **Fluxograma:**

![Alt text](https://user-images.githubusercontent.com/51386403/157355440-67ff2507-2112-4c49-8a1a-ec57b83c04f3.png "Fluxograma")