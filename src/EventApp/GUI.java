package EventApp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI {

    private Event event;
    private JTable eventTable;
    private DefaultTableModel tableModel;

    public void EventApp(Event event) {
        this.event = event;
        initializeUI();
    }

    private void refreshEventTable() {
        try {
            List<Event> events = event.getAllEvents();
            tableModel.setRowCount(0);
            for (Event event : events) {
                tableModel.addRow(new Object[]{event.getId(), event.getTitle(), event.getText(), event.getDate()});
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


        private void initializeUI() {

            JFrame frame = new JFrame("Event App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLayout(new BorderLayout());

            JPanel panel = new JPanel();
            JTextField titleField = new JTextField(10);
            JTextField descriptionField = new JTextField(10);
            JTextField dateField = new JTextField(10);
            JButton addButton = new JButton("Добавить событие");
            JButton deleteButton = new JButton("Удалить событие");
            JButton updateButton = new JButton("Обновить событие");

            panel.add(new JLabel("Title"));
            panel.add(titleField);
            panel.add(new JLabel("Text"));
            panel.add(descriptionField);
            panel.add(new JLabel("Date"));
            panel.add(dateField);
            panel.add(addButton);
            panel.add(deleteButton);
            panel.add(updateButton);

            frame.add(panel, BorderLayout.SOUTH);


            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String title = titleField.getText();
                    String description = descriptionField.getText();
                    String date = dateField.getText();
                    event.addEvent(new Event(0, "title", "text", "11.02.25"));
                    refreshEventTable();
                }
            });

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String title = titleField.getText();

                }
            });
        }
    }

