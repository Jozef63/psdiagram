/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.miroslavbartyzal.psdiagram.app.gui;

import cz.miroslavbartyzal.psdiagram.app.debug.function.variables.VariableModel;
import cz.miroslavbartyzal.psdiagram.app.gui.treeTable.JTreeTable;
import javax.swing.JViewport;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 * Tato třída zapouzdřuje komponentu TreeTable, tedy kombinaci stromu s
 * tabulkou, pro zobrazení výpisu proměnných.
 *
 * @author Miroslav Bartyzal (miroslavbartyzal@gmail.com)
 */
public final class JPanelVariables extends javax.swing.JPanel
{

    private VariableModel variableModel = new VariableModel();
    private JTreeTable jTreeTable = new JTreeTable(variableModel);

    /**
     * Vytvoří nový panel JPanelVariables
     */
    public JPanelVariables()
    {
        initComponents();

        jTreeTable.getTree().setRootVisible(false);
        jTreeTable.setFocusable(false);
        TreeCellRenderer tcr = jTreeTable.getTree().getCellRenderer();
        if (tcr instanceof DefaultTreeCellRenderer) {
            DefaultTreeCellRenderer dtcr = ((DefaultTreeCellRenderer) tcr);
            dtcr.setLeafIcon(new javax.swing.ImageIcon(getClass().getResource(
                    "/img/variables/16-Variable.png")));
            dtcr.setOpenIcon(new javax.swing.ImageIcon(getClass().getResource(
                    "/img/variables/16-Array.png")));
            dtcr.setClosedIcon(new javax.swing.ImageIcon(getClass().getResource(
                    "/img/variables/16-Array.png")));
        }
        jScrollPaneVariables.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE); // prevents glitches (http://andrewtill.blogspot.cz/2012/06/jscrollpane-repainting-problems.html)
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTabbedPaneVariables = new javax.swing.JTabbedPane();
        jPanelVariables = new javax.swing.JPanel();
        jScrollPaneVariables = new javax.swing.JScrollPane(jTreeTable);

        jTabbedPaneVariables.setFocusable(false);

        javax.swing.GroupLayout jPanelVariablesLayout = new javax.swing.GroupLayout(jPanelVariables);
        jPanelVariables.setLayout(jPanelVariablesLayout);
        jPanelVariablesLayout.setHorizontalGroup(
            jPanelVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneVariables, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        jPanelVariablesLayout.setVerticalGroup(
            jPanelVariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPaneVariables, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );

        jTabbedPaneVariables.addTab("Výpis proměnných", jPanelVariables);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneVariables)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneVariables)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelVariables;
    private javax.swing.JScrollPane jScrollPaneVariables;
    private javax.swing.JTabbedPane jTabbedPaneVariables;
    // End of variables declaration//GEN-END:variables

    /**
     * Vrátí model instance třídy TreeTable, která zobrazuje výpis proměnných.
     * <p/>
     * @return model instance třídy TreeTable, která zobrazuje výpis proměnných
     */
    public VariableModel getVariableModel()
    {
        return variableModel;
    }

}
