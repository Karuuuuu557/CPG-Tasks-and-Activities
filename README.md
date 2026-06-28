# CPG Tasks and Activities

A compilation of laboratory exercises and activities for **Computer Programming with Graphics (CPG)**, focusing on **Java Swing and AWT** — the foundational GUI frameworks in Java.

## 📂 Repository Structure

```
CPG-Tasks-and-Activities/
└── LABACTCOMPILATION/
    ├── bin/                # Compiled .class files
    └── src/                # Java source files (.java)
```

## 📋 Table of Contents

### 🔘 Buttons
| File | Description |
|------|-------------|
| `ButtonDemo.java` | AWT Frame with Red, Green, and Blue buttons that change the background color on click. |
| `ButtonExample.java` | Swing JFrame with a button that clears the text in a text field. |
| `SwingApplication.java` | A simple Swing app that tracks and displays the number of button clicks. |
| `ALSAMPLE1.java` | Demonstrates `ActionListener` — appends text to a text area each time a button is clicked. |

### ☑️ Checkboxes
| File | Description |
|------|-------------|
| `CheckBoxDemo.java` | A basic Swing checkbox panel with Chin, Glasses, Hair, and Teeth options and a Go button. |
| `CheckBoxExample.java` | A "McdoLibee Ordering System" — checkboxes for Burger, Fries, and Coke Float with an order total. |

### 🔽 Combo Boxes (Drop-down Lists)
| File | Description |
|------|-------------|
| `JComboBoxTest.java` | A subject selector combo box that displays the selected subject in a text field. |
| `JComboBoxTest2.java` | A color picker combo box with action and item listeners that log events to the console. |
| `Places.java` | A city/location selector (Caloocan, Makati, Taguig, Bulacan, Cavite) with an item listener. |
| `Places1.java` | An extended location picker with city and gender combo boxes, both with default selections. |
| `Places3.java` | A location picker with **Add** and **Remove** buttons that dynamically modify combo box items. |

### 🔑 Password Field
| File | Description |
|------|-------------|
| `PasswordField1.java` | A login form with username and password fields — the password is masked and displayed on button click. |

### 📝 Text Areas & Text Fields
| File | Description |
|------|-------------|
| `TextAreaExample.java` | A text area with a "Count Words" button that displays the word and character count. |

### 📑 Tabbed Pane
| File | Description |
|------|-------------|
| `MyTabs.java` | A simple tabbed interface with General, Display, and About tabs. |

### 📊 Survey Forms
| File | Description |
|------|-------------|
| `SurveyForm.java` | A full-featured website feedback survey form with personal info fields, radio button questions, rating tables, text areas, and a submit button. |
| `TestsurveyForm1.java` | A scrollable version of the website survey form with the same structure and layout. |

## ⚙️ How to Run

### Prerequisites
- **Java JDK** (8 or higher)

### Compile
```bash
cd LABACTCOMPILATION/src
javac *.java
```

### Run
```bash
java <ClassName>
```
> Replace `<ClassName>` with the name of the Java file you want to run (without the `.java` extension). For example:
> ```bash
> java SurveyForm
> java ButtonDemo
> java Places3
> ```

## 🛠️ Topics Covered

- **AWT (Abstract Window Toolkit)** — `Frame`, `Button`, `Panel`, `FlowLayout`
- **Swing Components** — `JFrame`, `JButton`, `JLabel`, `JTextField`, `JTextArea`, `JCheckBox`, `JRadioButton`, `JComboBox`, `JPasswordField`, `JTabbedPane`, `JScrollPane`, `JOptionPane`
- **Layout Managers** — `FlowLayout`, `BorderLayout`, `GridLayout`, `BoxLayout`, `GridBagLayout`, null layout
- **Event Handling** — `ActionListener`, `ItemListener`, `FocusListener`
- **Form Design** — survey forms, login screens, ordering systems

## 📌 Notes

- Pre-compiled `.class` files are provided in the `bin/` folder for convenience, but recompiling from source is recommended.
- Some programs use `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)` while others rely on closing via the IDE or task manager.
- The `ButtonDemo.java` uses the older AWT `Frame` class, while all other programs use Swing's `JFrame`.

---

*These activities were created for educational purposes as part of a Computer Programming with Graphics (CPG) course.*
