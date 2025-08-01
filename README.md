# 🧪 Automação de Formulário com Selenium + TestNG

Este projeto demonstra a automação de testes utilizando **Java + Selenium + TestNG**.  
Ele automatiza o preenchimento do formulário disponível no site [DemoQA](https://demoqa.com/automation-practice-form) e valida o envio com sucesso.

---

## ✅ Tecnologias Utilizadas
- **Java 17**
- **Maven** (gerenciamento de dependências)
- **Selenium WebDriver** (automação do navegador)
- **TestNG** (framework de testes)
- **WebDriverManager** (gerenciamento automático de drivers)
- **GitHub Actions** (CI/CD)

---

## ✅ Recursos do Projeto
✔ Preenche os campos obrigatórios do formulário  
✔ Faz upload de arquivo  
✔ Submete o formulário  
✔ Valida a abertura do modal de confirmação  
✔ Pipeline automatizado com GitHub Actions  

---

## ✅ Como Executar Localmente
Pré-requisitos:
- **Java JDK 17+**
- **Maven** instalado e configurado no PATH
- **Google Chrome** instalado

Passos:
```bash
git clone git@github.com:SEU_USUARIO/NOME_REPOSITORIO.git
cd NOME_REPOSITORIO
mvn clean test
```

---

## ✅ Pipeline CI/CD
O projeto inclui um workflow do GitHub Actions que:
1. Baixa o código do repositório
2. Instala dependências
3. Executa os testes em ambiente **headless** (sem interface gráfica)

Arquivo do pipeline:
```
.github/workflows/ci.yml
```

---

## ✅ Melhorias Futuras
- Relatórios com **Allure Reports**
- Estruturação com **Page Object Pattern**
- Execução paralela em múltiplos navegadores

---

## ✅ Autor
**Luis Perfeito**  
Projeto criado para fins de estudo e demonstração de práticas de automação e integração contínua.
