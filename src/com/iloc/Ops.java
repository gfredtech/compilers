package com.iloc;

abstract class Ops {
    abstract <R> R accept(Visitor<R> visitor);

    interface Visitor<R> {
        R visitZer0aryOp(Token op);

        R visitUnaryOp(Token op, Token first);

        R visitBinaryOp(Token op, Token first, Token second);

        R visitTernaryOp(Token op, Token first, Token second, Token third);
    }

    static class Zer0ary extends Ops {
        final Token opcode;

        Zer0ary(Token opcode) {
            this.opcode = opcode;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitZer0aryOp(this.opcode);
        }
    }

    static class Unary extends Ops {
        final Token opcode;
        final Token first;

        Unary(Token opcode, Token first) {
            this.opcode = opcode;
            this.first = first;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitUnaryOp(this.opcode, this.first);
        }
    }

    static class Binary extends Ops {
        final Token opcode;
        final Token first;
        final Token second;

        Binary(Token opcode, Token first, Token second) {
            this.opcode = opcode;
            this.first = first;
            this.second = second;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitBinaryOp(this.opcode, this.first, this.second);
        }
    }

    static class Ternary extends Ops {
        final Token opcode;
        final Token first;
        final Token second;
        final Token third;

        Ternary(Token opcode, Token first, Token second, Token third) {
            this.opcode = opcode;
            this.first = first;
            this.second = second;
            this.third = third;
        }

        <R> R accept(Visitor<R> visitor) {
            return visitor.visitTernaryOp(this.opcode, this.first, this.second, this.third);
        }
    }
}
