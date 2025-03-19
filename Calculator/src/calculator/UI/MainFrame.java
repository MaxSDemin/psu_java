package calculator.UI;

import calculator.Core.Data.DataManager;
import calculator.Core.Exception.IntegralValueException;
import calculator.Core.Integral.RecIntegral;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {
    // Shadow column
    private static final int SHADOW_COLUMN_NUMBER = 4; 
    private static final String SHADOW_COLUMN_TITLE = "ShadowColumn";     
    // Load/Save files
    private static final String TEXT_EXTENSION = ".txt";
    private static final String BINARY_EXTENSION = ".calcbin";
    private static final String TEXT_FILTER_DESCRIPTION = "Text Files (*" + TEXT_EXTENSION + ")";
    private static final String BINARY_FILTER_DESCRIPTION = "Calc Binary Files (*" + BINARY_EXTENSION + ")";
    private static final String SAVE_ERROR_MESSAGE = "Save error: ";
    private static final String LOAD_ERROR_MESSAGE = "Load error: ";
    // MessageBox
    private static final String ERROR_TITLE = "Error";
    
    private ArrayList<RecIntegral> _integrals;
        
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
        _integrals = new ArrayList<>();
        
        DataTable.removeColumn(DataTable.getColumn(SHADOW_COLUMN_TITLE));
        FileSaveMenuAsTextItem.addActionListener(e -> saveAsText());
        FileSaveMenuAsBinaryItem.addActionListener(e -> saveAsBinary());
        FileLoadMenuFromTextItem.addActionListener(e -> loadFromText());
        FileLoadMenuFromBinaryItem.addActionListener(e -> loadFromBinary());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        DataTableScrollPanel = new javax.swing.JScrollPane();
        DataTable = new javax.swing.JTable();
        TopBorderLabel = new javax.swing.JLabel();
        BottomBorderLabel = new javax.swing.JLabel();
        StepWidthLabel = new javax.swing.JLabel();
        TopBorderTextField = new javax.swing.JTextField();
        BottomBorderTextField = new javax.swing.JTextField();
        StepWidthTextField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        CalculateButton = new javax.swing.JButton();
        ClearTableButton = new javax.swing.JButton();
        FillTableButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        FileSaveMenu = new javax.swing.JMenu();
        FileSaveMenuAsTextItem = new javax.swing.JMenuItem();
        FileSaveMenuAsBinaryItem = new javax.swing.JMenuItem();
        FileLoadMenu = new javax.swing.JMenu();
        FileLoadMenuFromTextItem = new javax.swing.JMenuItem();
        FileLoadMenuFromBinaryItem = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Верхняя граница", "Нижняя граница", "Ширина шага", "Результат", "ShadowColumn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DataTableScrollPanel.setViewportView(DataTable);

        TopBorderLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TopBorderLabel.setText("Верхняя граница");
        TopBorderLabel.setName(""); // NOI18N

        BottomBorderLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BottomBorderLabel.setText("Ширина шага");

        StepWidthLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        StepWidthLabel.setText("Нижняя границы");

        TopBorderTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        BottomBorderTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        StepWidthTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        AddButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddButton.setText("Добавить");
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtonMouseClicked(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DeleteButton.setText("Удалить");
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseClicked(evt);
            }
        });

        CalculateButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CalculateButton.setText("Вычислить");
        CalculateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalculateButtonMouseClicked(evt);
            }
        });

        ClearTableButton.setText("Очистить");
        ClearTableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableButtonMouseClicked(evt);
            }
        });

        FillTableButton.setText("Восстановить");
        FillTableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FillTableButtonMouseClicked(evt);
            }
        });

        FileMenu.setText("File");

        FileSaveMenu.setText("Save...");

        FileSaveMenuAsTextItem.setText("As txt");
        FileSaveMenu.add(FileSaveMenuAsTextItem);

        FileSaveMenuAsBinaryItem.setText("As binary");
        FileSaveMenu.add(FileSaveMenuAsBinaryItem);

        FileMenu.add(FileSaveMenu);

        FileLoadMenu.setText("Load...");

        FileLoadMenuFromTextItem.setText("From txt");
        FileLoadMenu.add(FileLoadMenuFromTextItem);

        FileLoadMenuFromBinaryItem.setText("From binary");
        FileLoadMenu.add(FileLoadMenuFromBinaryItem);

        FileMenu.add(FileLoadMenu);

        MenuBar.add(FileMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TopBorderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StepWidthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BottomBorderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StepWidthTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                            .addComponent(BottomBorderTextField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(TopBorderTextField)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CalculateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataTableScrollPanel)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ClearTableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FillTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TopBorderLabel)
                    .addComponent(TopBorderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(StepWidthLabel)
                        .addComponent(BottomBorderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BottomBorderLabel)
                    .addComponent(StepWidthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CalculateButton))
                .addGap(18, 18, 18)
                .addComponent(DataTableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearTableButton)
                    .addComponent(FillTableButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseClicked
        // Check if all fields field
        String topBorderFieldText =  TopBorderTextField.getText();
        String bottomBordeFieldText =  BottomBorderTextField.getText();
        String stepWidthFieldText =  StepWidthTextField.getText();
        if (stringIsNullOrEmpty(topBorderFieldText) || 
            stringIsNullOrEmpty(bottomBordeFieldText) ||
            stringIsNullOrEmpty(stepWidthFieldText)) {
            return;
        }
        // Try to convert
        double topBorder;
        double bottomBorder;
        double stepWidth;
        try {
            topBorder = Double.parseDouble(topBorderFieldText);
            bottomBorder = Double.parseDouble(bottomBordeFieldText);
            stepWidth = Double.parseDouble(stepWidthFieldText);
        } catch (NumberFormatException e) {
            return;
        }
        // Step must be greater then zero
        if (stepWidth <= 0) {
            return;
        }
        // Add data to table
        RecIntegral integral;
        try {
            integral = new RecIntegral(topBorder, bottomBorder, stepWidth);
        } catch(IntegralValueException ex){
            JOptionPane.showMessageDialog(
                    this, 
                    ex.getMessage(),
                    ex.getExceptionName(), 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        _integrals.add(integral);
        AddIntegralToTable(DataTable, integral);
    }//GEN-LAST:event_AddButtonMouseClicked

    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        // Check if row selected
        int selectedRow = DataTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        // Remove row
        DefaultTableModel model = (DefaultTableModel)DataTable.getModel();
        _integrals.remove(
                (RecIntegral)model.getValueAt(selectedRow, SHADOW_COLUMN_NUMBER));
        model.removeRow(selectedRow);
    }//GEN-LAST:event_DeleteButtonMouseClicked

    private void CalculateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalculateButtonMouseClicked
        int selectedRow = DataTable.getSelectedRow();
        if (selectedRow < 0) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) DataTable.getModel(); 
        RecIntegral integral = (RecIntegral)model.getValueAt(selectedRow, SHADOW_COLUMN_NUMBER);

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                integral.calculateIntegralMultiThread();
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    model.setValueAt(integral.getResult(), selectedRow, 3);
                } catch (InterruptedException | ExecutionException ex) {
                    JOptionPane.showMessageDialog(
                        MainFrame.this, 
                        ex.getMessage(),
                        ERROR_TITLE, 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute();
    }//GEN-LAST:event_CalculateButtonMouseClicked

    private void ClearTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClearTableButtonMouseClicked
        ((DefaultTableModel) DataTable.getModel()).setRowCount(0); 
    }//GEN-LAST:event_ClearTableButtonMouseClicked

    private void FillTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FillTableButtonMouseClicked
        DefaultTableModel model = (DefaultTableModel) DataTable.getModel(); 
        model.setRowCount(0);
        for (RecIntegral integral : _integrals) {
            AddIntegralToTable(DataTable, integral);
        }
    }//GEN-LAST:event_FillTableButtonMouseClicked
    
    private void saveAsText() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter textFilter = 
                new FileNameExtensionFilter(
                        "Text Files (*" + TEXT_EXTENSION + ")", 
                        TEXT_EXTENSION.replace(".", ""));
        chooser.setFileFilter(textFilter);
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            // Append the .txt extension if it is missing.
            if (!file.getName().toLowerCase().endsWith(TEXT_EXTENSION)) {
                file = new File(file.getAbsolutePath() + TEXT_EXTENSION);
            }
            try {
                DataManager.saveDataAsText(file, _integrals);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, SAVE_ERROR_MESSAGE + e.getMessage());
            }
        }
    }
    
    private void saveAsBinary() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter binFilter = new FileNameExtensionFilter(
                BINARY_FILTER_DESCRIPTION, 
                BINARY_EXTENSION.replace(".", ""));
        chooser.setFileFilter(binFilter);
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            // Append the .calcbin extension if it is missing.
            if (!file.getName().toLowerCase().endsWith(BINARY_EXTENSION)) {
                file = new File(file.getAbsolutePath() + BINARY_EXTENSION);
            }
            try {
                DataManager.saveDataAsBinary(file, _integrals);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, SAVE_ERROR_MESSAGE + e.getMessage());
            }
        }
    }
    
    private void loadFromText() {
         JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter textFilter = new FileNameExtensionFilter(
                TEXT_FILTER_DESCRIPTION, 
                TEXT_EXTENSION.replace(".", ""));
        chooser.setFileFilter(textFilter);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            // Validate the file extension.
            if (!file.getName().toLowerCase().endsWith(TEXT_EXTENSION)) {
                JOptionPane.showMessageDialog(this, 
                        "Please select a file with " + TEXT_EXTENSION + " extension");
                return;
            }
            try {
                _integrals = DataManager.loadDataFromText(file);
                for (RecIntegral integral : _integrals) {
                    AddIntegralToTable(DataTable, integral);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, LOAD_ERROR_MESSAGE + e.getMessage());
            }
        }
    }
    
    private void loadFromBinary() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter binFilter = new FileNameExtensionFilter(
                BINARY_FILTER_DESCRIPTION, 
                BINARY_EXTENSION.replace(".", ""));
        chooser.setFileFilter(binFilter);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            // Validate the file extension.
            if (!file.getName().toLowerCase().endsWith(BINARY_EXTENSION)) {
                JOptionPane.showMessageDialog(this, 
                        "Please select a file with " + BINARY_EXTENSION + " extension");
                return;
            }
            try {
                _integrals = DataManager.loadDataFromBinary(file);
                for (RecIntegral integral : _integrals) {
                    AddIntegralToTable(DataTable, integral);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, LOAD_ERROR_MESSAGE + e.getMessage());
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
           }
        }
    }
    
    private void AddIntegralToTable(JTable table, RecIntegral integral) {
        double result = integral.getResult();
        ((DefaultTableModel)table.getModel()).addRow(
                new Object[]{
                    integral.getTopBorder(), 
                    integral.getBottomBorder(), 
                    integral.getStepWidth(),
                    result == Double.NaN ? "" : result, 
                    integral});
    }
    
    private boolean stringIsNullOrEmpty(String str) {
         return str == null || str.trim().isEmpty();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel BottomBorderLabel;
    private javax.swing.JTextField BottomBorderTextField;
    private javax.swing.JButton CalculateButton;
    private javax.swing.JButton ClearTableButton;
    private javax.swing.JTable DataTable;
    private javax.swing.JScrollPane DataTableScrollPanel;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JMenu FileLoadMenu;
    private javax.swing.JMenuItem FileLoadMenuFromBinaryItem;
    private javax.swing.JMenuItem FileLoadMenuFromTextItem;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu FileSaveMenu;
    private javax.swing.JMenuItem FileSaveMenuAsBinaryItem;
    private javax.swing.JMenuItem FileSaveMenuAsTextItem;
    private javax.swing.JButton FillTableButton;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel StepWidthLabel;
    private javax.swing.JTextField StepWidthTextField;
    private javax.swing.JLabel TopBorderLabel;
    private javax.swing.JTextField TopBorderTextField;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
