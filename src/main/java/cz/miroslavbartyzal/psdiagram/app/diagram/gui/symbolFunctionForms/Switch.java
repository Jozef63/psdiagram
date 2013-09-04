/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.miroslavbartyzal.psdiagram.app.diagram.gui.symbolFunctionForms;

import cz.miroslavbartyzal.psdiagram.app.diagram.flowchart.layouts.LayoutElement;
import cz.miroslavbartyzal.psdiagram.app.diagram.flowchart.symbols.EnumSymbol;
import cz.miroslavbartyzal.psdiagram.app.diagram.flowchart.symbols.Symbol;
import cz.miroslavbartyzal.psdiagram.app.diagram.gui.managers.FlowchartEditManager;
import cz.miroslavbartyzal.psdiagram.app.diagram.gui.symbolFunctionForms.documentFilters.ConstantFilter;
import cz.miroslavbartyzal.psdiagram.app.diagram.gui.symbolFunctionForms.documentFilters.VariableFilter;
import cz.miroslavbartyzal.psdiagram.app.global.SettingsHolder;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.LinkedHashMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;

/**
 * Tato třída představuje formulář pro editaci funkce symbolu vícecestného
 * rozhodování.
 *
 * @author Miroslav Bartyzal (miroslavbartyzal@gmail.com)
 */
public final class Switch extends AbstractSymbolFunctionForm
{

    private JLabel jLabelDescription;
    private Symbol mySymbol = EnumSymbol.SWITCH.getInstance(null);
    private JTextField[] jTextFieldSegments;

    /**
     * Konstruktor, inicializující tento formulář.
     *
     * @param element element, kterého se tento formulář týká
     * @param flowchartEditManager FlowchartEditManager, spravující editační
     * režim aplikace
     */
    public Switch(LayoutElement element, FlowchartEditManager flowchartEditManager)
    {
        super(element, flowchartEditManager);
        /*
         * jLabelDescription = new JLabel("<html>"
         * + "- řízení toku programu na<br />základě rovnosti vstupního<br
         * />číselného(nebo řetězcové-<br />ho) výrazu vůči konstan-<br />tám<br
         * />"
         * + "- pro oddělení více kons-<br />tatnt pro jednu větev pou-<br
         * />žijte znak \",\" (čárka)"
         * + "</html>");
         */
        jLabelDescription = new JLabel("<html><p>"
                + "- řízení toku programu na základě rovnosti vstupního číselného(nebo řetězcového) výrazu vůči konstantám<br />"
                + "- pro oddělení více konstatnt pro jednu větev použijte znak \",\" (čárka)"
                + "</p></html>");
        jLabelDescription.setFont(SettingsHolder.SMALLFONT_SYMBOLDESC);
        initComponents();

        jTextFieldConditionVar.setFont(SettingsHolder.CODEFONT);
        jLabelExamples.setFont(SettingsHolder.SMALL_CODEFONT);

        if (element.getSymbol().getCommands() != null) {
            jTextFieldConditionVar.setText(element.getSymbol().getCommands().get("conditionVar"));
            for (int i = 0; i < jTextFieldSegments.length; i++) {
                jTextFieldSegments[i].setText(element.getSymbol().getCommands().get("" + (i + 1)));
            }
        }

        if (SettingsHolder.settings.isFunctionFilters()) {
            ((AbstractDocument) jTextFieldConditionVar.getDocument()).setDocumentFilter(
                    new VariableFilter());
        }
        addDocumentListeners();
        super.trimSize();
    }

    @Override
    void addDocumentListeners()
    {
        jTextFieldConditionVar.getDocument().addDocumentListener(this);
        for (JTextField jTextField : jTextFieldSegments) {
            jTextField.getDocument().addDocumentListener(this);
        }
    }

    @Override
    void generateValues()
    {
        String conditionVar = "";
        String[] segmentConstants = new String[jTextFieldSegments.length];
        try {
            conditionVar = jTextFieldConditionVar.getDocument().getText(0,
                    jTextFieldConditionVar.getDocument().getLength());
            for (int i = 0; i < jTextFieldSegments.length; i++) {
                segmentConstants[i] = jTextFieldSegments[i].getDocument().getText(0,
                        jTextFieldSegments[i].getDocument().getLength());
                if (segmentConstants[i].equals("")) {
                    break;
                }
            }
        } catch (BadLocationException ex) {
        }

        generateValues(super.getElement(), conditionVar, segmentConstants);
    }

