/*
 * JPanelWithFXStageAndRoot.java Copyright (C) 2023 Daniel H. Huson
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

package megan.util;

import javafx.scene.Node;
import javafx.stage.Stage;
import jloda.fx.util.IHasJavaFXStageAndRoot;

import javax.swing.*;

public class JPanelWithFXStageAndRoot extends JPanel implements IHasJavaFXStageAndRoot {
    private final Node root;
    private final Stage stage;

    public JPanelWithFXStageAndRoot(Node root, Stage stage) {
        super();
        this.root = root;
        this.stage = stage;
    }

    @Override
    public Node getJavaFXRoot() {
        return root;
    }

    @Override
    public Stage getJavaFXStage() {
        return stage;
    }
}
