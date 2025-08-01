# 🧪 Automação de Formulário com Selenium + TestNG

Este projeto é uma automação de testes funcional para o formulário disponível em [DemoQA - Automation Practice Form](https://demoqa.com/automation-practice-form).  
Ele foi desenvolvido em **Java**, utilizando **Selenium WebDriver**, **TestNG** e **Maven** para gerenciamento de dependências.  
Além disso, o projeto possui integração com **GitHub Actions** para execução automática dos testes (CI/CD).

---

## ✅ Tecnologias Utilizadas
- **Java 17**
- **Maven**
- **Selenium WebDriver**
- **TestNG**
- **WebDriverManager**
- **GitHub Actions** (Pipeline CI)

---

## ✅ Estrutura do Projeto
```
form-automation-JAVA/
├── pom.xml
├── .gitignore
├── .github/workflows/ci.yml       # Pipeline CI no GitHub Actions
└── src/
    ├── main/java                  # (Não utilizado neste projeto)
    └── test/java/
        └── tests/
            ├── AppTest.java       # Teste simples 
            └── FormTest.java      # Teste completo do formulário
```

---

## ✅ Funcionalidades Automatizadas
✔ Preenche nome e sobrenome  
✔ Preenche e-mail  
✔ Seleciona gênero  
✔ Preenche telefone  
✔ Seleciona hobby  
✔ Faz upload de arquivo  
✔ Submete formulário  
✔ Valida modal de confirmação  

---

## ✅ Pré-requisitos
- **Java JDK 17+** instalado
- **Maven** instalado e configurado no PATH
- **Google Chrome** instalado (WebDriverManager baixa o driver automaticamente)

Verifique as versões:
```bash
java -version
mvn -version
```

---

## ✅ Como Executar os Testes Localmente
Clone o repositório:
```bash
git clone git@github.com:SEU_USUARIO/form-automation.git
cd form-automation
```

Execute os testes:
```bash
mvn clean test
```

---

## ✅ Pipeline CI com GitHub Actions
Este projeto possui um workflow que executa os testes automaticamente em cada **push** ou **pull request** na branch `main`.  
Arquivo do pipeline:  
```
.github/workflows/ci.yml
```

---

## ✅ Melhorias Futuras
- Integração com **Allure Reports** para relatórios gráficos
- Estrutura com **Page Object Pattern**
- Execução paralela de testes
- Suporte a múltiplos navegadores

---

## ✅ Autor
**Luis Perfeito**  
Desenvolvido como projeto prático para portfólio de **automação de testes** com CI/CD.
