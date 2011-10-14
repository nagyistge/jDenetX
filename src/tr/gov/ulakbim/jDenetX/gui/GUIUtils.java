/*
 *    GUIUtils.java
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
package tr.gov.ulakbim.jDenetX.gui;

import tr.gov.ulakbim.jDenetX.core.MiscUtils;

import javax.swing.*;
import java.awt.*;

public class GUIUtils {

    public static void showErrorDialog(Component parent, String title,
                                       String message) {
        JTextArea messagePanel = new JTextArea(message);
        JScrollPane messageScroll = new JScrollPane(messagePanel);
        messageScroll.setPreferredSize(new Dimension(400, 100));
        JOptionPane.showMessageDialog(parent, messageScroll, title,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showExceptionDialog(Component parent, String title,
                                           Exception ex) {
        showErrorDialog(parent, title, ex.getMessage() + "\n\n"
                + MiscUtils.getStackTraceString(ex));
    }

}