    /**
     * Vygeneruje danému symbolu elementu dané funkční příkazy a zároveň nastaví
     * defaultní text symbolu.
     * <p/>
     * @param element element, kterého se má generování hodnot týkat
     * @param conditionVar proměnná, které se tento Switch příkaz týká
     * @param segmentConstants konstanty jednotlivých větví tohoto symbolu
     */
    public static void generateValues(LayoutElement element, String conditionVar,
            String[] segmentConstants)
    {
        if (!conditionVar.equals("") && segmentConstants.length == element.getInnerSegmentsCount() - 1) {
            LinkedHashMap<String, String> commands = new LinkedHashMap<>();

            element.getSymbol().setDefaultValue(conditionVar + "?");
            commands.put("conditionVar", conditionVar);
            for (int i = 0; i < segmentConstants.length; i++) {
                if (segmentConstants[i].equals("")) {
                    break;
                }
                element.getInnerSegment(i + 1).setDefaultDescripton(segmentConstants[i]);
                commands.put("" + (i + 1), segmentConstants[i]);
            }

            if (commands.size() == element.getInnerSegmentsCount()) {
                element.getSymbol().setCommands(commands);
                return;
            }
        }
        element.getSymbol().setDefaultValue("");
        for (int i = 0; i < segmentConstants.length; i++) {
            element.getInnerSegment(i + 1).setDefaultDescripton(null);
        }
        element.getSymbol().setCommands(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldConditionVar = new javax.swing.JTextField();
        jPanel1 = new JPanelSymbol(mySymbol, jLabelDescription);
        jLabel3 = new javax.swing.JLabel();
        jLabelExamples = new javax.swing.JLabel();
        jPanelSegments = new JPanelSegments(super.getElement());

        setBorder(javax.swing.BorderFactory.createTitledBorder("<html>\nRozhodování - vícecestné (switch)\n</html>"));
        setPreferredSize(new java.awt.Dimension(187, 493));

        jLabel1.setText("Vstupní proměnná:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabel3.setText("Příklady:");

        jLabelExamples.setText("<html>\n- A<br />\n1<br />\n2,3,4<br />\n<br />\n- B<br />\n\"text1\"<br />\n\"text2\",\"text3\"\n</html>");
        jLabelExamples.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jPanelSegments.setPreferredSize(new java.awt.Dimension(20, 20));

        javax.swing.GroupLayout jPanelSegmentsLayout = new javax.swing.GroupLayout(jPanelSegments);
        jPanelSegments.setLayout(jPanelSegmentsLayout);
        jPanelSegmentsLayout.setHorizontalGroup(
            jPanelSegmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelSegmentsLayout.setVerticalGroup(
            jPanelSegmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelExamples, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextFieldConditionVar)
            .addComponent(jPanelSegments, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldConditionVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSegments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelExamples, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelExamples;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelSegments;
    private javax.swing.JTextField jTextFieldConditionVar;
    // End of variables declaration//GEN-END:variables

    /**
     * Metoda s prázdným tělem.
     */
    @Override
    public void changedUpdate(DocumentEvent de)
    {
    }

    /**
     * Automaticky vygeneruje hodnoty na základě vyplněné funkce symbolu a
     * spraví o této události FlowchartEditManager.
     *
     * @param de nová událost úpravy funkce
     */
    @Override
    public void insertUpdate(DocumentEvent de)
    {
        super.getFlowchartEditManager().prepareUndoManager();
        generateValues();
        super.fireChangeEventToEditManager();
    }

    /**
     * Automaticky vygeneruje hodnoty na základě vyplněné funkce symbolu a
     * spraví o této události FlowchartEditManager.
     *
     * @param de nová událost úpravy funkce
     */
    @Override
    public void removeUpdate(DocumentEvent de)
    {
        super.getFlowchartEditManager().prepareUndoManager();
        generateValues();
        super.fireChangeEventToEditManager();
    }

    private class JPanelSegments extends javax.swing.JPanel
    {

        private int minWidth = 0;
        private int minHeight = 0;
        private int componentPadding = 5;

        public JPanelSegments(LayoutElement element)
        {
            super.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            jTextFieldSegments = new JTextField[element.getInnerSegmentsCount() - 1];

            for (int i = 0; i < jTextFieldSegments.length; i++) {
                JLabel jLabel = new JLabel("Konstanta pro " + (i + 1) + ". větev");
                jLabel.setSize(jLabel.getPreferredSize());
                jLabel.setAlignmentX(0);
                if (jLabel.getSize().width > minWidth) {
                    minWidth = jLabel.getSize().width;
                }
                //jLabel.setBounds(0, minHeight, jLabel.getSize().width, jLabel.getSize().height);
                super.add(jLabel);
                super.add(Box.createRigidArea(new Dimension(0, componentPadding)));
                minHeight += jLabel.getSize().height + componentPadding;

                jTextFieldSegments[i] = new JTextField();
                jTextFieldSegments[i].setSize(jTextFieldSegments[i].getPreferredSize());
                jTextFieldSegments[i].setAlignmentX(0);
                if (SettingsHolder.settings.isFunctionFilters()) {
                    ((AbstractDocument) jTextFieldSegments[i].getDocument()).setDocumentFilter(
                            new ConstantFilter());
                }
                //jTextFieldSegments[i].setBounds(0, minHeight, minWidth, jTextFieldSegments[i].getSize().height);
                super.add(jTextFieldSegments[i]);
                minHeight += jTextFieldSegments[i].getSize().height;
                if (i + 1 < jTextFieldSegments.length) { //jeste se bude opakovat
                    super.add(Box.createRigidArea(new Dimension(0, componentPadding)));
                    minHeight += componentPadding;
                }
            }

            Dimension dim = new Dimension(minWidth, minHeight);
            super.setMinimumSize(dim);
        }

        @Override
        public void setMinimumSize(Dimension dmnsn)
        { // je treba zajistit, aby komponent nebyl mensi nez minimalni hodnoty
            super.setMinimumSize(new Dimension(minWidth, minHeight));
        }

        @Override
        public void setPreferredSize(Dimension dmnsn)
        { // je treba zajistit, aby se vzdy inicializoval symbol a preferedsize nebyl mensi nez minimalni hodnoty
            if (dmnsn.width < minWidth) {
                dmnsn.width = minWidth;
            }
            if (dmnsn.height < minHeight) {
                dmnsn.height = minHeight;
            }
            /*
             * for (JTextField jTextField: jTextFieldSegments) {
             * jTextField.setPreferredSize(new Dimension(dmnsn.width,
             * jTextField.getSize().height));
             * }
             */
            super.setPreferredSize(dmnsn);
        }

        @Override
        public void setLayout(LayoutManager lm)
        {
        }

    }

}
