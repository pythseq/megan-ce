/*
 * ShowConsensusCommand.java Copyright (C) 2023 Daniel H. Huson
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

import jloda.swing.commands.CommandBase;
import jloda.swing.commands.ICheckBoxCommand;
import jloda.swing.util.ResourceManager;
import jloda.util.parse.NexusStreamParser;
import megan.alignment.AlignmentViewer;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * command
 * Daniel Huson, 8.2011
 */
public class ShowConsensusCommand extends CommandBase implements ICheckBoxCommand {

    public boolean isSelected() {
        AlignmentViewer viewer = (AlignmentViewer) getViewer();
        return viewer.getAlignmentViewerPanel().isShowConsensus();
    }

    /**
     * parses the given command and executes it
     */
    @Override
    public void apply(NexusStreamParser np) throws Exception {
        np.matchIgnoreCase("set show-consensus=");

        boolean value = np.getBoolean();
        np.matchIgnoreCase(";");

        AlignmentViewer viewer = (AlignmentViewer) getViewer();
        viewer.getAlignmentViewerPanel().setShowConsensus(value);
    }

    /**
     * get command-line usage description
     *
     * @return usage
     */
    @Override
    public String getSyntax() {
        return "set show-consensus={true|false};";
    }

    /**
     * action to be performed
     *
	 */
    @Override
    public void actionPerformed(ActionEvent ev) {
        execute("set show-consensus=" + !isSelected() + ";");
    }

    private static final String NAME = "Show Consensus";

    public String getName() {
        return NAME;
    }


    /**
     * get description to be used as a tooltip
     *
     * @return description
     */
    public String getDescription() {
        return "Show consensus sequence";
    }

    /**
     * get icon to be used in menu or button
     *
     * @return icon
     */
    public ImageIcon getIcon() {
        return ResourceManager.getIcon("ShowConsensusSequence16.gif");
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
     * is this a critical command that can only be executed when no other command is running?
     *
     * @return true, if critical
     */
    public boolean isCritical() {
        return true;
    }

    /**
     * is the command currently applicable? Used to set enable state of command
     *
     * @return true, if command can be applied
     */
    public boolean isApplicable() {
        AlignmentViewer viewer = (AlignmentViewer) getViewer();
        return viewer.getAlignment().getNumberOfSequences() > 0;
    }
}
