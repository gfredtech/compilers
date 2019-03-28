package com.iloc;

public class IRPrinter implements Ops.Visitor<String> {

    String print(Ops expr) {
        return expr.accept(this);
    }

    @Override
    public String visitZer0aryOp(Token op) {
        return parenthesize(op.lexeme);
    }

    @Override
    public String visitUnaryOp(Token op, Token first) {
        return parenthesize(op.lexeme, first);
    }

    @Override
    public String visitBinaryOp(Token op, Token first, Token second) {
        return parenthesize(op.lexeme, first, second);
    }

    @Override
    public String visitTernaryOp(Token op, Token first, Token second, Token third) {
        return parenthesize(op.lexeme, first, second, third);
    }

    private String parenthesize(String name, Token... ops) {
        StringBuilder builder = new StringBuilder();

        builder.append("[").append(name);
        for (Token op : ops) {
            builder.append(" {").
                    append(op.type).
                    append(" ").
                    append(op.lexeme).
                    append("}");
        }
        builder.append("]");

        return builder.toString();
    }
}
