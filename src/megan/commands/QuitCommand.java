/*
 * QuitCommand.java Copyright (C) 2023 Daniel H. Huson
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
package megan.commands;

import jloda.swing.commands.ICommand;
import jloda.swing.director.ProjectManager;
import jloda.swing.util.ProgramProperties;
import jloda.swing.util.ResourceManager;
import jloda.util.parse.NexusStreamParser;
import megan.chart.ChartColorManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class QuitCommand extends CommandBase implements ICommand {
    public String getSyntax() {
        return "quit;";
    }

    public void apply(NexusStreamParser np) throws Exception {
        np.matchIgnoreCase("quit;");
        if (!ProgramProperties.isUseGUI()) // in non-gui mode,  ensure that the program terminates
        {
            ChartColorManager.store();
            ProgramProperties.store();
            System.exit(0);
        } else {    // todo: in non-gui mode, call the code below results in a deadlock...
            ProjectManager.doQuit(ChartColorManager::store, NewCommand::makeNewDocument);
        }
    }

    public void actionPerformed(ActionEvent event) {
        executeImmediately("quit;");
    }

    public boolean isApplicable() {
        return true;
    }

    public String getName() {
        return "Quit";
    }

    public KeyStroke getAcceleratorKey() {
        return KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
    }

    public String getDescription() {
        return "Quit the program";
    }

    public ImageIcon getIcon() {
        return ResourceManager.getIcon("sun/Stop16.gif");
    }

    public boolean isCritical() {
        return false;
    }
}

