# Password Validator API

API para validações de senha. Para ser considerada uma senha válida, deve atender os seguintes requisitos:
* 9 ou mais caracteres;
* Ao menos 1 dígito;
* Ao menos 1 letra minúscula;
* Ao menos 1 letra maiúscula;
* Ao menos 1 caractere especial (!@#$%^&*()-+);
* Não possuir caracteres repetidos dentro do conjunto;
* Não possuir espaços em branco.

Observação: é recomendado que os caracteres especiais sejam passados em sua versão codificada para evitar erros (por serem caracteres "reservados" para as URIs), conforme tabela abaixo:

| Caractere | Encoded |
|-----------|---------|
| !         | %21     |
| @         | %40     |
| #         | %23     |
| $         | %24     |
| %         | %25     |
| ^         | %5E     |
| &         | %26     |
| *         | %2A     |
| (         | %28     |
| )         | %29     |
| -         | %2D     |
| +         | %2B     |

---

## **Endpoint**
  /password/validate

* **Método:**\
  `GET`

* **URL Params**

   **Obrigatório:**

   `password={String}`

* **Exemplos de resposta:**

    * **Code:** 200 OK <br />
      **Content:**
   ```json
   true
   ```

  * **Code:** 400 Bad Request <br />
    **Content:**
   ```json
   {
       "status": 400,
       "details": "Required request parameter 'password' for method parameter type String is not present"
   }
   ```
  
---
## **Arquitetura:**

![Alt text](https://user-images.githubusercontent.com/51386403/157382746-ae8ec16c-1c5c-4ecc-86f9-000e3f840b06.png "Arquitetura")
* 1 - Controller conversa com a porta de entrada sem conhecer as classes que possuem as regras de negócio;
* 2 - Service constrói a cadeia de responsabilidade e conversa com a classe abstrata responsável por definir se a senha é válida ou não;
* 3 - Classe abstrata define métodos a serem implementados pelas classes filhas (cada uma possuirá uma regra de validação especifica dentro da cadeia) e possuí métodos em comum entre elas.

---
## **Fluxograma:**

![Alt text](https://user-images.githubusercontent.com/51386403/157355440-67ff2507-2112-4c49-8a1a-ec57b83c04f3.png "Fluxograma")

---
Para rodar o projeto, clone-o na sua máquina e execute a classe: br.com.passwordvalidator.PasswordValidatorApiApplication, o serviço rodará na porta 8080.