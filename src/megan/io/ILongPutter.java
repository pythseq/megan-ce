/*
 * ILongPutter.java Copyright (C) 2023 Daniel H. Huson
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

/**
 * A read and write long-indexed array of longs
 * Daniel Huson, 4.2015
 */
public interface ILongPutter extends AutoCloseable {
    /**
     * gets value for given index
     *
     * @return value or 0
     */
    long get(long index);

    /**
     * puts value for given index
     *
     * @param value return the putter
     */
    ILongPutter put(long index, long value);

    /**
     * length of array
     *
     * @return array length
	 */
    long limit();

    /**
     * close the array
     */
    void close();
}
