#!/bin/bash

# Google Java Format script
# Usage: ./format-java.sh [file_or_directory]

JAR_FILE="google-java-format.jar"

if [ ! -f "$JAR_FILE" ]; then
    echo "Error: $JAR_FILE not found. Please download it first."
    exit 1
fi

if [ $# -eq 0 ]; then
    # Format all Java files in src directory
    find src -name "*.java" -type f -exec java -jar "$JAR_FILE" --replace {} \;
    echo "Formatted all Java files in src directory"
else
    # Format specific file or directory
    java -jar "$JAR_FILE" --replace "$1"
    echo "Formatted: $1"
fi
