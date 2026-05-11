# 📚 JAVA MEDIA ARCHIVE
A small terminal-based media archive written in Java.

This project lets you **add**, **show**, **remove**, **edit** and **search for** media entries in an archive.  
Currently supported media types:
- **Books**
- **DVDs**

This repo was created as a learning project to practice Java fundamentals (OOP, collections, simple menu handling, and clean structuring).

---

## ▶️ STATUS
⏸️ Paused

All basic features are implemented and the program is working the way it should.
Some features (see **features**, roadmap) may be added in the future.

---

## 💡 FEATURES
Implemented Features:
- **Persistent entries**
  - entries are saved in a .csv-file and loaded upon starting the program
    
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
 
- **Tags and Status**
  - via the editing Option, tags can be added and the status can be changed
  - both displayed on the show tab
  - preparation for search by tag 


Roadmap:
- **Search by tag**
  - prepared, but not yet implemented
- **Search by other characteristics**
  - e.g. status, author, category (book, dvd,...)
- **More types of media**
  - shows/movies instead of dvd
  - possibly option to create own types in the program itself
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
This is the second of six small projects I do ahead of starting my CS degree. As such, it is a learning project and mirrors my skills and
and knowledge at that time.
I am always happy about feedback and constructive criticism
````*
