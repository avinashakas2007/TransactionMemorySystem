# TransactionMemorySystem

````markdown
# 🧠 Java In-Memory Key-Value Store

Welcome to the **Java Memory Management System** — a lightweight, interactive CLI application that lets you store, retrieve, update, and manage key-value pairs in memory, with simple **transaction-like operations**.

## 🚀 Features

✅ SET, GET, UPDATE, UNSET variables  
✅ COUNT the number of occurrences of a value  
✅ BEGIN, COMMIT, ROLLBACK transactions  
✅ Temporary vs Final memory distinction  
✅ Simple command-line interface  

---

## 💻 How It Works

The system uses two `HashMap`s:
- `tempmemomry`: holds temporary (uncommitted) changes.
- `finalmemory`: holds committed (final) data.

```plaintext
SET a 10         -> Stores `a = 10` in temp
GET a            -> Returns 10
BEGIN            -> Moves committed data to temp
UPDATE a 20      -> Changes `a` to 20 in temp
ROLLBACK         -> Discards temp changes
COMMIT           -> Saves temp to final
````

---

## 🧪 Example Commands

Try these after running the program:

```
SET name Alice
GET name
BEGIN
UPDATE name Bob
GET name
ROLLBACK
GET name
COMMIT
```

Expected Output:

```
Alice
Bob
Alice
```

---

## 📦 Installation & Running

### Requirements

* Java 8 or higher

### Run it locally

```bash
javac Main.java
java Main
```

Then enter your commands interactively in the terminal.

---

## 🛠 Available Commands

| Command          | Description                                |
| ---------------- | ------------------------------------------ |
| `SET var val`    | Sets a variable to a value                 |
| `GET var`        | Gets the value of a variable               |
| `UPDATE var val` | Updates value if variable exists           |
| `UNSET var`      | Removes variable from temp memory          |
| `COUNT val`      | Counts number of variables with this value |
| `BEGIN`          | Starts a new transaction                   |
| `COMMIT`         | Saves temp changes to final memory         |
| `ROLLBACK`       | Discards uncommitted changes               |

---

## 🧠 Behind the Scenes

This project showcases:

* ✅ Java Collections (`HashMap`, `ArrayList`)
* ✅ Command parsing and control flow
* ✅ Memory state management
* ✅ Simulated transactions

---

## 🙌 Contributing

Feel free to fork, improve, and contribute!

1. 🍴 Fork the repo
2. 🔧 Make changes
3. 🔁 Submit a Pull Request

---

## 👨‍💻 Author

Made with ❤️ by [Avinash](#)

---
