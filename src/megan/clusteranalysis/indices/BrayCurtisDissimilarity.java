/*
 * BrayCurtisDissimilarity.java Copyright (C) 2022 Daniel H. Huson
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

package megan.clusteranalysis.indices;

import jloda.graph.Node;
import megan.clusteranalysis.tree.Distances;
import megan.viewer.ClassificationViewer;


/**
 * compute the Bray Curtis dissimilarity
 * Daniel Huson, 6.2018
 */
public class BrayCurtisDissimilarity {
    public static final String NAME = "Bray-Curtis";

    /**
     * compute the Bray Curtis dissimilarity
     *
     * @return number of nodes used to compute value
     */
    public static int apply(final ClassificationViewer viewer, final Distances distances) {
        System.err.println("Computing " + NAME + " distances");

        final int nSamples = distances.getNtax();

        final double[] total = new double[nSamples];
        for (Node v : viewer.getSelectedNodes()) {
            final float[] count = (v.getOutDegree() == 0 ? viewer.getNodeData(v).getSummarized() : viewer.getNodeData(v).getAssigned());
            for (int s = 0; s < nSamples; s++)
                total[s] += count[s];
        }

        final float[][] lesser = new float[nSamples][nSamples];
        final float[][] sum = new float[nSamples][nSamples];

        for (Node v : viewer.getSelectedNodes()) {
            final float[] count = (v.getOutDegree() == 0 ? viewer.getNodeData(v).getSummarized() : viewer.getNodeData(v).getAssigned());
            for (int s = 0; s < nSamples; s++) {
                final double p = (total[s] > 0 ? count[s] / total[s] : 0);
                for (int t = s + 1; t < nSamples; t++) {
                    final double q = (total[t] > 0 ? count[t] / total[t] : 0);
                    lesser[s][t] += Math.min(p, q);
                    sum[s][t] += p + q;
                }
            }
        }
        for (int s = 0; s < nSamples; s++) {
            for (int t = s + 1; t < nSamples; t++) {
                if (sum[s][t] > 0)
                    distances.set(s + 1, t + 1, 1 - 2 * lesser[s][t] / sum[s][t]);
                else
                    distances.set(s + 1, t + 1, 0);
            }
        }
        return viewer.getSelectedNodes().size();
    }
}
