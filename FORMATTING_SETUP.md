# Google Java Format Setup for Cursor/VS Code

This guide helps you set up Google's Java code style in Cursor or VS Code for interview preparation.

## What's Included

1. **Google Java Format JAR** - Official Google formatter
2. **VS Code/Cursor Settings** - Automatic formatting configuration
3. **Format Script** - Command-line formatting tool
4. **EditorConfig** - Cross-editor formatting rules

## Quick Start

### 1. Automatic Formatting (Recommended)

The `.vscode/settings.json` file is already configured to:
- Format Java files on save
- Use Google Java Style
- Organize imports automatically
- Set proper import order

### 2. Manual Formatting

Use the provided script to format files:

```bash
# Format all Java files
./format-java.sh

# Format specific file
./format-java.sh src/main/java/org/atak/problems/InterviewPractice.java

# Format specific directory
./format-java.sh src/main/java/org/atak/problems/
```

### 3. Command Line Formatting

Format individual files directly:

```bash
java -jar google-java-format.jar --replace YourFile.java
```

## Google Java Style Guidelines

### Key Formatting Rules

1. **Indentation**: 2 spaces (not tabs)
2. **Line Length**: 100 characters maximum
3. **Braces**: K&R style (opening brace on same line)
4. **Naming**:
   - Classes: PascalCase
   - Methods/Variables: camelCase
   - Constants: UPPER_SNAKE_CASE
5. **Imports**: Organized by package

### Example

```java
public class ExampleClass {
  private static final int MAX_SIZE = 100;
  
  public void exampleMethod(String input) {
    if (input == null) {
      return;
    }
    
    for (int i = 0; i < input.length(); i++) {
      // Process each character
    }
  }
}
```

## Cursor/VS Code Extensions

Install these extensions for better Java development:

1. **Extension Pack for Java** (Microsoft)
2. **Language Support for Java by Red Hat**
3. **EditorConfig for VS Code**

## Keyboard Shortcuts

- `Shift + Alt + F`: Format document
- `Ctrl + Shift + P` → "Format Document": Format with specific formatter
- `Ctrl + S`: Save and auto-format (if enabled)

## Troubleshooting

### Formatter Not Working

1. Check if Java is installed: `java -version`
2. Verify the JAR file exists: `ls google-java-format.jar`
3. Restart Cursor/VS Code after changing settings

### Import Organization Issues

1. Ensure "Organize Imports" is enabled in settings
2. Use `Ctrl + Shift + O` to organize imports manually

### Line Length Issues

1. Check `.editorconfig` max_line_length setting
2. Ensure Google Java Format is being used (not Eclipse formatter)

## Additional Resources

- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [Google Java Format GitHub](https://github.com/google/google-java-format)
- [EditorConfig](https://editorconfig.org/)

## Commands to Remember

```bash
# Format all files
./format-java.sh

# Check formatting without changing files
java -jar google-java-format.jar --dry-run src/**/*.java

# Format specific file
java -jar google-java-format.jar --replace src/main/java/org/atak/problems/InterviewPractice.java
```
