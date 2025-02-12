/*
 * SetEdgeWidthCommand.java Copyright (C) 2023 Daniel H. Huson
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
package megan.commands.format;

import jloda.graph.Edge;
import jloda.swing.commands.CommandBase;
import jloda.swing.commands.ICommand;
import jloda.swing.graphview.GraphView;
import jloda.swing.util.ProgramProperties;
import jloda.util.parse.NexusStreamParser;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * set shape
 * Daniel Huson, 4.2011
 */
public class SetEdgeWidthCommand extends CommandBase implements ICommand {

    /**
     * get the name to be used as a menu label
     *
     * @return name
     */
    public String getName() {
        return "Set Edge Width";
    }

    /**
     * get description to be used as a tooltip
     *
     * @return description
     */
    public String getDescription() {
        return "Set the width of selected edges";
    }

    /**
     * get icon to be used in menu or button
     *
     * @return icon
     */
    public ImageIcon getIcon() {
        return null;
    }

    /**
     * gets the accelerator key  to be used in menu
     *
     * @return accelerator key
     */
    public KeyStroke getAcceleratorKey() {
        return null;
    }

    /**
     * parses the given command and executes it
     */
    @Override
    public void apply(NexusStreamParser np) throws Exception {
        np.matchIgnoreCase("set edgeWidth=");
        int width = np.getInt(0, 1000);
        np.matchIgnoreCase(";");

        if (getViewer() instanceof GraphView) {
            boolean changed = false;
            GraphView viewer = (GraphView) getViewer();
            for (Edge e : viewer.getSelectedEdges()) {
                viewer.setLineWidth(e, width);
                changed = true;
            }
            if (changed) {
                viewer.repaint();
            }
        }

    }

    /**
     * action to be performed
     *
	 */
    public void actionPerformed(ActionEvent ev) {
        Integer[] choices = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 40};

        Integer result = (Integer) JOptionPane.showInputDialog(getViewer().getFrame(), "Set edge width", "Set edge width", JOptionPane.QUESTION_MESSAGE, ProgramProperties.getProgramIcon(), choices, choices[1]);

        if (result != null)
            execute("set edgeWidth=" + result + ";");
    }


    /**
     * is this a critical command that can only be executed when no other command is running?
     *
     * @return true, if critical
     */
    public boolean isCritical() {
        return true;
    }

    /**
     * get command-line usage description
     *
     * @return usage
     */
    @Override
    public String getSyntax() {
        return "set edgeWidth=<integer>;";
    }

    /**
     * is the command currently applicable? Used to set enable state of command
     *
     * @return true, if command can be applied
     */
    public boolean isApplicable() {
        return getViewer() instanceof GraphView &&
                ((GraphView) getViewer()).getSelectedEdges().size() > 0;
    }

    /**
     * gets the command needed to undo this command
     *
     * @return undo command
     */
    public String getUndo() {
        return null;
    }
}
