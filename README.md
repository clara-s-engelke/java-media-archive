# 📚 JAVA MEDIA ARCHIVE
A small terminal-based media archive written in Java.

This project lets you **add**, **show**, and **remove** media entries in an archive.  
Currently supported media types:
- **Books**
- **DVDs**

This repo was created as a learning project to practice Java fundamentals (OOP, collections, simple menu handling, and clean structuring).

---

## ▶️ STATUS
🚧 In progress / learning project

Core features are implemented, but the project is still evolving and will change in the following weeks

---

## 💡 FEATURES
What you can do right now:
- **Add media**
  - Choose between **Book** and **DVD**
  - Enter title + release year
  - Book-specific fields: author, ISBN (optional), pages
  - DVD-specific fields: director, duration (minutes)
- **Show archive**
  - Prints a sorted list of all items with their info
- **Remove media**
  - Pick an item from the current archive and remove it
- **Search media**
  - using a simple search algorithm, it is possible to search pieces of media by their title

---

## ▶️ How to run

### Requirements
- **Java 21 (JDK)** installed (`java -version` should show 21.x)
- Any terminal (Windows Terminal / macOS Terminal / Linux shell)

### 1) Get the code
```bash
git clone https://github.com/clara-s-engelke/java-media-archive.git
cd java-media-archive
```

### 2) Compile
This project uses plain `javac` (no Maven/Gradle).

**macOS / Linux:**
```bash
mkdir -p bin
find src -name "*.java" | xargs javac -d bin
```

**Windows (PowerShell):**
```powershell
New-Item -ItemType Directory -Force bin | Out-Null
Get-ChildItem -Recurse -Filter *.java -Path src | ForEach-Object { $_.FullName } | javac -d bin @-
```

### 3) Run


---

## 🔧 TOOLS
- Java (21 JDK)
- IntelliJ IDEA
- Git/GitHub

---

## 📌 NOTES
This project is part of learning Java. The structure and code style will likely change as I improve.  
Feedback and suggestions are very welcome.
````*
