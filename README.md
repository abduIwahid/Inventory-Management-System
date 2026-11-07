# Inventory Management System

An OOP-based **Java** desktop application (built in NetBeans) for managing products, stock levels, sales, and suppliers — developed as a semester lab project.

## Features

- Add, update, view, and remove inventory items through a structured GUI
- Separate handling for **perishable** and **non-perishable** products (inheritance)
- Real-time stock tracking with file-based data persistence
- Sales and supplier records alongside product data
- Encapsulated, class-based design intended to scale to larger business operations

## Design highlights

- **OOP principles:** classes, inheritance (`PerishableItem`, `NonPerishableItem` extend the base item model), and encapsulation throughout
- **File handling:** dedicated `FileManager` / `FileHandler` classes keep storage separate from the UI
- **GUI forms:** Swing-style forms (e.g. `ItemForm`) for data entry

## Repository contents

```
Inventory Management System/
├── Documentation/     # Project description, final report, UML diagram (PDF)
├── src/               # Java sources (Item, Inventory, InventoryApp, forms, file handling)
└── build.xml          # NetBeans / Ant build file
```

## Run locally

1. Open the project in **NetBeans** (or any IDE that reads Ant `build.xml` projects).
2. Build and run — the main class is `InventoryApp`.

## Author

**Abdul Wahid** — BS Artificial Intelligence, COMSATS University Islamabad (Attock Campus)
GitHub: [github.com/abduIwahid](https://github.com/abduIwahid)
