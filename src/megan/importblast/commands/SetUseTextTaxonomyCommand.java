/*
 * SetUseTextTaxonomyCommand.java Copyright (C) 2023 Daniel H. Huson
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
package megan.importblast.commands;

import jloda.swing.commands.ICheckBoxCommand;
import jloda.swing.util.ResourceManager;
import jloda.util.parse.NexusStreamParser;
import megan.classification.ClassificationManager;
import megan.importblast.ImportBlastDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SetUseTextTaxonomyCommand extends jloda.swing.commands.CommandBase implements ICheckBoxCommand {
    public boolean isSelected() {
        ImportBlastDialog importBlastDialog = (ImportBlastDialog) getParent();
        return importBlastDialog.isParseTaxonNames();
    }

    public String getSyntax() {
        return "set useParseTextTaxonomy=<bool>;";
    }

    public void apply(NexusStreamParser np) throws Exception {
        np.matchIgnoreCase("set useParseTextTaxonomy=");
        boolean bool = np.getBoolean();
        np.matchIgnoreCase(";");
        ImportBlastDialog importBlastDialog = (ImportBlastDialog) getParent();
        importBlastDialog.setParseTaxonNames(bool);
    }

    public void actionPerformed(ActionEvent event) {
        executeImmediately("set useParseTextTaxonomy=" + (!isSelected()) + ";");
    }

    public boolean isApplicable() {
        return !ClassificationManager.isUseFastAccessionMappingMode();
    }

    final public static String NAME = "Parse Taxon Names";

    public String getName() {
        return NAME;
    }

    public String getDescription() {
        return "Parse taxon names embedded in BLAST file to identify taxa";
    }

    public ImageIcon getIcon() {
        return ResourceManager.getIcon("sun/Preferences16.gif");
    }

    public boolean isCritical() {
        return true;
    }


    public KeyStroke getAcceleratorKey() {
        return null;
    }
}

