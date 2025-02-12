/*
 * GUIConfiguration.java Copyright (C) 2023 Daniel H. Huson
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
package megan.inspector;

import jloda.swing.window.MenuConfiguration;
import megan.classification.data.ClassificationCommandHelper;

/**
 * configuration for menu and toolbar
 * Daniel Huson, 7.2010
 */
class GUIConfiguration {

    /**
     * get the menu configuration
     *
     * @return menu configuration
     */
    public static MenuConfiguration getMenuConfiguration() {
        MenuConfiguration menuConfig = new MenuConfiguration();
        menuConfig.defineMenuBar("File;Edit;Options;Window;Help;");

        menuConfig.defineMenu("File", "New...;|;Open...;@Open Recent;|;Open From Server...;|;Compare...;|;Import From BLAST...;@Import;Meganize DAA File...;|;Export Selected Text...;Export Image...;Export Legend...;|;Page Setup...;Print...;|;Close;|;Quit;");
        menuConfig.defineMenu("Open Recent", ";");
        menuConfig.defineMenu("Import", "Import Text (CSV) Format...;Import BIOM Format...;|;Import Metadata...;");

        menuConfig.defineMenu("Edit", "Inspector Cut;Inspector Copy;Inspector Paste;|;Clear;|;Select All;Select None;|;Find...;Find Again;|;Show Taxon...;Show Reads...;");

        menuConfig.defineMenu("Options", "BLAST on NCBI...;|;Collapse Inspector;Expand Inspector;|;Disable Taxon For Match;|;Sort Reads Alphabetically;");

        menuConfig.defineMenu("Window", "Close All Other Windows...;|;Reset Window Location;Set Window Size...;|;Message Window...;|;" +
                "Inspector Window...;|;Main Viewer...;" + ClassificationCommandHelper.getOpenViewerMenuString() + "|;Samples Viewer...;|;");

        menuConfig.defineMenu("Help", "About...;How to Cite...;|;Community Website...;Reference Manual...;|;Check For Updates...;");

        return menuConfig;
    }

    /**
     * gets the toolbar configuration
     *
     * @return toolbar configuration
     */
    public static String getToolBarConfiguration() {
        return "Open...;Print...;Export Image...;|;Find...;|;Main Viewer...;" + ClassificationCommandHelper.getOpenViewerMenuString() + "";
    }

    /**
     * gets the toolbar configuration
     *
     * @return toolbar configuration
     */
    public static String getPopupMenuConfiguration() {
        return "Inspector Copy;As Text...;|;Disable Taxon For Match;|;Clear;";
    }
}
