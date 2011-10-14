/*
 *    InstanceConditionalTest.java
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
package tr.gov.ulakbim.jDenetX.classifiers.conditionals;

import tr.gov.ulakbim.jDenetX.AbstractMOAObject;
import tr.gov.ulakbim.jDenetX.core.InstancesHeader;
import weka.core.Instance;

public abstract class InstanceConditionalTest extends AbstractMOAObject {

    private static final long serialVersionUID = 5154535748642485841L;

    // returns -1 if unknown

    public abstract int branchForInstance(Instance inst);

    public boolean resultKnownForInstance(Instance inst) {
        return branchForInstance(inst) >= 0;
    }

    // returns -1 if unknown

    public abstract int maxBranches();

    public abstract String describeConditionForBranch(int branch,
                                                     InstancesHeader context);

    public abstract int[] getAttsTestDependsOn();

}
