/*
 * ResetZoomCommand.java Copyright (C) 2023 Daniel H. Huson
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
package megan.alignment.commands;

import jloda.swing.commands.ICommand;
import jloda.swing.util.ResourceManager;
import jloda.util.parse.NexusStreamParser;
import megan.commands.CommandBase;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResetZoomCommand extends CommandBase implements ICommand {
    public String getSyntax() {
        return null;
    }

    public void apply(NexusStreamParser np) {
    }

    public void actionPerformed(ActionEvent event) {
        executeImmediately("expand axis=vertical what=fit;");
    }

    public boolean isApplicable() {
        return true;
    }

    public String getName() {
        return "Reset Zoom";
    }

    public ImageIcon getIcon() {
        return ResourceManager.getIcon("sun/AlignJustifyHorizontal16.gif");
    }

    public String getDescription() {
        return "Reset";
    }

    public boolean isCritical() {
        return true;
    }
}

