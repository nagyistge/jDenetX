/*
 *    NominalAttributeMultiwayTest.java
 *    Copyright (C) 2007 University of Waikato, Hamilton, New Zealand
 *    @author Richard Kirkby (rkirkby@cs.waikato.ac.nz)
 *
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package tr.gov.ulakbim.jDenetX.classifiers.attributes;

import tr.gov.ulakbim.jDenetX.classifiers.conditionals.InstanceConditionalTest;
import tr.gov.ulakbim.jDenetX.core.InstancesHeader;
import weka.core.Instance;

public class NominalAttributeMultiwayTest extends InstanceConditionalTest {

    private static final long serialVersionUID = 1L;

    protected int attIndex;

    public NominalAttributeMultiwayTest(int attIndex) {
        this.attIndex = attIndex;
    }

    @Override
    public int branchForInstance(Instance inst) {
        int instAttIndex = this.attIndex < inst.classIndex() ? this.attIndex
                : this.attIndex + 1;
        return inst.isMissing(instAttIndex) ? -1 : (int) inst
                .value(instAttIndex);
    }

    @Override
    public String describeConditionForBranch(int branch, InstancesHeader context) {
        return InstancesHeader.getAttributeNameString(context, this.attIndex)
                + " = "
                + InstancesHeader.getNominalValueString(context, this.attIndex,
                branch);
    }

    @Override
    public int maxBranches() {
        return -1;
    }

    public void getDescription(StringBuilder sb, int indent) {
        // TODO Auto-generated method stub

    }

    @Override
    public int[] getAttsTestDependsOn() {
        return new int[]{this.attIndex};
    }
}