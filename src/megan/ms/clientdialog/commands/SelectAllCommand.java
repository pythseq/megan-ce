/*
 * SelectAllCommand.java Copyright (C) 2023 Daniel H. Huson
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
package megan.ms.clientdialog.commands;

import jloda.swing.commands.CommandBase;
import jloda.swing.commands.ICommand;
import jloda.swing.util.ResourceManager;
import jloda.util.parse.NexusStreamParser;
import megan.ms.clientdialog.RemoteServiceBrowser;
import megan.ms.clientdialog.ServicePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 * * selection command
 * * Daniel Huson, 11.2010
 */
public class SelectAllCommand extends CommandBase implements ICommand {
    public String getSyntax() {
        return "select samples={all|none};";
    }

    /**
     * parses the given command and executes it
     */
    @Override
    public void apply(NexusStreamParser np) throws Exception {
        ServicePanel servicePanel = ((RemoteServiceBrowser) getViewer()).getServicePanel();

        np.matchIgnoreCase("select samples=");
        String what = np.getWordMatchesIgnoringCase("all none");

        if (what.equalsIgnoreCase("all"))
            servicePanel.selectAll(true);
        else if (what.equals("none"))
            servicePanel.selectAll(false);
        np.matchRespectCase(";");
        System.err.println("Number of nodes selected: " + servicePanel.getSelectedFiles().size());
    }

    public void actionPerformed(ActionEvent event) {
        executeImmediately("select samples=all;");
    }

    public boolean isApplicable() {
        return true;
    }

    public String getName() {
        return "Select All";
    }

    public String getDescription() {
        return "Select";
    }

    public ImageIcon getIcon() {
        return ResourceManager.getIcon("Empty16.gif");
    }

    public boolean isCritical() {
        return true;
    }

    public KeyStroke getAcceleratorKey() {
        return KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx());
    }
}
