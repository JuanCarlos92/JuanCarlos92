# Comandos de Git y GitHub

Este documento recopila **los comandos más importantes y usados de Git** (control de versiones) y su uso habitual con **GitHub**. Es ideal como chuleta (cheat sheet) o referencia rápida.

---

## Configuración inicial

```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tu@email.com"
git config --global core.editor "code --wait"
git config --list
```

---

## Crear o clonar repositorios

```bash
git init
git clone <url>
git clone <url> <carpeta>
```

---

## Estado y seguimiento de archivos

```bash
git status
git add <archivo>
git add .
git rm <archivo>
git mv <origen> <destino>
```

---

## Commits

```bash
git commit -m "mensaje"
git commit -am "mensaje"
git commit --amend
git log
git log --oneline
git show <hash>
```

---

## Ramas (branches)

```bash
git branch
git branch <nombre>
git checkout <rama>
git checkout -b <rama>
git switch <rama>
git merge <rama>
git branch -d <rama>
```

---

## Sincronización con GitHub (remotos)

```bash
git remote -v
git remote add origin <url>
git push origin <rama>
git push -u origin <rama>
git pull
git fetch
```

---

## Revertir y deshacer cambios

```bash
git checkout -- <archivo>
git reset <archivo>
git reset --hard
git revert <commit>
```

---

## Limpieza

```bash
git clean -f
git clean -fd
git stash
git stash save "mensaje"
git stash pop
git stash list
```

---

## Comparaciones

```bash
git diff
git diff --staged
git diff <rama1> <rama2>
```

---

## Tags

```bash
git tag
git tag v1.0
git tag -a v1.0 -m "versión 1.0"
git push origin v1.0
git push origin --tags
```

---

## Historial avanzado

```bash
git blame <archivo>
git reflog
git cherry-pick <commit>
```

---

## Autenticación con GitHub (HTTPS / SSH)

```bash
git config --global credential.helper store
ssh-keygen -t ed25519 -C "tu@email.com"
```

---

## Submódulos

```bash
git submodule add <url>
git submodule init
git submodule update
```

---

## Flujos habituales con GitHub

### Subir un proyecto nuevo

```bash
git init
git add .
git commit -m "Initial commit"
git branch -M main
git remote add origin <url>
git push -u origin main
```

### Actualizar proyecto

```bash
git add .
git commit -m "mensaje"
git push
```

---

## Comandos adicionales (completando la chuleta)

Estos comandos **no aparecen en la imagen** y son habituales en un uso real y profesional de Git/GitHub:

### Archivos y cambios

```bash
git add .
git rm <archivo>
git mv <origen> <destino>
git restore <archivo>
git restore --staged <archivo>
```

### Commits e historial

```bash
git commit -am "mensaje"
git commit --amend
git log --oneline
git log --graph --decorate --all
git reflog
git blame <archivo>
```

### Ramas (complemento)

```bash
git checkout <rama>
git checkout -b <rama>
git branch -a
git branch -D <rama>
```

### Remotos y sincronización

```bash
git remote -v
git remote remove <nombre>
git pull --rebase
git push
git push --force-with-lease
git fetch --all
```

### Reset y recuperación avanzada

```bash
git reset --soft HEAD~1
git reset --mixed HEAD~1
git reset --hard <hash>
```

### Limpieza

```bash
git clean -n
git clean -f
git clean -fd
```

### Tags

```bash
git tag
git tag v1.0
git tag -a v1.0 -m "versión 1.0"
git tag -d v1.0
git push origin --tags
```

### Stash avanzado

```bash
git stash list
git stash apply
git stash drop
git stash clear
```

### Submódulos

```bash
git submodule add <url>
git submodule init
git submodule update
git submodule update --remote
```

### Configuración y credenciales

```bash
git config --global user.name "Nombre"
git config --global user.email "email"
git config --list
ssh-keygen -t ed25519 -C "email"
```

---

## Comandos que NO existen

> `git request` **NO existe**

En GitHub, lo correcto es:

* **Pull Request** → desde la web o con GitHub CLI (`gh pr create`)

---

## Recursos útiles

* [https://git-scm.com/docs](https://git-scm.com/docs)
* [https://docs.github.com](https://docs.github.com)

---

✨ Chuleta completa y ampliada en formato Markdown (.md).
