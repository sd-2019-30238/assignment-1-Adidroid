package Presentation;

import BusinessLogic.RecommendationFactory;
import BusinessLogic.Service.BookService;
import BusinessLogic.Service.UserService;
import BusinessLogic.Model.Book;
import BusinessLogic.Model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class UserApp extends JFrame {

    // Variables declaration - do not modify
    private javax.swing.JButton addBtn;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton borrowBtn;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton buyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable libraryTabel;
    private javax.swing.JTable myBooksTabel;
    private javax.swing.JTable recommendationsTable;
    private javax.swing.JTextField sumField;

    private DefaultTableModel modelLibrary;
    private DefaultTableModel modelMyBooks;
    private DefaultTableModel modelRecommendations;
    private User user;




    public UserApp(User user) {
        this.user=user;
        initComponents();
        initTables();
        populateTables();
        populateRecommendationTable();
        actionListeners();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        libraryTabel = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        myBooksTabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        sumField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        borrowBtn = new javax.swing.JButton();
        buyBtn = new javax.swing.JButton();
        returnBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        recommendationsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);



        modelLibrary = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;// This causes all cells to be not editable
            }
        };

        modelMyBooks = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;// This causes all cells to be not editable
            }
        };

        modelRecommendations = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;// This causes all cells to be not editable
            }
        };



        libraryTabel.setModel(modelLibrary);

        jScrollPane1.setViewportView(libraryTabel);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Available Books");

        myBooksTabel.setModel(modelMyBooks);

        jScrollPane2.setViewportView(myBooksTabel);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("My Books");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Wallet:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText(Integer.toString(user.getMoney())+" $");
        checkBallance();



        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Sum:");

        addBtn.setText("Add");
        returnBtn.setText("Return");

        logOutBtn.setText("Logout ");

        borrowBtn.setText("Borrow");

        buyBtn.setText("Buy");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Recommended for you");

        recommendationsTable.setModel(modelRecommendations);

        jScrollPane4.setViewportView(recommendationsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(logOutBtn)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(sumField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(addBtn))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLabel4))
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(102, 102, 102)
                                                .addComponent(jLabel6))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(borrowBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(returnBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(buyBtn)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(189, 189, 189))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(187, 187, 187))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(sumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(addBtn))
                                                .addGap(257, 257, 257)
                                                .addComponent(buyBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(borrowBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(returnBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(logOutBtn))))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private <T> void createTable(Object object,DefaultTableModel model) {


        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                if(!field.getName().equals("user") && !field.getName().equals("user_id") )
                   model.addColumn(field.getName());

            } catch (IllegalArgumentException e) {

                e.printStackTrace();
            }
        }

    }

    private void actionListeners(){
        borrowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) libraryTabel.getValueAt(libraryTabel.getSelectedRow(), 0);
                Book book=BookService.get(id);
                book.setUser(user);
                BookService.update(book);

                populateTables();



            }
        });

        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) myBooksTabel.getValueAt(myBooksTabel.getSelectedRow(), 0);
                Book book=BookService.get(id);


                book.setUser(null);
                BookService.update(book);

               checkBallance();


                populateTables();
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int newSum=user.getMoney()+Integer.parseInt(sumField.getText());
                user.setMoney(newSum);
                UserService.update(user);

                jLabel4.setText(Integer.toString(newSum)+" $");
                checkBallance();
            }
        });

        buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = (int) libraryTabel.getValueAt(libraryTabel.getSelectedRow(), 0);
                int price=(int) libraryTabel.getValueAt(libraryTabel.getSelectedRow(), 4);
                Book book=BookService.get(id);
                book.setUser(user);
                BookService.update(book);

                int newSum=user.getMoney()-price;
                user.setMoney(newSum);
                UserService.update(user);

                jLabel4.setText(Integer.toString(newSum)+" $");
                checkBallance();

                populateTables();

            }
        });

        logOutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserApp.this.dispose();
                new Login().setVisible(true);
            }
        });
    }

    private void initTables(){
        createTable(new Book(),modelLibrary);
        createTable(new Book(),modelMyBooks);
        createTable(new Book(),modelRecommendations);
    }

    private void populateTables(){
        populateLibraryTable();
        populateMyBooksTable();

    }

    private void populateLibraryTable() {

        modelLibrary.setRowCount(0);

        for (Book book : BookService.getAll()) {
            if(book.getUser()==null){
                System.out.println(book.getUser());
                List<Object> data = new ArrayList<>();
                data.add(book.getId());
                data.add(book.getTitle());
                data.add(book.getAuthor());
                data.add(book.getGenre());
                data.add(book.getPrice());
                modelLibrary.addRow(data.toArray());
            }

        }

    }

    private void populateMyBooksTable() {

        modelMyBooks.setRowCount(0);

        for (Book book :UserService.getUserBooks(user)) {
            if(book.getUser()!=null){
                List<Object> data = new ArrayList<>();
                data.add(book.getId());
                data.add(book.getTitle());
                data.add(book.getAuthor());
                data.add(book.getGenre());
                data.add(book.getPrice());
                modelMyBooks.addRow(data.toArray());
            }



        }

    }

    private void populateRecommendationTable() {

        modelRecommendations.setRowCount(0);

        for (Book book :new RecommendationFactory().getRecommendation("Genre").getRecommendation()) {
            if(book.getUser()==null){
                List<Object> data = new ArrayList<>();
                data.add(book.getId());
                data.add(book.getTitle());
                data.add(book.getAuthor());
                data.add(book.getGenre());
                data.add(book.getPrice());
                modelRecommendations.addRow(data.toArray());
            }

        }

    }

    private void checkBallance(){
        if(user.getMoney()>=0)
            jLabel4.setForeground(Color.GREEN);
        else
            jLabel4.setForeground(Color.RED);
    }

}
