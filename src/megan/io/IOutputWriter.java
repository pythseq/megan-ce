/*
 * IOutputWriter.java Copyright (C) 2023 Daniel H. Huson
 *
 * (Some files contain contributions from other authors, who are then mentioned separately.)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package megan.io;


import java.io.Closeable;
import java.io.IOException;

/**
 * common interface for both OutputWriter and InputOutputReaderWriter
 * Daniel Huson, 8.2008
 */
public interface IOutputWriter extends Closeable {
    void writeInt(int a) throws IOException;

    void writeChar(char a) throws IOException;

    void write(int a) throws IOException;

    void write(byte[] bytes, int offset, int length) throws IOException;

    void write(byte[] bytes) throws IOException;

    void writeLong(long a) throws IOException;

    void writeFloat(float a) throws IOException;

    void writeByteByteInt(ByteByteInt a) throws IOException;

    void writeString(String str) throws IOException;

    void writeString(byte[] str, int offset, int length) throws IOException;

    void writeStringNoCompression(String str) throws IOException;

    long length() throws IOException;

    long getPosition() throws IOException;

    boolean isUseCompression();

    void setUseCompression(boolean use);
}
