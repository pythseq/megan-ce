/*
 * IName2IdMap.java Copyright (C) 2023 Daniel H. Huson
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
package megan.data;

import java.util.Collection;

/**
 * name to id interface
 * Daniel Huson, 4.2015
 */
public interface IName2IdMap {
    int get(String name);

    String get(int id);

    void put(String name, int id);

    Collection<Integer> getIds();

    Collection<String> getNames();

    int size();
}
