package com.iloc;

public class Token {
    final TokenType type;
    final String lexeme;
    final int line;

    Token(TokenType type, String lexeme, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.line = line;
    }

    public String toString() {
        return type + " " + lexeme + " Line: " + line;
    }
}
