
package com.harsh.sadp.decorator;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

class LowerCaseReader extends FilterReader {

    protected LowerCaseReader(Reader reader) {
        super(reader);
    }

    @Override
    public int read() throws IOException {
        int character = super.read();

        if (character == -1) {
            return -1;
        }

        return Character.toLowerCase((char) character);
    }

    @Override
    public int read(char[] buffer, int offset, int length)
            throws IOException {

        int count = super.read(buffer, offset, length);

        if (count == -1) {
            return -1;
        }

        for (int i = offset; i < offset + count; i++) {
            buffer[i] = Character.toLowerCase(buffer[i]);
        }

        return count;
    }
}

public class Main {

    public static void main(String[] args) {
        String input = "HELLO DESIGN PATTERNS!";

        try (Reader reader = new LowerCaseReader(
                new StringReader(input))) {

            StringBuilder output = new StringBuilder();
            char[] buffer = new char[8];
            int count;

            while ((count = reader.read(
                    buffer, 0, buffer.length)) != -1) {
                output.append(buffer, 0, count);
            }

            System.out.println("Original: " + input);
            System.out.println("Converted: " + output);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
