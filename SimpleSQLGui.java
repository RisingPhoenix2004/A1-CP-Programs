// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.*;
// import java.sql.*;
// import java.util.Vector;

// public class SimpleSQLGui extends JFrame {
//     private JTextField connectionField, usernameField;
//     private JPasswordField passwordField;
//     private JButton connectButton, getTablesButton, describeButton, getDataButton;
//     private JComboBox<String> databasesBox, tablesBox;
//     private JTextArea describeArea;
//     private JTable dataTable;
//     private Connection conn;

//     public SimpleSQLGui() {
//         setTitle("Simple SQL GUI");
//         setSize(900, 700);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setLayout(new FlowLayout());

//         connectionField = new JTextField(40);
//         usernameField = new JTextField(15);
//         passwordField = new JPasswordField(15);
//         connectButton = new JButton("Connect");
//         databasesBox = new JComboBox<>();
//         getTablesButton = new JButton("Get Tables");
//         tablesBox = new JComboBox<>();
//         describeButton = new JButton("Describe");
//         describeArea = new JTextArea(10, 60);
//         describeArea.setEditable(false);
//         getDataButton = new JButton("Get Data");
//         dataTable = new JTable();

//         add(new JLabel("Connection String:"));
//         add(connectionField);
//         add(new JLabel("Username:"));
//         add(usernameField);
//         add(new JLabel("Password:"));
//         add(passwordField);
//         add(connectButton);

//         add(new JLabel("Databases:"));
//         add(databasesBox);
//         add(getTablesButton);

//         add(new JLabel("Tables:"));
//         add(tablesBox);
//         add(describeButton);

//         add(new JScrollPane(describeArea));
//         add(getDataButton);
//         add(new JScrollPane(dataTable));

//         connectButton.addActionListener(e -> connectToDatabase());
//         getTablesButton.addActionListener(e -> loadTables());
//         describeButton.addActionListener(e -> describeTable());
//         getDataButton.addActionListener(e -> loadTableData());
//     }

//     private void connectToDatabase() {
//         try {
//             String url = connectionField.getText();
//             String user = usernameField.getText();
//             String password = new String(passwordField.getPassword());
//             conn = DriverManager.getConnection(url, user, password);
//             DatabaseMetaData meta = conn.getMetaData();
//             ResultSet rs = meta.getCatalogs();
//             databasesBox.removeAllItems();
//             while (rs.next()) {
//                 databasesBox.addItem(rs.getString(1));
//             }
//             JOptionPane.showMessageDialog(this, "Connected successfully.");
//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(this, "Connection failed: " + ex.getMessage());
//         }
//     }

//     private void loadTables() {
//         try {
//             String db = (String) databasesBox.getSelectedItem();
//             tablesBox.removeAllItems();
//             DatabaseMetaData meta = conn.getMetaData();
//             ResultSet rs = meta.getTables(db, null, "%", new String[] { "TABLE" });
//             while (rs.next()) {
//                 tablesBox.addItem(rs.getString("TABLE_NAME"));
//             }
//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(this, "Error loading tables: " + ex.getMessage());
//         }
//     }

//     private void describeTable() {
//         try {
//             String db = (String) databasesBox.getSelectedItem();
//             String table = (String) tablesBox.getSelectedItem();
//             DatabaseMetaData meta = conn.getMetaData();
//             ResultSet rs = meta.getColumns(db, null, table, "%");
//             describeArea.setText("");
//             while (rs.next()) {
//                 describeArea.append(rs.getString("COLUMN_NAME") + "\t" + rs.getString("TYPE_NAME") + "\n");
//             }
//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(this, "Error describing table: " + ex.getMessage());
//         }
//     }

//     private void loadTableData() {
//         try {
//             String table = (String) tablesBox.getSelectedItem();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery("SELECT * FROM " + table + " LIMIT 100");
//             ResultSetMetaData rsmd = rs.getMetaData();
//             Vector<String> columns = new Vector<>();
//             int colCount = rsmd.getColumnCount();
//             for (int i = 1; i <= colCount; i++) {
//                 columns.add(rsmd.getColumnName(i));
//             }
//             Vector<Vector<Object>> data = new Vector<>();
//             while (rs.next()) {
//                 Vector<Object> row = new Vector<>();
//                 for (int i = 1; i <= colCount; i++) {
//                     row.add(rs.getObject(i));
//                 }
//                 data.add(row);
//             }
//             dataTable.setModel(new DefaultTableModel(data, columns));
//         } catch (Exception ex) {
//             JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage());
//         }
//     }

//     public static void main(String[] args) {
//         try {
//             // Register JDBC drivers for supported DBs
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             Class.forName("org.postgresql.Driver");
//             // Add other drivers as needed
//             // MongoDB and Firestore need separate SDKs and APIs
//         } catch (Exception e) {
//             System.out.println("Warning: Driver registration issue " + e.getMessage());
//         }
//         SwingUtilities.invokeLater(() -> new SimpleSQLGui().setVisible(true));
//     }
// }
